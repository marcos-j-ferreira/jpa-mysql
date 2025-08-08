FROM openjdk:17-jdk-slim

WORKDIR /app

# Primeiro copia apenas o arquivo de dependências (para aproveitar cache do Docker)
COPY build/libs/*.jar app.jar

# Adiciona um usuário não-root para segurança
RUN adduser --system --group appuser && \
    chown appuser:appuser /app
USER appuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]