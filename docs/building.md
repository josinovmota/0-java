# How to build the project

First of all, ensure that you're currently using the [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html), [Git](https://git-scm.com/downloads), and [Apache Maven](https://maven.apache.org/) installed. You can check JDK version and Git version by using the following commands:


```
java -version
git --version
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