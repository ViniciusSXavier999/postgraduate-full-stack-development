# 2 → FLUXO E COMANDOS DO GIT

🏆 GIT FLOW → FLUXO DE DESENVOLVIMENTO.

🏆 O git não armazena códigos gigantescos de cada versão que você esta trabalhando, ele armazena uma série de mudanças em snapshots(basicamente é uma foto daquele momento que você está), cada snapshot é um commit que você fez enviando uma alteração local do seu repositório para o remoto.


---

### COMANDO PARA ENVIAR COMMITS

```bash
git commit ""
```

---

🏆 Nós como desenvolvedores precisamos entender como é esse fluxo e como a gente trabalha nele.


---

### ENTENDENDO O GIT FLOW

# ✅ **O que é Git Flow (resumo claro)**

**Git Flow é um modelo de organização de branches no Git** que define como o time deve criar, testar e liberar novas versões do projeto.

Ele cria **regras** para como o código flui dentro do repositório.

---

# 🔧 **Como funciona (resumo em 5 branches principais)**

### 1️⃣ **main**

Contém o código **estável**, pronto para produção.

### 2️⃣ **develop**

Branch onde o desenvolvimento acontece antes de ir para produção.

É como a "versão beta" do projeto.

### 3️⃣ **feature/**

Para criar novas funcionalidades.

Exemplo:

`feature/login`

`feature/cadastro-professor`

### 4️⃣ **release/**

Criada quando o sistema está quase pronto para lançar uma nova versão.

Ex.:

`release/1.2.0`

### 5️⃣ **hotfix/**

Para corrigir bugs **urgentes** na produção.

Ex.:

`hotfix/corrige-bug-login`

---

# 📌 **Por que usar Git Flow? (bem resumido)**

- evita bagunça no código
- separa funcionalidades em desenvolvimento
- permite lançar versões organizadas
- facilita trabalhar em equipe
- ajuda a corrigir bugs sem interromper o desenvolvimento

---

# 🧠 Resumo em 1 frase

**Git Flow é um modelo de organização de branches que mantém o desenvolvimento estruturado, limpo e seguro.**

🏆 Pode ser usado de forma manual ou com a ferramenta.


---

### EXPLICANDO O FUNCIONAMENTO DO GIT FLOW

Quando você executa **`git flow init`**, o Git Flow **configura automaticamente** a estrutura de branches padrão dentro do seu repositório.

Aqui está o que acontece **de forma clara e resumida**:

---

# ✅ **O que acontece ao rodar `git flow init`**

### 1️⃣ **Ele cria a estrutura padrão de branches do Git Flow**

- `main` (ou `master`) → código de produção
- `develop` → código em desenvolvimento

Se essas branches não existirem, ele **cria**.

---

### 2️⃣ **Ele pergunta quais nomes você quer usar para as branches**

Você verá perguntas como:

```
Branch name for production releases: [] main
Branch name for "next release" development: [] develop

```

Normalmente só aperta ENTER para aceitar o padrão.

---

### 3️⃣ **Ele define os prefixos das branches especiais**

Como:

```
Feature branches? [] feature/
Release branches? [] release/
Hotfix branches? [] hotfix/
Support branches? [] support/
Version tag prefix? []

```

Isso significa que, quando você iniciar algo como:

```
git flow feature start login

```

Ele criará uma branch:

```
feature/login

```

---

### 4️⃣ **Ele salva essas configurações no repositório**

Tudo fica guardado em:

```
.git/config

```

Assim, o Git Flow sabe como criar e finalizar branches automaticamente.

---

# 📌 **Resumo simples**

Rodar **`git flow init`**:

✔ inicializa o Git Flow no repositório

✔ cria a branch `develop` caso não exista

✔ define os prefixos: `feature/`, `release/`, `hotfix/`

✔ organiza o fluxo de desenvolvimento

---

# 📌 Em 1 frase:

**`git flow init` prepara seu projeto para usar o fluxo Git Flow, criando a estrutura e regras de branches automaticamente.**