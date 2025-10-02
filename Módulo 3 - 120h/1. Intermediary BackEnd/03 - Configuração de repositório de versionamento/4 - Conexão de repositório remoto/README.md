# 4 → CONEXÃO DE REPOSITÓRIO REMOTO

🏆 Vou criar um repositório que será o responsável por armazenar os códigos dessa disciplina.


> Nessa aula vamos aprender a conectar ao repositório remoto.
> 

### EXISTE 3 TIPOS POSSÍVEIS DE CONEXÃO COM O REPOSITÓRIO REMOTO

- HTTPS
- SSH(CHAVE)
- GITHUB CLI (GERALMENTE É UTILIZADO PARA APLICATIVOS COMO GITHUB DESKTOP)

---

### README.MD O QUE É?

🏆 É uma breve descrição do seu projeto e o que ele faz


### .GITIGNORE O QUE É?

🏆 São os arquivos que serão ignorados na hora de fazer o push para o repositório remoto


---

## REALIZANDO A CONEXÃO COM O REPOSITÓRIO REMOTO POR MEIO DA LINHA DE COMANDO

### COMANDO 1

> Inicializa um novo repositório Git na pasta local.
> 

🏆

```bash
git init
```


### COMANDO 2

> Adiciona o arquivo `readme.md` à área de *staging* (prepara para o commit).
> 

🏆

```bash
git add readme.md
```


### COMANDO 3

> Cria um *commit* com as mudanças adicionadas, registrando no histórico.
> 

🏆

```bash
git commit -m "mensagem"
```


### COMANDO 4

> Renomeia a branch atual para `main` (padrão usado no GitHub hoje).
> 

🏆

```bash
git branch -M main
```


### COMANDO 5

> Conecta o repositório local ao remoto, chamando esse remoto de **origin**.
> 

🏆

```bash
git remote add origin <url>
```


### COMANDO 6

> Envia (faz *push*) a branch `main` local para o repositório remoto `origin`.
> 

🏆

```bash
git push origin main
```

✅ Em resumo: você cria o repositório, prepara os arquivos, registra as mudanças, aponta para o repositório remoto e manda o código para lá.


---