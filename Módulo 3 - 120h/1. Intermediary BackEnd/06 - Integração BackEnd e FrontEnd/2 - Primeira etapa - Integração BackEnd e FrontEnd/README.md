# 2 → PRIMEIRA ETAPA: INTEGRAÇÃO BACK-END E FRONT-END

### ESSA É UMA ESTRUTURA PADRÃO QUE A GENTE TEM PARA INTEGRAÇÃO DE UM SERVIÇO NO BACK-END.

### TODOS NOSSOS COMPONENTES VÃO TER ESSE SERVICE

### SERVICE COMPATÍVEL COM O SERVICE DO BACK-END

### PRÓXIMO PASSOS VAMOS FAZER COM QUE ESSES DADOS SEJAM EXIBIDOS DE FORMA CORRETA ATRAVÉS DO HTML

---

🏆 Nessa aula vamos aprender a completar os services da aplicação FrontEnd.

🏆 Quando criamos o comando de service para nossos componentes ele já vem com algumas informações já feitas.

```jsx
ng generate service .../caminho/...
```


---

### COURSE SERVICE

```jsx
import { ErrorHandler, Injectable } from '@angular/core';
import axios from 'axios';
import { AxiosInstance } from 'axios';

export interface Params {
    [key: string]: any;
}

export interface GetOptions {
    url: string;
    params?: Params;
    data?: any;
}

export interface ErrorResponse {
    id: string;
    code: string;
    message: string;
}

@Injectable({
    providedIn: 'root'
})
export class CourseService {

    private axiosClient: AxiosInstance;
    private errorHandler: ErrorHandler;

    constructor(errorHandler: ErrorHandler) {
        this.errorHandler = errorHandler;
        this.axiosClient = axios.create({
            timeout: 3000,
            headers: {
                "X-Initialized-At": Date.now().toString()

            }
        });
    }

    // get
    public async get<T> (options: GetOptions ) : Promise<T> {
        try {
            let axiosResponse = await this.axiosClient.request<T>({
                method: "get",
                url: options.url,
                params: options.params
            });
            return ( axiosResponse.data);
        } catch (error) {
            return ( Promise.reject( this.normalizeError (error)));
        }
    }

    // put
    public async put<T> (options: GetOptions ) : Promise<T> {
        try {
            let axiosResponse = await this.axiosClient.request<T>({
                method: "put",
                url: options.url,
                params: options.params,
                data: options.data
            });
            return ( axiosResponse.data);
        } catch (error) {
            return ( Promise.reject( this.normalizeError (error)));
        }
    }

    // post
    public async post<T> (options: GetOptions ) : Promise<T> {
        try {
            let axiosResponse = await this.axiosClient.request<T>({
                method: "post",
                url: options.url,
                params: options.params,
                data: options.data
            });
            return ( axiosResponse.data);
        } catch (error) {
            return ( Promise.reject( this.normalizeError (error)));
        }
    }

    // delete
    public async delete<T> (options: GetOptions ) : Promise<T> {
        try {
            let axiosResponse = await this.axiosClient.request<T>({
                method: "delete",
                url: options.url,
                params: options.params
            });
            return ( axiosResponse.data);
        } catch (error) {
            return ( Promise.reject( this.normalizeError (error)));
        }
    }

    // normalização de erros
    private normalizeError(error: any) : ErrorResponse {
        console.log('Error: ', error)
        this.errorHandler.handleError(error);

        return ({
            id: "-1",
            code: "UnkownError",
            message: "An unexpected error occurred."
        })
    }

}
```

🏆

### EXPLICAÇÃO DO CÓDIGO

# ✅ **1. IMPORTS**

```tsx
import { ErrorHandler, Injectable } from '@angular/core';
import axios from 'axios';
import { AxiosInstance } from 'axios';

```

### 📝 Explicação:

- `ErrorHandler` → classe do Angular usada para tratar erros globalmente.
- `Injectable` → indica que essa classe é um serviço e pode ser injetada em outros lugares.
- `axios` → biblioteca usada para fazer requisições HTTP.
- `AxiosInstance` → tipo do axios que representa uma instância configurada dele.

---

# ✅ **2. Interface Params**

```tsx
export interface Params {
    [key: string]: any;
}

```

### 📝 Explicação:

Essa interface define um **objeto com chaves dinâmicas**.

- `[key: string]` → permite qualquer nome de propriedade.
- `any` → permite qualquer tipo de valor.

Exemplos válidos usando essa interface:

```tsx
{ id: 10 }
{ name: "João", age: 22 }
{ q: "curso", page: 1 }

```

---

# ✅ **3. Interface GetOptions**

```tsx
export interface GetOptions {
    url: string;
    params?: Params;
    data?: any;
}

```

### 📝 Explicação:

Define os **dados necessários para fazer uma requisição**.

- `url` → obrigatório (ex: "/api/users")
- `params` → opcional (vai na URL)
- `data` → opcional (vai no corpo da requisição)

---

# ✅ **4. Interface ErrorResponse**

```tsx
export interface ErrorResponse {
    id: string;
    code: string;
    message: string;
}

```

### 📝 Explicação:

Define como será o objeto de erro “normalizado”.

Ou seja: quando o axios der erro, você transforma o erro em um **formato padrão**.

---

# ✅ **5. Decorator Injectable**

```tsx
@Injectable({
    providedIn: 'root'
})
export class CourseService {

```

### 📝 Explicação:

- `Injectable` → indica que esse serviço pode ser injetado em outros lugares do Angular.
- `providedIn: 'root'` → esse serviço fica disponível para toda a aplicação automaticamente.

---

# ✅ **6. Variáveis internas da classe**

```tsx
private axiosClient: AxiosInstance;
private errorHandler: ErrorHandler;

```

### 📝 Explicação:

- `axiosClient` → será a instância configurada do axios.
- `errorHandler` → guardará a ferramenta de tratar erros do Angular.

---

# ✅ **7. Constructor**

```tsx
constructor(errorHandler: ErrorHandler) {
    this.errorHandler = errorHandler;
    this.axiosClient = axios.create({
        timeout: 3000,
        headers: {
            "X-Initialized-At": Date.now().toString()
        }
    });
}

```

### 📝 Explicação:

### ✔️ Recebe o serviço de erro do Angular

`errorHandler: ErrorHandler`

O Angular injeta automaticamente um `ErrorHandler` dentro desse serviço.

### ✔️ Guarda o errorHandler dentro da classe

`this.errorHandler = errorHandler;`

Agora você pode usar ele dentro de qualquer método.

### ✔️ Cria uma instância personalizada do axios

`axios.create(...)`

Essa instância possui:

- **timeout: 3000** → se a requisição demorar mais de 3s, falha.
- **headers** → adiciona um cabeçalho padrão em toda requisição:
    
    `"X-Initialized-At": Data e hora atual.`
    

Ou seja: toda requisição enviada vai ter esse header adicional.

---

# 🔵 **Método GET**

```tsx
public async get<T> (options: GetOptions ) : Promise<T> {
    try {
        let axiosResponse = await this.axiosClient.request<T>({
            method: "get",
            url: options.url,
            params: options.params
        });
        return ( axiosResponse.data);
    } catch (error) {
        return ( Promise.reject( this.normalizeError (error)));
    }
}

```

### 📝 Explicação:

- Recebe as opções (`url`, `params`)
- Usa `this.axiosClient.request` para fazer a requisição GET
- `await` → espera o servidor responder
- `return axiosResponse.data` → retorna somente os dados

Se der erro:

- cai no `catch`
- chama `normalizeError(error)`
- devolve o erro padronizado

---

# 🔵 **Método PUT**

```tsx
public async put<T> (options: GetOptions ) : Promise<T> {
    try {
        let axiosResponse = await this.axiosClient.request<T>({
            method: "put",
            url: options.url,
            params: options.params,
            data: options.data
        });
        return ( axiosResponse.data);
    } catch (error) {
        return ( Promise.reject( this.normalizeError (error)));
    }
}

```

### 📝 Explicação:

É igual ao GET, mas com método `"put"`

E envia também o `data` no corpo da requisição.

---

# 🔵 **Método POST**

```tsx
public async post<T> (options: GetOptions ) : Promise<T> {
    try {
        let axiosResponse = await this.axiosClient.request<T>({
            method: "post",
            url: options.url,
            params: options.params,
            data: options.data
        });
        return ( axiosResponse.data);
    } catch (error) {
        return ( Promise.reject( this.normalizeError (error)));
    }
}

```

### 📝 Explicação:

Mesmo esquema, mas com `"post"`.

---

# 🔵 **Método DELETE**

```tsx
public async delete<T> (options: GetOptions ) : Promise<T> {
    try {
        let axiosResponse = await this.axiosClient.request<T>({
            method: "delete",
            url: options.url,
            params: options.params
        });
        return ( axiosResponse.data);
    } catch (error) {
        return ( Promise.reject( this.normalizeError (error)));
    }
}

```

### 📝 Explicação:

DELETE normalmente não usa corpo (`data`).

Envia apenas:

- `url`
- `params`

---

# 🔴 **Normalização de erros**

```tsx
private normalizeError(error: any) : ErrorResponse {
    console.log('Error: ', error)
    this.errorHandler.handleError(error);

    return ({
        id: "-1",
        code: "UnkownError",
        message: "An unexpected error occurred."
    })
}

```

### 📝 Explicação:

Esse método faz 3 coisas:

### ✔️ 1. Printa o erro no console

`console.log('Error: ', error)`

### ✔️ 2. Usa o tratador de erro do Angular

`this.errorHandler.handleError(error)`

Assim, o Angular registra o erro nos logs internos dele.

### ✔️ 3. Retorna um erro **padronizado**

```tsx
{
    id: "-1",
    code: "UnkownError",
    message: "An unexpected error occurred."
}

```

➡️ Essa é a grande vantagem:

**Todos os erros terão exatamente o mesmo formato**, independente de como o servidor respondeu.

---

# 🎉 **RESUMO FINAL EM LINGUAGEM LEIGA**

Esse serviço:

- permite fazer **GET, POST, PUT e DELETE** usando axios
- centraliza erros em um método único
- manda todas as requisições com o mesmo header
- tem timeout
- torna o código organizado e padronizado

> É como criar um super-telefone para conversar com a API, com regras e comportamentos iguais para todas as chamadas.
> 

---


---

---

### GET OPTIONS

🏆 VAMOS TER O TRATAMENTO DE BODY E PARAMETROS, TUDO QUE A GENTE PRECISA NA ESTRUTURA DE REQUISIÇÕES DE UMA TELA, ELA VAI TRAZER URL, PARAMETRO, DADOS, ALGUMA ENTRADA DE BODY QUE PRECISAR,  A GENTE VAI TER A INTERFACE:

- GET OPTIONS

### ERROR RESPONSE

🏆 Vai servir para o tratamento de erro, seja ela sucesso ou erro, essa interface implementa as respostas de erro:

- ErrorResponse

### AXIOS

🏆 Faz toda interação HTTP


---

💡 Vamos ter os métodos assíncronos que vai buscar os métodos no back-end, para cada caso que temos no back-end, precisamos ter um compatível no front-end.


---

### DIFERENÇA SINCRONO E ASSÍNCRONO

💡

# ✅ **SINCRONO**

> Faz uma coisa por vez.
> 
> 
> O código espera uma tarefa terminar para só então continuar.
> 

É como estar numa fila:

Você só anda quando a pessoa da frente termina.

### Exemplo:

```tsx
let x = funcaoDemorada(); // trava aqui até terminar
console.log("Terminou!");

```

Enquanto `funcaoDemorada()` não finalizar, **nada mais acontece**.

---

# ✅ **ASSINCRONO**

> Permite que o código continue executando enquanto uma tarefa lenta acontece em segundo plano.
> 

É como pedir comida num restaurante:

Você faz o pedido e continua conversando.

Quando a comida fica pronta, o garçom traz para você.

### Exemplo:

```tsx
async function teste() {
  let dados = await fetch("url"); // espera a resposta, mas não trava o sistema
  console.log(dados);
}

```

O programa **não trava** enquanto espera a resposta da API.

---

# 🧠 Comparação rápida

| Característica | Síncrono | Assíncrono |
| --- | --- | --- |
| Bloqueia o código | ✔️ Sim | ❌ Não |
| Faz uma coisa por vez | ✔️ Sim | ❌ Não |
| Ideal para operações lentas | ❌ Não | ✔️ Sim |
| Exemplo do mundo real | Fila de mercado | Pedido em restaurante |

---

# 🎉 Resumo máximo

- **Síncrono = trava e espera.**
- **Assíncrono = não trava e continua.**

---

### EXPLICANDO MÉTODO ESPECIFICO

```jsx
    private normalizeError(error: any) : ErrorResponse {
        console.log('Error: ', error)
        this.errorHandler.handleError(error);

        return ({
            id: "-1",
            code: "UnkownError",
            message: "An unexpected error occurred."
        })
    }

```

🏆

# ✅ **O código a ser explicado**

```tsx
private normalizeError(error: any) : ErrorResponse {
    console.log('Error: ', error)
    this.errorHandler.handleError(error);

    return ({
        id: "-1",
        code: "UnkownError",
        message: "An unexpected error occurred."
    })
}

```

---

# 🧩 **Explicação detalhada (com blocos de código)**

---

## 📌 **1. Assinatura do método**

```tsx
private normalizeError(error: any) : ErrorResponse {

```

- **private** → só pode ser chamado dentro da própria classe.
- **normalizeError** → nome do método.
- **(error: any)** → recebe qualquer tipo de erro.
- **: ErrorResponse** → sempre retorna um objeto nesse formato.

---

## 📌 **2. Logando o erro**

```tsx
console.log('Error: ', error)

```

Serve para **mostrar o erro no console** durante o desenvolvimento.

Assim, caso o erro venha cheio de informações, você consegue ver tudo.

Exemplo de saída:

```
Error:  { status: 500, message: "Internal error" }

```

---

## 📌 **3. Enviando o erro para um tratador global**

```tsx
this.errorHandler.handleError(error);

```

Aqui você **passa o erro para outro serviço** que provavelmente faz algo como:

- salvar o erro em logs
- exibir um alerta ao usuário
- mandar o erro para um sistema externo (Sentry, Datadog etc.)
- escrever o erro num arquivo
- gerar um toast na tela

Ou seja, o método **não resolve o erro aqui** — ele só **repassa para outro tratador**.

Exemplo ilustrativo de como pode ser o `ErrorHandler`:

```tsx
handleError(error: any) {
    console.error("Captured error: ", error);
    // poderia enviar para um serviço externo aqui
}

```

---

## 📌 **4. Retornando um erro padronizado**

```tsx
return ({
    id: "-1",
    code: "UnkownError",
    message: "An unexpected error occurred."
})

```

Aqui está a parte mais importante:

### 🔸 **Independente do erro REAL**, você sempre retorna **um objeto padrão**.

Por quê?

Porque erros podem vir de mil jeitos:

Axios:

```tsx
error.response.data

```

Fetch:

```tsx
throw new Error("something")

```

Servidor:

```json
{ "msg": "Deu ruim", "err_code": 500 }

```

JavaScript interno:

```tsx
TypeError: undefined is not a function

```

Para evitar bagunça, você normaliza:

👉 **Sempre retorna o mesmo formato**.

👉 **Facilita o tratamento do erro no frontend**.

👉 **Evita que diferenças entre Axios, Fetch ou HttpClient quebrem o sistema**.

---

# 🧠 **Resumo visual**

```
(erro vindo de qualquer lugar)
        ↓
console.log()
        ↓
this.errorHandler.handleError()
        ↓
retorna um erro organizado e padronizado

```

---

# 🟢 **Resumo final (super simples)**

Esse método:

✔ recebe um erro

✔ mostra no console

✔ chama um serviço para tratar/logar

✔ devolve um erro **sempre no mesmo formato**

É um **normalizador de erros**, usado para manter tudo organizado e consistente.

---

### ATENÇÃO!!!!!!!!! O QUE É OS “:”?

# ✅ **O que significam os dois pontos (`:`) no TypeScript?**

No TypeScript, os **dois pontos** servem para **tipar** alguma coisa.

No caso do método:

```tsx
private normalizeError(error: any) : ErrorResponse {

```

Os dois pontos aparecem **duas vezes**, e cada um tem um significado diferente:

---

# 🟦 **1. Tipando o parâmetro**

```tsx
(error: any)

```

Aqui, o `:` significa:

👉 **“o parâmetro error tem o tipo any”**

Exemplo:

```tsx
function soma(x: number, y: number) {

```

Significa:

- `x` deve ser um número
- `y` deve ser um número

---

# 🟩 **2. Tipando o retorno do método**

```tsx
: ErrorResponse {

```

Esse `:` significa:

👉 **“essa função vai retornar um objeto do tipo ErrorResponse”**

Ou seja, qualquer coisa que você retornar **precisa seguir a interface**:

```tsx
export interface ErrorResponse {
    id: string;
    code: string;
    message: string;
}

```

Então retornar algo assim é permitido:

```tsx
return {
    id: "-1",
    code: "UnkownError",
    message: "Something went wrong"
}

```

Mas isso NÃO seria permitido:

```tsx
return {
    status: 500,
    description: "OPS"
}

```

Porque não bate com a interface **ErrorResponse**.

---

# 🎯 **Resumo simples**

| Onde aparece | Significa |
| --- | --- |
| `error: any` | o parâmetro **error** tem tipo **any** |
| `): ErrorResponse` | a função **retorna** um **ErrorResponse** |

---

# 📌 Visualmente:

```
normaliza o erro | recebe um 'error' de ANY tipo | e vai retornar um ErrorResponse
        ↓                     ↓                               ↓
private normalizeError     (error: any)                : ErrorResponse {

```

---


> O handleError é uma propriedade do Angular e já tem alguns retornos por padrão.
> 

🏆 Toda função assíncrona precisa ter um try catch para caso ela não dê certo por algum motivo.

