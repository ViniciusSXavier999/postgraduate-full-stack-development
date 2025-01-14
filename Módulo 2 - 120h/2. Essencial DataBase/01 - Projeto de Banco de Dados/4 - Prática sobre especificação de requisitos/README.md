# PRÁTICA SOBRE ESPECIFICAÇÃO DE REQUISITOS

🏆 Para entendermos o que é um requisito precisamos entender o que é um levantamento de dados


## IMPORTÂNCIA DO LEVANTAMENTO DE DADOS

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/praticaEspecifica%C3%A7%C3%A3oRequisito1.png" />

> A função do levantamento de dados é descobrir quais são as necessidades do usuário, quais são as funcionalidades necessárias para que a aplicação funcione corretamente, quais são as regras de negócio.
> 

🏆 Um bom projeto de Banco de Dados começa com um bom levantamento de Dados

---

---

## Ao fazer o levantamento de Dados nós vamos descobrir:

### Definição de requisito

✅ Uma condição ou capacidade que um sistema deve apresentar;

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/praticaEspecifica%C3%A7%C3%A3oRequisito2.png" />

> Tudo isso é resultado de um levantamento de Dados
> 

✅ Com esse levantamento de dados é que a gente faz a especificação dos requisitos


### NÓS TEMOS 3 TIPOS DE REQUISITOS:

- Requisitos funcionais (RF)
    - São os que mais nos interessam para fazer o projeto do Banco de dados
    - Como o próprio nome já diz, São as funcionalidades que são necessárias que o sistema desempenhe

- Requisitos não funcionais
    - Eles estão ligados as características (propriedades) do software, exemplo: ‘Os meus softwares deve ter uma usabilidade de interface gráfica e amigável ao ponto de conseguir acessar qualquer funcionalidade com no máximo 4 cliques’, a gente está determinando que o software tem que ter usabilidade e a gente determina uma métrica → Qualquer funcionalidade tem que ser atingida em até 4 cliques
    
    ✅   Alguns exemplos de requisitos não funcionais para um banco de dados são:
    
    - **Desempenho**: A rapidez e eficiência com que o sistema responde às ações do usuário
    - **Confiabilidade**: A consistência e precisão do sistema ao longo do tempo
    - **Usabilidade**: A facilidade com que os usuários podem aprender e utilizar o sistema
    - **Manutenibilidade**: A facilidade com que o sistema pode ser atualizado e mantido
    - **Portabilidade**: A capacidade do sistema de operar em diferentes ambientes ou plataformas
    

- Requisitos Inversos (RI) ou Escopo Negativo
    - Define claramente o que não será feito, determinamos as fronteiras do nosso projeto: ‘Nessa versão não será implementado o calculo do salário liquido’, isso é um exemplo de um requisito inverso.
    
    🚨 A gente vai armazenar o salário, mas não vamos fazer o calculo do salário liquido nessa versão
    
    

> Isso é definir um escopo negativo, aquilo que não será feito.
> 

---

## O REQUISITO MAIS IMPORTANTE PARA DESENVOLVER O BANCO DE DADOS É O REQUISITO FUNCIONAL

### Requisito funcional

🏆 Descreve funcionalidade e serviços do sistema


> Vamos avaliar tudo da imagem abaixo:
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/praticaEspecifica%C3%A7%C3%A3oRequisito3.png" />

🏆 A especificação de requisito sempre deve ser:

- Completa
    - Ela tem que ter todos os detalhes que permita o entendimento da equipe a respeito daquele requisito
- Consistente
    - Ela não pode ser redundante e nem contraditória, não adianta ter 3 requisitos falando a mesma coisa
- Coerente
    - Você não pode especificar o requisito que em determinado momento fala uma coisa e depois em outro momento fala outra coisa, exemplo: “A média do aluno é composta por 3 notas”, e em outro momento fala-se “A media do aluno é composta de 4 notas”, isso é incoerente

> Quando a gente especifica o requisito temos sempre que lembrar desses 3 características importantíssimas.
> 

---

---

### ESTUDO DE CASO ESCOLA - REQUISITOS FUNCIONAIS

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/praticaEspecifica%C3%A7%C3%A3oRequisito4.png" />

🏆 Podemos observar a maneira correta de especificar o requisito nos exemplos das imagens

> Perceba que o requisito tem que ter um código, geralmente ‘RF’ para dizer que é um requisito funcional, e em seguida o número do requisito.
> 

> Em seguida damos o nome do requisito → “MANTER DADOS DO PROFESSOR”, “MANTER DADOS DO ALUNO”
> 

> Já o texto representa uma breve descrição sobre o requisito
> 

💡 Quando utilizamos a palavra ‘MANTER’ ou ‘GERENCIAR’ nós estamos falando das 4 operações do CRUD

- CREATE
- UPDATE
- READ
- DELETE

> Quando a gente diz ‘MANTER OS DADOS DO PROFESSOR’ o sistema precisa fazer inserção, alteração, exclusão e consulta dos Dados do professor
> 

### MAIS EXEMPLOS

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/praticaEspecifica%C3%A7%C3%A3oRequisito5.png" />

💡 TODOS estão fazendo referência as operações do CRUD quando utilizado a palavra ‘MANTER’

🚨 ESSA FOI UMA ESPECIFICAÇÃO DE REQUISITO DO ESTUDO DE CASO DA ESCOLA

> Quais dados devem ser mantidos
> 

> Quais dados devem ser armazenados
> 

> Como podemos observar teremos os dados:
> 
- Do professor
- Do aluno
- Do curso
- Da matricula
- Da disciplina

🚨 Com base na especificação dos requisitos é que a gente começa fazer o nosso projeto de Bando de dados, POIS NA ESPECIFICAÇÃO DE REQUISITOS A GENTE DESCOBRE QUAIS DADOS VÃO PRECISAR SER ARMAZENADOS.

