# 1 → GRAVAÇÃO DE ARQUIVO NO BANCO

🏆 Vamos adicionar uma nova funcionalidade no projeto.

🏆 Vamos criar uma funcionalidade no qual é possível enviar uma foto

🏆 Cada vez que acrescentarmos atributos no objeto, colocamos no final dele.


---

### VAMOS UTILIZAR O MULTER E O PROCESS

## ✅ **Multer**

É um **middleware do Node.js (para Express)** usado para **receber e processar upload de arquivos** enviados pelo cliente (imagens, PDFs, etc).

Exemplo de uso:

- salvar imagem enviada pelo front
- acessar `req.file` ou `req.files`

---

## ✅ **process**

É um **objeto global do Node.js** que dá acesso ao **processo atual** em execução.

Usos comuns:

- acessar variáveis de ambiente: `process.env.PORT`
- terminar o processo: `process.exit()`
- ver argumentos do script: `process.argv`

---

🏆 VAMOS TER UMA PARTE PARA GUARDAR E OUTRA PARA ENVIAR.

🏆 Vamos adicionar essa linha de código no userController.js:

```jsx
const storage = multer.diskStorage()
```

### EXPLICAÇÃO

### **O que faz essa linha de código?**

```jsx
const storage = multer.diskStorage()

```

### **Explicação leiga:**

Essa linha cria uma **configuração de como e onde os arquivos enviados pelo usuário serão salvos no computador/servidor**.

Pense assim:

- O `multer` é como um "carteiro" que recebe arquivos (como fotos, PDFs, etc.).
- O `diskStorage()` diz ao multer **“guarde esses arquivos no disco (HD)”** e permite configurar:
    - a pasta onde os arquivos serão guardados,
    - o nome que cada arquivo vai ter.

Ou seja, essa linha prepara um **“plano de armazenamento”** para o multer.


### MÉTODO PRONTO

```jsx
const storage = multer.diskStorage({
    destination: function(req, file, callback) {
        callback(null, './images')
    },
    filename: function(req, file, callback) {
        callback(null, req.body.first_name + "_" + req.body.last_name + "_" + Date.now() + file.originalname)
    }
})
```

🏆

# 📦 O que esse código faz?

```jsx
const storage = multer.diskStorage({
    destination: function(req, file, callback) {
        callback(null, './images')
    },
    filename: function(req, file, callback) {
        callback(null, req.body.first_name + "_" + req.body.last_name + "_" + Date.now() + file.originalname)
    }
})

```

Esse código cria uma **configuração de como os arquivos enviados pelo usuário serão salvos no servidor**.

Imagine que o servidor é como um computador, e quando você faz upload de uma foto, ele precisa saber:

1. **Onde guardar o arquivo** (em qual pasta)
2. **Com qual nome salvar o arquivo**

Esse `storage` define exatamente isso.

---

# 🗂️ 1. `destination`: onde salvar o arquivo

```jsx
destination: function(req, file, callback) {
    callback(null, './images')
}

```

### Explicação simples:

- Essa função diz ao servidor: **"salve o arquivo dentro da pasta `images`"**.
- O `callback(null, './images')` significa:
    - `null` → não houve erro
    - `'./images'` → pasta onde o arquivo será colocado

Então, toda foto/arquivo enviado será guardado dentro da pasta **images**.

---

# 🏷️ 2. `filename`: qual será o nome do arquivo

```jsx
filename: function(req, file, callback) {
    callback(null, req.body.first_name + "_" + req.body.last_name + "_" + Date.now() + file.originalname)
}

```

### Explicação simples:

Aqui é definido **como o arquivo será renomeado quando for salvo**.

O nome ficará assim:

```
firstName_lastName_timestamp_nomeOriginal.ext

```

Exemplo:

Se o usuário João da Silva enviar um arquivo chamado `foto.png`, o nome salvo pode ficar:

```
Joao_Silva_1733187045123foto.png

```

### Por que isso é útil?

- Evita que dois arquivos com o mesmo nome se sobrescrevam.
- Facilita identificar qual arquivo pertence a qual usuário.
- O `Date.now()` garante um número único baseado na data/hora atual.

---

# 📌 Resumo leigo

- **`multer.diskStorage`** → cria as regras de como salvar arquivos.
- **`destination`** → escolhe a pasta.
- **`filename`** → define o nome final do arquivo.
- Esse código garante que todo arquivo enviado será salvo na pasta `images` com um nome único contendo o nome do usuário e a hora exata do upload.

---


---

🏆 Temos que adicionar essa propriedade no método de adicionar usuário para não dar erro.

🏆 Sendo assim, agora temos o backEnd pronto onde é possível fazer o upload de imagens.


### ADICIONANDO MÉTODO RESPONSÁVEL PELO UPLOAD

```jsx
const upload = multer({storage: storage}).single('file')
```

### EXPLICAÇÃO DO CÓDIGO

🏆

# 📎 O que faz essa linha?

```jsx
const upload = multer({storage: storage}).single('file')

```

## ✔️ Explicação leiga:

Essa linha cria **um "processador de upload"** que:

1. Usa a configuração de armazenamento que você criou (`storage`)
2. Aceita **apenas um único arquivo por vez**
3. Espera que esse arquivo venha no campo chamado **"file"** do formulário

---

# 🔍 Quebra parte por parte:

### **1. `multer({ storage: storage })`**

Isso cria o multer usando aquela configuração que diz **como salvar o arquivo**

(pasta, nome, etc.).

É como dizer:

> “Multer, quando chegar um arquivo, use essas regras aqui!”
> 

---

### **2. `.single('file')`**

Isso diz que você quer que o multer:

- Aceite **somente um arquivo**
- Esse arquivo deve vir com o nome **`file`**

Por exemplo, no front-end ou no Insomnia/Postman, você vai enviar o arquivo assim:

```
file: (selecionar arquivo)

```

Se o campo tiver outro nome, não funciona.

---

# 🎯 Em outras palavras:

Essa linha cria uma função chamada **`upload`** que você usa no controller para receber um arquivo.

