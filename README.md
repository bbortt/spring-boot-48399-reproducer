# Instructions

> **Profile-specific property loading not working in native images**
> 
> See [bug report @ spring-projects/spring-boot](https://github.com/spring-projects/spring-boot/issues/48399).

Build a native compiled image:

```shell
./mvnw install spring-boot:build-image
```

* AOT Processing done with `prod` profile
* Native compilation done with `default` profile

Results in:

> Successfully built image 'docker.io/library/spring-native-bug-reproducer:0.0.1-SNAPSHOT'

Image starts fine, but with `default` profile enabled:

> 2025-12-07T10:11:27.785Z  INFO 1 --- [           main] b.s.SpringNativeBugReproducerApplication : No active profile set, falling back to 1 default profile: "default"

As @mhalbritter mentioned, ...

> you have to specify the same profile when you run the native image [...]

and with that everything load into `prod` profile as expected.

```shell
docker run -e SPRING_PROFILE_ACTIVE --rm docker.io/library/spring-native-bug-reproducer:0.0.1-SNAPSHOT
```

[That is somewhat confusing](https://github.com/spring-projects/spring-boot/issues/48399#issuecomment-3617142936)!

But looks like a feature request for the `native-maven-plugin` - there is no way to specify environment variables from what I can see in the documentation.
