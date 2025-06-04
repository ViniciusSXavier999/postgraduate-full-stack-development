# 4 → AUTENTICAÇÃO JWT

✅ Está tudo pronto para utilizarmos o Auth token, basta agora configuramos o restante da nossa API


---


🏆 JWT ou JSON WEB TOKENS (RFC 7519) é um padrão, em grande parte, usado para a segurança em APIs REST.

> A maioria das APIs usam JWT para realizar suas autenticações
> 

🏆 O JWT gera tokens de acesso para autenticar um usuário na aplicação.


🏆 O token também pode armazenar funções de usuário e autorizar as solicitações com base na autoridade fornecida.


<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/JWT1.png" />

1 → Esta sendo feita uma autenticação com usuário e senha

2 → O servidor valida o usuário e a senha e gera o JWT usando a chave secreta

3 → RETORNA o JWT gerado

4 → Esta sendo feito um GET com o JWT sendo passado no HEADER

5 → **validar JWT usando chave secreta**

🏆 Essa primeira parte a gente fez na ultima aula que era buscar um token no auth0



### PRÓXIMOS PASSOS 🏆

- VAMOS PEGAR AQUELE TOKEN
- COLOCAR ELE NAS REQUISIÇÕES QUE ESTÃO PROTEGIDAS
- SE O TOKEN TIVER CERTO VAMOS CONCLUIR A AUTENTICAÇÃO

---

### REALIZANDO CONFIGURAÇÕES NECESSÁRIAS NO PROJETO

### 1. VAMOS PRECISAR ADICIONAR VÁRIAVEIS DE AMBIENTE PARA QUE A GENTE CONSIGA AUTENTICAR UTILIZANDO O TOKEN

NO APPLICATION PROPERTIES DO NOSSO PROJETO VAMOS ADICIONAR AS SEGUINTES VÁRIAVEIS DE AMBIENTE

```java
auth0.audience=https://strategies_pos_backend/api
spring.security.oauth2.resourceserver.jwt.issuer-uri=https://dev-mei87f8ygl73l03v.us.auth0.com/
```

🏆 spring.security.oauth2.resourceserver.jwt.issuer-uri → VAMOS ACHAR ESSE VALOR EM:

- APPLICATIONS
- APIs
- SELECIONAR A SUA API
- QUICK START

### 2. VAMOS CRIAR UMA CLASSE PARA VALIDAR O NOSSO IDENTIFICADOR UNICO LÁ DO AUTH0

🏆 Essa classe é responsável por validar o nosso identificador do AUTH0. 

Dentro da plataforma do AUTH0 nós podemos ter várias APIs, esse método nessa classe valida se o nosso identificador ele está batendo com o valor que colocamos no application.properties, dessa forma eu consigo linkar o meu projeto com a minha API do AUTH0.

> Serve também para que um usuário não use uma API usando a identificação de outra.
> 

```java
package com.example.demo.security;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

// CLASSE RESPONSÁVEL PELA VALIDAÇÃO DO IDENTIFICADOR UNICO DO AUTH0

public class AudienceValidator {

	private final String audience;

	public AudienceValidator(String audience) {
		this.audience = audience;
	}

	public OAuth2TokenValidatorResult validate(Jwt jwt) {
		if (jwt.getAudience().contains(audience)) {
			return OAuth2TokenValidatorResult.success();
		}
		return OAuth2TokenValidatorResult
				.failure(new OAuth2Error("invalid_token", "Token não tem audience válida", null));
	}

}
```



### EXPLICANDO O CÓDIGO LINHA POR LINHA 🏆

### 🔍 Classe completa:

```java
public class AudienceValidator {

    private final String audience;

    public AudienceValidator(@Value("${auth0.audience}") String audience) {
        this.audience = audience;
    }

    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        if (jwt.getAudience().contains(audience)) {
            return OAuth2TokenValidatorResult.success();
        }
        return OAuth2TokenValidatorResult
            .failure(new OAuth2Error("invalid_token", "Token não tem audience válida", null));
    }
}

```

---

## 🧠 Explicação linha por linha:

---

```java
public class AudienceValidator {

```

→ Declara uma classe pública chamada `AudienceValidator`.

Ela será usada para validar se o **JWT recebido** tem a **audience correta**.

---

```java
private final String audience;

```

→ Cria um campo `audience`, que vai armazenar o **valor esperado da audience**, vindo do `application.yml`.

---

```java
public AudienceValidator(@Value("${auth0.audience}") String audience) {

```

→ Construtor da classe. O valor de `${auth0.audience}` (configurado no `application.yml`) será injetado aqui.

---

```java
this.audience = audience;

```

→ Armazena o valor recebido no campo `audience` da classe.

---

```java
public OAuth2TokenValidatorResult validate(Jwt jwt) {

```

→ Método de validação do token JWT.

Esse método é chamado automaticamente pelo Spring Security ao receber um token.

---

```java
if (jwt.getAudience().contains(audience)) {

```

→ Verifica se a audience do token (claim `aud`) **contém o valor esperado**.

O `aud` pode ser uma lista, então usamos `.contains(...)`.

---

```java
return OAuth2TokenValidatorResult.success();

```

→ Se o token for destinado à API correta, a validação passa com sucesso.

---

```java
return OAuth2TokenValidatorResult.failure(
    new OAuth2Error("invalid_token", "Token não tem audience válida", null));

```

→ Se a audience estiver incorreta, retorna uma **falha de validação**, dizendo que o token é inválido.

---

## ✅ Resumo da função da classe:

> Garante que o token JWT recebido foi realmente emitido para essa API, validando a claim aud (audience).
> 
> 
> Isso evita que sua API aceite tokens destinados a outros serviços.
> 

---


### 3. VAMOS PRECISAR ADICIONAR UMA VALIDAÇÃO DO NOSSO TOKEN PARA SABER SE ELE É VALIDO OU NÃO, AS MODIFICAÇÕES VÃO SER FEITAS NA CLASSE SECURITYCONFIG

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Value("${auth0.audience}")
	private String audience;

	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
	private String issuer;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/**") // escopo da segurança
				.csrf(csrf -> csrf.disable()) // só configura CSRF
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/arquivos/upload").permitAll().anyRequest().authenticated())
				.cors(Customizer.withDefaults()) // ou .cors(cors -> ...)
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.decoder(jwtDecoder())) // ← Adicionamos suporte ao
																								// token JWT do Auth0

				);
		return http.build();
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		NimbusJwtDecoder decoder = JwtDecoders.fromIssuerLocation(issuer);

		OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator (audience);
		OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
		OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

		decoder.setJwtValidator(withAudience);
		return decoder;
	}

}
```

---

## REALIZANDO TESTES NO POSTMAN

### 1. PRIMEIRO VAMOS GERAR UM NOVO TOKEN

### 2. COPIAR ELE(SEM ASPAS)

### 3. VAMOS TESTAR O ENDPOINT DE UPLOAD QUE ATÉ ENTÃO ERA O UNICO LIBERADO

### 4. VAMOS TESTAR O ENDPOINT DE DOWNLOAD E ELE NÃO ESTÁ FUNCIONANDO POIS ESTÁ DANDO “UNAUTHORIZED”


### PASSO A PASSO PARA FUNCIONAR 🏆

- VAMOS IR EM “Authorization”
- VAMOS SELECIONAR “Bearer token”
- E DEPOIS COLAR O VALOR DAQUELE TOKEN

### PODEMOS VERIFICAR QUE LIBEROU O ACESSO AO FUNCIONAMENTO DO ENDPOINT

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/JWT2.png" />


🏆 Precisaremos fazer isso para todos os endpoints da nossa API


---

---

## DÚVIDAS E DICAS

🏆 LINK PARA A DOCUMENTAÇÃO QUE TEM O PASSO A PASSO PARA A IMPLEMENTAÇÃO DO AUTH0 NO PROJETO 

[Auth0 Spring Boot API SDK Quickstarts: Add Authorization to Your Spring Boot Application](https://auth0.com/docs/quickstart/backend/java-spring-security5/interactive)


### 1. OUTRAS FORMAS COMUNS DE GERAR E PEGAR UM TOKEN EM SUA APLICAÇÃO

Existem **outras formas comuns e robustas** de gerar e pegar um token (como um JWT) em sua aplicação, especialmente se você estiver usando **Spring Boot** ou outra stack backend.

---

## ✅ Formas alternativas de gerar tokens (sem Auth0)

### 1. **Implementar autenticação com Spring Security + JWT**

Você pode criar sua própria API de login que:

- Recebe e valida credenciais (ex: e-mail e senha)
- Gera um **JWT assinado**
- Retorna o token ao usuário

### 🔧 Fluxo típico:

1. O usuário envia `email` e `senha` via `POST /login`
2. O backend verifica os dados
3. Se válido, gera um JWT com `java-jwt`, `jjwt` ou outra lib
4. Envia o token na resposta
5. O cliente usa esse token no header `Authorization: Bearer <token>` nas próximas requisições

### 🛠️ Exemplo de código (simplificado):

```java
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest request) {
    // Verifica usuário e senha
    if (authService.validar(request)) {
        String token = jwtService.gerarToken(request.getUsername());
        return ResponseEntity.ok(new TokenResponse(token));
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

```

---

### 2. **Usar Keycloak (self-hosted ou em nuvem)**

- É uma **plataforma de identidade de código aberto**.
- Fornece login, cadastro, OAuth2, OpenID Connect e gera tokens JWT automaticamente.
- Você pode hospedar localmente ou usar como container Docker.

🔐 É como um "Auth0 gratuito e local".

---

### 3. **Usar Firebase Authentication (Google)**

- Se sua aplicação está no ecossistema do Firebase (mobile/web), o **Firebase Auth** fornece login com email/senha, Google, Facebook etc.
- Ele gera e gerencia tokens JWT para você.

---

### 4. **Usar outras bibliotecas/frameworks**

Você pode usar libs em qualquer linguagem para gerar e validar JWTs:

| Linguagem | Lib comum para JWT |
| --- | --- |
| Java | `jjwt`, `java-jwt` |
| Node.js | `jsonwebtoken` |
| Python | `PyJWT`, `Authlib` |
| PHP | `firebase/php-jwt` |

---

### ⚠️ Cuidados importantes ao gerar seu próprio token:

- Sempre **assine o JWT com uma chave secreta forte**
- Configure um **tempo de expiração (exp)** curto
- **Nunca coloque dados sensíveis dentro do token** (JWT é legível!)
- Sempre valide o token no backend antes de aceitar requisições protegidas

---

### 🧠 Em resumo:

| Método | Gera Token JWT? | Hospedagem | Ideal para... |
| --- | --- | --- | --- |
| Spring Security + JWT | ✅ | Sua app | Controle total do login/token |
| Keycloak | ✅ | Local/nuvem | Solução robusta de identidade |
| Firebase Auth | ✅ | Google | Apps web/mobile com login social |
| Bibliotecas (PyJWT etc.) | ✅ | Sua app | Projetos simples com login próprio |

---

### 2. FORMA SIMPLES E ATUALIZADA DE INTEGRAR O AUTH0 COM SPRING BOOT(NOSSA APLICAÇÃO)

C**omo integrar o Auth0 com Spring Boot**, consumindo o **token JWT fornecido por Auth0** para proteger suas rotas.

## ✅ Objetivo:

- Usuário faz login no Auth0 (por login social, senha, etc.)
- Auth0 retorna um **JWT (Access Token)**
- Esse token é enviado pelo cliente nas requisições à sua **API Spring Boot**
- Sua API **valida o token** e **permite ou bloqueia** o acesso às rotas protegidas

---

## 🧱 Tecnologias envolvidas:

- **Spring Boot 3.x**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Auth0 como servidor de autenticação (OAuth2 / OIDC)**

---

## 📦 Dependências no `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
</dependencies>

```

---

## ⚙️ Configurações no `application.yml`:

```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://SEU_DOMINIO.auth0.com/

```

🔐 Substitua `SEU_DOMINIO` pelo domínio da sua conta no Auth0. Exemplo:

```yaml
issuer-uri: https://meu-app.auth0.com/

```

---

## 🔐 Security Configuration (Spring Security):

A partir do Spring Boot 3, você pode configurar com o `SecurityFilterChain`:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt(Customizer.withDefaults())
            );
        return http.build();
    }
}

```

---

## ✅ Resultado:

- Sua API agora aceita **Access Tokens JWT emitidos pelo Auth0**.
- O token precisa ser enviado pelo cliente no header:

```
Authorization: Bearer <access_token>

```

---

## 🧪 Testando com Postman:

1. Faça login via Auth0 (pela sua aplicação frontend ou via Postman, usando o client credentials flow, por exemplo)
2. Pegue o `access_token` retornado
3. Envie esse token para sua API:

```
GET /api/privada
Authorization: Bearer eyJhbGciOi...

```

---

## 🔍 (Opcional) Validando escopos/permissões:

Você pode proteger endpoints com base em escopos:

```java
.authorizeHttpRequests(auth -> auth
    .requestMatchers("/admin/**").hasAuthority("SCOPE_admin")
    .anyRequest().authenticated()
)

```

Lembre-se de configurar os escopos corretamente no painel do Auth0 e atribuí-los ao token.

---

## 🎯 Conclusão

Com essa configuração:

- Você **não precisa validar o JWT manualmente**
- O **Spring Security faz tudo para você**
- O Auth0 é usado apenas para **emissão de tokens**
- Você foca apenas em proteger suas APIs com base nas claims do token

---

### 3. FIQUEI COM DÚVIDA REFERENTE SE NÃO ERA MAIS NECESSÁRIO CRIAR A CLASSE “AudienceValidator”

A necessidade de criar uma **classe `AudienceValidator`** em integrações com **Auth0 + Spring Security** era comum nas versões anteriores do Spring Boot (principalmente < 2.7), mas **com Spring Boot 3.x**, isso geralmente **não é mais necessário**, **desde que você configure corretamente o `issuer-uri` no `application.yml`**.

---

### ✅ Por que **antes** precisávamos do `AudienceValidator`?

Auth0 inclui no JWT um campo chamado **`aud` (audience)** — que indica **quem pode usar o token**.

Se a sua API não verificasse corretamente esse valor, poderia aceitar tokens que **não eram destinados à sua API**, o que é uma falha de segurança.

O Spring Security, por padrão, **não validava o `aud`**, então você precisava escrever um `AudienceValidator` personalizado.

---

### ✅ Por que **hoje** pode não ser necessário?

A partir do **Spring Boot 2.7+ e Spring Security 5.7+**, com o uso da propriedade:

```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://seu-dominio.auth0.com/

```

O Spring faz automaticamente:

- O download do `.well-known/openid-configuration`
- A validação de:
    - Assinatura do token
    - Tempo de expiração
    - **Issuer**
    - Chaves públicas do Auth0 (JWK Set)

👉 **A validação do `aud` não é automática**, mas **pode ser desnecessária**, **caso você tenha controle de quem emite e consome os tokens**, ou **configure corretamente o Auth0 para emitir tokens só com a audience certa**.

---

## 🔐 Quando você *ainda precisa* do `AudienceValidator`?

Se você estiver usando **várias APIs** com o mesmo Auth0 ou **clientes externos** enviando tokens com audiences incorretas, então **sim**, vale a pena garantir isso.

---

## ✅ Exemplo moderno de `AudienceValidator` (se precisar):

```java
@Component
public class AudienceValidator implements OAuth2TokenValidator<Jwt> {

    private final String audience;

    public AudienceValidator(@Value("${auth0.audience}") String audience) {
        this.audience = audience;
    }

    @Override
    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        if (jwt.getAudience().contains(audience)) {
            return OAuth2TokenValidatorResult.success();
        }
        return OAuth2TokenValidatorResult.failure(
            new OAuth2Error("invalid_token", "Token não tem audience válida", null)
        );
    }
}

```

E registre isso na sua config:

```java
@Bean
JwtDecoder jwtDecoder(@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}") String issuer,
                      AudienceValidator audienceValidator) {
    NimbusJwtDecoder jwtDecoder = JwtDecoders.fromIssuerLocation(issuer);
    jwtDecoder.setJwtValidator(
        new DelegatingOAuth2TokenValidator<>(JwtValidators.createDefaultWithIssuer(issuer), audienceValidator)
    );
    return jwtDecoder;
}

```

---

## 🔍 Em resumo:

| Situação | Precisa de `AudienceValidator`? |
| --- | --- |
| Você tem **1 API**, **1 audience**, tokens vêm do seu frontend | ❌ Não precisa |
| Você tem múltiplas APIs ou terceiros mandando tokens | ✅ Sim, é recomendado validar o `aud` |

---

### 4. EU TINHA ME ESQUECIDO O QUE ERA O ARQUIVO .yaml

 O arquivo `application.yml` (ou `application.properties`) é o **arquivo de configuração principal** de uma aplicação Spring Boot. Ele define propriedades como portas, conexões de banco, configurações de segurança, etc.

---

## 📂 Onde fica o `application.yml`?

### 🧭 Localização padrão:

```
src/main/resources/application.yml

```

### 📁 Exemplo de estrutura do projeto:

```
seu-projeto/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/seu/pacote/
│       └── resources/
│           ├── application.yml   ← 🔹 Aqui!
│           └── other-files...
├── pom.xml

```

---

## 📝 Alternativas:

### 1. `application.properties`

Se você preferir o formato `.properties`, o Spring também aceita:

```
src/main/resources/application.properties

```

Equivalente:

```
spring.security.oauth2.resourceserver.jwt.issuer-uri=https://seu-dominio.auth0.com/

```

---

## ✅ Boas práticas:

- Mantenha apenas **um `application.yml` por ambiente** ou use perfis (como `application-dev.yml`, `application-prod.yml`) se quiser separar configs.
- Nunca coloque segredos como `client_secret` diretamente no YAML. Use variáveis de ambiente.

---

Se você ainda não tem o arquivo, pode **criar um novo `application.yml`** dentro de `src/main/resources`.

---

### 5. O QUE É JWT DECODER?

## 🔍 O que é o **JwtDecoder**?

O `JwtDecoder` é um **componente do Spring Security** responsável por:

### ✅ **Decodificar**, **validar** e **analisar** tokens JWT recebidos nas requisições.

---

### 📦 O que ele faz exatamente?

Quando sua API recebe um JWT (por exemplo, no cabeçalho `Authorization: Bearer ...`), o `JwtDecoder` faz:

1. **Decodifica** o JWT (ele é só um texto Base64 dividido em 3 partes).
2. **Verifica a assinatura** usando a chave pública (no caso do Auth0, via JWK).
3. **Valida as claims** (expiração, issuer, audience, etc.).
4. **Converte o token em um objeto `Jwt`** que pode ser usado pela segurança do Spring.

---

### ⚙️ Como o Spring usa?

Quando você configura isso no seu `application.yml`:

```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://seu-dominio.auth0.com/

```

O Spring:

- Cria um `JwtDecoder` automaticamente com base no `issuer-uri`
- Usa esse decoder para validar os tokens recebidos
- Extrai as informações (como `sub`, `scope`, `email`, etc.) para aplicar segurança na sua API

---

## 🧠 Exemplo interno do que o Spring faz com o `JwtDecoder`

Internamente, o Spring faz algo como:

```java
JwtDecoder jwtDecoder = JwtDecoders.fromIssuerLocation("https://seu-dominio.auth0.com/");

```

E depois:

```java
Jwt jwt = jwtDecoder.decode(tokenRecebido);

```

---

## 🔐 Personalização (com AudienceValidator)

Se quiser adicionar uma validação personalizada (como o `audience`), você pode criar e configurar o seu próprio `JwtDecoder` assim:

```java
@Bean
public JwtDecoder jwtDecoder(
        @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}") String issuer,
        AudienceValidator audienceValidator) {

    NimbusJwtDecoder decoder = JwtDecoders.fromIssuerLocation(issuer);
    OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
    OAuth2TokenValidator<Jwt> validator = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);
    decoder.setJwtValidator(validator);

    return decoder;
}

```

---

## ✅ Resumo:

| Termo | O que é |
| --- | --- |
| `JwtDecoder` | Componente que **lê, valida e interpreta JWTs** |
| Para que serve? | Para garantir que apenas tokens válidos entrem na sua API |
| Quem fornece? | O Spring Security OAuth2 (configurado via YAML ou Java) |

---

### 6. DIFERENÇA DE USAR A VERSÃO SIMPLES(SEM O AUDIENCE VALIDATOR) E A VERSÇÃO COMPLETA DA CONFIGURAÇÃO DO SPRING SECURITY COM O AUTH0

---

## ✅ Esse código funciona?

**Sim.** Ele é uma forma mais **simples e direta** de configurar o Spring Security para proteger endpoints e aceitar **tokens JWT** via o recurso `oauth2ResourceServer`.

---

## 🔍 Diferença entre os dois códigos

| Item | Versão simples (`Customizer.withDefaults()`) | Versão completa (com `jwtDecoder()`) |
| --- | --- | --- |
| Valida token JWT do Auth0? | ✅ Sim (se `issuer-uri` estiver no `application.yml`) | ✅ Sim |
| Valida assinatura, expiração, issuer? | ✅ Sim | ✅ Sim |
| Valida `audience` (claim `aud`)? | ❌ **Não valida audience por padrão** | ✅ **Valida audience com `AudienceValidator`** |
| Personalização do token | ❌ Não permite | ✅ Permite customização (roles, escopos, etc.) |
| Melhor para produção? | ❌ Parcial | ✅ Sim, mais seguro e flexível |

---

### ✅ Quando usar a versão **simples**?

Use quando:

- Está testando localmente ou prototipando
- Confia que os tokens **não terão problemas de audience**
- Quer uma configuração mínima e rápida

---

### ✅ Quando usar a versão **completa**?

Use quando:

- Está em produção
- Precisa validar `audience`
- Quer segurança mais robusta e controle sobre o que o token carrega

---

## 📌 Lembre-se:

Mesmo na versão **simples**, o Spring **ainda depende da config correta do `issuer-uri` no `application.yml`** para funcionar com tokens do Auth0.

```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://SEU_DOMINIO.auth0.com/

```

---

## ✅ Conclusão:

| Se você... | Use... |
| --- | --- |
| Está apenas testando ou prototipando | `Customizer.withDefaults()` |
| Vai para produção ou expõe dados sensíveis | `jwtDecoder()` com `AudienceValidator` |

---

### 7. QUEM É O CLIENT?

## ✅ **Quem é o "client"?**

### Depende da perspectiva:

---

### 🟢 **No fluxo de autenticação (OAuth2 / Auth0):**

- **O "client" é a aplicação que pede o token ao Auth0.**

### Exemplo:

- Postman, frontend em React, ou backend em Spring Boot → todos podem ser um **OAuth2 client**.
- Eles mandam uma requisição para o Auth0 para obter um **access token**.

> 🔑 Auth0 é o servidor de autorização (Authorization Server).
> 
> 
> 🧑‍💻 **Postman ou sua aplicação é o client (Client Application)**.
> 

---

### 🟠 **Quando você está testando no Postman:**

- O **Postman age como client**, fazendo a requisição HTTP com um token no header.
- Esse token foi emitido antes (geralmente pelo Auth0).

### Ou seja:

- Postman não é o **emissor** do token.
- Postman é o **cliente que consome a API protegida**, enviando o token junto.

---

### 🟥 **Auth0 nunca é o client.**

- O Auth0 é o **Authorization Server**.
- Ele é responsável por:
    - Autenticar o usuário
    - Emitir tokens (`access_token`, `id_token`)
    - Validar credenciais
    - Aplicar regras de segurança

---

## 📌 Resumo:

| Papel | Quem é? |
| --- | --- |
| **Client** | Postman, React App, Spring App (quem consome a API e pede o token) |
| **Auth Server** | Auth0 |
| **API Resource** | Sua API em Spring Boot (que valida o token recebido) |

---

### 8. O QUE É UMA “CLAIM”?

## ✅ O que é uma **claim** no JWT?

**"Claim"** (em português: *declaração*) é **uma informação embutida no token JWT**.

Cada claim é uma **chave/valor** que carrega dados sobre o usuário, o token ou as permissões.

---

### 🎯 Exemplos comuns de claims:

```json
{
  "sub": "1234567890",
  "name": "João",
  "exp": 1717012345,
  "iss": "https://seu-dominio.auth0.com/",
  "aud": "https://sua-api.com/api"
}

```

| Claim | Significado |
| --- | --- |
| `sub` | ID do usuário |
| `name` | Nome do usuário |
| `exp` | Expiração do token (timestamp) |
| `iss` | Emissor do token (issuer) |
| `aud` | **Audience** — para quem o token é válido ✔️ |

---

## 🧩 E o que o **AudienceValidator** faz com isso?

Ele verifica a **claim `aud` (audience)** no token, para garantir que o token **foi emitido para a sua API**.

---

### ✅ Exemplo:

Se no `application.yml` você configurou:

```yaml
auth0:
  audience: https://minha-api.com/api

```

E o token recebido contém:

```json
"aud": ["https://minha-api.com/api"]

```

Então a validação passa.

Se vier com outro audience (ex: de outra aplicação), a validação **falha** — protegendo sua API contra o uso de tokens que não foram destinados a ela.

---

## 📌 Resumo:

> A claim aud (audience) diz para quem o token foi criado.
> 
> 
> O `AudienceValidator` verifica se essa claim bate com o que sua API espera.
> 

---