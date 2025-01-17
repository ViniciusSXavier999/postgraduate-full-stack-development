## O QUE É MER?


⚠️ MODELO ENTIDADE RELACIONAMENTO


---

## MODELO CONCEITUAL

> Quando a gente faz o Projeto de banco de Dados esse é o primeiro nível de modelagem, é o início do projeto, é onde a gente vai pensar no que o cliente precisa, em como que é o negócio do cliente
> 

⚠️ É comum chamarmos o MODELO CONCEITUAL de representação do mundo real

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual1.png" />

🏆 No MODELO CONCEITUAL o nosso objetivo é entender:

- Qual é o negócio do Cliente
- Qual as entidades desse negócio do cliente
- Como as Entidades se relacionam

> A gente não esta preocupado com outros aspectos técnicos, somente devemos se preocupar em fazer o levantamento de Dados e representar esses Dados
> 

---

### NOTAÇÃO - ENTIDADE

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual2.png" />

🏆 Temos a representação de como é uma entidade no modelo, um retângulo com os cantos arredondados e o nome da Entidade no centro desse retângulo

### NOTAÇÃO - ATRIBUTOS

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual3.png" />

🏆 Os atributos são desenhados dessa forma.

Atributos comuns é o circulo sem pintar.

Atributo identificador que vai se tornar a chave primária é o circulo pintado.


### NOTAÇÃO - RELACIONAMENTO

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual4.png" />

🏆 O símbolo do relacionamento é o losango


## NOTAÇÃO - PEQUENO EXEMPLO MODELO CONCEITUAL

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual5.png" />

---

---

---

🏆 Para que a gente possa fazer o modelo conceitual, primeiramente devemos ter a especificação dos requisitos


## ESTUDO DE CASO ESCOLA - REQUISITOS FUNCIONAIS

> Ou seja, qual foi o resultado do levantamento de Dados
> 
- O que é o negócio
- Quais são as funcionalidades
- Quais dados tem que ficar armazenados

🏆 Com base nos requisitos que a gente consegue fazer o modelo conceitual


## A SEGUIR VÃO SER APRESENTADOS 5 REQUISITOS FUNICIONAIS DE UM ESTUDO DE CASO DE UMA ESCOLA

> Como deve ser feito um projeto de Banco de Dados de uma escola.
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual6.png" />

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual7.png" />

🏆 Com base nesses requisitos que vamos ter condições de fazer o modelo conceitual.

> Estamos entendendo através dos requisitos quais são os dados que precisam ficar armazenados nesse Banco de Dados.
> 

## COMO IDENTIFICAR AS ENTIDADES?

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual8.png" />

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual9.png" />

> Para uma escola é importante armazenar dados do aluno? Tem significado manter os dados do aluno armazenados?
> 

> Se caso seja relevante e importante para o negócio significa que aluno para escola é uma entidade, é algo de extrema importância para o funcionamento daquele negócio
> 

📌 Quando olhamos para os requisitos a gente identifica quais são as entidades do nosso modelo conceitual, todos aspectos que são citados nos requisitos são relevantes para o negócio.


💡

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual10.png" />

### CONCLUSÃO SOBRE AS ENTIDADES DESSE ESTUDO DE CASO UTILIZADO NO EXEMPLO

🏆 ATRIBUTO: 

- IDENTIFICA
- QUANTIFICA
- QUALIFICA

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual11.png" />


---

## COMO IDENTIFICAR OS ATRIBUTOS?

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual12.png" />

> Observe que o atributo também responde ‘SIM’ para as duas perguntas feitas para identificarmos uma entidade.
> 

> Mas nome de aluno é uma entidade? não! porque nome de aluno identifica.
> 



<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual13.png" />

> Quais Dados importantes para serem armazenados do Aluno para o aspecto escola?
> 

🏆 Para gente descobrir quais são os atributos da entidade a gente tem que saber e identificar quais dados são importantes armazenar sobre aquele determinado aspecto para o negócio


🏆 Tudo depende do aspecto que a gente está olhando


🔒 Observar quais são os dados relevantes para se armazenar sobre aquele determinado negócio e depois então modelamos o conceitual identificando as entidades e os atributos.


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual14.png" />

🚫 Não existe entidade com apenas 1 atributo


### EXEMPLOS DE ATRIBUTOS EM ENTIDADES

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual15.png" />
---

## VAMOS PRATICAR!

> Vamos utilizar um software para fazer a modelagem de banco de dados: BRMODELO
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MER_Conceitual16.png" />

⚠️ Estamos dizendo que aluno faz matricula nesse exemplo acima 

A matricula é feita pelo aluno.


🏆 Desta forma a gente vai construindo o modelo conceitual, a gente representa entidade, os seus atributos e o relacionamento que existe entre essas entidades 

