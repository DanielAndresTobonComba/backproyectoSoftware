# ---------- ETAPA 1: build ----------
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copiamos pom y descargamos dependencias primero (mejor cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código
COPY src ./src

# Compilamos el jar
RUN mvn clean package -DskipTests

# ---------- ETAPA 2: runtime ----------
FROM eclipse-temurin:17-jre


WORKDIR /app

# Copiamos el jar generado
COPY --from=build /app/target/backproyecto-0.0.1-SNAPSHOT.jar app.jar

# Puerto típico de Spring Boot
EXPOSE 8080

# Ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
