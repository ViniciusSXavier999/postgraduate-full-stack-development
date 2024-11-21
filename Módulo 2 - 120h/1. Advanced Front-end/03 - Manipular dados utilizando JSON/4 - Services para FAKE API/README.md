# SERVICES PARA FAKE API



🏆 Esse código serve para fazer uma comunicação com qualquer API de qualquer linguagem, mas nesse caso estou fazendo a comunicação via JSON-SERVER com a minha fake API


---

## PARA QUE SERVE O SERIVCE?

🏆 Serve tanto para compartilhar dados entre os componentes, acessar o local storage igual vamos fazer nas aulas de segurança lá na pasta guard, como também o session storage.

> Também usamos o service para fazer a comunicação com a REST API através do protocolo HTTP.
> 

### O que é local storage?

O localStorage **é uma ferramenta do Angular que permite armazenar dados localmente no navegador do usuário**. O localStorage é uma API JavaScript que faz parte da Web Storage API

### O que é session storage?

O sessionStorage **é um recurso da API de Armazenamento da Web (Web Storage API) que permite armazenar dados localmente no navegador do utilizador**:

- Os dados são armazenados em pares chave/valor, em formato string
- Os dados são apagados automaticamente quando o utilizador fecha o navegador (ou aba/janela)
- Os dados não são partilhados entre abas ou janelas
- O limite de armazenamento é muito superior ao dos cookies e pode variar entre os navegadores

---

## O QUE UTILIZAR NO SERVICE?

⚠️ OBSERVABLE → Vale a pena pesquisar bastante sobre

🏆

> Vai validar se o JSON tem o formato do objeto que estou criando, por exemplo:
> 
> 
> 
> VAMOS SUPOR QUE EU TENHA UMA LISTA DE USUÁRIOS (um ARRAY de objeto de usuários)
> 
> <img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/observable1.png"/>
> 
> SE ao invés de firstName(que é como está no meu arquivo json) vir só “name” o Observable vai validar e vai dar um erro no console, ele é uma função do Javascrit que você fica observando ele se está vindo corretamente, (eu mando a informação, recebo essa informação e valido ela.)
> 
> <img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/observable2.png" />
> 

Podemos observar o nome do atributo igual o da classe typescript.


**É uma funcionalidade que permite lidar com eventos assíncronos e transferência de dados**

- Os Observables são parte da biblioteca rxjs, que é instalada automaticamente quando uma nova aplicação Angular é criada.
- Os Observables funcionam como espiões que monitoram as mudanças nos dados e notificam quando algo acontece. Eles são unidirecionais, ou seja, emitem notificações sempre que um dos seus itens é alterado.
- Os Observables são muito usados no Angular e podem ser considerados uma versão melhor do que as Promises do Javascript. A principal vantagem dos Observables é que eles podem retornar um fluxo de valores e podem ser cancelados, ao contrário das Promises que só podem retornar um valor e não podem ser canceladas.
- Os Observables são ideais para quando a informação vai mudar durante o ciclo de vida dela, como em chats, notificações, legenda em vídeos, modos dark e light, menus collapsable, ações de usuários, entre outros.

### BLOG SOBRE O OBSERVABLE EM ANGULAR

[O que é um Observable RxJs + Angular?](https://vidafullstack.com.br/angular/o-que-e-um-observable-rxjs-angular/)

---

### Durante a Aula obtive um erro “Error: A collection and schematic is required during execution.”,  RESOLUÇÃO:

[Angular 14: Error: A collection and schematic is required during execution](https://stackoverflow.com/questions/74143722/angular-14-error-a-collection-and-schematic-is-required-during-execution)

---

## PARA CRIAR UM ARQUIVO SERVICE NO ANGULAR, UTILIAR O SEGUINTE COMANDO:

```tsx
ng g service/user
```

---

### Durante a aula surgiu uma dúvida de como importar o HTTP client já que estou utilizando componentes standalone na nova versão do Angular 17, resolução:

[Angular 17 Http client injection](https://stackoverflow.com/questions/77483538/angular-17-http-client-injection)

### Durante a aula surgiu uma duvida referente aos ‘:’ em typescript

🏆

[qual-a-utilização-dos-dois-pontos-em-javascript](https://pt.stackoverflow.com/questions/108626/qual-a-utiliza%C3%A7%C3%A3o-dos-dois-pontos-em-javascript#:~:text=Neste%20contexto%20espec%C3%ADfico%20ele%20%C3%A9,%C3%89%20usado%20em%20object%20literals).

Bem, a utilização dos dois pontos é basicamente empregada em objetos:

```jsx
var frutas = {
  "banana":{
    cor: "yellow"
  }
}

```

Com o objeto você simplesmente "navega" entre os níveis das chaves:

```jsx
frutas.banana.cor; // yellow

```

Assim sempre que se usa uma chave em um objeto, se atribui um valor a ela, por meio dos dois ponto `:`, ao invés do igual `=`, usado para váriaveis, em geral.

[dois pontos | Fórum Alura](https://cursos.alura.com.br/forum/topico-dois-pontos-57152)

### DUVIDA RESOLVIDA

> O que vem após os : é o tipo de retorno do método, os : serve para declarar o tipo de retorno da função
> 

[What specifically does ':' mean along with a method in JavaScript?](https://stackoverflow.com/questions/79212615/what-specifically-does-mean-along-with-a-method-in-javascript)

[Documentação typescript que esclarece as dúvidas sobre a sintaxe dos ':'](https://www.typescriptlang.org/docs/handbook/2/everyday-types.html#return-type-annotations)


---

## O QUE É HttpHeaders?

🏆 Cabeçalhos HTTP são necessários para autenticar a solicitação, se você tiver um token no seu cabeçalho, o backend verificará sua API para verificar se você está autenticado para obter a resposta.

Exemplo: crie httpOptions com seus cabeçalhos em seu component.ts

```jsx
import { HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

```

e use-o quando fizer solicitações por meio de métodos http, como get, post, put, delete etc.

```jsx
return this.http.get<>(thisurl, httpOptions).subscribe();
```

🏆 No Angular, os headers HTTP **são usados para definir os headers do request no método Http.post()**. 

[Angular Documentação sobre Headers](https://v17.angular.io/guide/understanding-communicating-with-http#http-headers)

[dúvida sobre HEADERS HTTP stackoverflow](https://stackoverflow.com/questions/57864827/what-is-httpheaders-and-why-is-it-used-in-angular)


---

## CRUD → GET

### ESTOU CRIANDO UMA REQUISIÇÃO HTTP GET QUE ESTÁ RECEBENDO UMA LISTA DE USUÁRIOS DO OBJETO TIPO USER (ESSE DADO QUE ESTÁ VINDO VAI SER UM JSON)

> O observable vai fazer a verificação se esse objeto JSON é compatível com o objeto criado, se não, vai dar erro
> 

```tsx
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';

const httpOptions = {

  
  headers: new HttpHeaders({'content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class UserService {

  BASE_URL: string = 'http://localhost:3000';

  constructor(private segurancaHttp: HttpClient) { }

  getUsers(): Observable<User[]>{ // vai ser um array de usuários
    return this.segurancaHttp.get<User[]>(this.BASE_URL + 'users') // Aqui basicamente estou montando a URL e utilizando a concatenação
  }
}

```

## CRUD → POST

```tsx
 addUser(user:any): Observable<User>{
    return this.segurancaHttp.post<User>(this.BASE_URL + 'users', user, httpOptions)
  }
```

💡 Estou retornando a URL, o que eu estou querendo passar que é o objeto → user e o httpOptions


🏆 Conclusão → Ele vai pegar um objeto do tipo user e vai mandar lá para a REST API e vai passar o header que estou passando através da referência ‘httpOptions’ e vai receber no retorno um tipo de usuário User, se caso o usuário não for do mesmo tipo ele vai dar um erro, o back-end geralmente trata isso do outro lado

