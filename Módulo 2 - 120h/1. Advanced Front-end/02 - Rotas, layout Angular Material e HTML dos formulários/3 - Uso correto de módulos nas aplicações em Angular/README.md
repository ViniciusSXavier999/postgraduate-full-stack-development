# USO CORRETO DE MÓDULOS NAS APLICAÇÕES EM ANGULAR (Isso mudou no Angular 17 por conta do standalone)

## O QUE SÃO OS MÓDULOS NO ANGULAR?

🏆 São uma parte importante, mas que é modificada com frequência, nele colocamos:

- As dependências
- Os componentes que vamos utilizar

### Exemplo:

> Vamos supor que você tenha um componente que vai utilizar uma biblioteca de autenticação do facebook, vamos adicionar o pacote e logo em seguida a dependência, não tem necessidade de colocar esse componente no module principal, você pode criar um componente de login no formato lazy loading e dentro desse componente vai ter um module e dentro desse module você vai fazer os imports necessários, exemplo: Câmera, páginas, sendo assim, as bibliotecas desse module só vão ficar disponíveis para esse componente ou subcomponentes que estão sendo usados nesse componente.
> 

📌 Dividir os módulos do projeto e as dependências dele e os componentes que serão utilizados em modules separados para que você não tenha que carregar essas dependências em todo projeto, isso é utilizado em projetos grandes.


---

💡 O app.routes.ts é um module que carrega outros componentes de forma diferente através da dependência router que está dentro do frameork Angular


---

## PARA ENTENDER MAIS DETALHADAMENTE SOBRE OS MÓDULOS NO ANGULAR

[Arquitetura e MODULOS em Angular](https://vidafullstack.com.br/angular/arquitetura-angular/)

[Entendendo os MODULOS no Angular](https://horadecodar.com.br/conheca-as-diferencas-de-componentes-e-modulos-em-angular/)

## O ANTIGO `APP-ROUTING.MODULE.TS` ANTES DA VERSÃO 17 QUE VEIO COM COMPONENTES STANDALONE:

⚠️ Ele é um módulo que carrega outros componentes 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/exempllomodule1.png" />

> De forma diferente através da dependência (import) do @Angular/router que fica dentro do próprio Angular
> 

🏆 O módulo principal é o que fica junto com os componentes principais de uma aplicação Angular, geralmente chamado de `app.module.ts`

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/exemplomodule2.png" />

- declarations → São os componentes que criamos durante o desenvolvimento da aplicação
- imports → Ele adiciona os módulos de cada componente que vamos utilizar durante o desenvolvimento da aplicação
- providers → são classes que vão ajudar e podem ser globalmente dentro do contexto desse module, são classes que vão poder ser compartilhadas entre os componentes para acessar informação de uma API por exemplo para pegar informação de um banco de dados ou cadastrar informações

🏆 Tudo que estiver no meu module principal vai ser global, durante todo o contexto qualquer página que eu estiver, ele vai ser carregado.

### Quando utilizar o module principal?

🏆 Vamos supor que você tem uma dependência de Cadastro, é bom colocar global pois talvez seja necessário que você tenha vários formulários dentro da aplicação


> É possível fazer subcomponentes com os módulos
> 

> Não tem necessidade de criar os modules, somente se você for criar o componente lazy loading
>
---

## CONCLUSÃO

> É um arquivo onde você importa o seu componente para ser utilizado e compartilhado durante a aplicação
>