# CRIAR FORMULÁRIOS COM RECURSOS AVANÇADOS

🏆 Vamos apenas realizar um teste através de um novo campo ‘CEP’ no nosso formGroup do Cadastro.component.ts


> Vamos supor que eu tenha esse CEP no meu formulário, após colocar esse CEP eu preciso que ele seja verificado lá na API do correios ou qualquer outra API de cep para saber se ele é valido.
> 

> Para isso eu criaria uma nova class no GenericValidator, igual fizemos com o CPF. À única diferença é que ao invés de criar uma lógica, eu faria uma requisição ao meu back-end (json-server), ai você poderia criar uma classe que se chame ‘ValidatorCep’ que vai retornar true ou false, e ai dentro da API você verificaria se o back-end está correto, se tiver o método trás os dados de CEP
> 

 > 🏆 Eu também poderia criar um campo no HTML que no momento da digitação do usuário informando o CEP, se disponibilizado um auto complete do CEP de acordo com o que o usuário digita
> 

🏆 É possível fazer uma busca no mapa

🏆 Trazer imagens junto com o CEP

🚨 Se for fazer upload de imagem utilizando o formato JSON, será necessário passar o formato para BASE64, o Angular tem uma biblioteca para isso


🚨 É possível também gravar a latitude e longitude da localização do usuário

