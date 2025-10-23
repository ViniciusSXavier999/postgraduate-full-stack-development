# 5 → ADIÇÃO DE SQUELIZE NA APLICAÇÃO

## O QUE É SQUELIZE?

🏆

👉 **Sequelize** é um **ORM (Object-Relational Mapper)** para **Node.js**, usado para **trabalhar com bancos de dados relacionais** (como MySQL, PostgreSQL, SQLite ou MariaDB) **usando JavaScript em vez de SQL puro**.

---

### 🧠 Em resumo:

O **Sequelize** permite que você:

- **Crie, leia, atualize e delete** dados (CRUD) com métodos JavaScript;
- **Defina modelos (models)** que representam as tabelas do banco;
- Use **relacionamentos** entre tabelas (1:N, N:N, etc.);
- Evite escrever comandos SQL manuais.

---

### 💡 Exemplo simples:

Sem Sequelize:

```sql
SELECT * FROM users WHERE id = 1;

```

Com Sequelize:

```jsx
const user = await User.findByPk(1);

```

---

### ⚙️ O que ele faz por baixo dos panos:

- Conecta ao banco via drivers (como `mysql2` ou `pg`);
- Traduz o código JS em **comandos SQL equivalentes**;
- Retorna os resultados como **objetos JavaScript**.

---

### 📦 Em resumo rápido:

> Sequelize = ferramenta que facilita o uso de bancos SQL dentro de aplicações JavaScript,
> 
> 
> substituindo consultas SQL por código mais simples e orientado a objetos.
> 

---


---

### VAMOS INSTALAR O SEQUELIZE NO PROJETO

```bash
npm i sequelize
```

---

### VAMOS CRIAR UMA PASTA CHAMADA UTILS PARA COLOCAR AS INFORMAÇÕES DO BANCO DE DADOS NELA

```bash
import {Sequelize } from "sequelize";

// contém informações do banco de dados

const sequelize = new Sequelize("db_herocloud", "root", "soudev", {
  host: "localhost",
  dialect: "mysql",
  port: "3306",
  define: {
    timestamps: false
  }
});

// isso vai fazer com que essa classe seja exposta para aplicação e seja inicializada dentro do index
export default sequelize;
```

---

### VAMOS DESENVOLVER AS CLASSES DA NOSSA PASTA MODELS, TODAS TERÃO BÁSICAMENTE A MESMA ESTRUTURA DA CLASSE USER

```bash
import { DataTypes } from "sequelize";
import sequelize from "../utils/database.js"

const User = sequelize.define('users', {
    id: {
        type: DataTypes.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },

    first_name: {
        type: DataTypes.STRING,
        allowNull: false
    },

    last_name: {
        type: DataTypes.STRING,
        allowNull: false,
    },

    email: DataTypes.STRING,
    gender: DataTypes.STRING
},  **underscored: true**)

export default User;
```

🏆

### O QUE É A CONFIGURAÇÃO ?

---

### 🔹 **`underscored: true`**

Essa configuração faz o Sequelize **usar o padrão snake_case** (com **underline** entre as palavras)

em vez do padrão **camelCase** (sem underline) nos **nomes das colunas e chaves estrangeiras**.

---

### 🧠 Por padrão (sem `underscored: true`)

```jsx
const User = sequelize.define("User", {
  firstName: DataTypes.STRING,
  lastName: DataTypes.STRING
});

```

🗄️ O Sequelize cria no banco:

| id | firstName | lastName | createdAt | updatedAt |
| --- | --- | --- | --- | --- |

> (padrão camelCase — com letras maiúsculas no meio)
> 

---

### ✅ Com `underscored: true`

```jsx
const User = sequelize.define("User", {
  firstName: DataTypes.STRING,
  lastName: DataTypes.STRING
}, {
  underscored: true
});

```

🗄️ Agora o Sequelize cria:

| id | first_name | last_name | created_at | updated_at |
| --- | --- | --- | --- | --- |

> (padrão snake_case — com “_” separando palavras)
> 

---

### 🧩 Em resumo:

| Opção | Efeito nos nomes das colunas |
| --- | --- |
| `underscored: false` *(padrão)* | `createdAt`, `updatedAt`, `firstName` |
| `underscored: true` | `created_at`, `updated_at`, `first_name` |

---

### ⚙️ Onde usar:

Você pode colocar tanto **no model** quanto **globalmente**:

**➡️ No model específico:**

```jsx
const User = sequelize.define("User", {...}, {
  underscored: true
});

```

**➡️ Global (para todos os models):**

```jsx
const sequelize = new Sequelize("banco", "root", "senha", {
  dialect: "mysql",
  define: {
    underscored: true
  }
});

```

---

### ✅ **Resumindo em uma frase:**

> underscored: true faz o Sequelize usar nomes de colunas com underline (snake_case),
> 
> 
> o que é o padrão mais comum em bancos de dados SQL.
> 

---


---

### COMO VAMOS TRATAR AS ASSOCIAÇÕES?

🏆 Vamos criar um arquivo que irá tratar separadamente as associações e relacionamento das tabelas 


> O relacionamento vai ser feito pelo sequalize ao invés de criar uma tabela no banco de dados.
> 

```bash
import User from "./User.js"
import Teacher from "./Teacher.js"
import Course from "./Course.js"
import Evaluation from "./Evaluation.js"

const associations = () => {
    Course.hasMany(Teacher)
    User.hasMany(Evaluation)
    Course.hasMany(Evaluation)
}

const factory = {
    associations
}

export default factory;
```

🏆

### EXPLICAÇÃO DO CÓDIGO LINHA POR LINHA

---

```jsx
import User from "./User.js"
import Teacher from "./Teacher.js"
import Course from "./Course.js"
import Evaluation from "./Evaluation.js"

```

- **Importa os modelos** (`User`, `Teacher`, `Course`, `Evaluation`) que foram previamente definidos (cada um é um `Model` do Sequelize).
- Esses imports são necessários para declarar relacionamentos entre eles.

---

```jsx
const associations = () => {

```

- **Declara uma função chamada `associations`**.
- A ideia é agrupar todas as definições de relacionamento dentro dessa função para chamá-la uma vez (normalmente após todos os models serem carregados).

---

```jsx
    Course.hasMany(Teacher)

```

- **Define que `Course` *tem muitos* `Teacher`** (relação 1 → N).
- Isso faz com que o Sequelize crie/espere uma **foreign key** em `Teacher` apontando para `Course` (por padrão `courseId`, salvo se você configurar `foreignKey` diferente).
- Em termos práticos: um curso pode ter vários professores.

---

```jsx
    User.hasMany(Evaluation)

```

- **Define que `User` *tem muitas* `Evaluation`** (1 → N).
- Cria/usa uma foreign key em `Evaluation` apontando para `User` (por padrão `userId`).
- Significado: um usuário pode ter várias avaliações.

---

```jsx
    Course.hasMany(Evaluation)

```

- **Define que `Course` *tem muitas* `Evaluation`** (1 → N).
- Cria/usa uma foreign key em `Evaluation` apontando para `Course` (por padrão `courseId`).
- Significado: um curso pode ter várias avaliações.

---

```jsx
}

```

- **Fecha a função `associations`**.

---

```jsx
const factory = {
    associations
}

```

- **Cria um objeto `factory` com uma propriedade `associations`** cujo valor é a função declarada acima.
- É apenas uma forma de agrupar e exportar a função — poderia exportar a função diretamente, mas aqui você exporta um objeto.

---

```jsx
export default factory;

```

- **Exporta `factory` como default** do módulo, permitindo que outro arquivo faça `import associationsFactory from "./associations.js"` e execute `associationsFactory.associations()` (ou faça `const { associations } = ...`).

---

### 🔎 Observações úteis (rápidas)

- Normalmente é boa prática também declarar o **lado inverso** das associações (ex.: `Teacher.belongsTo(Course)`), embora `hasMany` já crie a FK; `belongsTo` torna mais explícito e adiciona métodos úteis no model filho.
- Chame `associations()` **apenas depois** de importar/definir todos os models, e **antes** de sincronizar (`sequelize.sync()`), para que as FKs sejam consideradas.
- Se quiser controlar nomes de FK, nomes de alias ou comportamento de cascade, você pode passar opções: `Course.hasMany(Teacher, { foreignKey: 'course_id', as: 'teachers' })`.

---
---