# VALIDAÇÃO DOS DADOS

> Quando a gente faz a digitação nos campos do formulário é possível digitar qualquer coisa, nessa aula será feita a validação de email para verificar se o usuário está digitando um @
> 

> É possível inclusive realizar a validação de “Confirmar senha”
> 

### Dicas de pesquisas para se aprofundar em formulários reativos:

“Formulários reativos em Angular”

“Validações de formulários reativos em Angular”

---

## Criando validação para email

## 1. PRIMEIRO VAMOS NO ARQUIVO TYPESCRIPT DO COMPONENTE QUE DESEJAMOS CRIAR A VALIDAÇÃO E CRIAR A SEGUINTE VARIAVEL QUE VAI RECEBER UM CONTROLS ‘EMAIL’

```tsx
email = this.addresForm.controls['email']
```

## 2. VAMOS INCLUIR O ‘Validators.email’ NO ARRAY DE VALIDAÇÕES

## 3. VAMOS CRIAR UM MÉTODO getErrorMessage()

```tsx
  // Estou verificando para mostrar na tela que o email não é valido
  getErrorMessage(){
    if(this.email.hasError('required')){
      // se o email tem erro eu vou retornar a mensagem 
      return 'O email é obrigatório'
    } else {

      return this.email.hasError('email')? 'Você deve preencher um valor para o email válido!' : ''
    }
  }
```

## 4. INSERIR ESSE MÉTODO NO TEMPLATE HTML

```html
   <div class="row">
        <div class="col">
          <mat-form-field class="full-width">
            <input matInput placeholder="Email" formControlName="email">
            @if (email.invalid) {
            <mat-error>{{getErrorMessage()}}</mat-error> <!-- A expressão completa exibe o <mat-error> somente se o campo email for inválido e tocado. -->
            }
          </mat-form-field>
        </div>
      </div>
```

### Método invalid

O método invalid no Angular é uma propriedade de um FormControl, FormGroup ou FormArray dentro de formulários reativos. Ele verifica se o controle de formulário é inválido com base nas validações definidas para o controle. Se o controle tiver algum erro de validação, a propriedade invalid será true, caso contrário, será false.

Explicando o invalid:
invalid é uma propriedade de leitura de um controle de formulário que retorna um valor booleano.
true: Se o formulário (ou controle) não passar nas validações.
false: Se o formulário (ou controle) passar nas validações.

true: O controle falhou na validação.
false: O controle passou em todas as validações e é válido.

> Estou fazendo a verificação com o if, se o if for false, meu método será executado
>

> Se ele for true ele vai retornar essa mensagem → 'Você deve preencher um valor para o email válido!'
> 

> Se for falso ele vai retornar vazio → ‘’
> 

## Conclusão

> Eu criei o método getErrorMessage() e atribui o valor do email do formularia a variavel 'email' e faço a validação para saber se ela está true ou falsa

## MÉTODO EXPLICADO DETALHADAMENTE - getErrorMessage()

Esse método **`getErrorMessage()`** serve para verificar os **erros de validação** do campo `email` em um formulário reativo e **retornar uma mensagem de erro** personalizada, dependendo do tipo de erro que foi encontrado nesse campo.

Vamos entender o funcionamento do código linha por linha:

### Código:

```tsx
getErrorMessage() {
  if (this.email.hasError('required')) {
    // Se o campo 'email' tem erro de 'required' (obrigatório), retorna a mensagem
    return 'O email é obrigatório';
  } else {
    // Se o campo 'email' tem erro de 'email' (formato inválido), retorna a mensagem
    return this.email.hasError('email') ? 'Você deve preencher um valor para o email válido!' : '';
  }
}

```

### Explicação:

1. **`this.email.hasError('required')`**:
    - O **`hasError('required')`** verifica se o campo `email` está inválido por causa de uma **validação de obrigatoriedade**.
    - O `hasError` é um método que verifica se o controle do formulário possui um erro específico (passado como argumento), no caso, `'required'`.
    - Se o campo **`email`** não foi preenchido, ou seja, se o valor do controle for vazio e a validação `Validators.required` estiver ativa, então o método **`hasError('required')`** vai retornar `true`.
    
    **Exemplo de erro**: Se o campo de email estiver vazio e for obrigatório (validação `required`), a mensagem `'O email é obrigatório'` será retornada.
    
2. **`this.email.hasError('email')`**:
    - O **`hasError('email')`** verifica se o campo `email` contém um erro de **formato inválido** para um endereço de email (ou seja, se o valor não é um email válido).
    - A validação **`Validators.email`** verifica se o valor inserido corresponde a um formato válido de email.
    - Se o email não estiver no formato correto, o **`hasError('email')`** vai retornar `true`.
    
    **Exemplo de erro**: Se o usuário inserir um email inválido como `"test@com"`, a validação `email` vai falhar e a mensagem `'Você deve preencher um valor para o email válido!'` será exibida.
    
3. **Estrutura condicional**:
    - Se o controle `email` tem o erro `required`, a função retorna a mensagem `'O email é obrigatório'`.
    - Caso contrário, se o erro for `email` (ou seja, o formato do email está errado), ele retorna a mensagem `'Você deve preencher um valor para o email válido!'`.
    - Se não houver nenhum erro, o método **`return ''`** retorna uma string vazia, indicando que não há erro a ser exibido.

### Exemplo prático no Angular (formulário reativo):

Imaginando que temos um formulário reativo com um campo `email`, o código completo do componente ficaria assim:

### 1. **Componente TypeScript**:

```tsx
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {
  cadastroForm: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.cadastroForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]]
    });
  }

  // Método para retornar as mensagens de erro de validação do email
  getErrorMessage() {
    const email = this.cadastroForm.get('email');  // Acessa o controle 'email'

    if (email?.hasError('required')) {
      return 'O email é obrigatório';  // Se o campo email for obrigatório e estiver vazio
    } else {
      return email?.hasError('email') ? 'Você deve preencher um valor para o email válido!' : '';
    }
  }

  onSubmit(): void {
    if (this.cadastroForm.valid) {
      console.log('Formulário enviado com sucesso');
    }
  }
}

```

### 2. **Template HTML**:

```html
<form [formGroup]="cadastroForm" (ngSubmit)="onSubmit()">
  <div>
    <label for="email">Email:</label>
    <input id="email" formControlName="email" />
    <div *ngIf="cadastroForm.get('email')?.touched && cadastroForm.get('email')?.invalid">
      <div *ngIf="cadastroForm.get('email')?.hasError('required')">
        O email é obrigatório.
      </div>
      <div *ngIf="cadastroForm.get('email')?.hasError('email')">
        Você deve preencher um valor para o email válido!
      </div>
    </div>
  </div>

  <button type="submit" [disabled]="cadastroForm.invalid">Enviar</button>
</form>

```

### Como funciona no HTML:

- **`formControlName="email"`**: O controle do formulário `email` é vinculado ao campo de entrada `<input>`.
- **`ngIf="cadastroForm.get('email')?.touched && cadastroForm.get('email')?.invalid"`**: A mensagem de erro só será exibida se o controle `email` for **tocado** (ou seja, o usuário interagiu com o campo) e estiver **inválido**.
- **Mensagem personalizada**: Usamos a função `getErrorMessage()` para determinar qual erro de validação mostrar ao usuário.

### Exemplo de funcionamento:

1. Se o usuário **deixar o campo de email vazio**, a mensagem `'O email é obrigatório'` será exibida.
2. Se o usuário preencher um **email inválido** (ex: `test@com`), a mensagem `'Você deve preencher um valor para o email válido!'` será exibida.
3. Se o campo for **válido**, nenhuma mensagem será mostrada.

### Resumo do que acontece:

- O método **`getErrorMessage()`** verifica os erros de validação do campo `email` e retorna uma mensagem personalizada com base no tipo de erro encontrado (`required` ou `email`).
- Ele usa o método **`hasError()`** para verificar se o campo tem o erro especificado, e dependendo disso, retorna a mensagem apropriada.

## O MESMO MÉTODO SÓ QUE UTILIZANDO APENAS IF ELSE (SEM OPERADOR TERNARIO)

### 1. **Componente TypeScript com `if` e `else`:**

```tsx
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {
  cadastroForm: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.cadastroForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]]
    });
  }

  // Método para retornar as mensagens de erro de validação do email
  getErrorMessage() {
    const email = this.cadastroForm.get('email');  // Acessa o controle 'email'

    if (email?.hasError('required')) {
      // Se o campo 'email' tiver erro de 'required' (campo obrigatório)
      return 'O email é obrigatório';
    } else {
      // Se o campo 'email' não tiver erro de 'required', verifica o erro de 'email' (formato inválido)
      if (email?.hasError('email')) {
        return 'Você deve preencher um valor para o email válido!';
      } else {
        // Se não houver erro
        return '';
      }
    }
  }

  onSubmit(): void {
    if (this.cadastroForm.valid) {
      console.log('Formulário enviado com sucesso');
    }
  }
}

```

### Como funciona o código agora?

1. **`if (email?.hasError('required'))`**:
    - Se o campo **`email`** estiver vazio e a validação de **`required`** (obrigatório) falhar, o método retorna a mensagem `'O email é obrigatório'`.
2. **`else`**:
    - Caso contrário, verificamos se o erro é de formato de **email** com **`email?.hasError('email')`**.
    - Se o erro for do tipo **email** (ou seja, o valor não for um email válido), a mensagem `'Você deve preencher um valor para o email válido!'` é retornada.
3. **`else` final**:
    - Se nenhum erro for encontrado (o email está válido), o método retorna uma string vazia (`''`), o que significa que não há erro a ser exibido.

### 2. **Template HTML:**

O template continua o mesmo, onde exibimos a mensagem de erro, se necessário, com base no estado do controle.

```html
<form [formGroup]="cadastroForm" (ngSubmit)="onSubmit()">
  <div>
    <label for="email">Email:</label>
    <input id="email" formControlName="email" />
    <div *ngIf="cadastroForm.get('email')?.touched && cadastroForm.get('email')?.invalid">
      <div *ngIf="cadastroForm.get('email')?.hasError('required')">
        O email é obrigatório.
      </div>
      <div *ngIf="cadastroForm.get('email')?.hasError('email')">
        Você deve preencher um valor para o email válido!
      </div>
    </div>
  </div>

  <button type="submit" [disabled]="cadastroForm.invalid">Enviar</button>
</form>

```

### Resumo:

Agora, o método **`getErrorMessage()`** usa **`if` e `else`** para verificar os erros:

- **Primeiro, ele verifica se o erro é de campo obrigatório** (`required`).
- **Depois, ele verifica se o erro é de formato de email** (`email`).
- Se não houver erros, ele retorna uma string vazia (`''`), indicando que o campo está válido.

Esse código segue a lógica do **`if`** e **`else`** de maneira clara e direta, sem o uso de operadores ternários.

---

## DÚVIDAS QUE SURGIRAM DURANTE A AULA

### Os campos do formControlName tem que ter o mesmo nome do formbuilder?

Sim, os **nomes** dos campos definidos com `formControlName` no HTML **precisam** corresponder exatamente aos **nomes dos controles** que você definiu no `FormBuilder` no TypeScript. O `formControlName` é utilizado para vincular um controle de formulário do tipo `FormControl` no TypeScript ao campo de entrada correspondente no HTML.

### Como funciona a correspondência entre `formControlName` e `FormBuilder`:

- No **TypeScript**, você define os controles do formulário dentro de um `FormGroup`, usando os nomes que deseja para os campos.
- No **HTML**, você usa a diretiva `formControlName` para associar os campos de entrada aos controles no `FormGroup` com o **mesmo nome**.

### Exemplo:

### 1. **Componente TypeScript:**

Aqui definimos um `FormGroup` no TypeScript com três campos: `nome`, `email` e `senha`.

```tsx
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {
  cadastroForm: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.cadastroForm = this.fb.group({
      nome: ['', [Validators.required, Validators.minLength(2)]],
      email: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit(): void {
    if (this.cadastroForm.valid) {
      console.log(this.cadastroForm.value); // Exibe os dados do formulário no console
    } else {
      console.log('Formulário inválido');
    }
  }
}

```

### 2. **Template HTML:**

No HTML, para cada campo de entrada, usamos a diretiva `formControlName` para associá-lo ao campo correspondente no `FormGroup` (definido com `FormBuilder`). O nome do campo no `formControlName` deve ser **idêntico** ao nome no `FormGroup`.

```html
<form [formGroup]="cadastroForm" (ngSubmit)="onSubmit()">
  <div>
    <label for="nome">Nome:</label>
    <input id="nome" formControlName="nome" />
    <div *ngIf="cadastroForm.get('nome').invalid && cadastroForm.get('nome').touched">
      Nome é obrigatório e deve ter pelo menos 2 caracteres.
    </div>
  </div>

  <div>
    <label for="email">Email:</label>
    <input id="email" formControlName="email" />
    <div *ngIf="cadastroForm.get('email').invalid && cadastroForm.get('email').touched">
      Email inválido.
    </div>
  </div>

  <div>
    <label for="senha">Senha:</label>
    <input type="password" id="senha" formControlName="senha" />
    <div *ngIf="cadastroForm.get('senha').invalid && cadastroForm.get('senha').touched">
      Senha é obrigatória e deve ter pelo menos 6 caracteres.
    </div>
  </div>

  <button type="submit" [disabled]="cadastroForm.invalid">Enviar</button>
</form>

```

### **Por que é necessário que os nomes coincidam?**

1. **Vinculação entre HTML e TypeScript**: O `formControlName` no HTML mapeia diretamente para o nome do controle de formulário no `FormGroup` (definido no TypeScript). Se o nome no HTML e no TypeScript não coincidir, o Angular não conseguirá associar o campo do formulário com o controle correspondente, o que resultará em um erro ou no comportamento inesperado do formulário.
2. **Gestão do estado**: O Angular usa os nomes dos controles para gerenciar o estado do formulário (como validações, valores e erro). Se os nomes não coincidirem, o Angular não conseguirá encontrar os controles corretos para aplicar as validações e acessar os valores corretamente.

### **Erros comuns ao não fazer a correspondência:**

- **Campo não encontrado**: O Angular não encontra o controle correspondente no `FormGroup` se o nome no HTML não coincidir com o nome do controle no TypeScript.
- **Validação não funciona**: Se o nome não corresponder, a validação do controle pode não ser aplicada corretamente.
- **Dados do formulário não são enviados corretamente**: O valor do controle pode não ser incluído na submissão do formulário se os nomes não coincidirem.

### Conclusão:

Sim, os nomes dos campos em **`formControlName`** **devem** ser **iguais** aos nomes dos controles definidos no **`FormGroup`** no **TypeScript**. Isso garante que o Angular possa associar corretamente os campos de entrada no HTML aos controles do formulário no TypeScript, permitindo que as validações e o gerenciamento do estado do formulário funcionem corretamente.

---

---

---

### O que é o hashError?

O **`hasError`** é um método de um **`FormControl`** no Angular que verifica se o controle de formulário possui um erro específico de validação. Ele retorna `true` se o erro estiver presente e `false` caso contrário.

---

---

---

### Como estou conseguindo usar o controls se eu não tenho importado o formGroup e somente o formBuilder?

A razão pela qual você está conseguindo usar o **`controls`** mesmo sem importar explicitamente o **`FormGroup`** é que o **`FormGroup`** é automaticamente incluído no **`FormBuilder`**. Isso ocorre porque o **`FormBuilder`** é uma **fábrica** (ou seja, um "construtor") que cria instâncias de **`FormGroup`**, **`FormControl`** e **`FormArray`** para você de forma simplificada.

### Como funciona o `FormBuilder` e o `FormGroup`:

Quando você usa o **`FormBuilder`** para criar um formulário, ele cria um **`FormGroup`** automaticamente. O **`FormGroup`** é a estrutura que contém os **controles de formulário** (`FormControl`), e a propriedade `controls` é uma parte do **`FormGroup`**.

### Explicando a importação:

- O **`FormBuilder`** é o que você importa diretamente, mas ele depende do **`FormGroup`** para funcionar.
- **`FormGroup`** é uma classe que é parte do pacote `@angular/forms`, e é **usada automaticamente** quando você cria um formulário com `FormBuilder`, mas você não precisa importá-la separadamente, porque ela já é acessível através da instância de `FormBuilder`.

### O que acontece por trás dos panos:

Quando você escreve algo como:

```tsx
this.cadastroForm = this.fb.group({
  nome: ['', Validators.required],
  email: ['', [Validators.required, Validators.email]]
});

```

O `FormBuilder` automaticamente cria um **`FormGroup`** para você. Isso significa que, em **`this.cadastroForm`**, você já tem uma instância de **`FormGroup`**, que contém a propriedade **`controls`** (com os controles de formulário que você definiu dentro do `group`).

### Não é necessário importar `FormGroup` explicitamente:

Você não precisa importar **`FormGroup`** diretamente se você está utilizando **`FormBuilder`** para criar seus formulários. O `FormBuilder` já faz essa parte do trabalho, e o Angular está configurado para permitir que você acesse os controles de um `FormGroup` mesmo sem importar explicitamente a classe.

### Exemplo de funcionamento:

Vamos detalhar um exemplo para ver o fluxo mais claro.

### Componente TypeScript:

```tsx
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {
  cadastroForm = this.fb.group({
    nome: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]]
  });

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    // Aqui, cadastroForm já é um FormGroup com controles 'nome' e 'email'
    console.log(this.cadastroForm.controls);  // Você consegue acessar controls diretamente
  }

  onSubmit(): void {
    if (this.cadastroForm.valid) {
      console.log(this.cadastroForm.value);  // Exibe os dados do formulário
    } else {
      console.log('Formulário inválido');
    }
  }
}

```

### O que ocorre aqui:

- **`this.fb.group({...})`**: O `FormBuilder` cria um **`FormGroup`** para você com os controles `nome` e `email`. Por isso, **`this.cadastroForm`** é automaticamente um `FormGroup` e tem a propriedade `controls`.
- **`this.cadastroForm.controls`**: Como o `FormBuilder` cria o `FormGroup` automaticamente, você pode acessar a propriedade `controls` sem precisar importar explicitamente a classe `FormGroup`. Os controles definidos no `group` são armazenados dentro dessa propriedade `controls`.

### Resumo:

- **O `FormBuilder` cria o `FormGroup` automaticamente** quando você usa o método `group()`.
- Você **não precisa importar o `FormGroup`** diretamente, pois ele já é usado de forma implícita ao criar o formulário com `FormBuilder`.
- **Os controles do formulário** ficam acessíveis através da propriedade `controls` do `FormGroup`, permitindo que você acesse o estado e o valor de cada controle individualmente.

Essa simplificação é um dos benefícios de usar o **`FormBuilder`**, que torna a criação e manipulação de formulários mais fácil e direta no Angular.

### O que é o controls em formBuilder

No contexto do `FormBuilder` no Angular, **`controls`** refere-se aos **controles de formulário** que são definidos dentro de um **`FormGroup`** ou **`FormArray`**. Esses controles são instâncias de `FormControl` que armazenam o valor de um campo de formulário e gerenciam o estado de validação desse campo.

### Detalhando o que são os **`controls`**:

Quando você usa o `FormBuilder` para criar um **`FormGroup`** (ou um **`FormArray`**), ele automaticamente cria **controles de formulário** (que são objetos `FormControl`) para cada campo ou controle dentro do grupo ou array. Esses controles são armazenados como **propriedades** do **`FormGroup`** e podem ser acessados através da propriedade **`controls`**.

### Exemplo:

Imagine que você tem um formulário com `nome` e `email`:

### Componente TypeScript usando `FormBuilder`:

```tsx
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {
  cadastroForm: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    // Criando o formulário com o FormBuilder
    this.cadastroForm = this.fb.group({
      nome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  // Método para acessar os controles diretamente
  acessarControles(): void {
    // Acessando os controles através da propriedade 'controls'
    console.log(this.cadastroForm.controls['nome']); // Exibe o controle 'nome'
    console.log(this.cadastroForm.controls['email']); // Exibe o controle 'email'
  }

  onSubmit(): void {
    console.log(this.cadastroForm.value); // Exibe os valores do formulário
  }
}

```

### Explicação:

- **`FormGroup`**: O `FormGroup` é uma coleção de controles de formulário (normalmente um conjunto de `FormControl`). Cada controle dentro do `FormGroup` é acessado através da propriedade `controls`.
- **`controls`**: A propriedade `controls` de um `FormGroup` contém todos os controles (que são instâncias de `FormControl`) que você definiu dentro do grupo. No exemplo acima, `controls['nome']` acessa o controle relacionado ao campo `nome`, e `controls['email']` acessa o controle relacionado ao campo `email`.
    
    Esses controles são objetos do tipo `FormControl` e possuem propriedades como:
    
    - **`value`**: O valor do campo.
    - **`valid`**: Um indicador booleano que mostra se o controle é válido ou não, baseado nas validações definidas.
    - **`invalid`**: Um indicador booleano que mostra se o controle é inválido.
    - **`touched`**: Indica se o controle foi tocado (usado) pelo usuário.
    - **`dirty`**: Indica se o controle foi alterado pelo usuário.
    - **`errors`**: Contém os erros de validação, caso existam.

### Acessando os controles:

Você pode acessar um controle diretamente usando o `controls` no `FormGroup` para ler ou manipular seu estado. Aqui está um exemplo de como acessar e manipular os controles:

```tsx
// Acessando o valor de um controle
const nomeValue = this.cadastroForm.controls['nome'].value;

// Verificando se o controle 'nome' é válido
const isNomeValid = this.cadastroForm.controls['nome'].valid;

// Verificando erros no controle 'email'
const emailErrors = this.cadastroForm.controls['email'].errors;

```

### Exemplo prático no template HTML:

No HTML, você pode associar diretamente os controles aos campos de entrada usando `formControlName`, mas também pode acessar e verificar o estado dos controles dentro do código TypeScript usando a propriedade `controls`.

```html
<form [formGroup]="cadastroForm" (ngSubmit)="onSubmit()">
  <div>
    <label for="nome">Nome:</label>
    <input id="nome" formControlName="nome" />
    <div *ngIf="cadastroForm.controls['nome'].invalid && cadastroForm.controls['nome'].touched">
      Nome é obrigatório.
    </div>
  </div>

  <div>
    <label for="email">Email:</label>
    <input id="email" formControlName="email" />
    <div *ngIf="cadastroForm.controls['email'].invalid && cadastroForm.controls['email'].touched">
      Email inválido.
    </div>
  </div>

  <button type="submit" [disabled]="cadastroForm.invalid">Enviar</button>
</form>

```

### Resumo:

- **`controls`** é uma propriedade de um **`FormGroup`** que armazena todos os controles de formulário (instâncias de `FormControl` ou `FormArray`) criados com o `FormBuilder`.
- Cada **controle** dentro de `FormGroup` pode ser acessado através de **`controls['nomeDoCampo']`**.
- Você pode usar a propriedade `controls` para acessar o estado e o valor dos campos de formulário programaticamente, além de verificar se estão válidos, se têm erros ou se foram tocados/alterados.

Essa estrutura é útil para quando você precisa manipular ou validar os campos de forma programática no TypeScript, além de ser fundamental para garantir que os campos do formulário estejam sendo gerenciados corretamente pelo Angular.

### O que significa o ? do lado de email no método  getErrorMessage()

O **`?`** ao lado de **`email`** no código é o **operador de encadeamento opcional** (ou **"optional chaining"**). Esse operador foi introduzido no JavaScript/TypeScript para facilitar o acesso a propriedades de objetos que podem ser `null` ou `undefined` sem gerar um erro.

### O que o `?.` faz?

O **`?.`** permite que você acesse uma propriedade ou método de um objeto de forma segura, **sem lançar um erro se o objeto for `null` ou `undefined`**. Se o valor da expressão à esquerda for `null` ou `undefined`, a execução é interrompida e **`undefined`** é retornado, em vez de lançar um erro.

### Exemplo no seu código:

```tsx
typescript
Copiar código
const email = this.cadastroForm.get('email'); // Acessando o controle 'email'
if (email?.hasError('required')) {  // Verifica se 'email' tem erro 'required'
  return 'O email é obrigatório';
}

```

Aqui, **`email?.hasError('required')`** significa:

1. **`email`**: Acessa o controle de formulário chamado `email`.
2. **`?.`**: Verifica se **`email`** não é `null` ou `undefined`. Se for `null` ou `undefined`, o código não tenta acessar o método **`hasError`** e retorna `undefined` (não lança um erro).
3. **`hasError('required')`**: Se **`email`** não for `null` ou `undefined`, ele chama o método **`hasError()`** para verificar se o campo `email` possui o erro de validação `'required'`.

### Caso sem o `?.`:

Se você não usasse o **`?.`**, o código poderia lançar um erro se o **`email`** fosse `null` ou `undefined`. Por exemplo:

```tsx
typescript
Copiar código
const email = this.cadastroForm.get('email');
if (email.hasError('required')) {  // Erro se 'email' for null ou undefined
  return 'O email é obrigatório';
}

```

Se **`this.cadastroForm.get('email')`** retornar `null` (por exemplo, se o controle não existir), o código acima lançaria um erro dizendo que **`hasError`** não pode ser chamado em `null` ou `undefined`.

### Exemplo prático com `?.`:

### Quando o valor é **não nulo** (válido):

```tsx
typescript
Copiar código
const email = { hasError: (error: string) => error === 'required' };  // Exemplo de objeto
console.log(email?.hasError('required'));  // Saída: true

```

### Quando o valor é **nulo**:

```tsx
typescript
Copiar código
const email = null;
console.log(email?.hasError('required'));  // Saída: undefined (sem erro)

```

### Resumo:

- O **`?.`** é o **operador de encadeamento opcional** que ajuda a evitar erros ao acessar propriedades ou métodos de objetos que podem ser `null` ou `undefined`.
- No seu caso, **`email?.hasError('required')`** verifica se o controle de formulário **`email`** existe e tem um erro de `required`, sem lançar um erro caso **`email`** seja `null` ou `undefined`.

---

---

---

### Explicação dessas linhas de código

```tsx
export class LoginComponent {
private fb = inject(FormBuilder);

addressForm = this.fb.group({

});
```

 

O código que você forneceu é parte de um componente do Angular, especificamente um componente chamado `LoginComponent`, que está utilizando o **Reactive Forms** para criar um formulário. Vamos detalhar o que cada parte do código significa:

### 1. **Definição da Classe do Componente**:

```tsx
export class LoginComponent {

```

Aqui, você está criando um componente chamado `LoginComponent`. Ele será responsável pela lógica da tela de login, onde provavelmente você terá um formulário com campos como e-mail, senha, etc.

### 2. **Injeção do `FormBuilder`**:

```tsx
private fb = inject(FormBuilder);

```

- **`inject(FormBuilder)`** é uma nova forma de injeção de dependências que foi introduzida no Angular a partir da versão 14. Essa abordagem substitui a forma tradicional de injeção via **constructor** (ex: `constructor(private fb: FormBuilder) {}`).
- O **`FormBuilder`** é um serviço fornecido pelo Angular para facilitar a criação de formulários reativos. Ele permite criar **`FormGroup`**, **`FormControl`**, e **`FormArray`** de forma mais simples.
- O **`private fb`** significa que você está criando uma propriedade privada chamada **`fb`** (abreviação de **FormBuilder**), que irá armazenar a instância do **`FormBuilder`** injetado.

### 3. **Criação do Formulário com `FormBuilder`**:

```tsx
addressForm = this.fb.group({});

```

- **`addressForm`** é uma variável que irá armazenar a instância do **`FormGroup`**, que é o tipo de estrutura para agrupar controles de formulário em Angular.
- **`this.fb.group({})`** cria um **`FormGroup`** vazio. Isso significa que, neste momento, o formulário não possui campos definidos. Se você fosse criar um formulário com campos como `email` e `senha`, o código ficaria assim:

```tsx
addressForm = this.fb.group({
  email: ['', [Validators.required, Validators.email]],
  password: ['', [Validators.required, Validators.minLength(6)]]
});

```

Neste caso, os campos **`email`** e **`password`** seriam controles dentro do **`FormGroup`**, e você aplicaria validadores a eles.

### Resumo do que o código faz:

- O código define um componente chamado **`LoginComponent`**.
- Ele utiliza o **`FormBuilder`** para criar um formulário, mas o formulário está vazio no momento (sem campos definidos dentro do **`FormGroup`**).
- A injeção de dependência do **`FormBuilder`** é feita via **`inject()`**, que é uma forma moderna e recomendada no Angular 14+.

Esse é um esqueleto básico para um formulário reativo. Para completar o formulário de login, você adicionaria campos dentro do **`FormGroup`** como nome de usuário, senha, etc., e também validadores para esses campos.

---

---

---

### fb.group significa o que?

 Ao usar **`fb.group()`**, você está **criando um `FormGroup`** com a ajuda do **`FormBuilder`**. No entanto, é importante entender as diferenças entre o **`FormBuilder`** e o **`FormGroup`**.

### Explicando o que acontece com `fb.group()`:

- **`FormBuilder`** é um serviço do Angular utilizado para simplificar a criação de formulários reativos. Ele não cria o formulário diretamente, mas cria instâncias de **`FormGroup`**, **`FormControl`** e **`FormArray`**. O **`FormGroup`** é o contêiner que agrupa os controles de formulário.
- **`FormGroup`** é uma estrutura que contém um conjunto de controles de formulário (como **`FormControl`**), que representam os campos individuais do formulário.

### Exemplo de uso:

Quando você escreve o código:

```tsx
addressForm = this.fb.group({
  email: ['', [Validators.required, Validators.email]],
  password: ['', [Validators.required, Validators.minLength(6)]]
});

```

Você está fazendo o seguinte:

1. **`this.fb`**: Isso é uma instância do **`FormBuilder`**, que foi injetado na classe.
2. **`this.fb.group({})`**: Aqui, você está chamando o método **`group()`** do **`FormBuilder`** para criar um **`FormGroup`**.
    - O método **`group()`** aceita um objeto de chaves e valores, onde:
        - As chaves são os nomes dos campos do formulário (neste caso, `email` e `password`).
        - Os valores são arrays, onde o primeiro item é o valor inicial do campo (normalmente uma string vazia `''`), e o segundo item são os **validadores** (como `Validators.required` ou `Validators.email`).

### O que é **`FormBuilder`** e **`FormGroup`**?

- **`FormBuilder`**: É uma classe que ajuda a criar facilmente formulários no Angular. Ele fornece métodos como `group()`, `control()`, e `array()` para facilitar a criação de grupos de controles, controles individuais e arrays de controles de formulário.
- **`FormGroup`**: É um objeto que representa um conjunto de **`FormControl`**. O **`FormGroup`** é usado para agrupar controles que pertencem a um mesmo formulário. Ele mantém o estado e a validação de cada controle dentro dele.

### Exemplo completo com `FormBuilder` e `FormGroup`:

```tsx
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(private fb: FormBuilder) {
    // Usando o FormBuilder para criar um FormGroup com os controles 'email' e 'password'
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      console.log(this.loginForm.value); // Mostra os dados do formulário
    } else {
      console.log('Formulário inválido');
    }
  }
}

```

### Resumo:

- **`fb.group()`** é usado para **criar um `FormGroup`** usando o **`FormBuilder`**.
- O **`FormBuilder`** simplifica a criação de formulários reativos no Angular.
- O **`FormGroup`** agrupa controles individuais (**`FormControl`**) e os valida.

Portanto, **`fb.group()`** não cria um **`FormBuilder`**, mas cria um **`FormGroup`** que pode conter vários controles de formulário, e você usa o **`FormBuilder`** para ajudar a criar esse **`FormGroup`** de maneira mais simples.

---

---

---

### Criando formulários utilizando somente FormBuilder

Para criar um formulário reativo no Angular utilizando **somente** o **`FormBuilder`** sem usar diretamente a instância de **`FormGroup`** no código, você ainda precisa usar o **`FormBuilder`**, mas de forma explícita, sem definir a estrutura de `FormGroup` diretamente.

Vamos criar o mesmo exemplo de formulário de login, mas utilizando o **`FormBuilder`** de maneira mais explícita:

### Exemplo com **`FormBuilder`**:

No Angular, o **`FormBuilder`** é utilizado para criar instâncias de **`FormGroup`** e **`FormControl`**. Quando você chama **`this.fb.group()`**, o **`FormBuilder`** cria um **`FormGroup`** automaticamente. O **`FormBuilder`** facilita o processo de criação de formulários, mas ele ainda está por trás da criação do **`FormGroup`**.

Aqui está como você pode usar **somente o `FormBuilder`** para criar um formulário reativo:

### Código:

```tsx
import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms'; // Importando FormBuilder e Validators

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  loginForm = this.fb.group({
    // Criando o FormGroup com os controles diretamente no FormBuilder
    email: ['', [Validators.required, Validators.email]], // Campo de email
    password: ['', [Validators.required, Validators.minLength(6)]] // Campo de senha
  });

  constructor(private fb: FormBuilder) { }

  onSubmit(): void {
    if (this.loginForm.valid) {
      console.log(this.loginForm.value); // Mostra os dados do formulário
    } else {
      console.log('Formulário inválido');
    }
  }
}

```

### Como funciona?

1. **Injeção de dependência do `FormBuilder`**:
    - O **`FormBuilder`** é injetado via **`constructor(private fb: FormBuilder)`**. Esse serviço ajuda a criar o formulário de maneira mais simples.
2. **Criando o formulário com `fb.group()`**:
    - **`this.fb.group()`** é usado para criar o **`FormGroup`** com os controles de formulário, sem a necessidade de instanciar explicitamente um **`FormGroup`**.
    - Dentro do `group()`, passamos um objeto que contém os controles, com seus valores iniciais e validações. Por exemplo:
        - `email: ['', [Validators.required, Validators.email]]`: O campo `email` é inicializado com uma string vazia `''`, e os validadores `Validators.required` e `Validators.email` são aplicados.
        - `password: ['', [Validators.required, Validators.minLength(6)]]`: O campo `password` também é inicializado com uma string vazia e tem os validadores `Validators.required` e `Validators.minLength(6)`.
3. **Submissão do formulário**:
    - O método `onSubmit()` verifica se o formulário é válido e, em seguida, exibe os valores do formulário no console ou uma mensagem de erro se o formulário for inválido.

### Template HTML:

```html
<form [formGroup]="loginForm" (ngSubmit)="onSubmit()">
  <div>
    <label for="email">Email:</label>
    <input id="email" formControlName="email" placeholder="Enter your email">
    <div *ngIf="loginForm.get('email')?.touched && loginForm.get('email')?.invalid">
      <div *ngIf="loginForm.get('email')?.hasError('required')">
        O email é obrigatório.
      </div>
      <div *ngIf="loginForm.get('email')?.hasError('email')">
        O email não é válido.
      </div>
    </div>
  </div>

  <div>
    <label for="password">Senha:</label>
    <input id="password" type="password" formControlName="password" placeholder="Enter your password">
    <div *ngIf="loginForm.get('password')?.touched && loginForm.get('password')?.invalid">
      <div *ngIf="loginForm.get('password')?.hasError('required')">
        A senha é obrigatória.
      </div>
      <div *ngIf="loginForm.get('password')?.hasError('minlength')">
        A senha deve ter no mínimo 6 caracteres.
      </div>
    </div>
  </div>

  <button type="submit" [disabled]="loginForm.invalid">Enviar</button>
</form>

```

### Resumo:

- **`fb.group()`** cria um **`FormGroup`** (não precisamos usar explicitamente `new FormGroup()`).
- **`FormBuilder`** torna o processo de criação de formulários mais conciso, sem necessidade de instanciar diretamente o **`FormGroup`**.
- O formulário criado é **reativo** e gerencia o estado e validação de seus campos automaticamente.

Esse exemplo utiliza apenas o **`FormBuilder`** para criar um formulário reativo e simplifica o processo de criação de campos e validação.

---

---

---

### É possível criar formulários reativos sem usar formGroup?

Em **formulários reativos** no Angular, **`FormGroup`** é a estrutura central para agrupar os controles de formulário. Contudo, há algumas alternativas ou variações de como você pode estruturar seus formulários sem utilizar explicitamente **`FormGroup`**. No entanto, **não é recomendado** evitar o uso do **`FormGroup`** em um cenário típico, pois ele organiza e facilita o controle e a validação dos campos.

Aqui estão as possibilidades:

### 1. **Usando Apenas `FormControl`**:

Embora **`FormGroup`** seja geralmente a maneira mais comum de estruturar um formulário reativo, você pode **criar um formulário com apenas `FormControl`**. O **`FormControl`** pode ser usado diretamente, sem a necessidade de agrupá-lo dentro de um `FormGroup`.

### Exemplo com Apenas `FormControl`:

```tsx
import { Component } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  // Criando FormControl diretamente sem usar FormGroup
  email = new FormControl('', [Validators.required, Validators.email]);
  password = new FormControl('', [Validators.required, Validators.minLength(6)]);

  constructor() {}

  onSubmit(): void {
    if (this.email.valid && this.password.valid) {
      console.log('Email:', this.email.value);
      console.log('Password:', this.password.value);
    } else {
      console.log('Formulário inválido');
    }
  }
}

```

### Template HTML:

```html
<form (ngSubmit)="onSubmit()">
  <div>
    <label for="email">Email:</label>
    <input id="email" [formControl]="email" placeholder="Enter your email">
    <div *ngIf="email.invalid && email.touched">
      <div *ngIf="email.hasError('required')">O email é obrigatório</div>
      <div *ngIf="email.hasError('email')">O email não é válido</div>
    </div>
  </div>

  <div>
    <label for="password">Senha:</label>
    <input id="password" type="password" [formControl]="password" placeholder="Enter your password">
    <div *ngIf="password.invalid && password.touched">
      <div *ngIf="password.hasError('required')">A senha é obrigatória</div>
      <div *ngIf="password.hasError('minlength')">A senha deve ter no mínimo 6 caracteres</div>
    </div>
  </div>

  <button type="submit" [disabled]="email.invalid || password.invalid">Enviar</button>
</form>

```

### 2. **Usando `FormArray`**:

Em casos onde você tem um conjunto dinâmico de campos, o **`FormArray`** pode ser usado para manter uma coleção de controles de formulário, mas isso ainda envolve um agrupamento dos controles. No entanto, um **`FormArray`** pode ser usado para criar listas de **`FormControl`** sem a necessidade de um **`FormGroup`**.

### Exemplo com `FormArray`:

```tsx
import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  // Usando FormArray para controlar múltiplos campos de email
  formArray = new FormArray([
    new FormControl('', [Validators.required, Validators.email]),
    new FormControl('', [Validators.required, Validators.minLength(6)]),
  ]);

  constructor() {}

  onSubmit(): void {
    console.log(this.formArray.value); // Exibe os valores dos campos
  }
}

```

### 3. **Formulários Simples com `NgModel` (não reativo)**:

Se você estiver aberto a usar **formularios "template-driven"** (não reativos), você pode usar o **`NgModel`** diretamente, sem usar **`FormGroup`** ou **`FormControl`**. No entanto, essa abordagem não se enquadra nos formulários **reativos** do Angular.

### Exemplo com `NgModel` (não reativo):

```html
<form #loginForm="ngForm" (ngSubmit)="onSubmit(loginForm)">
  <div>
    <label for="email">Email:</label>
    <input id="email" name="email" [(ngModel)]="email" required email>
  </div>

  <div>
    <label for="password">Senha:</label>
    <input id="password" name="password" [(ngModel)]="password" required minlength="6" type="password">
  </div>

  <button type="submit" [disabled]="loginForm.invalid">Enviar</button>
</form>

```

Essa abordagem usa **template-driven forms** e **`NgModel`** para vincular os valores dos campos de entrada a variáveis no componente, mas não utiliza **`FormGroup`** ou **`FormControl`**.

---

### Conclusão:

- **Não é comum** criar **formulários reativos** no Angular sem o **`FormGroup`**, pois ele é a maneira ideal de organizar e validar os campos do formulário.
- Você pode usar apenas **`FormControl`** ou **`FormArray`**, mas ainda assim estará organizando os controles de formulário de alguma forma, mesmo que sem um **`FormGroup`** explícito.
- Se você quiser evitar o uso de **`FormGroup`** por completo, isso pode ser feito utilizando **`FormControl`** diretamente ou um **`FormArray`** para armazenar múltiplos controles, mas geralmente não é a abordagem mais adequada para formulários complexos.

Em resumo, a **prática comum e recomendada** é usar **`FormGroup`** para um controle e validação mais estruturados dos formulários reativos no Angular.

---

---

---

### Qual o beneficio do formBuilder?

O **`FormBuilder`** oferece diversos benefícios ao criar formulários reativos no Angular, tornando o processo mais simples, conciso e legível. Ele facilita a criação e manipulação de **`FormGroup`**, **`FormControl`**, e **`FormArray`**, sem a necessidade de escrever código repetitivo.

Aqui estão os principais benefícios do **`FormBuilder`**:

### 1. **Sintaxe Mais Simples e Legível**

- O **`FormBuilder`** permite a criação de formulários reativos de maneira mais limpa e concisa, reduzindo o código necessário para inicializar um formulário.

Exemplo sem o **`FormBuilder`**:

```tsx
addressForm = new FormGroup({
  firstName: new FormControl('', [Validators.required, Validators.minLength(2)]),
  email: new FormControl('', [Validators.required, Validators.email]),
  phone: new FormControl('', [Validators.required])
});

```

Exemplo com **`FormBuilder`**:

```tsx
addressForm = this.fb.group({
  firstName: ['', [Validators.required, Validators.minLength(2)]],
  email: ['', [Validators.required, Validators.email]],
  phone: ['', [Validators.required]]
});

```

O **`FormBuilder`** permite que você defina os campos do formulário de maneira mais compacta e sem a necessidade de instanciar **`FormControl`** manualmente para cada campo.

### 2. **Reduz o Código Repetitivo**

- Com o **`FormBuilder`**, você pode criar formulários rapidamente, sem a necessidade de instanciar explicitamente cada **`FormControl`** ou **`FormGroup`**. Isso reduz a repetição do código.

### 3. **Facilita a Criação de Formulários Complexos**

- Quando você tem formulários com muitos campos ou campos dinâmicos, o **`FormBuilder`** torna a definição dos controles mais fácil de gerenciar. Ele pode ser usado para criar **`FormArray`**, **`FormGroup`** aninhados e **`FormControl`** de forma concisa.

### 4. **Maior Clareza no Código**

- O código com **`FormBuilder`** é mais direto e fácil de entender. As validações, valores padrão e outros atributos dos controles são definidos de maneira clara e centralizada.

### 5. **Integração Simples com Validadores**

- O **`FormBuilder`** facilita a aplicação de validadores, pois você pode especificá-los diretamente dentro da definição do campo, sem a necessidade de criá-los separadamente e associá-los a cada **`FormControl`**.

### 6. **Melhor Manutenção de Código**

- A utilização do **`FormBuilder`** torna o código mais modular e organizado, o que facilita a manutenção, especialmente em formulários grandes com muitos campos e validações complexas.

### Exemplo Completo Usando `FormBuilder`:

```tsx
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(private fb: FormBuilder) {
    // Criando o formulário usando FormBuilder
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],  // Campo de email
      password: ['', [Validators.required, Validators.minLength(6)]]  // Campo de senha
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      console.log('Formulário válido!', this.loginForm.value);
    } else {
      console.log('Formulário inválido!');
    }
  }
}

```

### Benefícios em Resumo:

1. **Sintaxe simplificada**: Torna a criação de formulários reativos mais direta e legível.
2. **Redução de código repetitivo**: Menos código necessário para criar formulários complexos.
3. **Facilidade em campos dinâmicos e aninhados**: Facilita a criação de formulários com campos que podem ser adicionados ou removidos dinamicamente.
4. **Integração eficiente de validadores**: Validação direta e simples dos campos.
5. **Melhor manutenção**: Estrutura de código mais limpa, o que facilita a manutenção a longo prazo.

O **`FormBuilder`** é uma ferramenta poderosa que ajuda a reduzir a complexidade na criação de formulários reativos no Angular, tornando o desenvolvimento mais eficiente e o código mais legível.

---

---

---

### FormGroup sempre vai estar por debaixo dos panos ?

**`FormGroup`** é de fato **a base** para a criação de **formulários reativos**. Dependendo de como você usa o Angular, você pode **não ver explicitamente** o **`FormGroup`** em algumas situações, especialmente quando usa o **`FormBuilder`**, mas ele **sempre existe** quando você trabalha com formulários reativos.

### Aqui está uma explicação mais detalhada:

### 1. **Usando `FormGroup` Explicitamente**

Quando você cria um formulário reativo manualmente, você precisa usar explicitamente o **`FormGroup`** para agrupar os controles do formulário. Veja um exemplo clássico:

```tsx
import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  // Usando FormGroup explicitamente
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])
  });

  onSubmit() {
    if (this.loginForm.valid) {
      console.log('Formulário válido!', this.loginForm.value);
    }
  }
}

```

Nesse exemplo, **`FormGroup`** é usado explicitamente para agrupar os controles `email` e `password`. Isso é o que **"por baixo dos panos"** significa: você está criando e manipulando o **`FormGroup`** diretamente.

### 2. **Usando o `FormBuilder`**

Quando você usa o **`FormBuilder`**, o **`FormGroup`** ainda é criado por trás dos panos, mas de forma mais concisa e automática. O **`FormBuilder`** ajuda a evitar a repetição de código ao criar formulários complexos.

```tsx
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(private fb: FormBuilder) {
    // Criando o FormGroup com FormBuilder
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      console.log('Formulário válido!', this.loginForm.value);
    }
  }
}

```

Embora você **não veja o `FormGroup` diretamente**, ele está sendo criado de forma implícita dentro do **`FormBuilder`**. O método **`this.fb.group()`** cria um **`FormGroup`** automaticamente com base na configuração que você fornece.

Portanto, quando você usa **`FormBuilder`**, **o `FormGroup` é criado automaticamente**, mas você **não precisa escrever a definição completa do `FormGroup`** manualmente, o que simplifica a criação e leitura do código.

### 3. **Como o `FormGroup` Funciona nos Bastidores?**

Mesmo quando você não escreve explicitamente **`FormGroup`**, ele ainda está sendo utilizado. A estrutura interna do formulário gerenciado pelo Angular se baseia no conceito de grupos de controles, e isso é feito com **`FormGroup`**.

No fundo, a estrutura de dados por trás de um formulário reativo pode ser descrita assim:

```tsx
{
  email: new FormControl(''),
  password: new FormControl('')
}

```

Este **objeto de controle** é na verdade um **`FormGroup`** que agrupa **`FormControl`** individuais.

### 4. **Em Resumo**

- **Sempre haverá um `FormGroup`** quando você estiver usando formulários reativos no Angular. Mesmo que você não o veja diretamente, ele sempre estará lá, agrupando os controles.
- **Quando você usa `FormBuilder`**, o **`FormGroup`** é criado automaticamente, e você não precisa instanciá-lo manualmente, mas ele **ainda é o mecanismo subjacente que agrupa os controles**.
- O **`FormGroup`** é um dos pilares dos **formulários reativos** no Angular, mesmo quando você não o define explicitamente.

Portanto, **o `FormGroup` não desaparece**. Ele pode ser ocultado por **`FormBuilder`** para simplificar o código, mas sempre estará por trás da estrutura do formulário.