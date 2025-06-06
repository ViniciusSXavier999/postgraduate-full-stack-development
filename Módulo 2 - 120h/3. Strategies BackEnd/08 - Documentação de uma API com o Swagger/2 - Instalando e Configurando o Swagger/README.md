# 2 → INSTALANDO E CONFIGURANDO O SWAGGER

💡 Nesta aula, vamos fazer todas as configurações necessárias para que possamos utilizar o Swagger na nossa API

> Exemplo: até o momento se fizermos o upload e download de um arquivo a partir do swagger não vai funcionar.
> 

---

## INICIANDO A IMPLEMENTAÇÃO DAS CONFIGURAÇÕES NECESSÁRIAS DO SWAGGER EM NOSSO PROJETO

### 1. PRIMEIRAMENTE, VAMOS REALIZAR UMA ALTERAÇÃO NO NOSSO “ArquivoController” PARA APARECER UM BOTÃO NO SWAGGER PARA PODERMOS REALIZER O UPLOAD DE UM ARQUIVO

🔒 No método POST, vamos substituir a anotação @RequestParam, para @RequestPart


⚠️ Não estava funcionando até que depois de muita pesquisa encontrei a solução, que era colocar esse trecho de código como parâmetro do método post:

```java
@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
```




### O QUE É @REQUESTPART? 🏆

### ✅ `@RequestPart` é usada para extrair **partes específicas** de uma requisição **multipart/form-data**, como:

- **Arquivos** (`MultipartFile`)
- **Objetos complexos** (ex: JSON)

---

### 📌 Exemplo:

```java
@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<?> upload(
    @RequestPart("arquivo") MultipartFile arquivo,
    @RequestPart("dados") MeuDTO dados
) {
    // Processa o arquivo e os dados JSON
}

```

---

### 🧠 Diferença entre `@RequestPart` e `@RequestParam`:

| Anotação | Tipo de uso |
| --- | --- |
| `@RequestParam` | Para campos simples (strings, números) |
| `@RequestPart` | Para arquivos ou objetos (JSON + arquivo) |

---

### 💡 Quando usar `@RequestPart`:

- Upload de arquivos com `MultipartFile`
- Upload de arquivos + dados juntos (ex: JSON)

### 2. REALIZANDO O TESTE DE UPLOAD E DOWNLOAD

🏆 Antes desse primeiro teste foi necessário liberar todos endpoints na nossa lógica de segurança.


### 1 PASSO 🏆

Realizar o upload do arquivo desejado 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/configSwagger1.png" />




### 2 PASSO 🏆

Inserir o nome do arquivo junto da extensão do mesmo e clicar em execute.

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/configSwagger2.png" />


### 3. VAMOS REALIZAR ALGUMAS CONFIGURAÇÕES NA API NA NOSSA CLASSE DE CONFIGURAÇÃO DO SWAGGER

Configuração essas que são: 

- Nome da nossa API
- Descrição
- Contato
- ETC ETC ETC

```java
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Minha API Rest FULL")
						.description("API REALIZADA DURANTE A PÓS GRADUAÇÃO EM DESENVOLVIMENTO FULL STACK PELA DESCOMPLICA")
						.version("1.0").termsOfService("Link_termos_uso")
						.contact(new Contact()
								.name("Vinicius")
								.url("https://github.com/ViniciusSXavier999")
								.email("seu@email.com"))
						.license(new License()
								.name("Licença da API")
								.url("https://www.link-da-licenca.com")));
	}
```



### EXPLICAÇÃO DO CÓDIGO LINHA POR LINHA 🏆

---

### 🧩 Código:

```java
@Bean
public OpenAPI customOpenAPI() {

```

- `@Bean`: Diz ao Spring que esse método cria um **componente (bean)** gerenciado pelo Spring.
- `OpenAPI`: Classe principal da especificação OpenAPI 3.0 (substituta do antigo `ApiInfo` do Springfox).
- `customOpenAPI()`: Nome do método — você pode chamar como quiser.

---

```java
    return new OpenAPI()

```

- Cria uma nova instância da documentação OpenAPI.
- É aqui que você vai "montar" a configuração com `.info(...)`, `.servers(...)`, `.components(...)` etc.

---

```java
        .info(new Info()

```

- Define as **informações principais da API** usando a classe `Info`.

---

```java
            .title("Minha API Rest FULL")

```

- Define o **título da API** que aparecerá no topo do Swagger UI.

---

```java
            .description("API REALIZADA DURANTE A PÓS GRADUAÇÃO EM DESENVOLVIMENTO FULL STACK PELA DESCOMPLICA")

```

- Define a **descrição da API**, explicando seu propósito, contexto, projeto etc.

---

```java
            .version("1.0")

```

- Versão da API. Pode ser usada para versionamento futuro (ex: `"v2"`, `"1.0.1"`).

---

```java
            .termsOfService("Link_termos_uso")

```

- Link para os **termos de uso da API**, se aplicável.
- Pode ser uma URL ou string explicativa.

---

```java
            .contact(new Contact()
                .name("Vinicius")
                .url("https://github.com/ViniciusSXavier999")
                .email("seu@email.com"))

```

- Adiciona um **contato do responsável pela API**:
    - `name`: Nome da pessoa ou empresa
    - `url`: Link para GitHub, site, LinkedIn, etc.
    - `email`: Contato para suporte ou dúvidas

---

```java
            .license(new License()
                .name("Licença da API")
                .url("https://www.link-da-licenca.com")));

```

- Define a **licença da API**:
    - Pode ser `MIT`, `Apache 2.0`, `GPL`, etc.
    - `url`: link para o texto completo da licença

---

### 🧾 Em resumo:

Esse código personaliza a interface do Swagger UI com:

| Campo | Valor |
| --- | --- |
| Título | "Minha API Rest FULL" |
| Descrição | "API realizada durante a pós-graduação..." |
| Versão | "1.0" |
| Termos de uso | "Link_termos_uso" |
| Contato | Nome, GitHub e email de Vinicius |
| Licença | Nome e link para a licença da API |

---


### 4. AGORA VAMOS IMPLEMENTAR A SEGURANÇA NA NOSSA DOCUMENTAÇÃO

```java
private Components securityComponents() {
		return new Components()
				.addSecuritySchemes("bearerAuth", 
						new SecurityScheme()
						.type(SecurityScheme.Type.HTTP)
				.scheme("bearer")
				.bearerFormat("JWT")
				.in(SecurityScheme.In.HEADER)
				.name("Authorization"));
	}
```



### EXPLICAÇÃO DO CÓDIGO LINHA POR LINHA 🏆

### `private Components securityComponents() {`

- Método auxiliar que retorna um objeto `Components` com configurações de segurança.

### `return new Components()`

- Cria um novo container para registrar esquemas de segurança, headers, etc.

### `.addSecuritySchemes("bearerAuth", ... )`

- Adiciona um esquema de segurança chamado `"bearerAuth"` (esse nome será usado para aplicar a segurança nos endpoints).

### `new SecurityScheme()`

- Cria a definição do esquema de autenticação.

---

### `.type(SecurityScheme.Type.HTTP)`

- Informa que o tipo de segurança é via protocolo HTTP (em vez de `APIKEY`, `OAUTH2`, etc.).

### `.scheme("bearer")`

- Define que será usado o **esquema Bearer** — ou seja, tokens no estilo `"Bearer <seu-token>"`.

### `.bearerFormat("JWT")`

- Informa que o formato do token é **JWT (JSON Web Token)** — isso é apenas informativo para a UI.

### `.in(SecurityScheme.In.HEADER)`

- Indica que o token será enviado via **header HTTP**, e não como query param ou cookie.

### `.name("Authorization")`

- Define que o nome do header onde o token deve ser enviado é **`Authorization`** (ex: `Authorization: Bearer ey...`).

---

## ✅ Resultado prático:

- O Swagger UI vai exibir um botão "Authorize"
- Ele espera que o token JWT seja informado no campo `Authorization`
- Ao informar o token, ele será enviado em todas as requisições do Swagger

### POR FIM

```java
	private SecurityRequirement securityRequirement() {
		return new SecurityRequirement().addList("bearerAuth");
	}
```



### EXPLICAÇÃO DESSE TRECHO DE CÓDIGO 🏆

### ✅ Método:

```java
private SecurityRequirement securityRequirement() {
    return new SecurityRequirement().addList("bearerAuth");
}

```

---

### 🧠 O que ele faz:

- Cria uma **exigência de segurança** para o Swagger.
- Diz que todos os endpoints (ou os que você aplicar) **devem usar o esquema de segurança chamado `"bearerAuth"`**.
- `"bearerAuth"` é o nome que você definiu antes no método `securityComponents()`.

---

### 📌 Em outras palavras:

> Esse método instrui o Swagger a exigir um token JWT nos endpoints que usam esse esquema.
> 

---

### ✅ Exemplo prático:

Se o usuário clicar em **Authorize** e informar um token JWT, ele será enviado automaticamente no header `Authorization` de cada requisição protegida.

---

