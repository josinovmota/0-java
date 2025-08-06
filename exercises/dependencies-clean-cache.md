# Clean dependencies cache

Imagine that we are creating our artifact `.jar` and we had an internet failure in the middle
of the process. It could affect our `project` in such a way that we have to clean `dependencies cache`. In order to
do that, we can use the following command:

```shell
mvn dependency:purge-local-repository -DreResolve=true
```

This command will clean the dependencies cache and the flag `-DreResolve=true` will reinstall them