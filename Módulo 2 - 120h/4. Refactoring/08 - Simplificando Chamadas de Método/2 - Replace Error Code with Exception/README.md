# 2 → REPLACE ERROR CODE WITH EXCEPTION

### PROBLEMA

🚨 Um método retorna um valor especial que indica um erro?


### SOLUÇÃO

✅ Em vez disso, lance uma exceção

🏆 Podemos substituir um código de erro por uma exceção 

🏆 As classes de exceção podem implementar seus próprios métodos, contendo assim parte da funcionalidade de tratamento de erros (como para enviar mensagens de erro.)


### EXPLICAÇÃO

🏆 Você consegue chamar **`TratamentoDeErro.test(0);` sem instanciar a classe** porque o método foi declarado como **`static`**.

---

### **Por que isso acontece?**

- Um método **`static`** pertence **à classe**, não a um objeto específico.
- Ele é carregado na memória **assim que a classe é carregada pela JVM**, antes de qualquer instância existir.
- Por isso, você pode acessá-lo diretamente usando `NomeDaClasse.metodo()`.

---

### **Relação com "Replace Error Code with Exception"**

Esse padrão substitui **valores de erro (ex: `-1`, `null`, `0`)** por **exceções**.

Métodos estáticos são comuns nesse contexto porque:

- Eles podem **verificar parâmetros** e lançar exceções sem precisar de um objeto.
- Tornam a validação centralizada.

Exemplo:

```java
public class TratamentoDeErro {

    public static void test(int valor) {
        if (valor == 0) {
            throw new IllegalArgumentException("Valor não pode ser zero!");
        }
        System.out.println("Valor válido: " + valor);
    }
}

```

Uso:

```java
public class Main {
    public static void main(String[] args) {
        TratamentoDeErro.test(0); // Lança exceção
    }
}

```

---


---
---

## TIPOS DE ERROS

- **Erro de compilação:** Ocorre quando o código não segue as regras da linguagem. É detectado **antes de executar** (ex.: sintaxe incorreta, tipo incompatível).
- **Erro de tempo de execução:** Acontece **enquanto o programa está rodando**, causando falhas ou exceções (ex.: divisão por zero, acessar índice inexistente).
- **Erro lógico:** O programa **compila e executa**, mas o **resultado está errado** por causa de uma lógica incorreta (ex.: fórmula errada).