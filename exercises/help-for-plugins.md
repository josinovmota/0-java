# Maven help command in plugins

### How can help be displayed for the Maven plugin: org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M1?

The answer to that is the command `mvn <plugin>:help`. In this case, using the plugin `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M1`
 we can use:

```shell
mvn org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M1:help
```

It will show some important information about this plugin such as `description`, `parameters` and `goals`