FROM openjdk:11
ADD ./backend/build/libs/*.jar henaknowledgeapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "henaknowledgeapp.jar"]
