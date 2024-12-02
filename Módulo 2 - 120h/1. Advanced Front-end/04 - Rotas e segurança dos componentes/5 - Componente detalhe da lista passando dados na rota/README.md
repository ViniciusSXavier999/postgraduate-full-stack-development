# COMPONENTE DETALHE DA LISTA PASSANDO DADOS NA ROTA

🏆 O JSON-SERVER TEM QUE ESTAR RODANDO, PARA SIMULAR A CONEXÃO COM UMA API


🏆 Vamos aprender a passar mais de 1 dado na rota

### MINHA DÚVIDA NO STACKOVERFLOW SOBRE O SUBSCRIBE

[MINHA DÚVIDA E RESPOSTA DE OUTRO PROGRAMADOR](https://stackoverflow.com/questions/79245057/i-have-a-question-regarding-the-subscribe-method?noredirect=1#comment139739039_79245057)

### DÚVIDAS(NOVAMENTE) SOBRE O SUBSCRIBE

[What is .subscribe in Angular?](https://stackoverflow.com/questions/44921788/what-is-subscribe-in-angular)

[Duvida sobre subscribe | Fórum Alura](https://cursos.alura.com.br/forum/topico-duvida-sobre-subscribe-199658)

---

## 1. VOU ALTERAR MEU ARQUVIDO DE ROTAS E ADICIONAR A ROTA DO MEU COMPONENTE LISTA-SIMPLES

```tsx
{path: 'listar-simples', component: 'ListaSimplesComponent'}
```

```tsx
     // Passando mais de duas informações na rota
    {path: 'detalhe/:id/:phone', component: DetalheComponent},
```

🏆 OS DADOS QUE VOU PASSAR NA ROTA

```tsx
  goToDetail(user: User){
    this.router.navigate(['detalhe', user.id, user.phone]) // vamos passar esses dois dados na rota
  }
```


## 2. VOU REALIZAR MODIFICAÇÕES NO MEU COMPONENT DETALHE.HTML E DETALHE.TS

### html

```html
<p>detalhe works!</p>
<br>
<h3>ID:</h3>  {{identificador}}
<br>
<h3>TELEFONE:</h3>  {{phone}}
```

### TS

```tsx
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-detalhe',
  standalone: true,
  imports: [],
  templateUrl: './detalhe.component.html',
  styleUrl: './detalhe.component.css'
})
export class DetalheComponent implements OnInit{

  constructor(private route: ActivatedRoute){

  }

  identificador: number = 0
  phone: string = ''

  ngOnInit(): void {

    // METODO PARA PEGAR OS PARAMETROS DA ROTA

    // por que o forEach()? porque se você tiver mais de um parametro.
    // ele pode passar mais de um parametro
      this.route.params.forEach((params: Params)=>{ // Aqui temos um arrow function
        if(params['id'] !== undefined){ // O operador !== em JavaScript é um operador de comparação que verifica se dois valores são diferentes e retorna true se forem, ou false se forem iguais.
          this.identificador =+ params['id']
          console.log(this.identificador)
        }

        // realizando a verificação do phone
        if(params['phone'] !== undefined){ 
          this.phone = params['phone']
          console.log(this.phone) // o console.log printa na tela do console do navegador as informações
        }
      })
  }

}
```

---

## É NO MEU METODO DO NGONINIT QUE ESTOU COLOCANDO MEU MÉTODO BUSCAUSER() QUE VAI TRAZER OS DADOS QUE EU DESEJO

```tsx
ngOnInit(): void {
    // Estou chamando meu método buscaUser

    /* AQUI ESTOU CHAMANDO MEU METODO QUE TRARA TODOS OS DADOS PARA MIM APÓS A RENDERIZAÇÃO DA PAGINA */
    this.buscaUser()
  }
```

🏆 Caso queira passar um objeto completo, é melhor serialiar ele e passar

