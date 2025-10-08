import { basename, dirname } from "path";

/* UM MÉTODO VAI FALAR O NOME DO DIRETÓRIO E O OUTRO O NOME DO ARQUIVO */

let nomeArquivo = basename('./teste.txt');
let fileName = basename('/teste/something')

let dir = dirname('/test/something')
let diretorio = dirname('/test/something/file.txt')

console.log('nome do arquivo -> ' + nomeArquivo)
console.log('fileName -> ' + fileName)
console.log('dir ->' + dir)
console.log('diretorio -> ' + diretorio)