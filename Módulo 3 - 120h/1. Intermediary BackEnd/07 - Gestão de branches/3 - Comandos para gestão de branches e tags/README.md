# 3 → COMANDOS PARA GESTÃO DE BRANCHES E TAGS

🏆 Vamos entender um pouco mais sobre quais os estados possíveis no seu versionamento de código para os arquivos que você esta trabalhando.


### VISUALIZA QUAL É A SITUAÇÃO ATUAL DOS ARQUIVOS

```bash
git status
```

### COMANDO USADO PARA ALTERAR O COMMIT MAIS RECENTE

```bash
git commit --amend
```

🏆

**Resumo do `git commit --amend`:**

> Serve para editar o último commit, permitindo corrigir a mensagem ou adicionar/remover arquivos antes de enviar para o repositório remoto.
> 

Use quando:

- quiser **corrigir a mensagem** do commit;
- **adicionar arquivos esquecidos** no último commit;
- **ajustar pequenos erros** antes do push.

⚠️ **Não use em commits já enviados (push)** para evitar conflitos.


### LISTA TODAS AS BRANCHES QUE VOCÊ TEM

```bash
git branch
```

### LISTA TODAS AS BRANCHES QUE JÁ FORAM TOTALMENTE MESCLADAS(MERGED) NA BRANCH ATUAL

```bash
git branch --merged
```

### LISTA BRANCHES QUE AINDA NÃO FORAM MERGEADAS NA BRANCH ATUAL.

```bash
git branch --no-merged
```

---

### BRANCHES NO MERCADO DE TRABALHO

🏆 Precisamos saber o fluxo que vamos seguir


> Precisamos entender juntamente com o time quando essas branches vão ser combinadas com a branch principal, para que você evite trabalhar uma coisa que já foi feita, ou fazer um conflito com algo que já esta sendo trabalhado
>