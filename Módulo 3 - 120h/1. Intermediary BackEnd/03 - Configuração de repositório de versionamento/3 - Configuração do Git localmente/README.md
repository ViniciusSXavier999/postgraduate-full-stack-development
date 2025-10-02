# 3 → CONFIGURAÇÃO DO GIT LOCALMENTE


💡 Para usar o sistema de versionamento distribuído você precisa ter uma máquina configurada localmente. 

---

### COMANDO QUE MOSTRA UMA LISTA DE CONFIGURAÇÕES IMPORTANTES

```bash
git config --list
```

### MOSTRA QUE O GIT ESTA CONFIGURADO LOCALMENTE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/configGitLocalmente.png" />

---

💡 Caso você opte por mais segurança, é necessário a criação de uma chave SSH

🏆 As **chaves SSH no Git** servem para criar uma **conexão segura** entre o seu computador e o servidor remoto (como GitHub, GitLab, Bitbucket), sem precisar digitar usuário e senha toda hora.

👉 Resumidamente:

- **SSH** (Secure Shell) usa um par de chaves:
    - **Chave privada** → fica no seu computador.
    - **Chave pública** → você cadastra no GitHub/GitLab/etc.
- Quando você faz um **git push, pull ou clone**, o servidor confere se a sua chave privada corresponde à pública cadastrada.
- Isso garante **autenticação segura e prática**.

💡 Vantagem: mais segurança que senha simples e evita ter que digitar credenciais em cada operação.

