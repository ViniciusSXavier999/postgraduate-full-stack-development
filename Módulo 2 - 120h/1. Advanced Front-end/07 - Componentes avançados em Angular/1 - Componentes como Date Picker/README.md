# COMPONENTE COMO DATE PICKER

## O QUE É DATE PICKER? (EXEMPLOS)

No Angular, um **Date Picker** (ou "seletor de datas") é um componente usado para permitir que os usuários escolham uma data de forma interativa. Ele geralmente exibe um campo de entrada (input) combinado com um calendário pop-up, onde o usuário pode selecionar uma data.

O **Date Picker** é muito usado em formulários para coletar informações relacionadas a datas, como aniversários, agendamentos, ou datas de início e término de eventos.

---

### **Material Angular Date Picker**

Uma implementação comum do Date Picker no Angular é o **Angular Material**, um conjunto de componentes de interface baseados no Material Design.

### **Exemplo básico com Angular Material**

1. **Instalar o Angular Material**:
Certifique-se de que o Angular Material está instalado no seu projeto:
    
    ```bash
    ng add @angular/material
    
    ```
    
2. **Importar o módulo do Date Picker**:
No seu arquivo de módulo (por exemplo, `app.module.ts`), importe os módulos necessários:
    
    ```tsx
    import { MatDatepickerModule } from '@angular/material/datepicker';
    import { MatNativeDateModule } from '@angular/material/core';
    import { MatFormFieldModule } from '@angular/material/form-field';
    import { MatInputModule } from '@angular/material/input';
    
    @NgModule({
      declarations: [...],
      imports: [
        ...,
        MatDatepickerModule,
        MatNativeDateModule,
        MatFormFieldModule,
        MatInputModule,
      ],
      providers: [MatDatepickerModule]
    })
    export class AppModule {}
    
    ```
    
3. **Adicionar no HTML**:
Agora você pode usar o componente de Date Picker no seu HTML:
    
    ```html
    <mat-form-field appearance="fill">
      <mat-label>Selecione uma data</mat-label>
      <input matInput [matDatepicker]="picker">
      <mat-datepicker-toggle matSuffix [for]="picker"></mat-datepicker-toggle>
      <mat-datepicker #picker></mat-datepicker>
    </mat-form-field>
    
    ```
    

### Funcionamento do código:

- **`<mat-form-field>`**: Cria um contêiner para o campo de entrada.
- **`matInput`**: Define o campo de entrada como um input do Angular Material.
- **`[matDatepicker]="picker"`**: Vincula o campo de entrada ao Date Picker identificado pelo `#picker`.
- **`<mat-datepicker-toggle>`**: Adiciona um ícone para abrir o calendário.
- **`<mat-datepicker>`**: Define o componente de calendário.

---

### **Personalização do Date Picker**

O Angular Material Date Picker pode ser personalizado para atender a diferentes necessidades:

1. **Formatar a Data**:
Para alterar o formato padrão da data (que pode ser no padrão ISO 8601), você pode usar um **Date Adapter** ou um serviço como `MAT_DATE_FORMATS`:
    
    ```tsx
    import { MAT_DATE_FORMATS } from '@angular/material/core';
    
    export const MY_DATE_FORMATS = {
      parse: {
        dateInput: 'DD/MM/YYYY',
      },
      display: {
        dateInput: 'DD/MM/YYYY',
        monthYearLabel: 'MMMM YYYY',
        dateA11yLabel: 'LL',
        monthYearA11yLabel: 'MMMM YYYY',
      },
    };
    
    @NgModule({
      providers: [
        { provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMATS }
      ],
    })
    export class AppModule {}
    
    ```
    
2. **Restringir o intervalo de datas**:
Você pode definir datas mínimas e máximas para o Date Picker:
    
    ```html
    <mat-form-field appearance="fill">
      <mat-label>Selecione uma data</mat-label>
      <input matInput [matDatepicker]="picker" [min]="minDate" [max]="maxDate">
      <mat-datepicker-toggle matSuffix [for]="picker"></mat-datepicker-toggle>
      <mat-datepicker #picker></mat-datepicker>
    </mat-form-field>
    
    ```
    
    No componente TypeScript:
    
    ```tsx
    minDate = new Date(2020, 0, 1); // 1º de Janeiro de 2020
    maxDate = new Date(2025, 11, 31); // 31 de Dezembro de 2025
    
    ```
    

---

### **Outras Bibliotecas de Date Picker**

Além do Angular Material, existem outras bibliotecas populares que oferecem Date Pickers com funcionalidades avançadas e estilos diferentes:

1. **ngx-bootstrap**:
    
    ```bash
    npm install ngx-bootstrap --save
    
    ```
    
    [Documentação oficial do ngx-bootstrap](https://valor-software.com/ngx-bootstrap/).
    
2. **ng-bootstrap**:
    
    ```bash
    npm install @ng-bootstrap/ng-bootstrap
    
    ```
    
    [Documentação oficial do ng-bootstrap](https://ng-bootstrap.github.io/).
    
3. **PrimeNG**:
    
    ```bash
    npm install primeng --save
    
    ```
    
    [Documentação oficial do PrimeNG](https://primefaces.org/primeng).
    

---

### **Resumo**

- Um **Date Picker** é um componente interativo para seleção de datas.
- O Angular Material oferece uma implementação robusta e personalizável.
- Você pode alterar o formato de exibição, restringir intervalos de datas e integrá-lo facilmente em formulários.
- Outras bibliotecas, como ngx-bootstrap e PrimeNG, também fornecem Date Pickers com estilos e funcionalidades diferentes.

---

---

---

🏆 Vamos explorar outros tipos de componentes do Angular material


> Caso você esteja trabalhando com o Angular Material isso facilita muito, pois basta ir em componentes e procurar por Date picker
> 

### VAMOS PEGAR O CÓDIGO DO DATE PICKER DO SITE DO ANGULAR MATERIAL E ADICIONAR NO COMPONENTE DE CADASTRO PRIMEIRAMENTE

```html
<mat-form-field>
<mat-label>Choose a date</mat-label>
<input matInput [matDatepicker]="picker">
<mat-hint>MM/DD/YYYY</mat-hint>
<mat-datepicker-toggle matIconSuffix [for]="picker"></mat-datepicker-toggle>
<mat-datepicker #picker></mat-datepicker>
</mat-form-field>
```

🚨 IMPORTAR OS SEGUINTES COMPONENTES NO COMPONENTE QUE VOCÊ VAI UTILIZAR

```tsx
    MatFormFieldModule, 
    MatInputModule, 
    MatDatepickerModule
```

NO APP.CONFIG IMPORTAR NO PROVIDERS

```html
 provideNativeDateAdapter()
```

> Varia de acordo com as versões do Angular, ficar atento na versão do Angular Material que o site do Angular está.
> 

> Precisamos adicionar o formControl para que funcione corretamente
> 

> Depois adicionar no formGroup do componente
> 

```tsx
 dataNascimento: [null, Validators.required],
```

🚨 Fiz apenas um ajusto no padding do meu campo senha

