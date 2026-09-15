# Etapa 1: Compilación
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .
# Damos permisos de ejecución a Maven Wrapper
RUN chmod +x ./mvnw
# Compilamos el proyecto omitiendo los tests para acelerar el proceso
RUN ./mvnw clean package -DskipTests

# Etapa 2: Ejecución
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copiamos el .jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]