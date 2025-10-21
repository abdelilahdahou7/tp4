# Utilise une image de base OpenJDK 17
FROM openjdk:17-jdk-slim

# Argument pour spécifier le chemin du fichier JAR
ARG JAR_FILE=target/*.jar

# Copie le fichier JAR de l'application dans le conteneur
COPY ${JAR_FILE} app.jar

# Expose le port sur lequel l'application va tourner (par défaut 8080 pour Spring Boot)
EXPOSE 8080

# Commande pour lancer l'application au démarrage du conteneur
ENTRYPOINT ["java","-jar","/app.jar"]
