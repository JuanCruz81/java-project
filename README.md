# Java HTTP Client

Proyecto Java simple que se conecta a un backend HTTP en `http://localhost:8080/api/tasks`

## 📋 Descripción

Este proyecto es un cliente HTTP en Java que:
- Se conecta a una API REST en localhost:8080
- Obtiene una lista de tareas
- Procesa y muestra la respuesta JSON

## 🚀 Requisitos

- Java 11 o superior
- Maven 3.6 o superior

## 🔧 Instalación y Ejecución

1. **Compilar el proyecto:**
```bash
cd /Users/juancruz/java-http-client
mvn clean compile
```

2. **Ejecutar el cliente:**
```bash
mvn exec:java -Dexec.mainClass="com.example.TaskClient"
```

O directamente:
```bash
mvn clean package
java -jar target/java-http-client-1.0-SNAPSHOT.jar
```

## 📦 Dependencias

- **Apache HttpClient 5.2.1** - Para hacer solicitudes HTTP
- **Gson 2.10.1** - Para procesar JSON
- **SLF4J** - Para logging

## 🎯 Estructura del Proyecto

```
java-http-client/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/example/
                └── TaskClient.java
```

## 📡 API Esperada

El proyecto espera que el backend retorne un JSON con un array de tareas en la URL:
```
GET http://localhost:8080/api/tasks
```

Ejemplo de respuesta:
```json
[
  {
    "id": 1,
    "title": "Tarea 1",
    "completed": false
  },
  {
    "id": 2,
    "title": "Tarea 2",
    "completed": true
  }
]
```
