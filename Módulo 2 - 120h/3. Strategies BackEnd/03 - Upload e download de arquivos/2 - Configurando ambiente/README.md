# 2 → CONFIGURANDO AMBIENTE

🏆 Vamos configurar o nosso projeto com variáveis de ambiente


---

### O QUE SÃO VARIÁVEIS DE AMBIENTE?

🏆 São variáveis que usamos durante nossa aplicação que pode mudar de ambiente para ambiente como o próprio nome já diz, vamos supor que a gente tenha dois ambientes na nossa API:

- 1 - EM DESENVOLVIMENTO
- 2 - EM PRODUÇÃO

✅  A configuração ao banco de dados e algumas outras informações são uma para nosso ambiente em desenvolvimento e são outras para nosso ambiente de produção.


> Toda vez que a gente precisa mudar uma variável de ambiente a gente não precisa refazer o deploy da aplicação, basta a gente ir no arquivo especifico de configuração do sistema de variáveis de ambiente e realizar as alterações necessárias que o sistema irá ler essas variáveis de ambiente automaticamente.
> 

---

### VAMOS VER COMO A GENTE CONFIGURA O UPLOAD E DOWNLOAD DE ARQUIVO USANDO VARIÁVEIS DE AMBIENTE QUE O SPRING VAI USAR, E DEPOIS CRIAREMOS A VARIÁVEL QUE IREMOS USAR.

### 1. CRIANDO VARIÁVEIS DE AMBIENTE

- 1 → Ir ate a pasta src/main/resources
- 2 → Entrar no arquivo application.properties

🏆 Como a gente não tem ambiente DEV e nem em PRODUÇÃO, é apenas 1 arquivo, mas se caso tivesse mais de 1 ambiente a gente teria mais de 1 arquivo dizendo se era um arquivo de DEV ou PRODUÇÃO.


### ESSAS SÃO AS VARIÁVEIS QUE O SPRING VAI USAR PARA QUE POSSAMOS UTILIZAR A TRANSFERÊNCIA DE ARQUIVO.

🏆 Para gente permitir que arquivos sejam transferidos para nossa API, é necessário habilitar algumas configurações do spring.

- 1 → Primeiro vamos habilitar o envio e recebimento de arquivos na nossa API SPRING BOTT

```java
spring.servlet.multipart.enabled=true 
```

- 2 → Também precisamos dizer qual o tamanho máximo do arquivo que a nossa API suporta

```java
spring.servlet.multipart.max-file-size=200mb
```

- 3 → Vamos ter que configurar o tamanho máximo do request, ele é composto por header, body e algumas outras informações, sendo que o arquivo vai no header.

```java
spring.servlet.multipart.max-request-size=215mb
```


### VAMOS CRIAR TAMBÉM UMA VARIÁVEL PARA NÓS UTILIZARMOS

💡 Vale ressaltar que precisaremos dizer qual o diretório do computador que queremos salvar esse arquivo.


🏆

```java
arquivo.uploadDir=C:\Users\ViniciusXavier\OneDrive\PÓS GRADUAÇÃO EM DESENVOLVIMENTO FULL STACK\Módulo 2 - Projeto de estudos - Spring Boot\uploadsAPI
```

✅ Eu quero que após eu iniciar a aplicação eu quero se caso essa pasta não exista o sistema crie ela para nós


### 2. VAMOS CRIAR UM PACKAGE CHAMADO ‘CONFIG’ E UMA CLASSE ONDE CHAMAREMOS ESSA VARIÁVEL DE AMBIENTE E TAMBÉM VAMOS CRIAR ESSE DIRETÓRIO CASO ELE NÃO EXISTA.

- 1 → Vamos criar um package chamado ‘CONFIG’
- 2 → Dentro dele criar uma classe chamada ‘ArquivoStorageProperties’
- 3 → Vou anotar essa classe com o @component que é uma anotação genérica utilizada para dizer que o spring está tomando conta daquela classe
- 4→ Vou criar uma variável que vai receber a minha variável de ambiente

```java
package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ArquivoStorageProperties {
	
	@Value("${arquivo.uploadDir}")
	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

}
```

✅

### ANOTAÇÃO @VALUE

A anotação `@Value` no Spring é usada para injetar valores em campos, métodos ou construtores de uma classe, com base em valores configurados no contexto da aplicação. Esses valores podem ser extraídos de várias fontes, como:

- **Propriedades do arquivo `application.properties` ou `application.yml`**.
- **Variáveis de ambiente**.
- **Argumentos de linha de comando**.
- **Valores constantes**.

Em resumo, a anotação `@Value` permite que você insira valores de configuração ou de propriedades diretamente no seu código.

### Exemplos de uso

1. **Injetando um valor de propriedade diretamente**:
    
    Se você tiver um arquivo `application.properties` com a seguinte entrada:
    
    ```
    app.name=MeuApp
    app.version=1.0.0
    
    ```
    
    Você pode usar a anotação `@Value` para injetar esses valores em um componente Spring:
    
    ```java
    @Component
    public class AppInfo {
    
        @Value("${app.name}")
        private String appName;
    
        @Value("${app.version}")
        private String appVersion;
    
        public void printInfo() {
            System.out.println("Nome do aplicativo: " + appName);
            System.out.println("Versão do aplicativo: " + appVersion);
        }
    }
    
    ```
    
2. **Injetando valores com expressões ou valores padrão**:
    
    Você também pode usar expressões do Spring Expression Language (SpEL) para calcular ou modificar o valor durante a injeção. E, caso a propriedade não exista, você pode fornecer um valor padrão:
    
    ```java
    @Value("${app.name:DefaultApp}")
    private String appName;
    
    @Value("#{2 * T(Math).PI}")
    private double doublePi;
    
    ```
    
    No exemplo acima:
    
    - Se a propriedade `app.name` não for encontrada, o valor `"DefaultApp"` será usado como fallback.
    - A expressão SpEL `#{2 * T(Math).PI}` calcula o dobro de Pi.
3. **Injetando listas ou arrays**:
    
    Você pode injetar listas ou arrays a partir de valores configurados:
    
    ```
    app.languages=Java,Python,C++
    
    ```
    
    E no código:
    
    ```java
    @Value("#{'${app.languages}'.split(',')}")
    private List<String> languages;
    
    ```
    

### Resumo

A anotação `@Value` no Spring é uma maneira poderosa e flexível de injetar valores de configuração no seu código, tornando sua aplicação mais dinâmica e ajustável conforme os ambientes ou requisitos de execução.


🏆 Toda vez que o spring iniciar o meu componente ‘ArquivoStorageProperties’ ele vai pegar o valor do minha variável de ambiente e jogar dentro da minha variável que está na classe do componente que ele está gerenciando.

- 5 → Vou criar uma classe chamada “ArquivoServic”
- 6 → Utilizar a anotação @Service para o SPRING reconhecer como um serviço
- 7 → Vou importar a minha classe ‘ArquivoStorageProperties’ através do construtor e pegar a minha variável de ambiente

```java
package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.config.ArquivoStorageProperties;

@Service
public class ArquivoService {
	
	public ArquivoService(ArquivoStorageProperties arquivoStorageProperties) {
		// Vamos pegar aquela string do meu arquivo application properties
		arquivoStorageProperties.getUploadDir();
	}

}
```

---

### O QUE FIZEMOS NA AULA?

🏆

- 1 → Nós habilitamos as transferências de arquivos no spring
- 2 → Criamos a variável de ambiente que nós iremos usar como diretório de uma pasta do nosso computador
- 3 → Criamos uma classe onde a gente pode pegar em tempo de execução essa variável que é o diretório da onde a gente vai salvar os arquivos
- 4 → E vimos como a gente pode usar ela passando como uma variável no construtor da nossa classe do arquivo service
