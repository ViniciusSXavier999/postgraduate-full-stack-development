# 4 → POST, GET, DELETE, PUT E PATCH

🏆 Os métodos HTTP são um meio da gente poder criar uma comunicação padrão entre APIS, ou client X server, eles funcionam como um método que cada requisição tem um significado e essas regras devem ser seguidas para que a gente possa estabelecer uma conexão, fazer uma requisição e ter uma response.


🏆 Temos regras para fazer requisições seja utilizando POST, GET, DELETE.

🏆 Toda requisição vai ter uma resposta a partir do conteúdo enviado.


🏆 É sempre importante utilizarmos os métodos certos para que nossa API reconheça aquela requisição e responda da melhor forma possível.


🏆 Esses verbos HTTP blindam a nossa API de forma que ela vai seguir o padrão e todo mundo vai conseguir usar sem mesmo conseguir o código dela.


---

## EXEMPLO PRÁTICO: POST, GET E DELETE

### Entramos no postman para testar os métodos HTTP.

## MÉTODO GET

🏆 Estamos buscando os estudantes juntamente com alguns parâmetros, nesse caso, eu quero buscar na página 0 e quero 5 itens nessa primeira requisição.

A URL **`http://localhost:8080/estudantes?pagina=0&itensPorPagina=5`** é uma requisição a um servidor local (**localhost**) na porta **8080**, pedindo uma lista de **estudantes**.

A parte após o **`?`** são **parâmetros de consulta** (query parameters), usados para controlar a resposta:

- **`pagina=0`**: Indica que a requisição está pedindo os estudantes da **página 0** (geralmente, a primeira página de uma lista paginada).
- **`itensPorPagina=5`**: Define que, em cada página, devem ser retornados **5 estudantes**.

Portanto, essa URL está pedindo ao servidor para retornar os primeiros 5 estudantes da lista, começando pela página 0 (ou seja, os 5 primeiros estudantes).


```java
http://localhost:8080/estudantes?pagina=0&itensPorPagina=5
```

> Recebemos a resposta no body, no formato JSON que é o padrão de troca de informações dessa API
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/CRUD1.png" />

> O conteúdo é um array vazio e temos informações da página que a gente consultou.
> 

🏆 Temos também o status da requisição (200 OK).

Toda requisição ela tem que ter uma resposta e toda resposta tem um status.


## MÉTODO POST

🏆 A requisição **POST** para a URL **`http://localhost:8080/estudantes`** é utilizada para **enviar dados ao servidor** e **criar um novo estudante** no sistema.

- **POST** é um método HTTP usado para **criar** ou **enviar dados** para o servidor.
- A URL **`/estudantes`** indica que os dados estão sendo enviados para o recurso "estudantes".

Em geral, o corpo da requisição (não mostrado na URL) conterá as informações do novo estudante (como nome, idade, etc.) que o servidor usará para criar o novo registro.

Portanto, essa requisição está pedindo ao servidor para **adicionar um novo estudante** ao banco de dados.


> Estamos usando o mesmo endereço que usamos no método GET, a diferença é que mudamos para POST
> 

```java
http://localhost:8080/estudantes
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/CRUD2.png" />


🏆 Esse é o corpo (body) da nossa requisição POST que será enviado ao servidor.


🏆 A diferença pro GET é que no POST não temos parametros.


🏆 A ideia é cadastrar um estudante passando as informações de um estudante


### RESPOSTA DA REQUISIÇÃO

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/CRUD3.png" />


🏆 Podemos notar que foi respondida com um status diferente, que é o 201, ele é usado para criar recursos em uma API rest full


🏆 A requisição também retornou um objeto do tipo JSON com ID


✅ Se executarmos novamente a requisição GET, ele vai retornar esse usuário estudante que acabamos de criar 


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/CRUD4.png" />


## MÉTODO DELETE

🏆 Podemos observar que ele é bem parecido com o GET e POST, porém a diferença é que ele usa outro verbo chamado DELETE e também passamos o parâmetro do usuário que queremos excluir.

A URL **`http://localhost:8080/estudantes/1`** com o método **DELETE** é usada para **remover** um **estudante** específico identificado pelo **ID 1**.

- **`DELETE`** é o método HTTP utilizado para **excluir** um recurso no servidor.
- **`/estudantes/1`** especifica o recurso "estudante" com o **ID 1**, ou seja, o estudante que será deletado.

Essa requisição está pedindo ao servidor para **excluir o estudante de ID 1** do sistema.


```java
http://localhost:8080/estudantes/1
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/CRUD5.png" />


🏆 Notamos que o DELETE não retornou nenhum BODY, porém retornou o status 200, isso significa que o registro foi deletado do banco com sucesso.


## MÉTODO PUT

🏆 Vamos imaginar que eu precise mudar todas informações de algum estudante nos registros do banco de dados, para isso eu utilizo o método PUT, basta passar o ID do usuário que você deseja alterar e após isso, realizar as mudanças necessárias.

O **método PUT** na URL **`http://localhost:8080/estudantes/2`** é usado para **atualizar completamente** as informações do estudante com **ID 2**.

- **`PUT`**: Substitui os dados atuais do estudante de ID 2 com os novos dados enviados no corpo da requisição.
- **Exemplo**: Se você enviar no corpo da requisição algo como **`{"nome": "João Silva", "idade": 22}`**, os dados do estudante de ID 2 serão atualizados para essas informações.

O método **PUT** é idempotente, ou seja, enviar a mesma requisição várias vezes terá o mesmo efeito.


```java
http://localhost:8080/estudantes/2
```

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/CRUD6.png" />


> Após realizar o PUT e as informações estiverem corretas, o status será “OK” e podemos verificar as mudanças realizando o método GET e buscando todos os dados.
> 

## MÉTODO PATCH

🏆 Caso você queira atualizar somente algumas pequenas informações do usuário, exemplo: quero alterar somente o endereço desse usuário.

A URL **`http://localhost:8080/estudantes/2`** com o **método PATCH** é usada para **atualizar parcialmente** o recurso do estudante com **ID 2**.

- **Método PATCH**: Envia apenas os **dados que precisam ser alterados**. No caso de um estudante, por exemplo, você poderia enviar apenas o campo que deseja modificar, como a **idade**, e os outros campos (como nome ou curso) permaneceriam inalterados.
- **Exemplo**: Se você deseja apenas atualizar a idade do estudante com ID 2, você enviaria algo como:
    
    ```json
    {
      "idade": 23
    }
    
    ```
    
    Nesse caso, o estudante de ID 2 terá apenas a **idade atualizada**, enquanto outros dados não serão modificados.
    

Em resumo, o **PATCH** permite alterações parciais no recurso, ao contrário do **PUT**, que substitui o recurso inteiro.


```java
http://localhost:8080/estudantes/2
```

---

## DIFERENÇAS DO MÉTODO PUT E PATCH

A diferença entre os métodos **PUT** e **PATCH** está na forma como eles atualizam os recursos em uma API:

1. **PUT**:
    - **Substitui completamente** o recurso existente com os dados enviados.
    - Espera-se que você envie **todos os dados** do recurso, mesmo os que não foram alterados.
    - Se você omitir algum campo no corpo da requisição, ele será **substituído** ou **apagado**.
    - **Exemplo**: Se você enviar um recurso com o nome e idade de um estudante, todos os outros campos (como curso ou endereço) precisam ser incluídos, ou serão apagados ou substituídos.
    
    **Exemplo de PUT**:
    
    ```json
    {
      "nome": "João Silva",
      "idade": 22,
      "curso": "Engenharia"
    }
    
    ```
    
2. **PATCH**:
    - **Atualiza parcialmente** o recurso, ou seja, apenas os campos que foram especificados.
    - Você envia **somente os dados que deseja alterar**. Os campos não mencionados **não são afetados**.
    - **Exemplo**: Se você deseja apenas atualizar a idade do estudante, basta enviar esse campo, e os outros dados permanecerão inalterados.
    
    **Exemplo de PATCH**:
    
    ```json
    {
      "idade": 23
    }
    
    ```
    

### Resumo:

- **PUT**: Substitui completamente o recurso, esperando que todos os dados sejam enviados.
- **PATCH**: Atualiza parcialmente o recurso, enviando apenas os campos que precisam ser alterados.
