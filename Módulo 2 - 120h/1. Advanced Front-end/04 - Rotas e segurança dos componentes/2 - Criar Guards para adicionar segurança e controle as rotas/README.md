# CRIAR GUARDS PARA ADICIONAR SEGURANÇA E CONTROLE DAS ROTAS

🏆 Agora vamos começar a implementar a segurança nas rotas

---

## 1. PRIMEIRO PASSO A SER REALIZADO É A CRIAÇÃO DE UM NOVO COMPONENTE CHAMADO PRIVATE

```tsx
ng g c pages/private
```

## 2. LOGO EM SEGUIDA, VOU CRIAR UMA NOVA ROTA DESSE COMPONENTE

```tsx
{path: 'private', component: PrivateComponent},
```

> Dentro dessa mesma rota será adicionado o canActivate: [AutorizadoGuard]
> 

```tsx
  {path: 'private', component: PrivateComponent,
        canActivate: [autorizadoGuard]
    },
```

## 3. APÓS ISSO VAMOS GERAR A PASTA JUNTAMENTE DO ARQUIVO DE GUARD

```tsx
ng g guard guards/Autorizado
```

## 4. VAMOS DESENVOLVER O CÓDIGO DO AUTORIZADO GUARD

```tsx
import { Component, inject, Injectable } from '@angular/core';
import {
  CanActivateFn,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
  Router,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AutorizacaoService } from '../services/autorizacao.service';

export const AutorizadoGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
):
  | Observable<boolean | UrlTree>
  | Promise<boolean | UrlTree>
  | boolean
  | UrlTree => {

    // INJETANDO O SERVICE
    const autorizadoService = inject(AutorizacaoService);

    // INJETANDO O ROUTER
    const router = inject(Router);

    // COLOCANDO EM UMA VARIAVEL PARA PODER FAZER A VERIFICAÇÃO
    const usuarioEstaLogado = autorizadoService.obterLoginStatus();

    if (usuarioEstaLogado) {
      return true;
    } else {
      router.navigate(["/login"]);  
      return false;
    }
};

```

> Será necessário criar um service para desenvolver a lógica para verificar se o usuário está logado ou não
> 

## 5. AGORA VOU DESENVOLVER O CÓDIGO DO SERVICE QUE VAI VERIFICAR SE O USUÁRIO ESTÁ LOGADO OU NÃO

```tsx
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AutorizacaoService {

  autorizado = false;

  constructor() { }

  // VAI CRIAR UMA FUNÇÃO PARA GRAVAR NO LOCALSTORAGE QUE ELE ESTÁ AUTORIZADO
  autorizar(token: string){
    localStorage.setItem("login", "sim");
  }

  // VAI APAGAR AS INFORMAÇÕES QUE ESTÃO NO LOCALSATORAGE
  deslogar(){
    localStorage.clear();
  }

// ELE VERIFICA SE DENTRO DO LOCALSTORAGE TEM O "sim" passado na função autorizar
  obterLoginStatus = () => !!localStorage.getItem("login");

}
```

## 6. REALIZAR MUDANÇAS NO LOGIN COMPONENT.TS

> Lembrando que é necessário injetar o service com a anotação @Inject, antes era feito por meio do constructor, agora é pela injeção de dependência
> 

> Vamos simular um login
> 

🏆 PASSO A PASSO DO QUE VAI ACONTECER

- Quando a gente clicar no botão logar a gente vai fazer essa verificação e vai logar o usuário
- A partir do momento que a gente entra na rota privada, ele vai verificar se está logado ou não, e vai autorizar ou não
- ELE VAI FAZER A VERIFICAÇÃO LÁ DENTRO DO AUTORIZADOGUARD

<img width="900" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/guard1.png />

- SE ele tiver passado pelo AutorizadoGuard, ai ele vai entrar no arquivo service e realizar as funções que estão dentro dele

<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/guard2.png />

- Após entrar no service ele vai setar login como “sim” e vai setar o flag para true lá no Autorizadoguard

### O QUE É O CANACTIVATE?

🏆 O CanActivate **é uma interface do Angular que permite proteger as rotas de um aplicativo**. Ele verifica se o usuário está autorizado a acessar uma determinada rota. 


### Blog na alura sobre Angular Guard

[Alura: Artigo Guarda de rotas funcional em Angular](https://www.alura.com.br/artigos/guarda-de-rotas-funcional-angular#:~:text=canActivate()%5D%20.,rota%20%C3%A9%20acess%C3%ADvel%20ou%20n%C3%A3o).

### Blog no site console.log sobre CanActivate e Como proteger rotas

[Como proteger suas rotas - Angular Guard CanActivate](https://consolelog.com.br/como-proteger-rotas-angular-com-guard/)

### Documentação oficial Angular sobre CanActivate()

[Angular](https://angular.dev/api/router/CanActivate)

---

📌 O CanActivate foi descontinuado, nas novas versões do Angular é recomendado utilizar o CanActivatfn()


### Possíveis problemas com o CanActivate nas novas versões do Angular

[Angular's "CanActivate" interface is deprecated. How to replace it?](https://stackoverflow.com/questions/75564717/angulars-canactivate-interface-is-deprecated-how-to-replace-it)

### Como usar CanActivateFn no angular 17 via injeção de dependência do constructor

[How to use CanActivateFn in Angular 16 via constructor dependency injection](https://stackoverflow.com/questions/76204932/how-to-use-canactivatefn-in-angular-16-via-constructor-dependency-injection)

## Estava com dificuldades para realizar a alteração de código para nova versão, então fui novamente para o stackoverflow

[I'm using version 17 of Angular and I would like to know how to use CanActivate, which has been discontinued and is now CanActivateFn,please thank you](https://stackoverflow.com/questions/79224889/im-using-version-17-of-angular-and-i-would-like-to-know-how-to-use-canactivate?noredirect=1#comment139703404_79224889)

# CONCEITOS IMPORTANTES SOBRE DÚVIDAS DURANTE A AULA

## INJECTABLE({ PROVIDEIN: ‘ROOT’ })

📌 O que é o `@Injectable({ providedIn: 'root' })` ?

A gente utiliza o `providedIn` para definir como e quem pode injetar esse serviço como dependência, normalmente o `root` diz que qualquer componente pode recebê-lo.

[Necessidade do providedIn: 'root' utilizando o @Injectable( ) | Fórum Alura](https://cursos.alura.com.br/forum/topico-necessidade-do-providedin-root-utilizando-o-injectable-134850)


## PROVIDERS EM ANGULAR

> Durante a aula eu obtive o seguinte erro: “Component imports must be standalone components, directives, pipes, or must be NgModules.( -992012)”
> 

> porque eu não estava realizando o inject do meu service no login.component.ts
> 

💡 RESPOSTA QUE OBTIVE DE UM DEV SENIOR SOBRE ESSE OCORRIDO

@vinudev você pode adicionar

```
@Injectable(providedIn: 'root') export class AutorizadoService
```

para que seja fornecido em todo o aplicativo, sem necessidade de adicionar ao array de provedores. Você também pode adicionar ao array de provedores de componentes, app.config.ts também. Mas você deve verificar a documentação oficial do angular em [angular.dev](https://angular.dev/) para começar bem sua jornada angular


📌 O que são os providers?

No Angular, os providers **são um parâmetro que define quais serviços estão disponíveis no escopo global de um módulo**

[Alura: Tópico módulo angular providers](https://cursos.alura.com.br/forum/topico-modulo-angular-ngmodule-parametro-providers-194344#:~:text=Mergulhe%20em%20programa%C3%A7%C3%A3o&text=%C3%94ps%2C%20beleza%20Walmir!,Espero%20ter%20ajudado).


## ROUTE GUARDS EM ANGULAR E CANACTIVATE

📌 O que são Route Guards?

**É uma interface do Angular que faz o meio de campo antes de chamar a rota de fato, seja navegando entre os componentes ou saindo de algum deles.**

**O route guards (ou rota de guarda), faz a verificação se o usuário pode ou não acessar determinada rota. Um exemplo é quando esquecemos de preencher algum campo obrigatório de um formulário e a página não nos deixa seguir em frente antes de preenchê-lo.**

📌 O que é CanActivate? 

**CanActivate – Verifica se o usuário pode acessar a rota;**


### BLOG COM TUDO BEM DETALHADO SOBRE ROUTE GUARDS E CANACTIVATE 

💡💡💡💡💡💡💡💡💡💡💡 [Blog vidafullstack.com.br sobre Route Guards e CanActive](https://vidafullstack.com.br/angular/o-que-e-route-guards-angular/#:~:text=%C3%89%20uma%20interface%20do%20Angular,ou%20saindo%20de%20algum%20deles). 💡💡💡💡💡💡💡💡💡💡💡💡💡💡💡💡💡

## DIFERENÇA ENTRE @INJECT E @INJECTABLE

📌 @INJECTABLE

Aqui são duas coisas diferentes, o `@Injectable` é para a gente tornar o serviço injetável em componentes.


📌 @INJECT

Já o uso do construtor é para receber injeções que podem ser injetáveis (que possuem o `@Injectable`).
Um a gente permite a injeção e o outro a gente de fato realiza a injeção.


### PROFESSOR NA ALURA EXPLICANDO A DIERENÇA

💡💡💡💡💡💡💡💡💡💡💡💡 [Alura: Tópico como funciona o dependecy injection](https://cursos.alura.com.br/forum/topico-como-funciona-o-dependency-injection-129807) 💡💡💡💡💡💡💡💡💡💡💡💡💡💡

### BLOG EXPLICANDO TUDO DETALHADAMENTE SOBRE @INJECTABLE 

💡💡💡💡💡💡💡💡💡💡💡💡  [Services e injeção de dependências em Angular: Blog console.log.com.br](https://consolelog.com.br/services-e-injecao-dependencia-angular-providers-viewproviders/#:~:text=O%20decorator%20%40Injectable()%20%C3%A9,outras%20classes%20da%20sua%20aplica%C3%A7%C3%A3o) 💡💡💡💡💡💡💡💡💡💡💡💡

## COMO NAVEGAR EM DIFERENTES ROTAS NO ANGULAR

[Navigate relative with Angular 2 Router (Version 3)](https://stackoverflow-com.translate.goog/questions/39124906/navigate-relative-with-angular-2-router-version-3?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt-BR&_x_tr_pto=sc)

[How do I navigate to a sibling route?](https://stackoverflow-com.translate.goog/questions/38634237/how-do-i-navigate-to-a-sibling-route?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt-BR&_x_tr_pto=sc)

[Angular - Rotas - Guardas - Navegação: Blog balta.io](https://balta.io/blog/angular-rotas-guardas-navegacao#:~:text=O%20Activated%20Route%20nos%20d%C3%A1,seus%20par%C3%A2metros%20e%20demais%20valores).

## COMO USAR A FUNÇÃO ANGULAR CANACTIVATE(CANACTIVATEFN)

[How to use Angular CanActivate(CanActivateFn) function.](https://medium.com/@ojiofor/how-to-use-angular-canactivate-function-b153e5a79f51)

## NO MODO STANDALONE, COMO IMPORTAR UM MÓDULO NO ANGULAR 17?

[In standalone mode, how to I import a module in Angular 17?](https://stackoverflow.com/questions/77727305/in-standalone-mode-how-to-i-import-a-module-in-angular-17)

## MÉTODO NAVIGATE()

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/guard3.png />

📌 O método navigate() do Angular **é utilizado para fazer a navegação entre páginas de uma aplicação por meio de código**


## SUBSTITUIR O MÉTODO NAVIGATE() PARA CREATEURLTREE()?

📌 VANTAGEM → Seria mais útil do que o navigate(), pois substitui a URL em vez de navegar para uma nova rota.


📌 [Angular CanActivate guard - createUrlTree relative navigation](https://stackoverflow.com/questions/55904784/angular-canactivate-guard-createurltree-relative-navigation)


## O QUE É OS MÉTODOS LOCALSTORAGE NO ANGULAR?

<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/guard4png.png />

📌 O Local Storage **é uma área de armazenamento no navegador do usuário que persiste dados mesmo após o fechamento do navegador, os dados são sempre salvos em formato de string**. É ideal para armazenar dados que precisam ser mantidos por longos períodos, como preferências do usuário ou temas.

Os métodos localStorage do Angular **são uma ferramenta de armazenamento de dados no navegador do usuário**. O localStorage é uma API JavaScript que faz parte do Web Storage

[Usando local e Session Storage da forma Certa com Angular](https://sougabriel.medium.com/usando-local-e-session-storage-da-forma-certa-com-angular-bb2f0a3cffbf)
