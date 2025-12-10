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

# INTENTIONAL: Copy vulnerable dependencies for Exercise 04 demonstration
# This ensures Trivy and Grype can detect the CVEs in log4j and jackson
COPY --from=build /root/.m2/repository/org/apache/logging/log4j /app/libs/log4j
COPY --from=build /root/.m2/repository/com/fasterxml/jackson /app/libs/jackson

# optional: non-root user
RUN useradd -r -u 1001 appuser
USER appuser

# App starten
ENTRYPOINT ["java","-cp","/app/app.jar","com.example.cicd.App"]

# falls du einen HTTP-Server drin hast:
# EXPOSE 8080
