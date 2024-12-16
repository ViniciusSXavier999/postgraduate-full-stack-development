# FINALIZAR A APLICAÇÃO COM FORMULÁRIO DE LOGIN

🏆 Vamos finalizar a implementação do sistema de login utilizando o FIREBASE

❓ O QUE É FIREBASE? 

O **Firebase** é uma plataforma desenvolvida pelo Google que oferece uma suíte de ferramentas e serviços para facilitar o desenvolvimento de aplicativos web e móveis. Ele inclui funcionalidades como banco de dados em tempo real, autenticação de usuários, armazenamento de arquivos, hosting, analytics, notificações push e muito mais.

O objetivo do Firebase é ajudar desenvolvedores a criar aplicativos rapidamente, fornecendo soluções prontas para backend, sem a necessidade de configurar servidores ou infraestrutura complexa.

---
---

> O firebase é um pouco diferente do json-server, o json server não tem um end-point para gente fazer Login e a gente precisa de um token para validar a nossa sessão
> 

## ARTIGO SOBRE FIREBASE

[O que é Firebase? Um Guia dessa ferramenta Google | Alura](https://www.alura.com.br/artigos/firebase?srsltid=AfmBOoquq4UtghbEdVEwLDkyeMbWWZyLjG-xiAJ9E3j4g7PrtDkt9h3m)

---

---

---

✅ Vamos utilizar os dois em conjunto, algumas partes vamos fazer com o json-server e outras com o firebase


---

## O QUE VAI SER FEITO?

🏆 Vamos fazer um login e ele (firebase) vai trazer para gente um token e esse token vai ser responsável pela nossa sessão


> Quando eu faço o login eu recebo um token que eu válido tanto a rota do front como também a do back-end
> 

> Com esse token eu posso transformar o usuário em Administrador, exemplo, só vai poder deletar um usuário se ele for administrador.
> 

---

🏆 A ideia principal é fazer o login e receber uma informação do back-end e depois com essa informação eu faço uma outra requisição em uma rota protegida onde só eu poderia acessar


## PASSO A PASSO

## 1. Vamos injetar o USER SERVICE no component LOGIN

```tsx
private service = inject(UserService)
```

## 2. Vou realizar alterações no user service, criando o método login()

> Vamos fazer parecido como está o cadastro
> 

```tsx
 login(data:any): Observable<User>{
    return this.segurancaHttp.post<User>(this.BASE_URL + 'users', data, httpOptions)
  }
```

> Colocamos data porque não vamos receber um objeto do tipo user
> 

## 3. Vamos alterar a URL para redirecionar a requisição para o firebase

```tsx
  FIREBASE_URL: *string* = ''
```

> Vale lembrar que estamos pensando como se fosse um back-end único onde eu tenho um end-point de login e outro de buscar usuários
> 

> Trocar para FIREBASE_URL no método
> 

🏆 O Método vai ficar dessa forma

```tsx
 login(data:any): Observable<User>{
    return this.segurancaHttp.post<User>(this.FIREBASE_URL + 'users', data, httpOptions)
  }
```

</aside>

## 4. Desenvolver uma nova lógica para o método onSubmit()

```tsx
onSubmit(): void {
    // this.loginClick()
    if (this.autorizacaoService.obterLoginStatus()) {
      this.autorizacaoService.deslogar()
    } else {
      //  this.autorizacaoService.autorizar();
      this.service.login({ user: 'hahahah' }).subscribe({  // O SUBSCRIBE É OBRIGÁTORIO EM UM OBSERVABLE
        next: (response) => {
          //  console.log(response)
          //  alert('Dado registrado com sucesso')
        },
        error: (erro: any) => { // error -> Tratamento de exceção do subscribe
          console.log(erro)
          alert('Ocorreu algum erro')
        }
      })
    }
  }
```

---

---

---

> Nas próximas aulas vamos realizar as requisições e vamos ver os dados recebidos através do console.log
> 

> Ver sobre toda a parte do JWT
>