# 4 → APLICAÇÃO COM EXPRESS

### O QUE É O EXPRESS?

🏆

**Express** é um **framework do Node.js** usado para **criar servidores e APIs de forma simples e rápida**.

👉 Ele facilita o trabalho com **rotas**, **requisições HTTP (GET, POST, PUT, DELETE)** e **respostas ao cliente**, sem precisar usar o módulo `http` manualmente.

📦 Exemplo básico:

```jsx
import express from 'express';
const app = express();

app.get('/', (req, res) => {
  res.send('Olá, mundo!');
});

app.listen(3000, () => console.log('Servidor rodando na porta 3000'));

```

➡️ **Resumindo:** Express = maneira prática e moderna de criar servidores no Node.js.


---

🏆 Vamos começar criar a base do back end, e depois criaremos o front end.


🏆 É um dos frameworks mais utilizados com nodeJS que temos no mercado.


---

### ESTRUTURA DA NOSSA APLICAÇÃO

![image.png](attachment:e04c1708-e7ec-4060-8f93-23cbec4066b8:image.png)

---

### VAMOS COLOCAR ALGUNS PACOTES QUE VAI FAZER PARTE DA NOSSA ESTRUTURA DO BACK END, SÃO ELES:

- models
- routes
- repositories
- service

💡 E vamos ter um arquivo index.js que é o padrão que colocamos no json para inicializar o projeto.

💡 Antes de iniciar com o arquivo index, vamos trazer a biblioteca express para aplicação

```bash
npm install express
```

> Caso você use o express junto com algum outro framework de front-end, a instalação já pode ser feita junto.
> 

### EXPLICANDO RESUMIDAMENTE OS IMPORTS DO ARQUIVO INDEX.JS

🏆

---

### 🧩 Linha por linha:

```jsx
import express from "express";

```

👉 **Importa o framework Express**, usado para criar **servidores HTTP e rotas** de forma simples no Node.js.

---

```jsx
import pkg from "body-parser";

```

👉 **Importa o Body-Parser**, uma biblioteca que **lê e interpreta o corpo (body)** das requisições HTTP, por exemplo dados enviados em formulários ou JSON.

---

```jsx
import router from "./routes/router.js";

```

👉 **Importa um módulo local** chamado `router.js`, onde normalmente ficam **as rotas da aplicação** (ex: `/login`, `/users`, etc).

---

📦 **Resumo geral:**

- **express** → cria o servidor e define rotas.
- **body-parser** → entende os dados enviados nas requisições.
- **router** → organiza e centraliza as rotas da aplicação.

### CÓDIGO DO ARQUIVO `INDEX.JS`

```bash
import {express} from "express"
import {pkg} from "body-parser"
import {router} from "./routes/router.js"

const app = express()
const {json, urlendcoded} = pkg

app.use(json());
app.use(urlendcoded({ extended: true }))

app.listen(3000, function(){
    console.log("Listening from 3000")
})

// rotas
app.use("/", router)
```

### EXPLICAÇÃO DO CÓDIGO

🏆

---

### 🧩 **Linha a linha:**

```jsx
import express from "express";

```

➡️ Importa o **framework Express**, usado para criar o servidor e lidar com rotas e requisições HTTP.

---

```jsx
import pkg from "body-parser";

```

➡️ Importa o **Body-Parser**, que serve para **interpretar o corpo (body)** das requisições (por exemplo, dados de formulários ou JSON enviados pelo cliente).

---

```jsx
import router from "./routes/router.js";

```

➡️ Importa o **arquivo de rotas** (`router.js`), onde estão definidas as rotas da aplicação (ex: `/login`, `/users`, etc).

---

```jsx
const app = express();

```

➡️ Cria uma **instância do Express**, que representa o servidor da aplicação.

---

```jsx
const { json, urlencoded } = pkg;

```

➡️ Extrai duas funções do Body-Parser:

- **`json()`** → para interpretar requisições com corpo em formato JSON.
- **`urlencoded()`** → para interpretar dados enviados via formulários (formulário HTML, por exemplo).

*(Obs: no seu código tem um pequeno erro de digitação: é `urlencoded`, não `urlendcoded`.)*

---

```jsx
app.use(json());
app.use(urlencoded({ extended: true }));

```

➡️ Diz ao Express para **usar o Body-Parser** e conseguir entender os dados enviados nas requisições.

---

```jsx
app.listen(3000, function() {
    console.log("Listening from 3000");
});

```

➡️ **Inicia o servidor** na **porta 3000**, e mostra uma mensagem no console quando estiver rodando.

---

```jsx
app.use("/", router);

```

➡️ **Conecta as rotas** do arquivo `router.js` à aplicação principal.

Tudo que vier da URL “/” será tratado pelas rotas definidas nesse arquivo.

---

### ⚙️ **Resumo geral:**

| Parte | Função |
| --- | --- |
| `express()` | Cria o servidor |
| `body-parser` | Lê o corpo das requisições |
| `router` | Define as rotas do sistema |
| `app.listen(3000)` | Roda o servidor na porta 3000 |

---



---

### VAMOS CRIAR ALGUNS ARQUIVOS NO PACOTE MODELS (POR ENQUANTO VAZIOS)

- Course.js
- User.js
- Teacher.js
- Evaluation.js

### PASTA SERVICES E SEUS ARQUIVOS

- CourseService.js
- EvaluationService.js
- TeacherService.js
- UserService.js

### VAMOS TAMBÉM CRIAR A PASTA ROUTES QUE ESTAVA FALTANDO E DENTRO DELA CRIAR ALGUNS ARQUIVOS QUE VAMOS UTILIZAR DURANTE A CRIAÇÃO DO PROJETO.

- UserController.js
- TeacherController.js
- CourseController.js
- EvaluationController.js


🏆 A base do controller vai ser cada arquivo desse trazer o router e o import do service de cada um deles


🏆 Iniciando o desenvolvimento do arquivo `UserController.js`

```bash
import express from "express";

let router = express.Router();

import userService from "../services/UserService.js"

export default router
```

### EXPLICAÇÃO DO CÓDIGO

---

```jsx
import express from "express";

```

➡️ **Importa o módulo Express** — o framework usado para criar e gerenciar rotas, servidores e middlewares no Node.js.

---

```jsx
let router = express.Router();

```

➡️ **Cria um objeto de roteador (Router)** do Express.

Esse `router` é como uma miniaplicação que permite definir rotas separadas (como `/login`, `/users`, etc.) e depois exportá-las para o arquivo principal (`app.js` ou `index.js`).

Assim o código fica mais **organizado e modular**.

---

```jsx
import userService from "../services/UserService.js"

```

➡️ **Importa um módulo chamado `UserService`** (que está em uma pasta `services` acima do diretório atual).

Esse arquivo provavelmente contém **funções de lógica de negócio**, como criar, atualizar ou buscar usuários no banco de dados.

O `router` vai usar essas funções para responder às requisições.

---

```jsx
export default router

```

➡️ **Exporta o `router`** para que ele possa ser usado em outro arquivo, geralmente com algo como:

```jsx
import router from "./routes/router.js";
app.use("/", router);

```

Assim, o Express passa a reconhecer as rotas que foram definidas dentro desse módulo.

---


---

### POR QUE TEMOS TODA ESSA ESTRUTURA?

### 🧩 1. **Por que ter um arquivo de controller separado (ex: `UserController.js`, `CourseController.js`, etc.)**

Cada **controller** representa um **grupo de rotas e regras específicas de um recurso** do seu sistema.

Por exemplo:

- `UserController.js` → lida com usuários (`/users`)
- `CourseController.js` → lida com cursos (`/courses`)
- `EvaluationController.js` → lida com avaliações (`/evaluations`)
- `TeacherController.js` → lida com professores (`/teachers`)

➡️ Essa separação é feita por **responsabilidade**.

Cada controller:

- define as **rotas** (GET, POST, PUT, DELETE);
- recebe os **dados** da requisição (`req.body`, `req.params`, `req.query`);
- chama o **service** correspondente para executar a lógica de negócio;
- envia a **resposta** (`res.json`, `res.send`, etc.).

---

### ⚙️ 2. **E por que chamar o “service” dentro de cada controller?**

Os **services** contêm a **lógica de negócio** — ou seja, o “cérebro” da aplicação.

Eles sabem **como manipular dados**, **acessar o banco de dados**, **fazer validações**, etc.

O **controller** apenas **orquestra** o fluxo:

1. Recebe a requisição.
2. Pega os dados enviados.
3. Chama o **service** correto.
4. Devolve o resultado.

👉 Isso separa as **funções de cada camada**, deixando o código mais limpo e fácil de manter.

---

### 🧠 3. Estrutura resumida de camadas (MVC simplificado)

| Camada | Responsabilidade | Exemplo |
| --- | --- | --- |
| **Controller** | Receber a requisição e chamar o service | `UserController.js` |
| **Service** | Contém a lógica de negócio | `UserService.js` |
| **Model** | Define a estrutura do dado (ex: banco de dados) | `User.js` |
| **Router** | Define as rotas e conecta ao controller | `router.js` |

---

### 📚 4. Exemplo prático

**📁 UserController.js**

```jsx
import express from "express";
import userService from "../services/UserService.js";

const router = express.Router();

router.get("/", async (req, res) => {
  const users = await userService.getAllUsers();
  res.json(users);
});

export default router;

```

**📁 UserService.js**

```jsx
const users = [
  { id: 1, name: "Vinicius" },
  { id: 2, name: "Ana" }
];

export default {
  getAllUsers() {
    return users;
  }
};

```

**📁 index.js**

```jsx
import express from "express";
import userController from "./controllers/UserController.js";

const app = express();
app.use("/users", userController);
app.listen(3000);

```

➡️ Assim, ao acessar `GET /users`, o Express chama o controller → que chama o service → que retorna os dados.

---

### ✅ Vantagens dessa estrutura:

- Organização por **responsabilidade**.
- Facilita manutenção e testes.
- Permite **reutilizar** código (ex: o mesmo `UserService` pode ser usado por outro controller).
- Torna o sistema **escalável**, fácil de crescer sem virar uma bagunça.

---

### VAMOS CRIAR OS REPOSITORIES

- UserRepository
- TeacherRepository
- CourseRepository
- EvaluationRepository

🏆 OS ARQUIVOS SERVICES VÃO IMPORTAR OS ARQUIVOS REPOSITORIES

> Por enquanto só vamos realizar as importações, os arquivos vão ser populados nas próximas aulas.
> 

🏆 Apenas o controller expõe o router, o service expõe as funções do service (regras de negócio em geral) 

🏆 

`export default service;` → significa que posso utilizar uma classe dentro de outra classe


---

### EXPLICANDO BREVEMENTE A ESTRUTURA DA CLASSE REPOSITORY

🏆

```bash
import userRepository from "../repositories/UserRepository.js"

const service = {

}

export default service; 
```

🏆

### EXPLICAÇÃO DO CÓDIGO

---

```jsx
import userRepository from "../repositories/UserRepository.js";

```

🔹 **Importação de módulo**

Aqui o código está **trazendo** (importando) algo que foi **exportado** de outro arquivo — `UserRepository.js`.

Esse arquivo provavelmente contém funções de acesso a dados (ex: salvar, buscar, atualizar usuários no banco).

💡 Em outras palavras:

> “Pegue o objeto ou classe exportado de UserRepository.js e disponibilize aqui com o nome userRepository.”
> 

---

```jsx
const service = {

};

```

🔹 **Criação de um objeto vazio chamado `service`**

Esse objeto servirá para **guardar funções** relacionadas à **lógica de negócio** de usuários.

➡️ Normalmente, você colocaria dentro dele métodos como:

```jsx
const service = {
  getAllUsers() { ... },
  createUser(data) { ... }
};

```

Essas funções usariam o `userRepository` para acessar o banco de dados.

💬 Em resumo:

> O service é o intermediário entre o controller e o repositório.
> 
> 
> Ele recebe dados do controller, aplica regras de negócio e usa o `repository` para buscar ou salvar no banco.
> 

---

```jsx
export default service;

```

🔹 **Exportação padrão (default)**

Essa linha **torna o objeto `service` disponível** para ser usado em outros arquivos.

➡️ Assim, em outro arquivo, você pode importar e usar:

```jsx
import userService from "../services/UserService.js";
userService.getAllUsers();

```

💬 Em resumo:

> “Deixe esse objeto service público, para que outros módulos possam utilizá-lo.”
> 

---

### 🧠 Resumo geral (linha a linha + propósito)

| Linha | O que faz | Papel na arquitetura |
| --- | --- | --- |
| `import userRepository...` | Importa o módulo que fala com o banco | Acesso a dados |
| `const service = {}` | Cria um objeto para funções de negócio | Lógica de negócio |
| `export default service;` | Exporta o `service` para uso externo | Disponibiliza o serviço para o controller |

---

### 📊 Em termos de **camadas (MVC / Clean Architecture)**

```
Controller → Service → Repository → Banco de Dados

```

- **Controller:** recebe a requisição HTTP e chama o service.
- **Service:** aplica regras de negócio e usa o repository.
- **Repository:** faz a comunicação direta com o banco de dados.

---

### 💬 Exemplo prático (para fixar)

```jsx
// 📁 UserRepository.js
export default {
  findAll() {
    return ["Vinicius", "Ana"];
  }
};

```

```jsx
// 📁 UserService.js
import userRepository from "../repositories/UserRepository.js";

const service = {
  getUsers() {
    return userRepository.findAll();
  }
};

export default service;

```

```jsx
// 📁 UserController.js
import userService from "../services/UserService.js";

console.log(userService.getUsers()); // ["Vinicius", "Ana"]

```

---

👉 **Em resumo final:**

Esse código está **importando um repositório**, **criando um objeto de serviço** (que ainda será preenchido com funções), e **exportando** esse serviço para que outras partes da aplicação (como o controller) possam usá-lo.


---

### INICIANDO OS ARQUIVOS REPOSITORIES

🏆 No repository vamos criar o nosso tratamento de dados

🏆 Vamos importar no repository nossas classes de models


### ARQUIVO COURSEREPOSITORY POR ENQUANTO

```bash
import User from "../models/User"

// fabrica de funções
const factory = {

}

export default factory;
```

> Vai ser replicado dessa forma para os outros arquivos repositories.
> 

---

🏆 NA NOSSA PASTA ROUTES, ALÉM DOS ARQUIVOS CONTROLLER VAMOS TER O ARQUIVO ROUTER QUE SERÁ RESONSÁVEL POR DESIGNAR UMA ROTA ESPECIFICA.
