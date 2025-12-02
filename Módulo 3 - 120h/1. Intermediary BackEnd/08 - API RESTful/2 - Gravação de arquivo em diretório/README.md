# 2 → GRAVAÇÃO DE ARQUIVO EM DIRETÓRIO

🏆 Vamos aprender a fazer o upload da imagem na parte do front-end.

🟣 A branch que você está utilizando para criar uma nova funcionalidade, sempre vai estar à frente da main (branch instável em que o programa esta rodando normalmente)


---

### VAMOS ADICIONAR UMA NOVA CONFIGURAÇÃO NO USER.SERVICE PARA O MÉTODO PUT E POST

```jsx
  let config = {
      headers: {
        "Content-Type": "multipart/form-data"
      }
    }
```

🟣

### EXPLICAÇÃO DO CÓDIGO

### 📦 O que significa essa configuração?

```jsx
let config = {
  headers: {
    "Content-Type": "multipart/form-data"
  }
}

```

## ✔️ Explicação leiga:

Essa configuração está dizendo para o **axios** (ou qualquer biblioteca de requisição):

> “Ei, eu estou enviando arquivos (como imagens), então trate essa requisição como um formulário com upload.”
> 

É isso que `multipart/form-data` significa:

📁 **um tipo especial de formulário que permite enviar arquivos + outros dados juntos.**

---

# 🧠 Por que isso é necessário?

Quando você envia **arquivos** (imagem, PDF, vídeo, etc.), o navegador ou o aplicativo **não pode usar JSON**, porque JSON não suporta arquivos binários.

Então a requisição precisa ir como:

- partes separadas
- cada parte contendo um pedaço do dado
- uma parte é a imagem
- outras partes podem ser: nome, e-mail, id etc.

Por isso esse formato se chama **multipart** (várias partes).

---

# 📌 Em resumo leigo:

Essa configuração está dizendo:

✔️ “Esse PUT está enviando um arquivo.”

✔️ “Use o modo certo para enviar arquivos.”

✔️ “O servidor vai conseguir entender que é upload.”

Sem isso, o servidor **não entenderia a imagem** que você está enviando.


---

🏆 CONFIGURANDO O FORMULÁRIO DO user form, começando pelo HTML

### HTML

```html
 <form [formGroup]="form">
        <formly-form [model]="model" [fields]="fields" [options]="options" [form]="form"></formly-form>
        <!-- adicionar o options no HTML  [options]="options" -->
        <img [src]="url" alt="Image Preview" width="200px" height="200px"
          class="row d-flex align-content-center justify-content-center">
        <input type="file" style="display: none;" name="file" accept="image/*" [multiple]="false"
          (change)="onSelectNewFile($event)" #fileInput>
        <input type="button" class="btn btn-primary" value="Choose file" (click)="fileInput.click()" />
      </form>
```


---

### O QUE É O BLOB?

🏆

### 📌 O que significa isso?

```tsx
fileSelected?: Blob;

```

Essa linha provavelmente está em um **TypeScript model/interface**.

---

# 🧠 O que é um *Blob*?

**Blob** significa **Binary Large Object**.

Em português: **objeto grande de dados binários**.

Mas, falando de forma simples:

👉 **Um Blob é um tipo de dado usado para representar arquivos na web.**

Ele pode ser:

- uma imagem
- um PDF
- um vídeo
- um arquivo qualquer enviado no formulário

É assim que o navegador representa arquivos carregados pelo usuário.

---

# 👶 Explicação para leigo:

Imagine que o arquivo que o usuário seleciona é transformado em uma “caixa” com dados binários.

Essa caixa é o **Blob**.

Então:

```tsx
fileSelected?: Blob;

```

significa:

> “Essa variável pode ter um arquivo… ou pode não ter (porque tem o ?).
> 
> 
> E, se tiver, esse arquivo será guardado como um **Blob**.”
> 

---

# 🔍 Por que usar Blob?

Porque o TypeScript precisa saber que o campo `fileSelected`:

- guarda **um arquivo de verdade**, não uma string
- pode ser enviado dentro de um `FormData`
- pode ser convertido para `File`, base64, etc.

---

# 📌 Exemplo prático

Quando você faz isso num input:

```html
<input type="file" (change)="onFileChange($event)">

```

No TypeScript:

```tsx
onFileChange(event: any) {
  this.fileSelected = event.target.files[0]; // isso é um Blob
}

```

O arquivo selecionado pelo usuário vira um **Blob**, então sua interface está dizendo:

> “fileSelected guarda um arquivo.”
> 

---


### O QUE É O DOM SINITIZER?

🏆

### 🛡️ O que é o **DomSanitizer** no Angular?

O **DomSanitizer** é um *“segurança do shopping”* que fica na porta do seu aplicativo Angular.

Ele verifica se algum conteúdo que você quer mostrar na tela **é seguro** ou pode causar ataques, como:

- scripts maliciosos
- URLs perigosas
- HTML com código escondido

Ou seja:

👉 **Ele limpa (“sanitiza”) qualquer conteúdo suspeito antes de deixar aparecer no navegador.**

---

# 👶 Explicação leiga:

Imagine que você está deixando pessoas entrarem em uma festa.

Antes de entrar, cada pessoa passa por um segurança que verifica se ela não está levando nada perigoso.

O **DomSanitizer** faz exatamente isso, só que com:

- URLs
- HTML
- vídeos
- imagens
- estilos
- conteúdo vindo de APIs

---

# 💡 Por que isso existe?

Porque o Angular tenta **proteger você automaticamente contra ataques XSS**

(códigos maliciosos inseridos em HTML).

Quando ele acha algo suspeito, ele **bloqueia** esse conteúdo.

Mas às vezes você quer **permitir** algo que o Angular acha inseguro — por exemplo:

- mostrar uma imagem de uma URL externa
- exibir um vídeo do YouTube através de um link dinâmico
- injetar HTML vindo do backend

Aí você usa o **DomSanitizer** para dizer:

> "Ok Angular, eu sei o que estou fazendo, deixe isso passar."
> 

---

# 📌 Exemplo real

### Embed de vídeo do YouTube

O Angular bloqueia isso:

```tsx
this.videoUrl = 'https://www.youtube.com/embed/abc123';

```

Então você precisa “sanitizar”:

```tsx
constructor(private sanitizer: DomSanitizer) {}

this.videoUrl = this.sanitizer.bypassSecurityTrustResourceUrl(
  'https://www.youtube.com/embed/abc123'
);

```

Agora o Angular confia e deixa mostrar o vídeo.

---

# 🧪 Em resumo:

✔️ **DomSanitizer** = “protetor” que impede conteúdo perigoso

✔️ Evita ataques XSS

✔️ Permite você marcar conteúdo como **seguro** quando necessário

✔️ Muito usado para:

- imagens dinâmicas
- iframes
- URLs externas
- HTML vindo do backend

---

### EXPLICANDO ALGUMAS PARTES DE CÓDIGO

```tsx
    this.route.queryParams.subscribe(async (params: any) => {
      if (params.id !== undefined && params.id !== null) {
        this.user = await this.userService.get<any>({
          url: `http://localhost:3000/user/${params.id}`,
          params: {
          }
        });
        this.model = this.user;
        this.getImage('http://localhost:3000/userImage/' + this.model.id).subscribe(x => this.url = x)
      } else {
        this.model = {}
      }
    });
  }
```

🏆

### EXPLICAÇÃO DO CÓDIGO

```tsx
this.route.queryParams.subscribe(async (params: any) => {
  if (params.id !== undefined && params.id !== null) {
    this.user = await this.userService.get<any>({
      url: `http://localhost:3000/user/${params.id}`,
      params: {
      }
    });
    this.model = this.user;
    this.getImage('http://localhost:3000/userImage/' + this.model.id).subscribe(x => this.url = x)
  } else {
    this.model = {}
  }
});

```

---

### ⭐ Explicação simples e leiga

Esse código está **escutando** (observando) os parâmetros que vêm na URL.

Exemplo:

```
http://meusite.com/editar?id=3

```

O `id=3` é um **query param**.

O objetivo desse código é:

1. Pegar o **ID** que veio pela URL
2. Buscar no backend os dados do usuário com esse ID
3. Atualizar a tela com esses dados
4. Buscar também a imagem do usuário
5. Caso não venha ID → significa que é uma criação de usuário, não edição

---

# 🧩 Explicação parte por parte

## **1. Escuta mudanças nos parâmetros da URL**

```tsx
this.route.queryParams.subscribe(async (params: any) => {

```

Isso quer dizer:

> “Toda vez que mudar algum parâmetro na URL (como ?id=5), execute esse código aqui.”
> 

---

## **2. Verifica se existe o parâmetro `id`**

```tsx
if (params.id !== undefined && params.id !== null) {

```

Tradução:

> “Se a URL tiver um id válido…”
> 

Isso significa que você está **editando um usuário existente**, não criando um novo.

---

## **3. Busca o usuário no backend pelo ID**

```tsx
this.user = await this.userService.get<any>({
  url: `http://localhost:3000/user/${params.id}`,
  params: {}
});

```

Aqui ele faz uma requisição HTTP:

- Vai no endereço `/user/{id}`
- Busca o usuário
- Salva na variável `this.user`

---

## **4. Atualiza o modelo do formulário**

```tsx
this.model = this.user;

```

Isso provavelmente alimenta:

- inputs (nome, e-mail, etc.)
- campos da tela do formulário

Ou seja:

> O formulário é preenchido com os dados do usuário.
> 

---

## **5. Busca a imagem do usuário**

```tsx
this.getImage('http://localhost:3000/userImage/' + this.model.id)
  .subscribe(x => this.url = x)

```

Aqui ele pega a imagem do usuário com base no ID:

- Faz a requisição para `/userImage/{id}`
- Quando a imagem chega, ela é atribuída a `this.url`
- Assim a interface consegue mostrar a foto na tela

---

## **6. Caso não tenha ID na URL**

```tsx
} else {
  this.model = {}
}

```

Significa que a pessoa está acessando a tela **para criar um novo usuário**, então o formulário deve começar vazio.

---

# 📝 Resumo bem simples

- O código observa a URL.
- Se tiver **id**, pega o usuário no backend e preenche a tela.
- Também pega a **imagem** do usuário.
- Se **não tiver id**, prepara o formulário vazio.

---


### CÓDIGO 2

🏆

```tsx
public getImage(url: string): Observable<SafeResourceUrl> {
    return this.http.get(url, { responseType: 'blob' }).pipe(
      map(
        x => {
          const urlToBlob = window.URL.createObjectURL(x)
          return this.domSanitizer.bypassSecurityTrustResourceUrl(urlToBlob)
        }
      ),
    )

  }
```


### EXPLICAÇÃO DO CÓDIGO

🏆

```tsx
public getImage(url: string): Observable<SafeResourceUrl> {
  return this.http.get(url, { responseType: 'blob' }).pipe(
    map(
      x => {
        const urlToBlob = window.URL.createObjectURL(x)
        return this.domSanitizer.bypassSecurityTrustResourceUrl(urlToBlob)
      }
    ),
  )
}

```

---

## ⭐ Explicação leiga (bem fácil de entender)

Esse método **busca uma imagem no servidor** e transforma essa imagem em um formato que o Angular permite mostrar na tela **com segurança**.

Ele faz 3 coisas principais:

1️⃣ **Baixa a imagem do backend como um arquivo (blob)**

2️⃣ **Converte esse arquivo em uma URL temporária para o navegador conseguir exibir**

3️⃣ **Pede ao Angular para confiar nessa URL**, para não bloquear por segurança

Pronto. É isso 😊

Agora vamos parte por parte.

---

## 🧩 Explicação detalhada, linha por linha

## **1. A função recebe a URL da imagem**

```tsx
public getImage(url: string): Observable<SafeResourceUrl> {

```

Isso significa:

> “Me dê o endereço da imagem e eu devolvo algo que pode ser exibido com segurança no Angular.”
> 

---

## **2. Faz um GET esperando um arquivo (blob)**

```tsx
return this.http.get(url, { responseType: 'blob' })

```

Aqui ele está dizendo:

> “Servidor, me envie essa imagem como arquivo.”
> 

`blob` = arquivo binário (a imagem crua, sem formato de texto)

Sem isso, a imagem viria como texto quebrado e seria impossível exibir.

---

## **3. Usa pipe + map para transformar o arquivo**

```tsx
.pipe(
  map(x => {

```

Esse `x` é o **arquivo da imagem** que veio do servidor.

Agora vamos transformá-lo em algo que o navegador entenda.

---

## **4. Cria uma URL temporária para mostrar a imagem**

```tsx
const urlToBlob = window.URL.createObjectURL(x)

```

Explicação simples:

> “Pegue esse arquivo e transforme em uma URL provisória para poder mostrar na tela.”
> 

Exemplo:

Pode virar algo tipo:

```
blob:https://minhaapp.com/ajhd8213-9812h9...

```

---

## **5. Autoriza o Angular a confiar nessa URL**

```tsx
return this.domSanitizer.bypassSecurityTrustResourceUrl(urlToBlob)

```

Como o Angular é muito rígido com segurança, ele **não permite exibir URLs desconhecidas**.

Então você diz:

> “Angular, relaxa. Essa URL é segura. Pode mostrar.”
> 

Esse método devolve um **SafeResourceUrl**, que o Angular aceita.

---

## 🎯 Em resumo, como se fosse uma história

Imagine que:

- Você pede ao servidor uma foto → ele te entrega o arquivo bruto
- Você transforma esse arquivo em um link temporário
- Você pede permissão ao Angular para usar esse link
- O Angular libera
- A imagem aparece na tela

---


### DÚVIDAS

### É OBRIGATÓRIO COLOCAR O BLOB ENTRE “”? E NÃO PODERIA SER OUTRO NOME DIFERENTE DO BLOB?

## ✅ **1. É obrigatório colocar entre aspas `'blob'` no `responseType`?**

Sim — **é obrigatório usar aspas**.

Quando você escreve:

```tsx
responseType: 'blob'

```

O valor `'blob'` é uma **string**, e o Angular espera exatamente essa string.

Se você escrevesse sem aspas:

```tsx
responseType: blob   // ❌ ERRADO

```

Isso daria erro porque `blob` seria interpretado como uma variável (que não existe).

Então:

✔️ `'blob'` → CORRETO

❌ `blob` → INCORRETO

**não, não pode ser outro nome no lugar de `'blob'`**.

Vou explicar bem simples 👇

---

## ✅ **Por que não pode ser outro nome?**

Porque **`responseType` só aceita quatro valores específicos**, definidos pelo Angular:

```tsx
'json'
'text'
'blob'
'arraybuffer'

```

Ou seja, **não é você que escolhe o nome**.

O Angular **só entende esses quatro valores**.

---

# ✔️ O que significa cada um (bem simples):

### **'json'**

👉 Significa que o backend vai devolver **dados JSON**

(exemplo: um objeto, uma lista, etc.)

### **'text'**

👉 Significa que vai devolver **texto puro**

### **'arraybuffer'**

👉 Mais usado para **arquivos binários mais técnicos** (ex: PDFs, áudio, streams)

### **'blob'**

👉 Arquivos “reais” como:

- imagens
- pdf
- vídeos
- arquivos enviados para download

Esse é o seu caso.

---

# 📌 Então, respondendo claramente:

### ❌ Não pode ser outro nome

### ✔️ Tem que ser exatamente `'blob'`

Se você colocar qualquer outra coisa como:

```tsx
responseType: 'arquivo'
responseType: 'imagem'
responseType: 'file'

```

Isso **não existe** no Angular → vai dar erro.

---

# 🧠 Por que `'blob'`?

Porque **o navegador** usa o tipo Blob para representar arquivos.

O Angular **só repassa isso**.

Por isso o nome não é escolhido por você — é o nome oficial do tipo.

---

### O QUE É O SafeResourceUrl?

🏆 O `SafeResourceUrl` é um **tipo especial do Angular**.

Ele serve para indicar pro Angular:

> “Esse conteúdo que estou passando é uma URL segura, pode confiar.”
> 

### Por quê?

Porque o Angular é bem rígido com segurança e **ele NÃO deixa você colocar URLs dinâmicas diretamente**, por medo de ataques.

Quando você usa o `DomSanitizer`, ele devolve exatamente isso:

```tsx
SafeResourceUrl

```

Que é um tipo seguro para armazenar URLs que vão ser usadas em:

- `img src=""`
- `iframe src=""`
- vídeos
- arquivos
- blobs (como no seu caso)

---

# 🧠 **3. O `SafeResourceUrl` é do Angular?**

SIM.

Ele é parte do Angular — mais especificamente do pacote:

```
@angular/platform-browser

```

É o Angular dizendo:

> “Essa URL pode ser usada no DOM sem risco.”
> 

Você não precisa criar esse tipo. Ele já vem pronto.


---

### CÓDIGO

```tsx
onSelectNewFile(event: any): void {
    const target = event.target as HTMLInputElement
    this.fileSelected = (target.files as FileList)[0];
    this.url = this.domSanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(this.fileSelected)) as string;
  }

```

🏆

### EXPLICAÇÃO DO CÓDIGO

```tsx
onSelectNewFile(event: any): void {
  const target = event.target as HTMLInputElement
  this.fileSelected = (target.files as FileList)[0];
  this.url = this.domSanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(this.fileSelected)) as string;
}

```

---

## ⭐ Explicação leiga (bem fácil)

Esse método é chamado quando o usuário **seleciona um arquivo** (normalmente uma imagem) no `<input type="file">`.

Ele faz 3 coisas:

1. **Pega o arquivo escolhido pelo usuário**
2. **Cria uma URL temporária para exibir a imagem na tela**
3. **Diz para o Angular confiar nessa URL**, para não bloquear a visualização

---

## 🧩 Explicação linha por linha

## **1. Pega o campo que disparou o evento**

```tsx
const target = event.target as HTMLInputElement

```

Explicação simples:

> “Pegue o elemento HTML que gerou o evento (o input de arquivo).”
> 

O `as HTMLInputElement` é só para o TypeScript entender que isso é um `<input />`.

---

## **2. Pega o arquivo que o usuário selecionou**

```tsx
this.fileSelected = (target.files as FileList)[0];

```

Explicação leiga:

- `target.files` é uma lista de arquivos
- `[0]` pega o primeiro arquivo (o único selecionado)
- Ele guarda esse arquivo na variável `fileSelected`

Ou seja:

> “Guarde a imagem que o usuário escolheu.”
> 

---

## **3. Cria uma URL temporária para visualizar a imagem**

```tsx
window.URL.createObjectURL(this.fileSelected)

```

Isso transforma o arquivo em algo assim:

```
blob:https://meusite.com/ajhdy712-9123s9...

```

Explicação simples:

> “Crie um link temporário para que o navegador possa mostrar a imagem antes mesmo de enviar para o servidor.”
> 

---

## **4. Pede ao Angular para confiar nessa URL**

```tsx
this.domSanitizer.bypassSecurityTrustUrl(...)

```

O Angular tem um sistema de segurança que **bloqueia URLs desconhecidas**.

Então você está dizendo:

> “Angular, essa URL é segura. Pode mostrar na tela.”
> 

Sem isso, a imagem não apareceria.

---

## **5. Guarda essa URL em `this.url`**

```tsx
this.url = ... as string;

```

Essa `this.url` provavelmente é usada no HTML assim:

```html
<img [src]="url">

```

Ou seja:

> “Mostre a imagem que o usuário acabou de selecionar.”
> 

---

# 🎯 Em resumo bem fácil:

- O usuário escolhe um arquivo.
- Você pega esse arquivo.
- Transforma em uma URL temporária.
- Pede para o Angular confiar nela.
- Mostra a imagem na tela.

É exatamente o efeito de **preview de imagem** antes de fazer upload.

---


### CÓDIGO

```tsx
  async onSubmit(fileinput: FileList | null): Promise<void> {
    // atenção o parâmetro precisa ter o null por conta do HTML

    let fileInput = fileinput![0] // o fileinput é parâmetro do onSubmit e o fileInput é atributo do componente
    let formData = new FormData();
    formData.append('first_name', this.model.first_name);
    formData.append('last_name', this.model.last_name);
    formData.append('email', this.model.email);
    formData.append('gender', this.model.gender);
    formData.append('file', fileInput);
```

### EXPLICAÇÃO DO CÓDIGO

🏆

```tsx
async onSubmit(fileinput: FileList | null): Promise<void> {
  // atenção o parâmetro precisa ter o null por conta do HTML

  let fileInput = fileinput![0] // o fileinput é parâmetro do onSubmit e o fileInput é atributo do componente
  let formData = new FormData();
  formData.append('first_name', this.model.first_name);
  formData.append('last_name', this.model.last_name);
  formData.append('email', this.model.email);
  formData.append('gender', this.model.gender);
  formData.append('file', fileInput);

```

---

## ⭐ Explicação super simples e leiga

Esse código:

1. **Recebe o arquivo** que o usuário escolheu
2. **Cria um FormData**, que é o formato correto para enviar arquivos
3. **Coloca todos os campos do formulário dentro do FormData**
4. **Coloca a imagem dentro do FormData**
5. Depois esse FormData será enviado para o backend via HTTP (PUT ou POST)

Ou seja:

> É o processo de montar o pacote completo com os dados + a imagem para mandar para o servidor.
> 

---

## 🧩 Explicando parte por parte

## **1. Método recebe o arquivo**

```tsx
async onSubmit(fileinput: FileList | null): Promise<void> {

```

O parâmetro é `FileList | null`

→ Isso significa:

- Pode vir uma lista de arquivos
- Ou pode vir `null` se o usuário não selecionou nada

Isso é necessário por causa do HTML, que pode enviar `null`.

---

## **2. Pega o primeiro arquivo da lista**

```tsx
let fileInput = fileinput![0]

```

Explicação leiga:

- `fileinput` é a **lista** de arquivos do HTML
- `[0]` pega o **primeiro** arquivo
- O `!` significa para o TypeScript:
    
    > “Confia em mim, isso não é nulo.”
    > 

Então:

> “Guarde o arquivo selecionado pelo usuário.”
> 

---

## **3. Cria um FormData**

```tsx
let formData = new FormData();

```

### Explicação simples:

O **FormData** é um "pacote" especial que permite enviar:

- texto
- números
- arquivos (como imagens)

Tudo junto na mesma requisição.

Ele é usado quando você precisa enviar **upload de arquivos**.

---

## **4. Adiciona os dados textuais no FormData**

```tsx
formData.append('first_name', this.model.first_name);
formData.append('last_name', this.model.last_name);
formData.append('email', this.model.email);
formData.append('gender', this.model.gender);

```

Isso significa:

> “Coloque cada campo do formulário dentro do FormData.”
> 

O backend vai receber esses valores como se fosse um formulário HTML.

---

## **5. Adiciona o arquivo dentro do FormData**

```tsx
formData.append('file', fileInput);

```

Aqui você coloca o arquivo junto com o resto dos dados.

Esse `'file'` deve bater com aquilo que o **multer** espera no backend:

```jsx
upload.single('file')

```

Ou seja:

> O Angular monta um pacote com as informações + imagem para enviar ao servidor.
> 

---

## 🎯 Resumão bem fácil:

- Pega a imagem
- Pega os dados do usuário
- Cria um “pacote especial” (FormData)
- Coloca tudo dentro
- Depois esse pacote vai ser enviado para o backend

É assim que se faz upload + dados ao mesmo tempo em Angular.

