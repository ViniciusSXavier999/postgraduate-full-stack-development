# ORDENAÇÃO

🏆 Continuação da aula passada


## PASSO A PASSO DA CONTINUAÇÃO DO CÓDIGO DA AULA PASSADA

### 1. ADICIONAMOS ESSAS DUAS LINHAS DE CÓDIGO AO MÉTODO “buscarUsers()”

```tsx
          this.dataSource.sort = this.sort
          this.dataSource.paginator = this.paginator
```

🏆 CÓDIGO buscarUsers() EXPLICAÇÃO DETALHADA

```tsx
buscaUsers(): void {

    this.service.getUsers().subscribe(
      {
        next: (resposta) => {
          this.dataSource = new MatTableDataSource<User> (resposta)
          this.dataSource.sort = this.sort
          this.dataSource.paginator = this.paginator
        },

        // Criação de exceção simples
        error: (erroo: any) => {
          alert('ocorreu algum erro')
          console.log(erroo)
        }
      }
    )
  }

```

Este código é uma função em Angular que faz uma busca de usuários usando um serviço, manipula os dados recebidos, e exibe-os em uma tabela do **Angular Material**. Vamos explicar cada parte detalhadamente.

---

### **1. Nome da Função: `buscaUsers`**

- **`buscaUsers`** é uma função declarada no componente Angular.
- Ela é usada para buscar os dados de usuários por meio de um serviço que retorna um **Observable**.

---

### **2. Uso do Serviço: `this.service.getUsers()`**

- **`this.service.getUsers()`** chama um método de serviço, que provavelmente faz uma requisição HTTP para buscar uma lista de usuários.
- Esse método retorna um **Observable** contendo os dados (possivelmente um array de usuários).

---

### **3. Inscrição no Observable com `subscribe`**

- O método **`subscribe`** é usado para reagir às emissões do Observable.
- No `subscribe`, dois callbacks são passados:
    1. **`next`**: Função executada quando os dados são retornados com sucesso.
    2. **`error`**: Função executada em caso de erro na requisição.

---

### **4. Manipulação dos Dados no `next`**

No callback **`next`**, os dados da resposta (no parâmetro `resposta`) são usados para configurar a tabela.

### Explicação das Linhas:

```tsx
this.dataSource = new MatTableDataSource<User>(resposta);

```

- **`MatTableDataSource`**: É uma classe do **Angular Material** usada para configurar os dados que serão exibidos em uma tabela (`<mat-table>`).
- **`resposta`**: Representa os dados retornados pela API, geralmente uma lista de usuários. Estes dados são passados para o **`MatTableDataSource`** para que possam ser exibidos.

```tsx
this.dataSource.sort = this.sort;

```

- Configura o cabeçalho da tabela para permitir ordenação (`<mat-sort>`).
- **`this.sort`**: É uma referência a um componente `MatSort` no HTML, que permite ordenação das colunas.

```tsx
this.dataSource.paginator = this.paginator;

```

- Configura a tabela para usar paginação (`<mat-paginator>`).
- **`this.paginator`**: É uma referência ao componente `MatPaginator` no HTML, usado para paginar os resultados.

---

### **5. Tratamento de Erro no `error`**

Se a requisição falhar, o callback **`error`** será executado. Neste caso:

```tsx
error: (erroo: any) => {
  alert('ocorreu algum erro');
  console.log(erroo);
}

```

- Um **alerta** é exibido ao usuário informando que ocorreu um erro.
- O erro detalhado é logado no console para ajudar no diagnóstico.

---

### **Exemplo de Funcionamento**

### Serviço (`getUsers`):

O método **`getUsers`** pode ser algo como:

```tsx
getUsers(): Observable<User[]> {
  return this.http.get<User[]>('https://api.example.com/users');
}

```

- Faz uma requisição HTTP GET para buscar usuários.
- Retorna um Observable contendo um array de objetos do tipo `User`.

### Template HTML (Tabela com Angular Material):

O HTML pode ter algo assim:

```html
<table mat-table [dataSource]="dataSource" matSort>
  <ng-container matColumnDef="name">
    <th mat-header-cell *matHeaderCellDef mat-sort-header>Nome</th>
    <td mat-cell *matCellDef="let user">{{ user.name }}</td>
  </ng-container>

  <ng-container matColumnDef="email">
    <th mat-header-cell *matHeaderCellDef mat-sort-header>Email</th>
    <td mat-cell *matCellDef="let user">{{ user.email }}</td>
  </ng-container>

  <tr mat-header-row *matHeaderRowDef="displayedColumns"></tr>
  <tr mat-row *matRowDef="let row; columns: displayedColumns;"></tr>
</table>

<mat-paginator [pageSize]="10"></mat-paginator>

```

### Configuração no Componente:

No arquivo TypeScript do componente:

```tsx
displayedColumns: string[] = ['name', 'email'];
@ViewChild(MatSort) sort!: MatSort;
@ViewChild(MatPaginator) paginator!: MatPaginator;

```

---

### **Resumo**

1. **`this.service.getUsers()`** faz uma requisição HTTP e retorna os dados.
2. No **callback `next`**:
    - Os dados recebidos (`resposta`) são passados para `MatTableDataSource`.
    - Ordenação (`sort`) e paginação (`paginator`) são configuradas.
3. No **callback `error`**:
    - Um alerta é exibido e o erro é registrado no console.
4. O Angular Material é usado para exibir os dados em uma tabela com ordenação e paginação.

Essa estrutura simplifica a exibição de dados tabulares de uma API no Angular.


### 2. VAMOS ADICIONAR ESSA LINHA DE CÓDIGO DO @VIEWCHILD

```tsx
@*ViewChild*(MatTable, {static: false}) table!: MatTable<User>
```

🏆 EXPLICAÇÃO DESSA LINHA DE CÓDIGO

O decorador **`@ViewChild`** no Angular é usado para acessar um elemento ou componente filho diretamente no TypeScript. Aqui está o que cada parte significa:

```tsx
@ViewChild(MatTable, {static: false}) table!: MatTable<User>;

```

### **Explicação Resumida:**

1. **`@ViewChild(MatTable)`**:
    - Está buscando uma instância do componente **`MatTable`** no template associado (HTML).
    - O componente `MatTable` é parte do Angular Material e é usado para exibir dados tabulares.
2. **`{static: false}`**:
    - Indica que a referência ao elemento ou componente filho só será resolvida após o ciclo de vida **`ngAfterViewInit`**.
    - Geralmente usado quando o componente ou elemento pode ser adicionado ou alterado dinamicamente.
3. **`table!: MatTable<User>`**:
    - Declara uma variável chamada `table` do tipo **`MatTable<User>`**.
    - O operador `!` diz ao TypeScript que a variável será inicializada antes de ser usada (garantia manual).

---

### **Uso Prático:**

Essa referência permite que você interaja diretamente com a tabela no código, como para:

- Atualizar dados dinamicamente.
- Acessar métodos ou propriedades específicas da tabela.

Exemplo de uso:

```tsx
this.table.renderRows();

```

Aqui, **`renderRows()`** força a tabela a renderizar novamente os dados.


### 3. AGORA VAMOS ALTERAR NOSSA WIEW HTML QUE É A LISTA ADICIONANDO AS COLUNAS QUE FALTAM PARA ELA

```html
 <!-- EMAIL Column -->
    <ng-container matColumnDef="email">
      <th mat-header-cell *matHeaderCellDef mat-sort-header>Email</th>
      <td mat-cell *matCellDef="let row">{{row.email}}</td>
    </ng-container>

    
        
    <!-- PHONE Column -->
    <ng-container matColumnDef="phone">
      <th mat-header-cell *matHeaderCellDef mat-sort-header>Telefone</th>
      <td mat-cell *matCellDef="let row">{{row.phone}}</td>
    </ng-container>

    <!-- CPF Column -->
    <ng-container matColumnDef="cpf">
      <th mat-header-cell *matHeaderCellDef mat-sort-header>CPF</th>
      <td mat-cell *matCellDef="let row">{{row.cpf}}</td>
    </ng-container>
```

### 4. TESTES E FEEDBACK

> Durante os testes, primeiro não estava buscando os dados pois faltava um dataSoure na linha do código HTML
> 

🏆 Podemos adicionar mais funcionalidades caso seja necessário, como por exemplo um botão de detalhes


🏆 A intenção principal é fazer o CRUD


💡 Para praticar é recomendado a gente fazer outro CRUD, como por exemplo o de produto


💡 Praticando aprende muito mais rápido


---

---

---

## DÚVIDAS QUE SURGIRAM DURANTE A AULA

### Qual a instância que o **`@ViewChild(MatTable)` está buscando no HTML e explicação do funcionamento**

No código HTML fornecido, a instância que o **`@ViewChild(MatTable)`** está buscando é o elemento **`<table mat-table>`**, que é um componente da biblioteca **Angular Material**.

---

### **Como o `@ViewChild` encontra a instância:**

1. **`mat-table` Diretiva**:
    - A diretiva **`mat-table`** transforma o elemento `<table>` em uma tabela do Angular Material.
    - Ela é automaticamente associada à classe `MatTable` no Angular Material.
2. **Correspondência pelo Tipo `MatTable`**:
    - Quando você declara `@ViewChild(MatTable)`, o Angular procura no template um elemento que use a classe correspondente, neste caso, `MatTable`.
    - O `<table mat-table>` satisfaz esse critério.
3. **Como é associada no código**:
    - O Angular localiza o elemento com a diretiva `mat-table`, cria uma instância de `MatTable` para ele, e a referencia na variável declarada pelo `@ViewChild`.

---

### **Resumo:**

- O `@ViewChild(MatTable)` busca a instância do componente **`MatTable`**, que está sendo aplicado ao elemento:
    
    ```html
    <table mat-table class="full-width-table" matSort aria-label="Elements">
    
    ```
    
- Isso permite que você manipule diretamente a tabela no TypeScript, como renderizar novamente linhas ou acessar métodos da tabela.

---

---

---

### EXPLICA ESSA LINHA DE CÓDIGO HTML

```html
 <ng-container matColumnDef="email">
 <th mat-header-cell *matHeaderCellDef mat-sort-header>Email</th>
 <td mat-cell *matCellDef="let row">{{row.email}}</td>
 </ng-container>
```

Essa linha de código define uma **coluna** em uma tabela do Angular Material (**`<mat-table>`**) para exibir dados relacionados ao campo **`email`** de um objeto. Vamos analisar parte por parte:

---

### **1. `<ng-container matColumnDef="email">`**

- **`<ng-container>`**:
    - Um contêiner lógico que não gera um elemento DOM visível. Ele serve apenas como agrupador para os elementos relacionados à definição da coluna.
- **`matColumnDef="email"`**:
    - Define o identificador único da coluna como **`email`**.
    - Esse identificador deve corresponder a uma entrada no array **`displayedColumns`** no componente TypeScript para que a coluna seja exibida.

---

### **2. `<th mat-header-cell *matHeaderCellDef mat-sort-header>Email</th>`**

- **`<th>`**:
    - Cria uma célula de cabeçalho para a coluna.
- **`mat-header-cell`**:
    - Diretiva do Angular Material que estiliza o cabeçalho da célula de acordo com o tema do Angular Material.
- **`matHeaderCellDef`**:
    - Marca esta célula como sendo a definição do cabeçalho da coluna.
- **`mat-sort-header`**:
    - Habilita a funcionalidade de ordenação na coluna, permitindo que o usuário clique no cabeçalho para ordenar os dados.
- **`Email`**:
    - Texto exibido no cabeçalho da coluna.

---

### **3. `<td mat-cell *matCellDef="let row">{{row.email}}</td>`**

- **`<td>`**:
    - Cria uma célula de dados (linha) correspondente à coluna.
- **`mat-cell`**:
    - Diretiva do Angular Material que estiliza a célula de dados de acordo com o tema.
- **`matCellDef="let row"`**:
    - Liga esta célula aos dados da linha atual. A variável **`row`** contém os dados da linha.
- **`{{row.email}}`**:
    - Exibe o valor do campo **`email`** do objeto representado pela linha.

---

### **Contexto Geral**

Essa estrutura funciona como parte de uma tabela **`<mat-table>`** para exibir os dados. Cada linha da tabela está associada a um objeto, e cada coluna é configurada para exibir um campo específico desse objeto.

### **Exemplo de Objeto para o Contexto**

Se os dados exibidos forem:

```tsx
dataSource = [
  { id: 1, name: 'John Doe', email: 'john.doe@example.com' },
  { id: 2, name: 'Jane Smith', email: 'jane.smith@example.com' },
];

```

A coluna **`email`** exibiria:

- **`john.doe@example.com`** na primeira linha.
- **`jane.smith@example.com`** na segunda linha.

---

### **Resumo**

Essa estrutura define a coluna **`email`**:

1. O cabeçalho exibe o texto **`Email`**.
2. As células de dados exibem o valor do campo **`email`** de cada objeto.
3. Ordenação é habilitada no cabeçalho da coluna graças à diretiva **`mat-sort-header`**.

Isso integra perfeitamente com as funcionalidades do **Angular Material Table**.

---

---

---

### EXPLICA ESSA LINHA DE CÓDIGO

"[dataSource]="dataSource">

O código **`[dataSource]="dataSource"`** em Angular é uma **data binding** (ligação de dados) no template de uma tabela do Angular Material (**`<mat-table>`**).

---

### **Significado Resumido:**

- **`[dataSource]`**:
    - Um **property binding** que conecta a propriedade `dataSource` do componente HTML (`<mat-table>`) a uma variável definida no TypeScript do componente.
    - A propriedade `dataSource` do `<mat-table>` controla os dados que serão exibidos na tabela.
- **`dataSource`**:
    - Refere-se a uma variável no arquivo TypeScript do componente.
    - Geralmente, é uma instância de **`MatTableDataSource`**, que encapsula os dados da tabela e gerencia funcionalidades como paginação e filtragem.

---

### **Como Funciona:**

1. **No TypeScript:**
    
    ```tsx
    dataSource = new MatTableDataSource<User>([
      { id: 1, name: 'John Doe', email: 'john.doe@example.com' },
      { id: 2, name: 'Jane Smith', email: 'jane.smith@example.com' }
    ]);
    
    ```
    
    Aqui, a variável `dataSource` contém os dados da tabela.
    
2. **No HTML:**
    
    ```html
    <table mat-table [dataSource]="dataSource">
    
    ```
    
    A tabela exibirá os dados contidos na variável `dataSource`.
    

---

### **Resumo**

O **`[dataSource]`** conecta a tabela aos dados fornecidos pelo componente, permitindo que o Angular Material gerencie e exiba esses dados na interface de forma automática e organizada.