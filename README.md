# Instructions

```shell
./mvnw -Pprod,native install spring-boot:build-image
```

Results in:

> Successfully built image 'docker.io/bbortt/spring-native-bug-reproducer:latest'

Then start the image, resulting in an error:

```shell
docker run --rm docker.io/bbortt/spring-native-bug-reproducer:latest
```

This way, it works:

```shell
docker run -e MANAGEMENT_SERVER_PORT=8090 --rm docker.io/bbortt/spring-native-bug-reproducer:latest
```
