# CRIAÇÃO DE SUBCOMPONENTES E A TRANSMISSÃO DE INFORMAÇÃO

> Agora vamos passar a informação de um componente para o outro (componente pai que é o home para o componente filho que é o header)
> 

---

🏆 Conceitos importantes do Angular:

- Angular core
    - O Angular core **é o módulo central do framework Angular, que fornece recursos essenciais para a construção de aplicações**. O core do Angular é como o "coração" do framework, pois é o script que importa todo o código do Angular para prover os recursos necessários.

- Input do angular core
    - A [**`input`**](https://angular.dev/api/core/input)função permite a declaração de entradas Angular em diretivas e componentes.
    
    Existem duas variantes de entradas que podem ser declaradas:
    
    1. **Entradas opcionais**
        
        com um valor inicial.
        
    2. **Entradas necessárias**
        
        que os consumidores precisam definir.
        
- Data binding
    - Data binding no Angular **é uma técnica que sincroniza automaticamente dados entre os modelos e os componentes da view**. Isso permite unir várias fontes de dados sem a necessidade de alterar os elementos do DOM manualmente

    
- NgOnInit
    - O ngOnInit **é uma interface do Angular que executa ações de inicialização quando um componente é criado**. Ele faz parte do ciclo de vida de um componente Angular e é carregado após a inicialização do construtor

---

---

> Eu poderia ter 2 sub componentes no home, o header e o footer
> 

> Lembrando que o HOME é o componente PAI
> 

> Caso eu queira que uma informação seja mandada do header para o footer → Eu vou criar uma função no HOME que vai pegar essa informação, o header vai alterar esse dado no HOME e vai alterar no footer, da para fazer diversas coisas, compartilhar funções e variáveis
>