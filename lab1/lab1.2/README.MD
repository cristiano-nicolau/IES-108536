## Create project

```bash
mvn archetype:generate -DgroupId=com.myweatherradar.app -DartifactId=MyWeatherRadar -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Pom.xml

```xml
<dependencies>
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20200518</version>
    </dependency>
</dependencies>
```


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
