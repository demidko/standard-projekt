# syntax = docker/dockerfile:experimental
FROM gradle:jdk15 as builder
WORKDIR /app
COPY src ./src
COPY build.gradle.kts ./build.gradle.kts
RUN --mount=type=cache,target=./.gradle gradle clean test shadowJar

FROM openjdk:15 as backend
WORKDIR /root
COPY --from=builder /app/*.jar ./app
