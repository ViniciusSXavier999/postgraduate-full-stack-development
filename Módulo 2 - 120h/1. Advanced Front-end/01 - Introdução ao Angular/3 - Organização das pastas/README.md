# ORGANIZAÇÃO DE PASTAS

> Organizando pastas e criando os componentes que criei as rotas na aula passada.
> 

> É considerado que são pages todos os componentes que serão configurados no arquivo de rotas, exemplo: home, cadastro, o componente de HEADER não é considerado como uma página.
> 

> Eu vou criar um componente HOME e dentro dele eu posso criar sub componentes
> 

---

### Comando para gerar componentes no Angular

```
ng g c nomeComponent 
```

---

✅ O header e o footer não é considerado componente porque eles vão ser compartilhados dentro da aplicação


---

🏆 Dentro da arquitetura de componentes existem muitas coisas importantes, como por exemplo:

- A possibilidade de passar dados de uma rota para a outra
- Passar dados para um sub componente
- É possível passar informação do componente pai pro componente filho e vice e versa

> Se eu tiver um dado que eu precise utilizar no header, é possível essa informação para o header
> 