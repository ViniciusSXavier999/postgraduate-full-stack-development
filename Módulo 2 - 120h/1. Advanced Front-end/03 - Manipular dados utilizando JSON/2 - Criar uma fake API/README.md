# CRIAR UMA API FAKE

⚠️ Ao invés de criar um back-end inteiro, eu vou utilizar o node para criar uma simulação de uma REST API com um banco de dados, porém nosso banco de dados será o json


## E COMO EU CONSIGO FAZER ESSA SIMUAÇÃO?

🏆 Utilizando um pacote do node chamado “JSON SERVER”, documentação e instruções para se trabalhar com esse pacote 👇🏻

[npm: json-server](https://www.npmjs.com/package/json-server)

> Você simula um CRUD
> 
- CREATE
- LER
- UPDATE
- DELETE

🏆 O JSON Server

**é uma ferramenta de linha de comando Node.js que permite criar uma API REST falsa, ou "mock", de forma rápida**:

- É uma biblioteca que permite criar uma API Fake em poucos segundos, sem a necessidade de escrever código
- É uma ferramenta de apoio para o desenvolvimento de aplicações, sendo mais comum no desenvolvimento de front-end
- Permite simular o comportamento de uma API REST completa, com recursos como rotas, métodos HTTP, filtragem, ordenação, entre outros

---

## PASSO A PASSO

## 1 → APÓS A INSTALAÇÃO FOI CRIADA UMA PASTA CHAMADA ‘JSON-SERVER’

## 2 → DENTRO DELA FOI CRIADO O ARQUIVO CHAMADO ‘db.json’

## 3 → POPULANDO O ARQUIVO

```tsx
{
    "users": [
      {
        "id": 1,
        "firstName": "Bruno Hauck",
        "email": "brunohauck@gmail.com",
        "phone": "1234567890",
        "cpf": "0000",
        "password": "123456"
      },
      {
        "id": 2,
        "firstName": "Bruno",
        "email": "brunohauck@gmail.com",
        "phone": "323",
        "cpf": "05126769685",
        "password": "fdsfds"
      },
      {
        "id": 3,
        "firstName": "Bruno",
        "email": "brunohauck@gmail.com",
        "phone": "323",
        "cpf": "05126769685",
        "password": "fdsfds"
      },
      {
        "id": 4,
        "firstName": "Bruno",
        "email": "brunohauck@gmail.com",
        "phone": "323",
        "cpf": "05126769685",
        "password": "fdsfds"
      },
      {
        "id": 5,
        "firstName": "Bruno",
        "email": "brunohauck@gmail.com",
        "phone": "323",
        "cpf": "05126769685",
        "password": "fdsfds"
      },
      {
        "id": 6,
        "firstName": "Bruno",
        "email": "brunohauck@gmail.com",
        "phone": "323",
        "cpf": "05126769685",
        "password": "fdsfds"
      },
      {
        "id": 7,
        "firstName": "Bruno",
        "email": "brunohauck@gmail.com",
        "phone": "323",
        "cpf": "05126769685",
        "password": "fdsfds"
      },
      {
        "id": 8,
        "firstName": "Bruno",
        "email": "brunohauck@gmail.com",
        "phone": "323",
        "cpf": "05126769685",
        "password": "fdsfds"
      },
      {
        "id": 9,
        "firstName": "Bruno",
        "email": "brunohauck@gmail.com",
        "phone": "323",
        "cpf": "05126769685",
        "password": "fdsfds"
      },
      {
        "id": 10,
        "firstName": "Bruno",
        "email": "brunohauck@gmail.com",
        "phone": "323",
        "cpf": "05126769685",
        "password": "fdsfds"
      },
      {
        "id": 11,
        "firstName": "Bruno",
        "email": "brunohauck@gmail.com",
        "phone": "323",
        "cpf": "05126769685",
        "password": "fdsfds"
      },
      {
        "id": 12,
        "firstName": "Bruno",
        "email": "brunohauck@gmail.com",
        "phone": "323",
        "cpf": "05126769685",
        "password": "fdsfds"
      },
      {
        "id": 13,
        "firstName": "Bruno",
        "email": "brunohauck@gmail.com",
        "phone": "323",
        "cpf": "05126769685",
        "password": "fdsfds"
      }
    ]
  }
```

## 4 → CRIAR CLASSE PARA REPRESENTAR O OBJETO

PASTA → MODELS

ARQUIVO → user.ts

## 5 → CRIAR A CLASSE NO ARQUIVO user.ts

```tsx
export class User {
    public id: String = ''
    public firstName: String = ''
    public phone: String = ''
    public email: String = ''
}
```

## 6 → VAMOS INICIALIZAR O JSON-SERVER

🏆 Para executar o json-server é necessario rodar o comando na pasta em que esta o arquivo db.json

> Clicar com o botão direito em cima da pasta e selecionar ‘open in integrated terminal’
> 

executar o seguinte comando para rodar o servidor json: 

```tsx
npx json-server db.json
```

---

## CONCLUSÃO

🏆 O JSON SERVER É MUITO INTERESSANTE POIS AGILIZA MUITO O APRENDIZADO, EM 5 MINUTOS VOCÊ JÁ TEM UMA FAKE API, isso facilita pois não é necessário criar uma API no back-end

