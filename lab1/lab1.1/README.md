# Lab 1.1 Notes

## Creating first Java Maven Project
``` bash
$ mvn archetype:generate -DgroupId=pt.mankings.app -DartifactId=test-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

- archetype - modelo ou padrão de como tudo é feito.
- groupId - identificador único de cada projeto, este deve seguir as "Java's package name rules"
- artifactId - nome do arquivo jar que será gerado após a compilação 
- archetypeArtifactId - modelo ou padrão de como tudo é feito.

## Build the Project

``` bash
mvn package
```

## Run the Project

``` bash
java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
```