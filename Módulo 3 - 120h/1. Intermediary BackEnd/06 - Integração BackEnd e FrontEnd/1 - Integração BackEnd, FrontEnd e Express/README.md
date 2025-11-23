# 1 → INTEGRAÇÃO BACK-END, FRONT-END E EXPRESS

### DIAGRAMA DE ENTIDADE E RELACIONAMENTO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/Integra%C3%A7%C3%A3oBackeFront.png"/>

---

🏆 Vamos começar fazendo a integração trazendo o que precisamos pro back-end primeiro, que é a exposição dessas rotas para o front-end.

> Para fazer essa exposição vamos utilizar o modo cors do NODE (disponibiliza rotas para o front end).
> 

### O QUE É O CORS DO NODE?

O **CORS** (Cross-Origin Resource Sharing) no Node.js é um **mecanismo de segurança** usado pelos navegadores para **controlar quais domínios podem fazer requisições** para o seu backend.

---

# ✅ **Explicação simples**

Imagine que seu backend está em:

```
http://localhost:3000

```

E seu frontend Angular está em:

```
http://localhost:4200

```

O **navegador bloqueia** requisições de um domínio diferente *por padrão* (por segurança).

O **CORS** diz ao navegador:

> “Tudo bem, esse outro domínio pode acessar os meus endpoints.”
> 

---

# 🔧 **No Node.js (Express)**

Geralmente você habilita assim:

```jsx
const cors = require('cors');
app.use(cors());

```

Ou permitindo apenas domínios específicos:

```jsx
app.use(cors({
  origin: 'http://localhost:4200'
}));

```

---

# 📌 O que o CORS faz?

O CORS habilita o servidor a responder com cabeçalhos do tipo:

```
Access-Control-Allow-Origin: http://localhost:4200
Access-Control-Allow-Methods: GET, POST, PUT, DELETE
Access-Control-Allow-Headers: Content-Type, Authorization

```

Sem isso, o navegador **bloqueia a requisição** — mesmo que o servidor responda.

---

# ❗ Sem CORS → Erro clássico no console

Você vê mensagens como:

```
Access to fetch at 'http://localhost:3000/getAllUsers' from origin 'http://localhost:4200'
has been blocked by CORS policy.

```

---

# 📘 Resumo final

| O que é? | Para que serve? | Onde é usado? |
| --- | --- | --- |
| Uma *política de segurança do navegador* | Para permitir que o frontend acesse o backend | No servidor Node/Express |

---

### O CORS DISPONIBILIZA ROTAS PARA O FRONT-END?

<aside>
🏆

# ✅ O que *realmente* é o CORS no Node.js?

**CORS = Cross-Origin Resource Sharing**

É **um mecanismo de segurança** do navegador que controla *quem pode acessar sua API*.

O navegador **bloqueia** requisições vindas de domínios diferentes — por exemplo:

- Front-end em: `http://localhost:4200`
- Backend em: `http://localhost:3000`

Por serem origens diferentes, o navegador bloqueia.

👉 É aí que entra o **CORS**, para permitir que essas requisições sejam realizadas.

---

# ❌ O que o CORS *não* faz

- Não cria rotas.
- Não disponibiliza rotas.
- Não altera o backend.
- Não altera o front-end.
- Não tem nada a ver com lógica da API.

---

# ✅ O que o CORS *faz de verdade*

O CORS **só libera o acesso a rotas que já existem** no backend.

Exemplo:

```jsx
import cors from "cors";
app.use(cors());

```

Isso apenas diz ao navegador:

> “Sim, o front-end pode acessar as rotas desse servidor.”
> 

Se você NÃO ativar o CORS, suas rotas continuam existindo — mas o navegador vai bloquear o acesso.

---

# 📌 Resumo simples

| Pergunta | Resposta |
| --- | --- |
| O CORS cria rotas? | ❌ Não |
| O CORS disponibiliza rotas? | ❌ Não |
| O CORS autoriza o front a acessar rotas existentes? | ✅ Sim |
| Sem CORS o backend funciona? | ✅ Sim, mas o navegador bloqueia |

---



---

🏆 Para acrescentar o CORS na aplicação, precisamos ir na pasta do back-end e colocar no index.js a seguinte linha de código:

```jsx
app.use(cors());
```

> Caso você esteja trabalhando com uma aplicação back-end que precisa limitar o acesso do usuário de alguma forma, é necessário estudar o módulo e fazer de acordo com a sua necessidade.
> 

---

### SHARED.SERVICE

🏆 Vai ser o responsável por todo o tratamento de dados compartilhados, vamos iniciar fazendo duas funções:

- GET users
- GET courses

> Vai fazer o tratamento do que vem do back-end para nossa tela.
> 
</aside>

### CÓDIGO DO SHARED SERVICE

```jsx
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Observable, of } from "rxjs";

//Criar esses exports
export interface Params {
    [key: string]: any;
}

@Injectable({
    providedIn: 'root'
})
export class SharedService {

    users: Array<{ value: string, label: string }> = [];
    courses: Array<{ value: string, label: string }> = [];

    getUsers(): Observable<any[]> {
        return this.http
            .get("http://localhost:3000/getAllUsers")
            .pipe(
                map(x => {
                    Object.values(x).map((_user) => {
                        let u = { value: _user.id, label: _user.first_name }
                        this.users.push(u);
                    })
                    console.log(x);
                    console.log(this.users);
                    return this.users;
                })
            );
    }

    getCourses(): Observable<any[]> {
        return this.http
            .get("http://localhost:3000/getAllCourses")
            .pipe(
                map(x => {
                    Object.values(x).map((_course) => {
                        let c = { value: _course.id, label: _course.name }
                        this.courses.push(c);
                    })
                    console.log(x);
                    console.log(this.courses);
                    return this.courses;
                })
            );
    }

    constructor(
        private http: HttpClient
    ) {
    }
}

```

### EXPLICAÇÃO DETALHADA DO CÓDIGO

🏆

```tsx
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Observable, of } from "rxjs";

```

### Explicação

- Essas linhas servem para **trazer funcionalidades prontas** para dentro do arquivo.
- Pense nisso como “importar ferramentas”.
- `HttpClient` é a ferramenta que permite o código **conversar com um servidor** e pedir informações pela internet.
- `Injectable` é algo que o Angular usa para permitir que essa classe seja usada em outras partes da aplicação.
- `map`, `Observable`, `of` são coisas do RxJS (uma biblioteca usada pelo Angular para lidar com dados que chegam de forma assíncrona).
    - `Observable` significa “uma fonte de dados que ainda vai chegar”.
    - `map` transforma os dados quando eles chegam.
    - `of` cria um Observable manualmente (mas aqui nem está sendo usado).

---

```tsx
//Criar esses exports
export interface Params {
    [key: string]: any;
}

```

### Explicação

- `interface` é como um **molde** que descreve como um objeto deve ser.
- Aqui temos um molde chamado `Params`.
- `[key: string]: any;` significa:
    - “Esse objeto pode ter **qualquer número de propriedades**, com **qualquer nome**, e com **qualquer tipo de valor**”.
- É como dizer:
    
    “Isso aqui pode receber *qualquer coisa* que venha em formato de chave e valor”.
    

---

```tsx
@Injectable({
    providedIn: 'root'
})
export class SharedService {

```

### Explicação

- `@Injectable({ providedIn: 'root' })` quer dizer:
    
    > Esse serviço será criado uma única vez e poderá ser usado por toda a aplicação.
    > 
- `export class SharedService` é a classe onde você vai colocar funcionalidades que poderão ser reaproveitadas por várias telas/componentes do Angular.
- É como criar uma “caixa de ferramentas compartilhada”.

---

```tsx
    users: Array<{ value: string, label: string }> = [];
    courses: Array<{ value: string, label: string }> = [];

```

### Explicação

- Aqui estamos criando **duas listas vazias**:
    - `users` (usuários)
    - `courses` (cursos)
- Cada item dentro dessas listas terá **sempre** o formato:
    
    ```tsx
    { value: string, label: string }
    
    ```
    
- Esse formato normalmente é usado para **popular dropdowns e selects** (combobox).
- `value` costuma ser o **id do banco**,
    
    `label` costuma ser o **nome que aparece na tela**.
    

---

```tsx
    getUsers(): Observable<any[]> {

```

### Explicação

- Aqui declaramos um método chamado `getUsers`.
- Ele vai devolver um **Observable**, ou seja:
    
    > Vai devolver uma informação que ainda não chegou, mas chegará no futuro.
    > 
- Como pedir comida por delivery:
    - você faz o pedido (requisição),
    - espera chegar (subscribe),
    - e quando chega você usa.

---

```tsx
        return this.http

```

### Explicação

- `this.http` é o HttpClient (a ferramenta para acessar o servidor).
- **IMPORTANTE:** para isso funcionar, o serviço precisa ter um constructor assim:
    
    ```tsx
    constructor(private http: HttpClient) {}
    
    ```
    
- Caso contrário `this.http` será **undefined** e o código quebra.

---

```tsx
            .get("http://localhost:3000/getAllUsers")

```

### Explicação

- Isso aqui faz uma requisição do tipo **GET** para o endereço do backend:
    
    `http://localhost:3000/getAllUsers`
    
- É como dizer:
    
    > “Servidor, me envie todos os usuários cadastrados”.
    > 

---

```tsx
            .pipe(

```

### Explicação

- O `pipe` é usado para **modificar** ou **tratar** os dados que chegam da requisição.
- Dentro dele colocamos operadores (como o `map`).

---

```tsx
                map(x => {

```

### Explicação

- `map` recebe o dado que veio do servidor (`x`) e permite **transformá-lo**.
- O que for retornado aqui dentro será o valor final que chega ao componente.

---

```tsx
                    Object.values(x).map((_user) => {

```

### Explicação

- `Object.values(x)` transforma o objeto recebido em um **array contendo apenas os valores**.
- Exemplo:
    
    Se `x` fosse:
    
    ```tsx
    { a: 10, b: 20 }
    
    ```
    
    `Object.values(x)` vira:
    
    ```tsx
    [10, 20]
    
    ```
    
- Em seguida, fazemos `.map` para **percorrer cada usuário** recebido.

---

```tsx
                        let u = { value: _user.id, label: _user.first_name }

```

### Explicação

- Para cada usuário `_user`, criamos um novo objeto `u` com o formato:
    
    ```tsx
    { value: id do usuário, label: primeiros nome do usuário }
    
    ```
    
- Esse é o formato usado pelo Angular para listas exibidas no frontend.

---

```tsx
                        this.users.push(u);

```

### Explicação

- Adiciona o objeto `u` na lista `users` que está dentro do serviço.
- Ou seja, a lista vai sendo preenchida com os usuários transformados.
- **Detalhe importante:** se esse método for chamado mais de uma vez, a lista vai duplicar os itens, porque nunca é esvaziada.

---

```tsx
                    })

```

### Explicação

- Fecha o `.map` que percorreu cada usuário recebido do backend.

---

```tsx
                    console.log(x);
                    console.log(this.users);

```

### Explicação

- `console.log(x)` mostra no navegador a resposta original do servidor.
- `console.log(this.users)` mostra como ficou a lista de usuários após ser montada.
- Isso é apenas para **debug** — não afeta o comportamento da aplicação.

---

```tsx
                    return this.users;

```

### Explicação

- O valor retornado aqui será o valor final entregue ao componente que chamou `getUsers()`.
- Portanto, quando o componente fizer:
    
    ```tsx
    this.sharedService.getUsers().subscribe(users => ...)
    
    ```
    
    Ele receberá exatamente o conteúdo de `this.users`.
    

---

```tsx
                })
            );
    }
}

```

### Explicação final

- Fecha o operador `map`, o `pipe`, o método `getUsers`, e a classe do serviço.
- A função completa funciona assim:
1. Faz uma requisição ao servidor.
2. Espera os dados chegarem.
3. Pega cada usuário e transforma no formato `{ value, label }`.
4. Coloca cada objeto transformado dentro da lista `this.users`.
5. Retorna essa lista transformada para quem chamou a função.

---


### EXPLICANDO A QUESTÃO DA INTERFACE PARAMS

🏆

# 👉 O QUE ESSA INTERFACE SIGNIFICA

```tsx
export interface Params {
    [key: string]: any;
}

```

Parece que está vazia, mas **na verdade ela diz uma regra muito poderosa**:

> “Qualquer objeto do tipo Params pode ter qualquer quantidade de propriedades, com qualquer nome, e com qualquer tipo de valor.”
> 

Essa linha aqui:

```tsx
[key: string]: any;

```

É o que chamamos de **assinatura de índice** (*index signature*).

---

# 👉 EXPLICANDO EM LINGUAGEM DE LEIGO

Imagine que você está dizendo:

> “Este objeto pode receber qualquer chave (‘nome’, ‘idade’, ‘cidade’, ‘qualquerCoisa’) e o valor pode ser qualquer coisa.”
> 

Então isto é válido:

```tsx
const p: Params = {
  nome: "Vinicius",
  idade: 23,
  ativo: true,
  altura: 1.80,
  qualquerCoisa: [1,2,3],
};

```

Por quê?

Porque **todas são chaves do tipo string**, e **todos os valores são de qualquer tipo**.

---

# 👉 POR QUE USAR ISSO?

Quando você não sabe previamente

**quais campos um objeto terá**,

mas sabe que será algo tipo “chave: valor”.

Exemplos comuns:

- filtros de uma busca
- parâmetros de URL
- query params
- formulários dinâmicos
- objetos que o backend monta com campos variáveis

---

# 👉 COMPARANDO COM UMA INTERFACE NORMAL

Uma interface comum é assim:

```tsx
interface Usuario {
  id: number;
  nome: string;
}

```

Aqui as chaves são fixas.

Mas com `Params`, você está dizendo:

> “Não sei quais chaves existirão,
> 
> 
> mas sei que podem existir quantas quiser.”
> 

---

# 👉 ENTÃO NÃO É “VAZIA”

Ela não está vazia — ela apenas tem um formato **genérico e flexível**.

Essa linha:

```tsx
[key: string]: any;

```

É um campo só, mas ele define uma **regra universal** para o objeto completo.

---

# 👉 EXEMPLO SIMPLES DA VIDA REAL

Imagine um objeto onde você guarda filtros:

```tsx
let filtros: Params = {};

filtros["nome"] = "Ana";
filtros["idadeMin"] = 18;
filtros["ativo"] = true;

```

Nenhuma dessas propriedades foi declarada antes…

mas como existe uma index signature, **está tudo permitido**.

---

# 👉 RESUMO

A interface **não está vazia**.

Ela diz:

✔ “qualquer chave string”

✔ “qualquer valor”

✔ “quantas chaves quiser”

É como criar um **objeto totalmente flexível**, mas ainda mantendo o TypeScript satisfeito.

---

Se quiser, posso te mostrar:

- como transformar essa interface em algo mais seguro,
- como limitar tipos dos valores,
- ou como restringir apenas algumas chaves.

---

### POR QUE USAR O CONSTRUCTOR COM O HTTP CLIENT COMO ARGUMENTO?

🏆

# **Por que existe esse constructor específico?**

Você mostrou:

```tsx
constructor(
    private http: HttpClient
)

```

Este constructor existe **apenas** para que o Angular injete (entregue) um objeto chamado `HttpClient` dentro da classe.

---

# ⚙️ **3. O que é `HttpClient`?**

É a ferramenta com a qual você **faz chamadas para APIs**, como:

- GET (buscar dados)
- POST (criar dados)
- PUT (editar dados)
- DELETE (remover dados)

É o "telefone" que o Angular usa para conversar com o servidor.

Sem ele, sua classe não consegue fazer requisições HTTP.

---

# 🎯 **4. Por que escrever `private http: HttpClient` dentro do constructor?**

Isso faz duas coisas ao mesmo tempo:

### ✔️ 1. O Angular faz *injeção de dependência*

Que é só um jeito bonito de dizer que:

> O Angular entrega para sua classe uma ferramenta pronta (HttpClient).
> 

Você não precisa criar manualmente com `new HttpClient()` — o Angular faz isso por você.

### ✔️ 2. Cria uma **propriedade da classe** automaticamente

Você não precisa escrever:

```tsx
private http: HttpClient;

constructor(http: HttpClient) {
    this.http = http;
}

```

O Angular deixa isso tudo implícito na forma curta:

```tsx
constructor(private http: HttpClient) {}

```

Ou seja:

- `private` → só pode ser usado dentro da classe
- `http` → o nome da ferramenta
- `HttpClient` → o tipo da ferramenta

---

# 🎯 **5. O que acontece se você remover esse constructor?**

→ A classe **não terá acesso** ao `HttpClient`.

→ E qualquer método que tente usar:

```tsx
this.http.get(...)

```

Vai dar erro:

**"Property 'http' does not exist"**

---

# 🧠 **6. Uma analogia simples**

Imagine que sua classe é um funcionário.

O constructor é como a lista de ferramentas que o funcionário recebe no primeiro dia:

```tsx
constructor(private http: HttpClient)

```

Isso é o Angular falando:

> “Toma aqui o HttpClient, você vai precisar dele para trabalhar.”
> 

Sem essa ferramenta, o funcionário não consegue fazer o trabalho.

---

# 📝 **7. Exemplo real simples**

Classe sem Angular:

```tsx
class Pessoa {
    constructor(nome) {
        this.nome = nome;
    }
}

```

Classe no Angular:

```tsx
export class UserService {

    constructor(private http: HttpClient) {}

    getUsers() {
        return this.http.get('https://api.com/users');
    }
}

```

Quando o serviço `UserService` é criado, o Angular automaticamente coloca um `HttpClient` dentro do atributo `http`.

---

# ✔️ **Resumo final**

| Parte | Para que serve |
| --- | --- |
| `constructor(...)` | É o método que recebe dependências da classe |
| `private http: HttpClient` | Pede para o Angular fornecer um `HttpClient` pronto |
| Injeção de Dependência | Angular cria e entrega o objeto automaticamente |
| Sem isso | Não dá pra usar `this.http` para fazer requisições |