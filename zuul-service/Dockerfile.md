FROM microsoft/iis:latest
MAINTAINER Tanja Stanic <tanja_stanic96@live.com>
ADD target/zuul-servis-0.0.1-SNAPSHOT.jar zuul-servis.jar
ENTRYPOINT ["java", "-jar", "./zuul-servis.jar"]
EXPOSE 8081