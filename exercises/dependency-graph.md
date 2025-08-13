# How can Maven produce a dependency graph?

Imagine that you have a lot of dependencies in your `Maven Project` but you got an error of a dependency
that you cant find in your `pom.xml`. Some dependencies of the `pom.xml` will automatically download other dependencies
in order to do their work.

So, how do I get the information about this transitive dependencies by CLI? You can use the following command:

```shell
mvn dependency:tree
```

It will show you every dependency in your project including the transitive ones