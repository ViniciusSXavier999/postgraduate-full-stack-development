# 1 → NODE

🏆 A linguagem Javascript foi criada em 1995 e foi feita justamente para facilitar o desenvolvimento para a web, para facilitar ainda mais esse desenvolvimento, vamos trabalhar com o framework node, que é especifico para linguagem Javascript.

🏆 O Javascript veio para deixar a comunicação entre o navegador e máquina muito mais simples e esse framework vai fazer essa parte.


## CLIENT-SIDE X SERVER-SIDE

🏆

🔹 **Client-side**

- É tudo o que acontece **no navegador do usuário**.
- Exemplo: HTML, CSS e JavaScript que rodam no browser para montar a interface e interagir com o usuário.
- Linguagens: normalmente **JavaScript**, mas também temos tecnologias como React, Angular, Vue etc.
- Característica: depende do computador/dispositivo do cliente.

---

### 🔹 **Server-side**

- É tudo o que acontece **no servidor**, antes de a resposta ser enviada ao navegador.
- Exemplo: quando você faz login, o servidor valida seu usuário e senha no banco de dados.
- Linguagens: PHP, Java, Python, Ruby, e também **JavaScript com Node.js**.
- Característica: depende do servidor, não do cliente.

---

### 🔹 **E o que isso tem a ver com o Node.js?**

- O **Node.js** trouxe o **JavaScript** para o **server-side**.
- Antes, o JS era usado só no navegador (**client-side**).
- Agora, com o Node, você pode usar **a mesma linguagem (JavaScript)** tanto no cliente quanto no servidor.

---

👉 Em resumo:

- **Client-side**: roda no navegador (interface, interatividade).
- **Server-side**: roda no servidor (processamento, banco de dados).
- **Node.js**: permite usar JavaScript no **server-side**.

🟢 ATRAVÉS DO NODE CONSEGUIMOS FAZER EM QUALQUER MAQUINA E DISPONILIZAR EM QUALQUER NAVEGADOR.


## PRINCIPAL PAPEL DO NODE

🟢 Node.js serve para **executar JavaScript no servidor**, permitindo:

- Criar **servidores web** e **APIs**.
- Desenvolver **aplicações em tempo real** (chat, jogos online).
- Conectar com **bancos de dados**.
- Automatizar tarefas e construir ferramentas.

👉 Em resumo: o Node.js é usado para construir aplicações rápidas, escaláveis e que precisam lidar com muitas conexões ao mesmo tempo.


---

### VAMOS FAZER UM EXEMPLO DE “HELLO WORD” COM O NODE.

```java
// server.mjs
import { createServer } from 'node:http';

const server = createServer((req, res) => {
  res.writeHead(200, { 'Content-Type': 'text/plain' });
  res.end('Hello World!\n');
});

// starts a simple http server locally on port 3000
server.listen(3000, '127.0.0.1', () => {
  console.log('Listening on 127.0.0.1:3000');
});

// run with `node server.mjs`
```

<aside>
🏆

```jsx
// server.mjs
import { createServer } from 'node:http';

```

- importa a função `createServer` do módulo interno `http`.
- o prefixo `node:` deixa claro que é um módulo core do Node (evita colisões com pacotes `http` de terceiros).
- uso de `import` indica **ES Modules** — por isso o arquivo tem `.mjs` (ou você poderia usar `"type":"module"` no package.json).

```jsx
const server = createServer((req, res) => {

```

- cria um servidor HTTP e registra a função que será chamada a cada requisição.
- `req` é o objeto de requisição (IncomingMessage) — tem `req.method`, `req.url`, `req.headers`, etc.
- `res` é o objeto de resposta (ServerResponse) — tem métodos para enviar cabeçalhos e corpo.

```jsx
  res.writeHead(200, { 'Content-Type': 'text/plain' });

```

- define o **status** da resposta (`200`) e os **headers** (aqui: conteúdo texto simples).
- alternativa equivalente mais explícita: `res.statusCode = 200; res.setHeader('Content-Type', 'text/plain');`

```jsx
  res.end('Hello World!\n');
});

```

- envia o corpo (`'Hello World!\n'`) e **encerra** a resposta. `res.end()` pode receber string ou Buffer.
- após `end()` a conexão pode ser fechada (ou mantida se `Connection: keep-alive`).

```jsx
// starts a simple http server locally on port 3000
server.listen(3000, '127.0.0.1', () => {

```

- inicia o servidor escutando na porta `3000` e no endereço `127.0.0.1` (loopback/local).
- o terceiro argumento é um callback executado quando o servidor começou a escutar.
- se quiser que fique acessível na rede, use `0.0.0.0` ou omita o host (outra opção: IPv6 `::`).

```jsx
  console.log('Listening on 127.0.0.1:3000');
});

```

- imprime uma mensagem no terminal confirmando que o servidor subiu.

```jsx
// run with `node server.mjs`

```

- executa com `node server.mjs`. Como o arquivo é `.mjs`, o Node roda em modo ES Module automaticamente.
- em versões antigas do Node o suporte a ESM era experimental; em versões modernas o comportamento é nativo.

---

### Observações rápidas

- Esse é um servidor **muito simples** — útil para aprendizado e testes. Para rotas, middleware, tratamento de erros e produtividade costuma-se usar frameworks (Express, Fastify, etc.).
- O modelo do Node é **assíncrono e orientado a eventos**, então se você fizer I/O bloqueante dentro do handler pode travar o loop de evento.
- Se você preferir a sintaxe CommonJS (antiga), o mesmo exemplo ficaria com `const { createServer } = require('http');` e arquivo `.js` sem `"type":"module"`.
</aside>

---

### ES MODULES X COMMONJS

---

### 🔹 **CommonJS (CJS)**

- **Padrão antigo do Node.js** (criado antes do ES6).
- Usa `require` e `module.exports`.
- Carregamento **síncrono** (um módulo é carregado todo de uma vez).
- Exemplo:
    
    ```jsx
    // math.js
    function soma(a, b) { return a + b; }
    module.exports = soma;
    
    // app.js
    const soma = require('./math.js');
    console.log(soma(2, 3));
    
    ```
    

---

### 🔹 **ES Modules (ESM)**

- **Padrão oficial do JavaScript (desde ES6)**.
- Usa `import` e `export`.
- Carregamento **assíncrono** (melhor para web e bundlers).
- Exemplo:
    
    ```jsx
    // math.mjs
    export function soma(a, b) { return a + b; }
    
    // app.mjs
    import { soma } from './math.mjs';
    console.log(soma(2, 3));
    
    ```
    

---

### ✅ Resumindo em 1 linha:

- **CommonJS** = sistema de módulos antigo do Node (`require`).
- **ES Modules** = padrão moderno e oficial do JS (`import/export`), funciona no navegador e no Node.