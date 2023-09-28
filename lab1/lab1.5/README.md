## How To create project2
```bash
mvn archetype:generate -DgroupId=IpmaApiClient -DartifactId=IpmaApiClient -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## How to comple project2
```bash
mvn clean install -u
```

## How to run the project2

```bash
java -jar ./target/IpmaApiClient-1.0-SNAPSHOT.jar
```

### To run jar, its necessary this in pom.xlm
```xml
 <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-shade-plugin</artifactId>
          <version>2.3</version>
          <executions>
            <!-- Run shade goal on package phase -->
            <execution>
          <phase>package</phase>
          <goals>
            <goal>shade</goal>
          </goals>
          <configuration>
            <transformers>
              <!-- add Main-Class to manifest file -->
                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                  <mainClass>IpmaApiClient.IpmaApiClient</mainClass>
                </transformer>
            </transformers>
          </configuration>
          </execution>
          </executions>
        </plugin>
     
    </plugins>
```

- Acerca do projeto 1 do exercicio 1.5, como surgiram várias duvidas tanto acerca do que era fazer no exercicio como na resolução do mesmo, nao foi implementada nenhuna solução.