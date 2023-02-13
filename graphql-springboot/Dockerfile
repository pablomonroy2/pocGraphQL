FROM gradle:jdk11-alpine
WORKDIR /app
COPY . .
RUN gradle bootJar


FROM adoptopenjdk/openjdk11-openj9:alpine-slim
WORKDIR /app
COPY --from=0 /app/build/libs/graphql-springboot.jar /app/graphql-springboot.jar

ENV JAVA_OPTS="-XX:+UseContainerSupport"
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar graphql-springboot.jar"]