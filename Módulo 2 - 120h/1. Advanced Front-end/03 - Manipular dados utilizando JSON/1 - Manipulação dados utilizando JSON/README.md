# MANIPUAÇÃO DADOS UTILIZANDO JSON

## O QUE É O JSON?

🏆 É um tipo de objeto Javascript.

> É possível transforma-lo em um objeto comum, por exemplo:
> 
- Lista de usuário
- Lista de produtos

> A melhor forma de manipular dados no front end é utilizando json
> 

---

🏆 Quando estamos fazendo uma comunicação com uma REST API, por padrão utilizamos o JSON como formato de troca de dados


---

## PRECISAREMOS ADICIONAR DUAS LINHAS NO ARQUIVO TS.CONFIG.JSON POIS IREMOS CONSUMIR UM JSON DENTRO DO PRÓPRIO PROJETO

> Depois a gente vai consumir esse Json da API, vai manipular ele da API
> 

> Por enquanto vamos manipular ele localmente
> 

```json
"esModuleInterop": true,
"resolveJsonModule": true
```

## LOGO EM SEGUIDA VAMOS CRIAR UM COMPONENTE QUE VAI ESTAR MANIPULANDO O JSON

🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑

```powershell
 ng g c pages/manipulandoJson
```
🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑

## DEPOIS VAMOS IMPORTAR O ARQUIVO DO JSON NO NOSSO COMPONENT `MANIPULANDO-JSON.COMPONENT.TS` QUE VAMOS MANIPULAR

 
🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑
```tsx
import studentsData from '../../../students.json'
```
🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑🔑

## DEPOIS VAMOS CRIAR UMA INTERFACE QUE VAMOS UTILIZAR PARA GERAR UM OBJETO STUDENT

💡 É uma maneira mais simples de criar um objeto, no typescript é uma maneira simples de criar um objeto


## DEPOIS DE DESENVOLVER O HTML E O TYPESCRIPT PARA MOSTRAR OS DADOS PARA O USUÁRIO, VAMOS TER QUE FAZER A ROTA DESSE COMPONENT

> Tive que importar alguns módulos pois estava dando o seguinte erro “ The `*ngFor` directive was used in the template, but neither the `NgFor` directive nor the `CommonModule` was imported. Use Angular's built-in control flow @for or make sure that either the `NgFor` directive or the `CommonModule` is included in the `@Component.imports` array of this component. ”
> 

> Importei o CommonModule no `component manipulando-json.component.ts`
> 

💡  {path: 'json', component: ManipulandoJsonComponent}
