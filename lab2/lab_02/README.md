# Server-side programming and application servers (Tomcat)

### O que é?

Server-side programming e servidores de aplicação, como o Tomcat, são conceitos fundamentais no desenvolvimento de aplicativos da web.
O Tomcat é um servidor de aplicação web de código aberto desenvolvido pela Apache Software Foundation. Ele é projetado para executar aplicativos Java. O Tomcat é um servidor web que suporta servlets e fornece um ambiente de execução para aplicativos web Java.

# JakartaWebStarter

- Implementamos um servlet java que imprime uma mensagem personalizada com base em parâmetros passados na URL.
- Compilamos o projeto atraves de  `mvn clean install`  e executamos o projeto com `java -jar target/JakartaWebStarter-1.0-SNAPSHOT.war`.
- Configuramos o arquivo docker-compose.yml onde mapeamos o diretório de destino local para a pasta padrão de implantação do Tomcat

```yml
version: '3'

services:
  tomcat:
    image: tomcat:latest
    ports:
      - "8080:8080"
    volumes:
      - ./target:/usr/local/tomcat/webapps
```
- Executamos o comando `docker-compose up` para iniciar o contêiner.
- Acessamos o endereço `http://localhost:8888/hello-servlet` e verificamos a mensagem impressa na tela.





