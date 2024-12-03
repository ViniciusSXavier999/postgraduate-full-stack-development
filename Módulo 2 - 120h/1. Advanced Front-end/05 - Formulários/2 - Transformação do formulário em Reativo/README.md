# TRANSFORMAÇÃO DO FORMULÁRIO EM REATIVO

> A classe do formBuilder da varias possibilidades para nós trabalharmos com validações
> 

---

📌 Podemos observar que se caso não seja digitado nenhum dado, vamos receber instantaneamente a mensagem de que é obrigatório, isso é a validação ocorrendo.

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/formreativo1.png" />

📌 Enquanto não for digitado os dados obrigatórios o botão não será habilitado 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/formreativo2.png" />


📌 Logo após colocar os dados obrigatório e clicar em entrar o alert será exibido na tela

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/formreativo3.png" />

---

> No angular tem dois tipos de formulários, o formulário normal a gente faz pelo próprio HTML
> 

> Existe muitas possibilidades com formularios reativos
> 

🚨 Esse disabled ele não valida os campos que estão no javascript

```tsx

    <mat-card-actions>
      <button mat-raised-button  color="primary" type="submit" [disabled]="!addressForm.valid" >Cadastrar</button>
    </mat-card-actions>
```


🚨 Quando eu clico no botão submit ele vai executar o ngSubmit que executa a função que temos no typescript

> Nas próximas aulas vamos gravar no localStorage e depois na fakeAPI utilizando o service
> 

---

## DÚVIDAS QUE SURGIRAM DURANTE A AULA

### O que é o ngSubmit()?

### 1. **Como funciona o `ngSubmit`?**

A diretiva **`ngSubmit`** é usada para disparar um evento de submissão do formulário em Angular, geralmente vinculando uma função do seu componente que irá processar os dados ou realizar alguma ação quando o formulário for submetido.

### 2. **Sintaxe e Uso Comum:**

Normalmente, o `ngSubmit` é colocado diretamente no **elemento `<form>`** para escutar o evento de submissão do formulário. Aqui está o exemplo típico de uso:

### Exemplo de `ngSubmit` no `<form>`:

```html
html
Copiar código
<form [formGroup]="cadastroForm" (ngSubmit)="onSubmit()">
  <!-- Campos do formulário -->
  <button type="submit" [disabled]="cadastroForm.invalid">Enviar</button>
</form>

```

- **`[formGroup]="cadastroForm"`**: Vincula o `FormGroup` (no TypeScript) ao formulário HTML.
- **`(ngSubmit)="onSubmit()"`**: Escuta o evento de submissão do formulário e chama o método `onSubmit()` no seu componente.

### 3. **Por que associar `ngSubmit` ao `<form>`?**

O `ngSubmit` deve ser associado ao formulário, porque é o evento que lida com a **submissão do formulário**. Quando o botão de submit é clicado (ou quando o usuário pressiona Enter em um campo de texto), o formulário é enviado, e o `ngSubmit` é disparado.

### 4. **Alternativas ao `ngSubmit` no `<form>`**

Embora a maneira comum seja associar o `ngSubmit` ao formulário, você também pode capturar o evento de submissão de outras maneiras, mas de forma indireta. Por exemplo, pode associar o `ngSubmit` a um botão fora do formulário ou a outro evento de sua escolha.

### Exemplo usando `ngSubmit` em um botão:

Você pode capturar o evento de submissão usando o `click` em vez do `ngSubmit` diretamente no formulário, como no seguinte exemplo:

```html
html
Copiar código
<form [formGroup]="cadastroForm">
  <!-- Campos do formulário -->
  <button type="button" (click)="onSubmit()" [disabled]="cadastroForm.invalid">Enviar</button>
</form>

```

Aqui, o evento **`(click)`** do botão chama a função `onSubmit()` diretamente, sem precisar do `ngSubmit` no próprio formulário.

### Usando um método adicional para enviar:

Em vez de disparar diretamente o envio, você pode ter uma função intermediária para realizar alguma ação antes de disparar a submissão real.

```html
html
Copiar código
<form [formGroup]="cadastroForm">
  <input formControlName="nome" />
  <button type="button" (click)="submitForm()">Enviar</button>
</form>

```

No componente TypeScript:

```tsx
typescript
Copiar código
submitForm() {
  if (this.cadastroForm.valid) {
    this.onSubmit(); // Submissão ou outra lógica adicional
  } else {
    console.log("Formulário inválido");
  }
}

```

### 5. **Resumindo**:

- **`ngSubmit`** no `<form>` é a maneira **mais recomendada** para capturar a submissão do formulário.
- **Não é obrigatório** colocar o `ngSubmit` no `<form>`, você pode capturar a submissão usando outras técnicas, como associar um evento de clique a um botão dentro ou fora do formulário.
- Contudo, o **`ngSubmit`** no formulário é preferido por ser mais semântico e tratar de forma adequada a submissão de formulários.

Em conclusão, usar **`ngSubmit` no formulário** é a prática comum e semântica, mas você pode usar alternativas para capturar o evento de submissão se desejar.