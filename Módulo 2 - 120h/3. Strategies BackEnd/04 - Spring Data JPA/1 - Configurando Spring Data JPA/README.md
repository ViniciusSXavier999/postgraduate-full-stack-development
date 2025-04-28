# 1 → CONFIGURANDO SPRING DATA JPA

🏆 Para habilitar o Spring data JPA em nossa aplicação, primeiro devemos configurar suas dependências.

Precisaremos da dependência do JPA (spring-boot-starter-jpa), do banco de dados MYSQL (mysql-connector-j) e também definir a configuração do dataSource.


### CONFIGURAÇÃO DO JPA NO POM.XML

```xml
 <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
```

### CONFIGURAÇÃO DO MYSQL NO POM.XML

```xml
 <dependency>
      <groupId>com.mysql</groupId>
      <artifactId>mysql-connector-j</artifactId>
      <scope>runtime</scope>
    </dependency>
```

### CONFIGURAÇÃO DO BANCO DE DADOS MYSQL NO APPLICATION.PROPERTIES

```java
spring.jpa.hibernate.ddl-auto=update 
spring.jpa.database=mysql
spring.datasource.url=jdbc:mysql://localhost/db_digitalmenu?createDatabaseIfNotExist=true&serverTimezone=America/Sao_Paulo&useSSl=false
spring.datasource.username=root
spring.datasource.password=soudev
```

🏆

### FERRAMENTA DE BANCO DE DADOS UTILIZADA NA AULA

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/ferramentasUtilizadas.png" />

### DOWNLOAD MYSQL


[MySQL :: Download MySQL Installer](https://dev.mysql.com/downloads/installer/)


### DOWNLOAD DBEAVER

[Instalação DBEAVER](https://dbeaver.io/download/)