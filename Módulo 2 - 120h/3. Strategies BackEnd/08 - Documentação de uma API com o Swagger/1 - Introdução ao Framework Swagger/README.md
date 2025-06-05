# 1 → INTRODUÇÃO AO FRAMEWORK SWAGGER

🏆 OpenAPI Specification (Anteriormente Swagger Specification) é um formato de descrição de API para APIs REST.


🏆 Da mesma forma que temos um padrão para documentar uma API RESTFULL, também vamos ter um padrão para documentar as nossas APIs.


### Um arquivo OPENAPI permite que você descreva toda a sua API, incluindo:

<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/swagger1.png" />


🏆 SWAGGER é um conjunto de ferramentas de código aberto criadas em torno da especificação OPENAPI que pode ajudá-lo a projetar, construir, documentar e consumir APIs REST.

> É possível consumir APIs, para quem está querendo conhecer uma nova API, ao invés de realizar todas as configurações passo a passo no postman, basta somente consumir essa API utilizando o SWAGGER e realizar as requisições necessárias.
> 

### AS PRINCIPAIS FERRAMENTAS DO SWAGGER SÃO:

<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/swagger2.png" />


> VAMOS UTILIZAR MAIS O SWAGGER UI 🏆
> 

---

### VAMOS INICIAR COM A IMPLEMENTAÇÃO DO SWAGGER NO PROJETO

💡 Para garantir compatibilidade com o Spring Boot 3, é importante utilizar o Springdoc OpenAPI na versão 2 ou superior. Versões anteriores não são compatíveis com o novo modelo Jakarta EE


### 1. PRIMEIRO VAMOS ADICIONAR A DEPENDÊNCIA NECESSÁRIA PARA UTILIZAR O SWAGGER

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.8</version>
</dependency>

```

💡 Eu não estava conseguindo acessar a url do swagger através do navegador por conta da minha classe de security config, onde foi necessário liberar a permissão para os caminhos específicos que eu gostaria de acessar.


### URLs PARA VERIFICAR SE O SWAGGER ESTÁ FUNCIONANDO CORRETAMENTE

```tsx
http://localhost:8080/swagger-ui/index.html
```

ou

```tsx
http://localhost:8080/v3/api-docs
```

### 2. VAMOS CRIAR UMA CLASSE DE UMA CONFIGURAÇÃO BÁSICA PARA NOSSA DOCUMENTAÇÃO NO SWAGGER (NÃO OBRIGATÓRIO)

### VERSÃO ANTIGA UTILIZADA NO SPRING BOOT 2.X

```java
@Bean
	public Docket api() {
		return new Docket(DocmentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSeelctors.any())
				.build();
	}
```



### EXPLICAÇÃO DO CÓDIGO LINHA POR LINHA Springfox Swagger com `Docket` 💡

```java
java
CopiarEditar
@Bean
public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)      // 1
            .select()                                   // 2
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))  // 3
            .paths(PathSelectors.any())                 // 4
            .build();                                  // 5
}

```

### Explicação linha a linha

1. `new Docket(DocumentationType.SWAGGER_2)`
    
    Cria um objeto `Docket`, que é a configuração principal do Swagger, definindo que o tipo da documentação será a versão Swagger 2.
    
2. `.select()`
    
    Inicia o builder para selecionar quais endpoints REST serão expostos na documentação.
    
3. `.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))`
    
    Filtra os endpoints para incluir **apenas as classes anotadas com `@RestController`**. Isso evita documentar classes que não sejam controladores REST.
    
4. `.paths(PathSelectors.any())`
    
    Permite que **todos os caminhos (paths) dos endpoints** sejam incluídos na documentação.
    
5. `.build()`
    
    Constrói o objeto `Docket` com as configurações especificadas.
    

### VERSÃO ATUALIZADA SPRING BOOT 3+

```java
@Bean
public OpenAPI customOpenAPI() {
    return new OpenAPI()                                      // 1
        .info(new Info()                                      // 2
            .title("Minha API")                               // 3
            .version("1.0")                                   // 4
            .description("Documentação gerada pelo SpringDoc OpenAPI")); // 5
}

```



### EXPLICAÇÃO DO CÓDIGO LINHA POR LINHA 💡

### Explicação linha a linha

1. `new OpenAPI()`
    
    Cria o objeto principal da especificação OpenAPI (versão 3), que conterá informações da API.
    
2. `.info(new Info())`
    
    Define o bloco de metadados da API.
    
3. `.title("Minha API")`
    
    Define o título da API que aparecerá na documentação.
    
4. `.version("1.0")`
    
    Define a versão da API.
    
5. `.description("Documentação gerada pelo SpringDoc OpenAPI")`
    
    Adiciona uma descrição resumida da API.
    

### OPÇÃO COM FILTRO DE PACOTES USANDO GroupedOpenApi

```java
@Bean
public GroupedOpenApi api() {
    return GroupedOpenApi.builder()                           // 1
        .group("minha-api")                                  // 2
        .packagesToScan("com.seu.pacote.controllers")       // 3
        .build();                                            // 4
}

```



### EXPLICAÇÃO DO CÓDIGO LINHA POR LINHA 💡

### Explicação linha a linha

1. `GroupedOpenApi.builder()`
    
    Cria um builder para definir um grupo de endpoints na documentação (útil para organizar APIs).
    
2. `.group("minha-api")`
    
    Define um nome para o grupo da API (pode ser útil para múltiplas versões ou módulos).
    
3. `.packagesToScan("com.seu.pacote.controllers")`
    
    Filtra os controladores REST que devem ser incluídos, buscando apenas as classes dentro desse pacote específico.
    
4. `.build()`
    
    Constrói o objeto `GroupedOpenApi` com as configurações definidas.
    

### CASO DÊ ERRO, COLOCAR A SEGUINTE LINHA NO APPLICATION PROPERTIES

```java
spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER
```

💡 Essa propriedade define **qual estratégia de correspondência de rotas (paths)** o Spring MVC vai usar para encontrar qual método do controller deve ser chamado para uma determinada requisição HTTP.

---

### Contexto das estratégias de matching no Spring MVC

- **ANT_PATH_MATCHER**:
    
    É a estratégia **clássica e antiga** do Spring para casar URLs, baseada em padrões do tipo `ant` — como `/**`, `/*.html`, `/users/*`, etc.
    
    Exemplo: `/api/users/*` casa `/api/users/123` e `/api/users/abc`.
    
- **PATH_PATTERN_PARSER**:
    
    É a estratégia **nova, mais rápida e eficiente**, introduzida no Spring Framework 5.3+. Usa um parser de padrões diferente e oferece melhor performance, além de suporte a features extras.
    

---

## Por padrão, qual estratégia é usada?

- Em versões **mais antigas** do Spring Boot (antes da 2.6), a padrão é o **ANT_PATH_MATCHER**.
- A partir do **Spring Boot 2.6**, o padrão mudou para o **PATH_PATTERN_PARSER**.

---

## É necessário usar `spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER` nas versões atuais?

- **Normalmente, NÃO**.
    
    O Spring Boot 3 já usa o **PATH_PATTERN_PARSER** como padrão, que é recomendado para a maioria dos casos, por ser mais performático.
    
- **Você só precisa usar o ANT_PATH_MATCHER se:**
    - Seu projeto tem alguma dependência, configuração ou código que depende exclusivamente do matcher antigo.
    - Alguma biblioteca ou framework que você usa não é compatível com o novo padrão.
    - Quer manter comportamento exatamente igual ao antigo por alguma razão de compatibilidade.

---

## Em resumo:

| Propriedade | O que faz | Usar quando? |
| --- | --- | --- |
| `spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER` | Usa a estratégia antiga de path matching (ant style) | Só se precisar compatibilidade com código legado ou bibliotecas que exigem isso |
| (padrão) `spring.mvc.pathmatch.matching-strategy=PATH_PATTERN_PARSER` | Usa a nova estratégia moderna, mais rápida e com mais recursos | Para novos projetos e recomendada para a maioria dos casos |

---

Se estiver começando um projeto novo com Spring Boot 3, deixe a configuração **sem essa propriedade** e use o padrão atual (PATH_PATTERN_PARSER). Se tiver algum problema com roteamento, aí sim avalie usar o ANT_PATH_MATCHER.

