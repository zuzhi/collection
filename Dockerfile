# syntax = docker/dockerfile:1.2
FROM clojure:openjdk-17 AS build

WORKDIR /
COPY . /

RUN clj -Sforce -T:build all

FROM azul/zulu-openjdk-alpine:17

COPY --from=build /target/collection-standalone.jar /collection/collection-standalone.jar

EXPOSE $PORT

ENTRYPOINT exec java $JAVA_OPTS -jar /collection/collection-standalone.jar
