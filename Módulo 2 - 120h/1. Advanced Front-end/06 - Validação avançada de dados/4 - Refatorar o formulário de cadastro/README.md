# REFATORAR O FORMULÁRIO DE CADASTRO

## DÚVIDAS QUE SURGIRAM DURANTE A AULA

### Eu tinha esquecido o que era refatoração, então fui pesquisar

Refatorar um código significa **reorganizar, modificar ou melhorar o código existente sem alterar seu comportamento externo ou funcionalidade**. O objetivo da refatoração é tornar o código mais limpo, eficiente, compreensível e fácil de manter.

---

### **Por que refatorar o código?**

1. **Melhorar a legibilidade**:
    - Tornar o código mais fácil de entender para outros desenvolvedores (ou para você mesmo no futuro).
2. **Reduzir a complexidade**:
    - Remover redundâncias, código desnecessário ou excessivamente complicado.
3. **Facilitar a manutenção**:
    - Organizar o código para que seja mais simples de corrigir bugs ou adicionar novas funcionalidades.
4. **Melhorar o desempenho**:
    - Otimizar partes do código que podem estar consumindo muitos recursos ou funcionando de forma ineficiente.
5. **Preparar para expansão**:
    - Tornar o código mais modular e flexível para suportar futuras alterações.

---

### **Exemplo básico de refatoração**

### Código original (não refatorado):

```tsx
function calcularPrecoFinal(preco: number, desconto: number) {
  if (desconto > 0) {
    return preco - (preco * desconto / 100);
  } else {
    return preco;
  }
}

```

### Código refatorado:

```tsx
function calcularPrecoFinal(preco: number, desconto: number): number {
  return desconto > 0 ? preco * (1 - desconto / 100) : preco;
}

```

**Melhorias:**

- Código mais enxuto.
- Menos duplicação de lógica.
- Maior legibilidade.

---

### **Boas práticas ao refatorar código**

1. **Entenda o código existente**:
    - Antes de começar, compreenda como o código funciona e os possíveis impactos das mudanças.
2. **Faça pequenos passos**:
    - Refatore pequenas partes de cada vez para evitar introduzir erros ou alterar funcionalidades inesperadamente.
3. **Garanta a cobertura por testes**:
    - Certifique-se de que o código já tenha testes antes de começar, ou crie testes para validar o comportamento existente.
4. **Elimine redundâncias**:
    - Identifique partes repetitivas no código e extraia-as para funções ou métodos reutilizáveis.
5. **Use padrões de design adequados**:
    - Substitua soluções improvisadas por abordagens que sigam padrões de design confiáveis.
6. **Adote convenções de código**:
    - Padronize nomes de variáveis, funções, e siga as práticas recomendadas da linguagem ou framework.

---

### **Exemplo de refatoração mais avançado**

### Código original:

```tsx
function calcularDesconto(valor: number, tipo: string) {
  if (tipo === 'VIP') {
    return valor * 0.8;
  }
  if (tipo === 'Regular') {
    return valor * 0.9;
  }
  return valor;
}

```

### Código refatorado:

```tsx
function calcularDesconto(valor: number, tipo: string): number {
  const descontos = {
    VIP: 0.8,
    Regular: 0.9,
    Padrão: 1
  };

  return valor * (descontos[tipo] || descontos['Padrão']);
}

```

**Melhorias:**

- Substituímos múltiplos **`if`** por um objeto que facilita futuras expansões.
- Código mais modular e legível.

---

### **Quando refatorar?**

- **Antes de adicionar novas funcionalidades**:
    - Prepare o código para que seja mais fácil adicionar a nova lógica.
- **Quando o código é difícil de entender**:
    - Se você ou sua equipe têm dificuldade em entender o código, é hora de torná-lo mais legível.
- **Após identificar "dívida técnica"**:
    - Corrija soluções improvisadas ou não ideais feitas sob pressão.
- **Durante revisões de código**:
    - Aproveite feedbacks para implementar melhorias sugeridas.

---

### **Resumo**

Refatorar é um processo contínuo e essencial no desenvolvimento de software para garantir que o código seja **limpo**, **eficiente** e **sustentável a longo prazo**. É uma prática fundamental para equipes que desejam manter uma base de código saudável e escalável.

---

---

---

🏆 Vamos refatorar o código para deixar ele mais parecido com o que a gente vai eviar para nossa fake api em node baseada em json


- TIRAMOS O CNPJ (porque é um formulário de cadastro de usuário e não de empresa)
- Vamos trocar o “firstName” por apenas “name”
- Vamos remover a linha de código que salva no localStorage pois agr vamos salvar na FAKE API
    
    ```tsx
    // localStorage.setItem('user', JSON.stringify(this.user))
    ```
    
- Adicionar o campo CPF no arquido do json serve (db.json)

🚨 O COMANDO ‘CTRL’ + ‘F’ substitui todos nomes de uma vez pelo nome que você desejar


✅ VAMOS UTILIZAR ESSE MÉTODO PARA ADICIONAR USUARIOS NA FAKE API (DB.JSON)

```tsx

  // MÉTODO POST -> CRIAR FUNÇÃO PARA ADICIONAR USER 

  /* Se eu adicionar um usuário por padrão ele retorna o próprio usuário que eu criei */
  addUser(user:any): Observable<User>{
    return this.segurancaHttp.post<User>(this.BASE_URL + 'users', user, httpOptions)
  }
```

> Na próxima aula!!
> 

---

---

---

## DÚVIDAS QUE SURGIRAM DURANTE A AULA

### Os campos do formControl tem que ser o mesmo nome do arquivo json que estou consumindo?

Não, os campos do **`FormControl`** no Angular **não precisam necessariamente ter o mesmo nome** dos campos do arquivo JSON que você está consumindo. Porém, se os nomes forem diferentes, será necessário fazer a correspondência manual entre os nomes dos campos no JSON e os controles do formulário.

---

### **Como funciona?**

- Os **nomes dos campos do `FormControl`** são definidos no seu formulário (em um `FormGroup`) e servem como identificadores dentro da aplicação.
- Os **nomes dos campos do JSON** dependem da estrutura do dado que você está consumindo.

Se os nomes forem diferentes, você precisará mapear os dados para o formulário ou do formulário para o JSON.

---

### **Exemplo 1: Nomes iguais**

Se os nomes no formulário e no JSON forem os mesmos, você pode atribuir os valores diretamente.

### Arquivo JSON:

```json
{
  "firstName": "João",
  "lastName": "Silva"
}

```

### Código do formulário:

```tsx
this.form = new FormGroup({
  firstName: new FormControl(''),
  lastName: new FormControl('')
});

// Atribuir os dados do JSON ao formulário
this.form.setValue({
  firstName: jsonData.firstName,
  lastName: jsonData.lastName
});

```

Neste caso, a correspondência é direta porque os nomes coincidem.

---

### **Exemplo 2: Nomes diferentes**

Se os nomes forem diferentes, será necessário mapear os dados.

### Arquivo JSON:

```json
{
  "nome": "João",
  "sobrenome": "Silva"
}

```

### Código do formulário:

```tsx
this.form = new FormGroup({
  firstName: new FormControl(''),
  lastName: new FormControl('')
});

// Mapear os dados do JSON para o formulário
this.form.setValue({
  firstName: jsonData.nome,
  lastName: jsonData.sobrenome
});

```

Aqui, mesmo que os nomes sejam diferentes, você controla como os valores do JSON são atribuídos ao formulário.

---

### **Correspondência ao salvar os dados**

Da mesma forma, ao enviar os dados de volta ao servidor, você pode mapear os nomes dos campos do formulário para os nomes esperados no JSON.

### Exemplo:

```tsx
const jsonData = {
  nome: this.form.get('firstName')?.value,
  sobrenome: this.form.get('lastName')?.value
};

```

---

### **Quando os nomes diferentes são úteis?**

1. **Tradução ou convenções internas**:
    - No JSON, o campo pode ser **`first_name`**, mas no formulário você prefere chamá-lo de **`firstName`** para seguir a convenção camelCase.
2. **Estruturas complexas**:
    - O JSON pode ter uma estrutura mais complexa, e você precisa ajustar os nomes para simplificar o uso no formulário.
3. **Manipulação de dados específicos**:
    - Quando os campos do JSON precisam de formatação ou transformação antes de serem usados no formulário.

---

### **Conclusão**

Não é obrigatório que os nomes dos campos do **`FormControl`** correspondam aos nomes do JSON, mas se forem diferentes, você precisará mapear os dados manualmente para garantir que o formulário funcione corretamente. Manter os nomes iguais é uma prática comum, pois reduz a necessidade de mapeamento e facilita o desenvolvimento.