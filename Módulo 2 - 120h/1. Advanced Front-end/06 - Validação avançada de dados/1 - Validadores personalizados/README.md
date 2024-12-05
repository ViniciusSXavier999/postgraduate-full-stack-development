# 1 → VALIDADORES PERSONALIZADOS

🏆 EXISTE VARIAS MANEIRAS DE FAZER VALIDAÇÕES

> Eu posso criar uma classe para fazer uma validação de cpf e cnpj
> 

> Vamos fazer a mascara de cpf
> 

📌 O que é mascara de cpf?

No contexto de **Angular**, uma **máscara de CPF** geralmente se refere ao processo de formatar a entrada de um campo de formulário para que ele siga o formato adequado de um **número de CPF (Cadastro de Pessoas Físicas)** no Brasil.

O formato padrão de um CPF é **"XXX.XXX.XXX-XX"**, onde:

- Os primeiros 9 dígitos representam os números do CPF.
- O último dígito é um número de controle que segue o padrão de verificação.
- A máscara inclui pontos (.) e um hífen (-) para separar as partes do número.


> Também é possível fazer um componente que realiza a validação da cotação do dólar, Eu coloco a cotação do dólar e na hora que eu clicar ele vai no service e verifica se o dólar está com aquela cotação mesmo
> 

> Eu posso fazer uma validação para saber se a matricula da pessoa esta ativa na empresa
> 

---

# ISSO É APENAS UM EXEMPLO PARA VER OS TIPOS DE VALIDAÇÕES QUE TEMOS COMO OPÇÃO PARA UTILIZAR

## 1. EU VOU COMEÇAR CRIANDO UM NOVO CAMPO NO MEU CADASTRO.COMPONENT.HTML

```html
 <div class="row">

        <div class="col">
          <mat-form-field class="full-width">
            <input matInput placeholder="Exemplo" formControlName="desc">
            @if (addressForm.controls['desc'].hasError('required')) {
            <mat-error>Nome é <strong>obrigatório</strong></mat-error>
            }
          </mat-form-field>
        </div>

    
      </div>
```

## 2. VOU CRIAR A VALIDAÇÃO DELE NO TYPESCRIPT DO MEU COMPONENTE AGORA

```tsx
 desc: [null, Validators.compose([Validators.required, Validators.minLength(2), Validators.maxLength(70)])],
```

## 3. EU PODERIA CRIAR UMA CLASSE(VERIFICAEXEMPLO) PARA FAZER VALIDAÇÕES E DENTRO DESSA CLASSE TERIA UM MÉTODO CHAMADO ISVALID()

```tsx
 desc: [null, Validators.compose([Validators.required, Validators.minLength(2), Validators.maxLength(70), VerificaExemplo.isValid()])],
```

> Esse método seria responsável por verificar se isso seria verdadeiro ou não, ai ele entraria dentro das condições
> 

## 4. VALIDATORS É UMA CLASSE ESTÁTICA QUE CONTÉM DIVERSAS VALIDAÇÕES

- Validators.email
- Validarts.max
- Validators.pattern
- Validators.maxLength

🏆 Uma coisa que tem que se atentar bastante é que se caso você queira uma validação mais avançada, como por exemplo, uma função, você tem que colocar ela no HTML e definir a sua lógica com as validações personalizadas no typescript


### Outro tipo de validação é no próprio HTML

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/validacaoAvancada.png" />

---

🏆 Vamos trabalhar com mascaras e vamos fazer a validação do CPF e CNPJ


---

---

---

## DÚVIDAS QUE SURGIRAM DURANTE A AULA

### Validators é um método do formGroup?

Não, **`Validators`** não é um método do **`FormGroup`**. **`Validators`** é um objeto que fornece várias funções de validação que podem ser usadas para validar os campos de um formulário reativo no Angular. Essas funções de validação são usadas para garantir que os dados inseridos pelos usuários em um formulário atendam a determinadas regras, como ser um número, ter um comprimento mínimo, ser um e-mail válido, entre outras.

### O que são os **Validators**?

O **`Validators`** é uma classe no Angular que contém várias funções estáticas que podem ser aplicadas aos controles de formulário (os campos individuais de um formulário reativo). Essas funções ajudam a aplicar regras de validação aos campos.

### Como usar **Validators**?

Em um formulário reativo, você pode usar os **`Validators`** ao definir o **`FormGroup`** e seus **`FormControl`**. O Angular permite aplicar essas funções diretamente ao definir um controle de formulário com o **`FormBuilder`** ou no momento de criação de um formulário.

### Exemplos de **Validators**:

### 1. **Validators** como parte do **`FormGroup`**:

Os **`Validators`** podem ser usados quando você está definindo os campos do formulário. Exemplo:

```tsx
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

export class ExampleComponent {
  addressForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.addressForm = this.fb.group({
      firstName: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(70)]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }
}

```

### 2. **Principais tipos de Validators**:

- **`Validators.required`**: Garante que o campo não fique vazio.
- **`Validators.minLength(n)`**: Garante que o valor tenha pelo menos `n` caracteres.
- **`Validators.maxLength(n)`**: Garante que o valor não tenha mais que `n` caracteres.
- **`Validators.email`**: Valida se o valor é um e-mail válido.
- **`Validators.pattern(regex)`**: Valida se o valor corresponde a um padrão (regex).
- **`Validators.min(n)`** e **`Validators.max(n)`**: Validam se o valor numérico está dentro de um intervalo especificado.

### **Exemplo de Uso dos Validators:**

```tsx
import { FormBuilder, Validators } from '@angular/forms';

export class MyComponent {
  myForm = this.fb.group({
    name: ['', [Validators.required, Validators.minLength(3)]],
    email: ['', [Validators.required, Validators.email]],
    phone: ['', [Validators.required]],
  });

  constructor(private fb: FormBuilder) {}
}

```

No exemplo acima:

- O campo **`name`** precisa ter pelo menos 3 caracteres e ser preenchido (usando `Validators.required` e `Validators.minLength(3)`).
- O campo **`email`** precisa ser um e-mail válido (usando `Validators.email`).
- O campo **`phone`** é obrigatório (`Validators.required`).

### **Verificando o estado de um formulário ou controle**:

Uma vez que você tenha configurado as validações no formulário, você pode verificar se os campos são válidos ou se algum erro de validação ocorreu, acessando as propriedades do **`FormGroup`** ou **`FormControl`**.

Exemplo de como verificar se um campo é válido:

```tsx
if (this.addressForm.valid) {
  // O formulário é válido
} else {
  // O formulário tem erros
}

if (this.addressForm.controls['email'].invalid) {
  // O campo 'email' é inválido
}

```

### Resumo:

- **`Validators`** não é um método do **`FormGroup`**; é uma classe que contém funções de validação estáticas.
- Você usa **`Validators`** ao definir os controles de formulário dentro de um **`FormGroup`** ou **`FormControl`**.
- **`FormGroup`** é uma estrutura para agrupar controles de formulário, enquanto **`Validators`** são as funções que você aplica a esses controles para validar as entradas dos usuários.

---

---

---

### Se o validators é um objeto, ele é instanciado a partir de qual classe?

O **`Validators`** no Angular não é uma instância de uma classe que você cria, mas sim uma **classe estática** que contém métodos estáticos para validação de formulários. Ou seja, você não precisa instanciá-lo com o operador `new` como faria com outras classes em JavaScript/TypeScript.

### O que significa "estático"?

Quando dizemos que **`Validators`** é **estático**, significa que todos os métodos de validação (como `Validators.required`, `Validators.minLength()`, etc.) são **métodos de classe**, e não métodos de instância. Portanto, você pode chamar esses métodos diretamente na classe **`Validators`** sem precisar criar uma instância dessa classe.

### A Classe **`Validators`** no Angular

O **`Validators`** é uma classe fornecida pelo Angular e está localizada no pacote **`@angular/forms`**. A classe **`Validators`** tem métodos estáticos que você usa para validar os campos de um formulário reativo.

### Exemplos de Métodos Estáticos na Classe `Validators`:

- **`Validators.required`**: Valida se o campo tem um valor.
- **`Validators.minLength(n)`**: Valida se o campo tem pelo menos `n` caracteres.
- **`Validators.maxLength(n)`**: Valida se o campo tem no máximo `n` caracteres.
- **`Validators.email`**: Valida se o campo contém um e-mail válido.
- **`Validators.pattern`**: Valida se o valor do campo corresponde a uma expressão regular.
- **`Validators.min(n)`** e **`Validators.max(n)`**: Valida se o valor numérico está dentro de um intervalo.

### Exemplo de Uso de **`Validators`**:

```tsx
import { FormBuilder, Validators } from '@angular/forms';

export class ExampleComponent {
  myForm = this.fb.group({
    name: ['', [Validators.required, Validators.minLength(3)]],
    email: ['', [Validators.required, Validators.email]],
    age: ['', [Validators.required, Validators.min(18)]],
  });

  constructor(private fb: FormBuilder) {}
}

```

### Explicando o Código:

- **`Validators.required`**: Verifica se o campo é obrigatório (não pode ser vazio).
- **`Validators.minLength(3)`**: Verifica se o campo tem pelo menos 3 caracteres.
- **`Validators.email`**: Verifica se o campo é um e-mail válido.
- **`Validators.min(18)`**: Verifica se o campo contém um valor numérico maior ou igual a 18.

### Conclusão

O **`Validators`** no Angular não precisa ser instanciado, pois ele é uma **classe estática**. Isso significa que você pode acessar os métodos de validação diretamente através de `Validators.metodo()`, sem precisar criar um objeto da classe.