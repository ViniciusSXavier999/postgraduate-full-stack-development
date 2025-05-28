# 3 → AUTENTICAÇÃO OAUTH

### DIFERENÇA DE OAUTH E AUTH0

🏆

### 🔑 **OAuth** (com "O" maiúsculo)

- **O que é:** Um **protocolo aberto** de **autorização**.
- **Função:** Permite que um sistema autorize outro sistema a acessar dados em nome do usuário, sem precisar compartilhar a senha.
- **Exemplo:** Login com Google, Facebook, GitHub, etc.
- **Tecnologia base:** Especificação usada em APIs e sistemas de autenticação.

✅ **OAuth é um padrão/protocolo.** Ele pode ser implementado por você ou por outras ferramentas (como o Spring Security ou o próprio Auth0).

---

### 🛠️ **Auth0**

- **O que é:** Uma **plataforma como serviço (SaaS)** que fornece autenticação e autorização.
- **Função:** Facilita a integração de **login seguro**, **geração de tokens (como JWT)**, **integração com redes sociais**, **MFA**, etc.
- **Base tecnológica:** Usa protocolos como **OAuth2**, **OIDC** e **JWT** por baixo dos panos.

✅ **Auth0 é uma empresa/produto** que **implementa OAuth** (e outros padrões) para você.

---

### ⚖️ Resumo comparativo:

| Característica | **OAuth** | **Auth0** |
| --- | --- | --- |
| Tipo | Protocolo padrão | Plataforma (SaaS) |
| Objetivo | Autorizar acesso a recursos | Fornecer autenticação/autorizações prontas |
| Criado por | Comunidade (open standard) | Empresa (agora parte da Okta) |
| Exemplo de uso | Login com Google/Facebook | Login usando serviço Auth0 com painel de gestão |
| Depende de | Você implementar | Serviço da Auth0 que implementa para você |

---

### 🎯 Em resumo:

- **OAuth** é o **protocolo**.
- **Auth0** é uma **plataforma que usa OAuth (entre outros)**.

Se você estiver desenvolvendo uma aplicação, pode escolher:

- **Implementar OAuth2 com Spring Security + JWT**
- **Usar Auth0 para gerenciar tudo com menos esforço**

---

### AUTENTICAÇÃO OAUTH

🏆 Auth0 fornece serviços de autenticação e autorização para vários tipos de aplicativos Como native, Single Page Applications e Web.

> A Auth0 vende um software como serviço que tem a responsabilidade de gerenciar toda parte de autenticação e autorização para nós, sendo assim a gente não precisa ficar se preocupando em cadastrar usuário no banco, esse software já faz isso para gente, basta apenas realizar as configurações necessárias.
> 

🏆 Além disso, permite a implementação de vários recursos como Single Sign-on, Social login e Multi-Factor Authentication


🔒 Como estamos trabalhando com um servidor de recursos só iremos autenticar a nossa API com um token JWT, caso a gente tivesse trabalhando com a parte do front-end a gente poderia implementar a parte de login e senha.


🏆 Seus recursos podem ser integrados com o Spring Security


⚠️ Para utilizar o Auth0 é preciso seguir algumas etapas como o cadastro na plataforma, configurações do aplicativo(NESSE CASO É NOSSA API) e credenciais(SÃO PERFIS, EXEMPLO: ADMNISTRADOR.).


---

### IMPLEMENTAÇÃO E CONFIGURAÇÕES DO AUTH0

### 1. SERÁ NECESSÁRIO CRIAR UMA CONTA NO SITE DO AUTH0 E REALIZAR CONFIGURAÇÕES

- 1 → CRIAR A CONTA CASO NÃO TENHA
- 2 → APÓS ESTAR LOGADO, CLICAR EM “APPLICATIONS” E SELECIONAR “APIs”
- 3 → REALIZAR AS CONFIGURAÇÕES NECESSÁRIAS (LEMBRANDO QUE NO CAMPO “IDENTIFIER” TEMOS QUE TER UM IDENTIFIER ÚNICO)
- 4 → APÓS ISSO CLICAR EM “CREATE” E A API SERÁ CRIADA

### 2. REALIZANDO TESTES NA API CRIADA ANTERIORMENTE

- 1 → VAMOS CLICAR EM TEST
- 2 → COPIAR A URL DO PRIMEIRO CAMPO PARA REALIZARMOS TESTES ATRAVÉS DO POSTMAN
- 3 → VAMOS ATÉ O POSTMAN CRIAR UMA NOVA COLEÇÃO
- 4 → VAMOS COLAR A URL QUE COPIAMOS ANTERIORMENTE DENTRO DE UMA NOVA REQUEST POST
- 5 → EM SEGUIDA, VAMOS INICIAR A CONFIGURAÇÃO DO DATA
    - VAMOS COPIAR O DATA
    - IR PARA O POSTMAN E SELECIONAR “BODY”
    - EM SEGUIDA, SELECIONAR “x-www-form-urlencoded” E EM “KEY” VAMOS COLOCAR O NOSSO CLIENT_ID
- 6 → VAMOS COLOCAR O VALOR DELE (É IMPORTANTE QUE ESTEJA CORRETO PORQUE SE NÃO, NÃO SERÁ POSSÍVEL GERAR UM TOKEN)
- 7 → VAMOS DEPOIS PEGAR CLIENT_SECRET E FAZER A MESMA COISA QUE FIZEMOS COM O CLIENT_ID
- 8 → DEPOIS VAMOS PEGAR O AUDIENCE(identificador único da nossa API) E FAZER A MESMA COISA, MAS COM O SEU RESPECTIVO VALOR
- 9 → REALIZAR O MESMO PROCESSO COM O GRANT_TYPE

✅ SE TUDO ESTIVER CORRETO UM TOKEN SERÁ GERADO PARA NÓS.


✅ É esse token que vamos utilizar para autenticar na nossa API.

## DÚVIDAS

### O QUE É `x-www-form-urlencoded`?

O `x-www-form-urlencoded` é **um tipo de codificação de dados** muito comum em requisições HTTP, especialmente quando estamos lidando com **formulários** ou APIs que esperam dados dessa forma.

Vamos direto ao ponto:

---

### 📦 O que é `x-www-form-urlencoded`?

É um **formato de envio de dados no corpo da requisição HTTP (normalmente POST)** onde os dados são codificados como se fossem enviados por um **formulário HTML tradicional**.

No Postman, quando você escolhe `x-www-form-urlencoded`, ele faz o seguinte:

- Monta os dados no formato:
    
    ```
    chave1=valor1&chave2=valor2&chave3=valor3
    
    ```
    
- Usa o cabeçalho:
    
    ```
    Content-Type: application/x-www-form-urlencoded
    
    ```
    

---

### 🧠 Como funciona?

Imagine que você envia isso no Postman:

| Key | Value |
| --- | --- |
| email | [teste@abc.com](mailto:teste@abc.com) |
| senha | 123456 |

O corpo da requisição será:

```
email=teste%40abc.com&senha=123456

```

Observe que:

- Os dados são **concatenados com `&`**.
- Caracteres especiais (como `@`) são **codificados** (ex: `@` vira `%40`).

---

### 🧩 Quando usar?

Use `x-www-form-urlencoded` quando:

✅ A API espera os dados como um **formulário web tradicional**

✅ Você está fazendo login via **formulário simples**

✅ A documentação da API ou servidor espera esse formato (ex: muitos servidores PHP e Java antigos)

---

### ⚠️ Diferença para `raw` JSON

| Formato | Exemplo de corpo | Content-Type |
| --- | --- | --- |
| `x-www-form-urlencoded` | `usuario=joao&senha=123` | `application/x-www-form-urlencoded` |
| `raw (JSON)` | `{"usuario":"joao","senha":"123"}` | `application/json` |

**Se a API espera JSON e você envia como `x-www-form-urlencoded`, ela pode não funcionar.**

---

### ✅ Em resumo:

| Item | x-www-form-urlencoded |
| --- | --- |
| É o quê? | Formato de envio de dados (como formulário HTML) |
| Usado em? | Requisições POST/PUT (principalmente em login, formulários simples) |
| Content-Type | `application/x-www-form-urlencoded` |
| Quando evitar? | Quando a API espera JSON, XML ou outro formato |

---

### Qual a diferença da segurança com spring security, Autenticação 0Auth e JWT?

As três tecnologias que você mencionou — **Spring Security**, **OAuth2** e **JWT** — estão relacionadas à segurança em aplicações, mas têm **funções distintas**. Vamos ver cada uma delas:

---

### 🔐 1. **Spring Security**

**O que é?**

Spring Security é um **framework de segurança** para aplicações Java/Spring. Ele fornece ferramentas para:

- Autenticação (login)
- Autorização (controle de acesso)
- Proteção contra ataques como CSRF, XSS, etc.
- Integração com OAuth2, JWT, LDAP, etc.

**Ponto-chave:**

É a **infraestrutura** que você usa para aplicar regras de segurança. Ele pode usar OAuth2 e JWT como **mecanismos de autenticação**.

---

### 🔑 2. **OAuth2**

**O que é?**

OAuth2 é um **protocolo de autorização** que permite que aplicações acessem recursos em nome do usuário, sem precisar da senha dele. Muito usado em **login com redes sociais**, por exemplo:

- "Entrar com Google"
- "Entrar com Facebook"

**Fluxo típico:**

1. O usuário faz login em um provedor (como Google).
2. A aplicação recebe um **token de acesso**.
3. Usa esse token para acessar APIs protegidas.

**Ponto-chave:**

OAuth2 é usado para **delegar acesso** a APIs. Ele pode retornar tokens que **representam o usuário**.

---

### 🔐 3. **JWT (JSON Web Token)**

**O que é?**

JWT é um **formato de token**. Ele contém **informações codificadas** (como ID do usuário, permissões, etc.) e é **assinado digitalmente**, garantindo integridade.

Exemplo de estrutura JWT:

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.
eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvZSBEb2UifQ.
SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

```

**Ponto-chave:**

JWT é **um tipo de token**, usado muitas vezes com OAuth2 ou diretamente em autenticações **stateless** (sem sessão no servidor).

---

### 📌 Como se relacionam na prática?

Em uma aplicação Spring moderna, os três podem trabalhar **juntos**:

1. **Spring Security** configura e controla toda a segurança.
2. **OAuth2** é usado como forma de autenticação (por exemplo, com login do Google).
3. O servidor emite um **JWT** como token de acesso, que o cliente usa para autenticar futuras requisições.

---

### ✅ Exemplo real:

- Usuário faz login via Google (OAuth2).
- Spring Security autentica o usuário.
- O sistema gera um JWT e envia ao cliente.
- O cliente envia o JWT em cada requisição.
- Spring Security valida o JWT em cada requisição e aplica as regras de acesso.