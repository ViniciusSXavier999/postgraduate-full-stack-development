# COMO SALVAR OS DADOS NA REST API?

🏆 Vamos agora salvar dados no json-server (arquivo db.json)


---

- [ ]  1. VAMOS VERIFICAR SE O JSON-SERVER ESTÁ RODANDO

```tsx
 npx json-server db.json
```

- [ ]  2. VERIFICAR SE A FUNÇÃO QUE SALVA NO JSON SERVER ESTÁ CONFIGURADA

```tsx
 addUser(user:any): Observable<User>{
    return this.segurancaHttp.post<User>(this.BASE_URL + 'users', user, httpOptions)
  }

```

- [ ]  3. ADICIONAR O USERSERVICE NO PROVIDERS DO APPCONFIG

❓ POR QUE ADICIONAR O USERSERVICE NO PROVIDERS?

Adicionar a classe de serviço no **`providers`** é uma maneira de garantir que o Angular possa criar e gerenciar a instância do serviço quando necessário. Hoje, com **`providedIn: 'root'`**, na maioria dos casos não é necessário registrar o serviço manualmente no **`providers`**, mas essa prática ainda é útil em casos específicos, como para criar instâncias locais ou para serviços sem `providedIn`.


### DÚVIDA SOBRE PROVIDERS

[ProvidedIn vs Providers | Fórum Alura](https://cursos.alura.com.br/forum/topico-providedin-vs-providers-122381)

### DIFERENÇA ENTRE PROVIDERS E PROVIDERIN

Não, `providedIn` e `providers` não são exatamente a mesma coisa, mas ambos estão relacionados à configuração de dependências no Angular, especificamente para fornecer serviços.

Aqui estão as diferenças principais entre eles:

### 1. **`providedIn`**:

- **Onde é usado**: Usado dentro de um serviço (classe).
- **Propósito**: O `providedIn` define onde o serviço será fornecido e torna o serviço disponível para injeção de dependência em todo o aplicativo.
- **Exemplo de uso**:
    
    ```tsx
    @Injectable({
      providedIn: 'root'  // O serviço será fornecido no nível raiz (app-wide)
    })
    export class MeuServico {
      constructor() {}
    }
    
    ```
    
- **Comportamento**: Ao usar `providedIn: 'root'`, o Angular cria um único exemplo do serviço e o disponibiliza globalmente. Isso faz parte do sistema de injeção de dependência de Angular, ajudando a garantir que o serviço seja singleton no aplicativo.
- **Outros valores possíveis**: `'root'`, `'platform'`, `'any'`, ou até mesmo um módulo específico onde o serviço será fornecido.

### 2. **`providers`**:

- **Onde é usado**: Usado em módulos, componentes, ou outros lugares de configuração do Angular.
- **Propósito**: O `providers` é uma maneira mais explícita de configurar e fornecer serviços no Angular. Ele lista os serviços que o Angular deve injetar em determinado escopo.
- **Exemplo de uso**:
    
    ```tsx
    @NgModule({
      providers: [MeuServico]  // Define explicitamente os serviços a serem fornecidos no módulo
    })
    export class MeuModulo {}
    
    ```
    
- **Comportamento**: Os serviços listados em `providers` podem ser fornecidos globalmente (se no módulo raiz) ou localmente (se em módulos ou componentes específicos).

### Diferença principal:

- `providedIn` é uma forma simplificada e moderna de registrar um serviço, diretamente dentro da classe do serviço, sem a necessidade de configuração adicional no módulo ou componente.
- `providers` é mais flexível e pode ser usado em módulos, componentes ou diretamente no bootstrap do Angular, proporcionando maior controle sobre o escopo e a criação do serviço.

**Em resumo**:

- `providedIn` é uma configuração declarativa diretamente dentro da classe do serviço.
- `providers` é usado para declarar serviços dentro de módulos ou componentes.

- [ ]  4. INJETAR O USERSERVICE DO MEU COMPONENTE DE CADASTRO

```tsx
  // INJETANDO SERVICE NO MEU COMPONENTE
  private service = inject(UserService)
```

- [ ]  5. CONFERIR SE COLOCOU O CPF E SUAS CONFIGURAÇÕES NO TS DO CADASTRO

```tsx
if(this.addressForm.controls['cpf'].value)
      this.user.phone = this.addressForm.controls['cpf'].value
```

- [ ]  6. REMOVER O USER.ID DE EXEMPLO

```tsx
// [this.user.id](http://this.user.id/) = '1'
```

---

---

---

## COMEÇANDO DE FATO A IMPLEMENTAÇÃO DO SERVICE

💡 Vamos utilizar o subscribe do RXJS para fazer uma chamada assíncrona, mas poderíamos utilizar:

- PIPE
- CATCH ERRO
- TAP

💡 FUNÇÃO IMPORTANTE

```tsx
 this.service.addUser(this.user).subscribe({  // O SUBSCRIBE É OBRIGÁTORIO EM UM OBSERVABLE
    next: (response) => {
      console.log(response)
      alert('Dado registrado com sucesso')
    },
    error: (erro: any) => {
      console.log(erro)
      alert('Ocorreu algum erro')
    }
   })   
  }
}

```

> Quando eu executo essa função, eu vou estar executando a função lá do service addUser() que vai fazer uma requisição HTTP post passando o user para a url que está no método.
> 

> Ele vai chamar essa função, o subscribe serve para controlar essa chamada assíncrona, ele vai ficar observando.
> 

> É um callback, ele vai fazer uma requisição e quando eu receber esse dado ele vai entrar no next, no tempo que eu não estou recebendo nada, esse código vai ficar parado esperando essa requisição
> 

> Ele espera a resposta de um objeto do tipo USER, ele valida se esse objeto esta correto ou não
> 

💡 Toda chamada para API vai ser através do service, vai ser uma chamada assincrona e vai mandar e vai esperar receber o dado


💡 callback → **callback** é uma função que é passada como argumento para outra função e é executada depois que essa função principal termina sua execução.


## EXPLICAÇÃO DO CÓDIGO

Esse trecho de código está utilizando o **RxJS** no Angular para realizar uma operação assíncrona (como uma chamada HTTP para adicionar um usuário). Vamos analisá-lo por partes:

---

### **1. `this.service.addUser(this.user)`**

Aqui, o método **`addUser`** da instância de serviço (**`this.service`**) é chamado, passando como parâmetro um objeto **`this.user`**.

- Presumivelmente, **`addUser`** é uma função do serviço que faz uma chamada HTTP para adicionar um novo usuário ao servidor. Por exemplo:

O método **`addUser`** retorna um **`Observable`**, que é um dos principais conceitos do **RxJS** no Angular. Ele representa uma **sequência de eventos assíncronos**.
    
    ```tsx
    addUser(user: User): Observable<any> {
      return this.http.post('https://api.example.com/users', user);
    }
    
    ```
    

---

### **2. `.subscribe()`**

O **`subscribe`** é a maneira de **consumir** ou "escutar" os eventos emitidos por um **`Observable`**. Ele é obrigatório para que o **`Observable`** comece a executar seu trabalho (nesse caso, enviar a solicitação HTTP).

- Sem o **`subscribe`**, o Observable não faz nada, porque é "preguiçoso" por padrão (Lazy Loading).

O método **`subscribe`** aceita um objeto com os seguintes callbacks:

1. **`next`**: Executado quando o Observable emite um valor com sucesso.
2. **`error`**: Executado se ocorrer um erro durante a execução do Observable.
3. **`complete`** (opcional): Executado quando o Observable conclui sua tarefa.

---

### **3. O objeto passado para `subscribe`**

O objeto passado ao **`subscribe`** contém os callbacks para lidar com os diferentes resultados do Observable:

### **Callback `next`**

```tsx
next: (response) => {
  console.log(response);
  alert('Dado registrado com sucesso');
}

```

- Executado quando o Observable retorna um valor bem-sucedido.
- Aqui, o código:
    1. **Exibe a resposta no console** (`console.log(response)`).
    2. **Exibe um alerta de sucesso** com a mensagem `'Dado registrado com sucesso'`.

### **Callback `error`**

```tsx
error: (erro: any) => {
  console.log(erro);
  alert('Ocorreu algum erro');
}

```

- Executado se ocorrer um erro na operação (por exemplo, se o servidor retornar um erro ou não puder ser alcançado).
- Aqui, o código:
    1. **Exibe o erro no console** (`console.log(erro)`).
    2. **Exibe um alerta indicando que ocorreu um erro**.

### **Callback `complete` (não usado aqui)**

Se usado, seria algo assim:

```tsx
complete: () => {
  console.log('Operação concluída');
}

```

- Executado quando o Observable conclui sua tarefa (independentemente de sucesso ou falha).
- Não é obrigatório, mas útil se você quiser realizar algo ao final.

---

### **Fluxo do Código**

1. O método **`addUser`** é chamado para enviar os dados do usuário ao servidor.
2. O Observable retornado é "escutado" usando o **`subscribe`**.
3. Dependendo do resultado:
    - **Sucesso (`next`)**: O servidor confirma que o usuário foi registrado, e a mensagem de sucesso é exibida.
    - **Erro (`error`)**: Um problema na requisição (como falha de rede ou erro no servidor) é tratado, exibindo uma mensagem de erro.

---

### **Por que o `subscribe` é obrigatório?**

- Um **`Observable`** é "preguiçoso". Ele só começa a executar seu trabalho quando alguém **se inscreve** nele (ou seja, chama o `subscribe`).
- Sem o **`subscribe`**, a chamada HTTP nunca seria feita e nenhum resultado seria processado.

---

### **Exemplo Completo**

Aqui está o código de um serviço e um componente que utiliza esse padrão:

### Serviço (`user.service.ts`):

```tsx
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) {}

  addUser(user: any): Observable<any> {
    return this.http.post('https://api.example.com/users', user);
  }
}

```

### Componente (`user.component.ts`):

```tsx
import { Component } from '@angular/core';
import { UserService } from './user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html'
})
export class UserComponent {
  user = { name: 'João', email: 'joao@example.com' };

  constructor(private service: UserService) {}

  saveUser() {
    this.service.addUser(this.user).subscribe({
      next: (response) => {
        console.log(response);
        alert('Dado registrado com sucesso');
      },
      error: (erro: any) => {
        console.log(erro);
        alert('Ocorreu algum erro');
      }
    });
  }
}

```

### HTML do Componente (`user.component.html`):

```html
<button (click)="saveUser()">Salvar Usuário</button>

```

---

### **Resumo**

- O **`subscribe`** é usado para consumir eventos de um **`Observable`**.
- **`next`**, **`error`**, e **`complete`** são callbacks que permitem tratar diferentes resultados da operação.
- Sem o **`subscribe`**, o Observable não será executado.
- Esse padrão é essencial para lidar com chamadas assíncronas no Angular (como requisições HTTP).


## APÓS O TESTE SER FEITO



<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/comoSalvarDados1.png" />

---

---

---

## DÚVIDAS DURANTE A AULA

### O que signfica o 'response' no parametro de next?

No contexto do **`next`** em um **`subscribe`** de um **`Observable`**, o **`response`** é o parâmetro que representa a **resposta** ou o **valor retornado** pelo **Observable** quando ele emite um evento bem-sucedido.

### Explicando mais detalhadamente:

### 1. **O que é o `next`?**

- O **`next`** é um **callback** (função de retorno) que é chamado quando o **Observable** emite um valor de sucesso.
- Esse valor pode ser qualquer coisa que o Observable esteja emitindo, como o corpo de uma resposta HTTP, um resultado de um cálculo, ou qualquer outro valor gerado de maneira assíncrona.

### 2. **O que é o `response`?**

- **`response`** é o **valor** que foi retornado pelo **Observable** no caso de sucesso. No exemplo de uma chamada HTTP, por exemplo, a **`response`** pode ser a resposta do servidor após o envio dos dados.
- Esse valor pode ser um objeto, um array, uma string, ou qualquer outro tipo de dado que o Observable esteja emitindo.

### Exemplo de uma Chamada HTTP:

Vamos usar o exemplo de um serviço Angular que faz uma solicitação HTTP e retorna um **Observable**. Quando a resposta da solicitação HTTP chega ao cliente, o **`next`** é chamado e o valor retornado pelo servidor é passado como o parâmetro **`response`**.

### Código do serviço (com uma requisição HTTP):

```tsx
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) {}

  // Método que faz uma requisição POST e retorna um Observable
  addUser(user: any): Observable<any> {
    return this.http.post('https://api.example.com/users', user);
  }
}

```

### Componente:

```tsx
import { Component } from '@angular/core';
import { UserService } from './user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html'
})
export class UserComponent {
  user = { name: 'João', email: 'joao@example.com' };

  constructor(private service: UserService) {}

  saveUser() {
    this.service.addUser(this.user).subscribe({
      next: (response) => {
        // O parâmetro 'response' é o valor retornado pela requisição HTTP
        console.log('Resposta do servidor:', response);
        alert('Dado registrado com sucesso');
      },
      error: (erro: any) => {
        console.log('Erro:', erro);
        alert('Ocorreu algum erro');
      }
    });
  }
}

```

### O que acontece:

- O método **`addUser`** faz uma **requisição HTTP** para o servidor, retornando um **Observable**.
- No **`subscribe`**, o **`next`** é chamado quando a requisição é concluída com sucesso e a resposta é recebida.
- A resposta do servidor (por exemplo, um objeto com informações sobre o usuário ou um código de status de sucesso) é passada para o parâmetro **`response`**.

---

### **Exemplo de `response`**

Suponha que a resposta do servidor seja algo como:

```json
{
  "id": 123,
  "name": "João",
  "email": "joao@example.com"
}

```

Esse **objeto JSON** seria passado para o parâmetro **`response`** e impresso no console como:

```tsx
console.log('Resposta do servidor:', response);
// Exemplo de saída no console:
// Resposta do servidor: { id: 123, name: "João", email: "joao@example.com" }

```

---

### **Resumo**:

- **`next`** é a função de retorno chamada quando o **Observable** emite um valor com sucesso.
- **`response`** é o valor que o **Observable** retorna, seja uma resposta de uma chamada HTTP, um valor calculado, ou outro tipo de dado.
- Esse parâmetro **`response`** pode ser qualquer dado que o servidor ou a operação assíncrona retorne, e é manipulado no **callback `next`**.

---

---

---

### Poderia ser outro nome no response ?

Sim, o nome **`response`** pode ser qualquer outro nome, desde que você se refira a ele corretamente no código. O nome é apenas uma convenção e pode ser alterado de acordo com a sua preferência, desde que você o use de forma consistente dentro do **callback `next`**.

Por exemplo, você poderia mudar o nome do parâmetro de **`response`** para **`data`**, **`result`**, **`res`**, ou qualquer outro nome que faça mais sentido para o seu contexto.

### Exemplo com **`data`** em vez de **`response`**:

```tsx
this.service.addUser(this.user).subscribe({
  next: (data) => {
    console.log('Dados retornados do servidor:', data);
    alert('Dado registrado com sucesso');
  },
  error: (erro: any) => {
    console.log('Erro:', erro);
    alert('Ocorreu algum erro');
  }
});

```

Neste exemplo:

- **`data`** agora é o parâmetro que representa a resposta retornada pelo **Observable**, mas a funcionalidade é a mesma. Você pode acessar os dados retornados e manipulá-los conforme necessário.

### Resumo:

- O nome do parâmetro no **`next`** pode ser alterado para qualquer nome que você preferir (como **`data`**, **`result`**, **`response`**, etc.).
- O importante é que esse nome representa o **valor retornado pelo Observable** e deve ser usado dentro do **callback `next`** para manipular os dados corretamente.

---

---

---

## DURANTE AULA MEUS ID NÃO ESTAVAM SENDO GERADOS AUTOMATICAMENTE, ENTÃO DECIDI IR AO STACKOVERFLOW
[MINHA DÚVIDA NO STACKOVERFLOW](https://stackoverflow.com/questions/79260921/how-can-i-generate-my-ids-automatically-with-json-server-does-it-no-longer-gene/79261064?noredirect=1#comment139778786_79261064)