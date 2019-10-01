FROM ubuntu:19.04
RUN apt-get update
RUN apt-get -y install openjdk-12-jdk
RUN apt-get -y install iputils-ping net-tools
ENV JAVA_HOME /usr/lib/jvm/java-12-openjdk-amd64
VOLUME /tmp
RUN mkdir /app
WORKDIR /app
#COPY ${JAR_TARGET} .
ENTRYPOINT ["sh","-c","tail -f /etc/hosts"]
#ENTRYPOINT ["sh","-c","java -jar -Dspring.profiles.active=docker /app/${JAR_TARGET}"]