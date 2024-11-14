# MODELO DE ROTAS DO SISTEMA

🏆 O que foi feito nessa aula? 

- Eu vou ter um formulário de Login
- E vou ter essa rota protegida

🏆 Eu vou ter uma rota privada que ao clicar no botão para ser redirecionado para essa rota, ela não irá permitir

🏆 É de extrema importância antes de iniciar a aplicação ou durante o desenvolvimento, pensar em maneiras de definir as rotas. 


🏆 É recomendado apenas criar uma pasta para proteger as rotas que necessitam de ser privadas que você não quer que seja acessada por qualquer pessoa.


🏆 Para passar de uma rota para outra é possível fazer através do HTML ou do typescript


---

> As rotas no Angular 17 são definidas no arquivo app.routes.ts
> 

Existe maneiras de:

- Proteger as rotas
- Criar subrotas
- Vamos supor que eu tenha um sistema e nele tenha uma área restrita que é só para administradores, a partir disso eu vou
    - Criar uma pasta administrador
    - Eu crio uma pasta de rota dentro desse componente administrador
    - Dentro dessa pasta vou criar meus subcomponentes
    - Nessa rota que está dentro dessa pasta, eu vou apontar para os componentes
    - e dentro do arquivo  app.routes.ts eu vou realizar as minhas configurações especificas

💡 Toda vez que eu criar um novo componente é necessário atualizar a rota dele lá no app.routes.ts


---

🏆 Vamos fazer isso com o nosso novo componente → Cadastro 

```jsx
    {path: 'cadastro', component: CadastroComponent}
```


---

## Vamos criar um novo componente que é o login

> Vou utilizar o mesmo formulário de cadastro fornecido pelo Angular Material, só que vou realizar modificações nele
> 

```jsx
          ng generate @angular/material:address-form pages/login
```

---

## O APRENDIZADO DE COMO PROTEGER ROTAS SERÁ FEITO NA PASTA GUARD.

Exemplos:

- Eu preciso que somente o usuário logado vai acessar
- Eu quero que quando ele digita uma rota desconhecida seja direcionado automaticamente para uma rota especifica
- É possível passar dados para a rota
- Passar um objeto completo pela rota

---

## BIBLIOTECAS PARA ESTUDAR

- RXJS
- REDUX ANGULAR

---