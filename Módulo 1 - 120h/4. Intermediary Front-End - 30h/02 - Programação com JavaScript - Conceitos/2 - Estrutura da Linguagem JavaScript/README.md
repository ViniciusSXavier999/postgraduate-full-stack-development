# ESTRUTURA DA LINGUAGEM JAVASCRIPT

## SINTAXE DE COMANDOS EM JAVASCRIPT

- JavaScript é case-sensitive ou seja, Maiúscula é diferente de Minúscula
- Espaços, tabulação e uma nova linha são considerados espaços em branco.
- O código fonte dos scripts em JavaScript são lidos da esquerda para a direita e são convertidos em uma sequência de elementos de entrada
- Recomenda-se sempre adicionar ponto e vírgula no final de suas declarações
- Escolha nomes coerentes para seu sistema (var Nome = “Maria”)

---

## Comentários

- São usados para inserir dicas, notas, sugestões ou alertas no código JavaScript.
- Torna mais fácil ler ou entender o que o código faz.
- Também pode ser usado para desabilitar código, evitando sua execução

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/comentariosjavascript.png" />

---

## Declaração de variáveis

### TIPOS

- var: declara uma variável e a inicializa com um valor
- let: declara uma variável local, escopo do bloco, a inicialização do valor é opcional
- const: declara uma variável de escopo do bloco, não pode ter seu valor alterado.

 <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/declara%C3%A7%C3%A3ovar.png" />


Explicação detalhada 👇🏻

[Tipos variáveis](https://cursos.alura.com.br/forum/topico-diferencas-const-let-e-var-200251#:~:text=Ol%C3%A1%2C%20Vitor%2C%20as%20principais%20diferen%C3%A7as,n%C3%A3o%20podem%20ser%20declaradas%20novamente).

---

## Identificadores de variáveis

### Regra para identificadores de variáveis

- Podem conter somente caracteres alfanuméricos (ou “$” ou “_“)
- Não podem iniciar com um dígito
- É “case sensitive”, Estado_origem é diferente de estado_origem.

### Exemplos válidos:

- Nome_funcionario
- Salario
- $Cidade

---

## Variável global e Variável local

### Variável Global

- Declarada fora de uma função
- Disponível para todos os blocos

### Variável Local

- Declarada dentro de uma função
- Disponível apenas para a função onde foi declarada
    
   <img width="500" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/globalelocal.png" />
    

### Variável Constante

- Para declarar usa a palavra chave “const”
- Não pode ter seu valor alterado
- A sintaxe de um identificador de uma constante é semelhante ao identificador de uma variável
- Não pode alterar seu valor por meio de uma atribuição ou ser declarada novamente enquanto o script está em execução
- Deve ser inicializada com um valor

    <img width="500" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/constante.png" />
