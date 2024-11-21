import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';

const httpOptions = {

  // atributo e valor
  headers: new HttpHeaders({'content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // url onde vou fazer a requisição
  BASE_URL: string = 'http://localhost:3000';

  // trazendo o HTTP para o service
  constructor(private segurancaHttp: HttpClient) { }


  // vou realizar o CRUD AGORA

  // GET -> Buscar
 //  POST -> ler
//   PUT -> Atualizar
//   DELETE -> Deletar

  // Começando pelo GET
  getUsers(): Observable<User[]>{ // vai ser um array de usuários
    return this.segurancaHttp.get<User[]>(this.BASE_URL + 'users') // Aqui basicamente estou montando a URL e utilizando a concatenação
  }

  // CRIAR FUNÇÃO PARA ADICIONAR USER

  /* Se eu adicionar um usuário por padrão ele retorna o próprio usuário que eu criei */
  addUser(user:any): Observable<User>{
    return this.segurancaHttp.post<User>(this.BASE_URL + 'users', user, httpOptions)
  }
}
