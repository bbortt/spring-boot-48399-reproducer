# Instructions

> **Profile-specific property loading not working in native images**
> 
> See [bug report @ spring-projects/spring-boot](https://github.com/spring-projects/spring-boot/issues/48399).

Build a native compiled image, activating `prod` profile:

```shell
./mvnw -Pprod,native install spring-boot:build-image
```

Results in:

> Successfully built image 'docker.io/library/spring-native-bug-reproducer:0.0.1-SNAPSHOT'

Then start the image, resulting in an error:

```shell
docker run --rm docker.io/library/spring-native-bug-reproducer:0.0.1-SNAPSHOT
```

As @mhalbritter mentioned, ...

> you have to specify the same profile when you run the native image [...]

```shell
docker run -e SPRING_PROFILE_ACTIVE --rm docker.io/library/spring-native-bug-reproducer:0.0.1-SNAPSHOT
```

[This is really confusing](https://github.com/spring-projects/spring-boot/issues/48399#issuecomment-3617142936)!
