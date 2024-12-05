import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-detalhe',
  standalone: true,
  imports: [],
  templateUrl: './detalhe.component.html',
  styleUrl: './detalhe.component.css'
})
export class DetalheComponent implements OnInit{

  constructor(private route: ActivatedRoute){

  }

  identificador: number = 0
  phonee: string = ''

  ngOnInit(): void {

    // METODO PARA PEGAR OS PARAMETROS DA ROTA

    // por que o forEach()? porque se você tiver mais de um parametro.
    // ele pode passar mais de um parametro
      this.route.params.forEach((params: Params)=>{ // Aqui temos um arrow function
        if(params['id'] !== undefined){ // O operador !== em JavaScript é um operador de comparação que verifica se dois valores são diferentes e retorna true se forem, ou false se forem iguais.
          this.identificador =+ params['idd']
          console.log(this.identificador)
        }

        // realizando a verificação do phone
        if(params['phone'] !== undefined){ 
          this.phonee = params['phone']
          console.log(this.phonee) // o console.log printa na tela do console do navegador as informações
        }
      })
  }

}
