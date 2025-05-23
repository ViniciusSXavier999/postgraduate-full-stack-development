# 4 → MÉTODOS ASSÍNCRONOS COM @ASYNC

## SÍNCRONO VS ASSÍNCRONO

## 🔁 **Método Síncrono**

🏆 EM CONTRA PARTIDA, PROCESSAMENTOS SÍNCRONOS SÃO EXECUTADOS UM APÓS O OUTRO, NA MESMA THREAD.

> A próxima linha de código só será executada após a anterior terminar e assim sucessivamente.
> 

- A execução **espera** o método terminar antes de continuar.
- É o comportamento **padrão** em Java e Spring.

### 🔹 Exemplo:

```java
public String processar() {
    // tarefa demorada
    return "pronto";
}

```

Se você chamar esse método, o código **só continua depois que ele terminar**.

---

## 🔀 **Método Assíncrono**

🏆 PROCESSAMENTO ASSÍNCRONO REFERE-SE A TAREFAS QUE NÃO DEPENDEM DO RESULTADO DE OUTRAS TAREFAS, ELAS OCORREM DE FORMA SIMULTÂNEA OU PARALELA A OUTRAS TAREFAS, EM THREADS DIFERENTES.

> Com método assíncronos podemos criar tarefas que não dependem do método anterior terminar para realizar a sua função.
> 

- A execução **não espera** o método terminar.
- Ele roda **em segundo plano** (em outra thread).
- Usado quando você quer melhorar a performance, liberar recursos, ou executar tarefas demoradas sem travar a aplicação.

### ✅ Como usar no Spring:

1. Habilite o suporte:

```java
@EnableAsync
@SpringBootApplication
public class MinhaAplicacao { }

```

1. Use `@Async`:

```java
@Async
public void enviarEmail() {
    // Simula tarefa longa
    System.out.println("Enviando e-mail...");
}

```

Agora, ao chamar `enviarEmail()`, o método **roda em background**, e o restante do código continua normalmente.

---

### 📌 Comparação:

| Tipo | Espera terminar? | Executa em outra thread? |
| --- | --- | --- |
| **Síncrono** | Sim | Não |
| **Assíncrono** | Não | Sim (com `@Async`) |

---

## SEMELHANÇA COM REQUISIÇÃO SÍNCRONA E ASSÍNCRONA

## ✅ Requisição síncrona vs assíncrona (no contexto de APIs e comunicação entre sistemas):

### 🔁 **Requisição Síncrona:**

- O cliente **espera a resposta** do servidor.
- O fluxo fica **bloqueado** até a resposta voltar.
- Padrão em requisições HTTP (como um `GET` em um navegador ou Postman).

📌 Exemplo:

Você faz um `GET /usuario/1` → o servidor processa e **só depois** responde.

---

### 🔀 **Requisição Assíncrona:**

- O cliente **não espera** a resposta imediata.
- A resposta pode vir depois, por outro canal (ex: fila, notificação, polling).
- Comum em APIs reativas, mensageria (Kafka, RabbitMQ), ou WebSockets.

📌 Exemplo:

Você envia um pedido para processar um relatório. A API retorna “Recebido”, e o resultado vem por e-mail ou notificação quando estiver pronto.

---

## 🎯 E como isso se relaciona com métodos síncronos/assíncronos no Spring?

| Conceito | Contexto interno do Java/Spring | Comunicação com cliente (API) |
| --- | --- | --- |
| **Método síncrono** | Código só continua após executar tudo | Cliente espera resposta |
| **Método assíncrono** (`@Async`) | Código continua mesmo com tarefa rodando em segundo plano | Pode ser usado para **não travar** a resposta, mas **não muda o tipo da requisição HTTP por si só** |

---

### 🧠 Conclusão rápida:

- Métodos `@Async` ajudam a **não travar o servidor** com tarefas longas.
- **Requisições assíncronas** são mais sobre como o **cliente e o servidor se comunicam**.
- São **conceitos parecidos**, mas usados em **níveis diferentes**: código interno vs comunicação externa.

---

### EXEMPLO

🏆 Vamos supor que a nossa API vai fornecer um serviço/endpoint que um usuário possa imprimir um relatório, vamos supor que essa resposta demore cerca de 15 a 10 segundos, isso acaba sendo muito tempo hoje em dia para o usuário ficar esperando essa resposta, ele pode até pensar que algo deu errado.

🏆 A ideia principal é que o usuário faça a requisição, o nosso sistema ele já responde de imediato que o relatório está sendo processado e enquanto isso ele joga essa tarefa para um método assíncrono que será executado separadamente e quando esse relatório tiver pronto o usuário pode pegar ele ou a própria API pode enviar essa notificação para o usuário dizendo que está pronto a tarefa dele.


---

### VAMOS INICIAR A IMPLEMENTAÇÃO NO NOSSO PROJETO

### 1. INICIANDO O ASYNC



### INICIANDO O ASYNC 🏆

🏆 Antes de tudo precisaremos iniciar o async através da anotação @EnableAsync na classe principal do programa

A anotação `@EnableAsync` no Spring é usada para **ativar o suporte a métodos assíncronos**, ou seja, permite que métodos anotados com `@Async` sejam executados **em background**, em outra thread, **sem bloquear o fluxo principal da aplicação**.

---

## ✅ Resumo rápido:

- `@EnableAsync` → Ativa o uso de `@Async` no projeto.
- **Colocada na classe principal** ou em uma classe de configuração:

```java
@SpringBootApplication
@EnableAsync
public class MinhaAplicacao { }

```

Depois disso, você pode usar:

```java
@Async
public void enviarEmail() {
    // tarefa que roda em segundo plano
}

```

---

### 📌 Sem `@EnableAsync`, o `@Async` **não funciona**, mesmo que esteja anotado corretamente.

---


### 2. VAMOS CRIAR UM CONTROLLER COM UM ENDPOINT PARA TESTAR NOSSO MÉTODO ASSÍNCRONO

```java
package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {
	
	@GetMapping
	public ResponseEntity<String> executarTarefaAsync() {
		// CHAMAR TAREFA ASYNC
		return ResponseEntity.ok("Atividade iniciada com Sucesso");
	}

}
```

### 3. VAMOS CRIAR UM SERVICE

```java
package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TarefaAsyncService {
	
	private static final Logger log = LoggerFactory.getLogger(TarefaAsyncService.class);
	
	@Async
	public void gerarTarefaAsync() throws InterruptedException {
		log.info("Tarefa iniciada com sucesso!");
		
		Thread.sleep(5000);
		
		log.info("Tarefa finalizada com sucesso.");
	}

}
```



### EXPLICANDO CÓDIGO DO SERVICE 🏆

---

### 📌 Explicação do método:

```java
@Async
public void gerarTarefaAsync() throws InterruptedException {
    log.info("Tarefa iniciada com sucesso!"); // Log de início

    Thread.sleep(5000); // Simula uma tarefa que demora 5 segundos

    log.info("Tarefa finalizada com sucesso."); // Log de fim
}

```

---

### ✅ Resumo:

- **`@Async`**: Faz com que o método rode em uma **thread separada**, sem bloquear o fluxo principal da aplicação.
- **`Thread.sleep(5000)`**: Simula uma tarefa demorada (ex: envio de e-mail, cálculo pesado, etc.).
- **`log.info(...)`**: Registra mensagens no log (útil para monitorar e depurar).
- **Assinatura `throws InterruptedException`**: Porque o `Thread.sleep` pode lançar essa exceção.

---

### 🧠 Resultado prático:

Quando você chamar `gerarTarefaAsync()`, a aplicação **não vai parar nem esperar os 5 segundos**. O método será executado **em segundo plano** e continuará o resto da execução normalmente.




### O QUE É UMA THREAD RESUMIDAMENTE? 🏆

---

### ✅ Em outras palavras:

- Uma thread é como uma **tarefinha** que o programa executa.
- Um programa pode ter **várias threads rodando ao mesmo tempo** (paralelamente ou concorrendo pelo processador).
- A **thread principal** executa o código normalmente.
- Outras threads podem ser criadas para **rodar tarefas em segundo plano**, sem travar o resto do sistema.

---

### 📌 Exemplo prático:

Imagine que sua aplicação faz isso:

1. Processa um pedido
2. Envia um e-mail de confirmação

Se você rodar tudo na **mesma thread**, o usuário espera o e-mail ser enviado.

Se você usar uma **nova thread (com `@Async`)**, o e-mail é enviado em segundo plano e o usuário **não precisa esperar**.

---

### 🧠 No Spring Boot:

- Quando você usa `@Async`, o Spring cria uma **nova thread** automaticamente para rodar aquele método.
- Isso melhora a **performance** e a **experiência do usuário**, especialmente em tarefas lentas.

---

Se quiser, posso te mostrar visualmente como isso funciona com exemplo simples. Deseja?


### VAMOS UTILIZAR O LOGGER NOVAMENTE PARA PODER OBSERVAMOS NO TERMINAL



### PARA QUE SERVE O LOGGER NO SPRING E NO JAVA EM GERAL 🏆

O **logger** no Spring (e no Java em geral) serve para **registrar mensagens no console ou em arquivos** durante a execução da aplicação. Ele é essencial para:

---

## ✅ **Finalidades do Logger no Spring:**

1. **Depuração (Debugging)**
    
    Ver o que está acontecendo internamente no sistema — valores de variáveis, entradas, saídas, etc.
    
2. **Monitoramento**
    
    Acompanhar o comportamento da aplicação em produção (como requisições, tempo de execução, falhas, etc.).
    
3. **Auditoria**
    
    Registrar ações importantes para controle, como login de usuários, transações, etc.
    
4. **Tratamento de erros**
    
    Exibir mensagens úteis quando uma exceção ocorre, facilitando a identificação do problema.
    

---

## 📘 Exemplo com `@Slf4j` (Lombok):

```java
@Slf4j
@Service
public class UsuarioService {

    public void salvarUsuario(Usuario usuario) {
        log.info("Salvando usuário: {}", usuario.getNome());
        // lógica para salvar
    }
}

```

> Nesse exemplo, log.info(...) escreve uma mensagem informativa no console ou no log da aplicação.
> 

---

## 🧠 Níveis de log mais usados:

| Nível | Quando usar |
| --- | --- |
| `trace` | Detalhes extremamente técnicos |
| `debug` | Informação útil para desenvolvedores |
| `info` | Informações gerais sobre o fluxo da aplicação |
| `warn` | Avisos sobre algo inesperado, mas não crítico |
| `error` | Erros que devem ser corrigidos |

---

## 🛠️ Backend de logging padrão no Spring Boot:

- Spring Boot já vem com o **SLF4J + Logback**, prontos para uso.
- Basta usar `@Slf4j` (Lombok) ou criar manualmente:

```java
private static final Logger log = LoggerFactory.getLogger(MinhaClasse.class);
```

---


### 4. AGORA VAMOS REALIZAR A INJEÇÃO DE DEPENDÊNCIA DO SERVICE NO CONTROLLER

```java
	@Autowired
	private TarefaAsyncService asyncService;
```

### CONTROLLER ATUALIZADO

```java
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TarefaAsyncService;

@RestController
@RequestMapping("/async")
public class AsyncController {
	
	@Autowired
	private TarefaAsyncService asyncService;
	
	@GetMapping
	public ResponseEntity<String> executarTarefaAsync() throws InterruptedException {
		// CHAMAR TAREFA ASYNC
		
		asyncService.gerarTarefaAsync();
		return ResponseEntity.ok("Atividade iniciada com Sucesso");
	}

}

```

<aside>
🏆 A ideia é que a gente chama esse endpoint e ele já de cara retorne para gente que o relatório já foi iniciado e posteriormente vamos ver que o relatório vai finalizar depois de 5 segundos.



### CONCLUSÃO E EXPLICAÇÃO 🏆

---

## 🔧 Classe `TarefaAsyncService` (Service)

```java
@Service // Marca a classe como um componente de serviço gerenciado pelo Spring
public class TarefaAsyncService {

    private static final Logger log = LoggerFactory.getLogger(TarefaAsyncService.class);
    // Cria um logger para registrar mensagens no console

    @Async // Diz ao Spring que esse método será executado de forma assíncrona (em outra thread)
    public void gerarTarefaAsync() throws InterruptedException {
        log.info("Tarefa iniciada com sucesso!");
        // Escreve no log que a tarefa começou

        Thread.sleep(10000);
        // Simula uma tarefa demorada (espera 10 segundos)

        log.info("Tarefa finalizada com sucesso.");
        // Escreve no log que a tarefa terminou
    }
}

```

---

## 🌐 Classe `AsyncController` (Controller)

```java
@RestController // Indica que essa classe é um controller REST
@RequestMapping("/asyncs") // Define a rota base "/asyncs" para os endpoints dessa classe
public class AsyncController {

    @Autowired
    private TarefaAsyncService asyncService;
    // Injeta o serviço TarefaAsyncService

    @GetMapping // Define que esse método será chamado com uma requisição GET em /asyncs
    public ResponseEntity<String> executarTarefaAsync() throws InterruptedException {
        asyncService.gerarTarefaAsync();
        // Chama o método assíncrono (ele roda em segundo plano)

        return ResponseEntity.ok("Atividade iniciada com Sucesso");
        // Retorna a resposta imediatamente, sem esperar os 10 segundos
    }
}

```

---

## 🧠 O que essa aplicação faz:

1. Você faz um `GET` para `http://localhost:8080/asyncs`.
2. O controller chama o método `gerarTarefaAsync()` do service.
3. Por causa do `@Async`, esse método **roda em uma nova thread**, ou seja, **não bloqueia** o controller.
4. A resposta `"Atividade iniciada com Sucesso"` é enviada **imediatamente** ao cliente (ex: Postman).
5. Enquanto isso, o método assíncrono continua executando em segundo plano por **10 segundos**, depois imprime no log que terminou.

---

### ✅ Resultado:

- O usuário **não espera os 10 segundos**.
- A tarefa é **executada em segundo plano**.
- Muito útil para tarefas demoradas, como envio de e-mails, relatórios, etc.

---

---

### CASO A GENTE QUEIRA CONFIGURAR UM EXECUTOR PERSONALIZADO E PERSONALIZAR AS THREADS

---

## ✅ 1. **Entendendo o que está por trás do `@Async`**

Quando você usa `@Async`, o Spring Boot automaticamente cria um **executor de tarefas** (um `ThreadPoolTaskExecutor`) para rodar os métodos assíncronos.

Por padrão, ele usa uma configuração simples com um número limitado de threads.

Mas você pode **customizar isso** para controlar melhor quantas tarefas podem rodar ao mesmo tempo, quantas ficam em fila, nome das threads etc.

---

## 🛠️ 2. **Configurando o Executor personalizado**

Crie uma classe de configuração:

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "meuExecutorAsync")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // número mínimo de threads
        executor.setMaxPoolSize(10); // número máximo de threads
        executor.setQueueCapacity(25); // quantas tarefas ficam na fila
        executor.setThreadNamePrefix("AsyncThread-"); // nome das threads
        executor.initialize();
        return executor;
    }
}

```

---

## 🔁 3. **Usando o executor configurado no seu método assíncrono**

No seu service:

```java
@Async("meuExecutorAsync") // usa o executor configurado
public void gerarTarefaAsync() throws InterruptedException {
    log.info("Tarefa iniciada");
    Thread.sleep(10000);
    log.info("Tarefa finalizada");
}

```

---

## 📋 4. **Monitorando via logs**

Com o `ThreadNamePrefix` definido como `"AsyncThread-"`, cada log assíncrono vai aparecer assim no terminal:

```bash
[AsyncThread-1] INFO  Tarefa iniciada
[AsyncThread-1] INFO  Tarefa finalizada

```

Isso mostra qual thread executou a tarefa. Se você tiver várias tarefas, vai ver `AsyncThread-2`, `AsyncThread-3`, etc.

---

## 🧠 Benefícios de configurar o executor:

| Vantagem | Por quê? |
| --- | --- |
| Controle de concorrência | Evita sobrecarga do servidor |
| Nomes de threads personalizados | Facilita identificar no log |
| Comportamento previsível | Define fila e paralelismo conforme sua regra |

---