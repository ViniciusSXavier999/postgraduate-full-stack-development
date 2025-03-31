# 2 → INTRODUÇÃO AO PADRÃO MVC

## MVC

🏆 É P ACRÔNIMO DE MODEL-VIEW-CONTROLLER, UM PADRÃO DE PROJETO DE SOFTWARE DESENVOLVIDO NO FINAL DA DÉCADA DE 70 POR TRYGVE REENSKAUG


🏆 FOI INTRODUZIDO PELA PRIMEIRA VEZ EM 1987 NA LINGUAGEM DE PROGRAMAÇÃO SMALLTALK E ACEITO COMO UM PADRÃO EM 1988.


---

## QUAL O OBJETIVO DO PADRÃO MVC?

🏆 O objetivo era resolver o problema de usuários controlando um conjunto de dados grandes e complexo

> Antes do padrão MVC os códigos eram muito bagunçados e muito difícil de entender.
> 

🏆 Como o padrão MVC foi criado antes dos navegadores da web, inicialmente foi projetado para interfaces gráficas de usuário (GUI) e atualmente é um padrão na maioria dos Frameworks de desenvolvimento.


🏆 Por ser um padrão arquitetural, significa que ele rege toda a arquitetura das aplicações.

Um **padrão arquitetural** é uma abordagem ou um modelo estrutural que define como os componentes de um sistema de software devem ser organizados e interagir entre si. Ele oferece diretrizes gerais sobre como construir, estruturar e organizar os diferentes elementos de um sistema de software para atender a requisitos como escalabilidade, manutenção, flexibilidade e desempenho. Esses padrões ajudam a promover boas práticas e uma estrutura reutilizável que pode ser aplicada em vários projetos.

### Exemplo de Padrão Arquitetural: **MVC (Model-View-Controller)**

O **MVC** é um dos padrões arquiteturais mais populares, especialmente em aplicações web e desktop. Ele divide a aplicação em três componentes principais:

### 1. **Model (Modelo)**

- **Responsabilidade**: O **Model** lida com a lógica de negócios e o gerenciamento de dados. Ele é responsável por acessar os dados, processá-los e fornecer informações ao **View** ou armazená-las.
- **Exemplo**: Em um sistema bancário, o **Model** pode ser a classe `ContaBancaria`, que lida com o saldo da conta e a realização de transações.

### 2. **View (Visão)**

- **Responsabilidade**: A **View** é responsável pela apresentação dos dados ao usuário. Ela exibe as informações que o **Model** fornece e reage às interações do usuário.
- **Exemplo**: A **View** pode ser a interface gráfica que exibe o saldo da conta bancária ou uma página HTML que mostra os dados em uma aplicação web.

### 3. **Controller (Controlador)**

- **Responsabilidade**: O **Controller** é o intermediário entre o **Model** e a **View**. Ele processa as entradas do usuário (como cliques e teclas digitadas), manipula o **Model** de acordo com as ações do usuário e atualiza a **View** conforme necessário.
- **Exemplo**: Em um sistema bancário, o **Controller** pode ser responsável por processar a solicitação de um usuário para transferir dinheiro, chamando métodos no **Model** para atualizar o saldo da conta e depois atualizar a **View** para refletir a nova informação.

### Fluxo de Trabalho no MVC:

1. O **usuário** interage com a **View** (interface do usuário).
2. A **View** envia a solicitação para o **Controller** (por exemplo, quando um botão é pressionado).
3. O **Controller** processa a solicitação e interage com o **Model** para realizar operações (como recuperar ou atualizar dados).
4. O **Model** executa a lógica de negócios e retorna os dados ou o status da operação ao **Controller**.
5. O **Controller** então atualiza a **View**, mostrando os dados mais recentes ou os resultados da operação para o usuário.

### Vantagens do Padrão **MVC**:

- **Separação de responsabilidades**: Cada parte (Model, View e Controller) tem responsabilidades bem definidas, o que facilita a manutenção e o entendimento do código.
- **Reusabilidade**: Como a lógica de negócios (Model) é separada da apresentação (View), é mais fácil reutilizar componentes em diferentes partes da aplicação.
- **Facilidade de testes**: Como as responsabilidades são bem divididas, torna-se mais fácil testar cada parte de forma independente.
- **Escalabilidade**: O padrão facilita o crescimento do sistema, pois você pode adicionar novas funcionalidades (por exemplo, uma nova forma de exibição dos dados) sem afetar a lógica de negócios.

### Outros Exemplos de Padrões Arquiteturais:

Além do **MVC**, existem muitos outros padrões arquiteturais que podem ser aplicados dependendo do tipo de aplicação e dos requisitos do sistema:

1. **MVVM (Model-View-ViewModel)**: Similar ao MVC, mas com um foco maior na separação entre a camada de apresentação (View) e a lógica de apresentação (ViewModel).
2. **MVP (Model-View-Presenter)**: Também semelhante ao MVC, mas aqui o Presenter toma o lugar do Controller e é responsável por interagir diretamente com a View e o Model.
3. **Arquitetura em Camadas (Layered Architecture)**: Divide o sistema em camadas, como camadas de apresentação, lógica de negócios e acesso a dados, para isolar responsabilidades e facilitar a manutenção.
4. **Microservices Architecture**: Em vez de uma única aplicação monolítica, um sistema é dividido em pequenos serviços independentes, cada um responsável por um conjunto específico de funcionalidades.
5. **Event-Driven Architecture**: O sistema é composto por componentes que comunicam uns com os outros através de eventos. Ideal para sistemas altamente distribuídos e escaláveis.

### Conclusão:

Um **padrão arquitetural** como o **MVC** é uma maneira de organizar e estruturar a aplicação de forma eficiente, garantindo que ela seja mais fácil de manter, entender e expandir. Padrões arquiteturais ajudam a resolver problemas comuns de design de software e são essenciais para garantir a qualidade e a escalabilidade de sistemas complexos.

🏆 Com uma arquitetura em camadas, cada uma delas tem responsabilidades especificas.

---

## ENTENDENDO COMO FUNCIONA CADA PARTE DO PADRÃO MVC

🏆 A arquitetura MVC separa a interface do usuário da lógica de negócios e também de dados, permitindo que o aplicativo seja escalável, de fácil manutenção, com componentes independentes e fácil de expandir.

💡 A parte de VIEW é responsabilidade do FRONT-END.

💡 Vamos utilizar bastante o controller que é a porta de entrada da nossa aplicação


💡 E o model que é o responsável por toda a lógica do negócio, o model é responsável pela parte das entidades, gerenciamento de dados, salvamento de dados, consultado de dados.



🏆 Por outro lado, o padrão MVC de forma geral possui uma alta complexidade, não sendo adequado para pequenas aplicações.

---

## FLUXOGRAMA PADRÃO MVC

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/padr%C3%A3oMVC1.png" />

### EXEMPLO DE PADRÃO MVC: UM RESTAURANTE

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/padr%C3%A3oMVC2.png" />

- Nós temos o cliente que tem acesso ao CARDAPIO que é a VIEW
- O cliente vai solicitar algum item no cardápio, e esse pedido necessita chegar de alguma forma na cozinha.
- Para esse pedido chegar até a cozinha precisamos de outra pessoa, que se trata do garçom, ele faz o papel do controller.
- O controller tem o papel de pegar o pedido do cliente, levar até a cozinha e quando o pedido estiver pronto ele leva para o cliente novamente.