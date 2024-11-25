# ROTAS ENTRE OS COMPONENTES

🏆 Vamos fazer a criação de uma SUBROTA


⚠️ No arquivo app.routes.ts fizemos as seguintes alterações:

```tsx
{path: 'subroute', component: SubRouteComponent,

         children: [
            {path: 'page1', component: ManipulandoJsonComponent},
             {path: 'page2', component: ManipulandoJsonComponent}
        ]
    },
```

chidren → Signica criança em inglês, é a partir dele que serão criadas as subrotas


📌 Quando eu acessar essa rota http://localhost:3000/subroute o angular vai carregar automaticamente as rotas filhas(children)

---

## O QUE É A TAG <ROUTER-OUTLET>

A tag `<router-outlet>` **é uma diretiva do Angular que indica para onde o Angular deve direcionar.**

> Decidi tirar a dúvida no stackoverflow
> 

[Minha dúvida no stackoverlow](https://stackoverflow.com/questions/79223188/what-is-the-router-outlet-tag-for-in-angular?noredirect=1#comment139699971_79223188)

### Blog sobre Rotas

[Roteamento Angular em 5 minutos (Portuguese)](https://medium.com/@jsmuster/roteamento-angular-em-5-minutos-portuguese-f0b64178ad8)

### Documentação oficial sobre rotas

[Angular Rotas](https://angular.dev/guide/routing/router-reference#router-outlet)

---

### Explicação da API router navigate

[API router navigate](https://stackoverflow-com.translate.goog/questions/39124906/navigate-relative-with-angular-2-router-version-3?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt-BR&_x_tr_pto=sc)