# 5 → WEBSOCKET

🏆 WebSocket é um protocolo de comunicação que permite a **conexão contínua e bidirecional** entre o cliente (como um navegador) e o servidor.

### Resumo:

- Diferente do HTTP, que é baseado em requisições e respostas, o WebSocket mantém uma conexão **aberta**.
- Isso permite a troca de mensagens em **tempo real**, sem precisar ficar fazendo novas requisições.
- É muito usado em **chats, jogos online, sistemas de notificação** e outras aplicações que exigem atualização constante de dados.

**Exemplo:** Um chat usa WebSocket para que mensagens apareçam imediatamente para todos os usuários assim que são enviadas.


🏆 Já que nós vimos como criar tarefas assíncronas, faz sentido agora utilizar o websocket, assim que essa tarefa terminar, a gente enviar o resultado para o usuário sem que ele precise ficar fazendo requests seguidas na aplicação.


🏆 WebSocket é uma tecnologia que permite abrir uma sessão de comunicação interativa entre o cliente e o servidor.

🏆 Desta forma, a API passa a ter um papel ativo na comunicação, podendo enviar mensagens sempre que necessário.


---

### DIFERENÇA DE WEBSOCKET E HTTP



### HTTP ✅

> O CLIENTE FAZ A REQUISIÇÃO E ESPERA A RESPOSTA, A CONEXÃO É ABERTA E FECHA LOGO EM SEGUIDA.
> 



### WEBSOCKET ✅

> VOCÊ ABRE A CONEXÃO, E ELA PERMANECE ABERTA, CHAMAMOS DE CONEXÃO PERSISTENTE. O SERVIDOR PODE ENVIAR UMA MENSAGEM PRO CLIENTE A QUALQUER MOMENTO.
> 

---

## IMPLEMENTAÇÃO NO PROJETO

### 1. PRIMEIRO VAMOS COLOCAR A DEPENDÊNCIA DO SOCKETIO NO POM.XML

```xml
	<dependency>
			<groupId>com.corundumstudio.socketio</groupId>
			<artifactId>netty-socketio</artifactId>
			<version>2.0.7</version>
		</dependency>
```

### 2. AGORA VAMOS CRIAR UMA CLASSE DE CONFIGURAÇÃO PARA O WEBSOCKET

✅ Toda vez que o spring iniciar ele vai passar por essa classe que vai ter esse método que vai retornar esse “socket io service”


```java
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.corundumstudio.socketio.SocketIOServer;

@Configuration
public class SocketConfig {
	
	@Bean
	public SocketIOServer socketIOServer() {
		com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
		
		// SETANDO A PORTA QUE O SOCKET IO VAI SUBIR
		config.setPort(9092);
		return new SocketIOServer(config);
	}

}
```



### EXPLICA O CÓDIGO 🏆

```java
@Configuration
public class SocketConfig {

```

🧩 Declara uma **classe de configuração Spring**, onde você define **beans** (objetos que o Spring gerencia).

---

```java
    @Bean
    public SocketIOServer socketIOServer() {

```

🔧 Este método cria e retorna uma instância de `SocketIOServer` e a registra como **bean** no Spring, para ser injetada em outras partes do projeto.

---

```java
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();

```

⚙️ Cria um objeto de **configuração** específico da biblioteca `netty-socketio`, necessário para configurar o servidor.

---

```java
        // SETANDO A PORTA QUE O SOCKET IO VAI SUBIR
        config.setPort(9092);

```

🔌 Define a **porta** onde o servidor Socket.IO vai escutar (neste caso, **9092**).

---

```java
        return new SocketIOServer(config);
    }

```

🚀 Cria o servidor com a configuração definida e o retorna para ser gerenciado como **bean** Spring.

---

### ✅ Em resumo:

Essa classe configura o **SocketIOServer** na porta **9092**, e o disponibiliza como um **bean Spring**, pronto para ser injetado e usado em outras partes do sistema.


### 3. VAMOS CRIAR UMA CLASSE DE SERVICE QUE VAI UTILIZAR ESSE SOCKET IO PARA ENVIAR MENSAGENS

```java
package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;

import jakarta.annotation.PreDestroy;

@Service
public class NotificacaoSerivce {
	
	private final SocketIONamespace namespace;
	
	private final SocketIOServer server;
	
	// MÉTODO PADRÃO QUE VAI RECEBER COMO PARAMETRO A NOSSA OUTRA CLASSE DE SOCKET
	public NotificacaoSerivce(SocketIOServer server) {
		this.server = server;
		
		// VAMOS ESPECIFICAR O CAMINHO QUE VAMOS SUBIR NOSSO WEBSOCKET
		this.namespace = server.addNamespace("/ws-listener");
		
		// VAMOS STARTAR O SERVIDOR
		this.server.start();
	}
	
	
	// MÉTODO PARA FINALIZAR O SERVIDOR QUANDO A GENTE NÃO PRECISAR MAIS
	@PreDestroy
	private void stopSocketIO() {
		this.server.stop();
	}

}
```



### EXPLICANDO CÓDIGO 🏆

```java
package com.example.demo.service;

```

📦 Define o **pacote** onde a classe está. Ajuda a organizar o projeto.

---

```java
import org.springframework.stereotype.Service;

```

📥 Importa a anotação `@Service`, que marca a classe como um **componente de serviço Spring** (gerenciado automaticamente pelo Spring Container).

---

```java
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;

```

📥 Importa as classes da biblioteca **netty-socketio**:

- `SocketIOServer`: representa o **servidor WebSocket**
- `SocketIONamespace`: representa um **canal lógico (namespace)** de comunicação

---

```java
import jakarta.annotation.PreDestroy;

```

📥 Importa a anotação `@PreDestroy`, que permite executar um método **antes do bean ser destruído** (por exemplo, ao desligar a aplicação).

---

```java
@Service
public class NotificacaoSerivce {

```

🔧 Declara a classe como um **serviço Spring** que ficará responsável por **enviar notificações em tempo real** via WebSocket.

---

```java
    private final SocketIONamespace namespace;
    private final SocketIOServer server;

```

🔒 Declara duas variáveis:

- `server`: o servidor Socket.IO principal.
- `namespace`: o "canal" de comunicação onde os clientes vão se conectar.

---

```java
    public NotificacaoSerivce(SocketIOServer server) {

```

🧩 Construtor que recebe o `SocketIOServer` como **dependência** (injeção de dependência via Spring).

---

```java
        this.server = server;

```

🔗 Salva o servidor recebido na variável da classe.

---

```java
        this.namespace = server.addNamespace("/ws-listener");

```

📡 Cria e registra um **namespace específico** chamado `"/ws-listener"`, que os clientes podem usar para se conectar.

Exemplo no cliente: `io("/ws-listener")`

---

```java
        this.server.start();

```

🚀 Inicia o servidor WebSocket para começar a aceitar conexões.

---

```java
    @PreDestroy
    private void stopSocketIO() {
        this.server.stop();
    }

```

🛑 Este método será chamado **automaticamente** quando a aplicação for encerrada. Ele **para o servidor** Socket.IO corretamente para liberar recursos.

---

### ✅ Resumo geral:

Essa classe:

- **Inicializa** o servidor Socket.IO e um **namespace** específico (`/ws-listener`)
- Marca-se como um **serviço Spring** para poder ser injetado em outros lugares
- **Inicia** o servidor no construtor
- **Para** o servidor de forma limpa quando a aplicação for finalizada (`@PreDestroy`)
</aside>

### 4. NESSA MESMA CLASSE EU VOU CRIAR UM MÉTODO QUE SERÁ RESPONSÁVEL POR TODA VEZ QUE AQUELA TAREFA ASSÍNCRONA TERMINAR ELE VAI ENVIAR UMA MENSAGEM PARA O NOSSO CLIENTE QUE ESTARÁ CONECTADO NESSE SERVIDOR.

```java
public void publicar(String mensagem) {
		namespace.getBroadcastOperations().sendEvent("Notificação", mensagem);
	}
```



### EXPLICAÇÃO DO CÓDIGO 🏆

### Código:

```java
public void publicar(String mensagem) {
    namespace.getBroadcastOperations().sendEvent("Notificação", mensagem);
}

```

---

### Linha 1:

```java
public void publicar(String mensagem) {

```

🔹 Declara um **método público** chamado `publicar`.

🔹 Ele **não retorna nada** (`void`).

🔹 Recebe um **parâmetro** chamado `mensagem`, que é uma **String**.

➡️ Esse método será usado para **enviar uma mensagem** (como uma notificação) para os clientes conectados via Socket.IO.

---

### Linha 2:

```java
    namespace.getBroadcastOperations().sendEvent("Notificação", mensagem);

```

Vamos dividir em partes para entender melhor:

### 👉 `namespace`

- É uma **variável** (provavelmente da classe) do tipo `SocketIONamespace`.
- Representa um **canal lógico** do servidor Socket.IO.
- Por exemplo, você pode ter vários namespaces como: `/chat`, `/admin`, `/notificacoes`, etc.

### 👉 `getBroadcastOperations()`

- Esse método retorna uma instância que permite **enviar eventos para todos os clientes conectados** ao namespace atual.
- É como dizer: "quero mandar algo para **todo mundo** que está nesse canal".

### 👉 `sendEvent("Notificação", mensagem)`

- Envia um evento com o nome `"Notificação"` para todos os clientes.
- O segundo parâmetro (`mensagem`) é o **conteúdo** que será enviado.

---

Esse método envia uma **mensagem em tempo real** para **todos os clientes conectados** ao `namespace`, usando o evento `"Notificação"`. É útil para coisas como:

- Alertas em dashboards
- Notificações push
- Atualizações em tempo real

### 5. AGORA VAMOS CONSUMIR ESSE SERVICE QUE CRIAMOS

1. VAMOS FAZER A INJEÇÃO DE DEPENDÊNCIA DA CLASSE NOTIFICAÇÃO SERVICE NA CLASSE TarefaAsyncService 
2. REALIZANDO ALTERAÇÕES NO MÉTODO QUE AGORA VAI FICAR DESSA FORMA:

🏆 Ao invés da mensagem ficar perdida no console, ela será enviada para o cliente.


```java
package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TarefaAsyncService {
	
	@Autowired
	NotificacaoSerivce notificacaoSerivce;
	
	private static final Logger log = LoggerFactory.getLogger(TarefaAsyncService.class);
	
	@Async
	public void gerarTarefaAsync() throws InterruptedException {
		log.info("Tarefa iniciada com sucesso!");
		
		Thread.sleep(10000);
		
		notificacaoSerivce.publicar("Tarefa finalizada com sucesso.");
	}

}
```

---

## INICIANDO OS TESTES NO POSTMAN

🏆 ANTES DE INICIAR OS TESTES VAMOS TER QUE REALIZAR UMA CONFIGURAÇÃO NO POSTMAN PARA QUE O CLIENTE SE CONECTE NO WEBSOCKET

### CONFIGURANDO UM CLIENTE WEBSOCKET NO POSTMAN

- 1 → VAMOS CLICAR EM NEW
- 2 → EM SEGUIDA EM WEBSOCKET

EM SEGUIDA 

- 3 → VAMOS COLOCAR O CAMINHO

```java
ws://localhost:9092/ws-listener
```

- 4 → DENTRO DO POSTMAN, PRECISAREMOS NOS CADASTRAR NO EVENTO CHAMADO “NOTIFICACAO” EM “EVENTS” 🏆
    
    
    
    > Você recebeu uma mensagem do servidor WebSocket com um tipo ou chave chamada "notificacao", e o Postman automaticamente criou esse "evento" para você visualizar.
    > 
    
    ---
    
    ### 🧠 Como o Postman identifica esse nome "notificacao"?
    
    O Postman tenta **interpretar automaticamente mensagens recebidas via WebSocket**, principalmente se elas vierem no formato JSON. Exemplo:
    
    ```json
    {
      "type": "notificacao",
      "mensagem": "Você tem uma nova mensagem!"
    }
    
    ```
    
    Nesse caso, ele vê o campo `"type": "notificacao"` e cria um evento com esse nome.
    
    Se você estiver ouvindo mensagens no WebSocket, e elas tiverem esse tipo de estrutura, o Postman:
    
    - Mostra isso em "Events"
    - Marca com “listen” para te avisar que ele está **ouvindo esse tipo de evento**
    
    ---
    
    ### ✅ O que significa o "listen" ativado?
    
    - **Listen ativado** = o Postman está **pronto para mostrar todas as mensagens** que chegam com esse tipo de estrutura (por exemplo, com `"type": "notificacao"`).
    - Ele **não bloqueia nem interfere** — só serve para que você veja agrupadas as mensagens desse tipo.
    
    ---
    
    ### 🔎 Como isso afeta você?
    
    Se seu backend envia mensagens como:
    
    ```json
    {
      "type": "notificacao",
      "conteudo": "Servidor atualizado com sucesso"
    }
    
    ```
    
    Você verá isso agrupado sob o evento **"notificacao"** no Postman. Isso **não significa** que o evento precisa ser criado manualmente — ele está apenas sendo **detectado automaticamente**.
    
    ---
    
    ### ✅ O que você pode fazer com isso?
    
    - Clicar no evento "notificacao" para **ver as mensagens recebidas** desse tipo.
    - Criar eventos personalizados com mensagens que você quer **enviar**, como:
        - `"type": "ping"`
        - `"type": "subscribe"`
        - etc.
    
    ---
    
    ### 🛠️ Dica final:
    
    Se seu backend estiver usando algo como Spring + STOMP, e estiver enviando mensagens para destinos como `/topic/notificacao`, o conteúdo pode ser algo como:
    
    ```json
    {
      "mensagem": "Alerta do sistema"
    }
    
    ```
    
    E o cliente (como Postman ou Stomp.js) vai receber essa mensagem — o Postman só está agrupando essas mensagens como "notificacao" se detectar isso no conteúdo.
    
    ---
    
    Se quiser, me mostre uma das mensagens que você está recebendo, e eu posso te explicar exatamente por que o evento aparece com esse nome.
    
    

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/Websocket1.png" />

- 5 → DENTRO DO POSTMAN, VAMOS PRECISAR REALIZAR ALGUMAS CONFIGURAÇÕES COMO POR EXEMPLO ALTERAR A VERSÃO, TEMPO DE RECONEXÃO, E O TEMPO QUE ELE VAI TENTAR SE RECONECTAR CASO A CONEXÃO CAIA.

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/Websocket2.png" />


### 1. APÓS CONFIGURAR TUDO CORRETAMENTE VAMOS CHAMAR O ENDPOINT DE GERAR RELATÓRIO

🏆 A ideia é que esse endpoint já responda para nós de imediato que o relatório está sendo executado e depois de algum tempo a gente vai receber uma notificação que esse relatório foi finalizado.

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/Websocket3.png" />

