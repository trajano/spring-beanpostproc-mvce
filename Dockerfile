FROM maven:3.6-jdk-11 as build
WORKDIR /p
COPY pom.xml .
RUN mvn -q -B dependency:resolve-plugins dependency:go-offline
COPY . .
RUN mvn -B package
RUN jar tvf  /p/target/demo-0.0.1-SNAPSHOT.war
FROM tomcat:9
COPY --from=build /p/target/demo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
