# 2 → SPRING SECURITY

🏆 SPRING SECURITY é uma poderosa estrutura de autenticação e controle de acesso.

🏆 É o padrão de fato para proteger aplicativos baseados em Spring.




### SPRING SECURITY 🏆

Ele é um projeto completo que através dele podemos fazer:

- Autenticação de usuário
- Validação de usuário
- Cadastro de usuário
- Cadastro de funções

> Vamos usar apenas um exemplo do básico dele.
> 

🏆 Como todos os projetos do Spring, o verdadeiro poder do Spring Security é encontrado na facilidade com que ele pode ser estendido para atender aos requisitos da API.

🏆 Para habilitar o Spring Security, é necessário, além das dependências, criar a classe de configuração.


🏆 É nessa classe que definimos quais protocolos de autenticação, autorização, proteção e armazenamento serão utilizados.


---

## CONFIGURANDO O SPRING SECURITY

### 1. VAMOS ADICIONAR A DEPENDÊNCIA DO SPRING SECURITY NO POM.XML 🏆

O **OAuth2 Resource Server** no Spring tem **tudo a ver com o Spring Security** — ele é, na verdade, **um dos módulos de segurança** oferecidos pelo Spring Security.

---

## ✅ Resumo simples:

> O Spring Security OAuth2 Resource Server permite que sua aplicação aceite tokens de acesso OAuth2 (como JWTs) para proteger APIs — ou seja, só quem tem um token válido pode acessar determinados endpoints.
> 

---

## 🧠 Como isso se encaixa no Spring Security?

### Spring Security = "o guarda"

Ele é o **framework central** que cuida de autenticação e autorização em aplicações Spring.

### OAuth2 Resource Server = "o guarda que entende tokens"

É uma **extensão/função do Spring Security** que ensina esse "guarda" a **validar tokens OAuth2** (geralmente JWTs) enviados no header Authorization.

---

## 🧱 Estrutura de uma aplicação com OAuth2 Resource Server

Imagine uma arquitetura com 2 componentes:

### 1. Authorization Server (como o Keycloak, Auth0, ou Spring Authorization Server)

- Emite tokens (ex: JWTs)
- Autentica usuários

### 2. Resource Server (sua API protegida com Spring Boot)

- Recebe os tokens
- **Valida** os tokens com a ajuda do Spring Security OAuth2 Resource Server
- Permite ou nega acesso com base nas permissões contidas no token (roles, scopes, etc.)

---

## ✅ Como ativar no Spring Boot

### Dependência no `pom.xml` (se usa Maven):

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>

```

### Configuração no `application.yml`:

```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://seu-authorization-server.com/

```

Ou com `jwks-uri` se estiver usando chaves públicas diretamente.

---

### Classe de configuração (opcional):

```java
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt()
            );

        return http.build();
    }
}

```

---

## 🔐 Resultado

Com isso, o Spring Security:

- Verifica o token JWT no header `Authorization: Bearer <token>`
- Valida assinatura, tempo de expiração, emissor, etc.
- Extrai roles/scopes e usa para fazer controle de acesso

---

## ✅ Conclusão

**OAuth2 Resource Server é um recurso embutido no Spring Security** que permite proteger APIs com tokens JWT (ou outros formatos OAuth2).

Se você está construindo uma API que deve aceitar tokens emitidos por Keycloak, Auth0, ou outro servidor OAuth2, esse é o módulo que você deve usar.


```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>
```

🏆 Estamos criando uma autenticação de recurso já que o nosso servidor se trata dessa especificação.


### 2. VAMOS CRIAR UM NOVO PACKAGE CHAMADO ‘SECURITY’, TODAS NOSSAS CONFIGURAÇÕES DE SEGURANÇA SERÁ ADICIONADA NESSE PACOTE

```java
package com.example.demo.security;
```

### 3. VAMOS CRIAR A CLASSE QUE VAMOS IMPLEMENTAR AS CONFIGURAÇÕES NECESSÁRIAS

🚨 Durante a aula notei que alguns métodos do spring security estavam desatualizados no momento da gravação da aula, são eles csrf() e jwwt(), fui atrás de pesquisas e realizei a alteração no projeto com a forma mais recente e atualizada até então.


```java
package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .securityMatcher("/**") // escopo da segurança
	        .csrf(csrf -> csrf.disable()) // só configura CSRF
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/arquivos/upload").permitAll()
	            .anyRequest().authenticated()
	        )
	        .cors(Customizer.withDefaults()) // ou .cors(cors -> ...)
	        .httpBasic(Customizer.withDefaults()); // ou .httpBasic(httpBasic -> ...)

	    return http.build();
	}

}
```



### EXPLICAÇÃO LINHA POR LINHA DO CÓDIGO 🏆

```java
@EnableWebSecurity

```

- Ativa a **segurança web do Spring Security** para a aplicação.
- Essa anotação é necessária para que o Spring aplique a lógica de autenticação/autorização aos endpoints.

---

### 🔹 **Definição do filtro de segurança principal**

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

```

- Cria um **bean do tipo `SecurityFilterChain`**, que define as **regras de segurança** para a aplicação.
- `HttpSecurity` é a classe usada para configurar filtros, autenticação, CORS, CSRF, etc.

---

### 🔹 **securityMatcher("/**")**

```java
    http.securityMatcher("/**")

```

- Define que essa `SecurityFilterChain` se aplica a **todas as requisições da aplicação** (`/**`).
- Pode ser útil quando você tem múltiplas cadeias de segurança com escopos diferentes.

---

### 🔹 **csrf(csrf -> csrf.disable())**

```java
    .csrf(csrf -> csrf.disable())

```

- Desabilita **CSRF protection** (proteção contra falsificação de requisições).
- Isso é comum em **APIs REST** (não em aplicações web com sessões).
- CSRF só é necessário em contextos onde há **cookies com autenticação de sessão**.

---

### 🔹 **authorizeHttpRequests(auth -> {...})**

```java
    .authorizeHttpRequests(auth -> auth
        .requestMatchers("/arquivos/upload").permitAll()
        .anyRequest().authenticated()
    )

```

- Define regras de **autorização** por padrão:
    - `requestMatchers("/arquivos/upload").permitAll()` → qualquer um pode acessar essa rota (sem autenticação).
    - `anyRequest().authenticated()` → todas as outras requisições exigem autenticação.

---

### 🔹 **cors(Customizer.withDefaults())**

```java
    .cors(Customizer.withDefaults())

```

- Ativa o **CORS (Cross-Origin Resource Sharing)** com as **configurações padrão**.
- Isso permite que sua API aceite chamadas de outras origens (ex: frontend separado).
- Pode ser customizado com um `CorsConfigurationSource` bean, se necessário.

---

### 🔹 **httpBasic(Customizer.withDefaults())**

```java
    .httpBasic(Customizer.withDefaults());

```

- Ativa **autenticação HTTP Basic** (usuário/senha via header `Authorization`).
- O `Customizer.withDefaults()` aplica o comportamento padrão.
- Ideal apenas para testes, ou APIs internas — não recomendado para produção sem HTTPS.

---

### 🔹 **Finalização da cadeia de segurança**

```java
    return http.build();

```

- Constrói e retorna a `SecurityFilterChain`.
- Isso é necessário para o Spring aplicar as regras de segurança corretamente.

---

## ✅ Em resumo, o que esse código faz?

- Aplica regras de segurança a **todas as rotas**.
- Desativa CSRF (comum em APIs REST).
- Permite acesso **sem autenticação** a `/arquivos/upload`.
- Requer autenticação para qualquer outra rota.
- Habilita CORS padrão.
- Usa autenticação **HTTP Basic**.

---


---

---

### REALIZANDO TESTES NO POSTMAN

### 1. CONSEGUIMOS FAZER TRANQUILAMENTE O UPLOAD DE UM ARQUIVO PORQUE ESSE ENDPOINT FOR PERMITIDO NAS NOSSAS CONFIGURAÇÕS

### 2. JÁ QUANDO TENTAMOS FAZER UM DOWNLOAD, RECEBEMOS ERRO 401 “UNAUTHORIZED”, E ISSO ACONTECE COM TODOS OS OUTROS ENDPOINTS

---

## CONCLUSÃO

🏆 PODEMOS NOTAR QUE É MUITO FÁCIL UTILIZAR O SPRING SECURITY, A GENTE PROTEGEU TODOS ENDPOINTS, E LIBERAMOS APENAS 1.


---

### DÚVIDAS QUE TIVE DURANTE A AULA E FUI ATRÁS DE SOLUÇÃO

### O QUE SIGNIFICA “→” NOS MÉTODOS?

 O operador `->` no código `.csrf(csrf -> csrf.disable())` é uma **expressão lambda** em Java. Ele faz parte da **sintaxe de programação funcional** introduzida no Java 8.

---

## ✅ O que significa `csrf -> csrf.disable()`?

Essa é uma **função anônima** (lambda) que recebe um argumento chamado `csrf` e executa o método `disable()` sobre ele.

No contexto:

```java
.csrf(csrf -> csrf.disable())

```

- `csrf` é o nome de um parâmetro (você poderia chamar de `x` ou qualquer outro nome).
- O Spring está esperando um **objeto `Consumer<CsrfConfigurer>`**, ou seja, uma função que **recebe um `CsrfConfigurer` e não retorna nada**.
- O `>` separa o **parâmetro** da **implementação da função**.

---

## 🔍 Equivalente com classe anônima:

Esse código:

```java
.csrf(csrf -> csrf.disable())

```

É **equivalente a**:

```java
.csrf(new Consumer<CsrfConfigurer<HttpSecurity>>() {
    @Override
    public void accept(CsrfConfigurer<HttpSecurity> csrf) {
        csrf.disable();
    }
});

```

A versão lambda é só uma forma **mais enxuta** e **moderna** de fazer isso.

---

## ✅ Onde mais se usa isso?

Você verá essa sintaxe em várias partes da configuração de segurança moderna:

```java
.authorizeHttpRequests(auth -> auth
    .requestMatchers("/public").permitAll()
    .anyRequest().authenticated()
)

.cors(cors -> cors.disable())
.httpBasic(httpBasic -> httpBasic.realmName("Minha API"))

```

Cada uma dessas configurações recebe um "configurador" como parâmetro (tipo `Consumer<T>`) e você o configura dentro da lambda.

---

## ✅ Conclusão

O `->` em `.csrf(csrf -> csrf.disable())` é uma **expressão lambda** que representa uma **função simples e sem nome**. Nesse caso, ela diz ao Spring: “quando for configurar o CSRF, desative-o”.

Se quiser, posso te mostrar mais exemplos com lambdas em configurações Spring — ou até como evitar lambdas se você quiser usar estilo mais tradicional. Deseja isso?

### O QUE É CSRF?

 Entender o que é **CSRF** (Cross-Site Request Forgery) é essencial quando se trabalha com segurança de aplicações web.

---

## 🛡️ O que é CSRF?

> CSRF (Cross-Site Request Forgery) é um tipo de ataque onde um site malicioso engana o navegador do usuário logado para executar ações indesejadas em um site onde ele já está autenticado (por exemplo, uma transferência bancária, exclusão de conta, etc).
> 

---

### 🔍 Exemplo simples:

Imagine que você está **logado no seu banco** em uma aba do navegador, e ao mesmo tempo você visita um **site malicioso** em outra aba. Esse site pode tentar **enviar uma requisição “em seu nome”** para a API do banco, como:

```html
<form action="https://banco.com/transferencia" method="POST">
  <input type="hidden" name="valor" value="1000">
  <input type="hidden" name="destino" value="hacker">
  <input type="submit">
</form>

<script>
  document.forms[0].submit();
</script>

```

Como você **já está autenticado no banco**, o navegador envia automaticamente **cookies de sessão** junto com a requisição, e o banco pode pensar que foi você quem fez essa ação.

---

## ✅ Como o Spring protege contra CSRF?

Por padrão, o **Spring Security habilita proteção contra CSRF** para requisições **com efeitos colaterais** (como `POST`, `PUT`, `DELETE`).

Ele faz isso exigindo um **token CSRF** em cada requisição dessas. Esse token:

- É gerado pelo servidor
- É enviado ao cliente (ex: em um campo hidden do HTML)
- Deve ser enviado de volta na requisição (ex: header ou corpo)

Se o token **não estiver presente ou for inválido**, a requisição é **bloqueada**.

---

### Exemplo: com CSRF habilitado

```
POST /transferencia HTTP/1.1
Host: banco.com
Cookie: JSESSIONID=abc123
X-CSRF-TOKEN: xyz789

{ "valor": 1000, "destino": "hacker" }

```

Sem o header `X-CSRF-TOKEN`, a requisição é rejeitada.

---

## ❌ Quando você pode desativar CSRF?

Em APIs REST **sem uso de cookies de sessão** (por exemplo, APIs que usam **JWT ou OAuth2 Bearer Token**), a proteção CSRF **não é necessária**, porque o ataque CSRF depende de o navegador **enviar automaticamente os cookies**.

Por isso é comum ver:

```java
http.csrf(csrf -> csrf.disable());

```

---

## ✅ Conclusão

- **CSRF** é um ataque que abusa da confiança do navegador para enviar requisições não autorizadas.
- O **Spring Security protege automaticamente** contra isso com um token CSRF.
- Em APIs REST **sem sessão via cookie**, você pode desabilitar CSRF com segurança.

