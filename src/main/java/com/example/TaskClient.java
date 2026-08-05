package com.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class TaskClient {
    private static final String API_URL = "http://localhost:8080/api/tasks";
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        System.out.println("🚀 Java HTTP Client - Conectando a: " + API_URL);
        
        try {
            fetchTasks();
        } catch (Exception e) {
            System.err.println("❌ Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void fetchTasks() throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(API_URL);
            httpGet.setHeader("Accept", "application/json");

            System.out.println("📤 Enviando solicitud GET a: " + API_URL);

            var response = httpClient.execute(httpGet, resp -> {
                int statusCode = resp.getCode();
                System.out.println("✅ Status Code: " + statusCode);

                if (statusCode == 200) {
                    HttpEntity entity = resp.getEntity();
                    if (entity != null) {
                        String content = EntityUtils.toString(entity);
                        System.out.println("\n📝 Respuesta recibida:");
                        System.out.println("─".repeat(50));
                        
                        try {
                            JsonArray tasks = gson.fromJson(content, JsonArray.class);
                            if (tasks != null && tasks.size() > 0) {
                                System.out.println("📋 Total de tareas: " + tasks.size() + "\n");
                                for (int i = 0; i < tasks.size(); i++) {
                                    JsonObject task = tasks.get(i).getAsJsonObject();
                                    System.out.println("Tarea #" + (i + 1) + ": " + gson.toJson(task));
                                }
                            } else {
                                System.out.println("No hay tareas disponibles");
                            }
                        } catch (Exception e) {
                            System.out.println("Respuesta (formato texto):\n" + content);
                        }
                    }
                } else {
                    System.out.println("⚠️  El servidor retornó un estado diferente a 200");
                }

                return null;
            });
        }
    }
}
