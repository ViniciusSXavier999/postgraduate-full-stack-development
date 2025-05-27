# 1 → CONCEITOS DE SEGURANÇA COM SPRING

🏆 Vamos ver dicas muito importantes para todo desenvolvedor relacionada a segurança da aplicação.


🏆 O TERMO SEGURANÇA NO DESENVOLVIMENTO DE SOFTWARE É ESSENCIAL NOS DIAS DE HOJE E DIRIA QUE OBRIGATÓRIO. HÁ VÁRIOS FATOES QUE DEVEMOS CONSIDERAR.

> Você já deve ter ouvido falar em ataques á webSites, dados vazados de clientes
> 

### QUANDO VAMOS DESENVOLVER UMA APLICAÇÃO, PARA MANTERMOS A APLICAÇÃO SEGURA, TEMOS QUE TER EM MENTE ALGUNS FATORES, SÃO ELES:

- O tipo de API, se ela é pública ou privada (mesmo API publica, ela precisa ter segurança, nem que seja um limitador de requests.)
- Quão sensíveis são os dados usados pela API (exemplo: cartões de banco, transferência de dinheiro, login e senha)
- Os métodos de autenticação, restrição e acesso.
- O tipo de comunicação https. (O recomendado é sempre utilizar HTTPS)
- Não expor informações na url (Exemplo: expor login e senha na URL)
- A infraestrutura, servidores e certificados ssl/tls, entre outros

🏆 Ao mesmo tempo que precisamos implementar os métodos de segurança, devemos pensar também na performance, complexidade e facilidade de uso da API, o que torna essa etapa do desenvolvimento complexa.


---

### VAMOS APRENDER 3 FORMAS DE TRAZER MAIS SEGURANÇA PARA NOSSA API RESTFULL:

- SPRING SECURITY
- PROTOCOLO 0auth
- AUTENTICAÇÃO JWT (JASON WEB TOKEN)