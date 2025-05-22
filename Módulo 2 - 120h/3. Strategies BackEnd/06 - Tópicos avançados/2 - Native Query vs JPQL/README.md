# 2 → NATIVE QUERY VS JPQL

### DIFERENÇA ENTRE NATIVE QUERY E JPQL.

### NATIVE QUERY

🏆 Native Query é o SQL que a origem de dados usa, no nosso caso MYSQL.

Depende da plataforma usada


### JPQL

🏆 Jakarta Persistence Query Languages (JPQL) é uma linguagem de consulta orientada a objeto independente da plataforma 


---

🏆 O JPA nos fornece duas formas de construir queries: JPQL e QUERY LOOKUP STRATEGIES


🏆 QUERY LOOKUP STRATEGIES é a habilidade de construir consultas através dos nomes dos métodos.

---

## ✅ O que é **Query Lookup Strategy** no Spring Data JPA?

É a **estratégia que o Spring usa para encontrar ou gerar a consulta (query)** que um método no repositório irá executar.

---

## 🔧 Existem 3 estratégias principais:

1. **`CREATE` (padrão):**
    
    O Spring **cria a query automaticamente** com base no nome do método.
    
    👉 Exemplo: `findByNome(String nome)` vira `SELECT e FROM Entidade e WHERE e.nome = :nome`
    
2. **`USE_DECLARED_QUERY`:**
    
    Usa uma query definida **manualmente** com a anotação `@Query`.
    
3. **`CREATE_IF_NOT_FOUND`:**
    
    Tenta usar uma query manual (`@Query`), e **se não encontrar, cria baseada no nome do método**.
    

---

## 🧩 Exemplo prático:

### 📌 Interface com método gerado automaticamente (`CREATE`):

```java
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    List<Estudante> findByNome(String nome);
}

```

➡️ O Spring **gera a query automaticamente** com base no nome `findByNome`.

---

### 📌 Mesmo método com query manual (`USE_DECLARED_QUERY`):

```java
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

    @Query("SELECT e FROM Estudante e WHERE e.nome = :nome")
    List<Estudante> buscarPorNome(@Param("nome") String nome);
}

```

➡️ Aqui, **você define a query manualmente**.

---

## 🔧 Como definir a estratégia (geralmente opcional):

No `application.properties` (raro de usar):

```
spring.data.jpa.repositories.query-lookup-strategy=create

```

Mas normalmente o Spring detecta automaticamente com base no que você escreve.

---

## 🎯 Resumo

| Estratégia | O que faz |
| --- | --- |
| `CREATE` | Cria query a partir do nome do método |
| `USE_DECLARED_QUERY` | Usa query escrita com `@Query` |
| `CREATE_IF_NOT_FOUND` | Usa `@Query` se existir, senão cria a partir do nome |

---


---

## EXEMPLO:

### Imagina se o diretor da escola quisesse saber quais alunos ainda não avaliaram nenhum curso. Como você faria essa consulta?

<img width="700" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/nativeQueryVsJPQL1.png" />

🏆 Quando utilizamos uma query nativa precisamos colocar “nativeQuery = true” assim como esta no primeiro exemplo;


🏆 Todas essas 3 consultas faz exatamente a mesma coisa!.


---

## PRATICANDO!

### VAMOS CRIAR UM ENDPOINT PARA OS ESTUDANTES QUE AINDA NÃO AVALIARAM OS CURSOS.

### 1. CRIAR O REPOSITORY COM A OPÇÃO DE QUERY QUE VOCÊ PREFERIR (VAMOS TER 3 CONSULTAS QUE FAZ A MESMA COISA, APENAS COMO EXEMPLO.)

### 1 → MÉTODO → QUERY NATIVA

```java
@Query(value = "SELECT e.* FROM api.estudante e " + 
	               " left join api.avaliacao_curso ac ON ac.estudante_id = e.id " + 
			       " where ac.estudante_id is null", nativeQuery = true)
	List<Estudante> findByAvaliacaoCursosEstudantesIsNullNativeQuery();
```

## 🧠 O que esse código faz?

```java
@Query(
  value = "SELECT e.* FROM api.estudante e " +
          "LEFT JOIN api.avaliacao_curso ac ON ac.estudante_id = e.id " +
          "WHERE ac.estudante_id IS NULL",
  nativeQuery = true
)
List<Estudante> findByAvaliacaoCursosEstudantesIsNullNativeQuery();

```

### ✅ Em português:

> Busque todos os estudantes que não têm nenhuma avaliação de curso associada.
> 

---

## 🔍 Explicando parte por parte:

### 🔹 `SELECT e.* FROM api.estudante e`

Seleciona todos os dados da tabela `estudante`.

---

### 🔹 `LEFT JOIN api.avaliacao_curso ac ON ac.estudante_id = e.id`

- Faz um **LEFT JOIN** entre `estudante` e `avaliacao_curso`.
- Ou seja, **pega todos os estudantes**, com ou **sem** avaliações.
- Quando o estudante **não tiver avaliação**, os campos da `avaliacao_curso` virão como `NULL`.

---

### 🔹 `WHERE ac.estudante_id IS NULL`

- **Filtra** os resultados para manter apenas os estudantes **sem avaliação associada**.
- Isso significa: "mostre apenas os estudantes que **não têm registros correspondentes** na tabela `avaliacao_curso`".

---

## ✅ Resultado final:

Você está retornando uma lista de estudantes **sem avaliações registradas**.

---

## 📌 Observações importantes:

- `nativeQuery = true` indica que **isso é SQL puro**, e não JPQL.
- `api.estudante` e `api.avaliacao_curso` indicam que você está usando um schema chamado `api`.
- O método no repositório (`findBy...`) poderia ter qualquer nome — o nome **não influencia a execução da query nativa**, já que a consulta está totalmente definida no `@Query`.

---

---

---

### 2 → MÉTODO → QUERY JPQL

```java
	// QUERY JPQL
	@Query(value = "SELECT e FROM Estudante e LEFT JOIN e.avaliacoes ac WHERE ac IS NULL")
	List<Estudante> findByAvaliacaoCursosEstudantesIsNullJPQL();
```

## ✅ **O que é esse método?**

```java
@Query(value = "SELECT e FROM Estudante e LEFT JOIN e.avaliacoes ac WHERE ac IS NULL")
List<Estudante> findByAvaliacaoCursosEstudantesIsNullJPQL();

```

### 🧠 Ele é:

- Um **método de repositório no Spring Data JPA**
- Usando **JPQL** (Java Persistence Query Language)
- Que faz uma **consulta personalizada com `@Query`**

---

## 🔍 **O que essa consulta faz?**

> Retorna todos os estudantes que ainda não possuem nenhuma avaliação registrada.
> 

---

### Explicando parte por parte:

### 📌 `SELECT e FROM Estudante e`

- Seleciona objetos do tipo `Estudante`.

### 📌 `LEFT JOIN e.avaliacoes ac`

- Faz um **LEFT JOIN** entre `Estudante` e sua coleção de `avaliacoes`.
- Mesmo se o estudante **não tiver avaliação**, ele ainda aparece no resultado (com `avaliacoes = null`).

### 📌 `WHERE ac IS NULL`

- Filtra os resultados e retorna **somente os estudantes que não têm avaliações** associadas.

---

## 🧩 Requisitos para funcionar:

- A entidade `Estudante` deve ter um relacionamento, algo como:

```java
@OneToMany(mappedBy = "estudante")
private List<AvaliacaoCurso> avaliacoes;

```

---

## ✅ Resumo rápido:

| Item | Valor |
| --- | --- |
| Tipo de query | JPQL |
| O que retorna | Estudantes **sem nenhuma avaliação de curso** |
| Como faz isso | `LEFT JOIN` + `WHERE ac IS NULL` |
| Requisito | Relacionamento entre `Estudante` e `AvaliacaoCurso` na entidade |

---

---

---

### 3 → MÉTODO → MÉTODO CRIADO A PARTIR DO NOME PELO SPRING

```java
	// QUERY CRIADA PELO SPRING AUTOMATICAMENTE A PARTIR DO NOME
	List<Estudante> findByAvaliacaoCursosEstudanteIsNull();
```

## ✅ O que é esse método?

```java
List<Estudante> findByAvaliacaoCursosEstudanteIsNull();

```

É um **método de repositório** no Spring Data JPA que:

- **Não usa `@Query`**
- **Deixa o Spring gerar a consulta automaticamente** com base no nome

Essa abordagem é conhecida como:

> 🔹 Query method name derivation
> 

---

## 🧠 O que esse método faz?

### Ele busca:

> Todos os estudantes que não têm nenhuma avaliação associada a eles
> 
> 
> *(ou seja, `AvaliacaoCurso.estudante` é `null`)*
> 

---

## 🧩 Como o Spring interpreta esse nome:

- `findBy...` → indica que é uma consulta
- `AvaliacaoCursos` → nome da **coleção ou relacionamento** na entidade `Estudante` (ou `AvaliacaoCurso`, dependendo do lado)
- `Estudante` → nome da **entidade associada**
- `IsNull` → condição que filtra onde o campo é `null`

---

## ⚠️ Interpretação depende do mapeamento!

Essa query **só funciona corretamente se as entidades estiverem mapeadas de forma compatível**.

Exemplo de entidades envolvidas:

### 📘 `AvaliacaoCurso`:

```java
@ManyToOne
private Estudante estudante;

```

### 📗 `EstudanteRepository`:

```java
List<Estudante> findByAvaliacaoCursosEstudanteIsNull();

```

➡ Aqui, o Spring interpreta que você quer os estudantes **cujos registros de avaliação (`AvaliacaoCurso`) ainda não têm estudante associado** (o que talvez seja raro).

---

## 🛠️ Mais comum: buscar estudantes sem avaliações

Se a ideia for **buscar estudantes que não têm nenhuma avaliação**, o nome mais comum seria:

```java
List<Estudante> findByAvaliacoesIsEmpty();

```

- Isso funciona se a entidade `Estudante` tiver:

```java
@OneToMany(mappedBy = "estudante")
private List<AvaliacaoCurso> avaliacoes;

```

---

## ✅ Resumo final

| Item | Valor |
| --- | --- |
| Tipo de método | Query automática baseada no nome (`query derivation`) |
| O que retorna | Estudantes ligados a avaliações onde `estudante` é `null` |
| Atenção | Pode não funcionar como esperado se os nomes das entidades não baterem |
| Alternativa comum | `findByAvaliacoesIsEmpty()` → estudantes **sem avaliações** |

### 2. CRIAR O SERVICE

```java

	public List<Estudante> buscarEstudanteQueNaoAvaliaram(){
		return repository.findByAvaliacaoCursosEstudanteIsNull();
	}
```

### 3. CRIAR O CONTROLLER COM O ENDPOINT

```java

	@GetMapping("/naoAvaliaram")
	public List<Estudante> buscarEstudantesQueNaoAvaliaram() {
		return estudanteService.buscarEstudanteQueNaoAvaliaram();
	}
```

---

---

---

### TESTES NO POSTMAN E NO BANCO DE DADOS

💡 Após realizar a buscar no endpoint criado no postman, vamos pegar a query nativa e executar no banco de dados para conferir se os resultados são os mesmos.

### QUERY PARA UTILIZAR NO MYSQL

```sql
 SELECT e.* FROM estudante e LEFT JOIN avaliacao_curso ac ON ac.estudante_id = e.id  WHERE ac.estudante_id IS NULL
```


---

---

---

## DÚVIDAS QUE SURGIRAM DURANTE A AULA E EU FUI ATRÁS PARA PESQUISAR

### DÚVIDA SOBRE ALIAS

### ✅ O que significa o `ac` nesta query?

```java
@Query("SELECT e FROM Estudante e LEFT JOIN e.avaliacoes ac WHERE ac IS NULL")

```

### 🔹 `ac` é um **alias (apelido)** para a entidade `AvaliacaoCurso`

- Aqui, `e` é o alias para `Estudante`.
- `ac` é o alias para cada item da coleção `avaliacoes` (ou seja, instâncias de `AvaliacaoCurso`).

---

## 🧠 Por que usar alias?

Alias (apelidos) são usados para:

- Deixar a query **mais curta e legível**.
- Permitir **referenciar** aquela entidade mais de uma vez se necessário.
- Evitar repetir nomes longos como `e.avaliacoes`.

---

## 📌 Exemplo comentado:

```
SELECT e                    -- seleciona estudantes
FROM Estudante e            -- alias 'e' para a entidade Estudante
LEFT JOIN e.avaliacoes ac   -- alias 'ac' para os itens da lista 'avaliacoes'
WHERE ac IS NULL            -- filtra estudantes que não têm avaliações

```

---

## 🧩 E na entidade?

Na sua entidade `Estudante`, provavelmente você tem algo assim:

```java
@OneToMany(mappedBy = "estudante")
private List<AvaliacaoCurso> avaliacoes;

```

- `e.avaliacoes` acessa a lista de avaliações.
- `ac` representa **cada item dessa lista** durante o `JOIN`.

---

## ✅ Resumo

| Símbolo | Significa o quê? |
| --- | --- |
| `e` | Apelido para a entidade `Estudante` |
| `ac` | Apelido para cada `AvaliacaoCurso` ligada ao estudante |
| Usado para | Deixar a query mais legível e referenciar facilmente |

---

🏆

### DÚVIDA SOBRE LOOP INFINITO NA CONVERSÃO DE OBJETO PARA JSON (SERIALIZAÇÃO.) 🚨

eu estava recebendo um erro de loop infinito no postman **de serialização JSON** causado por uma **referência cíclica bidirecional** entre duas entidades — nesse caso, `Estudante` e `Endereco`


---

### 🔄 O que está acontecendo?

Na sua entidade `Estudante`, você tem um campo como:

```java
@OneToOne(mappedBy = "estudante")
private Endereco endereco;

```

E na entidade `Endereco`, provavelmente algo assim:

```java
@OneToOne
@JoinColumn(name = "estudante_id")
private Estudante estudante;

```

Quando o Jackson tenta converter isso em JSON, ele faz:

1. Serializa o `Estudante`
2. Vai para `estudante.endereco`
3. Depois para `endereco.estudante`
4. Depois para `estudante.endereco.estudante`
5. E assim por diante…

💥 Resultado: loop infinito → JSON gigante → **resposta quebrada ou travada**

---

## ✅ Como resolver isso

Você tem **3 opções**, e pode escolher a mais adequada ao seu caso:

---

### 🔹 **1. Usar `@JsonIgnore` em um dos lados da relação**

Esse é o jeito **mais direto** e geralmente suficiente.

**Exemplo:**

```java
@OneToOne
@JoinColumn(name = "estudante_id")
@JsonIgnore
private Estudante estudante;

```

> Isso diz ao Jackson para ignorar esse campo na serialização.
> 

---

### 🔹 **2. Usar `@JsonManagedReference` e `@JsonBackReference`**

Esse método mantém o relacionamento, mas evita o loop.

**No lado “pai” (ex: `Estudante`)**:

```java
@OneToOne(mappedBy = "estudante")
@JsonManagedReference
private Endereco endereco;

```

**No lado “filho” (ex: `Endereco`)**:

```java
@OneToOne
@JoinColumn(name = "estudante_id")
@JsonBackReference
private Estudante estudante;

```

> ⚠️ Isso impede que o campo anotado com @JsonBackReference apareça no JSON.
> 

---

### 🔹 **3. Usar um DTO (Data Transfer Object)**

Separar as entidades da resposta JSON. Em vez de retornar a entidade diretamente, você monta um objeto leve com os dados que realmente quer mostrar.

---

## ✅ Qual é o melhor?

| Situação | Melhor solução |
| --- | --- |
| Só precisa retornar um lado do relacionamento | `@JsonIgnore` |
| Precisa manter o relacionamento mas evitar loop | `@JsonManagedReference` / `@JsonBackReference` |
| API pública ou precisa controle total | Usar DTOs |

---

## 🎯 Resumo

Você tem uma **referência circular entre `Estudante` e `Endereco`**, e o Jackson entra em **loop infinito**.

📌 **Solução rápida:**

Adicione `@JsonIgnore` no campo `Endereco.estudante`:

```java
@OneToOne
@JoinColumn(name = "estudante_id")
@JsonIgnore
private Estudante estudante;

```

---


### O QUE É UM RELACIONAMENTO BIDIRECIONAL? 🚨

**é uma relação entre dois objetos ou entidades que pode ser acessada em ambas as direções**


### PODE USAR OS DOIS JUNTOS? @JSONIGNORE JUNTO COM @JSONMANAGEDREFERENCE E @JSONBACKREFERENCE. 🚨

---

## ✅ **Você pode usar `@JsonManagedReference` / `@JsonBackReference` ou `@JsonIgnore` — mas não os dois ao mesmo tempo no mesmo campo.**

### ⚠️ Usar os dois **simultaneamente no mesmo campo** **causa conflito** e pode gerar erro ou comportamento imprevisível.

---

### 📌 Quando usar cada um:

| Situação | Use... |
| --- | --- |
| Quer evitar loop e **manter serialização do "lado pai"** | `@JsonManagedReference` no pai + `@JsonBackReference` no filho |
| Quer simplesmente **ignorar um lado da relação** no JSON | `@JsonIgnore` |

---

### 🧪 O que acontece se misturar?

```java
@OneToOne
@JsonIgnore
@JsonBackReference // ⚠️ Conflito aqui!
private Estudante estudante;

```

➡ Isso pode gerar:

- **Avisos em tempo de compilação**
- **Erro de mapeamento Jackson em runtime**
- Ou o comportamento pode **não ser o que você espera** (por exemplo, o campo pode não ser ignorado como deveria)

---

## 🎯 Regra prática:

✔️ Use **apenas um** dos dois por campo:

- `@JsonIgnore` se você quer **simplesmente omitir aquele campo do JSON**
- `@JsonManagedReference` / `@JsonBackReference` se você quer **controlar serialização em relações bidirecionais**

---

### 💡 Dica final:

Se sua entidade tiver muitas relações complexas, considere usar DTOs — isso **resolve de forma limpa e segura** o problema da serialização sem depender de anotações específicas do Jackson nas entidades.

Se quiser, posso te mostrar um exemplo simples com DTO para seu caso de `Estudante` e `Endereco`.


### O QUE É SERIALIZAÇÃO E DESSERIALIZAÇÃO? 🚨

## ✅ **O que é serialização?**

**Serialização** é o processo de **converter um objeto Java em outro formato que possa ser transmitido ou armazenado** — geralmente:

- JSON (em APIs REST)
- XML
- Binário (em arquivos ou streams de rede)

---

### 📌 No contexto do Spring Boot:

Quando você retorna um objeto no controller:

```java
@GetMapping("/estudante")
public Estudante getEstudante() {
    return estudanteService.buscarPorId(1L);
}

```

O Spring (usando Jackson) **serializa** esse `Estudante` para JSON automaticamente, para que o cliente (ex: Postman, navegador ou frontend) consiga entender a resposta.

### Exemplo:

Objeto Java:

```java
new Estudante(1L, "Maria", "maria@email.com")

```

Resposta JSON:

```json
{
  "id": 1,
  "nome": "Maria",
  "email": "maria@email.com"
}

```

➡️ **Isso é serialização.**

---

## 🔄 E o que é desserialização?

É o processo **inverso**: pegar um JSON (ou XML etc.) e **converter em um objeto Java**.

### Exemplo:

Você envia esse JSON no corpo de uma requisição:

```json
{
  "nome": "João",
  "email": "joao@email.com"
}

```

Se o controller tiver isso:

```java
@PostMapping("/estudante")
public void criarEstudante(@RequestBody Estudante estudante) {
    // ...
}

```

O Spring vai **desserializar** esse JSON em um objeto `Estudante`.

---

## ✅ Resumo

| Conceito | Significado |
| --- | --- |
| **Serialização** | Converter objeto Java → JSON (para resposta da API) |
| **Desserialização** | Converter JSON → objeto Java (ao receber dados na requisição) |

### O @JSONIGNORE CORTA O RELACIONAMENTO? 🚨

### ❌ **Não, o `@JsonIgnore` *não* corta o relacionamento entre entidades.**

Ele **apenas impede que aquele campo apareça no JSON**.

---

## ✅ O que o `@JsonIgnore` faz (e o que não faz):

| Ação | `@JsonIgnore` faz? |
| --- | --- |
| Impede que o campo apareça no JSON | ✅ Sim |
| Impede que o campo seja populado no JSON recebido (POST/PUT) | ✅ Sim |
| Remove ou quebra o relacionamento entre entidades no JPA | ❌ **Não** |
| Impede o uso do campo no Java | ❌ Não — continua acessível no código |

---

### 📌 Exemplo prático:

```java
@Entity
public class Endereco {

    @Id
    private Long id;

    private String rua;

    @OneToOne
    @JoinColumn(name = "estudante_id")
    @JsonIgnore // <--- Aqui
    private Estudante estudante;
}

```

### 🔎 Comportamento:

- **No banco de dados:** o relacionamento entre `Endereco` e `Estudante` continua funcionando perfeitamente.
- **No seu código Java:** você ainda pode acessar `endereco.getEstudante()`.
- **Na resposta da API (JSON):** o campo `estudante` **não aparece**.
- **Na requisição JSON (POST/PUT):** se você enviar esse campo, ele **será ignorado**.

---

### ✅ Quando usar `@JsonIgnore`?

Use quando:

- Você **não precisa mostrar aquele campo** na resposta da API
- Quer **evitar loops de serialização** (relacionamentos bidirecionais)
- O campo contém **dados sensíveis ou irrelevantes para o cliente**

---

Se quiser manter o relacionamento **e ainda controlar como ele aparece no JSON**, o ideal é usar um **DTO** (objeto de transferência de dados). Posso te mostrar um exemplo também, se quiser.

---

✅ **Resumo:**

`@JsonIgnore` **esconde o campo do JSON**, mas **não afeta o relacionamento nem o funcionamento interno da aplicação ou do JPA**.


### se eu aplicar o @Jsonignore na classe endereco e eu der um get na classe estudante via endpoint, o estudante vai aparecer na minha resposta na api? 🚨

---

## ✅ **Sim**, se você aplicar `@JsonIgnore` no campo `estudante` **dentro da classe `Endereco`**, e fizer um `GET` da entidade `Estudante`, **o `Estudante` vai aparecer normalmente na resposta da API.**

### 👉 O que vai acontecer:

- O JSON do `Estudante` vai incluir o `Endereco`
- Mas **dentro do `Endereco`, o campo `estudante` não vai aparecer** (graças ao `@JsonIgnore`)

---

### 📘 Exemplo prático:

### 🔹 Classe `Estudante`:

```java
@Entity
public class Estudante {

    @Id
    private Long id;
    private String nome;

    @OneToOne(mappedBy = "estudante", cascade = CascadeType.ALL)
    private Endereco endereco;

    // getters/setters
}

```

### 🔹 Classe `Endereco`:

```java
@Entity
public class Endereco {

    @Id
    private Long id;
    private String rua;

    @OneToOne
    @JoinColumn(name = "estudante_id")
    @JsonIgnore  // <--- AQUI!
    private Estudante estudante;

    // getters/setters
}

```

---

### 🔄 Requisição GET `/estudantes/1`

### 🔸 Resposta da API (JSON):

```json
{
  "id": 1,
  "nome": "João",
  "endereco": {
    "id": 10,
    "rua": "Rua X"
    // "estudante" está oculto aqui por causa do @JsonIgnore
  }
}

```

🔹 Ou seja:

- **Você vê o `Estudante` inteiro**
- **Você vê o `Endereco`**
- Mas **não vê o `Estudante` de novo dentro do `Endereco`**, evitando loop

---

## ✅ Conclusão

| Situação | Resultado |
| --- | --- |
| `@JsonIgnore` no campo `estudante` (dentro de `Endereco`) | `Estudante` aparece normalmente na resposta da API |
| Campo `estudante` dentro do `Endereco` | Não aparece no JSON (fica oculto) |



### DÚVIDA SOBRE @JSONIGNORE 🚨

---

### ✅ Quando você usa `@JsonIgnore`, **o campo continua existindo no objeto Java** normalmente, mas:

- ❌ **Não aparece no JSON de resposta (serialização)**
- ❌ **Não é esperado no JSON de entrada (desserialização)**

---

### 📌 Exemplo prático:

### Classe Java:

```java
public class Endereco {
    private Long id;
    private String logradouro;

    @JsonIgnore
    private Estudante estudante;

    // getters e setters
}

```

### Requisição GET (JSON retornado):

```json
{
  "id": 1,
  "logradouro": "Rua Exemplo"
  // estudante foi ignorado!
}

```

🔍 O campo `estudante` **existe no objeto Java**, você pode acessá-lo no código normalmente (`endereco.getEstudante()`), mas **o Jackson não o inclui no JSON** retornado pela API.

---

## ✅ Quando usar `@JsonIgnore`

| Situação | Deve usar? |
| --- | --- |
| Relação bidirecional para evitar loop | ✅ Sim |
| Campo sensível que não deve aparecer | ✅ Sim |
| Campo só usado internamente | ✅ Sim |
| Precisa que o campo apareça na resposta | ❌ Não |

---

## ✅ Alternativa se você **precisa do campo** no objeto Java **e** quer controlar como ele aparece no JSON:

Use um **DTO personalizado**, como:

```java
public class EnderecoDTO {
    private Long id;
    private String logradouro;
    // não inclui estudante
}

```

Aí você retorna esse DTO no controller, e não a entidade JPA.

---

### ✅ Resumindo

| Comportamento | Resultado com `@JsonIgnore` |
| --- | --- |
| `get` no Java (`obj.getCampo()`) | ✅ Funciona normalmente |
| Resposta JSON da API (GET) | ❌ Campo não aparece |
| Esperado em POST/PUT via JSON | ❌ Campo é ignorado na desserialização também |

Se quiser que ele **continue aparecendo no Java** mas **não cause loop na serialização**, `@JsonIgnore` é o caminho mais direto.

