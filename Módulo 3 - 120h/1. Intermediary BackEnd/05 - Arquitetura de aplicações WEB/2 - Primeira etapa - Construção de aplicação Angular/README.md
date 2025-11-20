# 2 → PRIMEIRA ETAPA: CONSTRUÇÃO DE APLICAÇÃO ANGULAR

🏆 Vamos rodar o comando:

```jsx
npm i 
```

> Vai baixar as informações necessárias e a pasta node modules
> 

---

🏆 Vamos ter uma aplicação e os componentes que simulam uma escola.

---

### DIFERENÇA DOS COMANDOS `NG BUILD` E `NG SERVE`

# **1. `ng serve`**

### ✔ Para desenvolvimento

- Compila o projeto **em memória**.
- Sobe um servidor local para você testar o sistema.
- Atualiza automaticamente quando você salva um arquivo (**live reload**).
- Não gera arquivos físicos na pasta `dist/`.

### 🟢 Comando:

```
ng serve

```

### 🟢 Resultado:

- O app roda em `http://localhost:4200/`.

---

# **2. `ng build`**

### ✔ Para gerar a versão final do projeto (produção)

- Compila o projeto e cria os arquivos otimizados.
- Gera a pasta **`dist/`** com HTML, JS, CSS, imagens minificadas etc.
- Essa versão é a que você envia para o servidor (deploy).

### 🟢 Comando:

```
ng build

```

### 🟣 Para produção mesmo:

```
ng build --configuration production

```

Isso produz arquivos bem menores, otimizados e sem ferramentas de debug.

---

# 📌 **Resumo direto**

| Comando | Usado para | O que faz |
| --- | --- | --- |
| **ng serve** | Desenvolvimento | Roda o app no navegador, recompila automaticamente |
| **ng build** | Deploy / produção | Gera os arquivos finais na pasta `dist/` |

---

### VAMOS INICIAR A GERAÇÃO DOS COMPONENTES DO ANGULAR

- COMPONENTE DE COURSE
- EVALUATION