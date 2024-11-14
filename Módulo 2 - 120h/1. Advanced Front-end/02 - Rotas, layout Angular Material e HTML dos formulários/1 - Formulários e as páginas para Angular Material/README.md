# ROTAS, LAYOUT ANGULAR MATERIAL E HTML DOS FORMULÁRIOS

📌 NGMODULE NÃO EXISTE MAIS NO ANGULAR 17, pois os componentes se tornaram independentes com o standalone

[SRTACK OVER FLOW - APP MODDULE DEIXOU DE EXISTIR NO ANGULAR 17](https://stackoverflow.com/questions/77454741/why-doesnt-app-module-exist-in-angular-17)

---

## O QUE É O ANGULAR MATERIAL?

🏆 Angular Material

**é uma biblioteca de componentes do Angular que oferece uma coleção de elementos de interface do usuário** (IU). Ele é uma implementação do Material Design, uma abordagem de design do Google que se concentra na usabilidade e na criação de interfaces modernas.

**O Angular Material é composto por:**

- Componentes prontos para uso, como botões, caixas de diálogo, tabelas, calendários, inputs, sliders e ícones
- Bibliotecas CSS
- Outros elementos
- É uma biblioteca de componentes prontos


✅ [Documentação do Angular material](https://material.angular.io/)

---

> Pode se dizer que é um framework de layout, denominado Angular material
> 

> Também existe outros parecidos, um dos mais conhecidos é o bootstrap.
> 

> IONIC
> 

---

✅ Mobile firts → Significa que a aplicação será responsiva para qualquer tipo de disposto 


---

🏆 Cada componente do angular material, é necessário fazer a importação desse componente principal no Module do Angular


---

## INSTALAÇÃO DO ANGULAR MATERIAL

[Angular Material](https://material.angular.io/guide/getting-started)

### Comando para instalar o Angular Material no projeto

```
ng add @angular/material
```

> Caso queira instalar outra biblioteca que é a o cdk, utilize o comando:
> 

!! Por padrão essa biblioteca já é instalada automaticamente junto do angular/material !! 

```
ng add @angular/cdk
```

---

## O QUE É O CDK?

🏆 O Component Dev Kit (CDK) do Angular é um

**conjunto de ferramentas que implementa padrões de interação comuns, sem se posicionar sobre a aparência dos elementos visuais**

:

- Fornece rolagem virtual, melhorando o desempenho e a capacidade de resposta da página
- Implementa comportamentos comuns, como Drag and Drop, sem opinar sobre a aparência dos elementos visuais
- É uma abstração das funcionalidades principais da biblioteca Angular Material, sem nenhum estilo específico do Material Design

---

📌 Agora vou gerar um schematics, o que é isso?

- Ele é um comando do Angular Material que vai gerar uma página de cadastro ou uma tabela com paginação que a gente vai utilizar ou um menu de navegação

### Comando:

```
ng generate @angular/material:address-form <component-name>
```


> Existe diversos tipos de comandos para gerar componentes já prontos.
>