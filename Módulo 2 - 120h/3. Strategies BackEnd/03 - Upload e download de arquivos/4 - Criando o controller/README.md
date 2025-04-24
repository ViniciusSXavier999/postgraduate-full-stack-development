# 4 → CRIANDO O CONTROLLER

🏆 O nosso controller terá dois end-points: 

- UPLOAD DE ARQUIVOS
- DOWNLOAD DE ARQUIVOS

---

### 1. PRIMEIRA COISA QUE VAMOS FAZER É CRIAR A NOSSA CLASSE CONTROLLER E COLOCAR AS DEVIDAS ANOTAÇÕES NECESSÁRIAS

### 2. VAMOS CRIAR OS MÉTODOS PARA UPLOAD E DOWNLOAD

### MÉTODO UPLOAD ARQUIVO

```java
@PostMapping("upload")
	public Arquivo uploadArquivo(@RequestParam("file") MultipartFile file) {
		String nomeArquivo = arquivoService.salvarArquivo(file);
		
		String caminhoArquivo = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/arquivos/downloadArquivo")
				.path(nomeArquivo).toUriString();
		
		return new Arquivo(nomeArquivo, caminhoArquivo, file.getContentType(), file.getSize());
	}
```

🔒

### EXPLICANDO O ENDPOINT UPLOAD

---

### 📦 Código completo:

```java
@PostMapping("upload")
public Arquivo uploadArquivo(@RequestParam("file") MultipartFile file) {
    String nomeArquivo = arquivoService.salvarArquivo(file);

    String caminhoArquivo = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/arquivos/downloadArquivo")
        .path(nomeArquivo).toUriString();

    return new Arquivo(nomeArquivo, caminhoArquivo, file.getContentType(), file.getSize());
}

```

---

### 🧠 Explicação linha por linha:

---

```java
@PostMapping("upload")

```

🔹 Define que este método será chamado quando o cliente fizer um **POST para a URL `/upload`**.

🔹 Geralmente, isso acontece quando um formulário com envio de arquivos (`multipart/form-data`) é submetido, ou via chamada HTTP com biblioteca tipo Postman, Axios, etc.

---

```java
public Arquivo uploadArquivo(@RequestParam("file") MultipartFile file) {

```

🔹 Define o método `uploadArquivo`, que:

- Retorna um objeto `Arquivo` (provavelmente uma classe modelo que você criou para descrever o arquivo salvo).
- Recebe um parâmetro `file`, que é o **arquivo enviado pelo cliente**.

🔹 `@RequestParam("file")`:

- Indica que o arquivo deve vir de um campo chamado `file` (como `<input type="file" name="file">`).
- `MultipartFile` é uma classe do Spring que representa arquivos enviados via formulário.

---

```java
String nomeArquivo = arquivoService.salvarArquivo(file);

```

🔹 Chama o método `salvarArquivo()` de um **serviço chamado `arquivoService`** (provavelmente você já viu ou criou esse método).

🔹 Esse método:

- Salva o arquivo no servidor
- Retorna o **nome do arquivo salvo** (como `"foto123.png"`)

---

```java
String caminhoArquivo = ServletUriComponentsBuilder.fromCurrentContextPath()
    .path("/arquivos/downloadArquivo")
    .path(nomeArquivo).toUriString();

```

🔹 Monta a **URL pública de acesso ao arquivo**, por exemplo:

```
http://localhost:8080/arquivos/downloadArquivo/foto123.png

```

🔹 Linha por linha:

- `fromCurrentContextPath()` → pega o caminho atual da aplicação (`http://localhost:8080`)
- `.path(...)` → adiciona o endpoint onde o arquivo pode ser baixado
- `.path(nomeArquivo)` → junta o nome do arquivo
- `.toUriString()` → transforma tudo em uma `String` com a URL completa

---

```java
return new Arquivo(nomeArquivo, caminhoArquivo, file.getContentType(), file.getSize());

```

🔹 Cria e retorna um objeto `Arquivo`, que provavelmente é uma **classe modelo** com esses atributos:

| Atributo | Valor |
| --- | --- |
| `nomeArquivo` | Nome do arquivo salvo (`"foto123.png"`) |
| `caminhoArquivo` | URL pública para baixar o arquivo |
| `file.getContentType()` | Tipo do arquivo (ex: `image/png`, `application/pdf`) |
| `file.getSize()` | Tamanho do arquivo em bytes |

---

### 🧾 Classe `Arquivo` (exemplo provável):

```java
public class Arquivo {
    private String nome;
    private String url;
    private String tipo;
    private long tamanho;

    public Arquivo(String nome, String url, String tipo, long tamanho) {
        this.nome = nome;
        this.url = url;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    // Getters e setters (ou use Lombok)
}

```

---

### 📌 Exemplo prático com Postman:

- Método: `POST`
- URL: `http://localhost:8080/upload`
- Tipo de Body: `form-data`
- Campo: `file` (tipo "File") → selecione um arquivo qualquer

---


💡

### @REQUESTPARAM

### ✅ O que é `@RequestParam`?

`@RequestParam` serve para **ligar um parâmetro da requisição HTTP** (como query string ou formulário) a um **parâmetro do método no controller**.

---

### 📦 Exemplo 1: Pegando da URL (Query Parameter)

Se você acessar a URL:

```
http://localhost:8080/saudacao?nome=Joao

```

Você pode capturar esse valor assim:

```java
@GetMapping("/saudacao")
public String saudacao(@RequestParam String nome) {
    return "Olá, " + nome + "!";
}

```

🔹 Aqui, o valor de `nome` na URL (`Joao`) é automaticamente passado para o parâmetro `String nome`.

---

### ⚙️ Com mais opções

```java
@GetMapping("/produto")
public String getProduto(@RequestParam(name = "id", required = false, defaultValue = "0") int id) {
    return "Produto com ID: " + id;
}

```

- `name = "id"` → nome do parâmetro na URL
- `required = false` → não é obrigatório
- `defaultValue = "0"` → se não for informado, será 0

---

### 📝 Exemplo 2: Envio por formulário (POST)

```html
<form action="/enviar" method="post">
    <input type="text" name="mensagem">
    <button type="submit">Enviar</button>
</form>

```

E no controller:

```java
@PostMapping("/enviar")
public String receber(@RequestParam String mensagem) {
    return "Você enviou: " + mensagem;
}

```

---

### 🆚 Diferença entre `@RequestParam`, `@PathVariable` e `@RequestBody`

| Anotação | Vem de onde? | Exemplo de uso |
| --- | --- | --- |
| `@RequestParam` | Query String ou formulário | `/produto?id=10` |
| `@PathVariable` | Parte da URL | `/produto/10` |
| `@RequestBody` | Corpo da requisição (JSON, etc.) | Envio de dados complexos via POST (ex: JSON) |

---


### MÉTODO DOWNLOAD ARQUIVO

```java
@GetMapping("/downloadArquivo/{nomeArquivo}")
	public ResponseEntity<Resource> downloadArquivo(@PathVariable String nomeArquivo, HttpServletRequest request) {
		
		
		Resource resource = arquivoService.carregarArquivo(nomeArquivo);
		
		// descobringo o tipo do arquivp
		String contentType = arquivoService.getContentType(request, resource);
		
		// agora vamos fazer o download do arquivo
		
		return ResponseEntity.ok()
				// Esse é um padrão para transferência e download de arquivo
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
```

🔒

### EXPLICAÇÃO DO CÓDIGO PASSO A PASSO

### ✅ Visão geral

Este método:

1. Recebe o **nome de um arquivo**
2. Busca esse arquivo no servidor
3. Descobre o tipo (MIME type)
4. Prepara a resposta com os **headers corretos para download**
5. Retorna o arquivo como resposta HTTP

---

### 📦 Código explicado:

```java
@GetMapping("/downloadArquivo/nomeArquivo")

```

🔹 Indica que esse método será acessado via **GET** na rota `/downloadArquivo/nomeArquivo`.

❗️**Problema aqui:** a URL tem `nomeArquivo` como **fixo**, quando o correto seria usá-lo como variável de caminho:

✅ O certo seria:

```java
@GetMapping("/downloadArquivo/{nomeArquivo}")

```

Assim, você pode passar o nome real do arquivo na URL, ex: `/downloadArquivo/foto123.png`

---

```java
public ResponseEntity<Resource> downloadArquivo(String nomeArquivo, HttpServletRequest request) {

```

🔹 Método que:

- Retorna um `ResponseEntity<Resource>` (um arquivo dentro da resposta HTTP)
- Recebe:
    - `String nomeArquivo` → o nome do arquivo a ser baixado
    - `HttpServletRequest request` → para acessar informações da requisição HTTP (como o `User-Agent`, etc.)

❗️**Nota:** Para que `nomeArquivo` funcione com a URL, ele precisa da anotação:

```java
@PathVariable String nomeArquivo

```

✅ Correto:

```java
public ResponseEntity<Resource> downloadArquivo(@PathVariable String nomeArquivo, HttpServletRequest request)

```

---

```java
Resource resource = arquivoService.carregarArquivo(nomeArquivo);

```

🔹 Chama um serviço (`arquivoService`) que tenta **carregar o arquivo** com o nome fornecido.

🔹 O retorno é um `Resource` — um tipo que representa um arquivo ou recurso externo no Spring.

---

```java
String contentType = arquivoService.getContentType(request, resource);

```

🔹 Esse método tenta descobrir o **tipo MIME** do arquivo (como `image/png`, `application/pdf`, etc.).

🔹 Usa o `HttpServletRequest` e o próprio arquivo (`Resource`) para identificar o tipo.

🔹 Isso ajuda o navegador a **entender como lidar com o arquivo** (abrir ou baixar, por exemplo).

---

```java
return ResponseEntity.ok()

```

🔹 Inicia a criação de uma resposta HTTP com status **200 OK**.

---

```java
    .contentType(MediaType.parseMediaType(contentType))

```

🔹 Define o cabeçalho `Content-Type` com o **tipo real do arquivo**, garantindo que o navegador saiba como tratá-lo corretamente.

---

```java
    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")

```

🔹 Define o cabeçalho `Content-Disposition` como `"attachment"`:

- Isso **força o navegador a baixar o arquivo**, em vez de tentar abrir direto.
- O nome do arquivo usado no download é o mesmo do arquivo original (`resource.getFilename()`)

---

```java
    .body(resource);

```

🔹 Define o **corpo da resposta** como o conteúdo do arquivo.

✔️ Com isso, o Spring entrega o arquivo diretamente ao navegador ou cliente.

---

### 🧾 Exemplo completo corrigido:

```java
@GetMapping("/downloadArquivo/{nomeArquivo}")
public ResponseEntity<Resource> downloadArquivo(
        @PathVariable String nomeArquivo,
        HttpServletRequest request) {

    Resource resource = arquivoService.carregarArquivo(nomeArquivo);

    String contentType = arquivoService.getContentType(request, resource);

    return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
            .body(resource);
}

```

---

### 📥 Exemplo de uso (navegador ou Postman):

Se você salvou o arquivo `"relatorio.pdf"`, pode acessar:

```
GET http://localhost:8080/downloadArquivo/relatorio.pdf

```

E ele será baixado automaticamente com os headers corretos.

---


---

### O QUE É A CLASSE HttpServletRequest?

🏆

Excelente pergunta! A classe `HttpServletRequest` é **uma das mais importantes** quando você trabalha com aplicações web em Java usando Servlets, Spring MVC ou Spring Boot.

---

## ✅ O que é `HttpServletRequest`?

A classe `HttpServletRequest` representa a **requisição HTTP feita pelo cliente** (como um navegador, Postman, ou outro sistema) para o servidor.

Ela contém **todas as informações da requisição**, como:

- Parâmetros da URL (query string)
- Dados do formulário (em POST)
- Cabeçalhos HTTP (headers)
- Informações sobre cookies
- IP do cliente
- Tipo do navegador (User-Agent)
- Caminho da URL acessada
- Corpo da requisição
- Sessão do usuário

---

## 📦 De onde ela vem?

Ela faz parte da especificação do **Servlet API**, do pacote:

```java
import jakarta.servlet.http.HttpServletRequest;
// ou em versões antigas:
import javax.servlet.http.HttpServletRequest;

```

> Em projetos Spring Boot, ela é passada automaticamente como parâmetro nos métodos do controller, caso você precise acessar dados da requisição diretamente.
> 

---

## 🛠 Exemplos práticos

### 🔹 Obter IP do cliente:

```java
String ip = request.getRemoteAddr();

```

### 🔹 Obter o User-Agent (navegador ou app que fez a requisição):

```java
String userAgent = request.getHeader("User-Agent");

```

### 🔹 Pegar um parâmetro da URL (ex: ?nome=joao):

```java
String nome = request.getParameter("nome");

```

### 🔹 Pegar o caminho completo da URL:

```java
String url = request.getRequestURL().toString();

```

---

## ✅ Quando usar no Spring?

Você só precisa usar `HttpServletRequest` **quando quiser acessar dados mais "baixos" ou específicos** da requisição, que o Spring normalmente já trataria automaticamente com anotações como `@RequestParam`, `@RequestHeader`, etc.

### 📌 Exemplo real no Spring:

```java
@GetMapping("/info")
public String info(HttpServletRequest request) {
    String ip = request.getRemoteAddr();
    String userAgent = request.getHeader("User-Agent");

    return "IP: " + ip + ", Navegador: " + userAgent;
}

```

---


### O QUE É SERVLET?

---

## ✅ O que é um **Servlet**?

Um **Servlet** é um **objeto Java** que roda dentro de um **servidor web** (como Tomcat) e é responsável por **receber e responder requisições HTTP**.

👉 Ele é a **base de toda aplicação web em Java** tradicional.

Tudo que você vê hoje em **Spring Boot**, por exemplo, por baixo dos panos ainda depende de Servlets.

---

### 📦 Em termos simples:

Um Servlet é como uma **classe Java que entende HTTP**.

Você escreve um código que:

- Recebe uma requisição (ex: um formulário enviado)
- Processa dados (ex: salva no banco)
- E responde (ex: "Usuário salvo com sucesso")

---

### 🧠 Como funciona o ciclo:

1. O navegador ou app envia uma requisição HTTP (ex: `GET /usuarios`)
2. O servidor (Tomcat, Jetty, etc.) **entrega essa requisição para o Servlet**
3. O Servlet processa a requisição (`HttpServletRequest`)
4. O Servlet gera uma resposta (`HttpServletResponse`)
5. A resposta é enviada de volta para o cliente (HTML, JSON, etc.)

---

### 🧪 Exemplo básico de Servlet:

```java
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().write("Olá, mundo!");
    }
}

```

🔹 Isso cria um endpoint em `/hello` que responde com "Olá, mundo!"

🔹 `doGet()` é chamado quando a requisição é do tipo GET

---

## 🚀 E o Spring? Usa Servlet?

**Sim!** Mas o Spring te **abstrai** de toda essa complexidade.

Por exemplo, este código no Spring:

```java
@GetMapping("/hello")
public String hello() {
    return "Olá, mundo!";
}

```

👉 Internamente o Spring está registrando um Servlet, tratando requisição e resposta, tudo **sem você precisar fazer isso manualmente**.

---

## 🧱 Tipos de Servlet:

- **HttpServlet** → mais comum, usado para requisições HTTP
- **GenericServlet** → base mais genérica (raro de usar diretamente)

---

### 📌 Resumo:

| Termo | Significado |
| --- | --- |
| **Servlet** | Classe Java que responde a requisições web |
| **HttpServlet** | Subclasse especializada para HTTP |
| **Servlet Container** | Servidor que executa os servlets (ex: Tomcat) |
| **Spring** | Usa servlets por baixo dos panos, mas simplifica tudo |

---