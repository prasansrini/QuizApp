FROM eclipse-temurin:17-jdk-alpine

WORKDIR /quiz-app

COPY target/OUTPUT.jar /quiz-app/OUTPUT.jar

EXPOSE 8888

CMD ["sh","-c", "java -jar /quiz-app/OUTPUT.jar;"]