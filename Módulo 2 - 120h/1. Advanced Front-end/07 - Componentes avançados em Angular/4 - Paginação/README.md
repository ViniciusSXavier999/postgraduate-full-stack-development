# PAGINAÇÃO

## O QUE SIGNIFICA OS SCHEMATICS DO ANGULAR MATERIAL?

🏆 São os templates de um componente, só que completos.

No Angular, **schematics** são ferramentas que ajudam a automatizar a criação, modificação e manutenção de projetos ou arquivos no Angular, geralmente usados para acelerar o desenvolvimento. Eles são responsáveis por gerar códigos padrão, configurar projetos e implementar mudanças de forma consistente e repetível.

Os schematics são comumente usados com o **Angular CLI** para facilitar tarefas como criar componentes, serviços, módulos, diretivas, ou até mesmo para aplicar atualizações e adicionar bibliotecas ao projeto.

---

### **Exemplos Práticos de Schematics**

1. **Gerar um Componente**:
Quando você executa o comando:
    
    ```bash
    ng generate component meu-componente
    
    ```
    
    Um schematic do Angular CLI é acionado para criar o componente com:
    
    - Arquivos básicos (`.ts`, `.html`, `.css`, `.spec.ts`).
    - Importação e configuração no módulo apropriado.
2. **Adicionar uma Biblioteca**:
Ao usar um comando como:
    
    ```bash
    ng add @angular/material
    
    ```
    
    Um schematic do Angular Material é executado para instalar a biblioteca, configurar estilos globais e adicionar módulos necessários ao projeto.
    
3. **Atualizar um Projeto Angular**:
Quando você executa:
    
    ```bash
    ng update @angular/core
    
    ```
    
    Schematics são usados para aplicar atualizações no código do projeto, ajustar configurações e garantir compatibilidade com versões mais recentes.
    

---

### **Tipos de Schematics**

1. **Schematics do Angular CLI**:
Incluem comandos nativos, como `ng generate` e `ng add`, para criar e configurar componentes, serviços, módulos, diretivas, etc.
2. **Schematics de Bibliotecas de Terceiros**:
Algumas bibliotecas, como Angular Material, PrimeNG, e NgRx, fornecem seus próprios schematics para facilitar a instalação e configuração.
3. **Schematics Personalizados**:
Desenvolvedores podem criar seus próprios schematics para atender a necessidades específicas, como:
    - Criar componentes com estrutura personalizada.
    - Aplicar configurações padronizadas no projeto.

---

### **Benefícios dos Schematics**

1. **Automatização**: Reduz o trabalho manual ao criar e configurar arquivos, garantindo consistência no projeto.
2. **Padrões de Código**: Os arquivos gerados seguem boas práticas recomendadas pelo Angular.
3. **Manutenção**: Facilita atualizações e migrações de código em grandes projetos.
4. **Produtividade**: Economiza tempo e reduz erros humanos.

---

### **Como os Schematics Funcionam?**

Os schematics são scripts que definem as mudanças a serem feitas no projeto, usando regras para manipular a estrutura de diretórios e arquivos.

Um schematic pode:

- Criar novos arquivos.
- Modificar arquivos existentes.
- Adicionar dependências ao `package.json`.
- Alterar configurações no `angular.json` ou outros arquivos.

---

### **Comandos Relacionados a Schematics**

1. **Gerar Código**:
    
    ```bash
    ng generate <blueprint> <nome>
    
    ```
    
    Exemplos:
    
    - Criar um componente:
        
        ```bash
        ng generate component meu-componente
        
        ```
        
    - Criar um serviço:
        
        ```bash
        ng generate service meu-servico
        
        ```
        
2. **Adicionar uma Biblioteca**:
    
    ```bash
    ng add <biblioteca>
    
    ```
    
    Exemplo:
    
    - Adicionar Angular Material:
        
        ```bash
        ng add @angular/material
        
        ```
        
3. **Atualizar Dependências**:
    
    ```bash
    ng update
    
    ```
    
    Exemplo:
    
    - Atualizar o Angular para a versão mais recente:
        
        ```bash
        ng update @angular/core @angular/cli
        
        ```
        
4. **Criar Schematics Personalizados**:
Usando o pacote **`@angular-devkit/schematics`**, é possível criar schematics customizados para projetos específicos.

---

### **Resumo**

Os **schematics** são ferramentas que automatizam tarefas no Angular, permitindo criar, modificar ou atualizar projetos de forma eficiente e consistente. Eles são usados frequentemente com o Angular CLI para:

- Gerar novos artefatos, como componentes ou serviços.
- Configurar bibliotecas externas.
- Realizar atualizações no projeto.

Essa funcionalidade ajuda a manter um padrão no código, economiza tempo e facilita a manutenção de projetos Angular.


## PASSO A PASSO

### 1. VAMOS ACESSAR O ANGULAR MATERIAL → https://v17.material.angular.io/guide/schematics. APÓS ISSO COPIAR E COLAR O SEGUINTE COMANDO

```tsx
ng generate @angular/material:table pages/listar
```

> SERÁ O NOSSO NOVO COMPONENTE LISTAR(não é o listar-simples) QUE JÁ TINHAMOS ANTES.
> 

> Essa lista é a mesma lista-simples que temos, mas completamente estilizada pelo Angular material
> 

🚨 Detalhe dessa lista é que o angular criou automaticamente um arquivo datasource com dados estáticos, mas não vamos utilizar eles.


### LISTA ATÉ O MOMENTO(vai ser alterada)


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/paginacao1.png" />

> Em verde podemos ver a páginação da lista
> 

🚨 Na próxima aula vamos trazer esses dados igual tínhamos feito com a lista-simples.


### 2. REALIZAR ALTERAÇÃO NO COMPONENTE MAIN PARA TER UM LINK PARA ESSA NOVA LISTA

```html
  <mat-nav-list>
      <a mat-list-item href="login">Login</a>
      <!-- Esse é o path que está lá no meu app.routes.ts -->
      <a mat-list-item href="cadastroo">Cadastro</a>
      <a mat-list-item href="listar">Listar Usuários</a>
    </mat-nav-list>
```

### 3. COMEÇAR AS ALTERAÇÕES NO LISTAR.COMPONENT.TS

```tsx
 dataSource = **new** MatTableDataSource<User> ([])
```

📌 Significado dessa linha de código

A linha de código:

```tsx
dataSource = new MatTableDataSource<User>([]);

```

faz o seguinte:

- **`MatTableDataSource<User>`**: Cria uma instância do `MatTableDataSource`, um tipo de fonte de dados usado pelo Angular Material para preencher tabelas (`MatTable`). Ele aceita um array de dados do tipo genérico `User`, ou seja, os dados são esperados no formato de objetos `User`.
- **`([])`**: Passa um array vazio como dados iniciais para o `MatTableDataSource`. Esse array será usado para preencher a tabela, e ele está vazio no momento da criação.

Portanto, a linha cria um `MatTableDataSource` vazio, esperando que o tipo de dados seja `User`. Isso significa que, inicialmente, a tabela não exibirá nenhum dado até que o array seja preenchido com dados do tipo `User`.

</aside>

### 4. VAMOS ADICIONAR O NGONINIT E DESENVOLVER A FUNÇÃO `BUSCARUSERS()`

```tsx
  ngOnInit(): void {
      this.buscaUser()
  }

  buscaUser(): void {

    this.service.getUsers().subscribe(
      {
        next: (resposta) => {
          console.log(resposta)
          this.users = resposta
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

> NÃO ESQUECER DE INETAR O ROUTER E O SERVICE NO COMPONENT
> 

```tsx
constructor(private router: Router, public service: UserService) {
  }
```

### 5. VAMOS MUDAR O DISPLAYEDCOLUMNS

antes

```tsx
  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'name'];
```

📌 SIGNIFICADO DE `displayColumns` 

A linha:

```tsx
displayedColumns = ['id', 'name'];

```

define quais colunas serão exibidas na tabela.

- **`displayedColumns`**: É um array que contém os nomes das colunas a serem exibidas na tabela.
- **`['id', 'name']`**: São os identificadores das colunas a serem exibidas, neste caso, uma coluna para o `id` e outra para o `name`. Esses valores correspondem aos campos nos dados que serão mostrados nas colunas da tabela.

Em resumo, essa linha especifica que a tabela deve exibir as colunas "id" e "name".

</aside>

DEPOIS

```tsx
/** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'firstName', 'email', 'phone', 'cpf'];
```

### 6. REALIZAMOS MUDANÇAS NO MÉTODO BUSCARUSERS()

```tsx
 buscaUsers(): void {

    this.service.getUsers().subscribe(
      {
        next: (resposta) => {
        // mudança principal
          this.dataSource = new MatTableDataSource<User> (resposta)
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

## CONCLUSÃO

📌 Eu to pegando os dados da minha REST API e estou atribuindo o MatTableDataSource

> Eles são os objetos desse componente gerados lá do Angular Material
> 

> O matSort que permite ordenar as colunas da tabela (são componentes já prontos do Angular Material)
> 

> O  MatTableDataSource **é uma fonte de dados, a medida que ele vai sendo atualizado ele altera a tabela**
> 

🏆 BASICAMENTE ESTAMOS INDO LÁ NA NOSSA REST API, TRAZENDO NOSSOS USUÁRIOS, MODIFICANDO O QUE FOI GERADO PELO ANGULAR MATERIAL PARA ESSE MATTABLEDATASOURCE PARA ELE SE TORNAR DO TIPO USER COM ESSES DISPLAYCOLUMNS = [’ID’, ‘NAME’, ‘EMAIL’, ‘PHONE’, ‘CPF’]


---

---

---

## DÚVIDAS QUE SURGIRAM DURANTE A AULA

### O que significa esse código?

```tsx
@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.css',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, MatSortModule]
})
export class ListarComponent implements AfterViewInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<ListarItem>;
  dataSource = new ListarDataSource();

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'name'];

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }
}
```

Esse código define um componente Angular chamado `ListarComponent` que exibe uma tabela utilizando o Material Design (Angular Material). O objetivo do componente é listar itens em uma tabela com funcionalidade de paginação e ordenação. Vamos analisar cada parte do código:

### 1. **Decorador `@Component`**

```tsx
@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.css',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, MatSortModule]
})

```

- **`selector: 'app-listar'`**: O `selector` define o nome da tag HTML usada para renderizar esse componente no template. Aqui, será `<app-listar></app-listar>`.
- **`templateUrl: './listar.component.html'`**: Define o caminho para o arquivo HTML que serve como o template do componente. Este arquivo contém a estrutura visual da tabela.
- **`styleUrl: './listar.component.css'`**: Define o caminho para o arquivo CSS que contém os estilos para o componente.
- **`standalone: true`**: Esse campo indica que o componente é autônomo, ou seja, não depende de um módulo externo para ser utilizado.
- **`imports: [MatTableModule, MatPaginatorModule, MatSortModule]`**: Importa os módulos do Angular Material necessários para a tabela (MatTableModule), paginação (MatPaginatorModule) e ordenação (MatSortModule). Esses módulos fornecem as funcionalidades de tabela avançada que são usadas no componente.

### 2. **Classe `ListarComponent`**

```tsx
export class ListarComponent implements AfterViewInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<ListarItem>;
  dataSource = new ListarDataSource();
  displayedColumns = ['id', 'name'];

```

- **`export class ListarComponent implements AfterViewInit`**: A classe `ListarComponent` implementa a interface `AfterViewInit`, o que significa que o código dentro do `ngAfterViewInit` será executado depois que a visualização (view) do componente for inicializada.
- **`@ViewChild(MatPaginator) paginator!`**: Utiliza o `@ViewChild` para acessar uma instância do componente `MatPaginator` do Angular Material, que será usado para controlar a paginação da tabela. O `!` é usado para indicar que a variável não será nula ou indefinida.
- **`@ViewChild(MatSort) sort!`**: Acessa o componente `MatSort` do Angular Material, que permite ordenar as colunas da tabela.
- **`@ViewChild(MatTable) table!`**: Acessa a tabela real, o componente `MatTable`, que exibirá os dados.
- **`dataSource = new ListarDataSource();`**: Cria uma instância de `ListarDataSource`, que é uma fonte de dados personalizada (não mostrada aqui, mas geralmente estende `DataSource` do Angular Material) que gerencia os dados a serem exibidos na tabela.
- **`displayedColumns = ['id', 'name'];`**: Define as colunas que serão exibidas na tabela, neste caso, as colunas 'id' e 'name'. Esse array será usado no template para definir as colunas da tabela.

### 3. **Método `ngAfterViewInit()`**

```tsx
ngAfterViewInit(): void {
  this.dataSource.sort = this.sort;
  this.dataSource.paginator = this.paginator;
  this.table.dataSource = this.dataSource;
}

```

- O método `ngAfterViewInit()` é chamado depois que o Angular inicializa a visualização (view) do componente. Aqui, ele configura a fonte de dados da tabela com as funcionalidades de ordenação e paginação:
    - **`this.dataSource.sort = this.sort;`**: Associa o controlador de ordenação (`MatSort`) à fonte de dados.
    - **`this.dataSource.paginator = this.paginator;`**: Associa o controlador de paginação (`MatPaginator`) à fonte de dados.
    - **`this.table.dataSource = this.dataSource;`**: Define a fonte de dados (`dataSource`) como a fonte de dados para a tabela. Isso faz com que a tabela exiba os itens definidos na `dataSource`.

### Resumo:

O código define um componente `ListarComponent` que exibe uma tabela com duas colunas (`id` e `name`). Ele utiliza os módulos `MatTableModule`, `MatPaginatorModule`, e `MatSortModule` do Angular Material para habilitar a tabela com funcionalidades de ordenação e paginação. O componente utiliza o `@ViewChild` para acessar os controles de paginação e ordenação e configura esses controles no método `ngAfterViewInit()`. A tabela é alimentada com os dados de uma fonte personalizada chamada `ListarDataSource`.