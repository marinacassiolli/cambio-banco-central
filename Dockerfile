FROM java:8
EXPOSE 8081
ADD /target/cambio-banco-central-1.jar cambio-banco-central-1.jar
ENTRYPOINT ["java", "-jar", "cambio-banco-central-1.jar"]