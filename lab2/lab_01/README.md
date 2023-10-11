# Servlet

## O que é?
O Servlet é uma classe Java que é executada em um servidor web. Ela recebe requests e dá respostas com base nessa requisição.
É uma interface padrão para a criação de aplicações web.

## Como usar?
Para usar o Servlet, é necessário criar uma classe que extenda a classe HttpServlet. Essa classe deve sobrescrever os métodos doGet e doPost, que são os métodos que recebem as requisições GET e POST, respectivamente.


# EmbeddedJettyExample

## O que é?
O EmbeddedJettyExample é um exemplo de aplicação web que usa o Servlet. Ele é um servidor web que recebe requisições GET e POST e responde com uma página HTML.

## Como usar?
Para usar o EmbeddedJettyExample, é necessário ter o Maven instalado. Após isso, basta executar o comando `mvn clean install` na pasta do projeto. Isso irá gerar um arquivo .war na pasta target. Para executar o servidor, basta executar o comando `java -jar target/embeddedjettyexample-1.0-SNAPSHOT.war`. Após isso, basta aceder o endereço `http://localhost:8080/` .



## Classe HelloServlet

## Classe Main

A classe Main é a classe que inicia o servidor. O código abaixo mostra o método main da classe Main.

```java
 public static void main(String[] args) throws Exception {

        Server server = new Server(8680);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new HelloServlet()), "/");
        server.start();
        server.join();
    }
```

### doGet

O método doGet recebe uma requisição GET e responde com uma página HTML. O código abaixo mostra o método doGet da classe HelloServlet.

```java
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);

            String msgParam = request.getParameter("msg");

            if (msgParam != null && !msgParam.isEmpty()) {
                response.getWriter().println("<h1>" + msgParam + "</h1>");
            } else {
                response.getWriter().println("<h1>2.1 Feito</h1>");
            }
        }
```

### doPost

O método doPost recebe uma requisição POST e responde com uma página HTML.



