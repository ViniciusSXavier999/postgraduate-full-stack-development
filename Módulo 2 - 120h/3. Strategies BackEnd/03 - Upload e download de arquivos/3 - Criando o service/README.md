# 3 → CRIANDO O SERVICE

🚨 Durante a aula eu estava tendo um erro no pom.xml que estava sendo ocasianado pelo tamanho do meu caminho de arquivo na arquivo ‘application properties’, realizei diversas pesquisas referente ao erro e inicialmente não obtive sucesso nas respostas, até que recorri ao chat gtp e obtive a solução lá.


---

---

### O SERVICE REFERENTE AS DUAS FUNCIONALIDADES, QUE DEVE CONTER 3 MÉTODOS:

 1 → SALVAR OS ARQUIVOS LOCALMENTE;

 2 → RECUPERAR OS ARQUIVOS

 3 → DETERMINAR O TIPO DO ARQUIVO

---

### 1. PRIMEIRA COISA QUE VAMOS FAZER É A SOLUÇÃO PARA CASO O DIRETÓRIO QUE DECLARAMOS NÃO EXISTA, DEVERÁ SER CRIADO UM.

- 1 → Vamos criar uma variável do tipo PATH

### O QUE É O TIPO PATH?

🏆 Em Java, o tipo `Path` é parte da API de arquivos introduzida no Java 7, especificamente no pacote `java.nio.file`. Ele representa o caminho (diretório ou arquivo) no sistema de arquivos, fornecendo uma maneira mais moderna e poderosa de trabalhar com arquivos em comparação com a antiga classe `File`.

### Características principais:

- **Representação de Caminho**: Um `Path` pode representar um caminho absoluto ou relativo, tanto em sistemas de arquivos locais quanto em sistemas de arquivos remotos.
- **Imutabilidade**: O objeto `Path` é imutável, ou seja, uma vez criado, ele não pode ser alterado. Se você precisar modificar o caminho, você cria um novo objeto `Path`.
- **Plataforma Independente**: O `Path` é projetado para funcionar em diferentes sistemas operacionais, ajustando-se automaticamente às convenções de caminhos do sistema (como o uso de barras `/` ou `\`).

### Operações comuns com `Path`:

1. **Criar um Path**:
    - `Path path = Paths.get("diretorio/arquivo.txt");`
    
    Aqui, `Paths.get()` cria um `Path` a partir de uma string representando o caminho.
    
2. **Verificar se o arquivo/diretório existe**:
    - `Files.exists(path)`
3. **Obter o nome do arquivo ou diretório**:
    - `Path fileName = path.getFileName();`
4. **Obter o diretório pai**:
    - `Path parent = path.getParent();`
5. **Manipulação de Caminhos Relativos**:
    - `Path relative = path.resolve("subdiretorio/arquivo.txt");`
6. **Trabalhando com diretórios e arquivos**:
    - `Files.isDirectory(path)`: Verifica se é um diretório.
    - `Files.isRegularFile(path)`: Verifica se é um arquivo regular.

### Exemplo simples:

```java
import java.nio.file.*;

public class PathExample {
    public static void main(String[] args) {
        Path path = Paths.get("diretorio/arquivo.txt");
        System.out.println("Nome do arquivo: " + path.getFileName());
        System.out.println("Diretório pai: " + path.getParent());

        // Verifica se o caminho existe
        if (Files.exists(path)) {
            System.out.println("Arquivo existe!");
        } else {
            System.out.println("Arquivo não encontrado.");
        }
    }
}

```

### Resumo:

O tipo `Path` oferece uma maneira mais moderna e robusta de lidar com caminhos de arquivos e diretórios, com suporte para várias operações úteis de manipulação de arquivos no sistema de arquivos, sendo uma melhoria significativa sobre a classe `File`.


- 2 → VAMOS DESENVOLVER O MÉTODO QUE FAZ O CÓDIGO INTERPRETAR O DIRETÓRIO DE FORMA CORRETA

```java
@Service
public class ArquivoService {
	
	private final Path fileStorageLocation;
	
	public ArquivoService(ArquivoStorageProperties arquivoStorageProperties) {
		// Vamos pegar aquela string do meu arquivo application properties
		this.fileStorageLocation = Paths.get(arquivoStorageProperties.getUploadDir()).toAbsolutePath().normalize();
	}
}
```

🏆

### EXPLICAÇÃO DO CÓDIGO ATÉ O MOMENTO

Esse método é o **construtor** da classe `ArquivoService`. Ele está recebendo um parâmetro do tipo `ArquivoStorageProperties`, que provavelmente é uma classe que contém as configurações relacionadas ao armazenamento de arquivos na aplicação, como o diretório onde os arquivos devem ser carregados.

Vamos analisar o que ele faz, passo a passo:

### Passos do método:

1. **Recebe um objeto `ArquivoStorageProperties`**:
O construtor recebe um parâmetro `arquivoStorageProperties` do tipo `ArquivoStorageProperties`. Esse objeto contém propriedades de configuração relacionadas ao armazenamento de arquivos, como o diretório onde os arquivos serão carregados.
2. **Obtém o diretório de upload**:
    - `arquivoStorageProperties.getUploadDir()` é chamado para obter a string que representa o diretório onde os arquivos serão armazenados. Essa string é lida de um arquivo de configuração, como `application.properties` ou `application.yml`.
3. **Converte a string para um objeto `Path`**:
    - `Paths.get(arquivoStorageProperties.getUploadDir())`: A string do diretório é convertida para um objeto `Path`. `Paths.get()` cria um `Path` que representa o caminho do diretório.
4. **Obtém o caminho absoluto**:
    - `.toAbsolutePath()`: Converte o `Path` relativo (caso seja) para um caminho absoluto, ou seja, o caminho completo no sistema de arquivos.
5. **Normaliza o caminho**:
    - `.normalize()`: Normaliza o caminho, o que significa que ele remove qualquer referência redundante, como `"."` ou `".."`. Isso ajuda a garantir que o caminho final esteja correto, sem problemas de barras duplas ou desnecessárias.
6. **Atribui o valor à variável `fileStorageLocation`**:
    - O valor final, que é o caminho absoluto e normalizado, é atribuído à variável `fileStorageLocation`. Essa variável provavelmente será usada em outras partes da classe para realizar operações de armazenamento de arquivos, como salvar, ler ou excluir arquivos do diretório especificado.

### Resumo do que o método faz:

O construtor **`ArquivoService`** recebe um objeto de configuração (`ArquivoStorageProperties`), pega o diretório de upload especificado nele (provavelmente de um arquivo de propriedades), converte esse diretório em um caminho absoluto e normalizado, e o armazena na variável `fileStorageLocation` para uso posterior.

Em termos simples, esse método configura o local onde os arquivos serão armazenados na aplicação, usando informações que vêm da configuração externa (`application.properties` ou algo similar).

### Exemplo de `application.properties`:

Para que esse código funcione corretamente, o arquivo `application.properties` pode ter uma configuração como:

```
arquivo.storage.upload-dir=uploads/

```

E a classe `ArquivoStorageProperties` seria algo assim:

```java
@ConfigurationProperties(prefix = "arquivo.storage")
public class ArquivoStorageProperties {
    private String uploadDir;

    // Getter e setter
    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}

```

Assim, o valor `uploads/` seria injetado no construtor do `ArquivoService`, permitindo o armazenamento de arquivos no diretório configurado.


- 3 → Vamos adicionar no mesmo método o método que tenta criar a pasta caso seja necessário

```java
	try {
			Files.createDirectories(fileStorageLocation);
		} catch (IOException e) {
			
			throw new UploadArquivoException("Algo deu errado ao tentar criar a pasta", e);
			
		}
```

🏆

### EXPLICAÇÃO DO CÓDIGO

- **`Files.createDirectories(fileStorageLocation)`**: Tenta criar o diretório especificado por `fileStorageLocation`.
    - Se o diretório já existir, nada acontece.
    - Se o diretório não existir, ele é criado, incluindo quaisquer diretórios intermediários.
- Se um erro ocorre durante a criação do diretório (como problemas de permissão ou de caminho inválido), ele lança uma `IOException`.
- O bloco `catch` captura essa `IOException`, e **lança uma exceção personalizada (`UploadArquivoException`)**, que inclui a mensagem `"Algo deu errado ao tentar criar a pasta"` e a exceção original (`e`) como causa. Isso permite que o erro seja tratado de maneira mais específica em outra parte do sistema.

A linha de código:

```java
Files.createDirectories(fileStorageLocation)

```

resumidamente, **tenta criar o diretório especificado em `fileStorageLocation`** no sistema de arquivos. Se os diretórios intermediários (caminhos) não existirem, eles também serão criados.

### Resumo:

- **`Files`**: Classe da API NIO do Java usada para operações de arquivos e diretórios.
- **`createDirectories`**: Método que cria o diretório no caminho especificado. Se o diretório já existir, não ocorre erro.
- **`fileStorageLocation`**: Um objeto do tipo `Path` que representa o caminho onde o diretório será criado.

Em resumo, **cria o diretório (e os intermediários) no caminho especificado** se ele ainda não existir.


---

✅ Após rodar o projeto a pasta foi criada de maneira correta e está tudo certo e funcionando até o momento.


---

### 2. AGORA VAMOS CRIAR OS 3 MÉTODOS QUE FALTAM.

### 1. PRIMEIRO MÉTODO SERÁ O MÉTODO DE PEGAR EXTENSÃO DO ARQUIVO

```java
	public String getContentType(HttpServletRequest request, Resource resource) {
		String contentType = null;
		
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
			
		} catch (Exception e) {
			log.error("Não foi possível determninar o tipo de arquivo");
		}
		
		if(contentType == null) {
			contentType = "application/octet-stream";
		}
		
		return contentType;
		
	}
```

🔒

### EXPLICANDO O CÓDIGO LINHA POR LINHA

Claro! Vou te explicar **linha por linha** de forma bem clara e direta o que esse método faz:

---

```java
public String getContentType(HttpServletRequest request, Resource resource) {

```

- Declara o método `getContentType`.
- Ele **recebe dois parâmetros**:
    - `HttpServletRequest request`: representa a requisição HTTP atual.
    - `Resource resource`: representa um arquivo ou recurso (do Spring, tipo um arquivo no classpath ou no sistema).
- Retorna uma `String` com o tipo de conteúdo (tipo MIME, como `image/png`, `application/pdf`, etc).

---

```java
String contentType = null;

```

- Cria uma variável chamada `contentType` e define inicialmente como `null`.
- Essa variável vai armazenar o tipo de conteúdo do arquivo.

---

```java
try {

```

- Início de um bloco `try`, onde se tenta executar algo que **pode lançar uma exceção** (erro).

---

```java
contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

```

- **Pega o caminho absoluto** do arquivo representado por `resource`.
- Usa o `ServletContext` (contexto da aplicação web) para tentar descobrir o **tipo MIME** com base no nome do arquivo (geralmente pela extensão).
    - Exemplo: se o arquivo for `documento.pdf`, o MIME será `"application/pdf"`.

---

```java
} catch (Exception e) {

```

- Captura qualquer exceção que possa ocorrer na linha anterior, como:
    - `resource.getFile()` falhar (arquivo não encontrado, permissão negada, etc).

---

```java
log.error("Não foi possível determninar o tipo de arquivo");

```

- Escreve no log de erro uma mensagem avisando que **não foi possível descobrir o tipo do arquivo**.
- `log` é provavelmente um logger (como o SLF4J ou Logback).

---

```java
if(contentType == null) {

```

- Verifica se a variável `contentType` **ainda está nula**, ou seja, se o tipo não foi determinado.

---

```java
contentType = "application/octet-stream";

```

- Se o tipo MIME não foi descoberto, define um **tipo genérico padrão** para arquivos binários.
- `"application/octet-stream"` diz basicamente "isso é um arquivo binário", e o navegador geralmente faz o download.

---

```java
return contentType;

```

- Retorna o tipo MIME final (descoberto ou genérico).

---

### ✅ Em resumo:

Esse método:

1. Tenta descobrir o tipo MIME de um arquivo (`Resource`) com base na extensão.
2. Se não conseguir, define um tipo genérico (`application/octet-stream`).
3. Isso é útil pra definir o **Content-Type** correto ao enviar arquivos via HTTP.


### 2. SEGUNDO MÉTODO SERÁ O MÉTODO DE SALVAR ARQUIVO 

```java
	public String salvarArquivo(MultipartFile file) {
		String nomeArquivo = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if (nomeArquivo.contains("..")) {
				throw new UploadArquivoException("Arquivo invalido");
			}
			
			Path targetLocation = this.fileStorageLocation.resolve(nomeArquivo);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			
			return nomeArquivo;
			
		} catch (Exception e) {
			throw new UploadArquivoException("Erro ao tentar salvar o arquivo", e);
		}
	}
```

🔒

### EXPLICANDO O CÓDIGO LINHA POR LINHA

---

```java
public String salvarArquivo(MultipartFile file) {

```

🔹 Declara um método público chamado `salvarArquivo`.

🔹 Ele recebe um parâmetro `file` do tipo `MultipartFile`, que representa um **arquivo enviado via formulário** (upload).

🔹 O método retorna uma `String`, que será o **nome do arquivo salvo**.

---

```java
String nomeArquivo = StringUtils.cleanPath(file.getOriginalFilename());

```

🔹 `file.getOriginalFilename()`:

- Retorna o **nome original do arquivo enviado**, ex: `"foto.png"` ou `"../hack.jpg"`.

🔹 `StringUtils.cleanPath(...)` (do Spring):

- **Limpa o caminho** do nome do arquivo, removendo qualquer ocorrência suspeita de navegação de diretórios (`../`, `./`, etc).
- Garante um nome mais seguro e confiável.

✔️ Resultado: `nomeArquivo` recebe o nome do arquivo de forma sanitizada.

---

```java
try {

```

🔹 Início do bloco `try`.

Usado para **capturar qualquer exceção** que possa acontecer nas próximas linhas (ex: erro ao copiar o arquivo).

---

```java
    if (nomeArquivo.contains("..")) {
        throw new UploadArquivoException("Arquivo invalido");
    }

```

🔹 Verifica se, mesmo após o `cleanPath`, o nome do arquivo ainda contém `".."`.

Isso é uma tentativa de **path traversal** (navegar por diretórios acima), que é uma falha de segurança.

🔹 Se detectar isso, o código **lança uma exceção personalizada** (`UploadArquivoException`) com a mensagem `"Arquivo inválido"`.

---

```java
    Path targetLocation = this.fileStorageLocation.resolve(nomeArquivo);

```

🔹 `this.fileStorageLocation`:

É um objeto `Path` que representa o **diretório onde os arquivos devem ser salvos**. Ele geralmente é inicializado em outro lugar da classe (por exemplo, no construtor).

🔹 `.resolve(nomeArquivo)`:

- Junta o caminho base (`fileStorageLocation`) com o `nomeArquivo`.
- Exemplo: `/uploads` + `foto.png` → `/uploads/foto.png`

✔️ `targetLocation` é o **caminho completo onde o arquivo será salvo** no sistema de arquivos.

---

```java
    Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

```

🔹 `file.getInputStream()`:

- Abre um **stream de leitura** do conteúdo do arquivo enviado.

🔹 `Files.copy(...)`:

- Copia os dados do arquivo (stream) para o **caminho de destino** (`targetLocation`).

🔹 `StandardCopyOption.REPLACE_EXISTING`:

- Se já existir um arquivo com esse nome, **ele será substituído**.

✔️ Essa linha é responsável por **salvar fisicamente o arquivo no servidor**.

---

```java
    return nomeArquivo;

```

🔹 Retorna o nome do arquivo salvo, útil para:

- Mostrar ao usuário
- Armazenar no banco de dados
- Gerar links de download, etc.

---

```java
} catch (Exception e) {
    throw new UploadArquivoException("Erro ao tentar salvar o arquivo", e);
}

```

🔹 Captura qualquer erro que possa ocorrer dentro do `try` (como problemas ao gravar o arquivo no disco).

🔹 Lança novamente uma **exceção personalizada** (`UploadArquivoException`), agora com:

- Uma mensagem amigável
- A exceção original (`e`), que ajuda na hora de fazer debug.

---

### ✅ Resumo do que o método faz:

1. Pega o nome original do arquivo e limpa.
2. Verifica se é um nome seguro.
3. Define onde salvar.
4. Copia o conteúdo do arquivo para o destino.
5. Retorna o nome do arquivo salvo.
6. Trata erros com uma exceção personalizada.

---


### 3. TERCEIRO MÉTODO SERÁ RESONSÁVEL PELO DOWNLOAD DO ARQUIVO

🔒

### EXPLICAÇÃO DO MÉTODO

Esse método tenta **localizar e retornar um arquivo** (como um PDF, imagem, etc.) que foi previamente salvo no servidor. Ele retorna esse arquivo como um **`Resource`**, que é um tipo genérico usado no Spring para representar qualquer recurso acessável (arquivo, URL, etc).

---

### 🔍 O que o método faz?

Esse método tenta **localizar e retornar um arquivo** (como um PDF, imagem, etc.) que foi previamente salvo no servidor. Ele retorna esse arquivo como um **`Resource`**, que é um tipo genérico usado no Spring para representar qualquer recurso acessável (arquivo, URL, etc).

---

### 📦 Código completo com explicação:

```java
public Resource carregarArquivo(String arquivoNome) {

```

🔹 Declara o método `carregarArquivo`, que:

- Recebe como parâmetro `arquivoNome` (o nome do arquivo a ser carregado)
- Retorna um objeto do tipo `Resource` (do pacote `org.springframework.core.io.Resource`)

---

```java
    try {

```

🔹 Início do bloco `try`, usado para capturar erros que podem ocorrer durante o carregamento do arquivo (ex: caminho inválido, arquivo não encontrado, etc.)

---

```java
        Path filePath = this.fileStorageLocation.resolve(arquivoNome).normalize();

```

🔹 Explicação dessa linha:

- `this.fileStorageLocation` é um `Path` com o **diretório base onde os arquivos estão armazenados**.
- `.resolve(arquivoNome)` junta o diretório com o nome do arquivo → ex: `/uploads` + `foto.png` = `/uploads/foto.png`.
- `.normalize()` remove qualquer parte suspeita do caminho, como `../`, `./`, etc., garantindo que seja um **caminho limpo e seguro**.

✔️ Resultado: `filePath` é o **caminho completo do arquivo que se deseja carregar**.

---

```java
        Resource resource = new UrlResource(filePath.toUri());

```

🔹 Cria um objeto `UrlResource` a partir da **URI** do caminho do arquivo:

- `filePath.toUri()` transforma o caminho do arquivo em uma `URI` (tipo de endereço universal).
- `new UrlResource(...)` cria o `Resource`, que o Spring pode usar para retornar arquivos em controladores REST, por exemplo.

✔️ Agora, o `resource` representa o **arquivo pronto para ser lido ou enviado**.

---

```java
        if (resource.exists()) {
            return resource;
        } else {
            throw new ArquivoNaoEncontradoException("Arquivo não encontrado");
        }

```

🔹 Verifica se o arquivo realmente **existe** no disco:

- Se existir, retorna o `resource` para quem chamou o método.
- Se **não existir**, lança uma exceção personalizada chamada `ArquivoNaoEncontradoException`.

---

```java
    } catch (Exception e) {
        throw new ArquivoNaoEncontradoException("Arquivo não encontrado");
    }

```

🔹 Qualquer erro que acontecer dentro do `try` será capturado aqui (por exemplo, URI inválida, problemas de permissão, etc.).
🔹 Nesse caso, ele também lança uma exceção `ArquivoNaoEncontradoException`.

---

### 🛠 Resumo do método:

1. Recebe o nome de um arquivo.
2. Constrói o caminho completo onde o arquivo deve estar.
3. Tenta transformar o caminho em um `Resource` (objeto que o Spring pode trabalhar).
4. Verifica se o arquivo existe:
    - Se sim → retorna o `Resource`
    - Se não → lança exceção
5. Se qualquer erro acontecer → lança a mesma exceção de "arquivo não encontrado"

---

### 📌 Utilidade prática:

Esse método seria útil, por exemplo, em um controller REST como esse:

```java
@GetMapping("/download/{nome}")
public ResponseEntity<Resource> download(@PathVariable String nome) {
    Resource arquivo = fileStorageService.carregarArquivo(nome);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + arquivo.getFilename() + "\"")
        .body(arquivo);
}

```

---

