# TABELAS DE LISTAGEM DE DADOS

🏆 Basicamente nessa aula estamos recapitulando como faz uma requisição para o servidor.


🏆 Nessa aula vamos voltar a utilizar a lista-simples juntamente do nosso componente manipulando-json.ts para consumir os dados do db.json


---

### 1. DENTRO DO LISTA-SIMPLES.COMPONENT.TS VAMOS DESENVOLVER A SEGUINTE LÓGICA

```tsx
 constructor(private router: Router, public service: UserService) {
  }

  // CRIANDO ARRAY DE USUARIOS
  users: User[] = []

  ngOnInit(): void {
    // Estou chamando meu método buscaUser

    /* AQUI ESTOU CHAMANDO MEU METODO QUE TRARA TODOS OS DADOS PARA MIM APÓS A RENDERIZAÇÃO DA PAGINA */
    this.buscaUser()
  }

  // Através desse método estou me inscrevendo nele através do subscribe e retornando next ou error que são funcionanlidades do subscribe
  buscaUser(): void {

    this.service.getUsers().subscribe(
      {
        next: (resposta) => {
          console.log(resposta)
          this.users = resposta
        },

        // Criação de exceção simples
        error: (erroo: any) => {
          alert('ocorreu algum erro')
          console.log(erroo)
        }
      }
    )
  }
```

### 2. DENTRO DO MANIPULANDO-JSON.COMPONENT.HTML VAMOS PEGAR O CÓDIGO E COLOCAR DENTRO DO LISTA-SIMPLES.COMPONENT.HTML

> Vamos alterar o students para users no ngFor da lista, o código ficará dessa maneira:
> 

```html
<h2>MANIPULANDO LISTA SIMPLES DE USUÁRIO</h2>

<div class="container">
    <h1>Lista de Usuarios</h1>
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
            <!-- Vamos acessar todos os dados daquele json e vamos varrer ele para mostrar na tela através do for -->
            <tr *ngFor="let user of users">
                <td>{{ user.id }}</td>
                <td>{{ user.firstName }}</td>
                <td>{{ user.email }}</td>
                <td>{{ user.phone }}</td>
                <td><button mat-button (click)="goToDetail(user)">Ir para detalhes</button></td>
            </tr>
        </tbody>
    </table>
</div>
```

## CONCLUSÃO

🏆 Basicamente estamos fazendo uma requisição do tipo GET que acessa nosso service e faz a requisição


⚠️ Nas próximas aulas vamos ver sobre a questão da paginação 

