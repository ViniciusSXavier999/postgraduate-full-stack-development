# CRIAR TABELAS DE LISTAGEM DE DADOS LAZY LOADING

> Outras ferramentas, como o ionic cria todas as páginas(componentes) como lazy loading
> 

---

# O QUE É LAZY LOADING?

O **lazy loading** é uma técnica de otimização que adia o carregamento de recursos (como imagens, vídeos ou dados) até que eles sejam realmente necessários, em vez de carregá-los todos de uma vez. Isso melhora o desempenho de aplicativos e páginas da web, reduzindo o tempo inicial de carregamento e economizando recursos de rede.

Por exemplo:
- **Sem lazy loading**: Todas as imagens de uma página são carregadas ao abrir a página, mesmo as que estão fora da tela.
- **Com lazy loading**: As imagens só são carregadas quando o usuário rola até elas.

Essa abordagem é especialmente útil em sistemas com grande quantidade de dados ou elementos visuais.

## ARTIGOS SOBRE LAZY LOADING

[Como o Lazy Loading pode melhorar o desempenho da minha aplicação Angular? | Alura](https://www.alura.com.br/artigos/como-lazy-loading-pode-melhorar-desempenho-aplicacao-angular?srsltid=AfmBOooPXFsVuGW1zxWGR4bcdaXv7RQng3Ez-NEBsEOPZVF34_X6D6IT)

[Angular: Lazy loading modules with services](https://stackoverflow.com/questions/48186872/angular-lazy-loading-modules-with-services)

🏆 DOCUMENTAÇÃO OFICIAL

[Angular](https://v17.angular.io/guide/lazy-loading-ngmodules)

## **Lazy loading no Angular – um guia para iniciantes sobre os NgModules**

[Lazy loading no Angular – um guia para iniciantes sobre os NgModules](https://www.freecodecamp.org/portuguese/news/lazy-loading-no-angular-um-guia-para-iniciantes-sobre-os-ngmodules/)

## DEFER() FACILITA A MANIPUAÇÃO DE COMPONENTES LAZY LOADING

[Introdução ao Angular 17](https://consolelog.com.br/introducao-ao-angular-17/)

---

---

---

## VANTAGENS DO LAZY LOADING

🏆 Vamos pensar no componente listar do nosso projeto, ele não esta lazy, todas as dependências e todos componentes está sendo importados no app.module (versões antigas do angular que ainda não utilizava componentes stand alone) e não teria essa necessidade de ficar com esse arquivo gigantesco. Se todos os meus componentes fossem lazy, esse arquivo seria mínimo. 

📌 Não teria a necessidade de colocar todas as dependências dentro do imports do app.module.ts, você poderia colocar simplesmente dentro do seu arquivo lazy loading


🏆 Na documentação do Angular tem um comando para gerar um componente lazy com ROTA já feita automaticamente 

```html
ng generate module customers --route customers --module app.module
```

🚨 Eu não sou obrigado a utilizar esse comando, basta eu criar um arquivo especifico de router e module para o meu componente Angular (versões antigas)



---

---

---

### COMO CRIAR COMPONENTES LAZY LOADING MESMO O COMPONENTE SENDO STANDALONE

[How to lazy load Standalone components](https://kurtwanger40.medium.com/how-to-lazy-load-standalone-components-ff6b2298259f)

---

📌 Temos um componente de cadastro por exemplo, podemos ter sub componentes, sub páginas e adicionar essa rota que a gente cria o lazy loading

const routes:

```html
const routes: Routes = [
  {
    path: 'items',
    loadChildren: () => import('./items/items.module').then(m => m.ItemsModule)
  }
];
```

> Eu consigo criar sub componentes que não vão ser lazy dentro dessa mesma pasta, que ele vai carregar a partir daquela rota
> 

> Podemos dividir nossa aplicação em módulos utilizando o lazy loading
> 

🚨 Caso você tenha um arquivo de service igual você tem no module principal da aplicação, você vai ter que colocar o service, o HTTPCLIENT, ao invés de ser somente global, o Angular vai reclamar e pedir para que você adicione no module especifico do componente lazy loading


---

---

---

### BASTA SUBSTITUIR O ‘COMPONENT’ PARA O LOADCHILDREN E O CAMINHO DO COMPONENTE PARA FAZER COM QUE ELE SEJA CARREGADO DE FORMA LAZY LOADING (PREGUIÇOSA)

```tsx
const routes: Routes = [
  {
    path: 'customers',
    loadChildren: () => import('./customers/customers.module').then(m => m.CustomersModule)
```

---

---

---

🏆 É MUITO IMPORTANTE VOCÊS PENSAREM QUANDO FOR CRIAR UMA ARQUITETURA, PRINCIPALMENTE UM SISTEMA GRANDE, MODULARIZAR ELE E CRIAR TODOS OS COMPONENTES LAZY LOADING QUE É O PADRÃO QUE SE UTILIZA NO MERCADO, É IMPORTANTE PARA A APLICAÇÃO FICAR MAIS ROBUSTA


🏆 TODAS AS DEPENDÊNCIAS MESMO QUE SEJA GLOBAL E VOCÊS FOREM UTILIZAR, É NECESSÁRIO COLOCAR DENTRO DO MODULE DO COMPONENTE LAZY (versões antigas)


> DESAFIO → TRANSFORMAR O LISTAR USUÁRIO EM LAZZY COMPONENT E FAZER OS IMPORTS, HTTP, SERVICE
> 

---

---

---

## DÚVIDAS QUE SURGIRAM DURANTE A AULA

### O que é sub componentes? (exemplos)

Um **subcomponente** no Angular é um componente secundário que é usado dentro de outro componente principal. Ele é comumente utilizado para organizar a aplicação em partes menores e mais reutilizáveis.

### **Exemplo de Subcomponente:**

### 1. **Criando o Subcomponente**

Crie o subcomponente com o Angular CLI:

```bash
ng generate component user-details

```

Isso criará os arquivos necessários (`user-details.component.ts`, `HTML`, `CSS`) para o subcomponente.

---

### 2. **Código do Subcomponente (`user-details.component.ts`)**

```tsx
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent {
  @Input() user: { id: number; name: string; email: string } | undefined;
}

```

Aqui, usamos o decorador **`@Input`** para receber dados do componente pai.

---

### 3. **Template do Subcomponente (`user-details.component.html`)**

```html
<div *ngIf="user">
  <h3>User Details</h3>
  <p><strong>ID:</strong> {{ user.id }}</p>
  <p><strong>Name:</strong> {{ user.name }}</p>
  <p><strong>Email:</strong> {{ user.email }}</p>
</div>

```

---

### 4. **Componente Pai (`app.component.ts`)**

```tsx
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  selectedUser = { id: 1, name: 'John Doe', email: 'john.doe@example.com' };
}

```

---

### 5. **Template do Componente Pai (`app.component.html`)**

Aqui, o subcomponente **`<app-user-details>`** é usado.

```html
<h1>Welcome to the App!</h1>
<app-user-details [user]="selectedUser"></app-user-details>

```

---

### **Explicação do Funcionamento:**

1. O **componente pai** (`AppComponent`) define um objeto de usuário e passa para o **subcomponente** através da **property binding** `[user]="selectedUser"`.
2. O **subcomponente** (`UserDetailsComponent`) exibe os detalhes do usuário recebido via **`@Input`**.

---

### **Resumo**

Um subcomponente é um componente reutilizável que recebe dados do componente pai e é renderizado dentro dele. No exemplo acima, `UserDetailsComponent` é o subcomponente, e `AppComponent` é o componente pai.

---

---

---

## Como criar componentes lazy loading com componentes standalone

No Angular 14, com a introdução de **componentes standalone**, também é possível configurar **lazy loading** para esses componentes, o que permite que eles sejam carregados sob demanda quando necessários (ou seja, quando o usuário navega até a rota associada a eles). A configuração de lazy loading para componentes standalone é feita por meio de **rotas** e a utilização da função `loadComponent`, que foi introduzida no Angular 14 para permitir o carregamento dinâmico de componentes.

Aqui está um guia passo a passo sobre como configurar lazy loading para componentes standalone:

### Passo 1: Criar um Componente Standalone

Primeiro, você precisa criar um componente standalone. Isso é feito ao definir o atributo `standalone: true` no decorador `@Component`.

Exemplo de componente standalone:

```tsx
// app/standalone/standalone.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-standalone',
  standalone: true,
  template: `<h2>Este é um Componente Standalone</h2>`,
})
export class StandaloneComponent {}

```

### Passo 2: Configurar as Rotas com Lazy Loading

Agora, você precisa configurar as rotas da sua aplicação para usar **lazy loading** com o componente standalone. No Angular, a forma de fazer lazy loading de componentes é através da função `loadComponent`, que carrega um componente dinamicamente quando a rota associada a ele é acessada.

No arquivo de configuração das rotas (geralmente `app-routing.module.ts` ou `app-routing.ts`), você irá configurar uma rota para o componente e usar a função `loadComponent` para carregar o componente de forma preguiçosa.

```tsx
// app/app-routing.module.ts
import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'lazy-component',
    loadComponent: () => import('./standalone/standalone.component').then(m => m.StandaloneComponent)
  }
];

```

Aqui, a rota `/lazy-component` irá carregar o componente `StandaloneComponent` de forma preguiçosa quando o usuário acessar essa URL.

### Passo 3: Configuração do Módulo da Aplicação

No Angular, você normalmente usaria o `NgModule` para configurar as rotas, mas no caso dos **componentes standalone**, você não precisa de um módulo para a aplicação inteira. Você pode inicializar a aplicação usando `bootstrapApplication` e adicionar as rotas diretamente no arquivo `main.ts` da aplicação.

```tsx
// main.ts
import { bootstrapApplication } from '@angular/platform-browser';
import { importProvidersFrom } from '@angular/core';
import { RouterModule } from '@angular/router';
import { routes } from './app-routing.module';

bootstrapApplication(AppComponent, {
  providers: [
    importProvidersFrom(RouterModule.forRoot(routes))  // Configura as rotas para a aplicação
  ]
})
  .catch(err => console.error(err));

```

### Passo 4: Acessar o Componente Lazy Loaded

Agora, ao acessar a URL `/lazy-component`, o componente `StandaloneComponent` será carregado preguiçosamente. Isso significa que o Angular irá carregar esse componente apenas quando a rota for acessada, economizando recursos e melhorando o desempenho da aplicação.

### Resumo dos Passos:

1. **Crie um Componente Standalone**: Defina um componente com `standalone: true` no decorador `@Component`.
2. **Configure as Rotas com Lazy Loading**: Use a função `loadComponent` nas rotas para carregar o componente de forma preguiçosa.
3. **Inicialize a Aplicação com `bootstrapApplication`**: Utilize `bootstrapApplication` para inicializar a aplicação, definindo as rotas diretamente no `main.ts`.

### Exemplo Completo:

### Componente Standalone:

```tsx
// standalone/standalone.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-standalone',
  standalone: true,
  template: `<h2>Componente Standalone Carregado Preguiçosamente!</h2>`,
})
export class StandaloneComponent {}

```

### Arquivo de Rotas (`app-routing.module.ts`):

```tsx
// app-routing.module.ts
import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'lazy-component',
    loadComponent: () => import('./standalone/standalone.component').then(m => m.StandaloneComponent)
  }
];

```

### Arquivo Principal (`main.ts`):

```tsx
// main.ts
import { bootstrapApplication } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { routes } from './app-routing.module';
import { AppComponent } from './app.component';

bootstrapApplication(AppComponent, {
  providers: [
    importProvidersFrom(RouterModule.forRoot(routes))  // Configuração das rotas
  ]
})
  .catch(err => console.error(err));

```

### Conclusão:

O **lazy loading** de componentes standalone no Angular é simples e envolve a utilização da função `loadComponent` dentro das rotas para carregar componentes sob demanda. Isso reduz o tamanho inicial da aplicação e melhora a performance, já que o componente será carregado apenas quando necessário.

---

---

---

🏆 A PARTIR DESSE MOMENTO EU COMEÇEI A TER DÚVIDAS EM RELAÇÃO A CONFIGURAÇÃO DO ARQUIVO app.config.ts e main.ts.


## EU PODERIA DEIXAR ESSE CÓDIGO NO MEU APP.CONFIG.TS?

```tsx
providers: [
    importProvidersFrom(RouterModule.forRoot(routes))  // Configura as rotas para a aplicação
  ]
```

Sim, você pode deixar a configuração das rotas em um arquivo separado, como o `app.config.ts` ou qualquer outro nome de arquivo que você escolher, e importar esse arquivo dentro do `main.ts` para configurar a aplicação. A ideia é manter a separação de preocupações e organizar seu código de forma mais modular.

Vamos ver como você poderia fazer isso de forma prática:

### Estrutura do Projeto

1. **Componente Standalone**: O componente que você quer carregar de forma lazy.
2. **Arquivo de Configuração de Rotas (`app.config.ts`)**: Definir as rotas e a configuração de lazy loading.
3. **Arquivo Principal (`main.ts`)**: Inicializar a aplicação e importar a configuração de rotas.

### Passo 1: Componente Standalone

Primeiro, crie um componente standalone, como já vimos anteriormente.

```tsx
// standalone/standalone.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-standalone',
  standalone: true,
  template: `<h2>Componente Standalone Carregado Preguiçosamente!</h2>`,
})
export class StandaloneComponent {}

```

### Passo 2: Arquivo de Configuração de Rotas (`app.config.ts`)

Agora, crie um arquivo `app.config.ts` (ou qualquer outro nome que desejar) para definir suas rotas. Este arquivo vai exportar a configuração de rotas que será importada no arquivo `main.ts`.

```tsx
// app.config.ts
import { Routes } from '@angular/router';
import { StandaloneComponent } from './standalone/standalone.component';

export const routes: Routes = [
  {
    path: 'lazy-component',
    loadComponent: () => import('./standalone/standalone.component').then(m => m.StandaloneComponent)
  }
];

```

### Passo 3: Arquivo Principal (`main.ts`)

No arquivo `main.ts`, você irá importar a configuração de rotas do arquivo `app.config.ts` e usá-la ao inicializar a aplicação com `bootstrapApplication`.

```tsx
// main.ts
import { bootstrapApplication } from '@angular/platform-browser';
import { importProvidersFrom } from '@angular/core';
import { RouterModule } from '@angular/router';
import { routes } from './app.config';  // Importa a configuração das rotas
import { AppComponent } from './app.component';

bootstrapApplication(AppComponent, {
  providers: [
    importProvidersFrom(RouterModule.forRoot(routes))  // Usando as rotas importadas de app.config.ts
  ]
})
  .catch(err => console.error(err));

```

### Resumo

1. **Componente Standalone**: Crie o componente com `standalone: true` no decorador `@Component`.
2. **Arquivo de Configuração de Rotas**: Defina as rotas no arquivo `app.config.ts` ou qualquer outro nome que desejar, e exporte a configuração.
3. **Arquivo Principal (`main.ts`)**: Importe a configuração de rotas e inicialize a aplicação com `bootstrapApplication`.

### Benefícios dessa Abordagem:

- **Organização**: Você pode manter a configuração de rotas separada do arquivo `main.ts`, o que facilita a manutenção e a escalabilidade da aplicação.
- **Modularidade**: Facilita a reutilização de configurações e componentes. Por exemplo, se você tiver múltiplos módulos ou diferentes configurações de rotas em arquivos separados, pode importar e usar quando necessário.

Com essa abordagem, você tem uma configuração modular e organizada, facilitando a manutenção e expansão da sua aplicação Angular.

---

---

---

## EXPLICA O CÓDIGO DO MEU ARQUIVO app.config.ts E DO ARQUIVO main.ts DO MEU PROJETO ATUAL

app.config

```tsx
export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes),  
};   
```

main.ts

```tsx
BotstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
```

O código que você está se referindo está configurando a aplicação Angular de uma maneira mais modular e simples, utilizando a função `bootstrapApplication` em conjunto com o `ApplicationConfig` para fornecer a configuração da aplicação, incluindo os **provedores** necessários (como as rotas). Vamos destrinchar o que está acontecendo em cada parte desse código.

### Explicação do Código

### 1. **`appConfig`**

```tsx
export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes)],
};

```

- **`ApplicationConfig`**: Este é um tipo de configuração específico do Angular que foi introduzido a partir da versão 14. Ele substitui a configuração tradicional via `NgModule` em uma aplicação que utiliza componentes standalone.
    - Ao invés de utilizar um `NgModule` para definir as dependências da aplicação (como serviços, rotas, etc.), você pode usar o `ApplicationConfig` para definir essas dependências de forma mais simples e direta.
- **`providers`**: O `providers` é um array onde você define os provedores necessários para a sua aplicação. Provedores no Angular são basicamente as dependências que a aplicação precisa para funcionar, como serviços, rotas, e outros recursos.
- **`provideRouter(routes)`**: Esse é um provedor que está sendo adicionado à configuração de `appConfig`.
    - **`provideRouter`** é uma função que registra o roteamento da aplicação e configura as rotas.
    - **`routes`** é uma constante que você provavelmente definiu anteriormente, que contém a configuração de rotas da sua aplicação. Essa configuração pode incluir rotas para componentes standalone, como vimos em exemplos anteriores.
    - O `provideRouter` é responsável por fornecer o roteamento da aplicação, permitindo que as rotas sejam gerenciadas pelo Angular e, em caso de lazy loading, que os componentes sejam carregados sob demanda.

Portanto, a linha:

```tsx
providers: [provideRouter(routes)],

```

está informando ao Angular que você quer configurar as rotas usando a função `provideRouter` e fornecer a lista de rotas `routes` para a aplicação.

### 2. **Uso de `bootstrapApplication`**

No arquivo `main.ts`, o `bootstrapApplication` é chamado para inicializar a aplicação, e a configuração que você criou (`appConfig`) é passada como um argumento.

```tsx
bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));

```

- **`bootstrapApplication`**: É a função que inicializa a aplicação Angular de forma mais simples, especialmente ao usar componentes standalone. Ela substitui a inicialização tradicional com `platformBrowserDynamic().bootstrapModule(AppModule)`, permitindo que você inicialize diretamente um componente.
    - **Primeiro argumento (`AppComponent`)**: Este é o componente raiz da aplicação. Neste caso, é o `AppComponent`, que será o componente principal da aplicação.
    - **Segundo argumento (`appConfig`)**: Este é o objeto de configuração que você criou anteriormente (`appConfig`), que inclui os **provedores** necessários, como as rotas. O Angular usará essas configurações ao inicializar a aplicação.
- **`.catch((err) => console.error(err))`**: Aqui, o código está tratando possíveis erros durante a inicialização da aplicação. Se houver algum problema ao inicializar a aplicação (por exemplo, se algum componente ou configuração não for encontrado), o erro será capturado e exibido no console.

### Resumo

1. **`appConfig`**:
    - Define os **provedores** que a aplicação precisa, neste caso, o provedor de rotas (`provideRouter(routes)`).
    - Isso substitui a necessidade de configurar as dependências no `NgModule`.
2. **`bootstrapApplication`**:
    - Inicializa a aplicação com o componente raiz (`AppComponent`).
    - Recebe `appConfig` como configuração, que inclui as rotas e outros provedores que você quer que sejam usados na aplicação.
    - Com essa abordagem, você pode configurar e inicializar a aplicação de forma mais direta, sem depender de `NgModules`.

Em resumo, o código está inicializando uma aplicação Angular sem a necessidade de um `NgModule`, usando a função `bootstrapApplication` e passando a configuração dos provedores de rotas de maneira simples. Essa abordagem é mais moderna e recomendada, especialmente ao trabalhar com **componentes standalone** no Angular.

---

---

---

## EXPLICA RESUMIDAMENTE ESSE CÓDIGO

```tsx
importProvidersFrom(RouterModule.forRoot(routes))  // Usando as rotas importadas de app.config.ts
]
```

> NESSE CASO FIQUEI EM DÚVIDA PORQUE NA RESPOSTA DA PERGUNTA QUE EU FIZ PEDINDO PARA CRIAR UM COMPONENT LAZY LOADING COM UM COMPONENTE STANDALONE O MAIN CONFIG ESTAVA DESSA FORMA
> 

A linha de código:

```tsx
providers: [
  importProvidersFrom(RouterModule.forRoot(routes))  // Usando as rotas importadas de app.config.ts
]

```

Está configurando o provedor de rotas para a aplicação Angular de forma simples e moderna. Vamos entender isso em partes:

1. **`importProvidersFrom(RouterModule.forRoot(routes))`**:
    - **`RouterModule.forRoot(routes)`**: Aqui, o `RouterModule.forRoot()` configura o roteamento da aplicação, utilizando as rotas definidas na constante `routes` (provavelmente importada de um arquivo como `app.config.ts`).
    - **`importProvidersFrom(...)`**: Essa função importa os provedores do módulo, neste caso, do `RouterModule` que contém as funcionalidades de roteamento. Ela é uma alternativa mais simples ao uso de `NgModule`, fornecendo a configuração diretamente sem a necessidade de um módulo tradicional.
2. **O que a linha faz**:
    - Registra o roteamento para a aplicação Angular, usando as rotas definidas em `routes`, permitindo que a navegação entre componentes seja gerenciada automaticamente pelo Angular.

### Resumo

Essa linha de código importa a configuração de roteamento para a aplicação, usando o `RouterModule` e as rotas definidas em `routes`, e as fornece como um provedor de dependências para a aplicação.

---

---

---

## A MINHA DÚVIDA AGORA ERA SE ESSA LINHA DE CÓDIGO

```tsx
providers: [
  importProvidersFrom(RouterModule.forRoot(routes))  // Usando as rotas importadas de app.config.ts
]

```

## FAZIA A MESMA COISA QUE A CONFIGURAÇÃO DO MEU ARQUIVO app.config.ts E main.ts

faz a mesma coisa que esse código do app.config.ts

```tsx
 export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes),
   };   
```

main.ts

```tsx
bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));?
```

Sim, a linha de código que você mostrou:

```tsx
export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes)],
};

```

e a linha que você mencionou anteriormente:

```tsx
providers: [
  importProvidersFrom(RouterModule.forRoot(routes))  // Usando as rotas importadas de app.config.ts
]

```

**fazem a mesma coisa** no contexto de configurar o roteamento da aplicação, mas com algumas diferenças no estilo e abordagem de implementação. Vamos analisar essas diferenças.

### O que cada código faz:

### 1. **`provideRouter(routes)`**

```tsx
export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes)],
};

```

- **Contexto**: Isso é usado na configuração de uma aplicação Angular com **componentes standalone**, usando a abordagem `ApplicationConfig` (Introduzida no Angular 14).
- **`provideRouter(routes)`**: O `provideRouter` é uma função que registra o roteamento da aplicação diretamente, passando as **rotas** definidas na constante `routes`. Não há necessidade de usar um `NgModule` para configurar o roteamento — isso é feito diretamente dentro da configuração `ApplicationConfig`.
- **Simplicidade**: É uma forma mais direta e moderna de fornecer o roteamento em uma aplicação standalone, sem a necessidade de módulos.

### 2. **`importProvidersFrom(RouterModule.forRoot(routes))`**

```tsx
providers: [
  importProvidersFrom(RouterModule.forRoot(routes))
]

```

- **Contexto**: Esse código é típico de uma aplicação Angular tradicional que ainda utiliza **`NgModules`** para gerenciar a configuração de dependências, como o roteamento.
- **`importProvidersFrom(RouterModule.forRoot(routes))`**: A função `importProvidersFrom` importa e registra os provedores do módulo `RouterModule`, que é configurado com as rotas definidas em `routes`. Isso é feito diretamente no `main.ts` ou em algum módulo de configuração, mas exige o uso de um módulo (`RouterModule`), o que é típico de aplicações que não utilizam componentes standalone.
- **Complexidade**: Requer o uso de `NgModules`, o que pode ser mais verboso e menos moderno em comparação com a abordagem com `ApplicationConfig`.

### Comparação

- **Abordagem `provideRouter(routes)`** (com `ApplicationConfig`): Usada para **componentes standalone** e **aplicações sem módulos**. É mais simples e direta, usando a nova API do Angular.
- **Abordagem `importProvidersFrom(RouterModule.forRoot(routes))`** (com `NgModule`): Usada em aplicações Angular **tradicionais**, que ainda utilizam `NgModules`. Embora seja eficaz, essa abordagem é mais antiga e não é tão simplificada quanto a nova abordagem com `ApplicationConfig`.

### Resumo:

**Sim, ambos fazem a mesma coisa**, ou seja, configuram o roteamento para a aplicação, mas com **formas diferentes de implementá-las**.

- **`provideRouter(routes)`** é a forma moderna, usada em aplicações com **componentes standalone** e a configuração de **`ApplicationConfig`**.
- **`importProvidersFrom(RouterModule.forRoot(routes))`** é a forma mais tradicional, usada em aplicações Angular com **`NgModules`**.

Se você estiver utilizando a abordagem **moderna de componentes standalone** (com Angular 14 ou superior), é recomendado usar `provideRouter(routes)` em conjunto com `ApplicationConfig`, como mostrado no primeiro exemplo.

### EXPLICAÇÃO NO STACK OVERFLOW

[provideRouter vs RouterModule.forRoot in angular](https://stackoverflow.com/questions/78189625/providerouter-vs-routermodule-forroot-in-angular)

---

---

---

## É OBRIGATÓRIO CRIAR UM MÓDULO SEPARADO PARA UM COMPONENTE LAZY LOADING?

Não, **não é obrigatório criar um módulo separado** para um componente **lazy-loaded** (carregado de forma preguiçosa) no Angular. A partir do Angular 14, com o suporte para **componentes standalone**, você pode criar componentes **lazy-loaded** sem precisar de um módulo separado.

Antes do Angular 14, a prática comum era criar um módulo separado (geralmente chamado de **`LazyModule`**) para cada funcionalidade ou componente que você queria carregar de forma preguiçosa, e esse módulo seria carregado via **lazy loading**. Porém, com a introdução de **componentes standalone**, agora você pode **carregar um componente standalone de forma preguiçosa diretamente**, sem a necessidade de criar um módulo específico.

### Como funciona o Lazy Loading com Componentes Standalone

Com a introdução de componentes standalone, você pode carregar um **componente independente** (sem precisar de um módulo Angular tradicional) de forma preguiçosa diretamente nas suas rotas.

### Exemplo de Lazy Loading de um Componente Standalone

Aqui está um exemplo de como você pode configurar o **lazy loading** de um **componente standalone** sem criar um módulo separado.

### 1. **Componente Standalone**

Crie um componente standalone:

```tsx
// lazy-component/lazy.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-lazy',
  standalone: true,
  template: `<h2>Componente Carregado de Forma Preguiçosa!</h2>`,
})
export class LazyComponent {}

```

### 2. **Configuração de Rota com Lazy Loading**

Agora, no arquivo de rotas (`app.config.ts` ou diretamente no arquivo `main.ts`), você pode usar o **lazy loading** para carregar o componente standalone:

```tsx
// app.config.ts
import { Routes } from '@angular/router';
import { LazyComponent } from './lazy-component/lazy.component';

export const routes: Routes = [
  {
    path: 'lazy',
    loadComponent: () => import('./lazy-component/lazy.component').then(m => m.LazyComponent)
  }
];

```

Nesse exemplo, o **componente `LazyComponent`** será carregado de forma preguiçosa quando o usuário acessar a rota `/lazy`. Você não precisa de um módulo separado, apenas de um componente standalone e a configuração de rota.

### 3. **Inicialização no `main.ts`**

No `main.ts`, você inicializa a aplicação com a configuração de rotas:

```tsx
// main.ts
import { bootstrapApplication } from '@angular/platform-browser';
import { importProvidersFrom } from '@angular/core';
import { RouterModule } from '@angular/router';
import { routes } from './app.config';
import { AppComponent } from './app.component';

bootstrapApplication(AppComponent, {
  providers: [
    importProvidersFrom(RouterModule.forRoot(routes))
  ]
})
  .catch((err) => console.error(err));

```

### Resumo

Com a introdução dos **componentes standalone** no Angular 14, **não é mais necessário** criar um módulo separado para um componente lazy-loaded. Você pode diretamente usar a função **`loadComponent`** nas rotas e carregar um componente de forma preguiçosa, sem a necessidade de módulos extras. Isso simplifica a estrutura do código e facilita o uso de lazy loading.

### Comparação com a Abordagem Tradicional (Sem Standalone)

Antes do Angular 14, a abordagem típica seria algo assim:

1. Criar um módulo (`LazyModule`).
2. Configurar o lazy loading usando `loadChildren` no arquivo de rotas.
3. O módulo seria carregado de forma preguiçosa.

Agora, você pode fazer isso diretamente com componentes standalone, sem a sobrecarga de módulos.

---

---

---

## O QUE É O DEFER NO ANGULAR 17?

No **Angular 17**, o `defer` é uma nova funcionalidade introduzida para melhorar o desempenho de carregamento de módulos e componentes. Ele permite que você defina explicitamente o **adiamento do carregamento** de módulos ou componentes até que seja necessário, tornando a experiência de navegação mais eficiente e rápida.

### O que o `defer` faz no Angular?

O `defer` permite **adiar o carregamento** de um componente ou módulo até o momento exato em que ele for realmente necessário. Isso pode ser útil especialmente em situações em que você deseja otimizar o tempo de carregamento inicial da aplicação, carregando recursos apenas quando o usuário interage com determinadas partes da aplicação.

O `defer` é uma forma mais flexível e poderosa de realizar **lazy loading** (carregamento preguiçoso), pois ele permite que você controle **exatamente** quando e como os módulos e componentes são carregados. O uso de `defer` ajuda a melhorar a performance da aplicação, carregando recursos **sob demanda**, sem impactar o desempenho da página inicial.

### Exemplos de Uso do `defer`

Aqui estão alguns exemplos para mostrar como o `defer` pode ser usado:

### 1. **Adiar o Carregamento de Componentes**

No Angular 17, você pode usar o `defer` para adiar o carregamento de **componentes standalone** ou **módulos**. Aqui está um exemplo de como você pode usá-lo nas rotas:

```tsx
import { Routes } from '@angular/router';
import { LazyComponent } from './lazy.component';

export const routes: Routes = [
  {
    path: 'lazy',
    loadComponent: () => import('./lazy.component').then((m) => m.LazyComponent),
    defer: true  // Adiando o carregamento do componente
  }
];

```

Neste exemplo, o componente `LazyComponent` só será carregado quando o usuário acessar a rota `/lazy`. O `defer: true` indica que o carregamento do componente será **adiado**, ajudando a reduzir o tempo de inicialização da aplicação.

### 2. **Adiar o Carregamento de Módulos**

Você também pode usar o `defer` em **módulos** com lazy loading. Em vez de carregar um módulo imediatamente, você pode optar por adiá-lo:

```tsx
export const routes: Routes = [
  {
    path: 'lazy-module',
    loadChildren: () => import('./lazy-module/lazy-module.module').then((m) => m.LazyModule),
    defer: true  // O carregamento do módulo será adiado
  }
];

```

### Vantagens do `defer`

1. **Desempenho Melhorado**: Ao adiar o carregamento de recursos não essenciais, você pode reduzir o **tempo de carregamento inicial** da aplicação, permitindo que o usuário tenha uma experiência mais fluida.
2. **Carregamento Sob Demanda**: Com o `defer`, você garante que recursos pesados ou não essenciais só sejam carregados quando realmente necessários, **sob demanda**.
3. **Experiência de Usuário Otimizada**: O `defer` ajuda a **carregar recursos no momento certo**, o que pode resultar em uma navegação mais ágil e responsiva.

### Conclusão

O `defer` no Angular 17 é uma funcionalidade que oferece maior controle sobre o **lazy loading** de componentes e módulos, permitindo que você adie o carregamento de recursos até o momento em que realmente forem necessários. Isso pode levar a um **melhor desempenho** e a uma **experiência mais ágil** para os usuários, tornando o carregamento inicial da aplicação mais rápido e eficiente.

---

---

---

## DURANTE A AULA, FIQUEI COM DÚVIDAS EM RELAÇÃO AO CÓDIGO DO PROFESSOR

Explica esse código

```tsx
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LazzyComponent } from './lazzy.component';

const routes: Routes = [{ path: '', component: LazzyComponent }];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class LazzyRoutingModule { }
```

Esse código define um módulo de roteamento no Angular, mais especificamente, um **módulo de roteamento para carregamento preguiçoso (lazy loading)**. Vamos explicar as partes do código para que você entenda claramente o que ele faz.

### Explicação do Código

```tsx
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LazzyComponent } from './lazzy.component';

const routes: Routes = [{ path: '', component: LazzyComponent }];

```

1. **Importação de Dependências**:
    - **`@angular/core`**: Importa o decorador `NgModule`, que permite criar módulos no Angular.
    - **`@angular/router`**: Importa `RouterModule` (para configurar o roteamento) e `Routes` (tipo que representa as rotas da aplicação).
    - **`LazzyComponent`**: Importa o componente `LazzyComponent`, que será exibido quando o usuário acessar a rota definida neste módulo.
2. **Definição das Rotas**:
    
    ```tsx
    const routes: Routes = [{ path: '', component: LazzyComponent }];
    
    ```
    
    - **`Routes`** é uma matriz de objetos que define as rotas da aplicação.
    - **`path: ''`**: Define a rota para a raiz do módulo (ou seja, quando o caminho da URL for vazio, ele carregará o `LazzyComponent`).
    - **`component: LazzyComponent`**: Especifica que, ao acessar essa rota, o Angular exibirá o `LazzyComponent`.

### Parte do Módulo Angular

```tsx
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LazzyRoutingModule { }

```

1. **`@NgModule`**:
    - Esse decorador define um módulo no Angular. Ele configura o módulo que contém o roteamento para o `LazzyComponent`.
2. **`imports: [RouterModule.forChild(routes)]`**:
    - **`RouterModule.forChild(routes)`**: O método `forChild` é utilizado para definir rotas em módulos que serão carregados de forma preguiçosa (lazy-loaded). Ele configura o roteamento apenas para o módulo específico (nesse caso, o módulo `LazzyRoutingModule`), ao contrário do `RouterModule.forRoot(routes)`, que é usado para configurar as rotas principais na aplicação.
    - Esse método indica que as rotas definidas em `routes` são específicas para este módulo e serão configuradas apenas quando o módulo for carregado.
3. **`exports: [RouterModule]`**:
    - O `RouterModule` é exportado para garantir que ele possa ser usado em outros módulos que importem o `LazzyRoutingModule`. Isso é necessário para que as rotas definidas dentro do módulo de roteamento possam ser aplicadas ao carregar o módulo.

### O que esse código faz?

- **Configuração de Roteamento para um Módulo Carregado Preguiçosamente**:
    - Esse código define o módulo de roteamento para um componente específico (neste caso, `LazzyComponent`).
    - O módulo de roteamento será configurado usando `forChild`, que é usado quando você quer definir as rotas para um **módulo preguiçosamente carregado**.
    - O componente `LazzyComponent` será carregado quando o usuário acessar a rota associada (neste caso, quando o caminho da URL for vazio dentro do módulo).

### Como isso se encaixa em um Módulo com Lazy Loading?

Este código seria parte de um módulo que é carregado de forma preguiçosa, por exemplo, quando você tem uma rota principal que usa o **lazy loading** para carregar esse módulo. A configuração de rotas seria algo assim no arquivo principal de rotas da aplicação (`app-routing.module.ts` ou `app.config.ts`):

```tsx
const routes: Routes = [
  {
    path: 'lazy', // Caminho da rota principal
    loadChildren: () => import('./lazzy/lazzy.module').then(m => m.LazzyModule) // Carrega o módulo LazzyModule de forma preguiçosa
  }
];

```

### Resumo:

- Esse código define um módulo de roteamento para um componente chamado `LazzyComponent`.
- Ele usa `RouterModule.forChild(routes)` para configurar as rotas de forma preguiçosa, o que significa que o módulo de roteamento será carregado somente quando necessário.
- A rota está configurada para que, quando a URL corresponder ao caminho vazio (`''`), o `LazzyComponent` seja exibido.
- Esse código seria utilizado em conjunto com o lazy loading, onde o módulo que contém esse roteamento seria carregado preguiçosamente, por exemplo, quando o usuário acessar uma rota específica na aplicação.