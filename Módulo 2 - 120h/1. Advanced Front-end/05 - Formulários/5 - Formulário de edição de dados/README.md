# FORMULÁRIO DE EDIÇÃO DE DADOS

## APÓS REALIZAR O TESTE PODEMOS OBSERVAR QUE O USUÁRIO FOI SALVO COM SUCESSO E ESTÁ TUDO FUNCIONANDO

> Se formos em armazenamento e seção podemos ver que o objeto foi salvo lá
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/formedicao1.png" />

---

---

---

## AGORA VAMOS CRIAR O COMPONENTE DE EDITAR FORMULÁRIO

```tsx
ng g c pages/editar
```

> Daria para fazer tudo no mesmo componente.
> 

---

❓ Como eu recupero o nosso formulário e preenchesse os dados na tela, já esta armazenado lá, mas como eu entraria nessa tela de editar?

---

## 1. VAMOS CRIAR UMA VARIAVEL QUE VAI SER NECESSARIA PARA QUE O ADDRESSFORM SEJA ACESSADO DENTRO DO COMPONENTE E FORA DELE NO HTML

```tsx
addressForm: any
```

## 2. COLOCAR O ADDRESS FORM DENTRO DO CONSTRUTOR E CRIAR LÓGICA PARA PEGAR (GET) OS DADOS DO LOCA STORAGE

```tsx
export class EditarComponent {

  // DENTRO DO FORMBUILDER TEMOS OS VALORES DOS DADOS
  private fb = inject(FormBuilder);
  user: User = new User();
  addressForm:any
  email: any
  
  constructor(){

    // PEGANDO O OBJETO
    if(localStorage.getItem('user')){
        // desserializando o objeto
        this.user = JSON.parse(localStorage.getItem('user') || '{}')
    }
    this.addressForm = this.fb.group({
      /* na nossa regra de negócio o nome vai ter no minimo 2 letras e no max 70 letras */
      // Ao inves de 'null' estamos dizendo que o formulario vai ter como dado de inicalização o valor que meu atributo do user receber
      firstName: [this.user.firstName, Validators.compose([Validators.required, Validators.minLength(2), Validators.maxLength(70)])],
      email: [null, Validators.compose([
        Validators.required, Validators.minLength(5), Validators.maxLength(50), Validators.email])
      ],
      phone: [this.user.phone, Validators.required],
      /* Se passarmos como "free" ele iria passar essa informação lá para o formulario dessa forma, mas não queremos desse jeito, por isso vamos colocar como "null" */
      password: [null, Validators.required]
    });

     
  this.email = this.addressForm.controls['email']

  }
```

## 3. POR ULTIMO CRIAR A ROTA DO COMPONENTE E REALIZAR OS TESTES NECESSÁRIOS

```tsx
{path: 'editar', component: EditarComponent},
```

---

## CONCLUSÃO E TESTES

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/formedicao2.png" />

🏆 Os campos serão renderizados automaticamente com os dados do user que foram puxados pelo ‘localStorage.getItem(’user’)’

---

### EXPLICAÇÃO DETALHADA

Esse código define um **componente Angular** chamado `EditarComponent`, que é utilizado para editar as informações de um usuário. Vou explicar o que cada parte do código faz.

### 1. **Declaração e inicialização do `FormBuilder`**:

```tsx
private fb = inject(FormBuilder);

```

- **`private fb = inject(FormBuilder)`**: Aqui, o **`FormBuilder`** está sendo injetado no componente. O **`FormBuilder`** é uma ferramenta do Angular que facilita a criação de formulários reativos.
- A partir do Angular 14, foi introduzida a função **`inject()`**, que substitui o uso do construtor para injeção de dependência. Isso é útil para simplificar a injeção de serviços diretamente em variáveis privadas. No caso, o `FormBuilder` está sendo usado para construir o formulário reativo (`addressForm`).

### 2. **Propriedades do Componente**:

```tsx
user: User = new User();
addressForm: any;
email: any;

```

- **`user: User = new User();`**: Aqui, a variável `user` é criada com o tipo `User` e é inicializada com um novo objeto `User`. Isso provavelmente se refere a um modelo ou classe que contém os dados do usuário (como `firstName`, `email`, `phone`, etc.).
- **`addressForm: any;`**: A variável `addressForm` é usada para armazenar o formulário reativo, mas o tipo `any` é utilizado aqui, o que poderia ser mais específico (como `FormGroup`).
- **`email: any;`**: A variável `email` parece ser uma propriedade para armazenar o email do usuário, mas não está sendo utilizada diretamente no código mostrado.

### 3. **Construtor e Inicialização dos Dados**:

```tsx
constructor(){
    if(localStorage.getItem('user')){
        // desserializando o objeto
        this.user = JSON.parse(localStorage.getItem('user') || '{}');
    }
    this.addressForm = this.fb.group({
        firstName: [this.user.firstName, Validators.compose([Validators.required, Validators.minLength(2), Validators.maxLength(70)])],
        email: [this.user.email, Validators.compose([
            Validators.required, Validators.minLength(5), Validators.maxLength(50), Validators.email
        ])],
        phone: [this.user.phone, Validators.required],
        password: [null, Validators.required]
    });
}

```

### **Deserializando o Objeto `user` de `localStorage`**:

```tsx
if(localStorage.getItem('user')){
    this.user = JSON.parse(localStorage.getItem('user') || '{}');
}

```

- O código acima verifica se existe um item chamado `'user'` armazenado no **`localStorage`** do navegador.
- Se o item `'user'` existir, ele será recuperado e desserializado (transformado de uma string JSON para um objeto JavaScript) usando **`JSON.parse()`**.
- Se não houver nada no `localStorage` (o que significa que o valor de `'user'` não foi encontrado), o valor padrão será um objeto vazio **`{}`**.

### **Construção do Formulário Reativo**:

```tsx
this.addressForm = this.fb.group({
    firstName: [this.user.firstName, Validators.compose([Validators.required, Validators.minLength(2), Validators.maxLength(70)])],
    email: [this.user.email, Validators.compose([
        Validators.required, Validators.minLength(5), Validators.maxLength(50), Validators.email
    ])],
    phone: [this.user.phone, Validators.required],
    password: [null, Validators.required]
});

```

- **`this.addressForm = this.fb.group({...})`**: Aqui, o formulário reativo é criado com **`FormBuilder`**. O **`FormGroup`** contém campos que são definidos através de um objeto, onde as chaves são os nomes dos campos e os valores são arrays com o valor inicial e as validações do campo.
    
    **Campos e Validações:**
    
    - **`firstName`**: O campo `firstName` é inicializado com o valor `this.user.firstName` (ou seja, o nome do usuário recuperado de `localStorage` ou um valor vazio se não existir). As validações são:
        - **`Validators.required`**: O campo é obrigatório.
        - **`Validators.minLength(2)`**: O nome deve ter no mínimo 2 caracteres.
        - **`Validators.maxLength(70)`**: O nome pode ter no máximo 70 caracteres.
    - **`email`**: O campo `email` é inicializado com o valor `this.user.email`. As validações para o email são:
        - **`Validators.required`**: O campo é obrigatório.
        - **`Validators.minLength(5)`**: O email deve ter no mínimo 5 caracteres.
        - **`Validators.maxLength(50)`**: O email pode ter no máximo 50 caracteres.
        - **`Validators.email`**: O valor precisa ser um email válido.
    - **`phone`**: O campo `phone` é inicializado com `this.user.phone` e é obrigatório (`Validators.required`).
    - **`password`**: O campo `password` é inicializado com **`null`** e é obrigatório (`Validators.required`). O valor `null` indica que o campo começará vazio.

### Resumo Geral:

- Este código define um **componente Angular** que contém um formulário reativo (`addressForm`) para editar informações do usuário.
- O formulário é inicializado com os dados do usuário, que são carregados de **`localStorage`** (se estiverem presentes).
- Validações são aplicadas em cada campo do formulário para garantir que os dados inseridos estejam corretos (por exemplo, o nome deve ter no mínimo 2 caracteres e o email precisa ser válido).
- O componente também define uma propriedade **`user`** que mantém as informações do usuário, recuperadas do **`localStorage`**.

O código é um exemplo de como usar o **FormBuilder** para criar formulários reativos no Angular, além de demonstrar como carregar dados persistidos no navegador (via **`localStorage`**) para preencher campos do formulário.

## OS DADOS SALVOS APARECERAM DESSA FORMA NO LOCAL STORAGE

<img width="900" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/formedicao3.png" />

> Podendo ser feita a edição a partir do componente de editar
> 

## APÓS CLICAR NO BOTÃO EDITAR, AS EDIÇÕES SERAM SALVAS

<img width="900" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/formedicao4.png" />