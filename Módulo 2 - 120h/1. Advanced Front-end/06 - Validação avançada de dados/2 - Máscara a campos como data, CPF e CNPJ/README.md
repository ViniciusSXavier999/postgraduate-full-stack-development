# MÁSCARA E CAMPOS COMO DATA, CPF E CNPJ

# MÁSCARA E CAMPOS COMO DATA, CPF E CNPJ

📌 DOCUMENTAÇÃO DO MASK → [Documentação MASK](https://github.com/JsDaddy/ngx-mask/blob/develop/USAGE.md)


🏆 Já aprendemos a fazer a validação básica, a validação avançada, mas agora vamos supor que eu queira colocar uma máscara para telefone e cpf, eu consigo fazer isso através de uma dependência em angular:

> Após baixar essa dependência eu vou fazer a configuração dentro do input que ai vamos colocar a mascara, é possível fazer vários tipos de máscara
> 

### DEPENDÊNCIA PARA USAR A MÁSCARA NO CPF, NUMERO DE TELEFONE ETC

```powershell
npm i ngx-mask
```

🏆 Vídeo explicativo de como configurar o mask no Angular 17+

[MASK IN ANGULAR 17+](https://www.youtube.com/watch?v=L145sRWlBQc)

## PRIMEIRO PASSO: ADICIONAR ‘`provideEnvironmentNgxMask(),`’ NO APP.CONFIG

## SEGUNDO PASSO: ADICIONAR NO IMPORTS DO COMPONENT QUE VOCÊ DESEJA UTILIZAR: `NgxMaskDirective, NgxMaskPipe,`


---

## PASSO A PASSO PARA CRIAÇÃO DA MÁSCARA

### 1. COLOCAR DENTRO DA TAG TELEFONE NO CADASTRO.COMPONENT.HTML

```powershell
mask="(000) 000 00 00" 
```

CÓDIGO HTML

```powershell
 <div class="row">
        <div class="col">
          <mat-form-field class="full-width">
            <input matInput placeholder="Telefone" mask="(00) 0000-0000"  formControlName="phone">
            @if (addressForm.controls['phone'].hasError('required')) {
            <mat-error>Telefone é <strong>obrigatório</strong></mat-error>
            }
          </mat-form-field>
        </div>
      </div>
```

TESTE E RESULTADO

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/maskCampo1.png" />

## 2. VAMOS CRIAR MAIS DOIS CAMPOS, CPF E CNPJ

> Antes será necessário criar uma validação para o cpf no cadastro component.ts
> 

```tsx
cpf: [null, Validators.required],
```

> NÃO ESQUECER DE CRIAR NA MODEL DE USER.TS
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/maskCampos2.png" />

CÓDIGO NO TEMPLATE HTML

```html
  <div class="row">
        <div class="col">
          <mat-form-field class="full-width">
            <input matInput placeholder="CPF" mask="000.000.000-00"  formControlName="cpf">
            @if (addressForm.controls['cpf'].hasError('required')) {
            <mat-error>CPF é <strong>obrigatório</strong></mat-error>
            }
          </mat-form-field>
        </div>
      </div>
```

---

---

## DÚVIDAS QUE SURGIRAM DURANTE A AULA

### É obrigado passar no formGroup os campos do meu formulario?

Não, **não é obrigatório** passar todos os campos do seu formulário para o **`FormGroup`** no Angular. O **`FormGroup`** é uma maneira de organizar e validar os campos de um formulário reativo, mas você tem a flexibilidade de decidir quais campos você deseja incluir nele.

### O que é um **`FormGroup`**?

O **`FormGroup`** no Angular é uma classe usada para agrupar um conjunto de controles de formulário (campos de entrada). Ela permite que você valide, monitore e manipule os valores desses campos de maneira centralizada. Você cria um **`FormGroup`** para representar um conjunto de dados no formulário, e dentro desse grupo você pode definir **`FormControl`** (para campos simples) ou **`FormArray`** (para arrays de campos).

### Exemplo de **`FormGroup`**:

```tsx
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-example',
  templateUrl: './example.component.html',
})
export class ExampleComponent {
  // Definindo o FormGroup com dois campos
  form: FormGroup;

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      firstName: ['', Validators.required], // Campo obrigatório
      lastName: ['', Validators.required],  // Campo obrigatório
    });
  }
}

```

### Respondendo à sua pergunta: **É obrigatório passar todos os campos?**

**Não**, você não precisa passar todos os campos do formulário para o **`FormGroup`**. Você pode incluir apenas os campos que são necessários para o seu caso de uso, ou seja, aqueles que você quer controlar ou validar. Caso haja campos no seu formulário que você não precisa manipular diretamente, você pode deixá-los fora do **`FormGroup`**.

### Exemplo:

Se você tem um formulário com muitos campos, mas só precisa validar alguns deles (por exemplo, apenas `firstName` e `lastName`), você pode criar um **`FormGroup`** apenas com esses campos:

### Exemplo sem todos os campos no `FormGroup`:

```tsx
this.form = this.fb.group({
  firstName: ['', Validators.required],
  lastName: ['', Validators.required],
  // Outros campos podem ser omitidos se não forem necessários para controle ou validação
});

```

### Campos não incluídos no `FormGroup`:

Se você tiver outros campos no seu formulário que **não são necessários** para o controle ou não exigem validação (por exemplo, campos que você não precisa vincular ao valor do formulário ou que são gerenciados de outra forma), você pode simplesmente **não adicioná-los** ao **`FormGroup`**. Esses campos podem ser manipulados diretamente no DOM ou fora da estrutura reativa do Angular.

### Exemplo:

```html
<form [formGroup]="form">
  <input formControlName="firstName" placeholder="First Name">
  <input formControlName="lastName" placeholder="Last Name">
  <!-- Outros campos não controlados pelo FormGroup -->
  <input type="text" placeholder="Age"> <!-- Não está no FormGroup -->
</form>

```

Neste exemplo, o campo **"Age"** não está incluído no **`FormGroup`** e não é controlado pelo Angular. Ele pode ser manipulado de outras formas (por exemplo, diretamente no template ou com outro controlador de estado).

### Conclusão:

Não, **não é obrigatório** passar todos os campos do seu formulário para o **`FormGroup`**. Você pode escolher quais campos precisa controlar ou validar no formulário e incluí-los no **`FormGroup`**. Outros campos que não precisam de controle reativo podem ser omitidos do grupo e manipulados de maneira simples no DOM.