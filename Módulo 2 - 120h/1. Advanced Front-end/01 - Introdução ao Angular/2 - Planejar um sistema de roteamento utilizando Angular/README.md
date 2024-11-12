## PLANEJAMENTO DA ROTA DA NOSSA APLICAÇÃO (modelo)

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/rotas.png" />

🏆 No fluxograma, temos um componente principal que é o app.component e temos o Router Module que vai rodar todos os outros componentes.

Também é possível observar subrotas 

- Page 1 Component
- Page 2 Component
---

## O QUE SÃO AS ROTAS EM UMA APLICAÇÃO ANGULAR?

> Exemplo → No navegador quando a gente abre algum site, podemos notar que em alguns momentos tem “Cadastrar usuário”, “Editar usuário”, através das rotas que é feita essa organização, no arquivo app.routing.module.ts, toda vez que eu troco a url, ele vai trocar o componente de forma automática, isso graças as rotas.
> 

> Com as rotas é possível:
> 
- Passar dados
- Sub rotas
- Proteger as rotas

---

### O QUE É PATHMATCH E REDIRECTO?

[pathMatch](https://cursos.alura.com.br/forum/topico-pathmatch-nao-entendi-205793)

---

> Dentro do arquivo app.routes.ts eu posso criar quantos componentes de rotas eu quiser, seja eles sub rotas, rotas privadas, seja qual for.
> 

---

### O QUE É LAZY LOADING?

O lazy loading, ou "carregamento preguiçoso", é uma técnica que permite carregar elementos de uma página da web apenas quando são necessários. No Angular, o lazy loading **é um padrão que permite carregar módulos sob demanda, ou seja, apenas quando solicitados**

---

✅ Utilizar uma arquitetura de componentes utilizando rotas fica bem mais rápido, robusto e organizado

> Se você tem uma dependência no login Component por exemplo, você nao vai precisar utilizar ela no home Component
> 
