FROM microsoft/iis:latest
MAINTAINER Tanja Stanic <tanja_stanic96@live.com>
ADD target/eureka-service-0.0.1-SNAPSHOT.jar eureka-service.jar
ENTRYPOINT ["java", "-jar", "./eureka-service.jar"]
EXPOSE 8761