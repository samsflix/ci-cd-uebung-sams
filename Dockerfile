# ===== STAGE 1: Build =====
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# zuerst nur pom.xml kopieren, damit Maven-Caches greifen
COPY pom.xml .
RUN mvn -B -q -DskipTests dependency:go-offline

# jetzt den Source-Code
COPY src ./src

# Baue das Projekt (Tests dürfen laufen, sonst -DskipTests=true setzen)
RUN mvn -B -DskipTests=false package

# ===== STAGE 2: Runtime =====
FROM eclipse-temurin:17-jre
WORKDIR /app

# JAR aus dem Build-Stage herüberziehen
# falls dein Jar anders heißt, hier anpassen
COPY --from=build /app/target/*.jar /app/app.jar

# optional: non-root user
RUN useradd -r -u 1001 appuser
USER appuser

# App starten
ENTRYPOINT ["java","-cp","/app/app.jar","com.example.cicd.App"]

# falls du einen HTTP-Server drin hast:
# EXPOSE 8080
