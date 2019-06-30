FROM microsoft/iis:latest
MAINTAINER Tanja Stanic <tanja_stanic96@live.com>
ADD target/zuul-server-0.0.1-SNAPSHOT.jar zuul-server.jar
ENTRYPOINT ["java", "-jar", "./zuul-server.jar"]
EXPOSE 8081