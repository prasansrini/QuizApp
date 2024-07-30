FROM openjdk:17-slim

WORKDIR /quiz-app

COPY target/OUTPUT.jar /quiz-app/OUTPUT.jar

COPY src/main/resources/input_questions.json /quiz-app/input_questions.json

EXPOSE 8888

CMD ["sh","-c", "java -jar /quiz-app/OUTPUT.jar;"]