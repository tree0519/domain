FROM java:8
VOLUME /tmp
ENV TZ=Asia/Shanghai
ADD app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar

