# Maven commands lifecycle

Whenever we use `Maven` as our **project manager** we need to use commands like `mvn install`, `mvn compile` and so on

As we learnt, Maven commands have some sort of hierarchy. To be more specific, whenever we type a command like `mvn compile`
other commands that are lower in the hierarchy will be executed too. Let me explain a little better

## Maven Default LifeCycle

| Order | Command  | Use                                                                        |
|-------|----------|----------------------------------------------------------------------------|
| 1     | validate | Ensures that the project structure is available (`pom.xml`, files structure)
| 2     | compile  | Compile the source code (`src/main/java` )
| 3     | test     | Test the compiled code with a unit test framework
| 4     | package  | Takes the compiled and tested code and the `.jar` in `target/`
| 5     | verify   | Do even more tests to verify if the `.jar` artifact is correct
| 6     | install  | Install the package into `~/.m2/repository` to use it as dependency in other projects locally
| 7     | deploy   | Publish the package into the remote repository. Note that this command need the remote repository to be configured

As you can see, there are a lot of default commands in `Maven` and they follow the hierarchy order. For example:
 if you use `mvn compile`, the `mvn validate` will be executed too, their order of
hierarchy.

## What is the minimum number of commands needed to clean, compile, test, deploy, and report on a project? (Note the lifecycle and dependencies).

Now we can answer that. The minimum commands needed are `mvn deploy` that by the hierarchy will run `mvn compile` and `mvn test`. Now, clean and report on a project are 2 other
commands that have their own lifecycle. To clean you can use `mvn clean`, and to report you can use `mvn site`