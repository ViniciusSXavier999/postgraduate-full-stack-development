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
  BASE_URL: string = 'http://localhost:3000/';
  FIREBASE_URL: string = ''

  // trazendo o HTTP para o service
  constructor(private segurancaHttp: HttpClient) { }


  // vou realizar o CRUD AGORA

  // GET -> Buscar
 //  POST -> ler
//   PUT -> Atualizar
//   DELETE -> Deletar

  // MÉTODO GET
  getUsers(): Observable<User[]>{ // vai ser um array de usuários
    return this.segurancaHttp.get<User[]>(this.BASE_URL + 'users') // Aqui basicamente estou montando a URL e utilizando a concatenação
  }

  login(data:any): Observable<User>{
    return this.segurancaHttp.post<User>(this.FIREBASE_URL + 'users', data, httpOptions)
  }

  // MÉTODO POST -> CRIAR FUNÇÃO PARA ADICIONAR USER 

  /* Se eu adicionar um usuário por padrão ele retorna o próprio usuário que eu criei */
  addUser(user:any): Observable<User>{
    return this.segurancaHttp.post<User>(this.BASE_URL + 'users', user, httpOptions)
  }


  // MÉTODO PUT -> ATUALIZAR
  editUser(user:any): Observable<User>{
    let url: string = this.BASE_URL + 'users/' + user.id // Estamos dizendo basicamente isso aqui -> 'http://localhost:3000/users/2'
    return this.segurancaHttp.post<User>(url, user, httpOptions)
  }

  // MÉTODO DELETE -> EXCLUI
  deleteUser(user:any): Observable<User>{
    let url: string = this.BASE_URL + 'users/' + user.id // Estamos dizendo basicamente isso aqui -> 'http://localhost:3000/users/2'
    return this.segurancaHttp.post<User>(url, httpOptions)
  }
}
