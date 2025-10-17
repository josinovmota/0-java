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

First of all, ensure that you're currently using the [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html), [Git](https://git-scm.com/downloads), and [Apache Maven](https://maven.apache.org/) installed. You can check JDK, Git and Apache Maven version by using the following commands:


```
java -version
git --version
mvn -- version
```

Now we can start building the project. The first thing in order to do that is cloning the repository:

```
git clone https://github.com/josinovmota/0-java
cd 0-java
```

After that you can use the `mvn clean install` command:

```
mvn clean install
```

## Testing

First of all be sure that you already downloaded the project (you can use the first part of the [Building the project](#building-the-project) in order to do that) so we can start doing the **unit tests**

Now, with everything settled we can properly do the unit tests using the following command in the `terminal`:

```
mvn test
```

If there's any doubt about Apache Maven lifecycle, you can use the [explanation](../exercises/maven-lifecycle.md) about its phases.

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