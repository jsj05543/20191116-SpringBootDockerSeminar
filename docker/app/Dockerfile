FROM ubuntu:19.04
RUN apt-get update
RUN apt-get -y install openjdk-12-jdk
ENV JAVA_HOME /usr/lib/jvm/java-12-openjdk-amd64
VOLUME /tmp
RUN mkdir /app
WORKDIR /app
COPY ${JAR_TARGET} .
ENTRYPOINT ["sh","-c","java -jar -Dspring.profiles.active=docker ${JAR_TARGET}"]