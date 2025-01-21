# 3 → DESENVOLVIMENTO DO MER LÓGICO

🏆 O MODELO LÓGICO É A SEGUNDA ETAPA DO PROJETO DE BANCO DE DADOS.

> O primeiro a ser construído é o modelo conceitual onde a importância é as entidades, os atributos e os relacionamentos entre essas entidades e também a cardinalidade
> 

### NO MODELO LÓGICO VAMOS TER COMO PRIORIDADE OS ASPECTOS TECNICOS:

- Qual campo vai ser a chave primária
- Qual campo vai ser a chave estrangeira
- Qual lado a chave estrangeira será colocada
- Se vai ter entidade associativa ou não
- Qual os atributos dessa entidade associativa caso tenha
- O campo vai armazenar números ou textos?

---

## ESTUDO DE CASO - FÁBRICA DE AUTOPEÇAS - REQUISITOS FUNCIONAIS - PARTE 1

🏆 Para que a gente possa fazer esse modelo lógico novamente devemos voltar aos requisitos, a gente já tem o modelo conceitual que foi gerado com os requisitos, e ai a gente usa os requisitos juntamente com o modelo conceitual para conseguir fazer o modelo lógico


<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MERl%C3%B3gico1.png" />

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MERlogico2.png" />

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MERlogico3.png" />

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MERlogico4.png" />

## APÓS A ANÁLISE DOS REQUISITOS, FOI GERADO O SEGUINTE MER CONCEITUAL

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MERlogico5.png" />

🏆 Podemos observar que a cardinalidade estabelecida é 1 no vendedor e N no cliente, a chave estrangeira ficara no cliente por conta do N 

💡

A cardinalidade **vendedor (1,1) - cliente (0,N)** descreve uma relação entre as entidades **vendedor** e **cliente**, com as seguintes regras:

### **Explicação da Cardinalidade:**

1. **Vendedor (1,1):**
    - Cada vendedor **deve obrigatoriamente atender a pelo menos um cliente** (no mínimo 1 cliente).
    - Cada vendedor pode atender **apenas 1 cliente por vez** (no máximo 1 cliente).
    - **Conclusão:** O vendedor é exclusivo para um único cliente.
2. **Cliente (0,N):**
    - Um cliente **não precisa obrigatoriamente estar associado a um vendedor** (no mínimo 0 vendedores, o que significa que o cliente pode estar "desatendido").
    - Um cliente pode ser atendido por **vários vendedores** ao longo do tempo ou simultaneamente (no máximo N vendedores).
    - **Conclusão:** A relação pode envolver múltiplos vendedores, mas não exige associação obrigatória.

---

### **Relação Representada**

Essa configuração pode ser usada em um sistema em que:

- Cada **vendedor** está designado a **um único cliente de cada vez** (exclusividade por cliente).
- Um **cliente** pode ter diversos vendedores designados ao longo do tempo (potencialmente simultâneos ou por turnos).

---

### **Cenário Prático**

**Exemplo: Sistema de Consultoria Personalizada**

- Cada consultor (vendedor) só atende um cliente por vez para oferecer um atendimento focado e exclusivo.
- Alguns clientes podem ter múltiplos consultores designados ao longo do tempo, mas não são obrigados a ter consultores associados constantemente.

---

### **Modelagem SQL**

### Tabela Vendedor:

```sql
CREATE TABLE Vendedor (
    id INT PRIMARY KEY,
    nome VARCHAR(50)
);

```

### Tabela Cliente:

```sql
CREATE TABLE Cliente (
    id INT PRIMARY KEY,
    nome VARCHAR(50)
);

```

### Relação:

```sql
CREATE TABLE VendedorCliente (
    vendedor_id INT NOT NULL,
    cliente_id INT,
    PRIMARY KEY (vendedor_id), -- Um vendedor só pode estar associado a um cliente
    FOREIGN KEY (vendedor_id) REFERENCES Vendedor(id),
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

```

---

### **Resumo**

- Cada **vendedor** atende **exclusivamente um cliente de cada vez**.
- Um **cliente** pode estar associado a **nenhum ou vários vendedores**.
Essa modelagem é útil para cenários de alocação dinâmica e controle direto de relacionamentos comerciais.

---

---

---

## AGORA VAMOS IMPLEMENTAR O MODELO LÓGICO, CRIANDO ELE NO BRMODELO SOFTWARE

> Devemos observar sempre o modelo conceitual como base e respeita-lo
> 

<img width="800" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/MERlogico6.png" />

💡 As ferramentas tem a geração automática, a gente gera o modelo conceitual e automaticamente ela irá gerar o modelo lógico

