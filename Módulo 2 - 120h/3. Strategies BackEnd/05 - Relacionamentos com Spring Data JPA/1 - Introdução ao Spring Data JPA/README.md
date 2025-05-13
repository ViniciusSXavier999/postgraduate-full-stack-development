# 1 → INTRODUÇÃO AO SPRING DATA JPA

### VAMOS CRIAR A SEGUINTE API PARA TESTAR OS RECURSOS DE RELACIONAMENTO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/springJPARelacionamento1.png" />

🏆 Podemos observar que a nossa classe principal é estudante.

- Teremos o relacionamento de 1 para 1 com endereço.
- Teremos relacionamento de estudante com livros que vai ser de 1 para muitos (1 estudante pode ter vários livros) (1 livro vai estar relacionado com apenas 1 estudante)
- Teremos também o relacionamento de estudantes com curso (vários estudante poderão avaliar vários cursos) (Vários cursos poderão ser avaliados por vários estudantes)

---

### RECAPITULANDO SOBRE O SPRING DATA JPA

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/springJPARelacionamento2.png" />

> Não precisamos nos preocupar com o que está lá no banco de dados, podemos fazer tudo apenas nos dedicando totalmente a nossa API RESTFULL
> 


🏆 NO JPA, AS CLASSES QUE REPRESENTAM OS DADOS QUE SERÃO ARAMAZENADOS NO BD SÃO CHAMADAS DE ENTIDADES(ENTITY), EXEMPLO:

- ESTUDANTE
- ENDEREÇO

🏆 O JPA DEFINE UMA API UNIFICADA PARA ACESSAR BANCOS DE DADOS RELACIONAIS E REALIZAR MAPEAMENTO OBJETO-RELACIONAL.


🏆 ESSE MAPEAMENTO OU ANOTAÇÃO FAZ COM QUE O JPA ASSOCIE A CLASSE JAVA EM QUESTÃO A UMA TABELA DO BANCO DE DADOS


### EXEMPLO DE ANOTAÇÕES PARA MAPEAMENTO:

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/springJPARelacionamento3.png" />

### EXEMPLO

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/springJPARelacionamento4.png" />

---

### 1. VAMOS INICIAR A CRIAÇÃO DAS CLASSES NO PROJETO.

- ENDEREÇO
- CURSO
- LIVRO

### 2. VAMOS MAPEAR TODAS ESSAS CLASSES COM AS ANOTAÇÕES NECESSÁRIAS E DESENVOLVER OS ATRIBUTOS NECESSÁRIOS.