# 3 → INTRODUÇÃO À API RESTFUL E SPRING BOOT

🏆 Interface de Programação de Aplicações baseada em Transferência de Estado Representacional


## O QUE É UMA API?

🏆 API - APPLICATION PROGRAMMING INTERFACE: É um conjunto de instruções e padrões que possam ser consumidos por uma aplicação, em muitos casos, sem conhecer detalhes sobre sua implementação. Permite a comunicação entre aplicações.


✅

### DE FORMA RESUMIDA:

PERMITE A COMUNICAÇÃO ENTRE APLICAÇÕES


## REST

🏆 Representational State Transfer: é um estilo de arquitetura, consiste em princípios, regras, restrições que, quando seguidas, permitem a criação de um projeto com interfaces bem definidas.

✅ REST → USA SOLICITAÇÕES HTTP PARA ACESSAR E USAR DADOS



## RESTFUL

🏆 Podemos definir como a capacidade de determinada API aplicar os princípios de REST

> Quando uma API que poderia implementar qualquer princípio, mas implementa os princípios REST, nós chamamos de API REST FULL
> 

⚠️ E quais são esses princípios?


## OS 6 PRINCÍPIOS ORIENTADORES OU RESTRIÇÕES DA ARQUITETURA RESTFUL SÃO:

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/APIrestFul1.png" />

### 1. UNIFORM INTERFACE

 **Uniform Interface** (ou **Interface Uniforme**) é um dos princípios fundamentais do estilo arquitetural **REST**. Ele descreve a ideia de que, para uma API REST ser simples e fácil de entender, ela deve ter uma interface padronizada e consistente para que os desenvolvedores saibam como interagir com os recursos da API sem precisar de muita explicação.

### Em termos simples:

A **Uniform Interface** significa que a estrutura e a forma de comunicação de uma API devem ser uniformes e seguir regras claras, para que qualquer recurso ou operação na API tenha um comportamento previsível.

### Como isso funciona na prática:

1. **Identificação de Recursos via URLs**:
    - Cada recurso da API deve ter uma URL única e bem definida. Por exemplo, `/produtos/123` pode ser o identificador do recurso "produto" com o ID 123.
2. **Uso de Métodos HTTP Padronizados**:
    - As operações sobre os recursos (como obter, criar, atualizar ou excluir) são feitas de forma consistente através dos métodos HTTP. Por exemplo:
        - **GET**: Para obter os dados de um recurso.
        - **POST**: Para criar um novo recurso.
        - **PUT**: Para atualizar um recurso existente.
        - **DELETE**: Para remover um recurso.
3. **Representações dos Recursos**:
    - Os recursos são representados de forma consistente, geralmente em formatos como **JSON** ou **XML**, e essas representações podem ser passadas de um servidor para um cliente e vice-versa.
4. **Uso de Códigos de Status HTTP**:
    - Os códigos de status HTTP também são usados de maneira uniforme para indicar o resultado de uma operação. Por exemplo, **200 OK** para sucesso, **404 Not Found** para recurso não encontrado, etc.

### Exemplo Prático:

Imagine uma API que gerencia produtos em um sistema de e-commerce.

- Para **obter** informações de um produto, você faz uma requisição **GET** para a URL `/produtos/123`.
- Para **criar** um novo produto, você faz uma requisição **POST** para a URL `/produtos`, enviando as informações do produto no corpo da requisição.
- Para **atualizar** um produto existente, você faz uma requisição **PUT** para a URL `/produtos/123`, com as informações atualizadas do produto.
- Para **deletar** um produto, você faz uma requisição **DELETE** para a URL `/produtos/123`.

Essa consistência torna a API mais fácil de usar e entender, pois todos os recursos e suas operações seguem um padrão claro e previsível.

### Por que a "Uniform Interface" é importante?

A **Uniform Interface** facilita o desenvolvimento e manutenção de APIs, pois garante que todos os recursos tenham a mesma estrutura e comportamento. Isso torna o código mais simples, mais flexível e mais fácil de escalar, além de permitir que desenvolvedores interajam com a API de forma intuitiva, sem precisar entender todos os detalhes de como cada parte do sistema foi implementada.

Em resumo, a "Uniform Interface" é um dos pilares do REST e visa garantir que as interações com a API sejam padronizadas, claras e consistentes, melhorando a usabilidade e a previsibilidade das comunicações entre sistemas.

### 2. STATELESS

**Stateless** (sem estado) é um dos princípios do estilo arquitetural REST. Significa que **cada requisição feita a uma API deve ser independente** e **não deve depender de informações armazenadas de requisições anteriores**.

Ou seja, o servidor **não armazena** o estado da comunicação entre o cliente e o servidor. Cada vez que o cliente faz uma requisição, ele deve enviar todas as informações necessárias para processá-la, como autenticação ou dados específicos, já que o servidor não lembra do que aconteceu antes.

Isso torna as APIs mais simples e escaláveis, pois o servidor não precisa manter um histórico de interações.

### 3. CACHABLE

**Cachable** (ou **cachêável**) é um dos princípios do REST e significa que as respostas de uma API podem ser **armazenadas em cache** (ou seja, armazenadas temporariamente) para **evitar requisições repetidas** ao servidor, melhorando o desempenho.

Quando uma resposta é **cachêável**, isso significa que o cliente (ou intermediários como proxies) pode armazenar a resposta e usá-la novamente sem precisar fazer a mesma requisição ao servidor. Isso reduz a carga no servidor e melhora a velocidade de resposta.

Para que algo seja cacheável, a resposta deve ter cabeçalhos HTTP que indiquem se ela pode ser armazenada e por quanto tempo.

> Vamos imaginar que temos um recurso na API que retorna sempre os mesmos dados, vamos imaginar que seja uma tabela de configurações, se essa informação não muda, qual a necessidade de eu ir lá no banco toda hora realizar a mesma requisição? para isso temos o princípio cachable para evitar isso.
> 

### 4. CLIENT-SERVER

Basicamente temos um cliente que vai se comunicar com o servidor, ou podemos ter vários clientes se comunicando com o servidor.

**Cliente-Servidor** é um dos princípios fundamentais do REST e se refere a uma **arquitetura em que as responsabilidades são divididas entre dois componentes principais**:

- **Cliente**: É o componente que faz as requisições (como um navegador ou aplicativo) para obter ou enviar dados.
- **Servidor**: É o componente que processa as requisições do cliente e envia de volta as respostas.

O cliente e o servidor **são independentes**, ou seja, o cliente não precisa saber como o servidor funciona internamente, e o servidor não precisa saber quem está fazendo as requisições. Isso torna a comunicação mais flexível e facilita a escalabilidade e manutenção dos sistemas.

### 5. LAYERED SYSTEM

Sistema em camadas, ele é muito utilizado nos dias atuais.

**Layered System** (ou **Sistema em Camadas**) é um princípio do REST que diz que a arquitetura de um sistema pode ser **dividida em camadas hierárquicas**, onde cada camada tem uma função específica.

Essas camadas podem incluir, por exemplo:

1. **Camada de cliente**: Onde o usuário interage com a aplicação.
2. **Camada de servidor**: Onde as requisições são processadas.
3. **Camada de armazenamento**: Onde os dados são persistidos, como bancos de dados.

A ideia é que cada camada não precisa conhecer ou interagir diretamente com outras camadas além da sua, o que ajuda a **modularizar** o sistema, melhorar sua **segurança**, **escalabilidade** e facilitar a manutenção. O cliente, por exemplo, pode interagir apenas com o servidor, sem precisar saber sobre a camada de armazenamento de dados.

### 6. CODE ON DEMAND

Código sobre demanda, esse principio significa que o usuário pode fazer uma solicitação na API e essa solicitação ela pode mudar a interface do usuário, vamos supor que a gente tenha uma aplicação com usuários comuns e usuários administradores, um usuário administrador ele não tem a mesma visualização que um usuário comum e vice e versa, ou uma informação sensível, na qual somente o usuário administrador tem acesso a essas informações.

**Code on Demand** é um princípio opcional do REST que permite que o **servidor envie código executável para o cliente**, como **JavaScript**, que o cliente pode executar para estender ou modificar o comportamento da aplicação.

Por exemplo, ao acessar uma página da web, o servidor pode enviar um script que o navegador do cliente executa para realizar ações específicas sem precisar fazer uma nova requisição ao servidor.

Esse princípio ajuda a reduzir a carga do servidor, já que parte da lógica pode ser executada pelo cliente, mas nem todas as APIs REST utilizam essa abordagem.

---

## SPRING BOOT


🏆 É um dos projetos baseados no Framework Spring. Sua premissa é permitir criar aplicações de forma simples e rápida. 


🏆 Com ele, os desenvolvedores podem começar rapidamente suas aplicações sem perder muito tempo na preparação e configuração de seu aplicativo SPRING

🏆

### CONCLUSÃO

API REST significa **"Interface de Programação de Aplicações baseada em Transferência de Estado Representacional"** (em inglês, **Representational State Transfer**). Ela é um estilo de arquitetura para sistemas distribuídos, geralmente usada para criar serviços web.

Em termos mais simples, uma **API REST** é um conjunto de regras e convenções que permitem que diferentes sistemas (como aplicativos ou sites) se comuniquem uns com os outros pela internet. O REST usa o protocolo HTTP (o mesmo utilizado pelos navegadores) para enviar e receber dados, de forma simples e eficiente.

Aqui estão alguns conceitos importantes relacionados ao REST:

1. **Recursos**: Tudo no sistema REST é considerado um recurso (por exemplo, um usuário, um produto, etc.), e cada recurso é identificado por uma URL única.
2. **Métodos HTTP**: O REST usa os métodos HTTP para realizar operações sobre os recursos. Os métodos mais comuns são:
    - **GET**: Para obter informações de um recurso.
    - **POST**: Para criar um novo recurso.
    - **PUT**: Para atualizar um recurso existente.
    - **DELETE**: Para excluir um recurso.
3. **Stateless (Sem Estado)**: Em uma API REST, cada requisição deve conter todas as informações necessárias para ser processada, ou seja, o servidor não armazena o estado das requisições anteriores. Isso torna a comunicação mais simples e escalável.
4. **Representações**: Quando você interage com um recurso, o servidor envia uma "representação" desse recurso, que pode ser em formato JSON, XML, etc.

Em resumo, uma API REST é uma maneira eficiente e estruturada de comunicar sistemas através da web, utilizando o protocolo HTTP e seguindo os princípios do REST.

