# 3 → MÓDULOS PARA REQUISIÇÕES

## VAMOS APRENDER DOIS MÓDULOS PARA REQUISIÇÃO: HTTP E URL

🏆 Ambos métodos vão trabalhar no HTML, a principal diferença deles é que o módulo http ele é nativo do node e o URL ele é público, por isso é necessário baixar.

```bash
npm i url
```


---

## VAMOS INICIAR REALIZANDO UM TESTE “OLÁ MUNDO” COM O MÓDULO HTTP

### CÓDIGO

```bash
import { createServer } from 'http'

createServer(function (req, res) {

    res.write('Hello World Descomplica!')
    return res.end();

}).listen(8080);
```

### EXPLICAÇÃO RESUMIDA DO CÓDIGO

🏆 Esse código **cria um servidor web simples com Node.js**.

---

### Linha por linha:

```jsx
import { createServer } from 'http'

```

- Importa o módulo nativo **`http`**, que permite criar servidores.

```jsx
createServer(function (req, res) {

```

- Cria um **servidor HTTP**.
- A função recebe:
    - `req` → informações da **requisição** do cliente.
    - `res` → usado para **enviar a resposta**.

```jsx
    res.write('Hello World Descomplica!')

```

- Escreve o texto `"Hello World Descomplica!"` como resposta.

```jsx
    return res.end();

```

- Finaliza a resposta e envia para o navegador.

```jsx
}).listen(8080);

```

- Faz o servidor **escutar a porta 8080**.
- Ou seja, se você abrir `http://localhost:8080`, verá a mensagem **"Hello World Descomplica!"**.

---

👉 **Resumo curto:**

> Cria um servidor Node.js que responde “Hello World Descomplica!” quando acessado na porta 8080.
> 

🏆 As nossas aplicações vão ter essa configuração no index para conseguir disponibilizar a nossa aplicação backEnd para o frontEnd


---

## AGORA VAMOS CRIAR O SERVIDOR E FAZER UM TRATAMENTO DE URL

### VAMOS INICIAR CRIANDO DOIS ARQUIVOS

- verao.html
- inverno.html

### AGORA COMO VAMOS FAZER PARA IDENTIFICAR ESSES ARQUIVOS?

🏆 Vamos criar um novo arquivo e chamar ele de url.js, vamos utilizar a mesma estrutura do código do http.js


### CÓDIGO

```bash
import { createServer } from 'http'
import { parse } from 'url';
import { readFile } from 'fs';

createServer(function (req, res) {

    const q = parse(req.url, true)
    const filename = "." + q.pathname

       readFile(filename, function(err, data){
        if(err) {
            res.writeHead(404, {'Content-Type': 'text/html'})
            return res.end("404 not found");
        }
        res.writeHead(200, {'content-Type': 'text/html'});
        res.write(data)
        return res.end();
    })

}).listen(8080);
```

### EXPLICAÇÃO DO CÓDIGO

🏆

```jsx
import { createServer } from 'http'

```

- Importa `createServer` do módulo nativo **http**.
- `http` → usado para **criar um servidor web**.

```jsx
import { parse } from 'url';

```

- Importa `parse` do módulo nativo **url**.
- `parse()` → **divide/analisa** uma URL (retorna `pathname`, `query`, etc).

```jsx
import { readFile } from 'fs';

```

- Importa `readFile` do módulo nativo **fs** (File System).
- `readFile()` → **lê arquivos** de forma assíncrona.

```jsx
createServer(function (req, res) {

```

- Cria o servidor HTTP e define o **callback** que roda a cada requisição.
- `req` = requisição do cliente; `res` = objeto para montar a resposta.

```jsx
    const q = parse(req.url, true)

```

- Usa `parse` para transformar `req.url` em um **objeto** (`q`).
- O `true` → converte a query string em objeto (`q.query`).

```jsx
    const filename = "." + q.pathname

```

- Monta o **caminho local** do arquivo a partir do `pathname`.
- Ex.: se `q.pathname` = `/index.html`, `filename` = `./index.html`.

```jsx
    readFile('filename', function(err, data){

```

- Chama `readFile` para **ler o arquivo** e fornece um **callback** `(err, data)`.
- `(err)` = erro na leitura; `(data)` = conteúdo lido.

```jsx
        if(err) {

```

- Verifica se houve erro ao ler o arquivo (por exemplo: arquivo não existe).

```jsx
            res.writeHead(404, {'Content-Type': 'text/html'})

```

- Define o cabeçalho HTTP com **status 404** e `Content-Type: text/html`.

```jsx
            return res.end("404 not found");

```

- Envia a resposta de erro e **finaliza** a conexão.

```jsx
        }

```

- Fecha o `if` (continua se não houve erro).

```jsx
        res.writeHead(200, {'content-Type': 'text/html'});

```

- Define o cabeçalho HTTP com **status 200 OK** e `Content-Type: text/html`.

```jsx
        res.write(data)

```

- Escreve o **conteúdo do arquivo** na resposta (envia ao cliente).

```jsx
        return res.end();

```

- Finaliza a resposta (envia tudo para o navegador).

```jsx
    })

```

- Fecha o callback de `readFile`.

```jsx
}).listen(8080);

```

- Faz o servidor **escutar a porta 8080**.
- Acessível em `http://localhost:8080`.

---


### REALIZANDO TESTES

🏆 CASO A GENTE DIGITE A URL DESSA FORMA http://localhost:8080/inverno.html

💡 Vai ser disponibilizado o conteúdo do arquivo inverno.html
---

🏆 CASO A GENTE DIGITE A URL DESSA FORMA http://localhost:8080/inverno.html

💡 Vai ser disponibilizado o conteúdo do arquivo verao.html

💡 Caso nada seja passado na url, será retornado uma mensagem de “404 not found”


---

🔥 Com esse módulo de URL podemos ter personalizações simples de páginas estáticas do [localhost](http://localhost) em projetos pequenos

