# CRIAÇÃO FORMULÁRIOS REATIVOS

🏆 DOCUMENTAÇÃO ANGULAR SOBRE FORMULÁRIOS REATIVOS

[Angular Formulários reativos](https://angular.dev/guide/forms/reactive-forms)


## EXISTE DOIS TIPOS DE FORMULÁRIOS, SÃO ELES:

🏆
- **Template-Driven Forms**
- **Reactive Forms**.

### PRINCIPAIS DIFERENÇAS ENTRE ELES:

- No caso dos Template-Driven a lógica é implementada no template do componente (HTML)
- Template-Driven Forms funcionam de forma assíncrona
- Para usar o Template-Driven Forms é necessário importar o módulo FormsModule
- No caso dos Reactive Forms a lógica fica, geralmente, no componente e as suas validações são feitas programaticamente com TypeScript.
- Reactive Forms funciona de forma síncrona
- Para usar Reactive Forms deverá ser importado o módulo ReactiveFormsModule


---

## FORMULÁRIO REATIVO

> A gente conta que é um formulário reativo quando tem um FORMBUILDER
> 

📌 SIGNFICADO DE REATIVO NO ANGULAR

- Reatividade no Angular refere-se à **capacidade do framework de atualizar automaticamente a interface do usuário (UI) sempre que ocorrem mudanças nos dados subjacentes**.
    
    [O que é Reatividade no Angular](https://pt.linkedin.com/pulse/o-que-%C3%A9-reatividade-angular-elton-andrade)
    

- No Angular, reativo refere-se a uma **abordagem de programação que permite criar formulários e aplicações web dinâmicas e responsivas**

## O QUE É FORM BUILDER?

🏆 Documentação do FormBuilder 

[Angular Documentação FormBuilder](https://angular.dev/api/forms/FormBuilder)

---


🏆 Sempre que formos trabalhar com formulários reativos devemos importar o ReactiveFormsModule


> FormBuilder é a biblioteca que configura o usuário
> 

📌 Quando eu coloco null é porque ele vai começar com vazio

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/Formularios1.png" />


📌 Realizando validação no botão do formulário

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/formularios2.png" />


> Ele só vai validar o botão se o formulário for valido
> 

📌 Eu consigo ter o controle durante a digitação dos valores do formulário, se eu usar outro tipo de formulário eu só vou ter a validação depois que eu apertar o botão submit


## EXPLICAÇÃO DO @IF dentro do HTMl

O trecho de código fornecido é parte de um formulário em Angular utilizando o Angular Material. Vou explicar linha por linha para que você compreenda todos os detalhes e o funcionamento dessa estrutura.

### 1. `<mat-form-field class="full-width">`

- **`<mat-form-field>`**: Esse é um componente do Angular Material que fornece uma estrutura estilizada para campos de entrada (inputs). Ele é usado para envolver os elementos do formulário e fornecer um design consistente, incluindo recursos como labels flutuantes, validação de erros e outras funcionalidades visuais.
- **`class="full-width"`**: Isso é uma classe CSS personalizada (ou talvez do seu projeto) que provavelmente aplica um estilo de largura completa para o campo. Ou seja, o campo de entrada ocupará toda a largura disponível.

### 2. `<input matInput placeholder="Email" formControlName="email">`

- **`<input>`**: Este é o campo de entrada padrão HTML. Aqui ele é utilizado dentro de um formulário reativo, com Angular Material.
- **`matInput`**: Este é um diretiva do Angular Material que aplica o estilo Material Design ao campo de entrada, como bordas arredondadas, animações de foco, entre outros. Ele é necessário para que o input tenha o estilo do Material.
- **`placeholder="Email"`**: Esse é o texto de dica que aparecerá dentro do campo de entrada quando ele estiver vazio, indicando ao usuário que tipo de dado ele deve inserir.
- **`formControlName="email"`**: Esta diretiva é fundamental para os formulários reativos em Angular. Ela vincula este campo de entrada ao controle de formulário `email` no seu `FormGroup`. Ou seja, ele vai associar o valor digitado no campo `email` ao controle `email` do seu `FormGroup`.

### 3. A condicional `@if (addressForm.controls['email'].hasError('required')) { ... }`

Vou explicar como isso funciona com a sintaxe correta:

- **`ngIf="addressForm.controls['email'].hasError('required')"`**: Essa é a diretiva estrutural `ngIf`, que renderiza o conteúdo apenas quando a condição for verdadeira.
    - **`addressForm.controls['email']`**: Isso acessa o controle `email` dentro do seu `FormGroup` chamado `addressForm`.
    - **`.hasError('required')`**: Esse método verifica se o controle `email` tem um erro de validação do tipo `'required'`. Ou seja, ele verifica se o campo foi deixado vazio, já que `'required'` é uma validação comum para garantir que o campo não seja nulo ou indefinido.
- **`<mat-error>`**: Esse é um componente do Angular Material que exibe uma mensagem de erro estilizada quando ocorre uma falha de validação, como um campo obrigatório que não foi preenchido.
- **Mensagem de erro**: A mensagem exibida será "Email é <strong>obrigatório</strong>", e o texto **"obrigatório"** estará em negrito por conta da tag `<strong>`.

### Resumo do fluxo

1. O `<input matInput>` é utilizado para capturar o valor do "Email" no formulário.
2. O `formControlName="email"` liga este campo ao controle `email` dentro do `FormGroup` (presumivelmente chamado `addressForm`).
3. A validação de erro é verificada dentro do template utilizando `ngIf`. Se o controle `email` tiver o erro `'required'` (ou seja, se o campo estiver vazio e for obrigatório), o erro será mostrado.
4. Se a condição for verdadeira (o campo de email estiver vazio e for obrigatório), o componente `<mat-error>` exibirá a mensagem "Email é obrigatório", com o texto "obrigatório" em negrito.

## DÚVIDAS QUE FORAM SURGINDO DURANTE A AULA E EU FUI PESQUISAR.

### Diferença de FormBuild e FormGroup

[Diferença entre FormBuild e FormGroup | Fórum Alura](https://cursos.alura.com.br/forum/topico-diferenca-entre-formbuild-e-formgroup-260933)

[Exploring the Differences Between FormGroup and FormBuilder in Angular](https://medium.com/@edelcustodiofrias/exploring-the-differences-between-formgroup-and-formbuilder-in-angular-222bb192ece0)

### Reatividade no Angular

[Pensando Reativamente](https://medium.com/@richardleecba/pensando-reativamente-91361cfdccc5)

### O que é Reactive forms Angular

📌 **Pensa como se FormGroup fosse um grupo de FormsControls e cada FormControl é uma propriedade.**

[O que é Reactive Forms - Angular](https://vidafullstack.com.br/angular/o-que-e-reactive-forms-angular/)

### Como criar formulários Reactive no Angular

[Como criar formulários do tipo Reactive Forms com Angular - Fábrica de Código](https://www.fabricadecodigo.com/criar-formulario-reactive-forms)

### Como Criar formulário dinâmico em Angular

[Como criar um formulário dinâmico - Angular - Site console.log](https://consolelog.com.br/como-criar-um-formulario-dinamico-angular/)

### Qual é a diferença entre formControlName e FormControl?

[What is the difference between formControlName and FormControl?](https://stackoverflow.com/questions/40171914/what-is-the-difference-between-formcontrolname-and-formcontrol)

📌 A principal diferença entre formControlName e FormControl no Angular é que

**formControlName aponta para um dos controles criados, enquanto FormControl é um elemento fundamental do Angular Forms**

- **formControlName** Aponta para um dos controles criados, como "nome", "endereco", "email" ou "senha".
- **FormControl** Representa um campo de entrada do usuário e é responsável por rastrear o valor, o estado de validação e o estado de interação do campo.

### Formulários reativos compartilhados em Angular

[Criando formulários reativos compartilhados com Angular.](https://www.dio.me/articles/criando-formularios-reativos-compartilhados-com-angular)

### Formulário Reactive vs Formulário normal

[Reactive vs. Template Driven | Fórum Alura](https://cursos.alura.com.br/forum/topico-reactive-vs-template-driven-324533)

### Como aplicar validações em formulários reativos em Angular

[Como aplicar validação em formulários reativos no Angular? | Alura](https://www.alura.com.br/artigos/como-aplicar-validacao-formularios-reativos-angular)

### Form builder vs Form Control e Form group

[Angular form builder vs form control and form group](https://stackoverflow.com/questions/56015702/angular-form-builder-vs-form-control-and-form-group)

---

## CONCLUSÃO APÓS MUITAS PESQUISAS

Em Angular, tanto o `FormBuilder` quanto o `FormGroup` são usados para criar e manipular formulários reativos, mas desempenham papéis diferentes. Vamos explicar cada um:

### 1. **FormGroup**

`FormGroup` é uma classe que representa um grupo de controles de formulário em Angular. Ele é usado para agrupar múltiplos `FormControl` (ou outros `FormGroup`s) e fornecer funcionalidades de validação e controle de status para todo o grupo de controles.

### Exemplo de uso de `FormGroup`:

```tsx
import { FormGroup, FormControl } from '@angular/forms';

export class ExemploComponent {
  meuFormulario = new FormGroup({
    nome: new FormControl(''),
    email: new FormControl('')
  });
}

```

No exemplo acima:

- Criamos um `FormGroup` chamado `meuFormulario`.
- Dentro dele, adicionamos dois `FormControl`s: `nome` e `email`.

### 2. **FormBuilder**

`FormBuilder` é uma classe que fornece métodos convenientes para criar instâncias de `FormGroup`, `FormControl` ou `FormArray`. Ele é basicamente uma forma mais simplificada e concisa de construir formulários reativos. O `FormBuilder` é muito útil quando você precisa criar formulários complexos, pois ele facilita a sintaxe e reduz a repetição de código.

### Exemplo de uso de `FormBuilder`:

```tsx
import { FormBuilder, FormGroup } from '@angular/forms';

export class ExemploComponent {
  meuFormulario: FormGroup;

  constructor(private fb: FormBuilder) {
    this.meuFormulario = this.fb.group({
      nome: [''],
      email: ['']
    });
  }
}

```

Aqui:

- Usamos o `FormBuilder` no construtor para criar um `FormGroup`.
- A função `group()` do `FormBuilder` é usada para criar o grupo de controles de forma mais compacta e legível.

### Diferenças principais

- **Sintaxe**: O `FormBuilder` fornece uma maneira mais concisa de criar formulários, enquanto o `FormGroup` exige mais código para adicionar controles de forma manual.
- **Convenção**: O `FormBuilder` é utilizado para criar formulários de maneira mais fácil e reduzida, enquanto o `FormGroup` é a estrutura principal para agrupar controles de formulário. O `FormBuilder` é frequentemente usado com `FormGroup` para simplificar a criação de formulários.

### Conclusão

- **`FormGroup`**: Classe que agrupa controles de formulário e gerencia seu estado e validações.
- **`FormBuilder`**: Serviço que simplifica a criação de `FormGroup` e outros controles de formulário, tornando o código mais limpo e conciso.

Você pode usar o `FormBuilder` para construir instâncias de `FormGroup` de maneira mais fácil, mas o `FormGroup` é o tipo que você está realmente usando para gerenciar o formulário.

---

## O QUE É A PROPRIEDADE CONTROLS DO FORMGROUP?

A propriedade `controls` do `FormGroup` em Angular é um objeto que contém todos os controles de formulário (como `FormControl`, `FormGroup` ou `FormArray`) associados a esse grupo. Ela permite acessar e manipular esses controles diretamente.

Quando você cria um `FormGroup`, você adiciona múltiplos controles a ele, e esses controles ficam armazenados dentro da propriedade `controls`. Cada controle é acessível pelo seu nome ou chave, que corresponde ao nome dado a cada controle no grupo.

### Exemplo básico

Considerando o seguinte exemplo:

```tsx
import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-exemplo',
  templateUrl: './exemplo.component.html',
})
export class ExemploComponent {
  meuFormulario = new FormGroup({
    nome: new FormControl(''),
    email: new FormControl('')
  });

  acessarControles() {
    console.log(this.meuFormulario.controls['nome']); // Acessa o controle 'nome'
    console.log(this.meuFormulario.controls['email']); // Acessa o controle 'email'
  }
}

```

Aqui:

- Criamos um `FormGroup` com dois controles: `nome` e `email`.
- Podemos acessar os controles do `FormGroup` diretamente através da propriedade `controls`.

### Como funciona a propriedade `controls`?

- **Estrutura**: A propriedade `controls` é um objeto de chave-valor, onde cada chave é o nome do controle e o valor é o próprio controle (como um `FormControl`, `FormGroup` ou `FormArray`).
    
    No exemplo acima:
    
    - `meuFormulario.controls['nome']` retorna o `FormControl` associado ao campo "nome".
    - `meuFormulario.controls['email']` retorna o `FormControl` associado ao campo "email".
- **Acessando os controles**: Você pode acessar qualquer controle dentro de um `FormGroup` utilizando a chave correspondente, como mostrado acima, ou através de um `for` para iterar sobre todos os controles do grupo.

### Exemplo de acesso a todos os controles

```tsx
export class ExemploComponent {
  meuFormulario = new FormGroup({
    nome: new FormControl(''),
    email: new FormControl('')
  });

  acessarTodosControles() {
    for (const controle in this.meuFormulario.controls) {
      if (this.meuFormulario.controls.hasOwnProperty(controle)) {
        console.log(controle, this.meuFormulario.controls[controle]);
      }
    }
  }
}

```

Neste exemplo:

- Usamos um loop `for...in` para iterar sobre os nomes dos controles dentro do `FormGroup`.
- Para cada controle, acessamos o `FormControl` correspondente dentro de `meuFormulario.controls`.

### Principais usos da propriedade `controls`

1. **Acesso direto aos controles**: Você pode acessar qualquer controle individualmente, como mostrado, para manipular seu valor, validar ou fazer alterações dinâmicas.
2. **Validação**: A propriedade `controls` é útil para validar ou verificar o status de cada controle de forma individual.
3. **Manipulação de dados**: Com a propriedade `controls`, você pode atualizar os valores dos controles ou configurar novas propriedades programaticamente.

### Conclusão

A propriedade `controls` de um `FormGroup` em Angular é um objeto onde você pode acessar e manipular diretamente todos os controles de um formulário. Ela fornece uma maneira poderosa e flexível de interagir com os dados do formulário e controlar seu comportamento.


## qual a diferença entre formControl e formControlName?

Em Angular, tanto o `FormControl` quanto o `FormControlName` estão relacionados a formulários reativos (Reactive Forms), mas são usados em contextos diferentes e têm finalidades específicas. Vamos ver a diferença entre eles:

### 1. **FormControl**

O `FormControl` é uma classe que representa um único controle de formulário em Angular. Ele é usado para gerenciar o estado e o valor de um campo de entrada, como um `input`, dentro de um formulário reativo.

#### Características do `FormControl`:
- **Valor e estado**: Ele contém o valor atual do campo, o status de validação, e outras informações como erros e status de `touched` ou `dirty`.
- **Criado diretamente no código**: O `FormControl` é instanciado no código TypeScript, geralmente dentro de um `FormGroup` ou `FormArray`, e pode ser associado a um campo de formulário.

#### Exemplo de uso de `FormControl`:

```typescript
import { FormControl, FormGroup } from '@angular/forms';

export class ExemploComponent {
  meuFormulario = new FormGroup({
    nome: new FormControl(''),  // Criando o FormControl diretamente
  });
}
```

Aqui:
- Criamos um `FormControl` para o campo `nome` com um valor inicial de uma string vazia.
- O `FormControl` é parte de um `FormGroup`, mas pode também ser usado de forma independente.

### 2. **FormControlName**

O `FormControlName` é uma diretiva usada em templates HTML. Ele é utilizado para associar um controle de formulário (`FormControl`) a um campo de entrada no formulário HTML. Ou seja, você utiliza o `FormControlName` para vincular o `FormControl` do TypeScript ao campo de entrada HTML.

#### Características do `FormControlName`:
- **Associação no template**: Ele faz a conexão entre o controle de formulário no código (no `FormGroup`) e o campo de entrada no HTML.
- **Apenas em formulários reativos**: O `FormControlName` só é usado dentro de formulários reativos e precisa de um `FormGroup` associado no componente.

#### Exemplo de uso de `FormControlName`:

```html
<form [formGroup]="meuFormulario">
  <mat-form-field>
    <input matInput placeholder="Nome" formControlName="nome"> <!-- FormControlName -->
  </mat-form-field>
</form>
```

Aqui:
- **`formControlName="nome"`**: O `FormControlName` associa o campo de entrada HTML ao controle de formulário chamado `nome` no `FormGroup` (`meuFormulario`) no componente.

### Diferenças principais:

| **Aspecto**             | **`FormControl`**                                           | **`FormControlName`**                                        |
|-------------------------|-------------------------------------------------------------|--------------------------------------------------------------|
| **Uso**                 | Usado no código TypeScript para criar e gerenciar controles de formulário. | Usado no template HTML para associar um campo de entrada a um `FormControl`. |
| **Contexto**            | Parte do `FormGroup` ou `FormArray` no TypeScript.          | Diretiva usada no template HTML para vincular ao campo de entrada. |
| **Exemplo de uso**      | `new FormControl('valor inicial')`                         | `<input formControlName="nome">`                              |
| **Objetivo**            | Criar e controlar o estado do campo de formulário no código. | Associar o controle de formulário com o campo de entrada no HTML. |

### Resumo:
- **`FormControl`** é utilizado para criar e gerenciar controles de formulário no código TypeScript, enquanto o **`FormControlName`** é usado para associar esses controles a campos de entrada no template HTML, dentro de um formulário reativo.


## ANALOGIA FORMULARIOS REATIVOS EM ANGULAR

Uma outra analogia útil para entender **formularios reativos** em Angular pode ser a de um **controle remoto de TV**. Aqui está como podemos associar os componentes de um formulário reativo a essa analogia:

### **Formulários Reativos como um Controle Remoto de TV**

1. **FormGroup = Controle Remoto**
   - O **FormGroup** é como o **controle remoto da TV**. Ele é a "central de comando", onde você controla todas as funções do formulário. Assim como um controle remoto pode controlar várias TVs ou dispositivos ao mesmo tempo, o **FormGroup** gerencia múltiplos controles de formulário (os campos) de uma vez. No controle remoto, você tem botões para diferentes funções, como aumentar o volume ou trocar o canal; no **FormGroup**, você tem **controles** que gerenciam os valores e estados dos campos de formulário.

2. **FormControl = Botões do Controle Remoto**
   - Cada **FormControl** seria um **botão do controle remoto**. Cada botão tem uma função específica, como aumentar o volume, mudar o canal ou ligar/desligar a TV. De maneira semelhante, cada **FormControl** tem uma responsabilidade única, como controlar o valor de um campo de texto (exemplo: nome, email) ou de uma caixa de seleção. Assim como pressionar um botão altera a função da TV, alterar o valor de um **FormControl** muda o estado ou o valor do campo no formulário.

3. **FormControlName = Canal Selecionado**
   - O **FormControlName** é como o **canal selecionado** no controle remoto. Quando você pressiona um botão para trocar de canal, ele se conecta a um canal específico, e a TV passa a exibir o conteúdo daquele canal. Da mesma forma, o **FormControlName** conecta o campo do **FormControl** com o **campo de entrada HTML** no template. Quando você configura um `formControlName`, você está dizendo ao formulário qual controle de formulário gerenciará aquele campo.

4. **Observables = Tela da TV**
   - Os **Observables** podem ser comparados com a **tela da TV**, que exibe as atualizações em tempo real. Assim como a tela da TV muda constantemente com as imagens e vídeos que você está assistindo, os **Observables** monitoram as mudanças nos valores dos controles do formulário em tempo real. Por exemplo, se o valor de um **FormControl** for alterado (como digitar no campo de texto), isso é refletido imediatamente no **Observable**, assim como a tela da TV reflete as mudanças de canal ou conteúdo.

5. **Validação = Funcionalidades de Segurança da TV (Controle de Volume, Bloqueio de Canal)**
   - As **validações** em um formulário reativo (como verificar se o campo de email está no formato correto ou se o campo obrigatório foi preenchido) são como as **funcionalidades de segurança** da TV. Por exemplo, uma TV pode ter um bloqueio de canal ou um limite de volume para não permitir que algo aconteça sem restrições. Da mesma forma, as **validações** no formulário **impõem regras** que o valor do campo deve atender para ser considerado **válido** (semelhante a um botão que, se pressionado incorretamente, não permite a alteração até que as condições sejam atendidas).

### Resumo da Analogias:

- **FormGroup** = **Controle remoto** (centraliza e gerencia os **FormControls**).
- **FormControl** = **Botões do controle remoto** (controlam valores específicos de campos, como um botão de volume ou canal).
- **FormControlName** = **Canal selecionado** (associa um controle específico do formulário ao campo HTML).
- **Observables** = **Tela da TV** (mostra as atualizações em tempo real, refletindo as mudanças de valores).
- **Validações** = **Funcionalidades de segurança da TV** (impõem regras e restrições para garantir que o valor esteja correto, como um bloqueio de canal ou volume).

Com essa analogia, podemos entender como **formularios reativos** em Angular funcionam de maneira integrada e dinâmica, controlando e monitorando mudanças em tempo real, e assegurando que tudo siga as regras definidas.