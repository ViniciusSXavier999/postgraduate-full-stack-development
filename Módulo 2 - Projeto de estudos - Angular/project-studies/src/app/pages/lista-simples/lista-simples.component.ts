import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-lista-simples',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './lista-simples.component.html',
  styleUrl: './lista-simples.component.css'
})
export class ListaSimplesComponent implements OnInit {

  constructor(private router: Router, public service: UserService) {
  }

  // CRIANDO ARRAY DE USUARIOS
  users: User[] = []


  ngOnInit(): void {
    // Estou chamando meu método buscaUser
    this.buscaUser()
  }

  buscaUser(): void {

    this.service.getUsers().subscribe(
      {
        next: (resposta) => {
          console.log(resposta)
          this.users = resposta
        },

        // Criação de exceção simples
        error: (erro: any) => {
          console.log('ocorreu algum erro')
          console.log(erro)
        }
      }
    )
  }

  // Vamos passar mais de uma informação na rota
  goToDetail(user: User){
    this.router.navigate(['detalhe', user.id])
  }



}
