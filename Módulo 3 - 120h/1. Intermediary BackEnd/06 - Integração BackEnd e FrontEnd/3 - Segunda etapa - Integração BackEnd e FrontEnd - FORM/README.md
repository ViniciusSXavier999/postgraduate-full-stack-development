# 3 → SEGUNDA ETAPA: INTEGRAÇÃO BACK-END E FRONT-END

🏆 Vamos continuar com a integração, mas dessa vez voltado para como os dados vão chegar na nossa tela, vamos partir para o form 

🏆 Precisamos de um form que vai ser a entrada de dados para o BackEnd e de uma list que vai mostrar esses dados na tela.

🏆 No arquivo user-form.component.ts a gente tem todas as dependências para a formatação e interação do service, essa interação ela tem todos os atributos do nosso objeto e ela tem um construtor.

🏆 Esse construtor é o que mantém todas as rotas ativas que vão trazer a integração do backEnd


### CÓDIGO

```jsx
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormlyFieldConfig, FormlyFormOptions } from '@ngx-formly/core';
import { ActivatedRoute, Router } from "@angular/router";
import { UserService } from "../user.service";
import { HttpClient } from '@angular/common/http';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';

export const GENDERS = [
  { label: 'Homem', value: 'male' },
  { label: 'Mulher', value: 'feme' },
  { label: 'Outro', value: 'other' }
];
@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent {
  fileInput: File | null = null;
  fileSelected?: Blob;
  url: SafeResourceUrl | undefined;

  user: any = {};
  model: any = {};
  form = new FormGroup({});

  options: FormlyFormOptions = {};

  fields: FormlyFieldConfig[] = [
    {
      className: 'd-flex align-content-center justify-content-center',
      fieldGroupClassName: 'row',
      fieldGroup: [
        {
          key: 'first_name',
          type: 'input',
          props: {
            label: 'Nome',
            placeholder: 'Primeiro Nome',
            required: true,
          },
        },
        {
          key: 'last_name',
          type: 'input',
          props: {
            label: 'Sobrenome',
            placeholder: 'Nome da Família',
            required: true,
          },
        },
        {
          key: 'email',
          type: 'input',
          props: {
            label: 'Email',
            placeholder: 'Email',
            required: true,
          },
        },
        {
          key: 'gender',
          type: 'select',
          props: {
            label: 'Genero',
            placeholder: 'Genero',
            required: true,
            options: GENDERS,
          },
        },
      ]
    }
  ];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private http: HttpClient,
    private domSanitizer: DomSanitizer
  ) {

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

  onSelectNewFile(event: any): void {
    const target = event.target as HTMLInputElement
    this.fileSelected = (target.files as FileList)[0];
    this.url = this.domSanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(this.fileSelected)) as string;

    // atenção no método bypassSecurityTrustHtml estamos usando URL
  }

  async onSubmit(fileinput: FileList | null): Promise<void> {
    // atenção o parâmetro precisa ter o null por conta do HTML

    let fileInput = fileinput![0] // o fileinput é parâmetro do onSubmit e o fileInput é atributo do componente
    let formData = new FormData();
    formData.append('first_name', this.model.first_name);
    formData.append('last_name', this.model.last_name);
    formData.append('email', this.model.email);
    formData.append('gender', this.model.gender);
    formData.append('file', fileInput);

    if (this.form.valid) {
      if (this.model?.id !== undefined && this.model?.id !== null) {
        this.user = await this.userService.put<any>({
          url: `http://localhost:3000/updateUser/${this.model?.id}`,
          params: {
          },
          data: formData
        });
      } else {
        delete this.model?.id;
        await this.userService.post<any>({
          url: `http://localhost:3000/addUser`,
          params: {
          },
          data: formData
        });
      }
    }
    await this.router.navigate(['/users']);
  }
}

```

### EXPLICAÇÃO DO CÓDIGO LINHA POR LINHA

```tsx
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormlyFieldConfig, FormlyFormOptions } from '@ngx-formly/core';
import { ActivatedRoute, Router } from "@angular/router";
import { UserService } from "../user.service";
import { HttpClient } from '@angular/common/http';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { map, Observable } from 'rxjs';

```

Explicação linha a linha:

- `import { Component } from '@angular/core';` — traz a função `Component` do Angular, usada para marcar a classe como um componente (tela/parte da UI).
- `import { FormGroup } from '@angular/forms';` — traz `FormGroup`, que representa um formulário no Angular (controle dos campos).
- `import { FormlyFieldConfig, FormlyFormOptions } from '@ngx-formly/core';` — traz tipos do Formly (biblioteca que cria formulários dinamicamente): `FormlyFieldConfig` descreve um campo; `FormlyFormOptions` armazena opções extras.
- `import { ActivatedRoute, Router } from "@angular/router";` — `ActivatedRoute` lê parâmetros da URL (ex.: `?id=1`); `Router` permite navegar entre páginas.
- `import { UserService } from "../user.service";` — importa o serviço que faz requisições relacionadas a usuários (get, post, put…).
- `import { HttpClient } from '@angular/common/http';` — import do serviço HTTP do Angular (usar para buscar blobs/imagens).
- `import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';` — `DomSanitizer` ajuda a tornar URLs seguras para o Angular exibir; `SafeResourceUrl` é o tipo seguro retornado.
- `import { map, Observable } from 'rxjs';` — `Observable` é tipo que representa dados assíncronos; `map` é um operador para transformar valores em um `Observable`.

---

```tsx
export const GENDERS = [
  { label: 'Homem', value: 'male' },
  { label: 'Mulher', value: 'feme' },
  { label: 'Outro', value: 'other' }
];

```

Explicação:

- `export const GENDERS = [...]` — define e exporta uma constante chamada `GENDERS`.
- Cada item `{ label, value }` é uma opção pronta para um `<select>`: `label` é o texto mostrado, `value` é o valor real enviado ao servidor.

---

```tsx
@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent {

```

Explicação:

- `@Component({...})` — diz ao Angular que a classe abaixo é um componente e aponta o HTML (`templateUrl`) e CSS (`styleUrls`) do componente.
- `selector: 'app-user-form'` — nome usado no HTML para inserir esse componente (ex.: `<app-user-form></app-user-form>`).
- `export class UserFormComponent {` — início da classe que contém toda a lógica da tela.

---

```tsx
  fileInput: File | null = null;
  fileSelected?: Blob;
  url: SafeResourceUrl | undefined;

  user: any = {};
  model: any = {};
  form = new FormGroup({});

  options: FormlyFormOptions = {};

```

Explicação:

- `fileInput: File | null = null;` — propriedade que pode guardar um `File` (arquivo) ou `null`. Inicialmente `null`.
- `fileSelected?: Blob;` — armazena o arquivo selecionado como `Blob` (binário). `?` significa opcional.
- `url: SafeResourceUrl | undefined;` — URL segura (tipada) para exibir imagem; pode ser `undefined` inicialmente.
- `user: any = {};` — objeto para guardar dados do usuário vindos da API.
- `model: any = {};` — modelo que o Formly usa para preencher os campos do formulário.
- `form = new FormGroup({});` — cria o container do formulário (inicial vazio).
- `options: FormlyFormOptions = {};` — opções do Formly (inicialmente vazio).

---

```tsx
  fields: FormlyFieldConfig[] = [
    {
      className: 'd-flex align-content-center justify-content-center',
      fieldGroupClassName: 'row',
      fieldGroup: [
        {
          key: 'first_name',
          type: 'input',
          props: {
            label: 'Nome',
            placeholder: 'Primeiro Nome',
            required: true,
          },
        },
        {
          key: 'last_name',
          type: 'input',
          props: {
            label: 'Sobrenome',
            placeholder: 'Nome da Família',
            required: true,
          },
        },
        {
          key: 'email',
          type: 'input',
          props: {
            label: 'Email',
            placeholder: 'Email',
            required: true,
          },
        },
        {
          key: 'gender',
          type: 'select',
          props: {
            label: 'Genero',
            placeholder: 'Genero',
            required: true,
            options: GENDERS,
          },
        },
      ]
    }
  ];

```

Explicação:

- `fields: FormlyFieldConfig[] = [...]` — array que descreve os campos do formulário (Formly).
- O objeto dentro define um `fieldGroup` (grupo de campos) com `className` e `fieldGroupClassName` para estilização/layout.
- Cada item em `fieldGroup` tem:
    - `key` — nome do campo no `model` (ex.: `model.first_name`).
    - `type` — tipo de campo que Formly vai renderizar (`input`, `select`).
    - `props` — propriedades visuais e regras (label, placeholder, required).
- No campo `gender`, `options: GENDERS` usa a lista que definimos antes.

---

```tsx
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private http: HttpClient,
    private domSanitizer: DomSanitizer
  ) {

```

Explicação do construtor (linha a linha):

- `constructor(...) {` — método executado quando o componente é criado.
- `private route: ActivatedRoute` — pede ao Angular para injetar `ActivatedRoute` e guarda na propriedade `route`. Serve para ler os parâmetros/queries da URL.
- `private router: Router` — injeção de `Router` para navegar entre rotas.
- `private userService: UserService` — injeção do serviço que faz chamadas relacionadas a usuários (get/post/put).
- `private http: HttpClient` — injeção do `HttpClient` para requisições HTTP (usado em `getImage`).
- `private domSanitizer: DomSanitizer` — injeção do `DomSanitizer` para tornar URLs seguras.

---

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

Explicação detalhada (linha a linha — foco em métodos e fluxo):

- `this.route.queryParams.subscribe(async (params: any) => {`
    - `this.route.queryParams` é um `Observable` que emite quando os parâmetros da URL mudam.
    - `.subscribe(...)` = “me avise quando houver parâmetros” e execute a função passada.
    - A função é `async` porque dentro dela usamos `await`.
- `if (params.id !== undefined && params.id !== null) {`
    - Verifica se a URL tem `?id=algumaCoisa`. Se tem, significa que estamos **editando** um usuário existente.
- `this.user = await this.userService.get<any>({ url:` [http://localhost:3000/user/${params.id}`](http://localhost:3000/user/$%7Bparams.id%7D%60), params: { } });`
    - Chama `userService.get` (método assíncrono que faz requisição) para pegar os dados do usuário com aquele `id`.
    - `await` espera a resposta antes de continuar.
    - O resultado é guardado em `this.user`.
- `this.model = this.user;`
    - Copia os dados para `model`, que é o objeto que o formulário irá usar para preencher os campos.
- `this.getImage('http://localhost:3000/userImage/' + this.model.id).subscribe(x => this.url = x)`
    - Chama `getImage` para buscar a imagem do usuário (retorna `Observable<SafeResourceUrl>`).
    - `.subscribe(x => this.url = x)` = quando a imagem estiver pronta, guarda a URL segura em `this.url` (usada no template para mostrar a imagem).
- `} else { this.model = {} }`
    - Se não há `id` na URL, então é criação de novo usuário; `model` fica vazio.
- `});` fecha o subscribe; `}` fecha o construtor.

---

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

Explicação do método `getImage` linha a linha (muito detalhado, pois você pediu foco em métodos):

- `public getImage(url: string): Observable<SafeResourceUrl> {`
    - Declara método público `getImage`, que recebe uma `url` (string) e retorna um `Observable` que, quando emitido, entregará um `SafeResourceUrl`.
- `return this.http.get(url, { responseType: 'blob' }).pipe(`
    - `this.http.get(url, { responseType: 'blob' })` faz uma requisição HTTP GET pedindo o conteúdo como `blob` (dados binários da imagem).
    - Isso retorna um `Observable<Blob>`.
    - `.pipe(...)` permite aplicar transformações nesse `Observable`.
- `map( x => {`
    - Usa o operador `map` para transformar o `Blob` (`x`) em uma URL segura.
- `const urlToBlob = window.URL.createObjectURL(x)`
    - `window.URL.createObjectURL(x)` cria uma URL temporária local que aponta para o `Blob` recebido. Ex.: `blob:http://.../abc-123`.
    - Essa URL permite que a imagem seja exibida no `<img src="...">` sem precisar salvar em servidor público.
- `return this.domSanitizer.bypassSecurityTrustResourceUrl(urlToBlob)`
    - `DomSanitizer.bypassSecurityTrustResourceUrl(...)` marca a URL como segura para o Angular (por padrão o Angular pode bloquear URLs dinâmicas por segurança).
    - Retorna um `SafeResourceUrl` que é seguro de usar no template.
- `})` fecha o `map`.
- `)` fecha o `pipe`.
- `}` fecha o método.

Resumindo `getImage`: baixa a imagem como blob, cria uma URL local temporária e a torna segura para exibição.

---

```tsx
  onSelectNewFile(event: any): void {
    const target = event.target as HTMLInputElement
    this.fileSelected = (target.files as FileList)[0];
    this.url = this.domSanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(this.fileSelected)) as string;

    // atenção no método bypassSecurityTrustHtml estamos usando URL
  }

```

Explicação linha a linha:

- `onSelectNewFile(event: any): void {` — método chamado quando o usuário escolhe um arquivo no `<input type="file">`. Recebe o evento do navegador.
- `const target = event.target as HTMLInputElement` — pega o elemento HTML que disparou o evento e diz ao TypeScript que ele é um `HTMLInputElement` (para acessar `.files`).
- `this.fileSelected = (target.files as FileList)[0];` — pega o primeiro arquivo selecionado (`files[0]`) e guarda em `this.fileSelected`.
- `this.url = this.domSanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(this.fileSelected)) as string;`
    - `window.URL.createObjectURL(this.fileSelected)` cria uma URL temporária para o arquivo local (preview).
    - `this.domSanitizer.bypassSecurityTrustUrl(...)` marca essa URL como segura para o Angular.
    - O resultado é guardado em `this.url` para exibir preview no template.
- Comentário alerta: apenas lembrando que estamos usando `bypassSecurityTrustUrl` — método que diz ao Angular “confio nessa URL”.

---

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

    if (this.form.valid) {
      if (this.model?.id !== undefined && this.model?.id !== null) {
        this.user = await this.userService.put<any>({
          url: `http://localhost:3000/updateUser/${this.model?.id}`,
          params: {
          },
          data: formData
        });
      } else {
        delete this.model?.id;
        await this.userService.post<any>({
          url: `http://localhost:3000/addUser`,
          params: {
          },
          data: formData
        });
      }
    }
    await this.router.navigate(['/users']);
  }
}

```

Explicação do `onSubmit` linha a linha (muito detalhado — esse é o trecho mais importante):

- `async onSubmit(fileinput: FileList | null): Promise<void> {`
    - Declara método `onSubmit` assíncrono (usa `async/await`).
    - Recebe `fileinput` que é um `FileList` ou `null` (por causa do template/HTML).
    - Retorna `Promise<void>` (não devolve valor, apenas finaliza).
- `let fileInput = fileinput![0]`
    - `fileinput!` usa o operador de non-null assertion (diz ao TypeScript “confie, não é nulo aqui”).
    - Pega o primeiro arquivo (`[0]`) e guarda em `fileInput`.
    - **Observação:** se `fileinput` for realmente `null`, isso dará erro em runtime — o `!` significa que o autor assumiu que o HTML passará sempre um FileList quando esta função for chamada.
- `let formData = new FormData();`
    - Cria um `FormData`, que serve para enviar dados de formulário (texto + arquivos) via HTTP como `multipart/form-data`.
- `formData.append('first_name', this.model.first_name);`
    - Adiciona o campo `first_name` ao `FormData` com o valor do modelo.
- `formData.append('last_name', this.model.last_name);`
    - Adiciona `last_name`.
- `formData.append('email', this.model.email);`
    - Adiciona `email`.
- `formData.append('gender', this.model.gender);`
    - Adiciona `gender`.
- `formData.append('file', fileInput);`
    - Adiciona o arquivo (imagem) ao `FormData` com a chave `file`.
- `if (this.form.valid) {`
    - Verifica se o formulário está válido (regras `required` etc.). Se não estiver, não faz nada (não envia).
- `if (this.model?.id !== undefined && this.model?.id !== null) {`
    - Verifica se `model.id` existe: se existe, estamos **atualizando** um usuário já existente.
- `this.user = await this.userService.put<any>({ url:` [http://localhost:3000/updateUser/${this.model?.id}`](http://localhost:3000/updateUser/$%7Bthis.model?.id%7D%60), params: {}, data: formData });`
    - Chama `userService.put` para enviar os dados ao endpoint de atualização. Usa `await` para esperar a resposta e guarda o resultado em `this.user`.
- `} else { delete this.model?.id; await this.userService.post<any>({ url:` [http://localhost:3000/addUser`](http://localhost:3000/addUser%60), params: {}, data: formData }); }`
    - Se não há `id`, é criação: remove qualquer `model.id` (caso exista por engano) e chama `userService.post` para criar novo usuário, enviando `formData`.
- `}` fecha `if (this.form.valid)`.
- `await this.router.navigate(['/users']);`
    - Após o envio (criação ou atualização), navega para a rota `/users` (provavelmente tela de lista).
- `}` fecha `onSubmit`.
- `}` fecha a classe `UserFormComponent`.

---

## 🟢 **Resumo final (muito simples, como você pediu)**

- Este componente monta e controla a **tela de cadastro/edição de usuário**.
- Os **métodos principais**:
    - `constructor` – lê `?id=` na URL; se existir, busca dados do usuário e a imagem; preenche o formulário.
    - `getImage(url)` – baixa a imagem como blob, cria uma URL temporária e a torna segura para exibir.
    - `onSelectNewFile(event)` – pega o arquivo escolhido pelo usuário e gera preview.
    - `onSubmit(fileinput)` – monta `FormData` (texto + imagem), verifica se está válido, decide entre criar ou atualizar via `userService` e redireciona para `/users`.

### Papel desta classe e por que ela é necessária

- **Papel:** ser o controlador da página de formulário de usuário — ele conecta a interface (HTML) com a lógica (chamadas à API) e lida com o estado do formulário, validação, upload de imagem e navegação.
- **Por que é necessária:** sem essa classe, a tela não teria lógica para:
    - preencher campos ao editar,
    - validar e enviar os dados,
    - tratar e mostrar preview da imagem,
    - redirecionar ao finalizar.
        
        Em outras palavras, é ela quem torna a página **interativa e funcional**.
        

---


## DÚVIDAS IMPORTANTES

### POR QUE UMA CLASSE USA SUBSCRIBE E A OUTRA NÃO?

🏆

# ✅ **RESUMO RÁPIDO (para fixar antes da explicação completa)**

| Classe | Como busca dados | Tipo retornado | Por isso usa… |
| --- | --- | --- | --- |
| **UserFormComponent** | `HttpClient` (Angular) | **Observable** | PRECISA usar `.subscribe()` |
| **CourseService** | `axios` | **Promise** | NÃO usa subscribe. Usa `await` |

👉 Essa é exatamente a diferença:

**Observable → subscribe**

**Promise → await**

---

Agora vamos detalhar bonitinho.

---

# 🟦 **1. Por que o `UserFormComponent` usa `.subscribe()`?**

Porque ele usa este código:

```tsx
this.http.get(url, { responseType: 'blob' })

```

E o **HttpClient do Angular SEMPRE retorna um Observable**, nunca uma Promise.

Para consumir um Observable, você é obrigado a usar:

```
.subscribe(...)

```

Exemplo real do componente:

```tsx
this.getImage('http://localhost:3000/userImage/' + this.model.id)
  .subscribe(x => this.url = x)

```

🔹 `.getImage()` retorna **Observable**

🔹 Para acessar o valor, você usa `.subscribe(...)`

---

# 🟩 **2. Por que o `CourseService` NÃO usa `.subscribe()`?**

Porque ele usa **axios**:

```tsx
this.axiosClient.request<T>({...})

```

O axios **NÃO usa Observable**.

Ele usa **Promises**.

E Promises são consumidas com:

- `await`
    
    ou
    
- `.then()`

Nunca com `.subscribe()`.

Exemplo:

```tsx
let axiosResponse = await this.axiosClient.request<T>({...})
return axiosResponse.data;

```

Aqui você vê:

✔ `async`

✔ `await`

❌ NADA de subscribe, porque Promises não usam subscribe.

---

# 🔥 Diferença resumida entre Observable e Promise

## 🔵 Observable (Angular HttpClient)

- pode emitir vários valores ao longo do tempo
- você controla quando parar
- precisa de `.subscribe()`

## 🟠 Promise (axios)

- emite apenas **um único valor**
- resolve uma vez e pronto
- consumida com `await` / `.then()`

---

# 🏗️ Diferença estrutural entre as duas classes

| Classe | Função | Tecnologias usadas | Consequência |
| --- | --- | --- | --- |
| **UserFormComponent** | É um componente de tela | Angular HttpClient | precisa de `.subscribe()` |
| **CourseService** | É um serviço de API | axios + promises | usa `async/await`, sem `.subscribe()` |

---

# 📌 Conclusão final

A diferença não é porque “uma é componente e outra é service”.

A diferença é **APENAS** por causa da biblioteca usada para fazer requisições.

---

# ✔️ **POR QUE UMA USA SUBSCRIBE E A OUTRA NÃO? (resposta direta)**

👉 **Porque o componente usa HttpClient (Observable → precisa de subscribe)**

👉 **E o serviço usa Axios (Promise → não usa subscribe)**

---


### EXEMPLO COM TEACHER SERVICE E TEACHER FORM COMPONENT.TS

🏆

# ✅ **1. As duas classes consomem o backend?**

**Sim.**

Mas…

- **TeacherService** é quem **faz** a requisição.
- **TeacherFormComponent** apenas **usa** o serviço para pedir a requisição.

Então:

✔ **TeacherService → Consome o backend diretamente**

✔ **TeacherFormComponent → NÃO consome o backend sozinho, ele usa TeacherService para isso**

Ou seja:

### 🔥 O componente NÃO acessa a API.

### 🔥 Ele sempre pede ao serviço para fazer isso.

---

# 🟦 **2. O `TeacherFormComponent` consome o `TeacherService`?**

**SIM.**

Veja aqui:

```tsx
private teacherService: TeacherService

```

E depois ele usa assim:

```tsx
this.teacherService.get<any>(...)
this.teacherService.put<any>(...)
this.teacherService.post<any>(...)

```

✔ O componente depende do service

✔ O component chama o service

✔ O service nunca chama o component (e nunca deve)

Então:

### 🔹 O component → controla a tela

### 🔹 O service → controla a comunicação com o backend

Eles têm papéis diferentes.

---

# 🟩 **3. Diferença entre as duas classes (explicado em nível profissional e também para leigos)**

## **TeacherService (classe 1)**

### 📌 Para profissionais:

- É uma **classe de comunicação com a API**.
- Encapsula chamadas HTTP usando Axios.
- Fornece métodos genéricos (get, post, put, delete).
- Tem tratamento de erro centralizado (normalizeError).
- Retorna Promises usando async/await.
- NÃO sabe nada sobre HTML, tela, formulário ou navegação.

### 📌 Para leigos:

É como um “mensageiro” que vai até o servidor e traz ou envia informações.

O componente fala:

> “Ei, eu preciso dos dados do professor!”
> 

E o TeacherService responde:

> “Deixa comigo, vou buscar no servidor.”
> 

---

## **TeacherFormComponent (classe 2)**

### 📌 Para profissionais:

- É um componente Angular, responsável pela **interface**.
- Monta o formulário usando Formly.
- Recebe parâmetros da rota para saber se é edição ou criação.
- Envia o formulário ao TeacherService.
- Decide a navegação após sucesso.
- NÃO sabe como a requisição HTTP é feita.

### 📌 Para leigos:

É a **tela** onde o usuário digita nome, curso etc.

Quando o usuário clica "Salvar":

Ele não sabe falar com o servidor, então pede ajuda ao TeacherService.

---

# 🟧 **4. Fluxo completo (como uma conversa)**

Imagine assim:

### Usuário:

“Quero cadastrar um professor!”

### TeacherFormComponent (a tela):

“Ok! TeacherService, pega esses dados e envia para o backend!”

### TeacherService:

“Beleza, vou enviar pro servidor agora.”

→ Envia via Axios

→ Recebe a resposta

→ Devolve para o componente

### Componente:

“Servidor respondeu, vou redirecionar para a lista de professores.”

---

# 🟨 **5. Relação entre as classes (bem clara)**

✔️ O **TeacherFormComponent usa o TeacherService**

❌ O TeacherService **não usa o TeacherFormComponent**

❌ O TeacherService **não depende** do componente

✔️ O TeacherFormComponent **depende** do TeacherService

Isso chamamos de:

**Inversão de Dependência → Camada da UI depende da camada de serviço**

---

# 🟩 **6. Então… qual é a diferença entre elas?**

| TeacherService | TeacherFormComponent |
| --- | --- |
| Fala com o backend | Renderiza a tela |
| Usa Axios | Usa formulário (Formly) |
| É uma camada de serviço | É uma camada de interface |
| Não sabe nada sobre HTML | Não sabe nada sobre HTTP |
| retorna dados | envia dados ao serviço |
| Pode ser reaproveitado em vários componentes | É específico dessa tela |

---

# 🟢 **7. Em resumo (resposta final)**

### ✔️ Ambas consomem o backend

- TeacherService → diretamente
- TeacherFormComponent → indiretamente via TeacherService

### ✔️ O TeacherFormComponent consome o TeacherService

- Ele chama o service para buscar, atualizar ou criar professores

### ✔️ Por que cada uma é necessária?

- **TeacherService**: centraliza toda lógica de comunicação com a API.
- **TeacherFormComponent**: exibe a tela, controla o formulário e aciona o serviço.

👉 Se você colocasse tudo em um único arquivo, ficaria confuso, difícil de testar, difícil de reaproveitar e violaria as boas práticas do Angular.

---


### EU PODERIA USAR AXIOS EM AMBAS AS CLASSES?

🏆

# ✅ **1. As duas classes consomem o backend?**

**Sim.**

Mas…

- **TeacherService** é quem **faz** a requisição.
- **TeacherFormComponent** apenas **usa** o serviço para pedir a requisição.

Então:

✔ **TeacherService → Consome o backend diretamente**

✔ **TeacherFormComponent → NÃO consome o backend sozinho, ele usa TeacherService para isso**

Ou seja:

### 🔥 O componente NÃO acessa a API.

### 🔥 Ele sempre pede ao serviço para fazer isso.

---

# 🟦 **2. O `TeacherFormComponent` consome o `TeacherService`?**

**SIM.**

Veja aqui:

```tsx
private teacherService: TeacherService

```

E depois ele usa assim:

```tsx
this.teacherService.get<any>(...)
this.teacherService.put<any>(...)
this.teacherService.post<any>(...)

```

✔ O componente depende do service

✔ O component chama o service

✔ O service nunca chama o component (e nunca deve)

Então:

### 🔹 O component → controla a tela

### 🔹 O service → controla a comunicação com o backend

Eles têm papéis diferentes.

---

# 🟩 **3. Diferença entre as duas classes (explicado em nível profissional e também para leigos)**

## **TeacherService (classe 1)**

### 📌 Para profissionais:

- É uma **classe de comunicação com a API**.
- Encapsula chamadas HTTP usando Axios.
- Fornece métodos genéricos (get, post, put, delete).
- Tem tratamento de erro centralizado (normalizeError).
- Retorna Promises usando async/await.
- NÃO sabe nada sobre HTML, tela, formulário ou navegação.

### 📌 Para leigos:

É como um “mensageiro” que vai até o servidor e traz ou envia informações.

O componente fala:

> “Ei, eu preciso dos dados do professor!”
> 

E o TeacherService responde:

> “Deixa comigo, vou buscar no servidor.”
> 

---

## **TeacherFormComponent (classe 2)**

### 📌 Para profissionais:

- É um componente Angular, responsável pela **interface**.
- Monta o formulário usando Formly.
- Recebe parâmetros da rota para saber se é edição ou criação.
- Envia o formulário ao TeacherService.
- Decide a navegação após sucesso.
- NÃO sabe como a requisição HTTP é feita.

### 📌 Para leigos:

É a **tela** onde o usuário digita nome, curso etc.

Quando o usuário clica "Salvar":

Ele não sabe falar com o servidor, então pede ajuda ao TeacherService.

---

# 🟧 **4. Fluxo completo (como uma conversa)**

Imagine assim:

### Usuário:

“Quero cadastrar um professor!”

### TeacherFormComponent (a tela):

“Ok! TeacherService, pega esses dados e envia para o backend!”

### TeacherService:

“Beleza, vou enviar pro servidor agora.”

→ Envia via Axios

→ Recebe a resposta

→ Devolve para o componente

### Componente:

“Servidor respondeu, vou redirecionar para a lista de professores.”

---

# 🟨 **5. Relação entre as classes (bem clara)**

✔️ O **TeacherFormComponent usa o TeacherService**

❌ O TeacherService **não usa o TeacherFormComponent**

❌ O TeacherService **não depende** do componente

✔️ O TeacherFormComponent **depende** do TeacherService

Isso chamamos de:

**Inversão de Dependência → Camada da UI depende da camada de serviço**

---

# 🟩 **6. Então… qual é a diferença entre elas?**

| TeacherService | TeacherFormComponent |
| --- | --- |
| Fala com o backend | Renderiza a tela |
| Usa Axios | Usa formulário (Formly) |
| É uma camada de serviço | É uma camada de interface |
| Não sabe nada sobre HTML | Não sabe nada sobre HTTP |
| retorna dados | envia dados ao serviço |
| Pode ser reaproveitado em vários componentes | É específico dessa tela |

---

# 🟢 **7. Em resumo (resposta final)**

### ✔️ Ambas consomem o backend

- TeacherService → diretamente
- TeacherFormComponent → indiretamente via TeacherService

### ✔️ O TeacherFormComponent consome o TeacherService

- Ele chama o service para buscar, atualizar ou criar professores

### ✔️ Por que cada uma é necessária?

- **TeacherService**: centraliza toda lógica de comunicação com a API.
- **TeacherFormComponent**: exibe a tela, controla o formulário e aciona o serviço.

👉 Se você colocasse tudo em um único arquivo, ficaria confuso, difícil de testar, difícil de reaproveitar e violaria as boas práticas do Angular.

---


### NÃO É COMUM USAR HTTPCLIENT PARA CONSUMIR O BACKEND?

🏆 Sim! **É muito comum — e até o padrão do Angular — usar o `HttpClient` diretamente dentro do *service* para consumir o backend.**

Ou seja ⬇️

👉 *O mais comum é assim:*

```
Service -> usa HttpClient -> chama API
Component -> chama o Service -> recebe dados

```

Então sua frase está **corretíssima**:

> “não é comum utilizar httpclient no service para consumir o backend diretamente?”
> 

✅ **É comum sim. É o jeito padrão do Angular.**

---

# 🤔 Então por que seu código usa **Axios** e não `HttpClient`?

Provavelmente porque:

### ✔️ O desenvolvedor queria usar algo externo ao Angular

Alguns devs preferem Axios por motivos pessoais ou porque já usam em outros projetos.

### ✔️ Axios é mais flexível para interceptors / integração externa

Tem dev que acha mais simples configurar interceptors, instâncias diferentes, timeouts, etc.

### ✔️ Protótipo migrado de React ou Node

É muito comum importar Axios quando o projeto veio de React, Node ou outro ecossistema.

---

# 🆚 **HttpClient vs Axios dentro do Service**

## 🟦 HttpClient (método padrão Angular)

Vantagens:

- Interage com todo o sistema do Angular
- Tem interceptors do Angular (para token, erros, etc)
- Retorna **Observable** (boa integração com RxJS)
- Pode cancelar requisições automaticamente ao destruir o componente
- Não precisa instalar nada

Desvantagens:

- Alguns devs acham mais verboso

---

## 🟧 Axios (o que seu projeto usa agora)

Vantagens:

- Retorna **Promise**, que alguns devs preferem
- Configuração global mais simples
- Requisições geralmente mais curtas

Desvantagens:

- Foge do padrão Angular
- Não integra com interceptors do Angular
- Não cancela requisições ao destruir components
- Perde parte dos recursos do Angular

---

# ✔️ Então: *o mais comum é usar HttpClient no service*?

**SIM — este é o jeito recomendado pela equipe do Angular.**

Seu cenário atual é assim:

### TeacherService:

- usa Axios → **funciona, mas não é o padrão Angular**

### TeacherFormComponent:

- usa `ActivatedRoute.queryParams.subscribe` → **porque rota é Observable**, não por causa de Axios

---

