# 4 → REFATORAÇÃO AUTOMATIZADA

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/refatora%C3%A7%C3%A3oAutomatizada1.png" />

> Vamos imaginar que é necessário alterar o nome de um objeto/variável ou da classe para um nome que seja mais adequado com o processo que está sendo executado, dessa maneira nós conseguimos localizar os locais que utilizamos aquele termo, e substituir.
> 

---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/refatora%C3%A7%C3%A3oAutomatizada2.png" />

> A refatoração é a possibilidade de debugar o código, vasculhar e identificar todas as ações que foram desenvolvidas e implementadas, dessa maneira conseguimos estruturar, dessa forma a gente consegue avaliar o nosso código e corrigir de forma sistematizada.
> 

---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/refatora%C3%A7%C3%A3oAutomatizada3.png" />

> A refatoração também está atrelada com a compreensão do código pelos programadores, por isso nós podemos renomear métodos para torna-los mais claros.
> 

---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/refatora%C3%A7%C3%A3oAutomatizada4.png" />



### O QUE É ARVORE SINTÁTICA NA PROGRAMAÇÃO? 🏆

Em **programação**, uma **árvore sintática** (ou **árvore de análise sintática**, do inglês *syntax tree* ou *parse tree*) é uma **estrutura em árvore** que representa a **estrutura gramatical de um código-fonte** segundo as regras da linguagem de programação.

---

### 📌 Para que serve?

Ela é usada por **compiladores e interpretadores** para entender o que o código está fazendo. A árvore mostra **como as partes do código se organizam** e como se relacionam de acordo com a **gramática da linguagem**.

---

## 🌳 Exemplo simples (expressão matemática)

Código:

```c
3 + 4 * 5

```

A árvore sintática (considerando a precedência dos operadores) seria:

```
       +
      / \
     3   *
        / \
       4   5

```

- O  tem precedência maior, então é avaliado antes de `+`.
- A árvore deixa isso claro de forma hierárquica.

---

## 🧠 Tipos de árvore:

### 1. **Árvore de Derivação (Parse Tree)**

Mostra **toda a aplicação das regras gramaticais**, incluindo não-terminais e terminais. Mais detalhada.

### 2. **Árvore Sintática Abstrata (AST - Abstract Syntax Tree)**

Mais simplificada. Remove detalhes desnecessários (como parênteses, vírgulas, palavras-chave supérfluas) e foca só na **estrutura lógica** do código.

Exemplo de AST para:

```python
x = 3 + 4

```

A AST pode ser:

```
    =
   / \
  x   +
     / \
    3   4

```

---

## ⚙️ Usos práticos:

- **Compilação** (gerar código de máquina ou bytecode)
- **Interpretação** (executar diretamente o código)
- **Análise estática** (verificar erros ou más práticas)
- **Refatoração automática** (como IDEs fazem)

---


> Pode se dizer que as IDEs são algo mais pessoal, podemos escolher a que mais nos identificarmos.
> 

---

## REFATORANDO USANDO ECLIPSE

> Vamos utilizar durante as aulas para exemplos simples de refatoração.
> 

🏆 O assistente de refatoração do Eclipse facilita o trabalho ao detectar automaticamente todas as dependências da classe que está sendo renomeada e também modificá-las. 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/refatora%C3%A7%C3%A3oAutomatizada5.png" />

> Ao realizar a mudança de nomenclatura da classe, isso ocorrerá em todas outras partes do código que usava esse nome que alteramos, tudo será atualizado automaticamente, essa é uma grande vantagem das IDEs.
> 

### RENOMEANDO VARIÁVEIS E MÉTODOS USANDO ECLIPSE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/refatora%C3%A7%C3%A3oAutomatizada6.png" />

> Após renomear, todas as instancias e locais que a gente tem todas essas determinadas chamadas, vão ser atualizados.
> 

### RENOMEANDO PACOTES

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/refatora%C3%A7%C3%A3oAutomatizada7.png" />