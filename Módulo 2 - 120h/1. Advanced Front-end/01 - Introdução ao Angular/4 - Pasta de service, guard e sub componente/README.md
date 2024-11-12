# PASTA DE COMPONENTES E PASTA PAGES

✅ A partir do Angular 17 todo componente que você gera, ele é standalone, isso significa que ele é um componente independente 


✅ Agora ao invés de importar as bibliotecas que você vai utilizar no componente, no app modules, você vai fazer essa importação no próprio componente 


💡 Para gerar um projeto Angular que não seja standalone basta digitar o seguinte comando:

```
ng new nome --no--standalone
```
---

---

🏆 Se eu colocar /home seremos redirecionados para pages de home

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/rotas1.png" />

🏆 Se eu colocar /listar vai ser redirecionado para pages de listar

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/rotas2.png" />

---

---
🏆 Quando a rota está vazia ela será automaticamente redirecionada para /home pois no meu arquivo de rotas está dessa forma:

```
  {path:'', redirectTo: '/home', pathMatch: 'full'},
```

---

---

💡 Vamos adicionar o component header dentro de home (header vai ser um sub component), veja o passo a passo:

- Primeiro vamos verificar o seletor dele no header.component.ts
- A partir desse seletor, vamos adicionar ele no HTML do home
- E realizar o import do Header component no typescript do home, pois agora no angular 17 a importação é feita diretamente no componente e não no arquivo appModule

---

⚠️A pasta ‘guard’ vai ser aonde vou criar a segurança das rotas

⚠️ Já o service vai ser o responsável pela comunicação com a API externa


---

### Como importar componentes no Angular 17.

[Importando componentes no Angular 17](https://angular.dev/guide/components/importing)