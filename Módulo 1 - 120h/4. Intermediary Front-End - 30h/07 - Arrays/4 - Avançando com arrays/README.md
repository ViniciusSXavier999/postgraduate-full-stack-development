## MÉTODO SPLICE

🏆 O nome dessa função é bem parecido com **slice()**. Essa similaridade de nomes algumas vezes confundem os desenvolvedores. O método splice() altera o array, seja adicionando ou removendo elementos dele.

Vamos ver como fazer essas operações com esse método:

`array.splice(índice, número de elementos);` (número de elementos que eu quero tirar a partir daquele índice)


🏆 O índice é o ponto de início para a remoção dos elementos. Elementos que tem um número de índice menor que o índice fornecido não serão removidos

`array.splicce(2); // Todos os elementos a partir do índice 2 serão removidos` 

> Se eu não coloco a quantidade para ser removido, ele pega do 2 e arranca todo mundo
> 

> O SPLICE() DA UM CORTE NO ARRAY
> 

🏆 Se não definirmos o segundo parâmetros, todos os elementos começando do índice informado serão removidos do array


🏆 Como um segundo exemplo, se eu passar o segundo parâmetro como 1, o elemento que está no índice 2 será removido após a execução do splice() for executada:

`array.splice(2, 1);`

 <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/avan%C3%A7andoComArray1.png" />

 <img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/avan%C3%A7andoComArray2.png" />


---