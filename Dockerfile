# ---------- STAGE 1: Build JAR usando Maven ----------
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /workspace

# Copiar solo pom.xml primero para aprovechar cache de dependencias
COPY pom.xml .
RUN mvn -B -DskipTests dependency:go-offline

# Copiar código fuente y construir
COPY src ./src
RUN mvn -B -DskipTests package

# ---------- STAGE 2: Crear imagen runtime ----------
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Opcional: crear usuario no-root para seguridad
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup
USER appuser

# Copiar JAR desde stage de build
COPY --from=build /workspace/target/*.jar app.jar

# Variables de entorno para configuración de Java
ENV JAVA_OPTS="-Xms128m -Xmx512m"

# Exponer puerto 8080
EXPOSE 8080

# Healthcheck simple (verifica que la app responda)
HEALTHCHECK --interval=30s --timeout=5s --start-period=15s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8080/ || exit 1

# Punto de entrada
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
