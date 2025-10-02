# 1 → SISTEMAS DE VERSIONAMENTO

🟢

Um **sistema de versionamento** (ou **controle de versão**) é uma ferramenta que **registra e gerencia as alterações feitas em arquivos ou projetos ao longo do tempo**.

👉 Resumidamente:

- Ele guarda o **histórico de mudanças**.
- Permite **voltar a versões anteriores**.
- Facilita o **trabalho em equipe**, já que várias pessoas podem editar o mesmo projeto sem perder nada.

### 🔹 Exemplos de sistemas de versionamento:

- **Git** (o mais usado hoje, distribuído).
- **SVN (Subversion)**.
- **Mercurial**.
- **CVS (Concurrent Versions System)** (mais antigo).

💡 Plataformas que usam esses sistemas: **GitHub, GitLab, Bitbucket** (todas baseadas em Git).


---

🏆 O versionamento consiste em manter o histórico do desenvolvimento para aquele software especifico.


🏆 O versionamento bem feito tem uma operação de devops no final que vai poder publicar e disponibilizar para o usuário aquele código e construção que foi feita ao decorrer do tempo


🏆 O sistema de versionamento pode ser da forma mais simples, até a forma mais robusta que é a do git(mais utilizada mundialmente)


🏆 Esse desenvolvimento de software que a gente faz para todas as aplicações precisa ser versionado por segurança, para que outra pessoa consiga trabalhar em cima dele, para que você mostre o incremento da evolução do seu código e do software que você está construindo.


---

### 3 TIPOS PRINCIPAIS DE VERSIONAMENTO

- LOCAL
- VERSÃO CENTRALIZADA
- VERSÃO DISTRIBUIDA

### LOCAL

🟢 Significa que ele vai estar somente na sua máquina e só você vai ter acesso.

> Esse é um dos piores tipos de versionamento, porque você acaba perdendo o controle do histórico de evolução do projeto.
> 

### VERSÃO CENTRALIZADA

🟢 Você vai ter um servidor central com todos os códigos originais e a partir dele você vai conseguir criar cópias para fazer essa evolução do código.

> é quase um sistema local, mas a base dele está em um servidor.
> 

### VERSÃO DISTRIBUIDA

> É o sistema de versionamento mais utilizado atualmente
> 

> A evolução do código vai ser fácil de ser baixada e clonada para qualquer tipo de dispositivo
> 

> Facilita o trabalho em equipe e você consegue guardar usuário, momento que foi enviado e as linhas que foram alteradas.
> 

🟢

É o caso do git. 

O **Git** é chamado de **sistema de versionamento distribuído** porque **cada desenvolvedor tem em seu computador uma cópia completa do repositório**, incluindo todo o histórico de versões.

👉 Isso significa:

- Não depende de um servidor central para funcionar.
- Você pode **criar branches, commits e acessar o histórico offline**.
- Depois, sincroniza (push/pull) com repositórios remotos como GitHub, GitLab ou Bitbucket.

Resumindo: no Git, **todo mundo tem o repositório inteiro**, não apenas a parte em que está trabalhando — por isso é **distribuído**.
