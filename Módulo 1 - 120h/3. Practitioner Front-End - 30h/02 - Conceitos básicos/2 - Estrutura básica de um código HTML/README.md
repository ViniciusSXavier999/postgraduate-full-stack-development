# ESTRUTURA BÁSICA DE UM CÓDIGO HTML

> atalho no vscode para gerar estrutura HTML ! + enter
> 

🏆 O HTML possui alguns elementos indispensáveis que toda página tem que ter para ser reconhecida pelo navegador como uma página HTML

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/3ba112f0-ff9f-452b-90da-b97c8122eae6/536794c0-69cb-4a1f-a0d6-7165c0d308cc/Untitled.png)

- DOCTYPE → Define que é um elemento HTML (Ele diz que o conteúdo da página está na versão 5 do HTML), ele é o DOCTYPE da versão do HTML 5, nas outras versões é um DOCTYPE bem maior

- HTML → Para dar início ao conteúdo da página HTML, abrimos a tag <html lang="pt-BR"> e todo o conteúdo da página deve estar entre sua abertura e seu fechamento </html>. Note que a *tag* possui o atributo  lang que deve conter o idioma do conteúdo da página, (importante para ajudar os motores de busca e navegadores a interpretar a página) neste caso, português do Brasil, cuja abreviação é pt-BR.

- HEAD(cabeça) → Este elemento é uma seção que deve conter dados sobre o documento HTML como título do documento, codificação dos caracteres, estilos, *scripts* e outras informações. O conteúdo que fica dentro desta *tag* não é exibido pelo navegador.

- BODY → (Todo o conteúdo visivel da página) A seguir, vamos abrir a tag <body>, que irá conter a estrutura do site.


---

## Conceitos dos elementos que fica dentro da head

- <meta charset="UTF-8"> . O atributo *charset* especifica a codificação de caracteres para o documento HTML. A especificação HTML5 incentiva a utilização do conjunto de caracteres *UTF-8*, que abrange quase todos os caracteres e símbolos do mundo.
    
    > UTF-8 → Interpreta qualquer idioma
    > 
- <meta name="viewport" content="width=device-width, initial-scale=1.0">. Esta meta tag viewport fornece ao navegador instruções sobre como controlar o dimensionamento da página quando acessada de diferentes tamanhos de dispositivos. O valor width=device-width do atributo content define que a largura da página deve seguir a largura do tamanho da tela do dispositivo. O valor initial-scale=1.0 define o nível de zoom inicial quando a página é carregada pela primeira vez pelo navegador, neste caso, 1.