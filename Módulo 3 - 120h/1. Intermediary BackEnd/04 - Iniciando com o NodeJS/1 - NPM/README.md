# 1 → NPM

🏆 O NPM(node package manager) é o gerenciador de pacotes do node, ele vai ser o nosso aliado durante quase todo tempo.

NPM <SUBCOMANDO>

> Na frente desse subcomando é possível utilizar o - - help para obter explicações sobre ele.
> 

🏆 Os principais comandos que vamos utilizar são:

Resumidamente:

- **`npm init`**
    - Cria o arquivo **`package.json`** no seu projeto.
    - Esse arquivo guarda as informações do projeto (nome, versão, autor) e as dependências (bibliotecas que você instalar).
    - É como a "identidade" do seu projeto Node.js.
- **`npm install <pacote>`**
    - Baixa e instala um pacote/biblioteca do **npm (Node Package Manager)**.
    - Exemplo: `npm install express` → instala o Express e adiciona no `package.json`.
    - Se rodar só `npm install` (sem nome), ele instala todas as dependências listadas no `package.json`.

👉 Em resumo:

- `npm init` → cria o **projeto Node**.
- `npm install` → instala **bibliotecas** para usar no projeto.

---

### VAMOS APRENDER ALGUMAS PRÁTICAS BÁSICAS DE MÓDULOS DE INTERAÇÃO E REQUISIÇÃO

🔒 Para isso vamos criar uma pasta chamada “hello-npm”

🔒 Para essa pasta ser um repositório que é administrado pelo NPM, vamos ter que acessa-la e rodar o comando `npm init`

🔒 Após eu executar esse comando, é solicitada algumas informações que vão fazer parte do package json(arquivo de configuração do projeto npm), esse arquivo de configuração vai abraçar todas as dependências do seu projeto.

> Caso você não coloque nenhum nome, será adicionado o nome defaut que está entre parênteses.
> 


---

### EXISTE 3 TIPOS DE MÓDULOS DO NODE

1. **Módulos Nativos (Core Modules)**
    - Já vêm embutidos no Node.js.
    - Não precisam ser instalados.
    - Exemplo: `fs` (arquivos), `http` (servidor), `path` (caminhos de diretórios).
2. **Módulos de Terceiros**
    - Criados pela comunidade e instalados via **npm**.
    - Exemplo: `express`, `mongoose`, `lodash`.
3. **Módulos Locais (ou personalizados)**
    - Criados pelo próprio desenvolvedor dentro do projeto.
    - Você os exporta com `module.exports` e importa com `require('./meuModulo')`.

👉 Resumindo:

- **Nativos** → já vêm no Node.
- **Terceiros** → você baixa com `npm`.
- **Locais** → você mesmo cria.