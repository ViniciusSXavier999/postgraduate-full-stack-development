# 2 → CRIANDO O PROJETO PARA APLICAÇÃO

🏆 Vamos começar o Desenvolvimento da API

---

## 1. VAMOS INICIAR UM NOVO PROJETO JAVA SPRING INSERINDO AS CONFIGURAÇÕES INICIAIS

✅ Clicar em “Create new Spring Starter Project”


<img width="900" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/CriandoProjetoAplica%C3%A7%C3%A3o1.png" />

## 2. VAMOS ADICIONAR AS DEPENDÊNCIAS DO PROJETO

✅ Dependência é as bibliotecas que nosso projeto vai utilizar para facilitar nosso desenvolvimento


- Spring Boot Dev Tools → Serve para nosso projeto startar automaticamente, onde não é necessária ficar parando e iniciando o projeto toda hora, toda vez que fazemos uma alteração no código o nosso projeto inicia automaticamente.

- Spring Web → É a dependência do spring que a gente usa para construir uma API RESTful, as anotações e os principais recursos estão dentro dessa dependência, ela não pode faltar.

🏆

### @SPRINGBOOTAPPLICATION

É a anotação mais importante que temos no Spring, ela é responsável por toda configuração do nosso projeto inicial, ela basicamente fala para nós “Esse projeto vai usar todas as configurações necessárias que uma aplicação SPRING precisa ter e você desenvolvedor não precisa se preocupar com isso”

🏆 Essa classe possui um método principal, e toda vez que rodarmos nosso projeto ele será rodado nela.

🏆 Podemos ver o arquivo POM.xml, ele contém todas as dependências do projeto.


<img width="900" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/CriandoProjetoAplica%C3%A7%C3%A3o2.png" />

## 3. VAMOS CRIAR UM ENDOPOINT SÓ PARA TESTAR NOSSA APLICAÇÃO INICIAL

- Primeiro adicionamos a anotação @RestController que diz que aquela classe é uma classe controladora e que vai gerar endPoints para nós.
- Depois Criamos o método para retornar uma String e para isso utilizamos o método HTTP @GetMapping

<img width="900" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/CriandoProjetoAplica%C3%A7%C3%A3o3.png" />

### RESULTADO NO NAVEGADOR NA PORTA 8080

<img width="900" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/CriandoProjetoAplica%C3%A7%C3%A3o4.png" />
