# COMO SALVAR OS DADOS NO LOCAL STORAGE?

## O QUE É LOCAL STORAGE?

O **local storage** é uma funcionalidade do navegador web que permite armazenar dados localmente no dispositivo do usuário, de forma persistente. Ele é uma das APIs disponíveis no **Web Storage**, que também inclui o **session storage**. Esses dados permanecem armazenados mesmo quando o navegador é fechado e reaberto, diferentemente do session storage, que é apagado assim que a aba ou sessão é encerrada.

### Características principais do local storage:

1. **Persistência**: Os dados permanecem no navegador até que sejam removidos manualmente pelo usuário ou programaticamente pelo desenvolvedor.
2. **Capacidade**: Geralmente, cada domínio pode armazenar cerca de **5 a 10 MB** de dados, dependendo do navegador.
3. **Acesso local**: Os dados só podem ser acessados pelo mesmo domínio que os armazenou, garantindo certo nível de segurança.
4. **Baseado em chave-valor**: Armazena pares de chave e valor como strings.

### Exemplos de uso:

- Salvar preferências do usuário (tema claro/escuro).
- Manter informações de formulário para preenchimento posterior.
- Criar uma funcionalidade simples de carrinho de compras sem backend.

### Como usar local storage em JavaScript:

### Gravar dados:

```jsx
localStorage.setItem('nome', 'João');

```

### Recuperar dados:

```jsx
let nome = localStorage.getItem('nome');
console.log(nome); // "João"

```

### Remover dados:

```jsx
localStorage.removeItem('nome');

```

### Limpar todos os dados:

```jsx
localStorage.clear();

```

O local storage é muito útil para funcionalidades que não exigem interações complexas ou armazenamento de dados sensíveis (como senhas), já que os dados ficam expostos no navegador e podem ser manipulados por usuários mal-intencionados.

---

> DENTRO DO FORMBUILDER TEMOS OS VALORES DOS DADOS
> 

### Existem diversas maneiras de gravar dados localmente no navegador:

- Session Storage
- Local Storage
- Cookie

📌 O local storage não é um banco de dados, é uma memória que você consegue guardar informação, se você fechar e abrir o navegador, ela vai continuar lá, a não ser que esteja usando aba anônima.


🏆 Vamos utilizar o local Storage, vamos simular como se tivéssemos gravando em um banco de dados, mas esse banco de dados vai ser local, depois vamos editar esse formulário, pegando os dados que foram salvos e editando eles.


---

## 1. PRIMEIRO VAMOS VERIFICAR SE O OBJETO(CLASSE) USER ESTÁ OK

```tsx

export class User {
    public id: String = ''
    public firstName: String = ''
    public phone: String = ''
    public email: String = ''
}
```

## 2. REALIZAR MODIFICAÇÕES NO CADASTRO.COMPONENT.TS

> Vou Criar um novo objeto do tipo User
> 

```html
  user: User = **new** User
```

### 3. AGORA VOU COMEÇAR PEGAR OS DADOS DESSE USER

📌 Agora vou começar pegar os dados desse usuário (user)

```tsx
  onSubmit(): void {
    this.user.id = '1'

    // Pegando os dados que meu usuário preencher no campo firstName e atribuindo a variavel do meu objeto user
    if(this.addressForm.controls['firstName'].value)
      this.user.firstName = this.addressForm.controls['firstName'].value

    if(this.addressForm.controls['email'].value)
      this.user.firstName = this.addressForm.controls['email'].value

    if(this.addressForm.controls['phone'].value)
      this.user.firstName = this.addressForm.controls['phone'].value

    if(this.addressForm.controls['password'].value)
      this.user.firstName = this.addressForm.controls['password'].value
    
    alert('Entrou no onSubmit');
  }
} 
 
 
 // if(this.addressForm.controls['firstName'].value)
  //    this.user.firstName = this.addressForm.controls['firstName'].value
```

> Eu poderia fazer somente dessa forma `this.user = =this.addressForm.value`  porém user tem o id e estamos passando um valor diferente
> 

> Estamos pegando o valor que tem no formulário e transformando ele em um objeto
> 

🏆 Significado do código acima

Esse trecho de código provavelmente está escrito em **TypeScript** e é comum em aplicações **Angular**. Ele verifica se um campo de formulário (`firstName`) possui um valor antes de atribuí-lo a uma propriedade de um objeto (`user`). Vamos analisar cada parte:

---

### Código:

```tsx
typescript
Copiar código
if (this.addressForm.controls['firstName'].value)
    this.user.firstName = this.addressForm.controls['firstName'].value;

```

### Explicação detalhada:

1. **`this.addressForm.controls['firstName']`**
    - `this.addressForm`: Refere-se a um formulário reativo criado no Angular usando `FormGroup`.
    - `.controls`: É uma propriedade do `FormGroup` que contém todos os controles (campos) do formulário.
    - `['firstName']`: Acessa o controle chamado `firstName` dentro do formulário. Este é o campo de entrada que o código está verificando.
2. **`.value`**
    - Obtém o valor atual do campo `firstName`. Este é o dado inserido pelo usuário no formulário.
3. **`if (this.addressForm.controls['firstName'].value)`**
    - Verifica se o valor do campo `firstName` **não é vazio**, **nulo** ou **indefinido**.
    - Se houver um valor, a condição será verdadeira.
4. **`this.user.firstName = this.addressForm.controls['firstName'].value;`**
    - Se a condição for verdadeira, o valor do campo `firstName` será atribuído à propriedade `firstName` de um objeto chamado `user`.
    - Aqui, `this.user` provavelmente é uma instância de uma classe ou um objeto que representa o usuário.

---

### Fluxo do código:

- **Se o campo `firstName` do formulário possui algum valor**:
    
    O valor será atribuído à propriedade `firstName` do objeto `user`.
    
- **Se o campo está vazio (ou nulo)**:
    
    Nada será atribuído, e o código segue em frente.
    

---

### Exemplo prático:

### Suponha que temos o seguinte `FormGroup`:

```tsx
typescript
Copiar código
this.addressForm = new FormGroup({
    firstName: new FormControl(''), // Inicialmente vazio
    lastName: new FormControl('')
});

this.user = {
    firstName: '',
    lastName: ''
};

```

### Caso de uso no código:

1. Se o usuário insere **"João"** no campo `firstName`:
    - `this.addressForm.controls['firstName'].value` será `"João"`.
    - A propriedade `this.user.firstName` será atualizada para `"João"`.
2. Se o campo `firstName` está vazio:
    - A condição será falsa, e `this.user.firstName` não será alterado.

## 4. SALVANDO NO LOCALSTORAGE E CONVERTENDO O OBJETO PARA STRING

```tsx
  localStorage.setItem('user', JSON.stringify(this.user)) 
```

> Estamos pegando o objeto que está na memória e estamos serializando ele e convertendo ele para string e salvando ele para string
> 

🏆 SIGNFICADO DO CÓDIGO 

Essa linha de código armazena dados no **local storage** do navegador. Vamos analisar cada parte em detalhes:

---

### Código:

```jsx
localStorage.setItem('user', JSON.stringify(this.user));

```

### Explicação detalhada:

1. **`localStorage`**
    - É um objeto global disponível no navegador que permite armazenar dados no formato de **chave-valor**.
    - Os dados armazenados no `localStorage` são persistentes, ou seja, permanecem disponíveis mesmo após o fechamento do navegador.
2. **`setItem(chave, valor)`**
    - Método usado para **salvar** dados no local storage.
    - **Parâmetros**:
        - **`chave`**: Uma string que representa o nome ou identificador do dado (neste caso, `'user'`).
        - **`valor`**: Uma string que representa o valor associado à chave. Como o local storage só aceita strings, qualquer outro tipo de dado precisa ser convertido para string.
3. **`'user'`**
    - É a chave usada para identificar os dados armazenados.
    - Ao usar esta chave futuramente, é possível recuperar os dados armazenados.
4. **`JSON.stringify(this.user)`**
    - O método `JSON.stringify()` converte um objeto JavaScript (neste caso, `this.user`) em uma string no formato JSON.
    - Isso é necessário porque o local storage só armazena **strings**.
    - Por exemplo:
        - Objeto: `{ name: 'João', age: 25 }`
        - Após `JSON.stringify()`: `"{"name":"João","age":25}"`

---

### O que esse código faz?

Ele salva no local storage os dados do objeto `this.user`, convertendo-o em uma string JSON.

- **Chave:** `'user'`
- **Valor:** Uma string JSON representando o objeto `this.user`.

---

### Exemplo prático:

### Suponha que `this.user` contém o seguinte objeto:

```jsx
this.user = {
    name: 'João',
    age: 25,
    email: 'joao@example.com'
};

```

### Após executar a linha:

```jsx
localStorage.setItem('user', JSON.stringify(this.user));

```

O `localStorage` conterá:

- **Chave:** `'user'`
- **Valor armazenado:** `'{"name":"João","age":25,"email":"joao@example.com"}'`

---

### Como recuperar esse dado?

Para recuperar os dados salvos no local storage:

```jsx
let userString = localStorage.getItem('user'); // Obtém a string JSON
let userObject = JSON.parse(userString); // Converte de volta para objeto
console.log(userObject.name); // "João"

```

---

### Resumo:

- **`localStorage.setItem('user', JSON.stringify(this.user))`**: Salva o objeto `this.user` no local storage, convertendo-o em string JSON.
- É uma forma comum de armazenar objetos complexos no navegador para uso posterior.
