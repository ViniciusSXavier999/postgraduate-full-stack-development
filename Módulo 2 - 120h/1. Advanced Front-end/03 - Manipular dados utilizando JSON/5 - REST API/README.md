# REST API

🏆 Praticamente toda a internet roda em cima do protocolo HTTP, os browsers rodam em cima do HTTP

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/cruud.png" />


> Podemos observar que no navegador, ele utiliza o GET para pegar diversos arquivos necessários.
> 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/navegadorget.png" />

---

## CÓDIGO DO MÉTODO PUT:

```tsx
  editUser(user:any): Observable<User>{
    let url: string = this.BASE_URL + 'users/' + user.id
    return this.segurancaHttp.post<User>(url, user, httpOptions)
  }
```

## CÓDIGO DO MÉTODO DELETE

> É basicamente a mesma coisa, só não passamos o objeto
> 

```tsx
 deleteUser(user:any): Observable<User>{
    let url: string = this.BASE_URL + 'users/' + user.id // Estamos dizendo basicamente isso aqui -> 'http://localhost:3000/users/2'
    return this.segurancaHttp.post<User>(url, httpOptions)
  }
```

---

🏆 Ainda vamos aprender sobre formulário reativo e também a salvar esses formulários no localstorage


---

🚨 É recomendado fazer services de cada objeto separado, exemplo:

- ProdutoService
- UserService

---

## OUTROS EXEMPLOS PARA PRATICAR

- Criar exemplo de produtos
- De professores
- De supermercado
- Times
- Roupas

---

💡 A melhor forma de aprender programação é praticando

> O angular é tudo organizado, é de certa forma fácil de entender e decorar pois é tudo bem separado.
> 


Durante a aula surgiu uma dúvida sobre a nomenclatura dos imports no typescript, se poderia ser qualquer nome:
[Minha dúvida no stackoverflow](https://stackoverflow.com/questions/79213577/import-naming-can-be-any-in-typescript)