FROM openjdk:21-jdk

COPY target/DIgitalLedgerApp-0.0.1-SNAPSHOT.jar .

EXPOSE 2005

ENTRYPOINT ["java", "-jar","DIgitalLedgerApp-0.0.1-SNAPSHOT.jar"]

