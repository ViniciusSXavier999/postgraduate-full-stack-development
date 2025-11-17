# 6 → CRIAÇÃO DE CRUD

### O QUE É A ESTRUTURA DO CRUD?

🏆

- CREATE → CRIAÇÃO
- READ → LEITURA
- UPDATE → ATUALIZAÇÃO
- DELETE → EXCLUIR

> Isso é o que denominamos de CRUD básico.
> 

---

### VAMOS COMEÇAR O DESENVOLVIMENTO DOS ARQUIVOS DA PASTA ROUTE.

🏆 Esse router é o arquivo que vai disponibilizar para o front-end as rotas que podem ser acessadas no nosso back-end


🏆 Todos os controllers vão começar da tela inicial que é o (”/”), essa é a raiz da aplicação.


### CÓDIGO DO ARQUIVO ROUTER

```bash
import express from "express"
let router = express.Router()

import userController from "./UserController.js"
import courseController from "./CourseController.js"
import teacherController from "./TeacherController.js"
import evaluationController from "./EvaluationController.js"

router.get("/", function(req, res){
    console.log("oi!")
    // só para ver se deu erro
    res.status(200).json({message: "sucesso!"})
})

// vamos fazer o router utilizar todos os nossos controllers 

router.use("/", userController)
router.use("/", teacherController)
router.use("/", courseController)
router.use("/", evaluationController)

export default router;
```

### EXPLICAÇÃO DO CÓDIGO

🏆

Esse código é um **roteador principal** (um *router central*) que junta todos os controladores da sua aplicação Express.

Vamos entender **resumidamente**, mas linha a linha 👇

---

```jsx
import express from "express"
let router = express.Router()

```

➡️ Importa o **Express** e cria um **objeto router**,

que serve para agrupar várias rotas (como `/users`, `/teachers`, etc.) em um único módulo.

---

```jsx
import userController from "./UserController.js"
import courseController from "./CourseController.js"
import teacherController from "./TeacherController.js"
import evaluationController from "./EvaluationController.js"

```

➡️ Importa todos os **controladores** (cada um é um router separado) —

ou seja, cada controller tem suas próprias rotas específicas.

---

```jsx
router.get("/", function(req, res){
    console.log("oi!")
    res.status(200).json({message: "sucesso!"})
})

```

➡️ Cria uma rota simples de teste (`GET /`).

Quando acessada, mostra “oi!” no console e responde com `{ message: "sucesso!" }` em JSON.

Serve para verificar se o servidor está funcionando corretamente.

---

```jsx
// vamos fazer o router utilizar todos os nossos controllers
router.use("/", userController)
router.use("/", teacherController)
router.use("/", courseController)
router.use("/", evaluationController)

```

➡️ **Conecta todos os controladores** ao roteador principal.

- Cada `router.use("/", XController)` diz:
    
    “use as rotas definidas nesse controller a partir da raiz `/`”.
    
- Assim, por exemplo, se o `userController` tiver uma rota `/users`, ela ficará acessível em:
    
    ```
    http://localhost:3000/users
    
    ```
    

---

```jsx
export default router;

```

➡️ **Exporta** esse router principal,

para que o arquivo principal da aplicação (`app.js` ou `server.js`) possa usá-lo:

```jsx
app.use("/", router);

```

---

### ⚙️ 💡 Em resumo:

Esse arquivo:

- Cria um **router principal**;
- Testa uma rota `/` simples;
- **Importa todos os controllers**;
- Junta tudo em um só lugar;
- Exporta o router para o app principal usar.

---

✅ **Resumindo em uma frase:**

> Esse arquivo serve como ponto central de rotas, reunindo todos os controllers
> 
> 
> e encaminhando as requisições para o controller correto.
> 

---


💡

O QUE FAZ ESSA LINHA DE CÓDIGO `let router = express.Router()`?

### 🧩 Linha:

```jsx
let router = express.Router()

```

---

### 🧠 1. O que é `express.Router()`?

`Router()` é uma **função do Express** que cria um **objeto de roteamento isolado**.

Esse objeto (`router`) serve para **organizar e agrupar rotas** de forma modular.

---

### 🧱 2. O que ela faz na prática?

Ela cria um **mini "aplicativo Express"** — com suas próprias rotas (`get`, `post`, `put`, `delete`), middlewares, e lógica, **separado** do `app` principal.

Você pode imaginar assim:

- `app` → o servidor principal (geralmente no `index.js` ou `app.js`)
- `router` → partes independentes do app, cada uma cuidando de um conjunto de rotas (ex: usuários, cursos, professores etc.)

---

### 💡 3. Exemplo prático

```jsx
import express from "express"
let router = express.Router()

// rota dentro desse router
router.get("/users", (req, res) => {
  res.send("Listando usuários")
})

// exporta o router para ser usado no app principal
export default router

```

No seu arquivo principal (`app.js`):

```jsx
import express from "express"
import userRouter from "./routes/UserController.js"

const app = express()

// usa o router importado
app.use("/", userRouter)

```

Agora, quando acessar `http://localhost:3000/users`, o Express vai:

> Passar a requisição para o router que você criou.
> 

---

### ⚙️ 4. Por que isso é útil?

✅ **Organização:** separa as rotas por módulo (ex: `UserController`, `CourseController` etc.)

✅ **Manutenção:** facilita modificar uma parte sem mexer no resto.

✅ **Reutilização:** você pode importar o mesmo router em outro lugar, se precisar.

---

### 📊 5. Comparando com Java

Pense no `router` como uma **classe controladora** (`Controller`) em Java (por exemplo, no Spring Boot).

Cada método `router.get()` ou `router.post()` seria como um endpoint anotado com `@GetMapping` ou `@PostMapping`.

---

### ✅ **Resumindo**

| Elemento | O que faz |
| --- | --- |
| `express.Router()` | Cria um mini módulo de rotas independente |
| `router` | Objeto que contém as rotas e middlewares |
| `app.use("/", router)` | Conecta esse router ao servidor principal |

---


### O QUE FAZ O MÉTODO `USE()` DO EXPRESS?

🏆

## `use()` é um **método do Express**

Ele serve para **registrar middlewares e rotas** dentro da sua aplicação ou dentro de um `router`.

---

### 🧠 Estrutura geral:

```jsx
app.use([caminho], middlewareOuRouter)

```

- `app` → é sua aplicação Express principal (criada com `const app = express()`).
- `use()` → é a função que **"pluga"** algo no fluxo de requisições.
- `[caminho]` (opcional) → define **em qual rota base** aquilo será aplicado.
- `middlewareOuRouter` → é o que vai ser executado quando chegar uma requisição (pode ser um middleware ou um router).

---

### 💡 Exemplo 1 — aplicando um *middleware global*

```jsx
app.use(express.json());

```

➡️ Diz ao Express: “toda requisição que chegar deve passar primeiro pelo `express.json()`”,

que serve para interpretar JSON no corpo da requisição.

---

### 💡 Exemplo 2 — conectando um router

```jsx
import userRouter from "./routes/UserController.js"

app.use("/users", userRouter);

```

➡️ Isso significa:

> Todas as rotas dentro de userRouter vão começar com /users.
> 

Então, se dentro do router você tiver:

```jsx
router.get("/", (req, res) => res.send("Listar usuários"));

```

O endpoint final será:

```
http://localhost:3000/users/

```

---

### 💡 Exemplo 3 — sem caminho (aplica a tudo)

```jsx
app.use((req, res, next) => {
  console.log("Qualquer rota passou por aqui");
  next(); // permite que a requisição continue
});

```

➡️ Executa esse código **para toda requisição**, independentemente da rota.

---

### ⚙️ Em resumo:

| Código | O que faz |
| --- | --- |
| `app.use(express.json())` | Habilita leitura de JSON no corpo da requisição |
| `app.use("/users", userRouter)` | Liga um grupo de rotas à URL base `/users` |
| `app.use((req, res, next) => {...})` | Cria um middleware global para todas as rotas |

---

### 🧩 Comparando com Java (Spring Boot)

`app.use()` é parecido com quando você usa **interceptadores ou filtros** (`@ControllerAdvice`, `@Filter`, etc.),

ou quando você **mapeia controladores** (`@RequestMapping("/users")`).

---

✅ **Resumo final:**

> use() é uma função do Express usada para registrar middlewares ou routers,
> 
> 
> e definir **em qual rota base** eles devem atuar.
> 

### O QUE É UM MIDDLEWARE NO EXPRESS?

🏆

👉 **Middleware** no **Express** é uma **função intermediária** que **intercepta e trata requisições e respostas** antes delas chegarem na rota final (ou antes de sair da rota).

---

### 🧠 Em resumo:

> Middleware = uma função que fica “no meio do caminho” entre o cliente e o servidor,
> 
> 
> podendo **ver, alterar ou bloquear** a requisição/resposta.
> 

🏆

### Vamos mudar a estrutura do arquivo `index.js` para ter uma função assíncrona que cria o banco e popula o banco com todas as tabelas vazias

```bash
import { express } from "express"
import { pkg } from "body-parser"
import { router } from "./routes/router.js"

import sequelize from "./utils/database.js"
import association from "./models/Associations.js"

const app = express()
const { json, urlencoded } = pkg

// vamos mudar a estrutura para ter uma função assíncrona que cria o banco e popula o banco com todas as tabelas vazias

app.use(json());
app.use(urlencoded({ extended: true }))

    (async () => {
        try {
            association.associations();
            await sequelize.sync()
            app.listen(3000, function () {
                console.log("Listening from 3000")
            })
        } catch (error) {
            console.log(error)
        }
    })()

// rotas
app.use("/", router)
```

> Dessa forma o index já está pronto para inicializar o sequelize, antes de começar a disponibilizar a nossa aplicação.
> 

### EXPLICAÇÃO DO CÓDIGO DETALHADAMENTE!

vamos analisar **esse código do `index.js`** no mesmo estilo detalhado e direto que estávamos fazendo antes — linha por linha, explicando **o que acontece** e **por que**.

---

### 🧩 Código:

```jsx
import { express } from "express"
import { pkg } from "body-parser"
import { router } from "./routes/router.js"

import sequelize from "./utils/database.js"
import association from "./models/Associations.js"

const app = express()
const { json, urlencoded } = pkg

app.use(json());
app.use(urlencoded({ extended: true }))

(async () => {
    try {
        association.associations();
        await sequelize.sync()
        app.listen(3000, function () {
            console.log("Listening from 3000")
        })
    } catch (error) {
        console.log(error)
    }
})()

app.use("/", router)

```

---

### 🧠 Explicação linha por linha:

---

```jsx
import { express } from "express"

```

➡️ Importa o **Express**, que é o framework usado para **criar o servidor e gerenciar as rotas**.

> ❗ Aqui há um pequeno erro: o correto seria import express from "express", porque o express é exportado por padrão, não como objeto.
> 

---

```jsx
import { pkg } from "body-parser"

```

➡️ Importa o **Body-Parser**, responsável por **interpretar o corpo das requisições HTTP** (por exemplo, ler o `req.body` quando o cliente envia dados em JSON ou formulários).

---

```jsx
import { router } from "./routes/router.js"

```

➡️ Importa o **arquivo de rotas principal**, que reúne todos os controladores da aplicação (`UserController`, `CourseController`, etc.) e os entrega para o Express tratar.

---

```jsx
import sequelize from "./utils/database.js"

```

➡️ Importa o objeto `sequelize`, que contém a **conexão configurada com o banco de dados** MySQL.

Esse objeto é criado dentro do arquivo `database.js` e será usado para sincronizar (criar) as tabelas.

---

```jsx
import association from "./models/Associations.js"

```

➡️ Importa o módulo que **define os relacionamentos entre as tabelas (models)**, como:

- um curso tem muitos professores,
- um usuário tem muitas avaliações, etc.

---

```jsx
const app = express()

```

➡️ Cria uma instância da aplicação Express — é nela que vamos configurar as rotas, middlewares e inicializar o servidor.

---

```jsx
const { json, urlencoded } = pkg

```

➡️ Extrai as funções `json` e `urlencoded` do `body-parser`.

- `json()` → permite receber e interpretar JSON no corpo da requisição.
- `urlencoded()` → permite receber dados vindos de formulários.

---

```jsx
app.use(json());
app.use(urlencoded({ extended: true }))

```

➡️ Essas duas linhas **ativam os middlewares** do `body-parser`.

Ou seja, antes de qualquer rota ser executada, o Express consegue **ler e entender o corpo das requisições** enviadas pelo cliente.

---

```jsx
(async () => {
    try {
        association.associations();
        await sequelize.sync()
        app.listen(3000, function () {
            console.log("Listening from 3000")
        })
    } catch (error) {
        console.log(error)
    }
})()

```

➡️ Essa parte é o **coração da inicialização do sistema**.

É uma **função assíncrona autoexecutável (IIFE)** — ou seja, ela é chamada imediatamente assim que o código é lido.

Dentro dela:

1. **`association.associations();`**
    
    👉 Chama o método que cria **todas as relações entre as tabelas** (como `Course.hasMany(Teacher)`).
    
2. **`await sequelize.sync()`**
    
    👉 O Sequelize **sincroniza os modelos com o banco**.
    
    Se o banco estiver vazio, ele **cria as tabelas automaticamente** com base nos modelos (`User`, `Teacher`, `Course`, etc.).
    
3. **`app.listen(3000, ...)`**
    
    👉 Quando o banco já estiver pronto, o servidor é iniciado na **porta 3000**.
    
    Assim, o servidor só começa a rodar **depois que o banco estiver conectado e sincronizado**, evitando erros.
    
4. **`catch (error)`**
    
    👉 Caso aconteça algum erro (por exemplo, falha de conexão com o banco), ele será exibido no console.
    

---

```jsx
app.use("/", router)

```

➡️ Finalmente, essa linha **registra todas as rotas principais** da aplicação.

Tudo que estiver configurado no arquivo `router.js` será usado a partir do caminho base `/`.

Por exemplo:

- `/users` → acessa o `UserController`,
- `/courses` → acessa o `CourseController`, etc.

---

### ⚙️ Resumo final

| Etapa | O que faz |
| --- | --- |
| Importa dependências | Express, body-parser, sequelize e associações |
| Cria o app | Inicializa o servidor Express |
| Configura middlewares | Para entender JSON e formulários |
| Cria função assíncrona | Conecta e sincroniza com o banco de dados |
| Inicia o servidor | Só depois da sincronização do banco |
| Registra rotas | Liga os controladores ao servidor |

---


---

### AGORA VAMOS TER EM NOSSO CRUD A CHAMADA DO REPOSITORY QUE VAI SER FEITA NO SERVICE E TAMBÉM A LÓGICA DO NEGÓCIO

```bash
import userRepository from "../repositories/UserRepository.js"

// Função que salva o usuário no banco de dados
function saveUser(userModel) {
    return userRepository.saveUser(userModel);
}

// Buscando usuário pelo id
function getUserById(id) {
    return userRepository.getUserById(id);
}

// função que busca todos usuários 
function getAllUsers() {
    return userRepository.getAllUsers();
}

// Método que deleta um User
function deleteUserById(id) {
    return userRepository.deleteUserById(id);
}

// Método que atualiza um User
function updateUserById(id, userModel) {
    return userRepository.updateUserById(id, userModel);
}

const service = {
    /* Todo método que você fizer no seu service é necessário expor para que ele seja visto por outros pacotes */
    saveUser,
    getUserById,
    getAllUsers,
    deleteUserById,
    updateUserById
}

export default service; 
```

💡 BÁSICAMENTE TODOS OS OUTROS SERVICES VÃO TER A MESMA ESTRUTURA.


---

🏆

### AGORA VAMOS DESENVOLVER O REPOSITORY COM OS MÉTODOS PARA MANIPULAR O BANCO DE DADOS.


### FUNÇÃO QUE SALVA UM USUÁRIO

```bash
// FUNÇÃO QUE SALVA O USUÁRIO
async function saveUser(UserModel) {
    const save = await User.create(UserModel)
    return save
}

```

🏆

### EXPLICAÇÃO DA FUNÇÃO

```jsx
// FUNÇÃO QUE SALVA O USUÁRIO
async function saveUser(UserModel) {
    const save = await User.create(UserModel)
    return save
}

```

---

### 🧩 Linha por linha:

1. `// FUNÇÃO QUE SALVA O USUÁRIO`
    
    👉 É apenas um **comentário** explicando o propósito da função.
    
2. `async function saveUser(UserModel) {`
    
    👉 Declara uma **função assíncrona** chamada `saveUser`
    
    — o `async` permite usar `await` dentro dela.
    
    Ela recebe um parâmetro `UserModel`, que contém os **dados do usuário** (ex: nome, e-mail, senha...).
    
3. `const save = await User.create(UserModel)`
    
    👉 Usa o modelo `User` (provavelmente do Sequelize ou outro ORM) para **criar e salvar** um novo registro no banco de dados com os dados de `UserModel`.
    
    - O `await` faz a função **esperar** o banco terminar a operação antes de continuar.
    - O resultado (dados do usuário salvo, incluindo o ID) é armazenado em `save`.
4. `return save`
    
    👉 Retorna o resultado da criação — ou seja, **o objeto do usuário recém-criado**.
    
5. `}`
    
    👉 Fecha a definição da função.
    

---

🔹 **Resumo geral:**

A função `saveUser` recebe um objeto com dados de um usuário, salva esse usuário no banco de dados e retorna o registro salvo (incluindo informações geradas automaticamente, como o ID).


### FUNÇÃO QUE BUSCA TODOS USUÁRIOS

```bash
// FUNÇÃO QUE BUSCA TODOS USUÁRIOS 
async function getAllUsers() {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await User.findAll({
        order: [
            ['id', 'ASC']
        ]
    }) 
}
```

🏆

### EXPLICAÇÃO DA FUNÇÃO QUE BUSCA TODOS USUÁRIOS

```jsx
async function getAllUsers() {
    return await User.findAll({
        order: [
            ['id', 'ASC']
        ]
    })
}

```

---

### 🧩 Linha por linha:

1. `async function getAllUsers() {`
    
    👉 Declara uma **função assíncrona** chamada `getAllUsers`.
    
    O `async` permite usar o `await` dentro dela, ou seja, **esperar o resultado** de operações que demoram (como consultas ao banco de dados).
    
2. `return await User.findAll({`
    
    👉 Usa o modelo `User` (do Sequelize, provavelmente) para **buscar todos os registros** da tabela de usuários.
    
    O `await` faz com que a função **espere o banco responder** antes de continuar.
    
    Em seguida, o resultado é **retornado**.
    
3. `order: [ ['id', 'ASC'] ]`
    
    👉 Define a **ordenação dos resultados**:
    
    - `'id'` é o campo usado para ordenar;
    - `'ASC'` significa **ordem crescente** (do menor para o maior ID).
        
        Assim, os usuários são listados **na ordem em que foram cadastrados**.
        
4. `})`
    
    👉 Fecha o método `findAll()` e suas configurações (o objeto com `order`).
    
5. `}`
    
    👉 Fecha a função `getAllUsers`.
    

---

✅ **Resumo geral:**

A função `getAllUsers` **busca todos os usuários no banco de dados** e **retorna a lista completa**, organizada **em ordem crescente de ID**.


### FUNÇÃO QUE BUSCA USUÁRIO POR ID

```bash
// FUNÇÃO QUE BUSCA USUÁRIO POR ID
async function getUserById(id) {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await User.findByPk(id) 
}

```

### EXPLICAÇÃO DA FUNÇÃO DETALHADAMENTE

🏆

```jsx
// FUNÇÃO QUE BUSCA USUÁRIO POR ID
async function getUserById(id) {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await User.findByPk(id)
}

```

---

### 🧩 Linha por linha:

1. `// FUNÇÃO QUE BUSCA USUÁRIO POR ID`
    
    👉 É apenas um **comentário** explicando o propósito da função — ela serve para **procurar um usuário específico** pelo seu **ID**.
    
2. `async function getUserById(id) {`
    
    👉 Declara uma **função assíncrona** chamada `getUserById`.
    
    Ela recebe um **parâmetro `id`**, que representa o **identificador único** do usuário no banco de dados.
    
    O `async` permite usar `await` dentro da função.
    
3. `// aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma variável.`
    
    👉 Comentário explicando que, em vez de guardar o resultado numa variável (como `const user = ...`), o retorno do banco é feito **diretamente**.
    
4. `return await User.findByPk(id)`
    
    👉 Usa o método **`findByPk()`** (do Sequelize) para **buscar um registro pelo valor da sua chave primária (Primary Key)** — nesse caso, o `id`.
    
    - O `await` faz a função **esperar o banco de dados responder**.
    - O `return` devolve **o usuário encontrado** (ou `null` se não existir).
5. `}`
    
    👉 Fecha a função.
    

---

✅ **Resumo geral:**

A função `getUserById` **busca e retorna um único usuário** do banco de dados **com base no ID informado**.

Se o ID não existir, o retorno será `null`.


### FUNÇÃO QUE DELETA USUÁRIO

```bash
// FUNÇÃO QUE DELETA UM USUÁRIO
async function deleteUserById(id) {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await User.destroy({where: {id: id}}) 
}
```

### EXPLICAÇÃO DA FUNÇÃO

🏆

```jsx
async function deleteUserById(id) {

    return await User.destroy({ where: { id: id } })
}

```

---

### 🧩 Linha por linha:

1. `async function deleteUserById(id) {`
    
    👉 Declara uma **função assíncrona** chamada `deleteUserById`.
    
    Ela recebe um **parâmetro `id`**, que representa o **identificador do usuário** que será excluído.
    
    O `async` permite usar `await` dentro da função.
    
2. `return await User.destroy({ where: { id: id } })`
    
    👉 Usa o método **`destroy()`** do **Sequelize** para **excluir** um ou mais registros do banco de dados.
    
    - O objeto `{ where: { id: id } }` indica a **condição** da exclusão:
        
        > “Apague o usuário cujo campo id seja igual ao valor recebido.”
        > 
    - O `await` faz a função **esperar o término da exclusão** antes de retornar.
    - O `return` devolve o **resultado da operação**, que geralmente é:
        - `1` se um registro foi excluído com sucesso;
        - `0` se **nenhum usuário com esse ID** foi encontrado.
3. `}`
    
    👉 Fecha a definição da função.
    

---

✅ **Resumo geral:**

A função `deleteUserById` **remove um usuário do banco de dados** com base no ID informado e **retorna quantos registros foram apagados** (geralmente `1` ou `0`).


### FUNÇÃO QUE ATUALIZA USUÁRIO

```bash
// FUNÇÃO QUE ATUALIZA UM USUÁRIO
async function updateUserById(id, UserModel) {

    try {
        const result = await User.update(UserModel, {where: {id: id}})
        if (result[0]===1) {
            return {message: "User atualizado com sucesso!"}
        } else {
            return {message: "Não consigo encontrar a opção $(id) para atualizar"}
        }
    } catch (error) {
        console.error()
    }
}
```

### EXPLICAÇÃO DA FUNÇÃO

🏆

```jsx
async function updateUserById(id, UserModel) {

    try {
        const result = await User.update(UserModel, { where: { id: id } })
        if (result[0] === 1) {
            return { message: "User atualizado com sucesso!" }
        } else {
            return { message: "Não consigo encontrar a opção $(id) para atualizar" }
        }
    } catch (error) {
        console.error()
    }
}

```

---

### 🧩 Linha por linha:

1. `async function updateUserById(id, UserModel) {`
    
    👉 Declara uma **função assíncrona** chamada `updateUserById`.
    
    - **`id`** → o identificador do usuário que será atualizado.
    - **`UserModel`** → objeto com os **novos dados** (por exemplo, nome, email etc.).
        
        O `async` permite usar `await` dentro da função.
        

---

1. `try {`
    
    👉 Inicia um **bloco de tentativa**.
    
    Serve para **testar o código** que pode gerar erros (como a atualização no banco).
    
    Se der erro, o `catch` cuidará disso.
    

---

1. `const result = await User.update(UserModel, { where: { id: id } })`
    
    👉 Usa o método **`update()`** do Sequelize para **atualizar o usuário** no banco de dados.
    
    - **`UserModel`** contém os novos valores.
    - **`{ where: { id: id } }`** define **qual usuário será atualizado**.
    - O `await` faz a função esperar a conclusão da atualização.
    - O Sequelize retorna um **array**, onde `result[0]` indica **quantos registros foram atualizados**.

---

1. `if (result[0] === 1) { return { message: "User atualizado com sucesso!" }
} else { return { message: "Não consigo encontrar a opção $(id) para atualizar" }
}`
    
    👉 Faz uma **verificação do resultado**:
    
    - Se `result[0] === 1` → significa que **1 usuário foi atualizado com sucesso**, então retorna uma mensagem positiva.
    - Caso contrário → nenhum usuário foi encontrado com aquele `id`, e retorna uma mensagem de erro.
        
        *(Obs.: deveria usar **`${id}`** e não `$(id)` para interpolar o valor corretamente.)*
        

---

1. `} catch (error) { console.error()
}`
    
    👉 O bloco **`catch`** captura qualquer **erro** que aconteça dentro do `try` (como erro de conexão com o banco) e o exibe no console.
    
    - `console.error()` deveria idealmente ser `console.error(error)` para mostrar a causa do erro.

---

1. `}`
    
    👉 Fecha a definição da função.
    

---

✅ **Resumo geral:**

A função `updateUserById` **atualiza um usuário no banco de dados** usando o `id` como referência.

Ela retorna uma mensagem informando **se o usuário foi atualizado com sucesso** ou **se não foi encontrado**, e trata possíveis erros durante o processo.


🏆 VOU REPLICAR ESSAS OPERAÇÕES PARA AS OUTRAS CLASSES DE REPOSITORIES DO MEU PROGRAMA


---

🏆

### ULTIMO PASSO SERÁ A MONTAGEM DO CONTROLLER COM O MAPEAMENTO DESSAS ESTRUTURAS.

> O controller vai chamar o service.
> 

### VAMOS REPLICAR ESSA ESTRUTURA DO USER CONTROLLER PARA AS OUTRAS ENTIDADES DA APLICAÇÃO (TEACHER, EVALUATION E COURSE)

🏆

### POST

```bash
async function addUser(req, res) {
    try {
        const userModel = {
            first_name: req.body.first_name,
            last_name: req.body.last_name,
            email: req.body.email,
            gender: req.body.gender
        }

        const user = await userService.saveUser(userModel)
        return res.status(201).json(user)
    } catch (error) {
        console.error("Erro em addUser:", error)
        return res.status(500).json({ message: "Erro ao salvar usuário", error: error.message })
    }
}

router.post("/addUser", addUser)

export default router
```

### EXPLICAÇÃO DO CÓDIGO


🏆

---

```jsx
import express from "express"
import userService from "../services/UserService.js"

const router = express.Router()

```

Aqui estamos importando o **Express**, que é o framework principal do servidor, e o **userService**, que contém a lógica de negócio para salvar o usuário.

Depois criamos uma instância de `router` — ela serve para organizar nossas rotas separadamente do `app.js`.

---

```jsx
async function addUser(req, res) {

```

Essa linha define uma **função assíncrona** chamada `addUser`.

Ela será executada toda vez que alguém fizer um **POST** na rota `/addUser`.

Como é assíncrona, podemos usar `await` dentro dela (para esperar respostas do banco, por exemplo).

---

```jsx
    try {

```

Abrimos um bloco `try` para tratar possíveis erros.

Se alguma operação falhar (como salvar no banco), o código vai cair no `catch` lá embaixo.

---

```jsx
        const userModel = {
            first_name: req.body.first_name,
            last_name: req.body.last_name,
            email: req.body.email,
            gender: req.body.gender
        }

```

Aqui montamos o objeto `userModel` com os dados que o cliente enviou no corpo da requisição (`req.body`).

Cada campo (`first_name`, `last_name`, etc.) vem direto do corpo da requisição JSON.

Esse objeto será enviado para o **service**, que vai realmente salvar o usuário no banco.

---

```jsx
        const user = await userService.saveUser(userModel)

```

Chamamos o método `saveUser` do `userService`, passando o `userModel` como argumento.

O `await` faz o código **esperar** até que o usuário seja salvo antes de continuar.

O retorno (`user`) normalmente contém o registro completo que foi criado, incluindo o `id` e os timestamps (`createdAt`, `updatedAt`).

---

```jsx
        return res.status(201).json(user)

```

Enviamos uma resposta HTTP com código **201 (Created)** indicando sucesso, junto com o objeto do usuário criado.

O método `res.json()` converte o objeto automaticamente em JSON para enviar ao cliente.

---

```jsx
    } catch (error) {
        console.error("Erro em addUser:", error)
        return res.status(500).json({ message: "Erro ao salvar usuário", error: error.message })
    }

```

Esse bloco `catch` captura qualquer erro que aconteça no processo — por exemplo, erro de conexão com o banco.

Mostramos o erro no console e devolvemos uma resposta **500 (erro interno do servidor)** com uma mensagem amigável.

---

```jsx
router.post("/addUser", addUser)

```

Aqui conectamos a função `addUser` à rota POST `/addUser`.

Ou seja, quando o cliente enviar um POST para esse endpoint, o Express chamará automaticamente essa função.

Repara que agora **não estamos usando uma função callback anônima** — apenas passando a função `addUser` como referência.

Isso deixa o código mais limpo, fácil de testar e reutilizar.

---

```jsx
export default router

```

Exportamos o `router` para poder importar e usar no `app.js` com `app.use("/", router)`.

---

🔹 **Resumo final:**

- Lê os dados do corpo (`req.body`);
- Cria o objeto `userModel`;
- Chama o `userService` para salvar no banco;
- Retorna o resultado ao cliente;
- Tudo isso sem callback anônima, usando uma função nomeada.

---


🏆

### GET

```bash

```

### EXPLICAÇÃO DO CÓDIGO

🏆

---

```jsx
async function getAllUsers(req, res) {

```

Aqui criamos uma **função assíncrona** chamada `getAllUsers`.

O Express vai chamar essa função sempre que alguém fizer uma **requisição GET** para a rota `/getAllUsers`.

O `req` representa a **requisição** (dados enviados pelo cliente).

O `res` representa a **resposta** (o que o servidor vai devolver).

Por ser uma função `async`, ela permite usar `await` dentro dela — útil pra lidar com operações que demoram (como consultas no banco de dados).

---

```jsx
    try {

```

Abrimos um bloco `try` para capturar possíveis erros durante a execução do código (por exemplo, erro de conexão com o banco).

Tudo dentro do `try` é tentado; se algo falhar, o programa pula direto pro `catch`.

---

```jsx
        const allUsers = await userService.getAllUsers()

```

Aqui chamamos o método `getAllUsers()` do **`userService`**.

Esse service é responsável por conversar com o **repositório** ou diretamente com o **Sequelize**, que faz a busca no banco de dados.

O `await` faz o código **esperar** o resultado dessa busca antes de continuar.

Quando o banco termina de buscar os dados, a constante `allUsers` recebe a lista completa dos usuários.

---

```jsx
        return res.status(200).json(allUsers)

```

Depois que os dados são obtidos, o servidor responde ao cliente com:

- um **status 200 (OK)** indicando sucesso,
- e o conteúdo em formato **JSON**, contendo todos os usuários retornados do banco.

O `return` encerra a função e envia essa resposta.

---

```jsx
    } catch (error) {

```

Se der algum erro dentro do `try` (por exemplo, falha na consulta, problema de rede ou erro no banco), o código vem para esse bloco `catch`.

---

```jsx
        console.error("Erro ao buscar usuários:", error)

```

Aqui exibimos no terminal do servidor uma mensagem de erro com detalhes — isso ajuda no **debug** (para o desenvolvedor entender o que aconteceu).

---

```jsx
        return res.status(500).json({ message: "Erro ao buscar usuários" })

```

Depois disso, retornamos uma resposta HTTP com o código **500 (Internal Server Error)**, indicando que o erro aconteceu no lado do servidor.

Também enviamos uma mensagem simples em JSON para o cliente entender o motivo.

---

```jsx
router.get("/getAllUsers", getAllUsers)

```

Essa linha **liga** a função `getAllUsers` à rota **GET /getAllUsers**.

Ou seja: sempre que o cliente acessar esse caminho, o Express executa automaticamente a função que criamos.

Perceba que **não usamos uma função anônima** dentro da rota, apenas passamos a **referência da função** `getAllUsers`.

Isso deixa o código mais **organizado**, **limpo** e **reutilizável**.

---

🔹 **Resumo final:**

Esse trecho cria uma rota `/getAllUsers` que:

1. Recebe uma requisição GET do cliente;
2. Usa o `userService` pra buscar todos os usuários no banco;
3. Retorna a lista em formato JSON com status 200;
4. Se algo der errado, mostra o erro no console e retorna status 500 com uma mensagem de erro.

---


🏆

### GET BUSCANDO POR ID

```bash
async function getUserById(req, res) {
    try {
        const userId = req.params.id
        const user = await userService.getUserById(userId)

        return res.status(200).json(user)
    } catch (error) {
        console.error("Erro ao buscar usuário por ID:", error)
        return res.status(500).json({ message: "Erro ao buscar usuário" })
    }
}

// rota que usa a função
router.get("/user/:id", getUserById)
```

### EXPLICAÇÃO DO CÓDIGO


🏆

---

```jsx
async function getUserById(req, res) {

```

Aqui definimos uma **função assíncrona** chamada `getUserById`.

O Express vai executar essa função quando alguém fizer uma requisição **GET** para a rota `/user/:id`.

O parâmetro `:id` significa que a rota espera um **valor dinâmico**, por exemplo:

`/user/5` ou `/user/123`.

Os parâmetros de rota ficam disponíveis dentro de `req.params`, e por isso usamos isso logo em seguida.

---

```jsx
    try {

```

Abrimos o bloco `try` para tratar erros de forma controlada.

Tudo dentro dele é tentado — se alguma parte falhar (por exemplo, erro de banco ou ID inválido), o código vai direto para o `catch`.

---

```jsx
        const userId = req.params.id

```

Aqui pegamos o valor do parâmetro `id` da URL.

Ou seja, se o cliente acessar `/user/10`, o valor de `userId` será `"10"`.

Esse valor é usado para buscar no banco o usuário correspondente.

---

```jsx
        const user = await userService.getUserById(userId)

```

Chamamos o método `getUserById` do **`userService`**, passando o `userId` que pegamos da rota.

Esse service é quem faz a comunicação com o banco (diretamente ou via repositório).

O `await` faz o código **esperar o resultado** dessa operação antes de continuar.

Quando o banco responde, o objeto `user` contém os dados do usuário correspondente ao ID informado.

---

```jsx
        return res.status(200).json(user)

```

Depois que os dados são encontrados, o servidor envia uma resposta **com status 200 (OK)** e os dados do usuário no formato **JSON**.

O `return` encerra a função e envia a resposta ao cliente.

---

```jsx
    } catch (error) {

```

Se acontecer algum erro dentro do `try` — por exemplo, se o ID não existir, ou se houver uma falha de conexão —, o código vem para o `catch`.

---

```jsx
        console.error("Erro ao buscar usuário por ID:", error)
        return res.status(500).json({ message: "Erro ao buscar usuário" })

```

Aqui mostramos o erro completo no console do servidor (para ajudar o desenvolvedor a entender o que aconteceu).

E retornamos uma resposta com **status 500 (erro interno do servidor)** e uma mensagem em JSON explicando que houve falha na busca.

---

```jsx
router.get("/user/:id", getUserById)

```

Essa linha conecta a função `getUserById` à rota **GET /user/:id**.

Ou seja, toda vez que o cliente fizer uma requisição como:

```
GET /user/1
GET /user/15
GET /user/999

```

O Express vai executar automaticamente a função `getUserById`.

Perceba que **não usamos função anônima dentro da rota**, apenas passamos a **referência da função**.

Isso deixa o código **organizado**, **reutilizável** e **fácil de testar**.

---

🔹 **Resumo geral:**

Esse método cria uma rota que:

1. Lê o **ID** passado na URL (`req.params.id`);
2. Usa o **`userService`** para buscar esse usuário no banco;
3. Retorna o usuário encontrado com **status 200**;
4. Se algo der errado, mostra o erro no console e retorna um **status 500** com mensagem de erro.
