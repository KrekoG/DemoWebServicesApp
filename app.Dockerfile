ARG war_name

FROM maven:3.9 AS builder
COPY . /usr/src/mymaven
WORKDIR /usr/src/mymaven/
RUN ls -lash && mvn clean package

FROM tomcat:11.0-jdk17-temurin AS runner
ARG war_name
COPY --from=builder /usr/src/mymaven/target/$war_name /usr/local/tomcat/webapps/ROOT.war
