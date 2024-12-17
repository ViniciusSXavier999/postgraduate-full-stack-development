# AUTENTICAÇÃO JWT

🏆 RESUMIDAMENTE É UM TOKEN QUE EU CONSIGO COLOCAR INFORMAÇÕES NELE.

O **JWT (JSON Web Token)** é um padrão aberto usado para **autenticação** e **autorização** entre partes, permitindo o envio de informações de forma segura e compacta. Ele é composto por três partes: **Header** (cabeçalho), **Payload** (dados) e **Signature** (assinatura), separadas por pontos.

- **Header**: Define o tipo do token e o algoritmo de criptografia.
- **Payload**: Contém as informações (claims) sobre o usuário e dados adicionais.
- **Signature**: Garante a integridade do token e que ele não foi alterado.

JWT é amplamente usado para autenticar usuários em sistemas **web** e **APIs**, pois pode ser facilmente verificado e transportado em HTTP headers.


## BLOG SOBRE JWT

[O que é JSON Web Tokens? | Alura](https://www.alura.com.br/artigos/o-que-e-json-web-tokens?srsltid=AfmBOoowf16zPymZIFkIfC6Ui2f4xnCpGXM45nD-jF5Hl0ufKRDGnRaL)

## DOCUMENTAÇÃO OFICIAL

[JWT.IO](https://jwt.io/)

## AQUI PODEMOS VER UM EXEMPLO CLARO SOBRE O JWT

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/autenticacaoJWT.png" />

> a UNICA maneira que um hacker conseguiria burlar isso seria tendo justamente o token
> 

🏆 Sim, um hacker precisaria do **token JWT (JSON Web Token)** para realizar ações maliciosas, como **se passar por um usuário autenticado**. O JWT contém informações como a identidade do usuário (usualmente no payload), bem como uma assinatura digital que garante que o token não foi alterado.

Se um hacker obtiver o token JWT, ele pode:

1. **Imitar o usuário**: Se o token contiver informações de autenticação (como ID do usuário ou permissões), o hacker pode se passar por esse usuário, assumindo suas permissões, acessando dados privados ou realizando ações no sistema como se fosse o usuário original.
2. **Modificação (se o segredo for fraco ou comprometido)**: Se o segredo usado para assinar o JWT for fraco ou comprometido, o hacker pode modificar o conteúdo do token, como alterar permissões ou outros dados no payload. Contudo, para que isso funcione, o hacker também precisa do **segredo** usado para assinar o token ou da chave privada, caso seja uma assinatura baseada em chave assimétrica.

**Como proteger os JWT contra roubo**:

- **Uso de HTTPS**: Para evitar que os tokens sejam interceptados durante a transmissão, é importante usar HTTPS (SSL/TLS) para criptografar a comunicação entre o cliente e o servidor.
- **Armazenamento seguro**: Os tokens não devem ser armazenados de forma insegura, como em locais acessíveis ao JavaScript (por exemplo, armazenamento local ou cookies não seguros).
- **Expiração e revogação**: É importante que os tokens tenham um tempo de expiração curto e que, quando necessário, possam ser revogados ou invalidados, evitando que um token roubado seja válido por muito tempo.
- **Verificação de assinatura**: No lado do servidor, é fundamental verificar a assinatura do JWT para garantir que ele não tenha sido modificado.

Portanto, o hacker não só precisaria do token JWT, mas também de algumas informações extras (como o segredo ou a chave) para conseguir manipular ou usá-lo de forma indevida.

</aside>

> Basicamente o Token é a sua sessão
> 

---

---

---

## 1. Vou criar uma nova model chamada ‘userAuth’

```tsx
export class UserAuth {
    kind: string = '';
    localId: string = '';
    email: string = '';
    displayName: string = '';
    idToken: string = '';
    registered: boolean = true;
    refreshToken: string = '';
    expiresIn: string = '';
  }
```

> Isso é necessário para a autenticação do usuário
> 

[How do I cast a JSON Object to a TypeScript class?](https://stackoverflow.com/questions/22875636/how-do-i-cast-a-json-object-to-a-typescript-class)

🏆 Essa classe **`UserAuth`** é uma **definição de modelo** em **TypeScript**, geralmente utilizada em projetos que usam **Firebase** para autenticação de usuários. A classe organiza e estrutura as informações relacionadas à autenticação.

### Explicação dos atributos:

1. **`kind`**: Representa o tipo de resposta retornada pelo Firebase (ex: "identitytoolkit#SignupNewUserResponse").
2. **`localId`**: Identificador único do usuário fornecido pelo Firebase.
3. **`email`**: O endereço de e-mail do usuário autenticado.
4. **`displayName`**: Nome exibido do usuário (opcional, pode ser fornecido na criação da conta).
5. **`idToken`**: Token de autenticação JWT emitido pelo Firebase, usado para autenticar o usuário em cada requisição.
6. **`registered`**: Indica se o usuário já está registrado (booleano, geralmente **true** se for uma resposta de login).
7. **`refreshToken`**: Token usado para obter um novo `idToken` quando o atual expira.
8. **`expiresIn`**: Tempo em segundos para o token expirar.

### Uso da classe:

Essa classe é usada como um **modelo de dados** para mapear a resposta da API de autenticação do Firebase. Isso ajuda a manipular os dados do usuário de forma mais organizada e com **tipagem segura** no TypeScript.

Exemplo de uso:

```tsx
const user = new UserAuth();
user.email = "user@example.com";
user.idToken = "tokenJWT";

```

Isso facilita o controle e o uso das informações de autenticação no projeto.


## 2. Vou criar uma nova model chamada ‘userReturn’ que vai ser o retorno do Firebase

```tsx
export class UserReturn {

    constructor( public kind: string, public users?:UsersEntity[]){
        
    }
  }
  export interface UsersEntity {
    localId: string;
    email: string;
    passwordHash: string;
    emailVerified: boolean;
    passwordUpdatedAt: number;
    providerUserInfo?: (ProviderUserInfoEntity)[] | null;
    validSince: string;
    lastLoginAt: string;
    createdAt: string;
    lastRefreshAt: string;
  }
  export interface ProviderUserInfoEntity {
    providerId: string;
    federatedId: string;
    email: string;
    rawId: string;
  }
```

🏆 Essas informações estarão vindo do firebase


Essa classe e interfaces representam um **modelo de dados** em **TypeScript** usado para estruturar as respostas do Firebase, especialmente relacionadas à recuperação de informações de usuários.

### **Análise da classe `UserReturn`**

```tsx
export class UserReturn {
  constructor(public kind: string, public users?: UsersEntity[]) {
  }
}

```

- **`kind`**: É uma string que identifica o tipo de resposta da API do Firebase.
- **`users`**: Um **array opcional** (`UsersEntity[]`) que contém informações detalhadas sobre os usuários. O `?` indica que esse parâmetro é opcional.

A classe usa o **TypeScript shorthand** no construtor para declarar e inicializar automaticamente as propriedades.

---

### **Interface `UsersEntity`**

```tsx
export interface UsersEntity {
  localId: string;
  email: string;
  passwordHash: string;
  emailVerified: boolean;
  passwordUpdatedAt: number;
  providerUserInfo?: (ProviderUserInfoEntity)[] | null;
  validSince: string;
  lastLoginAt: string;
  createdAt: string;
  lastRefreshAt: string;
}

```

Essa interface define a estrutura para representar **dados do usuário** retornados pelo Firebase. Cada propriedade significa:

- **`localId`**: Identificador único do usuário no Firebase.
- **`email`**: Endereço de e-mail do usuário.
- **`passwordHash`**: Hash da senha armazenada no Firebase.
- **`emailVerified`**: Booleano que indica se o e-mail foi verificado.
- **`passwordUpdatedAt`**: Timestamp do último update na senha (em milissegundos).
- **`providerUserInfo`**: (Opcional) Array de provedores de autenticação usados pelo usuário (ex: Google, Facebook).
- **`validSince`**: Data (timestamp) a partir da qual o token do usuário é válido.
- **`lastLoginAt`**: Timestamp do último login do usuário.
- **`createdAt`**: Timestamp da criação da conta do usuário.
- **`lastRefreshAt`**: Timestamp do último refresh do token.

---

### **Interface `ProviderUserInfoEntity`**

```tsx
export interface ProviderUserInfoEntity {
  providerId: string;
  federatedId: string;
  email: string;
  rawId: string;
}

```

Esta interface descreve informações sobre o **provedor de autenticação** associado ao usuário:

- **`providerId`**: Identificador do provedor (ex: "google.com", "password").
- **`federatedId`**: ID fornecido pelo provedor externo.
- **`email`**: E-mail associado ao provedor.
- **`rawId`**: ID bruta do usuário no provedor.

---

### **Resumo**

Essa estrutura de classe e interfaces é usada para mapear e organizar a resposta da **API de gerenciamento de usuários do Firebase**. Por exemplo, ela pode ser utilizada ao chamar a API que retorna informações sobre contas de usuários cadastrados.

Exemplo de uso:

```tsx
const userResponse = new UserReturn("identitytoolkit#GetAccountInfoResponse", [
  {
    localId: "123456",
    email: "user@example.com",
    passwordHash: "ABCDEF",
    emailVerified: true,
    passwordUpdatedAt: 1620000000000,
    providerUserInfo: [{ providerId: "google.com", federatedId: "123", email: "user@example.com", rawId: "123" }],
    validSince: "1620000000",
    lastLoginAt: "1620005000000",
    createdAt: "1600000000000",
    lastRefreshAt: "1620006000000"
  }
]);
console.log(userResponse);

```

Esse código organiza os dados recebidos e facilita o **uso tipado** no TypeScript.

🚨 é obrigatorio quando se utiliza firebase?

Não, **não é obrigatório** criar essas classes e interfaces ao utilizar o Firebase. Elas são uma prática recomendada para projetos em **TypeScript**, pois ajudam a:

1. **Organizar e tipar os dados** retornados pelas APIs do Firebase.
2. **Facilitar o desenvolvimento**, oferecendo autocompletar e evitando erros de digitação.
3. **Melhorar a manutenção** do código, deixando claro quais propriedades são esperadas.

### Firebase sem TypeScript

Se você estiver usando **JavaScript puro**, o Firebase funciona sem precisar dessas definições, pois o JavaScript é **dinâmico** e não exige tipagem. Exemplo básico:

```jsx
firebase.auth().currentUser.then((user) => {
  console.log(user.email);
});

```

### Firebase com TypeScript

Ao usar TypeScript, definir classes e interfaces ajuda o desenvolvedor a **validar os dados** e usar recursos de tipagem forte. Exemplo:

```tsx
import { UserReturn, UsersEntity } from './user-model';

firebase.auth().currentUser?.getIdTokenResult().then((tokenResult: UserReturn) => {
  console.log(tokenResult.users?.[0].email);
});

```

### Resumo

- As **classes e interfaces** não são obrigatórias para usar o Firebase.
- São uma boa prática no **TypeScript** para deixar o código mais robusto, organizado e legível.
- Em **JavaScript puro**, você pode usar o Firebase diretamente sem se preocupar com tipagem.
</aside>

## 3. Agora vamos criar uma nova variável e atribuir uma nova url para ela no Nosso user.service.ts

```tsx
 FIREBASE_URL: 'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDThl5AbjP3GU4XvtdpBn5ZvVUFVXMJMSA'
```

🚨 O que significa essa linha? 'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDThl5AbjP3GU4XvtdpBn5ZvVUFVXMJMSA'?

Essa URL do Firebase é usada para a **autenticação de usuários** no serviço de **Firebase Authentication** utilizando **e-mail e senha**. Vamos entender em partes:

---

### **Estrutura da URL**

1. **`https://identitytoolkit.googleapis.com`**
    - É o **endpoint base** da API de autenticação do Firebase, fornecida pelo Google.
2. **`/v1/accounts:signInWithPassword`**
    - Esse é o **método específico** da API usado para realizar o **login com e-mail e senha**.
    - Ele faz parte do **Identity Toolkit** do Firebase.
3. **`?key=AIzaSyDThl5AbjP3GU4XvtdpBn5ZvVUFVXMJMSA`**
    - **`key`**: É a **chave da API** do Firebase.
    - Essa chave é usada para **autenticar a requisição** e vincular a chamada ao seu projeto específico do Firebase.

---

### **Funcionamento**

Quando você faz uma **requisição POST** para essa URL, enviando os dados de e-mail e senha no **corpo** da requisição, o Firebase verifica as credenciais e retorna um **token JWT** que pode ser usado para autenticar o usuário em outras partes do sistema.

---

### **Exemplo de Requisição**

```
POST https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDThl5AbjP3GU4XvtdpBn5ZvVUFVXMJMSA
Content-Type: application/json

{
  "email": "usuario@exemplo.com",
  "password": "senha123",
  "returnSecureToken": true
}

```

### **Resposta Esperada**

Se as credenciais estiverem corretas, a API retorna uma resposta como esta:

```json
{
  "idToken": "TOKEN_JWT_AQUI",
  "email": "usuario@exemplo.com",
  "refreshToken": "TOKEN_DE_REFRESH",
  "expiresIn": "3600",
  "localId": "UID_DO_USUARIO",
  "registered": true
}

```

- **`idToken`**: Token JWT que pode ser usado para autenticar o usuário em outras requisições.
- **`refreshToken`**: Token usado para obter um novo `idToken` quando ele expira.
- **`expiresIn`**: Tempo (em segundos) para expiração do token.
- **`localId`**: Identificador único do usuário no Firebase.
- **`registered`**: Confirma que o usuário já existe.

---

### **Resumo**

Essa URL é usada para realizar **login com e-mail e senha** no Firebase Authentication. A chave **API Key** permite que a chamada à API seja associada ao seu projeto Firebase. O retorno inclui um **token JWT** que autentica o usuário e mantém a sessão ativa.


## 4. Vamos criar outra variável chamada ‘TOKEN_FIREBASE’ isso é caso a gente crie nosso firebase, esse token será gerado lá

```tsx
  TOKEN_FIREBASE: string =  'AIzaSyDThl5AbjP3GU4XvtdpBn5ZvVUFVXMJMSA'
  FIREBASE_URL: string = 'https://identitytoolkit.googleapis.com/'

```

## 5. Alterar nosso método `login()` no user.service para retornar um objeto do tipo ‘UserAuth’

```tsx
login(data:any): Observable<UserAuth>{
    console.log(data)
    return this.segurancaHttp.post<UserAuth>(this.FIREBASE_URL + 'v1/accounts:signInWithPassword?key=' + this.TOKEN_FIREBASE, data, httpOptions)
  }
```

## 6. Vamos alterar o nosso console log no arquivo login.component

```tsx
console.log(response.idToken)
```

> Isso é necessário para vermos o token e colocar ele na url
> 

## 7. Para autorizar precisamos saber se esse token existe, vamos fazer essa lógica:

```tsx
            if(response.idToken)
            this.autorizacaoService.autorizar()
               },
```

> Basicamente ele faz com que as rotas sejam protegidas, a rota protegida só vai ser acessada se você fizer o login
> 

---

---

---

## EXPLICAÇÃO DO CÓDIGO `onSubmit()`

```tsx

  onSubmit(): void {
    // this.loginClick()
    if (this.autorizacaoService.obterLoginStatus()) {
      this.autorizacaoService.deslogar()
    } else {
      //  this.autorizacaoService.autorizar();
      this.service.login({ user: 'hahahah' }).subscribe({  // O SUBSCRIBE É OBRIGÁTORIO EM UM OBSERVABLE
        next: (response) => {
           console.log(response.idToken)
           if(response.idToken)
            this.autorizacaoService.autorizar()
          //  alert('Dado registrado com sucesso')
        },
        error: (erro: any) => { // error -> Tratamento de exceção do subscribe
          console.log(erro)
          alert('Ocorreu algum erro')
        }
      })
    }
  }
```

Esse código é um **método `onSubmit()`** que provavelmente é usado em um **formulário de login**. Ele faz a verificação do **status de login** do usuário e, dependendo do status, ou **faz o logout** ou **faz a requisição de login**.

Vamos explicar o que cada parte faz:

---

### **Estrutura do código:**

1. **`if (this.autorizacaoService.obterLoginStatus())`**
    - Aqui, o código verifica se o usuário já está **logado** ou não, através do método `obterLoginStatus()` da classe **`autorizacaoService`**.
        - Se o usuário **está logado**, ele chama o método `deslogar()` para fazer o **logout**.
        - Se o usuário **não está logado**, o código executa o bloco do `else`, onde tenta **logar o usuário**.
2. **`this.service.login({ user: 'hahahah' })`**
    - Aqui, o código chama o método **`login`** do serviço **`service`**, passando um **objeto com dados de login**. O parâmetro `user: 'hahahah'` parece ser um exemplo de dado ou um valor fixo (em uma implementação real, deveria ser o **e-mail** e a **senha** do usuário).
    - Esse método **`login`** retorna um **Observable**, o que significa que a requisição é assíncrona.
3. **`subscribe()`**
    - O `subscribe` é necessário para que o **Observable** execute a lógica assíncrona da requisição HTTP. O **`subscribe`** recebe dois objetos:
        - **`next`**: A função que será chamada quando a requisição for bem-sucedida.
        - **`error`**: A função que será chamada quando ocorrer algum erro na requisição.

---

### **Explicando o que acontece em cada parte do código:**

1. **`next: (response) => { ... }`**:
    - Quando a requisição de login for **bem-sucedida**, a função de **`next`** é executada.
    - O **`response`** é a resposta da requisição. Nesse caso, espera-se que a resposta tenha um **`idToken`** (que é um **token de autenticação** retornado pelo backend, como o Firebase).
    - Se o **`idToken`** estiver presente (indicando que o login foi bem-sucedido), o método `autorizar()` da **`autorizacaoService`** é chamado. Isso provavelmente configura o usuário como **logado** no sistema.
    
    ```jsx
    if (response.idToken) {
      this.autorizacaoService.autorizar();
    }
    
    ```
    
2. **`error: (erro: any) => { ... }`**:
    - Se ocorrer algum erro durante a requisição de login, a função **`error`** será chamada.
    - O erro será exibido no console (`console.log(erro)`) e uma mensagem de alerta será mostrada ao usuário: **"Ocorreu algum erro"**.

---

### **Comentários sobre o código**:

- **`this.service.login({ user: 'hahahah' })`**:
    - A string `'hahahah'` não parece ser uma entrada de login válida. Em um cenário real, o parâmetro seria provavelmente algo como `{ email: 'usuario@exemplo.com', password: 'senha' }`.
- **`subscribe()`**:
    - O `subscribe` é necessário porque a **requisição HTTP** é **assíncrona**. Ou seja, a resposta da requisição não vem imediatamente, e precisamos usar o `subscribe` para aguardar e lidar com o resultado ou erro.
- **Uso de `next` e `error`**:
    - **`next`**: A lógica executada se a requisição for bem-sucedida (por exemplo, quando o login é válido e o `idToken` é retornado).
    - **`error`**: A lógica executada se a requisição falhar (por exemplo, se o usuário fornecer credenciais inválidas).

---

### **Resumo do Fluxo:**

1. Se o usuário está **logado**, chama o método `deslogar()` para deslogar.
2. Se o usuário não está **logado**, faz a requisição de **login** chamando `this.service.login()`.
3. Se o login for **bem-sucedido**, chama `this.autorizacaoService.autorizar()` para autorizar o usuário no sistema.
4. Se ocorrer um **erro** na requisição, exibe um alerta de erro ao usuário.

---

### **Exemplo de código com dados reais de login**:

Se você quiser que o login receba um **e-mail** e **senha** reais, o código poderia ser algo assim:

```tsx
onSubmit(email: string, password: string): void {
    if (this.autorizacaoService.obterLoginStatus()) {
      this.autorizacaoService.deslogar();
    } else {
      this.service.login({ email: email, password: password }).subscribe({
        next: (response) => {
          console.log(response.idToken);
          if (response.idToken)
            this.autorizacaoService.autorizar();
        },
        error: (erro: any) => {
          console.log(erro);
          alert('Ocorreu algum erro');
        }
      });
    }
}

```

Neste caso, o método `onSubmit` receberia **e-mail** e **senha** como parâmetros, fazendo o login com as credenciais fornecidas pelo usuário.

---

---

---

## DÚVIDAS QUE SURGIRAM DURANTE A AULA

### o que significa o 'data' nesse método?

```tsx
login(data:any): Observable<UserAuth>{
    console.log(data)
    return this.segurancaHttp.post<UserAuth>(this.FIREBASE_URL + 'v1/accounts:signInWithPassword?key=' + this.TOKEN_FIREBASE, data, httpOptions)
  }
```

No método `login`, o parâmetro **`data`** representa o **corpo da requisição** que será enviado para a **API do Firebase**. Ele carrega os **dados necessários** para a autenticação, como **e-mail e senha**.

Vamos analisar o método:

```tsx
login(data: any): Observable<UserAuth> {
    console.log(data);
    return this.segurancaHttp.post<UserAuth>(
      this.FIREBASE_URL + 'v1/accounts:signInWithPassword?key=' + this.TOKEN_FIREBASE,
      data,
      httpOptions
    );
}

```

---

### **Significado de `data`**

- **`data`**: É um objeto que contém as informações que serão enviadas no **corpo da requisição HTTP**.
    - No caso da autenticação com Firebase, o **data** geralmente contém os seguintes campos:
        
        ```json
        {
          "email": "usuario@exemplo.com",
          "password": "senha123",
          "returnSecureToken": true
        }
        
        ```
        
- Esse **objeto** será enviado como JSON no corpo da requisição **POST**.

---

### **Como ele é usado?**

1. **`this.segurancaHttp.post`**:
    
    Este é um método de requisição **HTTP POST** fornecido pelo Angular, que envia os dados (nesse caso, `data`) para o Firebase.
    
2. **Endpoint**:
    
    A URL:
    
    ```
    this.FIREBASE_URL + 'v1/accounts:signInWithPassword?key=' + this.TOKEN_FIREBASE
    
    ```
    
    - Aponta para o serviço de autenticação do Firebase.
    - **`key`**: É a chave de API usada para autenticar a requisição no Firebase.
3. **`data` no corpo**:
    
    O objeto `data` é incluído como corpo da requisição HTTP. O Firebase espera esse JSON para validar o usuário.
    
4. **`httpOptions`**: Contém **cabeçalhos HTTP** necessários, como `Content-Type: application/json`.

---

### **Exemplo de uso do método `login`**

```tsx
const loginData = {
  email: "usuario@exemplo.com",
  password: "senha123",
  returnSecureToken: true
};

this.loginService.login(loginData).subscribe(response => {
  console.log("Login realizado com sucesso", response);
});

```

**Saída no console** (de `console.log(data)`):

```json
{
  "email": "usuario@exemplo.com",
  "password": "senha123",
  "returnSecureToken": true
}

```

---

### **Resumo**

- O parâmetro **`data`** é o **corpo da requisição POST** que contém os dados necessários para autenticação, como **e-mail e senha**.
- Ele é passado para o método `post` do Angular **HttpClient**, que envia esses dados para a API do Firebase.
- Essa estrutura torna o método genérico e reutilizável, aceitando qualquer objeto no corpo da requisição.

---

---

---

### O que pode substituir o firebase? uma api feita no spring boot?

Sim, é possível substituir o **Firebase** por uma **API desenvolvida em Spring Boot** ou outra tecnologia backend. O Firebase é uma plataforma que oferece soluções **prontas** para backend, como autenticação, banco de dados, armazenamento e hospedagem, mas você pode construir uma solução personalizada usando **Spring Boot**.

---

### **Firebase vs Spring Boot API**

| **Firebase** | **API no Spring Boot** |
| --- | --- |
| Solução pronta para **autenticação, banco de dados, etc.** | Solução personalizada, você desenvolve cada funcionalidade. |
| Sem necessidade de gerenciar servidor. | Requer configuração de servidor e infraestrutura. |
| Rápido para implementar, ideal para MVPs. | Flexível e escalável, adequado para projetos complexos. |
| Uso de **serviços em nuvem**. | Você controla toda a aplicação no backend. |

---

### **O que você pode construir no Spring Boot para substituir o Firebase?**

1. **Autenticação**
    - Implemente autenticação com **JWT (JSON Web Token)**.
    - Use Spring Security para proteger endpoints e gerenciar usuários.
2. **Banco de Dados**
    - Use bancos de dados relacionais (**MySQL, PostgreSQL**) ou não relacionais (**MongoDB**).
    - Crie endpoints REST para inserir, atualizar, buscar e deletar dados.
3. **Armazenamento de Arquivos**
    - Configure armazenamento local ou integre serviços externos como **AWS S3** ou **Google Cloud Storage**.
4. **Hospedagem**
    - A API Spring Boot pode ser hospedada em servidores como **AWS EC2**, **Heroku**, **Azure** ou **Google Cloud**.
5. **Notificações Push**
    - Implemente notificações usando **Firebase Cloud Messaging (FCM)** ou **APNs** para iOS/Android.

---

### **Exemplo: Autenticação com JWT no Spring Boot**

1. **Dependências no `pom.xml`**:
    
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
        <version>0.11.2</version>
    </dependency>
    
    ```
    
2. **Geração de Token JWT**:
    
    ```java
    import io.jsonwebtoken.Jwts;
    import io.jsonwebtoken.SignatureAlgorithm;
    import java.util.Date;
    
    public class JwtUtil {
        private final String SECRET_KEY = "secreta123";
    
        public String generateToken(String username) {
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        }
    }
    
    ```
    
3. **Proteção com Spring Security**:
    - Use filtros e configurações do Spring Security para validar o token e proteger as rotas.

---

### **Vantagens de uma API Spring Boot**

1. **Flexibilidade**: Total controle sobre lógica de negócios, endpoints e banco de dados.
2. **Escalabilidade**: Melhor para projetos grandes e complexos.
3. **Personalização**: Você implementa exatamente o que precisa.
4. **Integrações**: Mais fácil de integrar com sistemas externos (ERP, APIs externas, etc.).

---

### **Conclusão**

Uma **API em Spring Boot** é uma excelente alternativa ao Firebase para projetos que exigem mais controle, personalização e escalabilidade. Porém, enquanto o Firebase é rápido e prático para protótipos ou pequenos projetos, o Spring Boot exige mais esforço inicial para configurar infraestrutura, autenticação e banco de dados.

---

---

---

## O que significa essa url no Firebase'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDThl5AbjP3GU4XvtdpBn5ZvVUFVXMJMSA'

Essa URL do Firebase é usada para a **autenticação de usuários** no serviço de **Firebase Authentication** utilizando **e-mail e senha**. Vamos entender em partes:

---

### **Estrutura da URL**

1. **`https://identitytoolkit.googleapis.com`**
    - É o **endpoint base** da API de autenticação do Firebase, fornecida pelo Google.
2. **`/v1/accounts:signInWithPassword`**
    - Esse é o **método específico** da API usado para realizar o **login com e-mail e senha**.
    - Ele faz parte do **Identity Toolkit** do Firebase.
3. **`?key=AIzaSyDThl5AbjP3GU4XvtdpBn5ZvVUFVXMJMSA`**
    - **`key`**: É a **chave da API** do Firebase.
    - Essa chave é usada para **autenticar a requisição** e vincular a chamada ao seu projeto específico do Firebase.

---

### **Funcionamento**

Quando você faz uma **requisição POST** para essa URL, enviando os dados de e-mail e senha no **corpo** da requisição, o Firebase verifica as credenciais e retorna um **token JWT** que pode ser usado para autenticar o usuário em outras partes do sistema.

---

### **Exemplo de Requisição**

```
POST https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDThl5AbjP3GU4XvtdpBn5ZvVUFVXMJMSA
Content-Type: application/json

{
  "email": "usuario@exemplo.com",
  "password": "senha123",
  "returnSecureToken": true
}

```

### **Resposta Esperada**

Se as credenciais estiverem corretas, a API retorna uma resposta como esta:

```json
{
  "idToken": "TOKEN_JWT_AQUI",
  "email": "usuario@exemplo.com",
  "refreshToken": "TOKEN_DE_REFRESH",
  "expiresIn": "3600",
  "localId": "UID_DO_USUARIO",
  "registered": true
}

```

- **`idToken`**: Token JWT que pode ser usado para autenticar o usuário em outras requisições.
- **`refreshToken`**: Token usado para obter um novo `idToken` quando ele expira.
- **`expiresIn`**: Tempo (em segundos) para expiração do token.
- **`localId`**: Identificador único do usuário no Firebase.
- **`registered`**: Confirma que o usuário já existe.

---

### **Resumo**

Essa URL é usada para realizar **login com e-mail e senha** no Firebase Authentication. A chave **API Key** permite que a chamada à API seja associada ao seu projeto Firebase. O retorno inclui um **token JWT** que autentica o usuário e mantém a sessão ativa.

---

---

---

### Json para typescript, explicação e como fazer?

Converter um **JSON** para **TypeScript** significa transformar a estrutura de um arquivo ou objeto JSON em **interfaces** ou **tipos** no TypeScript. Isso ajuda a garantir tipagem estática, validação e autocompletar no desenvolvimento.

---

## **Explicação**

- **JSON**: É um formato de dados leve baseado em texto (ex: `{"name": "John", "age": 30}`).
- **TypeScript**: Permite definir **tipos** e **interfaces** para representar a estrutura desses dados.

Por exemplo, se você tem o seguinte JSON:

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "johndoe@example.com",
  "isAdmin": true
}

```

No **TypeScript**, ele pode ser representado como:

```tsx
interface User {
  id: number;
  name: string;
  email: string;
  isAdmin: boolean;
}

```

Isso define um **modelo de dados** que pode ser usado no código com tipagem segura.

---

## **Como fazer?**

### **1. Manualmente**

Para pequenos JSONs, você pode criar as interfaces manualmente, observando o tipo de cada valor:

- **String** → `string`
- **Número** → `number`
- **Booleano** → `boolean`
- **Array** → `Tipo[]`
- **Objeto** → Outra interface

Exemplo:

```json
{
  "id": 1,
  "name": "Jane Doe",
  "roles": ["admin", "editor"],
  "profile": {
    "age": 25,
    "country": "USA"
  }
}

```

TypeScript:

```tsx
interface User {
  id: number;
  name: string;
  roles: string[];
  profile: Profile;
}

interface Profile {
  age: number;
  country: string;
}

```

---

### **2. Usando ferramentas automáticas**

Ferramentas online podem gerar as interfaces TypeScript a partir do JSON:

- [**json2ts**](https://json2ts.com/)
Cole o JSON e a ferramenta gera as interfaces automaticamente.

Exemplo:

Para o JSON:

```json
{
  "name": "Alice",
  "age": 28,
  "skills": ["TypeScript", "JavaScript"]
}

```

**Saída no json2ts:**

```tsx
export interface RootObject {
  name: string;
  age: number;
  skills: string[];
}

```

---

### **3. Usando o VSCode**

1. Copie o JSON.
2. Cole no seu arquivo TypeScript.
3. Use a extensão **"Paste JSON as Code"** ou "JSON to TS".

---

### **Como usar as interfaces no código?**

Exemplo de uso da interface:

```tsx
const user: User = {
  id: 1,
  name: "Jane Doe",
  roles: ["admin", "editor"],
  profile: {
    age: 25,
    country: "USA"
  }
};

console.log(user.name); // Tipagem e autocompletar funcionam

```

---

### **Resumo**

- **Manual**: Para pequenos JSONs, defina os tipos observando os valores.
- **Automático**: Use ferramentas como **json2ts**.
- Tipagem em TypeScript melhora a segurança, o autocompletar e reduz erros no código.

---

---

---

### O que significa tipagem estatica?

**Tipagem estática** é um conceito em linguagens de programação onde o **tipo de dado** de uma variável é **determinado em tempo de compilação** e não pode ser alterado durante a execução do programa.

Isso significa que, quando você declara uma variável, o tipo dela (como `string`, `number`, `boolean`) deve ser especificado ou inferido pelo compilador, e qualquer tentativa de atribuir um valor de tipo diferente resultará em um **erro de compilação**.

---

### **Características da Tipagem Estática**

1. **Segurança**: Reduz erros em tempo de execução, pois os tipos são verificados antecipadamente.
2. **Detecção de erros**: Erros de tipo são identificados **antes de executar** o código.
3. **Performance**: Pode melhorar o desempenho, já que o compilador sabe os tipos e pode otimizar o código.
4. **Previsibilidade**: Evita mudanças inesperadas no tipo de dados.

---

### **Exemplo Prático**

**Em TypeScript (tipagem estática):**

```tsx
let nome: string = "João";
nome = 123; // Erro! Tipo 'number' não pode ser atribuído ao tipo 'string'.

```

O erro é detectado **antes de executar o programa**.

**Em JavaScript (tipagem dinâmica):**

```jsx
let nome = "João";
nome = 123; // Sem erro. O tipo pode mudar em tempo de execução.

```

Aqui, a variável `nome` aceita valores de tipos diferentes porque o JavaScript tem **tipagem dinâmica**.

---

### **Vantagens da Tipagem Estática**

- **Menos erros**: Identificação de erros durante o desenvolvimento.
- **Autocompletar e IntelliSense**: Ferramentas como VSCode oferecem sugestões precisas com base nos tipos.
- **Código mais robusto**: Torna o código mais seguro e fácil de manter.

---

### **Resumo**

A **tipagem estática** força o uso consistente de tipos de dados, verificando-os durante a **compilação**. Isso ajuda a prevenir erros, aumentar a produtividade e criar códigos mais previsíveis. Linguagens como **TypeScript, Java, C++ e C#** utilizam tipagem estática.

---

---

---