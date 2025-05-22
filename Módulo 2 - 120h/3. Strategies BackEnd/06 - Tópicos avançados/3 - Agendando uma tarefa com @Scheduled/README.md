# 3 → AGENDANDO UMA TAREFA COM @SCHEDULED

🏆 Imagina que você tem que executar uma tarefa que vai se repetir ao longo de um determinado período, exemplo: Todos os dias, uma vez na semana ou uma vez por mês, ou de 30 em 30 minutos, você consegue fazer esse agendamento no spring utilizando a anotação @SCHEDULED


🏆 Só existem duas regras para criar um método usando o @@SCHEDULED: 

- O retorno tem que ser void (caso não seja será ignorado).
    - Faz sentido porque como ninguém vai chamar esse método, ele não pode receber nenhum parâmetro.
- O método não deve receber nenhum parâmetro

---

### VAMOS IMPLEMENTAR ESSA FUNCIONALIDADE NO NOSSO PROGRAMA

### 1. PRIMEIRO VAMOS NA CLASSE PRINCIPAL E COLOCAR A ANOTAÇÃO @ENABLESCHEDULING

🚨 Essa configuração é obrigatória, porque se não, não vai funcionar.


---

## ✅ O que é `@EnableScheduling`? 💡

`@EnableScheduling` é uma anotação do Spring usada para **ativar o suporte ao agendamento de tarefas com `@Scheduled`**.

> Sem ela, os métodos anotados com @Scheduled não vão funcionar, mesmo que estejam escritos corretamente.
> 

---

## 🧩 Como funciona?

Quando você coloca `@EnableScheduling` em uma classe de configuração (geralmente a `@SpringBootApplication`), o Spring ativa um **agendador interno** que verifica periodicamente se há tarefas a serem executadas conforme os intervalos definidos.

---

### 📘 Exemplo de uso:

```java
@SpringBootApplication
@EnableScheduling  // <- Ativa o suporte a agendamentos
public class MinhaAplicacao {
    public static void main(String[] args) {
        SpringApplication.run(MinhaAplicacao.class, args);
    }
}

```

E aí você pode usar isso em qualquer componente:

```java
@Component
public class TarefaAutomatica {

    @Scheduled(fixedRate = 10000)
    public void executarTarefa() {
        System.out.println("Executando tarefa agendada: " + LocalDateTime.now());
    }
}

```

---

## 🧠 Resumo:

| Anotação | Função |
| --- | --- |
| `@EnableScheduling` | Ativa o suporte a métodos agendados com `@Scheduled` |
| `@Scheduled` | Define quando e com que frequência o método será executado |

---


### 2. VAMOS CRIAR UM PACKAGE PARA NOSSO SCHEDULE

```java
com.example.demo.schedule
```

### 3. DENTRO DESSE PACKAGE VAMOS CRIAR UMA CLASSE NA QUAL IMPLEMENTAREMOS A TAREFA

- Vamos anotar essa classe com a anotação @Component para dizer ao spring ser o responsável por gerenciar ela

```java

package com.example.demo.schedule;

import org.springframework.stereotype.Component;

@Component
public class EstudanteSchedule {
}
```

### 4. VAMOS DESENVOLVER O MÉTODO RESPONSÁVEL PELA TAREFA

- Também vamos utilizar o Logger para ver o resultado no terminal

```java
package com.example.demo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EstudanteSchedule {
	
	private static final Logger log = LoggerFactory.getLogger(EstudanteSchedule.class);
```

### INICIANDO O DESENVOLVIMENTO DO MÉTODO QUE VAI CHAMAR AS TAREFAS

🏆 Nesse exemplo do método abaixo, será executado a cada segundo a mensagem “tarefa executada com sucesso” no terminal.

> Temos que colocar em mili segundo de quanto em quanto tempo a gente quer que a tarefa seja executada
> 

```java
@Scheduled(fixedDelay = 1000)
	public void executarTarefa() {
		log.info("Tarefa executada com sucesso!");
	}
```

### AGORA VAMOS SUPOR QUE A GENTE QUEIRA QUE ESSA TAREFA SEJA EXECUTADA TODOS OS DIAS EM UM CERTO HORARIO

🏆 Quando colocamos * significa que será todos os dias.

