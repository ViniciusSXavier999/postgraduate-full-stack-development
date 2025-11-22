# 5 → QUARTA ETAPA: CONSTRUÇÃO DE APLICAÇÃO ANGULAR

🏆 O código vai estar no material de apoio.

---

🏆 Vamos iniciar populando a lista de MENU do nosso HTML principal.

```jsx
<!--Adicionar aqui para entrar na barra lateral-->
<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/users">
              <span data-feather="home"></span>
              Usuários
            </a>
            <a class="nav-link active" aria-current="page" href="/teachers">
              <span data-feather="home"></span>
              Professores
            </a>
            <a class="nav-link active" aria-current="page" href="/courses">
              <span data-feather="home"></span>
              Cursos
            </a>
            <a class="nav-link active" aria-current="page" href="/evaluations">
              <span data-feather="home"></span>
              Avaliações
            </a>
          </li>
        </ul>
      </div>
    </nav>
    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <router-outlet></router-outlet>
    </main>
  </div>
</div>
```


---

🏆 Quando a gente deseja ter um componente compartilhado, podemos criar um serviço usando o comando do angular:

```jsx
ng generate service
```

🏆 Exemplo de dados compartilhados: Quando na tabela de professores eu necessito do id do curso especifico, sendo assim eu vou criar um relacionamento que vai traduzir o id do curso para o nome do curso, para isso eu vou precisar de um serviço compartilhado que vai linkar os dois lados da informação e vai fornecer essa informação para nós na tela.



🏆 O back-end já tem essa estrutura pronta, a gente usa o sql para trazer os relacionamentos, mas no front-end precisamos de um tratamento no service.


### CÓDIGO QUE VAI PERMITIR TRANSFORMAR ESSES DADOS

```jsx
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Observable, of } from "rxjs";
import { CourseService } from "../pages/course/course.service";
import { UserService } from "../pages/user/user.service";

//Criar esses exports
export interface Params {
    [key: string]: any;
}

@Injectable({
    providedIn: 'root'
})
export class SharedService {

    users: Array<{ value: string, label: string }> = [];
    courses: Array<{ value: string, label: string }> = [];

    getUsers(): Observable<any[]> {
        return this.http
            .get("http://localhost:3000/getAllUsers")
            .pipe(
                map(x => {
                    Object.values(x).map((_user) => {
                        let u = { value: _user.id, label: _user.first_name }
                        this.users.push(u);
                    })
                    console.log(x);
                    console.log(this.users);
                    return this.users;
                })
            );
    }

    getCourses(): Observable<any[]> {
        return this.http
            .get("http://localhost:3000/getAllCourses")
            .pipe(
                map(x => {
                    Object.values(x).map((_course) => {
                        let c = { value: _course.id, label: _course.name }
                        this.courses.push(c);
                    })
                    console.log(x);
                    console.log(this.courses);
                    return this.courses;
                })
            );
    }

    constructor(
        private http: HttpClient
    ) {
    }
}
```


### EXPLICAÇÃO DO CÓDIGO LINHA POR LINHA

🏆

### ✅ **Explicação linha por linha do código**

---

```tsx
import { HttpClient } from "@angular/common/http";

```

**Importa o HttpClient**, que permite fazer requisições HTTP (GET, POST, PUT etc.) ao backend.

---

```tsx
import { Injectable } from "@angular/core";

```

Importa o **Injectable**, usado para dizer ao Angular que essa classe pode ser injetada em outros lugares.

---

```tsx
import { map, Observable, of } from "rxjs";

```

Importa funções da biblioteca RxJS:

- **map**: transforma o dado retornado do backend.
- **Observable**: tipo que representa um fluxo assíncrono.
- **of**: cria um observable manualmente (apesar de não ser usado no seu código).

---

```tsx
import { CourseService } from "../pages/course/course.service";
import { UserService } from "../pages/user/user.service";

```

Importaria serviços de curso e usuário (mas **não são usados** aqui). Provavelmente ficaram de outro exemplo.

---

```tsx
export interface Params {
    [key: string]: any;
}

```

Define uma **interface genérica**, onde qualquer chave (`string`) pode existir e aceitar qualquer valor (`any`).

---

```tsx
@Injectable({
    providedIn: 'root'
})

```

Diz ao Angular que esse serviço ficará disponível globalmente na aplicação inteira (**singleton global**).

---

```tsx
export class SharedService {

```

Declara a classe do serviço, chamada **SharedService**.

---

```tsx
    users: Array<{ value: string, label: string }> = [];
    courses: Array<{ value: string, label: string }> = [];

```

Cria arrays que serão preenchidos com:

```tsx
{ value: id, label: nome }

```

Esses arrays são usados para popular selects, dropdowns, etc.

---

```tsx
    getUsers(): Observable<any[]> {

```

Declara a função **getUsers**, que devolve um **Observable** contendo um array.

---

```tsx
        return this.http
            .get("http://localhost:3000/getAllUsers")

```

Faz uma requisição **GET** para o backend e traz todos os usuários.

---

```tsx
            .pipe(

```

Usa o `pipe` para transformar o resultado recebido.

---

```tsx
                map(x => {

```

Aplica o operador **map**, que transforma a resposta `x` antes de retornar.

---

```tsx
                    Object.values(x).map((_user) => {

```

Pega os valores do objeto retornado e percorre cada usuário.

---

```tsx
                        let u = { value: _user.id, label: _user.first_name }

```

Cria um novo objeto contendo apenas o **id** e o **nome** do usuário.

---

```tsx
                        this.users.push(u);

```

Adiciona esse objeto formatado ao array `this.users`.

---

```tsx
                    })

```

Fecha o `map` interno.

---

```tsx
                    console.log(x);
                    console.log(this.users);

```

Exibe no console:

- a resposta original
- o array formatado

---

```tsx
                    return this.users;

```

Retorna o array final, que será recebido no componente.

---

```tsx
                })
            );

```

Fecha o `map` e o `pipe`.

---

```tsx
    getCourses(): Observable<any[]> {

```

Inicia o método que busca os **cursos**. Ele é idêntico ao de usuários, mas para cursos.

---

```tsx
        return this.http
            .get("http://localhost:3000/getAllCourses")

```

Chama a rota que retorna todos os cursos.

---

```tsx
            .pipe(
                map(x => {
                    Object.values(x).map((_course) => {

```

Percorre os cursos retornados.

---

```tsx
                        let c = { value: _course.id, label: _course.name }

```

Cria um objeto contendo **id** e **name** do curso.

---

```tsx
                        this.courses.push(c);

```

Adiciona ao array `courses`.

---

```tsx
                    })
                    console.log(x);
                    console.log(this.courses);
                    return this.courses;
                })
            );

```

Exibe no console e retorna o array.

---

```tsx
    constructor(
        private http: HttpClient
    ) {
    }

```

O construtor injeta o **HttpClient**, permitindo usar `this.http` dentro do serviço.

---

🏆Tudo que a gente precisar fazer que envolver converter ou relacionar dois services diferentes, vamos colocar no shared, ele vai ficar no meio dos objetos como um intermediador.


---

🏆Vamos desenvolver o HTML do professor


---

### O QUE É O NG ON INIT?

🟣

### ✅ **O que é o `ngOnInit()`?**

É um método especial que **roda automaticamente** logo depois que o componente é criado e que suas dependências do construtor já foram injetadas.

Ele pertence à interface `OnInit`:

```tsx
export class MeuComponente implements OnInit {

  ngOnInit(): void {
    // Executa assim que o componente for inicializado
  }
}

```

---

## 🔍 **Para que serve?**

O `ngOnInit()` é usado para:

### ✔️ Carregar dados iniciais

Exemplo:

- Buscar lista de usuários
- Carregar dados de um serviço
- Iniciar variáveis

### ✔️ Executar lógica depois que o Angular criar o componente

O **construtor NÃO deve conter lógica pesada**.

O `ngOnInit()` é o lugar ideal para:

- Chamar serviços via HTTP
- Preencher variáveis
- Configurar estado inicial

---

## 🧠 **Diferença entre constructor e ngOnInit()**

### **constructor()**

- Angular chama primeiro
- Usado apenas para **injeção de dependências**
- Não deve ter lógica de inicialização de dados

### **ngOnInit()**

- Chamado depois que o Angular montou o componente
- Lugar correto para executar lógica inicial (carregar dados, etc.)

---

## 📌 Exemplo didático

```tsx
export class UserListComponent implements OnInit {

  users: any[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.userService.getAll().subscribe(data => {
      this.users = data;
    });
  }
}

```

### ▶️ O que acontece aqui?

1. **O Angular cria o componente**
2. **O constructor é chamado** → apenas injeta `UserService`
3. **O ngOnInit() é chamado** → carrega os usuários do backend

---

## 🎯 Resumo curto

| Local | Quando executa | Para que usar |
| --- | --- | --- |
| **constructor** | Antes do componente iniciar | Injeção de dependências |
| **ngOnInit()** | Ao iniciar o componente | Carregar dados e lógica inicial |

---


---

### EXPLICAÇÃO DA CLASSE PRINCIPAL DE ROUTING

🏆

# 🔥 **CÓDIGO (AppRoutingModule)**

```tsx
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserFormComponent } from './pages/user/user-form/user-form.component';
import { UserListComponent } from './pages/user/user-list/user-list.component';
import { TeacherFormComponent } from './pages/teacher/teacher-form/teacher-form.component';
import { TeacherListComponent } from './pages/teacher/teacher-list/teacher-list.component';
import { EvaluationListComponent } from './pages/evaluation/evaluation-list/evaluation-list.component';
import { EvaluationFormComponent } from './pages/evaluation/evaluation-form/evaluation-form.component';
import { CourseListComponent } from './pages/course/course-list/course-list.component';
import { CourseFormComponent } from './pages/course/course-form/course-form.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'users',
        component: UserListComponent,
        loadChildren: () => import('./pages/user/user.module').then((module) => module.UserModule)
      },
      {
        path: 'addUser',
        component: UserFormComponent
      },
      {
        path: 'teachers',
        component: TeacherListComponent,
        loadChildren: () => import('./pages/teacher/teacher.module').then((module) => module.TeacherModule)
      },
      {
        path: 'addTeacher',
        component: TeacherFormComponent
      },
      {
        path: 'evaluations',
        component: EvaluationListComponent,
        loadChildren: () => import('./pages/evaluation/evaluation.module').then((module) => module.EvaluationModule)
      },
      {
        path: 'addEvaluation',
        component: EvaluationFormComponent
      },
      {
        path: 'courses',
        component: CourseListComponent,
        loadChildren: () => import('./pages/course/course.module').then((module) => module.CourseModule)
      },
      {
        path: 'addCourse',
        component: CourseFormComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

```

---

# ✅ **EXPLICAÇÃO LINHA POR LINHA (Como você pediu)**

---

### ✔️ **IMPORTS**

```tsx
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

```

- `NgModule` → permite criar um módulo Angular
- `RouterModule` → módulo responsável por rotas
- `Routes` → tipo que descreve uma lista de rotas

---

### ✔️ **Importações dos componentes usados nas rotas**

```tsx
import { UserFormComponent } from './pages/user/user-form/user-form.component';

```

- Cada um desses imports traz componentes que você pode navegar via URL.

---

# 🔥 **Definição das Rotas**

```tsx
const routes: Routes = [

```

- Aqui começa a lista de rotas de toda a aplicação.

---

```tsx
  {
    path: '',
    children: [

```

- `path: ''` → rota raiz (ex.: `localhost:4200`)
- `children` → define rotas “filhas” abaixo desta rota raiz
    
    (ex.: `/users`, `/teachers`, `/courses` etc.)
    

---

## 🔹 **Rota de USERS**

```tsx
{
  path: 'users',
  component: UserListComponent,
  loadChildren: () => import('./pages/user/user.module').then((module) => module.UserModule)
},

```

- Quando acessar `/users`
- Angular mostra o **UserListComponent**
- E também carrega (lazy load) o módulo `UserModule`

➡️ **Lazy Loading** = módulo só é carregado quando a rota é acessada

➡️ melhora desempenho

---

```tsx
{
  path: 'addUser',
  component: UserFormComponent
},

```

- Quando acessar `/addUser`
- Renderiza o **UserFormComponent**

---

## 🔹 **Rota de TEACHERS**

Segue a mesma lógica:

- `/teachers` → TeacherListComponent + módulo carregado
- `/addTeacher` → TeacherFormComponent

---

## 🔹 **Rota de EVALUATIONS**

Mesma estrutura:

- `/evaluations` → EvaluationListComponent
- `/addEvaluation` → EvaluationFormComponent

---

## 🔹 **Rota de COURSES**

Mesma ideia:

- `/courses` → CourseListComponent
- `/addCourse` → CourseFormComponent

---

# 🔥 **Módulo de Rotas**

```tsx
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

```

### ✔️ O que significa?

- `RouterModule.forRoot(routes)`
    - Registra as rotas principais da aplicação
    - `forRoot()` só é usado **no módulo principal**
- `exports: [RouterModule]`
    - Permite que outros módulos usem essas rotas

---

# 🎯 **RESUMO RÁPIDO**

- Esse arquivo define **todas as rotas principais** da aplicação.
- Cada `path` aponta para um componente.
- Alguns paths carregam módulos com **lazy loading**.
- Toda a navegação da aplicação passa por esse arquivo.
- Ele é o **"Google Maps" da sua aplicação Angular"**.

---


### EXPLICAÇÃO DE LINHA DE CÓDIGO

🏆

# Explicação detalhada da linha

```tsx
loadChildren: () => import('./pages/user/user.module').then((module) => module.UserModule)

```

Essa linha configura *lazy loading* (carregamento tardio) de um módulo no routing do Angular. Vou destrinchar passo a passo.

---

### 1 — O que `loadChildren` faz

`loadChildren` diz ao Angular: *quando a rota for acessada, carregue este módulo separadamente (em um chunk) ao invés de incluí-lo no bundle inicial.* Isso reduz o tamanho inicial da aplicação e melhora o tempo de carregamento.

---

### 2 — `() => import('...')` — função que retorna uma `Promise`

- `() =>` é uma **arrow function** sem parâmetros.
- `import('./pages/user/user.module')` é a sintaxe padrão do JavaScript/TypeScript para **dynamic import** — isso retorna uma `Promise` que resolve para o módulo (objeto contendo as exports do arquivo).
- Como é dentro de uma função, o import só é executado no momento em que o Angular precisa carregar a rota (ou seja, quando o usuário navega para ela).

---

### 3 — `.then((module) => module.UserModule)` — pegar a `export` correta

- O `import(...)` resolve para um objeto que contém todas as *exports* do arquivo `user.module.ts`.
- `.then((module) => module.UserModule)` pega a export **nominal** `UserModule` daquele objeto e a retorna.
- O Angular espera receber a *classe do módulo* (por exemplo `UserModule`) da Promise.

---

### 4 — Fluxo em tempo de execução (simplificado)

1. App é carregada — *UserModule* **não** é carregado ainda.
2. Usuário navega para a rota configurada (ex.: `/users`).
3. Angular executa a função `loadChildren`.
4. O bundle/chunk com `user.module` é solicitado ao servidor (fetch).
5. Quando resolvido, Angular pega `module.UserModule` e carrega o módulo, seus componentes e suas rotas filhas.
6. A navegação continua para o componente desejado.

---

### 5 — Porque usar isso (benefícios)

- **Melhora a performance inicial**: reduz bundle inicial.
- **Escalabilidade**: módulos grandes só carregam quando necessário.
- **Separação de responsabilidades**: cada feature pode ter seu próprio módulo e bundle.

---

### 6 — Requisitos / boas práticas

- O arquivo `./pages/user/user.module.ts` **deve exportar** `UserModule` (ex.: `export class UserModule {}`).
- Caminho é relativo ao arquivo onde o `routes` está declarado.
- Usar o dynamic import (arrow function + `import()`) é a forma recomendada com o *Angular Ivy*. A sintaxe antiga de string (`'./path#UserModule'`) está obsoleta.
- Evite dependências circulares entre módulos, pois podem travar o carregamento.

---

### 7 — Possíveis problemas comuns

- **Caminho errado** → erro em tempo de execução ao acessar a rota.
- **Não exportou o módulo** → `module.UserModule` undefined.
- **Módulo com providers que colidem** — cuidado com providers de escopo global/Singleton.
- **SSR (Angular Universal)** — verifique compatibilidade se usar server-side rendering.

---

### 8 — Extras (opções relacionadas)

- Você pode usar estratégias de pré-carregamento (`PreloadAllModules`, ou preloading customizado) se quiser carregar os lazy modules após o carregamento inicial para melhorar latência de navegação.
- Para nomear o chunk gerado: é possível usar comentários mágicos do bundler, por exemplo
    
    ```tsx
    import(/* webpackChunkName: "user-module" */ './pages/user/user.module')
    
    ```
    
    (nem sempre necessário — o Angular/webpack já cria nomes legíveis).
    

---


### O QUE É UMA PROMISSE?

🏆

Uma **Promise** (Promessa) em JavaScript é um **objeto que representa uma operação assíncrona que ainda não foi concluída**, mas que **vai** ter um resultado **no futuro** — seja **sucesso** ou **erro**.

---

# ✅ **Explicação simples**

Uma Promise é como pedir uma pizza:

- Você faz o pedido (**inicia a Promise**)
- A pizzaria começa a preparar (**pendente / pending**)
- Depois de um tempo, acontece uma das duas coisas:
    - A pizza chega (**resolved** / resolvida)
    - Dá algum problema (**rejected** / rejeitada)

A *Promise* permite que você programe o que vai acontecer **quando** a operação terminar.

---

# 🧠 **Estados de uma Promise**

1. **Pending** → ainda em execução
2. **Fulfilled** → deu certo (resolve)
3. **Rejected** → deu errado (reject)

---

# 💡 Exemplo simples

```tsx
const promise = new Promise((resolve, reject) => {
    const sucesso = true;

    if (sucesso) {
        resolve("Pedido concluído!");
    } else {
        reject("Erro ao concluir pedido...");
    }
});

promise.then((resultado) => {
    console.log(resultado);
}).catch((erro) => {
    console.log(erro);
});

```

---

# 📌 **Quando Angular usa Promise?**

Exemplo que você viu:

```tsx
loadChildren: () => import('./pages/user/user.module')
                   .then((module) => module.UserModule)

```

Esse `import(...)` retorna uma **Promise**, e o `.then()` só roda **quando o módulo terminar de ser carregado**.

Isso permite o **lazy loading**: carregar módulos **somente quando a rota for acessada**.

---

# 🆚 Promise vs Observable

| Promise | Observable |
| --- | --- |
| Retorna **um único valor** | Pode retornar **vários valores** |
| Não pode ser cancelada | Pode ser cancelado (unsubscribe) |
| Executa automaticamente | Executa quando alguém "assina" |
| Ferramenta do JS | Ferramenta adicional (RxJS) |

---

# ✔ Resumo final

**Promise é um objeto que representa algo assíncrono que vai terminar no futuro.**

Ela pode dar certo (resolve) ou dar errado (reject), e você usa `.then()` e `.catch()` para lidar com o resultado.

