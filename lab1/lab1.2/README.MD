## Create project

```bash
mvn archetype:generate -DgroupId=com.myweatherradar.app -DartifactId=MyWeatherRadar -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Pom.xml

The pom.xml file is the core of a project's configuration in Maven.

The minimum requirement for a POM are:
- The `groupId` and `artifactId`. These two attributes  identify your artifact within its group, which can be used to locate it on repositories
- The `version` of the artifact you are building
- The `project`'s `build` output directory (target)

Other POM elements are:
- `dependencies` - lists the project's dependencies and allows you to declare the dependencies of your project
- `repositories` - lists the repositories where artifacts can be found
- `build` - contains the default configuration for the build process

## Compile project

```bash
mvn package
```

## How to run the project

### Compile with no arguments

```bash
mvn exec:java -Dexec.mainClass="com.myweatherradar.app.WeatherStarter"
```

Alternativa:

```bash
java -jar ./target/MyWeatherRadar-1.0-SNAPSHOT.jar
```

### Compile with arguments

```bash
 mvn exec:java -Dexec.mainClass="com.myweatherradar.app.WeatherStarter" -Dexec.args="1160900"
```

Alternativa:

```bash
java -jar ./target/MyWeatherRadar-1.0-SNAPSHOT.jar 1160900
```
