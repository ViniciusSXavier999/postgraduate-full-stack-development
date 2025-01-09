# PROJETO DE BANCO DE DADOS - CARACTERÍSTICAS

> Todo projeto de software tem um ciclo de vida, ou seja, fases que precisam ser construídas e cada fase possui a elaboração de artefatos e tarefas. A mesma coisa acontece em Projeto de Banco de Dados, ele possui etapas onde cada etapa gera um determinado artefato e a elaboração e execução de tarefas, essas etapas são:
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/projetoBD1.png" />

- 1 → Estudo de Viabilidade
    - Essa aplicação precisa de Banco de Dados?
    - E qual seria esse Banco de Dados?
    - Quais dados devem ser armazenados?

- 2 → Coleta e análise de requisitos
    - Quais são as funcionalidades (requisitos) que essa aplicação tem, que vai necessitar de um armazenamento de dados e quais serão os dados que deverão ser armazenados para cada requisito?

- 3 → PROJETO
    - Agora vem efetivamente o projeto que é composto por 3 níveis de modelagem.
    - Aqui é onde efetivamente construímos os diagramas de entidade e relacionamento

- 4 → IMPLEMENTAÇÃO
    - Nós temos nosso projeto e agora temos que fazer a construção física desse projeto

- 5 → VALIDAÇÃO
    - Aquilo que implementamos fisicamente no SGBD confirma o que foi especificado no projeto?

- 6 → OPERAÇÃO
    - Criamos o projeto, implementamos e agora vamos disponibilizar esse Banco de dados para operação dos usuários

---

---

---

## FEITO ISSO AGORA VAMOS ESPECIFICAR EXATAMENTE AS ETAPAS DO PROJETO DE BANCO DE DADOS

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/projetoBD2.png" />

### REQUISITOS DOS USUÁRIOS

🏆

- Quais são as necessidades dos usuários?
- Quais são as funcionalidades da aplicação?
- Quais dados devem ser armazenados para cada funcionalidade?

## NÍVEL 1 DE MODELAGEM → ESQUEMA / MODELO CONCEITUAL

### PROJETO CONCEITUAL

🏆

- Criação do modelo entidade e relacionamento conceitual
- O que deve ser modelado?
- O que deve ser projetado?
- Quais são as entidades?
- Como reconhecer o que é entidade e o que é atributo
- Como essas entidades estão relacionadas

## NÍVEL 2 DE MODELAGEM → ESQUEMA / MODELO LÓGICO

### PROJETO LÓGICO

🏆

- Quais entidades estarão relacionadas através de chave estrangeira?
- Onde essas chaves estrangeiras vão ficar localizadas?
- Quais tipos de relacionamento que existem entre essas entidades?
- Quais atributos vão desempenhar o papel de chave primária?
- Qual o tamanho de cada um dos atributos?

## NÍVEL 3 DE MODELAGEM → ESQUEMA / MODELO FISICO

### PROJETO FISICO

🏆

- A gente tem que implementar esse banco de Dados
- Quais tabelas serão criadas?
- Qual o comando de criação dessas tabelas?
- Quais tipos, tamanhos e restrições que serão aplicadas em cada um desses campos
- Tudo isso é definido no projeto Físico do banco de Dados

---

---

---

## A IMPORTÂNCIA DO PROJETO DE BANCO DE DADOS

✅ O motivo pelo qual você deve se preocupar com o projeto do banco de dados é que é de suma importância e consistência, integridade e precisão dos dados num banco de dados


> O projeto de banco de dados é fundamental para que a gente possa determinar as características  do que será armazenado, quem sabe
> 
- Quantas tabelas serão criadas
- Qual será a estrutura dessa tabela
- Quais será os campos dessas tabelas
- Como essas tabelas estarão relacionadas
- Quais as restrições que iram compor cada um dos atributos dentro dessas tabelas

> Todas essas especificações constam no projeto de banco de dados
> 

---

> Se não construirmos um bom projeto de banco de dados, teremos consequências muito danosas
> 

💡 Se for projetado de forma imprópria, os usuários terão dificuldade em trabalhar com certos tipos de informação, somando-se a isso o risco que estas buscas venham a produzir informações incorretas 


Algumas das consequências

- Dados redundantes
- Dados inconsistentes
- Falta de integridade nos dados

🏆 É fundamental que a gente construa um bom projeto de banco de dados para que depois na hora de implementar e principalmente na hora de dar a manutenção nesse banco de dados todas operações ocorra com sucesso e a gente não tenha nenhum tipo de desinformação


---

## OBJETIVOS DE UM BOM PROJETO

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/projetoBD3.png" />

## VANTAGENS DE UM BOM PROJETO DE BANCO DE DADOS

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/projetoBD4.png" />

🏆 O banco de dados da toda a base para a construção de toda aplicação que vai acessar aquele banco de dados

---

---

---

## COMPOSIÇÃO DE PROJETO DE BANCO DE DADOS

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/projetoBD5.png" />

🏆 PARA QUE A GENTE POSSA CONSTRUIR ESSE PROJETO, A GENTE TEM QUE SEMPRE CONSTRUIR ESSES 3 NIVEIS DE MODELAGEM

- NÍVEL CONCEITUAL
    - Para representar o mundo real, como o negócio funciona

- NÍVEL LÓGICO
    - Onde a gente especifica chave primária, chave estrangeira, tipo de relacionamento, cardinalidade de relacionamento
    
- NÍVEL FÍSICO
    - Onde vamos criar efetivamente os scripts, os comandos que vão permitir a implementação de todas as estruturas que foram projetadas
