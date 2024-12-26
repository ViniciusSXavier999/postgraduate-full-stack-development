# INTRODUÇÃO AOS SISTEMAS DE BANCOS DE DADOS

## É muito importante saber a diferença entre dado, informação e conhecimento. Esses conceitos estão interligados, mas são coisas diferentes, são aspectos diferentes da mesma concepção

---

## O QUE É DADO?

🏆 É algo que precisa de processamento. Quando olhamos o dado sozinho, não faz sentido. É a menor unidade de armazenamento

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/projetoBancoDedados1.png" />

> Esses são exemplos de alguns dados, mas podemos observar que eles não trazem um significado completo do que eles representam
> 

🚨

> A data é só uma data, não sabemos o que é essa data “21/08/1976”, pode ser uma data de nascimento, uma data de matricula, uma data de falecimento, pode ser uma serie de coisas
> 

🏆 Essa é a principal característica de um dado, não á um entendimento completo quando a gente olha para o dado de forma isolada

---

---

---

## O QUE É INFORMAÇÃO?

🏆 É o resultado da operação com o dado

> Para que a gente obtenha a informação, a gente precisa do dado, a gente faz algum tipo de operação com o dado e obtém a informação.
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/ProjetoBancoDeDados2.png" />

Explicando exemplos da imagem:

> A data
> 
- Primeiro a gente faz a classificação do dado
- Essa data do exemplo acima é uma data de nascimento
- Tendo o dado ‘Data de nascimento’, qual é o tipo de INFORMAÇÃO que é gerada?
- Conseguimos gerar a idade da pessoa, a gente pega a data atual - a data de nascimento e obtém a idade da pessoa

> A temperatura
> 
- Vamos realizar o mesmo procedimento, a gente classifica o dado, essa é uma temperatura do que? do ar.
- Sabendo que é uma temperatura do ar, que tipo de informação podemos gerar com esse dado?
- A gente pode identificar se o dia está quente ou frio, como vemos na imagem, quente e frio são informações que foram geradas a partir do dado

> Palavra Poucas
> 
- Vamos primeiramente classificar o dado, poucas se refere a quantidade de nuvens no céu
- Outro tipo de operação que fazemos com o dado, é operação de observação → Se há poucas nuvens no céu a probabilidade de chover é baixa
- Probabilidade de chover alta e baixa são as informações que foram geradas através da observação da quantidade de nuvens no céu.

🏆 SÃO DADOS QUE GERARAM AS INFORMAÇÕES

- Poucas
- 30 graus
- 21/08/1976

🏆 AS INFORMAÇÕES

- IDADE
- DIA QUENTE OU FRIO
- PROBABILIDADE DE CHOVER ALTA E BAIXA

---

---

## POR QUE É NECESSÁRIO A GENTE SABER A DIFERENÇA ENTRE DADOS E INFORMAÇÕES?

🏆 O banco de dados armazena DADOS. E o sistema de informação, ele gera informações


---

---

---

### Qual seria o problema de armazenar as informações ao invés dos dados?

🚨 Vamos supor que ao invés de armazenar a data de nascimento, a gente armazene a idade

- A idade esse ano da pessoa é 47 anos
- Com o passar do tempo, nada aconteceu no banco de dados, o tempo só passou.
- No ano que vem a idade da pessoa NÃO vai ser 47, vai ser 48.
- Mas o que está armazenado no banco de dados é 47, apenas a informação

⚠️ Ou seja, quando a gente armazena a informação, só com o passar do tempo aquela informação se torna velha.

> E o que significa ter uma informação velha? significa ter uma informação falsa, é por isso que nunca armazenamos a informação, a gente sempre armazena o dado
> 

---

---

---

## APÓS ISSO, NÓS TEMOS O CONHECIMENTO

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/projetoBancoDeDados3.png" />

### EXEMPLO:

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/projetoBancoDeDados4.png" />

⚠️ Nós já sabemos que temos:

- Data (Dado)[
- Com a data a gente pode ter também o dado da temperatura
- (Naquela Data fez aquela Temperatura)
- Com a temperatura conseguimos dizer se o dia está quente ou frio

⚠️ Nós podemos também ter outro dado que é a quantidade de pessoas que vão a praia.

A partir disso a gente pode descobrir um comportamento comum que é quando o dia está quente, mais pessoas vão a praia e consequentemente quando os dias estão frios, menos pessoas vão a praia

🏆 Esse é o conhecimento, a gente descobriu um comportamento comum, com base nesse conhecimento, podemos utilizar ele em nosso beneficio 

---

---

## CONCLUSÃO

### OS DADOS GERAM INFORMAÇÃO, E AS ANALISES DAS INFORMAÇÕES GERAM O CONHECIMENTO

---

---

## ONDE FICAM ARMAZENADOS ESSES DADOS?

> Dentro de arquivos, e esses arquivos ficam organizados dentro de um Sistema.
> 

### SISTEMA DE ARQUIVOS

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/projetoBancoDeDados5.png" />

🏆 O sistema de arquivos é um sistema responsável por armazenar arquivos contendo dados.


🏆 O sistema tem um conjunto de operações que acessam os dados para gerar as informações, através desse sistema nós vamos encontrar mecanismos para: 

- Fornecer mecanismos para usuários manipularem arquivos e diretórios
- Garantir a validade e coerência dos dados
- Otimizar o acesso aos dados
