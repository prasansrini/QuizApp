#FROM eclipse-temurin:17-jdk-jammy
#
#COPY . /quiz-app
#
#WORKDIR /quiz-app
#
##COPY target/OUTPUT.jar /quiz-app/quiz-app.jar
#
#CMD ["java","--version"]
#CMD ["mvn","--version"]
#
##EXPOSE 8888
##
##ENV JAVA_OPTS=""
##
##ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /quiz-app/quiz-app.jar"]


FROM eclipse-temurin:17-jdk-alpine

RUN apk add --no-cache bash procps curl tar

# common for all images
LABEL org.opencontainers.image.title="Apache Maven"
LABEL org.opencontainers.image.source=https://github.com/carlossg/docker-maven
LABEL org.opencontainers.image.url=https://github.com/carlossg/docker-maven
LABEL org.opencontainers.image.description="Apache Maven is a software project management and comprehension tool. "

ENV MAVEN_HOME=/usr/share/maven

COPY --from=maven:3.9.8-eclipse-temurin-11 ${MAVEN_HOME} ${MAVEN_HOME}
COPY --from=maven:3.9.8-eclipse-temurin-11 /usr/local/bin/mvn-entrypoint.sh /usr/local/bin/mvn-entrypoint.sh
COPY --from=maven:3.9.8-eclipse-temurin-11 /usr/share/maven/ref/settings-docker.xml /usr/share/maven/ref/settings-docker.xml

RUN ln -s ${MAVEN_HOME}/bin/mvn /usr/bin/mvn

ARG MAVEN_VERSION=3.9.8
ARG USER_HOME_DIR="/root"
ENV MAVEN_CONFIG="$USER_HOME_DIR/.m2"

ENTRYPOINT ["/usr/local/bin/mvn-entrypoint.sh"]

COPY . /quiz-app

WORKDIR /quiz-app

EXPOSE 8888

CMD ["sh","-c", "mvn -version;cd /quiz-app;mvn clean package;java -jar /quiz-app/target/OUTPUT.jar;"]