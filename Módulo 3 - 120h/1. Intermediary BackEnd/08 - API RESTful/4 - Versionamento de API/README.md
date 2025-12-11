# 4 → VERSIONAMENTO DE API

🏆 VAMOS UTILIZAR O POSTMAN PARA EXEMPLIFICAR O VERSIONAMENTO DE API


---

🏆 versionamento de API é uma questão extremamente polemica entre os desenvolvedores, porque você não tem um padrão para versionar a API, não existe uma regra ou uma boa pratica, é completamente livre, você pode colocar no inicio da sua url ou no fim, você escolhe e seu time escolhe onde vai achar melhor.

🏆 É importante mencionar quando se trata de versionamento de API: 

- Estejam alinhados de qual versão do serviço que vocês vão utilizar, exemplo:
    - Você vai usar uma API do google para fazer uma consulta do google maps, eles tem uma API pública, usa a versão X e o seu colega tem que usar a versão X também.
    - Caso você esteja disponibilizando um serviço, igual esse por exemplo, avise no setup que é a versão 0, 2, 3,.
- o FRONT END precisa estar avisado de qual versão será utilizada, porque se você atualizar apenas a versão do back end você vai quebrar a aplicação.

🏆

Se a gente tivesse versionamento nessa api, TERIAMOS A SEGUINTE URL lá no arquivo `user-form.component.ts`: 

```tsx
`http://localhost:3000/v1/updateUser/${this.model?.id}`
```

### URL SEM O VERSIONAMENTO

```tsx
`http://localhost:3000/updateUser/${this.model?.id}`
```


🏆 Também é necessário olhar para o mapeamento dos endpoints no back-end, PODEMOS TER ENDPOINTS EM VERSÕES DIFERENTES, NÃO É NECESSÁRIO TER UMA APLICAÇÃO INTEIRA COM UMA VERSÃO DIFERENTE.

🏆 Você tem que ter um alinhamento de saber qual o tamanho da funcionalidade que faz gerar uma nova versão.

🏆 Também é possível passar o versionamento da API pelo headers no user.service


🏆 Para testar uma versão especifica da API, podemos utilizar o postman

🏆 Para fazer o versionamento você precisa sempre estar alinhado com o seu projeto, processos e os desenvolvedores do seu time.

💡 O versionamento também vai estar no arquivo packagelock tanto no node, como também no Angular.

