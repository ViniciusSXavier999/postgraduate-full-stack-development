# PASSAR DADOS ENTRE AS ROTAS

## DÚVIDAS QUE SURGIU DURANTE A AULA

### **Qual a diferença entre o ngOnInit e o Constructor?**

📌 São duas coisas com propósitos diferentes:

O `constructor` é o método default da classe. No Angular ele é usado principalmente para injetar dependências no componente

O `ngOnInit` faz parte do ciclo de vida do componente. Uma prática comum é usar ele para inicialização da lógica do componente.

[Qual a diferença entre o ngOnInit e o Constructor](https://pt.stackoverflow.com/questions/422986/qual-a-diferen%C3%A7a-entre-o-ngoninit-e-o-constructor)

### Artigo que aborda quando OnInit parou de ser implementado automaticamente nos projetos Angular

[Implements OnInit e método OnInit | Fórum Alura](https://cursos.alura.com.br/forum/topico-implements-oninit-e-metodo-oninit-273990)


### Qual a diferença entre **ActivatedRoute e ActivatedRouteSnapshot no Angular?**

📌 [What is the difference between ActivatedRoute and ActivatedRouteSnapshot in Angular4](https://stackoverflow.com/questions/46050849/what-is-the-difference-between-activatedroute-and-activatedroutesnapshot-in-angu)


### O que é snapshot no Angular?

📌 No Angular, o snapshot **é um método do objeto ActivatedRoute que permite obter um valor estático do parâmetro de rota**.

[Fluxo de dados via rota no Angular](https://medium.com/@lspeixotodev/fluxo-de-dados-via-rota-no-angular-58631d598ce5)


### **Por que devo usar o novo `inject()` do Angular 14 em vez da DI com o construtor?**

📌 [Why I should use Angular 14’s new inject() instead of DI with the constructor](https://www.reddit.com/r/Angular2/comments/12kk84j/why_i_should_use_angular_14s_new_inject_instead/?tl=pt-br&rdt=34269)

[What is the difference between @Inject vs constructor injection as normal parameter in Angular 2?](https://stackoverflow.com/questions/40017679/what-is-the-difference-between-inject-vs-constructor-injection-as-normal-parame)


### Artigo sobre params e snapshot

[O que é Route Parameters Angular?](https://vidafullstack.com.br/angular/o-que-e-route-parameters-angular/)

### **Qual é a diferença entre this.route.params e this.route.snapshot.params no angular ActivatedRoute**

📌 [what is the difference between this.route.params and this.route.snapshot.params in angular ActivatedRoute](https://stackoverflow.com/questions/70797769/what-is-the-difference-between-this-route-params-and-this-route-snapshot-params)


### Por que utilizar o this dentro de métodos no javascript

📌 No JavaScript, a palavra-chave `this` é utilizada para referenciar o objeto atual em que o código está sendo escrito. Dentro de um método, o `this` refere-se ao objeto ao qual o método pertence, permitindo o acesso às suas propriedades e métodos.


### IMPORTANTE!!!

📌 [[Bug] Angular não consegue identificar os parâmetros das rotas | Fórum Alura](https://cursos.alura.com.br/forum/topico-bug-angular-nao-consegue-identificar-os-parametros-das-rotas-340433)


### Descrição das propriedades do objeto ActivatedRoute

🏆  [Angular Documentação](https://v17.angular.io/api/router/ActivatedRoute#description)


---

AGORA VOU REALIZAR O TESTE DA APLICAÇÃO

> Primeiro vou tentar entrar na rota private, ele vai direcionar automaticamente para o login, pois ainda não realizei o login
> 

```tsx
localhost:4200/login
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/dadosEntreRotas1.png" />

> Após isso, vou clicar em “Entrar” e vai aparecer o alert na tela
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/dadosEntreRotas2.png" />

> Após isso, se eu tentar entrar na rota ‘private’ novamente, ele vai liberar
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/dadosEntreRotas3.png" />

---

🏆 Agora vamos tentar passar dados de uma página para outra utilizando as rotas


# 1. VAMOS CRIAR UMA NOVA ROTA

```tsx
{path: 'detalhe/:id', component: DetalheComponent},
```

> Não pode ter espaço, não podemos passar um objeto por exemplo, teria que fazer de outra maneira, serializando o objeto para poder passar, nesse caso vamos passar somente o id
> 

## 2. CRIAR O COMPONENTE DETALHE E DESENVOLVER A SUA LÓGICA

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

  ngOnInit(): void {

    // METODO PARA PEGAR OS PARAMETROS DA ROTA

    // por que o forEach()? porque se você tiver mais de um parametro.
    // ele pode passar mais de um parametro
      this.route.params.forEach((params: Params)=>{ // Aqui temos um arrow function
        if(params['id'] !== undefined){ // O operador !== em JavaScript é um operador de comparação que verifica se dois valores são diferentes e retorna true se forem, ou false se forem iguais.
          this.identificador =+ params['id']
          console.log(this.identificador)
        }
      })
  }

}
```

## 3. APÓS ISSO, VOU UTILIZAR O DATABIND PARA PASSAR INFORMAÇÕES PARA O HTML DO COMPONETE DETALHE

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/Microcertificado%20-%20L%C3%B3gica%20de%20Programa%C3%A7%C3%A3o%20com%20Java.png" />

## 4. EM SEGUIDA, VOU PARA MEU COMPONENTE MANIPULANDO-JSON.HTML E VOU ADICIONAR MAIS UM TD NA TABELA

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/dadosEntreRotas4.png" />

## 5. LOGO APÓS, VOU CRIAR ESSE MÉTODO NO MANIPULANDO-JSON.COMPONENT.TS

```tsx
  goToDetail(student: Student){
    this.router.navigate(['detalhe', student.id])
  }
```

---

## REALIZANDO TESTES

## 1. RODAR A APLICAÇÃO

```tsx
ng serve
```

## 2. ENTRAR NA ROTA DO MANIPULANDO JSON

```tsx
http://localhost:4200/json
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/dadosEntreRotas6.png" />

## 3. CLICAR NOS BOTÕES DE ‘IR PARA DETALHE’ QUE DINAMICAMENTE VAI SER ALTERADO O ID NA URL E VAMOS SER REDIRECIONADOS PARA ROTA DO COMPONENTE DETALHE

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/dadosEntreRotas7.png" />

---

## CONCLUSÃO E RECAPITULANDO

> Adicionamos a rota detalhe/:id, após o id podemos passar mais quantas informações desejarmos para serem passadas via url
> 

<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/dadosEntreRotas8.png" />

> É possível passar objetos também, porem serializados
> 

### O QUE É SERIALIZAÇÃO?

📌
 > Em ciência da computação, no contexto de armazenamento e transmissão de dados, a serialização é o processo de salvar ou transliterar um objeto em outro em um meio de armazenamento (como um arquivo de computador ou um buffer de memória) ou transmiti-lo por uma conexão de rede, seja em forma binária ou em formato de texto como o XML ou JSON. Esta série de bytes pode ser usada para recriar um objeto com o mesmo estado interno que o original.
> 

# **Existe apenas um tipo de serialização?**

Não. Existem vários tipos de serialização, sendo a diferença o formato final de representação dos dados. Por exemplo, utilizando o método `Json`, da biblioteca `Newtonsoft.Json`, você terá uma serialização JSON. Usando o objeto `System.Xml.Serialization.XmlSerializer`, você poderá converter (ou serializar) um objeto no formato XML.

[Serialização e exemplos](https://pt.stackoverflow.com/questions/13087/o-que-%C3%A9-serializa%C3%A7%C3%A3o-quando-usar-como-implementar-no-c)
