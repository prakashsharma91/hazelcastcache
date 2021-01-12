FROM java:8

EXPOSE 8080

ADD target/hazelcastcache.jar  hazelcastcache.jar

ENTRYPOINT [ "java", "-jar", "hazelcastcache.jar" ]