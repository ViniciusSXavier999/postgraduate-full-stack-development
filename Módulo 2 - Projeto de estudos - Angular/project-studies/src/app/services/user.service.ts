import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { UserAuth } from '../models/userAuth';
import { UserReturn } from '../models/userReturn';

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
 TOKEN_FIREBASE: string = 'AIzaSyAX06LYNcy0od0xCQkLPkXCXfLThK2oLv4' // minha chave da api key
 FIREBASE_URL: string = 'https://identitytoolkit.googleapis.com/'

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

  
  login(data: any): Observable<UserAuth>{
    console.log(data)
    var url: string = this.FIREBASE_URL + 'v1/accounts:signInWithPassword?key=' + this.TOKEN_FIREBASE
    console.log(url)
    return this.segurancaHttp.post<UserAuth>(url, data, httpOptions)
  }

  
  getUserById(): Observable<UserReturn> {
    let data = {idToken: localStorage.getItem('token') || ''}
    var url: string = this.FIREBASE_URL + 'v1/accounts:lookup?key=' + this.TOKEN_FIREBASE;
    return this.segurancaHttp.post<UserReturn>(url, data, httpOptions)
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
