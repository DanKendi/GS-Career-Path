# Dockerfile
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Dá permissão pro gradlew
RUN chmod +x ./gradlew

# Build da aplicação
RUN ./gradlew clean build -x test

# Expõe a porta
EXPOSE 8080

# Comando de execução
ENTRYPOINT ["java", "-jar", "build/libs/CareerPath-0.0.1-SNAPSHOT.jar"]