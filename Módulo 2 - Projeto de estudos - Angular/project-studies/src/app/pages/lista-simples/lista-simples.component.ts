import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { CommonModule } from '@angular/common';
import { MatButton } from '@angular/material/button';

@Component({
  selector: 'app-lista-simples',
  standalone: true,
  imports: [CommonModule, MatButton],
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

    /* AQUI ESTOU CHAMANDO MEU METODO QUE TRARA TODOS OS DADOS PARA MIM APÓS A RENDERIZAÇÃO DA PAGINA */
    this.buscaUser()
  }

  // Através desse método estou me inscrevendo nele através do subscribe e retornando next ou error que são funcionanlidades do subscribe
  buscaUser(): void {

    this.service.getUsers().subscribe(
      {
        next: (resposta) => {
          console.log(resposta)
          this.users = resposta
        },

        // Criação de exceção simples
        error: (erroo: any) => {
          alert('ocorreu algum erro')
          console.log(erroo)
        }
      }
    )
  }

  // Vamos passar mais de uma informação na rota
  goToDetail(user: User){
    this.router.navigate(['detalhe', user.id, user.phone]) // vamos passar esses dois dados na rota
  }



}
