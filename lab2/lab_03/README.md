# Spring Boot

O Spring Boot é um projeto da Spring que visa facilitar o processo de configuração e publicação de aplicações que utilizem o ecossistema Spring. Ele utiliza o conceito de Convenção sobre Configuração, ou seja, ele já vem com algumas configurações padrões para que o desenvolvedor não precise se preocupar com isso. Além disso, ele também possui um servidor de aplicação embutido, o que facilita o processo de deploy. 

## Spring Initializr

O Spring Initializr é uma ferramenta que permite a criação de projetos Spring Boot de forma rápida e fácil. Para utilizá-lo, basta acessar o site https://start.spring.io/ e preencher as informações necessárias, desde dependencias, linguagem de programação, ...

### Alterar a app port

Alterar as configurações do servidor embutido do Spring Boot é muito simples. Basta adicionar a seguinte linha no arquivo `application.properties`:

```properties
server.port=7777
```

### Run da app

Para rodar a aplicação, basta executar o seguinte comando:

```bash
mvn spring-boot:run
```

### Build da app

Para gerar o arquivo `.jar` da aplicação, basta executar o seguinte comando:

```bash
mvn clean package
```

### Run do jar

Para rodar o arquivo `.jar` gerado, basta executar o seguinte comando:

```bash
java -jar target/<nome-do-arquivo>.jar
```

