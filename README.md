# 0-java

![0-java-header](assets/SD.png)

Welcome to **0-java**, a repository containing exercises of the Nemesis Collective Java Training.

## Overview

Here you'll find a command-line Java application that takes a username as an argument, stores it in an in-memory H2 database, and prints the username along with its auto-generated ID.

## Training exercises of maven

### What is the minimum number of commands needed to clean, compile, test, deploy, and report on a project? (Note the lifecycle and dependencies).

[Explanation](./exercises/maven-lifecycle.md)

### How can help be displayed for the Maven plugin: org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M1?

[Explanation](./exercises/help-for-plugins.md)

### How can all of a project's plugins be displayed?

[Explanation](./exercises/show-plugins.md)

### How can Maven dependencies be cleared from the local cache?

[Explanation](./exercises/dependencies-clean-cache.md)

### How can Maven dependency updates in the project be listed?

[Explanation](./exercises/display-dependencies-updates.md)

### How can Maven produce a dependency graph?

[Explanation](./exercises/dependency-graph.md)

## Building the project

In order to build the project, you can use the [how to build the project](./docs/building.md) guide.

## Testing

To run the tests, refer to the [running tests](./docs/testing.md) guide.

## Executing the project

To execute the project you can simply use the following command:

Windows (PowerShell)
```
mvn "exec:java" "-Dexec.args=<args separated with spaces>"
```

Linux (Bash)
```
mvn exec:java -Dexec.args="<args separated with spaces>"
```

## Sorting the POM

To sort the `pom.xml` file you should use the following command:

```
mvn sortpom:sort
```

## Formatting code

To format the code you can use the following command:

```
mvn fmt:format
```