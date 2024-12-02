# COMPONENTE DE LISTAR

## ESTAVA COM MUITA DÚVIDA SOBRE O OBSERVABLE, DECIDI NOVAMENTE IR AO STACKOVERFLOW E DEPOIS DE TANTO TENTAR ENTENDER, EU ACHEI A EXPLICAÇÃO E ANALOGIA PERFEITA

[MINHA DÚVIDA NO STACKOVERFLOW](https://stackoverflow.com/questions/79235095/is-it-possible-to-use-an-observable-without-subscribing/79235142#79235142)

---

### DÚVIDAS QUE SURGIRAM DURANTE A AULA

### O que é o OBSERVABLE?

📌 Artigos sobre OBSERVABLES

🏆 `Observable` é um tipo implementado através do *observer pattern*, basicamente é uma maneira da gente lidar com processamentos assíncronos.

OBSERVABLE DOCUMENTAÇÃO OFICIAL

[RxJS](https://rxjs-dev.firebaseapp.com/guide/observable)

🔒 O QUE SÃO PROCESSAMENTOS ASSINCRONOS?

[O que são processamentos assíncronos e processamentos síncronos?](https://pt.stackoverflow.com/questions/151216/o-que-s%C3%A3o-processamentos-ass%C3%ADncronos-e-processamentos-s%C3%ADncronos)


[O que é um Observable RxJs + Angular?](https://vidafullstack.com.br/angular/o-que-e-um-observable-rxjs-angular/)

[Observables: como funcionam?](https://dev.to/felipedsc/observables-como-funcionam-15eb)

[Entendendo RxJS Observable com Angular](https://medium.com/tableless/entendendo-rxjs-observable-com-angular-6f607a9a6a00)

[Angular - RxJS - Cold e Hot Observable](https://consolelog.com.br/angular-rxjs-cold-e-hot-observable/)

[Um mergulho profundo nos Observables do RxJS: recriando a biblioteca RxJS do zero (Portuguese)](https://medium.com/@jsmuster/um-mergulho-profundo-nos-observables-do-rxjs-recriando-a-biblioteca-rxjs-do-zero-portuguese-c40262983556#)


### DICAS SOBRE OBSERVABLE

[Por que devemos ter cuidado com o Observables no Angular? 7 dicas importantes](https://www.dio.me/articles/por-que-devemos-ter-cuidado-com-o-observables-no-angular-7-dicas-importantes)

> IMPORTANTE!!!
> 

[Você não precisa usar só Observables no Angular](https://vidafullstack.com.br/angular/observables-promises-angular/)

### DIFERENÇA ENTRE OBSERVABLE E BEHAVIORSUBJECT

[What is the difference between BehaviorSubject and Observable?](https://stackoverflow.com/questions/39494058/what-is-the-difference-between-behaviorsubject-and-observable)

### DÚVIDAS DE OUTRAS PESSOAS QUE ME AJUDARAM EM RELAÇÃO AO SUBSCRIBE E OBSERVABLE

[[Dúvida] Subscribe no método criarPensamento | Fórum Alura](https://cursos.alura.com.br/forum/topico-duvida-subscribe-no-metodo-criarpensamento-330368#)

[Recapitulando: O que é um Observable? | Fórum Alura](https://cursos.alura.com.br/forum/topico-recapitulando-o-que-e-um-observable-123171)

### O que é o método subscribe()?

📌 No JavaScript, o método `subscribe` **é usado para se inscrever em um `Observable` e permitir que ele execute sua lógica**


### DÚVIDAS SOBRE SUBSCRIBE()

[[Dúvida] Subscribe no método criarPensamento | Fórum Alura](https://cursos.alura.com.br/forum/topico-duvida-subscribe-no-metodo-criarpensamento-330368#)

---

## O QUE SERÁ FEITO NA AULA:

> Temos que permanecer com o json funcionando para conseguirmos puxar a lista de users
> 

🏆 Vou entrar na pasta que se encontra o arquivo json e rodar o comando:

```tsx
npx json-server db.json
```


---

## 1. VOU COPIAR DO COMPONENTE MANIPULANDO-JSON.COMPONENT.HTML O CÓDIGO PARA MEU ARQUIVO LISTAR.COMPONENT.HTML

```tsx
<h2>MANIPULANDO LISTA SIMPLES DE USUÁRIO</h2>

<div class="container">
    <h1>Lista de Estudantes</h1>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
            </tr>
        </thead>
        <tbody>

            <tr *ngFor="let user of users">
                <td>{{ user.id }}</td>
                <td>{{ user.firstName}}</td>
                <td>{{ user.email }}</td>
                <td>{{ user.phone }}</td>
                <td><button mat-button (click)="goToDetail(user)">Ir para detalhe</button></td>
            </tr>
        </tbody>
    </table>
</div>
```

## 2. VOU DESENVOLVER A LÓGICA DO MEU LISTA-SIMPLES.COMPONENT.TS

```tsx
import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-lista-simples',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './lista-simples.component.html',
  styleUrl: './lista-simples.component.css'
})
export class ListaSimplesComponent implements OnInit {

  constructor(private router: Router, public service: UserService) {
  }

  // CRIANDO ARRAY DE USUARIOS
  users: User[] = []

  ngOnInit(): void {
    // Estou chamando meu método buscaUser
    this.buscaUser()
  }

  buscaUser(): void {

    this.service.getUsers().subscribe(
      {
        next: (resposta) => {
          console.log(resposta)
          this.users = resposta
        },

        // Criação de exceção simples
        error: (erro: any) => {
          console.log('ocorreu algum erro')
          console.log(erro)
        }
      }
    )
  }

  // Vamos passar mais de uma informação na rota
  goToDetail(user: User){
    this.router.navigate(['detalhe', user.id])
  }

}
```

---

## CONCLUSÃO DA AULA

🔒 Criamos um método buscaUser() no lista-simples.ts que ao clicar vamos lá pro método getUsers() do nosso service que já tínhamos criado anteriormente

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/componenteListar.png" />

> Esse método getUsers() no service, basicamente faz o direcionamento para nossa API
> 

### SERVICES EM ANGULAR

[SERVICES EM ANGULARM, QUAL A FINALIDADE?](https://cursos.alura.com.br/forum/topico-ficou-meio-confuso-na-parte-do-service-199429)