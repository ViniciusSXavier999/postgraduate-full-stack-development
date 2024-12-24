# ALTERAÇÃO DE ROTAS PARA AUTH GUARD E JWT

## 1. Alterações no método onSubmit()

🚨 Vamos iniciar realizando alterações no método onSubmit()

```tsx
  onSubmit(): void {
  
    if (this.autorizacaoService.obterLoginStatus()) {
      this.autorizacaoService.deslogar()
    } else {
     
      this.service.login(this.addressForm.value).subscribe({
        
        next: (response) => {
           console.log(response.idToken)

           
           if(response.idToken){
            this.autorizacaoService.autorizar()

            // importei o route do Angular
            this.route.navigate(['/usuario'])
           }
        },

        error: (erro: any) => { 
          console.log(erro)
          alert('Ocorreu algum erro')
        }
      })
    }
  }
```

> Criei um novo IF que vai fazer com que só aconteça a autorização se o usuário estiver com o token
> 

> Criei um novo componente usuário que é para onde vamos ser redirecionados quando entrarmos
> 

📌 Explicação passo a passo do código

Claro! Vou explicar o código **linha por linha** conforme solicitado. Este código parece ser um método `onSubmit()` em um componente Angular, que lida com a lógica de login e logout, verificando o status de autenticação de um usuário.

### Código:

```tsx
onSubmit(): void {  // 1

```

- **Linha 1**: Define o método `onSubmit`, que provavelmente é chamado quando um formulário é enviado (por exemplo, um formulário de login). O tipo de retorno `void` indica que não há um valor retornado por este método.

```tsx
  if (this.autorizacaoService.obterLoginStatus()) {  // 2

```

- **Linha 2**: Verifica se o usuário está atualmente logado. Para isso, chama o método `obterLoginStatus()` do serviço `autorizacaoService`. Esse método provavelmente retorna um valor booleano indicando se o usuário está autenticado ou não.

```tsx
    this.autorizacaoService.deslogar()  // 3

```

- **Linha 3**: Caso o usuário esteja logado (se a condição anterior for verdadeira), o método `deslogar()` do serviço `autorizacaoService` é chamado. Esse método provavelmente realiza o logout, removendo o estado de autenticação do usuário (como tokens ou informações de sessão).

```tsx
  } else {  // 4

```

- **Linha 4**: Se o usuário **não estiver logado** (ou seja, a condição `if` anterior for falsa), o código dentro do bloco `else` será executado, tratando o caso de login.

```tsx
    this.service.login(this.addressForm.value).subscribe({  // 5

```

- **Linha 5**: Aqui, o método `login()` do serviço `service` (provavelmente um serviço de autenticação ou API) é chamado. Ele passa os dados do formulário (`this.addressForm.value`) como argumento, provavelmente contendo as credenciais do usuário (como e-mail e senha). O método `login` retorna um Observable, e a função `subscribe` é usada para tratar a resposta dessa requisição assíncrona.

```tsx
      next: (response) => {  // 6

```

- **Linha 6**: O bloco `next` define o comportamento do código quando a requisição de login for bem-sucedida (ou seja, a resposta é recebida). O parâmetro `response` contém a resposta da API.

```tsx
        console.log(response.idToken)  // 7

```

- **Linha 7**: Exibe o valor de `idToken` da resposta no console. O `idToken` provavelmente é um token de autenticação (como um JWT) fornecido pela API após um login bem-sucedido.

```tsx
        if (response.idToken) {  // 8

```

- **Linha 8**: Verifica se o `idToken` foi realmente retornado na resposta. Isso indica que o login foi bem-sucedido e o servidor forneceu um token válido.

```tsx
          this.autorizacaoService.autorizar()  // 9

```

- **Linha 9**: Caso o `idToken` esteja presente (login bem-sucedido), o método `autorizar()` do serviço `autorizacaoService` é chamado. Esse método provavelmente realiza a ação de armazenar o token (por exemplo, em `localStorage` ou `sessionStorage`) e marcar o usuário como autenticado.

```tsx
          this.route.navigate(['/usuario'])  // 10

```

- **Linha 10**: Após a autorização, o método `navigate()` do serviço de roteamento (`this.route`) é chamado para redirecionar o usuário para a página `/usuario`. Esse redirecionamento ocorre após o login bem-sucedido.

```tsx
        }  // 11

```

- **Linha 11**: Fecha o bloco `if` que verifica a presença de `idToken`.

```tsx
      },  // 12

```

- **Linha 12**: Fecha o bloco `next` do `subscribe`, que é executado quando a requisição de login é bem-sucedida.

```tsx
      error: (erro: any) => {  // 13

```

- **Linha 13**: Define o bloco `error`, que lida com possíveis erros na requisição. O parâmetro `erro` contém a informação do erro caso a requisição falhe (por exemplo, se as credenciais do usuário estiverem incorretas).

```tsx
        console.log(erro)  // 14

```

- **Linha 14**: Exibe o erro no console, o que pode ajudar no diagnóstico e na depuração.

```tsx
        alert('Ocorreu algum erro')  // 15

```

- **Linha 15**: Exibe um alerta na tela informando o usuário de que ocorreu um erro, sem especificar o tipo de erro. Isso poderia ser melhorado para fornecer uma mensagem mais detalhada ao usuário, dependendo da natureza do erro.

```tsx
      }  // 16

```

- **Linha 16**: Fecha o bloco `error`, que é executado caso haja um erro na requisição.

```tsx
    })  // 17

```

- **Linha 17**: Fecha o `subscribe()`. O `subscribe` é usado para assinar o Observable retornado pelo método `login()`, permitindo que o código reaja aos diferentes eventos: `next`, `error`, e `complete`.

```tsx
  }  // 18

```

- **Linha 18**: Fecha o bloco `else` que foi iniciado na linha 4. Esse bloco trata o login quando o usuário não está autenticado.

```tsx
}  // 19

```

- **Linha 19**: Fecha o método `onSubmit()`.

---

### Resumo do funcionamento:

- O método `onSubmit()` lida com duas situações:
    1. **Logout**: Se o usuário já está logado, ele será deslogado usando o método `deslogar()` do serviço de autorização.
    2. **Login**: Se o usuário não está logado, ele tenta fazer login com as credenciais fornecidas no formulário. Caso o login seja bem-sucedido, o `idToken` da resposta é armazenado e o usuário é redirecionado para a página de usuário (`/usuario`). Caso ocorra um erro durante o login, o erro é exibido no console e uma mensagem de alerta é mostrada.

Essa lógica é usada principalmente para gerenciar o estado de login e fornecer uma experiência de usuário fluida ao fazer login ou logout na aplicação.


## 2. Criar dentro do user.service um método getUsersById

> Vamos pegar os dados lá do firebase
> 

```tsx
 getUserById(id: string): Observable<UserReturn> {
    let data = {idToken: localStorage.getItem('token') || ''}
    var url: string = this.FIREBASE_URL + 'v1/accounts:signInWithPassword?key=' + this.TOKEN_FIREBASE;
    return this.segurancaHttp.post<UserReturn>(url, data, httpOptions)
  }
```

🏆 EXPLICANDO ESSE MÉTODO LINHA POR LINHA


## 3. Criar uma rota de ‘usuarios’ que é para onde vamos ser redirecionados após realizar as autenticações

```tsx
{path: 'usuario', component: 'UsuarioComponent'}
```

## 4. Conteúdo do novo componente ‘Usuario’

HTML

```tsx
<p>usuario works!</p>

<h2>Email: {{email}}</h2>
```

TYPESCRIPT

```tsx
import { Component, OnInit } from '@angular/core';
import { UserReturn } from '../../models/userReturn';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css'
})

export class UsuarioComponent implements OnInit {

  email: string = ''
  localId: string = ''
  user: UserReturn = new UserReturn('',[]);
  constructor(private service: UserService) { }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(): void {
    this.service.getUserById('1').subscribe(
      {
        next: (response) => {
          console.log('entrou no response')
          console.log(response)
          //this.users = response;
          if(response){
            this.user = response;
            if(this.user.users){
              this.email = this.user.users[0].email;
            } 
          }
          
          /*
          if(user != null)
          this.email = user.users[0].email*/
        },
        error: (erro: any) => {
          console.log('entrou no erro')
          alert("Usuário ou Senha inválido(s)!");
          console.log(erro)
        }
      }
    )
  }

}
```

🏆 Explicação do código passo a passo

Esse código é um **componente Angular** que provavelmente é parte de uma aplicação web que gerencia dados de usuários. Vou explicar o significado de cada parte do código:

### **Importações (Linhas 1 a 3):**

```tsx
import { Component, OnInit } from '@angular/core';  // 1
import { UserReturn } from '../../models/userReturn';  // 2
import { UserService } from '../../services/user.service';  // 3

```

1. **Linha 1**: Aqui, `Component` e `OnInit` são importados de `@angular/core`. O `Component` é um decorador que é usado para marcar a classe como um componente Angular. O `OnInit` é uma interface usada para implementar um método `ngOnInit()` que é executado após o componente ser inicializado, sendo ideal para chamadas de API ou carregamento de dados.
2. **Linha 2**: A classe `UserReturn` é importada do arquivo `userReturn`. Ela provavelmente define a estrutura de dados que será manipulada nesse componente (por exemplo, informações sobre um usuário).
3. **Linha 3**: O serviço `UserService` é importado do caminho especificado. Esse serviço provavelmente contém métodos para interagir com uma API ou outras fontes de dados relacionadas aos usuários.

### **Componente Angular (Linhas 4 a 8):**

```tsx
@Component({
  selector: 'app-usuario',  // 4
  standalone: true,  // 5
  imports: [],  // 6
  templateUrl: './usuario.component.html',  // 7
  styleUrls: ['./usuario.component.css']  // 8
})

```

1. **Linha 4**: Define o `selector` do componente como `app-usuario`. Esse é o nome do elemento HTML que será usado para incluir esse componente na aplicação (ex: `<app-usuario></app-usuario>`).
2. **Linha 5**: A opção `standalone: true` é uma característica nova do Angular (desde a versão 14), que indica que este componente pode ser usado independentemente, sem a necessidade de ser declarado dentro de um módulo.
3. **Linha 6**: A opção `imports` está vazia aqui, mas ela permitiria importar outros módulos ou componentes que o componente atual necessita.
4. **Linha 7**: Define o caminho para o template HTML do componente. Esse arquivo define a estrutura da interface do usuário para o componente `UsuarioComponent`.
5. **Linha 8**: Define o caminho para o arquivo CSS, onde os estilos do componente são especificados.

### **Classe `UsuarioComponent` (Linhas 9 a 14):**

```tsx
export class UsuarioComponent implements OnInit {  // 9

```

- **Linha 9**: A classe `UsuarioComponent` implementa a interface `OnInit`, o que significa que ela deve implementar o método `ngOnInit()`. Esse método será chamado automaticamente quando o componente for inicializado.

### **Propriedades da classe (Linhas 10 a 13):**

```tsx
  email: string = '';  // 10
  localId: string = '';  // 11
  user: UserReturn = new UserReturn('', []);  // 12
  constructor(private service: UserService) { }  // 13

```

1. **Linha 10**: A propriedade `email` é uma string que inicialmente está vazia. Ela será usada para armazenar o e-mail do usuário.
2. **Linha 11**: A propriedade `localId` é uma string que, aparentemente, armazenará um identificador único para o usuário.
3. **Linha 12**: A propriedade `user` é um objeto da classe `UserReturn`, que provavelmente contém os dados do usuário. Inicialmente, `user` é instanciado com valores padrão (`''` para o e-mail e um array vazio para a lista de usuários).
4. **Linha 13**: O construtor injeta o serviço `UserService` na classe. Isso permite que o componente use esse serviço para realizar operações relacionadas ao usuário, como obter dados de um usuário a partir de uma API.

### **Método `ngOnInit` (Linha 14):**

```tsx
  ngOnInit(): void {  // 14
    this.getUser();  // 15
  }

```

1. **Linha 14**: O método `ngOnInit()` é chamado automaticamente quando o componente é inicializado. Dentro desse método, o método `getUser()` é chamado para buscar os dados do usuário.

### **Método `getUser` (Linhas 16 a 28):**

```tsx
  getUser(): void {  // 16
    this.service.getUserById().subscribe(  // 17
      {  // 18
        next: (response) => {  // 19
          console.log('entrou no response')  // 20
          console.log(response)  // 21
          if (response) {  // 22
            this.user = response;  // 23
            if (this.user.users) {  // 24
              this.email = this.user.users[0].email;  // 25
            }
          }
        },
        error: (erro: any) => {  // 26
          console.log('entrou no erro')  // 27
          alert("Usuário ou Senha inválido(s)!");  // 28
          console.log(erro)  // 29
        }
      }  // 30
    )  // 31
  }  // 32

```

1. **Linha 16**: Define o método `getUser()`, que será responsável por buscar os dados do usuário usando o serviço `UserService`.
2. **Linha 17**: Chama o método `getUserById()` do serviço `UserService`. Esse método provavelmente faz uma requisição HTTP para obter os dados do usuário a partir de um backend ou API. O método `subscribe()` é usado para lidar com a resposta assíncrona.
3. **Linhas 18 a 31**: Aqui é onde o método `subscribe()` é utilizado, que trata a resposta da requisição de forma assíncrona:
- **Linha 19**: Define o bloco `next`, que é chamado quando a requisição é bem-sucedida e uma resposta (`response`) é recebida.
- **Linha 20 e 21**: Registra a mensagem `'entrou no response'` e a resposta no console para depuração.
- **Linha 22**: Verifica se a resposta existe.
- **Linha 23**: Se a resposta existir, ela é atribuída à variável `user`.
- **Linha 24**: Verifica se a resposta contém a propriedade `users`.
- **Linha 25**: Se `users` existir, o e-mail do primeiro usuário na lista é atribuído à variável `email`.
- **Linha 26-31**: Define o bloco `error` que é chamado se houver um erro na requisição. O erro é registrado no console e um alerta é exibido para o usuário com a mensagem `'Usuário ou Senha inválido(s)!'`.

### **Conclusão do Componente:**

Este componente, `UsuarioComponent`, faz parte de uma aplicação Angular e serve para recuperar os dados de um usuário a partir de uma API, usando o serviço `UserService`. Quando o componente é inicializado, ele chama o método `getUser()` para obter essas informações, exibindo o e-mail do usuário após a resposta bem-sucedida.

### Resumo da Lógica:

- O componente busca dados do usuário ao ser inicializado.
- Usa o serviço `UserService` para fazer uma requisição.
- Armazena e exibe o e-mail do usuário se a resposta for bem-sucedida.
- Exibe uma mensagem de erro caso algo dê errado na requisição.

Se precisar de mais explicações ou detalhes, fique à vontade para perguntar!


📌 As versões mais novas do Angular é necessário inicializar as variáveis 


🏆 AGORA APÓS LOGAR VAMOS MOSTRAR O EMAIL


## 5. Agora dentro do Autorizar vamos colocar o token no localStorage

```tsx
  autorizar(token: string){
    localStorage.setItem("login", "sim");
    localStorage.setItem("token", token);
  }
```

🏆 Explicação do código 

Vamos entender o que esse código faz **passo a passo**.

---

### **Código**

```tsx
autorizar(token: string) {
    localStorage.setItem("login", "sim");
    localStorage.setItem("token", token);
}

```

---

### **O que o método faz?**

Este método é usado para armazenar informações no **`localStorage`** do navegador, indicando que um usuário foi autenticado com sucesso. Ele salva:

1. Um valor fixo `"sim"` com a chave `"login"`, que pode ser usado para verificar o estado de autenticação.
2. Um **token de autenticação** associado ao usuário autenticado.

---

### **Passo a passo do funcionamento**

1. **Parâmetro `token`:**
    - O método recebe um parâmetro chamado `token` (do tipo `string`), que é o token de autenticação retornado por uma API, como o Firebase Authentication.
2. **Armazenando o status de login:**
    
    ```tsx
    localStorage.setItem("login", "sim");
    
    ```
    
    - Este comando salva uma chave-valor no **`localStorage`**.
        - **Chave:** `"login"`
        - **Valor:** `"sim"`
    - Esse valor `"sim"` pode ser usado posteriormente para verificar se o usuário está autenticado.
3. **Armazenando o token:**
    
    ```tsx
    localStorage.setItem("token", token);
    
    ```
    
    - Salva o token de autenticação no **`localStorage`**.
        - **Chave:** `"token"`
        - **Valor:** O valor do `token` recebido como parâmetro.
    - Este token é normalmente usado para:
        - Realizar requisições autenticadas (por exemplo, enviá-lo no cabeçalho HTTP para validar o acesso).
        - Identificar o usuário logado.

---

### **O que é o `localStorage`?**

O **`localStorage`** é um armazenamento persistente no navegador que permite salvar dados como pares **chave-valor**. Algumas características:

- Os dados permanecem salvos mesmo após o navegador ser fechado.
- Ideal para armazenar informações simples, como tokens ou preferências do usuário.
- Os dados podem ser acessados usando:
    - **`localStorage.getItem(key)`**: Para ler um item.
    - **`localStorage.setItem(key, value)`**: Para salvar um item.
    - **`localStorage.removeItem(key)`**: Para remover um item.

---

### **Uso Prático**

Este método seria chamado após um login bem-sucedido para salvar o estado de autenticação e o token do usuário. Por exemplo:

### Após o Login:

```tsx
this.authService.login(data).subscribe({
  next: (response) => {
    if (response.idToken) {
      this.autorizacaoService.autorizar(response.idToken); // Salva o login e o token
      this.router.navigate(['/dashboard']); // Redireciona para a página principal
    }
  },
  error: (err) => {
    console.error('Erro de login:', err);
  }
});

```

### Verificação de Login:

Posteriormente, você pode usar o valor salvo no **`localStorage`** para verificar se o usuário está logado:

```tsx
const isLoggedIn = localStorage.getItem("login") === "sim";
console.log(isLoggedIn ? "Usuário está logado" : "Usuário não está logado");

```

---

### **Pontos Importantes**

1. **Segurança:**
    - O **`localStorage`** não é um local seguro para armazenar tokens sensíveis, como o `idToken`. Qualquer script ou extensão maliciosa pode acessá-lo.
    - Em aplicações que exigem alta segurança, considere armazenar tokens em cookies com **HTTP-only**.
2. **Limpar o Login:**
    - Quando o usuário fizer logout, é importante remover essas informações do `localStorage`:
        
        ```tsx
        localStorage.removeItem("login");
        localStorage.removeItem("token");
        
        ```
        
3. **Uso do Token:**
    - O token salvo pode ser usado em requisições autenticadas:
        
        ```tsx
        const token = localStorage.getItem("token");
        if (token) {
          this.http.get("https://api.example.com/protected-endpoint", {
            headers: { Authorization: `Bearer ${token}` },
          });
        }
        
        ```
        

---

### **Resumo**

O método `autorizar`:

1. **Indica que o usuário está logado** salvando `"sim"` com a chave `"login"` no `localStorage`.
2. **Armazena o token de autenticação** recebido para ser usado posteriormente em requisições ou validações de login.

---

🏆 Existe o auth 1.0 e 2.0, esse que estamos usando é o 1.0, por exemplo, login com o google, login com o instagram, isso se trata do login 2.0 pois você passa mais parâmetros e mais trocas, esses tipos de login são bem seguros, mas todos são baseados em JTW, ELES RETORNAM UM TOKEN JWT

---

---

---

## QUE SURGIRAM DURANTE A AULA

### Explica esse código passo a passo

```tsx
 login(data: any): Observable<UserAuth>{
   console.log(data)
   var url: string = this.FIREBASE_URL + 'v1/accounts:signInWithPassword?key=' + this.TOKEN_FIREBASE
   console.log(url)
   return this.segurancaHttp.post<UserAuth>(url, data, httpOptions)
}
```

Vamos analisar o código **passo a passo** para entender o que ele faz e como funciona:

---

### **Código Completo**

```tsx
login(data: any): Observable<UserAuth> {
    console.log(data);
    var url: string = this.FIREBASE_URL + 'v1/accounts:signInWithPassword?key=' + this.TOKEN_FIREBASE;
    console.log(url);
    return this.segurancaHttp.post<UserAuth>(url, data, httpOptions);
}

```

---

### **Passo 1: Declaração do Método**

O método `login` recebe um parâmetro `data` do tipo `any` e retorna um `Observable<UserAuth>`.

### **Detalhes:**

1. **Parâmetro `data`:**
    - O `data` contém as informações necessárias para a autenticação, geralmente um objeto com:
        
        ```json
        {
          "email": "user@example.com",
          "password": "password123",
          "returnSecureToken": true
        }
        
        ```
        
2. **Retorno do Método:**
    - O método retorna um `Observable<UserAuth>`.
    - Isso significa que a chamada de login é assíncrona, e quem usar este método precisará se inscrever nele com `subscribe()` para obter a resposta.

---

### **Passo 2: Exibição do Parâmetro no Console**

```tsx
console.log(data);

```

- Imprime o valor de `data` no console para verificar as informações enviadas, útil para debug.

---

### **Passo 3: Construção da URL da API**

```tsx
var url: string = this.FIREBASE_URL + 'v1/accounts:signInWithPassword?key=' + this.TOKEN_FIREBASE;

```

### **Como funciona:**

1. **`this.FIREBASE_URL`**:
    - Contém a URL base do Firebase Authentication, geralmente algo como:
        
        ```
        https://identitytoolkit.googleapis.com/
        
        ```
        
2. **Endpoint Adicionado**:
    - É anexado o endpoint de login específico do Firebase:
        
        ```
        v1/accounts:signInWithPassword
        
        ```
        
3. **Token Firebase (`this.TOKEN_FIREBASE`)**:
    - Adiciona a chave de API do projeto Firebase como query string (`?key=`):
        
        ```
        ?key=YOUR_API_KEY
        
        ```
        
4. **Resultado Final:**
    - A URL completa será algo como:
        
        ```
        https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDThl5AbjP3GU4XvtdpBn5ZvVUFVXMJMSA
        
        ```
        

---

### **Passo 4: Exibição da URL no Console**

```tsx
console.log(url);

```

- Exibe a URL gerada para confirmar que ela está correta antes de realizar a requisição. Isso ajuda a identificar problemas de configuração, como uma API Key errada.

---

### **Passo 5: Requisição HTTP com `post`**

```tsx
return this.segurancaHttp.post<UserAuth>(url, data, httpOptions);

```

### **Como funciona:**

1. **`this.segurancaHttp.post<T>()`**:
    - Realiza uma requisição HTTP do tipo **POST** para o Firebase, usando o cliente HTTP configurado no Angular.
    - `T` (neste caso, `UserAuth`) especifica o formato esperado da resposta da API.
2. **Parâmetros Passados:**
    - **`url`**: A URL da API construída anteriormente.
    - **`data`**: O objeto contendo as credenciais de login.
    - **`httpOptions`**: Um objeto de configuração para a requisição. Pode incluir cabeçalhos ou outras opções, por exemplo:
        
        ```tsx
        const httpOptions = {
          headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
        };
        
        ```
        
3. **Retorno:**
    - Retorna um `Observable<UserAuth>` para que o componente ou serviço que chamar este método possa se inscrever no resultado.

### **Exemplo de `UserAuth`:**

O tipo `UserAuth` define como será a resposta esperada da API, algo como:

```tsx
export class UserAuth {
  kind: string;
  idToken: string;
  email: string;
  refreshToken: string;
  expiresIn: string;
  localId: string;
}

```

---

### **Passo 6: Uso do Método**

Este método será chamado por outro componente ou serviço para realizar o login. Por exemplo:

```tsx
this.authService.login({
  email: 'user@example.com',
  password: 'password123',
  returnSecureToken: true
}).subscribe({
  next: (response) => {
    console.log('Login bem-sucedido:', response);
  },
  error: (error) => {
    console.error('Erro ao fazer login:', error);
  }
});

```

---

### **Resumo Final**

1. **Recebe dados de login** no parâmetro `data`.
2. **Constrói a URL da API do Firebase**, incluindo a chave de API.
3. **Faz uma requisição HTTP POST** para autenticar o usuário.
4. **Retorna um Observable**, permitindo que o resultado seja processado com `subscribe()`.

Este código é uma implementação comum para autenticação usando o Firebase Authentication em Angular. 🚀

---

---

---

### Esse 'data' eu passo através do formulario?

Sim! O **`data`** é geralmente passado através dos dados de um formulário em Angular. O formulário coleta as informações de login, como o **email** e a **senha**, e os envia como um objeto para o método `login`.

---

### **Como passar os dados do formulário para o método?**

### 1. **Criação de um Formulário no Template**

No arquivo HTML do componente, você pode criar um formulário que captura os dados de email e senha. Por exemplo:

```html
<form (ngSubmit)="onSubmit()" #loginForm="ngForm">
  <input
    type="email"
    name="email"
    [(ngModel)]="email"
    placeholder="Email"
    required
  />
  <input
    type="password"
    name="password"
    [(ngModel)]="password"
    placeholder="Senha"
    required
  />
  <button type="submit">Login</button>
</form>

```

### **Detalhes:**

- **`(ngSubmit)="onSubmit()"`**: Define que a função `onSubmit()` será chamada quando o formulário for enviado.
- **`[(ngModel)]`**: Faz o **two-way data binding** entre o campo do formulário e as propriedades `email` e `password` no TypeScript.
- **`#loginForm="ngForm"`**: Cria uma referência local ao formulário, caso seja necessário acessar propriedades como `valid`.

---

### 2. **Captura dos Dados no Componente (TypeScript)**

No componente TypeScript, defina as variáveis `email` e `password` para armazenar os valores:

```tsx
import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  email = ''; // Valor do campo de email
  password = ''; // Valor do campo de senha

  constructor(private authService: AuthService) {}

  onSubmit() {
    const data = {
      email: this.email,
      password: this.password,
      returnSecureToken: true, // Necessário para o Firebase Authentication
    };

    // Chama o método login passando os dados do formulário
    this.authService.login(data).subscribe({
      next: (response) => {
        console.log('Login bem-sucedido:', response);
      },
      error: (error) => {
        console.error('Erro ao fazer login:', error);
        alert('Falha no login! Verifique suas credenciais.');
      },
    });
  }
}

```

---

### **Explicação do Fluxo**

1. O usuário preenche os campos **email** e **senha** no formulário.
2. Quando o botão "Login" é clicado, o evento `(ngSubmit)` dispara o método `onSubmit()`.
3. O método `onSubmit()`:
    - Cria um objeto `data` com os valores do formulário.
    - Passa esse objeto para o método `login()` do serviço `AuthService`.
4. O método `login()` realiza a requisição HTTP para autenticar o usuário no Firebase.

---

### **Exemplo de Objeto `data`**

Se o usuário preencheu o formulário com:

- Email: `user@example.com`
- Senha: `password123`

O objeto `data` será:

```json
{
  "email": "user@example.com",
  "password": "password123",
  "returnSecureToken": true
}

```

Esse objeto será enviado para o Firebase via requisição POST.

---

### **Conclusão**

Sim, o `data` geralmente vem de um formulário no Angular. Ele pode ser capturado usando:

- **`[(ngModel)]`** para vincular campos do formulário às propriedades no TypeScript.
- O evento **`(ngSubmit)`** para enviar os dados do formulário ao chamar o método `login()`.

---

---

---

### Sem o data nao seria possivel retornar os dados do objeto?

Sem o **`data`**, que contém as credenciais de login (como o email e a senha), não seria possível enviar as informações necessárias ao Firebase para autenticar o usuário. O Firebase Authentication exige esses dados na requisição para que possa processar e retornar uma resposta contendo o objeto do usuário.

---

### **Por que o `data` é obrigatório?**

O **`data`** contém os parâmetros que a API do Firebase Authentication espera para realizar o login. Especificamente, no endpoint **`signInWithPassword`**, o Firebase espera um payload JSON com as seguintes informações mínimas:

1. **`email`**: O email do usuário que está tentando se autenticar.
2. **`password`**: A senha associada à conta.
3. **`returnSecureToken`**: Um valor booleano (`true`) que informa à API para retornar um token seguro.

Se o **`data`** não for enviado, a API não saberá:

- Quem é o usuário que está tentando se autenticar.
- Qual é a senha correspondente.

A requisição falhará com um erro, algo como:

```json
{
  "error": {
    "code": 400,
    "message": "MISSING_PASSWORD",
    "errors": [
      {
        "message": "MISSING_PASSWORD",
        "domain": "global",
        "reason": "invalid"
      }
    ]
  }
}

```

---

### **E se você tentar retornar os dados sem o `data`?**

Sem fornecer o `data`, o Firebase Authentication não retornará as informações do usuário porque a requisição estará incompleta.

### Exemplo de Requisição Errada:

```tsx
login(): Observable<UserAuth> {
  const url = this.FIREBASE_URL + 'v1/accounts:signInWithPassword?key=' + this.TOKEN_FIREBASE;

  // Sem enviar dados (email e password), a requisição será inválida
  return this.segurancaHttp.post<UserAuth>(url, {}, httpOptions);
}

```

### Resultado:

- O Firebase responderá com um erro indicando a ausência de dados obrigatórios.
- A resposta da API será algo como:
    
    ```json
    {
      "error": {
        "message": "MISSING_EMAIL"
      }
    }
    
    ```
    

---

### **Conclusão**

O **`data`** é **obrigatório** porque:

1. Ele contém as informações necessárias (como email e senha) para que o Firebase possa autenticar o usuário.
2. Sem ele, a API não consegue processar a requisição, e nenhum dado será retornado.

Portanto, sempre forneça o `data` contendo os campos obrigatórios ao chamar o método de login.