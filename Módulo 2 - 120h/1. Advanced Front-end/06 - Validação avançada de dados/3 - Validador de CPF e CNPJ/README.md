# VALIDADOR DE CPF E CNPJ

> Vamos continuar com as validações
> 

> Tem como fazer até mesmo com uma linha de código igual estávamos mostrando com o mask para criar um padrão de pattern para fazer a validação do CPF e CNPJ
> 

🏆 Não teremos tempo para criar essa classe passo a passo, mas existe uma regra que você segue, fazendo um calculo para saber se o CPF é valido, a mesma coisa serve para CNPJ

> O CPF e o CNPJ segue basicamente a mesma lógica dessa classe que vamos criar.
> 


📌 A validação disso é uma regra, é o mesmo código que empresas grandes utilizam que tenham um formulário com necessidade da adição do CPF ou CNPJ, É A MESMA LÓGICA (CALCULO)


📌 Existe outras maneiras de fazer essa validação que é pegar o dado, criar o arquivo de service e validar o CPF e CNPJ no serasa, o service teria que ir no servidor e verificar essa validação


📌 VAMOS CRIAR UMA CLASSE, VAMO PASSAR O NÚMERO DENTRO DE REGRAS E VAI RETORNAR FALSE OU TRUE


> A regra é única, é o mesmo código, a única modificação que foi feita foi para que ele seja compatível com o typecript
> 

---

## 1. SERÁ CRIADA UMA PASTA CHAMADA ‘rulesCPF&CNPJ’ E DENTRO DELA UM ARQUIVO CHAMADO ‘validador.ts’

> É muito fácil de encontrar em javascript essas validações de CPF e CNPJ, a parte mais difícil foi transformar para typescript
> 

CÓDIGO DA CLASSE VALIDADOR.TS → CLASSE QUE VALIDA O CPF

```tsx
import { AbstractControl, Validators } from "@angular/forms";

export class GenericValidator {
    constructor() {} 
    /**
     * Valida se o CPF é valido. Deve-se ser informado o cpf sem máscara.
    */
    static isValidCpf() {
      return (control: AbstractControl): Validators => {
        const cpf = control.value;
        console.log(cpf);
        if (cpf) {
          let numbers, digits, sum, i, result, equalDigits;
          equalDigits = 1;
          if (cpf.length < 11) {
           return null as any;
          }
 
          for (i = 0; i < cpf.length - 1; i++) {
            if (cpf.charAt(i) !== cpf.charAt(i + 1)) {
              equalDigits = 0;
              break;
            }
          }
 
          if (!equalDigits) {
            numbers = cpf.substring(0, 9);
            digits = cpf.substring(9);
            sum = 0;
            for (i = 10; i > 1; i--) {
              sum += numbers.charAt(10 - i) * i;
            }
 
            result = sum % 11 < 2 ? 0 : 11 - (sum % 11);
 
            if (result !== Number(digits.charAt(0))) {
              return { cpfNotValid: true };
            }
            numbers = cpf.substring(0, 10);
            sum = 0;
 
            for (i = 11; i > 1; i--) {
              sum += numbers.charAt(11 - i) * i;
            }
            result = sum % 11 < 2 ? 0 : 11 - (sum % 11);
 
            if (result !== Number(digits.charAt(1))) {
              return { cpfNotValid: true };
            }
            return null as any;
          } else {
            return { cpfNotValid: true };
          }
       }
     return null as any;
   };
 }
}
```

> Na internet tem vários geradores de CPF, geralmente esses geradores passam dessa regra de validar cpf
> 

### EXPLICAÇÃO DETALHADA DO CÓDIGO

Essa linha de código define um **validador personalizado** em Angular para verificar se um CPF (Cadastro de Pessoa Física, utilizado no Brasil) é válido. Ela está estruturada para ser usada em formulários reativos e segue a lógica de validação do CPF com base em dígitos verificadores. Vamos analisar as partes principais.

---

### **Código detalhado:**

### **Importações**:

```tsx
import { AbstractControl, Validators } from "@angular/forms";

```

- **`AbstractControl`**: Uma classe base usada para representar controles de formulários (inputs, textareas, etc.) em Angular.
- **`Validators`**: Um conjunto de validadores embutidos no Angular, como validação de campos obrigatórios, mínimos, máximos, etc.

### **Definição da classe `GenericValidator`:**

```tsx
export class GenericValidator {
    constructor() {}

```

- Cria uma classe chamada `GenericValidator`.
- O construtor não realiza nenhuma ação.

### **Definição do validador `isValidCpf`:**

```tsx
static isValidCpf() {
    return (control: AbstractControl): Validators => {

```

- **`static`**: O método pode ser chamado diretamente sem precisar instanciar a classe.
- **`isValidCpf`**: O nome do método que realiza a validação do CPF.
- **Retorna uma função anônima** que:
    - Recebe como argumento um `AbstractControl` (representa o campo do formulário que será validado).
    - Retorna um objeto do tipo `Validators` indicando se o valor é válido ou não.

---

### **Lógica do Validador:**

### **Obtendo o valor do controle:**

```tsx
const cpf = control.value;
console.log(cpf);

```

- Obtém o valor do campo que está sendo validado.
- Imprime o CPF no console para depuração.

---

### **Validação básica:**

```tsx
if (cpf) {
    let numbers, digits, sum, i, result, equalDigits;
    equalDigits = 1;
    if (cpf.length < 11) {
        return null as any;
    }

```

- Verifica se o CPF foi fornecido e possui pelo menos 11 dígitos.
    - Caso contrário, retorna `null` (o campo é considerado válido porque o valor é vazio ou inadequado para validação).

---

### **Verifica se todos os dígitos são iguais:**

```tsx
for (i = 0; i < cpf.length - 1; i++) {
    if (cpf.charAt(i) !== cpf.charAt(i + 1)) {
        equalDigits = 0;
        break;
    }
}
if (!equalDigits) { ... }

```

- Se todos os dígitos forem iguais (por exemplo, `111.111.111-11`), o CPF é inválido.
- Caso contrário, a validação continua.

---

### **Cálculo dos dígitos verificadores:**

1. **Primeiro dígito verificador:**
    
    ```tsx
    numbers = cpf.substring(0, 9); // Primeiro bloco de números
    digits = cpf.substring(9);    // Últimos dois dígitos (verificadores)
    sum = 0;
    
    for (i = 10; i > 1; i--) {
        sum += numbers.charAt(10 - i) * i;
    }
    
    result = sum % 11 < 2 ? 0 : 11 - (sum % 11);
    if (result !== Number(digits.charAt(0))) {
        return { cpfNotValid: true };
    }
    
    ```
    
    - Calcula o primeiro dígito verificador com base nos 9 primeiros números.
    - Verifica se o resultado corresponde ao primeiro dígito verificador do CPF.
    - Se não corresponder, retorna `{ cpfNotValid: true }`, indicando que o CPF é inválido.
2. **Segundo dígito verificador:**
    
    ```tsx
    numbers = cpf.substring(0, 10);
    sum = 0;
    
    for (i = 11; i > 1; i--) {
        sum += numbers.charAt(11 - i) * i;
    }
    
    result = sum % 11 < 2 ? 0 : 11 - (sum % 11);
    if (result !== Number(digits.charAt(1))) {
        return { cpfNotValid: true };
    }
    return null as any;
    
    ```
    
    - Calcula o segundo dígito verificador com base nos 10 primeiros números.
    - Valida o segundo dígito da mesma forma que o primeiro.

---

### **Retorno final:**

- **CPF válido**: Retorna `null` (nenhum erro).
- **CPF inválido**: Retorna `{ cpfNotValid: true }`.

---

### **Como usar o validador?**

Esse validador pode ser usado em um formulário reativo no Angular. Exemplo:

### Formulário:

```tsx
this.form = new FormGroup({
    cpf: new FormControl('', [GenericValidator.isValidCpf()])
});

```

### Verificação de erro no template:

```html
<div *ngIf="form.controls['cpf'].hasError('cpfNotValid')">
    CPF inválido!
</div>

```

---

### Resumo:

Essa linha de código define um validador personalizado para verificar se o CPF informado é válido. Ele segue as regras formais de cálculo do CPF, verificando:

1. Se o CPF tem 11 dígitos.
2. Se todos os dígitos são iguais (inválido).
3. Se os dígitos verificadores estão corretos.

---

---

---

## 2. LOGO APÓS ISSO VAMOS COLOCAR ESSA VALIDAÇÃO COM O MÉTODO LÁ NO FORM GROUP DO CPF NO TYPESCRIPT DE CADASTRO COMPONENT

```tsx
   cpf:  [null, Validators.compose([Validators.required, GenericValidator.isValidCpf])],
```

## 3. AGORA VOU ALTERAR O HTML, VOU DUPLICAR O MAT-ERROR NO FORM PARA SABER SE ELE É VALIDO OU NÃO E SE EU DIGITEI OU NÃO O VALOR

```html

      <div class="row">
        <div class="col">
          <mat-form-field class="full-width">
            <input matInput placeholder="CPF" mask="000.000.000-00"  formControlName="cpf">
            @if (addressForm.controls['cpf'].hasError('required')) {
            <mat-error>CPF é <strong>obrigatório</strong></mat-error>
            }

            <!-- Se após a função de validação ele retornar cpfNotValid, será escrito na tela "CPF NÃO É VALIDO" -->
            @if (addressForm.controls['cpf'].getError('cpfNotValid')) {
              <mat-error>CPF não é <strong>valido</strong></mat-error>
              }      
              <!--     -->
          </mat-form-field>
        </div>
      </div>
```

## 4. REALIZANDO TESTES E CONCLUSÃO

- Entrar no site de gerador de CPF

[Gerador de CPF - 4Devs](https://www.4devs.com.br/gerador_de_cpf)

- Após gerar o cpf, copie e cole lá no campo
- NENHUM ERRO FOI ENCONTRADO
    
   <img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/validadorCPFTeste1.png" />
    

- Agora se colocarmos qualquer número, ele irá mostrar o erro de CPF inválido
    
<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/validadorCPFTeste2.png" />
    

## DÚVIDAS QUE SURGIRAM DURANTE A AULA

### Qual a diferença de hasError e getError? angular html

No **Angular**, os métodos **`hasError`** e **`getError`** são usados em formulários reativos para verificar e obter erros associados a controles de formulário. Embora ambos lidem com a validação de campos, eles têm funcionalidades distintas.

---

### **1. `hasError`**

- **Descrição**: Verifica se um campo do formulário contém um **erro específico**.
- **Retorno**: Um valor booleano (`true` ou `false`).
- **Uso típico**: Determinar se um erro está presente e, com base nisso, exibir mensagens de validação ou ajustar o comportamento do formulário.

### **Sintaxe**:

```tsx
formControl.hasError(errorCode: string, path?: string[]): boolean

```

- **`errorCode`**: O código do erro que você deseja verificar, como `'required'`, `'minlength'`, `'maxlength'`, etc.
- **`path`** (opcional): O caminho para um controle filho, caso esteja validando um grupo ou array de controles.

### **Exemplo**:

```tsx
<form [formGroup]="form">
  <input formControlName="email">
  <div *ngIf="form.controls['email'].hasError('required')">O e-mail é obrigatório!</div>
</form>

```

Nesse caso:

- **`form.controls['email'].hasError('required')`** verifica se o campo **email** possui o erro `'required'`.

---

### **2. `getError`**

- **Descrição**: Retorna o **valor do erro** associado a um controle de formulário.
- **Retorno**: O valor do erro (se existir) ou `null` (se o erro não estiver presente).
- **Uso típico**: Obter informações detalhadas sobre um erro, como os valores definidos para validações.

### **Sintaxe**:

```tsx
formControl.getError(errorCode: string, path?: string[]): any

```

- **`errorCode`**: O código do erro que você deseja obter, como `'minlength'`, `'maxlength'`, etc.
- **`path`** (opcional): O caminho para um controle filho, se aplicável.

### **Exemplo**:

```tsx
<form [formGroup]="form">
  <input formControlName="username">
  <div *ngIf="form.controls['username'].hasError('minlength')">
    O nome de usuário deve ter no mínimo
    {{ form.controls['username'].getError('minlength').requiredLength }} caracteres.
  </div>
</form>

```

Nesse caso:

- **`hasError('minlength')`** verifica se há o erro de comprimento mínimo.
- **`getError('minlength')`** retorna os detalhes do erro, como o número mínimo de caracteres exigidos.

---

### **Principais Diferenças**:

| **Aspecto** | **`hasError`** | **`getError`** |
| --- | --- | --- |
| **Retorno** | `true` ou `false` | Valor do erro ou `null` |
| **Uso principal** | Verificar a existência de um erro específico | Obter informações detalhadas do erro |
| **Exemplo típico** | Mostrar mensagens de erro com base em validações | Acessar valores de restrições de erro |

---

### **Resumo em HTML**:

### `hasError` para verificar:

```html
<div *ngIf="form.controls['email'].hasError('required')">
  O e-mail é obrigatório!
</div>

```

### `getError` para obter detalhes:

```html
<div *ngIf="form.controls['password'].hasError('minlength')">
  A senha deve ter no mínimo
  {{ form.controls['password'].getError('minlength').requiredLength }} caracteres.
</div>

```

---

---

---

### O que é abstractControl?

No Angular, **`AbstractControl`** é uma classe base que representa a estrutura fundamental para lidar com a validação e o gerenciamento do estado de **controles de formulário** (inputs, selects, checkboxes, etc.).

Essa classe é usada internamente pelo Angular para fornecer funcionalidades comuns a outros tipos de controles, como **`FormControl`**, **`FormGroup`**, e **`FormArray`**.

---

### **Características principais de `AbstractControl`**:

1. **Classe abstrata**: Não pode ser instanciada diretamente, mas suas funcionalidades são herdadas por outras classes, como:
    - **`FormControl`**: Representa um único campo de entrada.
    - **`FormGroup`**: Representa um grupo de controles.
    - **`FormArray`**: Representa um array de controles.
2. **Fornece métodos e propriedades comuns**:
    - Para verificar o estado do controle (válido, inválido, sujo, etc.).
    - Para gerenciar valores, validações e erros.

---

### **Propriedades importantes de `AbstractControl`**:

1. **`value`**:
    - Retorna o valor atual do controle.
    
    ```tsx
    const value = control.value; // O valor do campo de entrada
    
    ```
    
2. **`valid` / `invalid`**:
    - Indicam se o controle é válido ou inválido com base nos validadores aplicados.
    
    ```tsx
    if (control.valid) {
      console.log('O campo é válido!');
    }
    
    ```
    
3. **`errors`**:
    - Retorna um objeto contendo os erros de validação, se houver.
    
    ```tsx
    const errors = control.errors; // { required: true, minlength: { requiredLength: 5, actualLength: 3 } }
    
    ```
    
4. **`pristine` / `dirty`**:
    - **`pristine`**: Verdadeiro se o controle nunca foi modificado pelo usuário.
    - **`dirty`**: Verdadeiro se o controle foi alterado pelo usuário.
    
    ```tsx
    if (control.dirty) {
      console.log('O campo foi modificado!');
    }
    
    ```
    
5. **`touched` / `untouched`**:
    - **`touched`**: Verdadeiro se o controle foi acessado (perdeu o foco).
    - **`untouched`**: Verdadeiro se o controle nunca foi acessado.
    
    ```tsx
    if (control.touched) {
      console.log('O campo perdeu o foco!');
    }
    
    ```
    
6. **`status`**:
    - Retorna o status geral do controle: `"VALID"`, `"INVALID"`, `"PENDING"`, ou `"DISABLED"`.
    
    ```tsx
    const status = control.status; // "VALID" ou "INVALID"
    
    ```
    

---

### **Métodos importantes de `AbstractControl`**:

1. **`setValue(value: any)`**:
    - Atualiza o valor do controle, substituindo completamente o valor anterior.
    
    ```tsx
    control.setValue('Novo Valor');
    
    ```
    
2. **`patchValue(value: any)`**:
    - Atualiza apenas os valores informados, sem substituir o valor completo (usado em grupos e arrays).
    
    ```tsx
    formGroup.patchValue({ nome: 'João' });
    
    ```
    
3. **`reset(value?: any)`**:
    - Redefine o controle ao estado inicial, opcionalmente com um novo valor.
    
    ```tsx
    control.reset();
    
    ```
    
4. **`markAsTouched()`** e **`markAsUntouched()`**:
    - Define o estado do controle como "acessado" ou "não acessado".
    
    ```tsx
    control.markAsTouched();
    
    ```
    
5. **`markAsDirty()`** e **`markAsPristine()`**:
    - Define o estado do controle como "modificado" ou "não modificado".
    
    ```tsx
    control.markAsDirty();
    
    ```
    
6. **`hasError(errorCode: string)`**:
    - Verifica se o controle possui um erro específico.
    
    ```tsx
    if (control.hasError('required')) {
      console.log('O campo é obrigatório!');
    }
    
    ```
    
7. **`getError(errorCode: string)`**:
    - Retorna os detalhes de um erro específico.
    
    ```tsx
    const minError = control.getError('minlength'); // { requiredLength: 5, actualLength: 3 }
    
    ```
    

---

### **Exemplo prático usando `AbstractControl`**:

```tsx
import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-form-example',
  template: `
    <form [formGroup]="form">
      <label for="nome">Nome:</label>
      <input id="nome" formControlName="nome">
      <div *ngIf="nomeControl.hasError('required') && nomeControl.touched">
        O nome é obrigatório.
      </div>
    </form>
  `
})
export class FormExampleComponent {
  form = new FormGroup({
    nome: new FormControl('', [Validators.required])
  });

  get nomeControl(): AbstractControl {
    return this.form.get('nome')!;
  }
}

```

### Explicação:

1. **`AbstractControl`** é usado para obter o controle do campo `nome` no formulário.
2. Ele permite verificar o estado do controle e exibir mensagens de erro, como "O nome é obrigatório" se o campo for tocado e estiver vazio.

---

### **Resumo**:

- **`AbstractControl`** é a classe base para todos os tipos de controle de formulário no Angular.
- Oferece propriedades e métodos úteis para validar, gerenciar e interagir com campos de formulário.
- Não é usada diretamente, mas você interage com ela através de **`FormControl`**, **`FormGroup`**, ou **`FormArray`**.