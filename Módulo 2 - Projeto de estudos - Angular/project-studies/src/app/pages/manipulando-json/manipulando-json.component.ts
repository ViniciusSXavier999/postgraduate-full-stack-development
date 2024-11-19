import { Component, OnInit } from '@angular/core';
import studentsData from '../../../students.json'
import { CommonModule } from '@angular/common';

// Dados do objeto
interface Student {
  id: Number;
  name: String;
  email: String;
  gender: String;
}

@Component({
  selector: 'app-manipulando-json',
  standalone: true,
  imports: [CommonModule ],
  templateUrl: './manipulando-json.component.html',
  styleUrl: './manipulando-json.component.css'
})

export class ManipulandoJsonComponent implements OnInit {

  // Criando um array de objeto student
  students: Student[] = studentsData;

  constructor(){}
  
  ngOnInit(): void {

    // vamos mostrar que realmente estamos pegando esses dados

    /* Ele vai pegar a lista e transformar para um array de objetos do tipo student e vai mostrar esses dados na tela  */
    console.log(this.students)
      
  }


}
