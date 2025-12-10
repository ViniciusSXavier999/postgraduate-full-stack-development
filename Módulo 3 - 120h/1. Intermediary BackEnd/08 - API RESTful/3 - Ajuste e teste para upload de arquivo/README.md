# 3 → AJUSTE E TESTE PARA UPLOAD DE ARQUIVO

🏆 Vamos realizar testes na aplicação e verificar o upload acontecendo.


---

🏆 Precisamos ter o cors instalado no projeto


### PASSO A PASSO

## 1

🏆 Vamos iniciar rodando o projeto back-end

```tsx
node index.js
```

> Lembrando que o database tem que estar criado no mysql workbench, o sequelazi só cria as tabelas.
> 

## 2

🏆 No lado do front-end, precisamos conferir os endpoints e se eles estão configurados com a porta 3000, logo em seguida vamos rodar o comando: 

```tsx
ng serve 
```

> Responsável pelo build da aplicação.
> 

> Qualquer alteração que você fizer, ele vai atualizar automaticamente sem que você precise ficar parando a aplicação e rodando novamente.
> 

## 3

🏆 Vamos iniciar realizando o teste de cadastrar um novo usuário enviando uma imagem

> Vamos ter que realizar alguns ajustes referente ao envio e também para atualização de usuários.
> 

### FOI CRIADO O MÉTODO QUE ENVIA A IMAGEM DO USUÁRIO DIRETAMENTE PARA O NAVEGADOR.

```tsx
router.get('/userImage/:id', getUserImage);

async function getUserImage(req, res) {

    try {
        const user = await userService.getUserById(req.params.id);

        // Envia o arquivo da imagem
        const caminhoCompleto = process.cwd() + "\\" + user.profile_picture;
        return res.sendFile(caminhoCompleto);

    } catch (error) {
        console.error("Erro ao buscar imagem do usuário:", error);
        return res.status(500).json({ message: "Erro ao carregar imagem" });
    }
}

```

🏆

### EXPLICAÇÃO DO MÉTODO

## ✅ **Método SEM uso de lambda**

```jsx
router.get('/userImage/:id', getUserImage);

async function getUserImage(req, res) {

    try {
        const user = await userService.getUserById(req.params.id);

        // Envia o arquivo da imagem
        const caminhoCompleto = process.cwd() + "\\" + user.profile_picture;
        return res.sendFile(caminhoCompleto);

    } catch (error) {
        console.error("Erro ao buscar imagem do usuário:", error);
        return res.status(500).json({ message: "Erro ao carregar imagem" });
    }
}

```

---

## 📘 **Explicação detalhada linha por linha**

---

## ✔️ **1. Registrar a rota**

```jsx
router.get('/userImage/:id', getUserImage);

```

- Cria uma rota GET chamada `/userImage/:id`
- Quando alguém acessa `/userImage/5`, por exemplo, o Express chama **a função `getUserImage`**
- Aqui não existe arrow function; apenas referencia a função já declarada.

---

## ✔️ **2. Criar a função de forma tradicional**

```jsx
async function getUserImage(req, res) {

```

- Cria uma função **assíncrona** que recebe a requisição e a resposta.
- Essa função será executada quando a rota for chamada.

---

## ✔️ **3. Buscar o usuário no banco**

```jsx
const user = await userService.getUserById(req.params.id);

```

- `req.params.id` pega o ID que veio na URL.
- Exemplo: `/userImage/10` → `id = 10`
- `getUserById` consulta o banco e retorna o usuário com esse ID.
- O objeto retornado deve ter:
    
    `user.profile_picture` → caminho salvo pelo multer.
    

---

## ✔️ **4. Montar o caminho completo do arquivo**

```jsx
const caminhoCompleto = process.cwd() + "\\" + user.profile_picture;

```

- `process.cwd()` = retorna a **pasta raiz do projeto** (onde o index.js está).
- Como o multer salva caminhos relativos (ex: `"uploads/foto.png"`),
    
    aqui montamos o caminho ABSOLUTO.
    
- No Windows, usamos **barra invertida `\`**.

Exemplo final:

```
C:\meu_projeto\uploads\imagem123.png

```

---

## ✔️ **5. Enviar a imagem como arquivo**

```jsx
return res.sendFile(caminhoCompleto);

```

- `sendFile` envia o arquivo da imagem diretamente para o navegador.
- O navegador automaticamente exibe a imagem.

Exemplo no HTML:

```html
<img src="http://localhost:3000/userImage/10">

```

A foto do usuário aparece!

---

## ✔️ **6. Tratamento de erros**

```jsx
} catch (error) {
    console.error("Erro ao buscar imagem do usuário:", error);
    return res.status(500).json({ message: "Erro ao carregar imagem" });
}

```

Se:

- O usuário não existir
- O arquivo não estiver no disco
- Ou houver algum erro no banco

Ele retorna um erro amigável para o front-end.

---

# 🎯 **Resumo final**

| Parte | O que faz |
| --- | --- |
| Rota `/userImage/:id` | Recebe um ID de usuário |
| `getUserById` | Busca o usuário no banco |
| `user.profile_picture` | Pega o caminho da imagem salva pelo multer |
| `process.cwd()` | Obtém a pasta raiz do projeto |
| `sendFile()` | Envia a imagem para o navegador. |

---

---

### CURIOSIDADE

### QUANDO USAR {} OU NÃO DURANTE A IMPORTAÇÃO DE UM MÓDULO

🏆

### ✅ **Por que agora foi necessário usar `{}` ao importar?**

Porque **`promisify` é uma named export**, enquanto antes você estava importando **default exports**.

---

# 📌 **1. Import com `{}` = named export**

Quando uma biblioteca/exporta **várias funções separadas**, cada uma com seu nome, você precisa importar usando **desestruturação**:

```jsx
import { promisify } from "util";

```

Isso acontece porque o módulo **exporta exatamente esse nome**:

```jsx
export function promisify() {}

```

Ou em CommonJS:

```jsx
module.exports = { promisify }

```

Então você precisa importar por nome.

---

# 📌 **2. Import sem `{}` = default export**

Exemplo:

```jsx
import express from "express";

```

Aqui, o módulo `express` exporta **um único valor principal**, chamado `default`.

Equivale a:

```jsx
export default express;

```

Então não existe "nome", apenas o valor default.

---

# 📌 **3. Resumo visual**

| Situação | Como importar | Por quê |
| --- | --- | --- |
| Export default | `import x from "mod"` | Só existe um valor principal |
| Export nomeado (named export) | `import { x } from "mod"` | Você precisa importar pelo nome exato |
| Export default + named juntos | `import x, { y } from "mod"` | Módulo mistura ambos |

---

# ✔️ Por isso antes não precisou `{}`

Express, multer e Sequelize possuem **default exports**.

Já `promisify` está dentro do módulo `util` como **named export**, não default.

