# 2 → GIT E GIT BASH

🏆 O git é um sistema de controle de versões, utilizado na maioria das empresas.

🏆 Com o git é possível registrar as versões do seu código na sua máquina, esse registro além de ficar feito na máquina, vai ser enviado para um servidor remoto, dessa forma você pode acessar ele em outras máquinas e também disponibilizar para outros desenvolvedores contribuir para o seu código.


---

## GIT X GIT BASH

🏆

---

### 🔹 **Git**

- É um **sistema de controle de versão**.
- Permite **salvar o histórico** de alterações do código, **voltar versões**, **trabalhar em equipe** com *branches* e **sincronizar com repositórios remotos** (ex: GitHub, GitLab).
- É a **ferramenta principal** para versionar projetos.

---

### 🔹 **Git Bash**

- É um **terminal (shell)** que vem junto com a instalação do Git no Windows.
- Permite usar **comandos do Git** e também vários comandos do Linux/Unix no Windows (como `ls`, `pwd`, `touch`).
- Ou seja: é um **ambiente de linha de comando** para interagir com o Git e com o sistema.

---

### ✅ Diferença principal

- **Git** → a **ferramenta** de versionamento.
- **Git Bash** → o **terminal** que você usa para rodar os comandos do Git (e outros comandos estilo Linux) no Windows.

---


### CURIOSIDADE

🏆 O nome **Bash** vem de **“Bourne Again SHell”**:

- É um **trocadilho** com o nome do shell antigo chamado **Bourne Shell (sh)**, criado por **Stephen Bourne**.
- “Bourne Again” brinca com a ideia de ser uma **nova versão do Bourne Shell**.

Então não é exatamente o sobrenome do engenheiro sozinho, mas **uma homenagem + trocadilho**.


### SITE PARA DOWNLOAD DO GIT

🏆 [Git - Downloads](https://git-scm.com/downloads)


### PARA VERIFICAR A VERSÃO DO GIT NA MÁQUINA

🏆 Abrir o cmd e digitar 

```bash
git --version
```


### O QUE É A CHAVE SEGURA NO GIT?

🏆

---

### 🔹 **O que é a chave SSH do Git**

- **SSH (Secure Shell)** é um protocolo que permite **conexão segura entre seu computador e um servidor**.
- A **chave SSH** é um par de arquivos:
    1. **Chave privada** → fica **no seu computador** (não pode ser compartilhada).
    2. **Chave pública** → você adiciona no **GitHub, GitLab ou outro servidor Git**.

---

### 🔹 Para que serve no Git

- Permite **autenticar seu computador** com o servidor Git sem precisar digitar usuário e senha toda hora.
- Garante que apenas você (ou computadores autorizados) possam **enviar ou puxar código**.

---

### 🔹 Como funciona resumidamente

1. Você gera o par de chaves no seu PC.
2. Adiciona a **chave pública** no GitHub/GitLab.
3. Quando você fizer `git push` ou `git pull`, o servidor verifica se sua **chave privada** bate com a pública.
4. Se bater → conexão autorizada, sem precisar digitar senha.

---

👉 Em resumo:

**A chave SSH é como uma “identidade segura” do seu computador para o Git**, permitindo enviar e receber código de forma prática e segura.

### O QUE ACONTECE SE NÃO UTILIZAR A CHAVE SEGURA?

🏆

---

### 🔹 O que muda nos seus repositórios já criados?

1. **Se você já usa HTTPS (`https://...`)**
    - Nada muda imediatamente.
    - Você ainda pode continuar dando `git pull` / `git push` usando usuário + senha/token.
    - Se quiser usar SSH, precisa mudar a URL do repositório para o formato `git@github.com:usuario/repositorio.git`.

---

1. **Se você passar a usar SSH (`git@...`)**
    - Você não vai mais precisar digitar usuário e senha/token toda vez.
    - O Git vai autenticar usando sua chave SSH automaticamente.
    - Então, o único impacto é **mais praticidade e segurança**.

---

### 🔹 Como mudar um repositório existente de HTTPS para SSH

Dentro da pasta do repositório, rode:

```bash
git remote -v

```

Isso mostra a URL atual (provavelmente `https://...`).

Para trocar para SSH:

```bash
git remote set-url origin git@github.com:SEU-USUARIO/NOME-REPO.git

```

Depois confira novamente:

```bash
git remote -v

```

Agora deve aparecer a URL no formato SSH.

---

👉 **Resumindo**:

- Seus repositórios já criados **não quebram**.
- Se quiser usar SSH, só precisa trocar a URL de cada um (uma vez).
- Depois disso, seus `push` e `pull` vão rodar sem pedir senha.

---
