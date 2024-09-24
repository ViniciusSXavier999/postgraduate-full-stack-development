# IF, SWITCH, FOR, WHILE

## CONTROLE DE FLUXO

🏆 IF… ELSE

- Estrutura condicional que executa a afirmação, dentro do bloco, se determinada condição for verdadeira. Se for falsa, executa as afirmações dentro de else.
- Sintaxe

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/controledefluxo1.png" />

Condição: expressão (premissa) que pode ser avaliada como verdadeira (true) ou falsa (false), veja lógica de programação para entender melhor.

- afirmação1: Condicional que será executada caso a condição em if seja verdadeira (true).

Pode ser qualquer instrução, incluindo mais condicionais if aninhadas à instrução. Para executar múltiplas instruções, faça um agrupamento com uma instrução vazia (empty).

- afirmação2: Condicional que será executada caso a condição em if seja avaliada como falsa (false) e a condição else exista. Pode ser qualquer instrução, incluindo instruções em bloco e mais condicionais if aninhadas.

> Se a condição não for verdadeira, o else será executado
> 

### Múltiplas condicionais


🏆 Múltiplas condicionais if…else podem ser aninhadas quando necessário.

Observe que não existe elseif(em uma palavra). O correto é a instrução com espaços (else if), conforme abaixo: 

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/controledefluxo2.png" />

Para executar múltiplas instruções dentro de uma condição, utilize um bloco ({…}). Em geral, é sempre uma boa prática utilizar instruções dentro de blocos, especialmente em códigos que envolvem condicionais if aninhadas.

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/controledefluxo3.png" />

### Exemplos usando IF…ELSE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/controledefluxo4.png" />

> Nesse caso se x for maior que 10, eu vou atribuir + 10 para variável result que pode estar fora do escopo
> 

### Exemplo usando else if

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/controledefluxo5.png" />

Perceba que não existe sintaxe de elseif em JavaScript. Entretanto, você pode escrevê-la com um espaço entre o if e o else

> Nesse caso se nenhuma das duas condições forem verdadeiras, será executado o bloco do else.
> 
