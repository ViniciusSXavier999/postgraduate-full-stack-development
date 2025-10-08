# 2 → MÓDULOS PARA INTERAÇÃO

🏆 A primeira biblioteca que vamos instalar para interação á inquirer

```bash
npm install inquirer
```

### O QUE É ESSA BIBLIOTECA?

🔒 O **Inquirer** é uma **biblioteca do Node.js** (instalada via **npm**) usada para **criar interações no terminal** — ou seja, permite fazer perguntas ao usuário e capturar suas respostas de forma fácil e organizada.

👉 Você instala assim:

```bash
npm install inquirer

```

---

### 💡 Em resumo:

O **Inquirer** serve para:

- Criar **menus interativos** no terminal.
- Fazer **perguntas** (como texto, múltipla escolha, confirmação, etc).
- **Receber e usar as respostas** do usuário dentro do seu script Node.js.

---

### 🧩 Exemplo básico:

```jsx
import inquirer from "inquirer";

inquirer
  .prompt([
    {
      type: "input",
      name: "nome",
      message: "Qual é o seu nome?",
    },
    {
      type: "list",
      name: "linguagem",
      message: "Qual linguagem você prefere?",
      choices: ["JavaScript", "Python", "Java"],
    },
  ])
  .then((respostas) => {
    console.log(`Olá ${respostas.nome}, você gosta de ${respostas.linguagem}!`);
  });

```

---

### ⚙️ Tipos de perguntas suportadas:

- `input` → campo de texto
- `password` → texto oculto
- `confirm` → sim/não
- `list` → escolha única
- `checkbox` → múltiplas escolhas
- `number` → número

---

### 📦 Onde é usado:

- Em **CLIs (Command Line Interfaces)** — programas que rodam no terminal.
- Em **ferramentas de automação** ou **scripts interativos**, como geradores de código (ex: *Yeoman*, *Nest CLI*, *Create React App*).

---


### MÓDULO FS

🏆 Por padrão esse módulo já vem instalado nativamente com o node, então é necessário instala-lo, mas caso seja necessário:

```bash
npm i fs
```

### O QUE É ESSA BIBLIOTECA?

🏆 O **módulo `fs`** (de **File System**) é um **módulo nativo do Node.js** — ou seja, ele **vem instalado automaticamente** com o Node — e serve para **trabalhar com arquivos e pastas** do sistema.

---

### 📦 Em resumo:

O `fs` permite que você:

- **Leia** arquivos.
- **Crie** ou **edite** arquivos.
- **Apague** arquivos.
- **Crie pastas**, **liste diretórios**, e muito mais.

### MÓDULO PATH

🏆 Também já vem instalado nativamente com o node.

```bash
npm i path
```

### O QUE É ESSA MÓDULO?

🏆

 O **módulo `path`** também é um **módulo nativo do Node.js** (assim como o `fs`) — ou seja, **não precisa ser instalado**.

Ele serve para **trabalhar com caminhos de arquivos e pastas** de forma **segura e compatível com todos os sistemas operacionais** (Windows, Linux, macOS, etc).

---

### 📦 Em resumo:

O `path` ajuda a:

- Montar **caminhos de arquivos/pastas** corretamente;
- **Unir**, **normalizar** ou **separar** partes de um caminho;
- Obter o **nome do arquivo**, **extensão** ou **diretório** de um caminho.

---

### 🧩 Exemplo básico:

```jsx
import path from "path";

const caminho = path.join("pasta", "subpasta", "arquivo.txt");
console.log(caminho);

```

👉 No Windows, ele gera:

```
pasta\subpasta\arquivo.txt

```

👉 No Linux/macOS, ele gera:

```
pasta/subpasta/arquivo.txt

```

Isso é útil porque o Node adapta automaticamente o formato de caminho ao sistema operacional.

---

### ⚙️ Métodos principais:

| Método | O que faz | Exemplo |
| --- | --- | --- |
| `path.join()` | Junta partes de um caminho, corrigindo barras e redundâncias | `path.join('pasta', 'arquivo.txt')` → `'pasta/arquivo.txt'` |
| `path.resolve()` | Retorna o **caminho absoluto** (com base no diretório atual) | `path.resolve('pasta')` → `C:\projeto\pasta` |
| `path.basename()` | Retorna o **nome do arquivo** | `path.basename('/user/teste/arq.txt')` → `'arq.txt'` |
| `path.dirname()` | Retorna o **diretório pai** | `path.dirname('/user/teste/arq.txt')` → `'/user/teste'` |
| `path.extname()` | Retorna a **extensão do arquivo** | `path.extname('foto.png')` → `'.png'` |

---

### 💡 Exemplo prático:

```jsx
import path from "path";

const arquivo = "/home/vinicius/projetos/app/index.js";

console.log(path.basename(arquivo)); // index.js
console.log(path.dirname(arquivo));  // /home/vinicius/projetos/app
console.log(path.extname(arquivo));  // .js

```

---

### 🧠 Dica:

O `path` é muito usado junto com o `fs`, por exemplo:

```jsx
import fs from "fs";
import path from "path";

const caminho = path.join("dados", "texto.txt");
fs.writeFileSync(caminho, "Conteúdo de exemplo!");

```

Assim você garante que o caminho do arquivo será montado corretamente em qualquer sistema.

---


---

## QUAL UTILIZAR? (**CommonJS (CJS)** e **ES6 Modules (ESM)**)

🏆

---

## 🧩 Diferença entre **CommonJS (CJS)** e **ES6 Modules (ESM)**

| Característica | **CommonJS (CJS)** | **ES6 Modules (ESM)** |
| --- | --- | --- |
| **Origem** | Padrão antigo do Node.js | Padrão moderno do JavaScript (ES6/ES2015) |
| **Importar módulos** | `const fs = require('fs');` | `import fs from 'fs';` |
| **Exportar** | `module.exports = ...` ou `exports.nome = ...` | `export default ...` ou `export const nome = ...` |
| **Extensão padrão** | `.js` (sem configuração extra) | `.mjs` ou `.js` com `"type": "module"` |
| **Suporte nativo** | Sempre suportado no Node | Suportado apenas com `"type": "module"` no `package.json` |
| **Carregamento** | Síncrono (bloqueante) | Assíncrono |
| **Uso típico** | Projetos mais antigos, pacotes npm antigos | Projetos modernos, com sintaxe ES6+ |

---

## 💡 Em resumo:

- **CommonJS** → usa `require()` e `module.exports`
- **ESM (ES6)** → usa `import` e `export`

---

## 🧭 Como o Node decide qual usar?

O Node verifica o seu **`package.json`**.

Se você tiver:

### 🔹 CommonJS (padrão antigo)

```json
{
  "type": "commonjs"
}

```

ou **nenhum `"type"` definido**, o Node **assume automaticamente** CommonJS.

👉 Arquivos `.js` serão interpretados como CommonJS.

👉 Você usa `require()` e `module.exports`.

---

### 🔹 ES Modules (moderno)

```json
{
  "type": "module"
}

```

👉 Arquivos `.js` serão interpretados como **ESM**.

👉 Você usa `import` e `export`.

👉 Você pode importar módulos com sintaxe moderna:

```jsx
import fs from "fs";

```

---

## 🧠 Dica prática — qual usar?

| Situação | Melhor escolha |
| --- | --- |
| Projeto novo em Node.js (2023+) | `"type": "module"` (ESM) |
| Projeto antigo ou dependências que usam `require()` | CommonJS |
| Biblioteca npm que precisa compatibilidade ampla | CommonJS (ou usar ambos) |

---

## 🔍 Exemplo rápido de diferença:

### CommonJS:

```jsx
// index.js
const soma = require('./soma');
console.log(soma(2, 3));

// soma.js
module.exports = (a, b) => a + b;

```

### ES6 Modules:

```jsx
// index.js
import soma from './soma.js';
console.log(soma(2, 3));

// soma.js
export default (a, b) => a + b;

```

---

✅ **Recomendação atual:**

Use `"type": "module"` no `package.json`, a menos que você precise de compatibilidade com bibliotecas antigas.

---


---

## UTILIZANDO A BIBLIOTECA INQUIRER

### CÓDIGO

```bash
import inquirer from "inquirer";

inquirer.prompt(
    [
        {
            type: 'input',
            name: 'nome',
            message: 'Qual seu nome?',
        }, {
            type: 'list',
            name: 'idade',
            message: 'Qual sua idade?',
            choices: [
                '29 a 30',
                '40 a 50',
                '50+'
            ]
        }
    ]
).then((ansers) => {
    console.log(
        "Oi " + ansers.nome + 
        " com " + ansers.idade + " anos de vida! "
    )
});
```

### EXPLICAÇÃO DO CÓDIGO

🏆

```jsx
1  import inquirer from "inquirer";

2  inquirer.prompt(
3      [
4          {
5              type: 'input',
6              name: 'nome',
7              message: 'Qual seu nome?',
8          }, {
9              type: 'list',
10             name: 'idade',
11             message: 'Qual sua idade?',
12             choices: [
13                 '29 a 30',
14                 '40 a 50',
15                 '50+'
16             ]
17         }
18     ]
19 ).then((ansers) => {
20     console.log(
21         "Oi " + ansers.nome +
22         " com " + ansers.idade + " anos de vida! "
23     )
24 });

```

### Explicação linha a linha

**Linha 1**

`import inquirer from "inquirer";`

- Importa a biblioteca **Inquirer** usando sintaxe de ES Modules.
- Requer que o Node esteja configurado para ESM (por exemplo, `package.json` com `"type": "module"`) ou que você esteja usando `.mjs`.
- Alternativa CommonJS: `const inquirer = require('inquirer');`.

**Linha 2**

`inquirer.prompt(`

- Chama o método `prompt` da biblioteca. Esse método **exibe perguntas no terminal** e **retorna uma Promise** que resolve com as respostas do usuário.

**Linha 3**

`[`

- Início de um array de perguntas. Cada elemento do array é um objeto que descreve uma pergunta (tipo, texto, nome, etc).

**Linhas 4–8** (primeiro objeto)

```jsx
{
  type: 'input',
  name: 'nome',
  message: 'Qual seu nome?',
}

```

- `type: 'input'` → tipo da pergunta: campo de texto livre.
- `name: 'nome'` → chave que será usada no objeto de respostas (ex.: `answers.nome`).
- `message: 'Qual seu nome?'` → a pergunta exibida ao usuário no terminal.

**Linha 8** (separador) → fecha o primeiro objeto e começa o próximo.

**Linhas 9–17** (segundo objeto)

```jsx
{
  type: 'list',
  name: 'idade',
  message: 'Qual sua idade?',
  choices: [
    '29 a 30',
    '40 a 50',
    '50+'
  ]
}

```

- `type: 'list'` → apresenta opções em lista; o usuário escolhe uma (setas + Enter).
- `name: 'idade'` → chave no objeto de respostas (ex.: `answers.idade`).
- `message: 'Qual sua idade?'` → texto da pergunta.
- `choices: [...]` → array de opções mostradas ao usuário. Cada item pode ser uma string (retorna essa string) ou um objeto `{ name, value }` se quiser apresentar algo e devolver outro valor.

**Linha 18**

`]` → fim do array de perguntas.

**Linha 19**

`).then((ansers) => {`

- `prompt(...)` retorna uma **Promise**; `.then(...)` registra o que acontece quando o usuário respondeu todas as perguntas.
- O parâmetro `ansers` (observe a grafia) é o **objeto de respostas**. Ex.: `{ nome: 'Vinicius', idade: '29 a 30' }`.

**Linhas 20–23**

```jsx
console.log(
  "Oi " + ansers.nome +
  " com " + ansers.idade + " anos de vida! "
)

```

- Imprime no terminal uma mensagem combinando as respostas.
- Concatena strings com `+`. Poderia ser mais limpo usando template literals: `console.log(`Oi ${answers.nome} com ${answers.idade} anos de vida!`)`.

**Linha 24**

`});` → fecha o `.then` e a chamada.

---


### RESULTADO NO TERMINAL ESPERADO

```bash
$ node index.js
✔ Qual seu nome? Vini
✔ Qual sua idade? 29 a 30
Oi Vini com 29 a 30 anos de vida!
```

---

## AGORA VAMOS TESTAR O FS SUBINDO UM SERVIDOR DO NODE, MAS A PÁGINA LOCALHOST VAI SER CARREGADA DE UM HTML

### CÓDIGO HTML UTILIZADO

```bash
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OI NODE</title>
</head>
<body>
    <h1>OLÁ FS</h1>
    <p>Esse é um teste</p>
</body>
</html>
```

### AGORA VAMOS BUSCAR ESSE ARQUIVO UTILIZANDO O NODE QUE VAI UTILIZAR O FS

```bash
import {createServer} from 'http'
import { read, readFile } from 'fs'

createServer(function(req, res){
    readFile('demo-readFile.html', function(err, data){
        res.writeHead(200, {'content-Type': 'text/html'});
        res.write(data)
        return res.end();
    })
}

).listen(8080);
```

### EXPLICANDO O CÓDIGO

🏆

```jsx
import {createServer} from 'http'
import { read, readFile } from 'fs'

```

- **Linha 1:** importa `createServer` do módulo nativo `http` → serve para criar um servidor web.
- **Linha 2:** importa `read` e `readFile` do módulo nativo `fs` → serve para **ler arquivos** no sistema. (No código você só usa `readFile`.)

---

```jsx
createServer(function(req, res){

```

- Cria um servidor HTTP.
- Recebe uma **função callback** com dois parâmetros:
    - `req` → objeto da requisição do cliente
    - `res` → objeto da resposta que você vai enviar.

---

```jsx
    readFile('demo-readFile.html', function(err, data){

```

- Lê o arquivo `demo-readFile.html` de forma **assíncrona**.
- Callback recebe:
    - `err` → se houver erro na leitura
    - `data` → conteúdo do arquivo lido.

---

```jsx
        res.writeHead(200, {'content-Type': 'text/html'});

```

- Define o **cabeçalho da resposta HTTP**:
    - `200` → status OK
    - `Content-Type: text/html` → o navegador interpreta o conteúdo como HTML.

---

```jsx
        res.write(data)

```

- Escreve o **conteúdo do arquivo HTML** na resposta que será enviada ao cliente.

---

```jsx
        return res.end();

```

- Finaliza a resposta HTTP, enviando **todo o conteúdo para o navegador**.

---

```jsx
    })

```

- Fecha a callback de `readFile`.

---

```jsx
}
).listen(8080);

```

- Fecha a função do servidor.
- `.listen(8080)` → o servidor vai **escutar a porta 8080**.
- Agora você pode acessar no navegador: `http://localhost:8080` e verá o conteúdo do `demo-readFile.html`.

---

### 💡 Resumo rápido:

1. Importa módulos nativos (`http` e `fs`).
2. Cria um servidor HTTP.
3. Lê um arquivo HTML de forma assíncrona.
4. Configura cabeçalho HTTP e envia o conteúdo do arquivo como resposta.
5. Servidor roda na porta 8080.

---


### EM SEGUIDA, BASTA RODAR A APLICAÇÃO

```bash
node fs.js
```

### E ACESSAR O LOCALHOST:8080 NO NAVEGADOR

---

## AGORA VAMOS UTILIZAR O MÓDULO PATH

### CÓDIGO

```bash
import { basename, dirname } from "path";

/* UM MÉTODO VAI FALAR O NOME DO DIRETÓRIO E O OUTRO O NOME DO ARQUIVO */

let nomeArquivo = basename('./teste.txt');
let fileName = basename('/teste/something')

let dir = dirname('/test/something')
let diretorio = dirname('/test/something/file.txt')

console.log('nome do arquivo -> ' + nomeArquivo)
console.log('fileName -> ' + fileName)
console.log('dir ->' + dir)
console.log('diretorio -> ' + diretorio)
```

### EXPLICAÇÃO DO CÓDIGO

🏆

---

```jsx
import { basename, dirname } from "path";

```

- Importa dois métodos do módulo nativo **`path`** do Node.js:
    - `basename` → retorna **o nome do arquivo** de um caminho.
    - `dirname` → retorna **o caminho do diretório** de um arquivo ou pasta.

---

```jsx
let nomeArquivo = basename('./teste.txt');

```

- Pega apenas o **nome do arquivo** do caminho `./teste.txt`.
- Resultado: `"teste.txt"`

```jsx
let fileName = basename('/teste/something')

```

- Pega o **último segmento** do caminho `/teste/something`.
- Resultado: `"something"` (pode ser arquivo ou pasta; `basename` só pega a última parte).

---

```jsx
let dir = dirname('/test/something')

```

- Retorna o **diretório pai** do caminho `/test/something`.
- Resultado: `"/test"`

```jsx
let diretorio = dirname('/test/something/file.txt')

```

- Retorna o **diretório onde o arquivo está**.
- Resultado: `"/test/something"`

---

```jsx
console.log('nome do arquivo -> ' + nomeArquivo)
console.log('fileName -> ' + fileName)
console.log('dir ->' + dir)
console.log('diretorio -> ' + diretorio)

```

- Mostra no terminal os valores obtidos pelas funções.
- Saída esperada:

```
nome do arquivo -> teste.txt
fileName -> something
dir -> /test
diretorio -> /test/something

```

---

### 💡 Resumo rápido:

- `basename(caminho)` → retorna o **nome do arquivo ou última pasta**.
- `dirname(caminho)` → retorna o **caminho do diretório pai**.

---

## DÚVIDAS DURANTE A AULA

### O QUE É UMA PROMISSE?

🏆 Resumidamente 👇

Uma **Promise** (promessa) é um **objeto do JavaScript** que representa **algo que vai acontecer no futuro** — normalmente o **resultado de uma operação assíncrona** (como ler um arquivo, buscar dados de uma API, ou esperar o usuário responder no terminal).

---

### 💡 Em outras palavras:

É uma forma de **esperar** um resultado **sem travar o código**.

Enquanto a operação acontece, o programa continua rodando.

---

### ⚙️ Estrutura básica:

Uma promise tem **três estados**:

1. **Pending (pendente)** → ainda está executando.
2. **Fulfilled (resolvida)** → deu certo.
3. **Rejected (rejeitada)** → deu erro.

---

### 🧩 Exemplo simples:

```jsx
const promessa = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve("Deu certo!");
  }, 2000);
});

promessa.then((resultado) => {
  console.log(resultado); // → "Deu certo!" (depois de 2 segundos)
});

```

---

### ✅ Em resumo:

> Promise = um jeito de lidar com código assíncrono (tarefas que demoram) sem travar o programa.
> 

---


---

### QUAL A DIFERENÇA EM USAR NODE `NOMEARQUIVO.JS` E `NG SERVE`?

🏆 Perfeito! Vamos resumir a **diferença principal** entre rodar com `node nomearquivo.js` e `ng serve` no Angular:

---

## 1️⃣ `node nomearquivo.js`

- **O que é:** Executa diretamente um **arquivo JavaScript com Node.js**.
- **Uso típico:** Servidores backend, scripts de automação, ferramentas CLI.
- **Como funciona:**
    - Node interpreta o código JS e roda tudo na sua máquina.
    - Você precisa **definir a porta** se estiver criando um servidor HTTP.
- **Exemplo:**

```bash
node server.js

```

```jsx
import express from 'express';
const app = express();
app.listen(3000, () => console.log('Servidor rodando na porta 3000'));

```

- Resultado: Um servidor Node (API, backend) rodando na porta que você escolheu.

---

## 2️⃣ `ng serve`

- **O que é:** Comando do **Angular CLI** que inicia o **servidor de desenvolvimento do front-end**.
- **Uso típico:** Projetos Angular durante o desenvolvimento.
- **Como funciona:**
    - Compila os arquivos TypeScript/HTML/CSS do Angular.
    - Serve o projeto em um **servidor local de desenvolvimento** (default: porta 4200).
    - Suporta **hot reload**, ou seja, atualiza automaticamente o navegador quando você salva arquivos.
- **Exemplo:**

```bash
ng serve

```

- Resultado: O front-end Angular é servido em `http://localhost:4200`.

---

## 🔹 Resumindo a diferença

| Aspecto | `node nomearquivo.js` | `ng serve` |
| --- | --- | --- |
| Tipo de projeto | Backend / scripts JS | Frontend Angular |
| Porta padrão | Depende do código (ex: 3000) | 4200 |
| Compilação | Não compila TS (Node roda JS) | Compila TypeScript/HTML/CSS |
| Hot reload | Não | Sim |
| Uso em produção | Sim (Node server) | Não (apenas dev) |

---

💡 **Dica:**

Em projetos completos **full-stack**, você pode ter:

- **Backend Node/Express** → `node server.js`
- **Frontend Angular** → `ng serve` (em desenvolvimento)
- Para produção, você faz o **build do Angular** (`ng build`) e serve os arquivos estáticos pelo Node ou outro servidor real.

---


---

### O QUE É UMA FUNÇÃO CALLBACK?

🏆 Uma **função callback** é uma **função que você passa como argumento para outra função**, e que **será executada depois** que algum evento ou operação terminar.

---

### 💡 Em outras palavras:

- É uma forma de dizer:

> “Quando você terminar essa tarefa, executa esta função.”
> 
- Muito usada em **operações assíncronas** (como ler arquivos, fazer requisições ou timers).

---

### 🧩 Exemplo:

```jsx
function cumprimentar(nome) {
  console.log("Olá, " + nome);
}

function processarUsuario(callback) {
  const nome = "Vinicius";
  callback(nome); // chama a função passada
}

processarUsuario(cumprimentar);
// Saída: Olá, Vinicius

```

---

### 📌 Exemplo com Node/FS:

```jsx
import { readFile } from 'fs';

readFile('arquivo.txt', 'utf-8', function(err, data) {
  if(err) throw err;
  console.log(data);
});

```

- A função dentro do `readFile` é o **callback**, que será executada **quando a leitura do arquivo terminar**.

---

Em resumo:

> Callback = função passada para outra função para ser executada depois.
> 
