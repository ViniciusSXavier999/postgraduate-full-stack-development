import { Component, inject } from '@angular/core';

import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { User } from '../../models/user';

@Component({
  selector: 'app-editar',
  standalone: true,
  imports: [
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    ReactiveFormsModule
  ],
  templateUrl: './editar.component.html',
  styleUrl: './editar.component.css'
})
export class EditarComponent {

  // DENTRO DO FORMBUILDER TEMOS OS VALORES DOS DADOS
  private fb = inject(FormBuilder);
  user: User = new User();
  addressForm:any
  email: any
  
  constructor(){

    // PEGANDO O OBJETO
    if(localStorage.getItem('user')){
        // desserializando o objeto
        this.user = JSON.parse(localStorage.getItem('user') || '{}')
    }
    this.addressForm = this.fb.group({
      /* na nossa regra de negócio o nome vai ter no minimo 2 letras e no max 70 letras */
      // Ao inves de 'null' estamos dizendo que o formulario vai ter como dado de inicalização o valor que meu atributo do user receber
      firstName: [this.user.name, Validators.compose([Validators.required, Validators.minLength(2), Validators.maxLength(70)])],
      email: [this.user.email, Validators.compose([
        Validators.required, Validators.minLength(5), Validators.maxLength(50), Validators.email])
      ],
      phone: [this.user.phone, Validators.required],
      /* Se passarmos como "free" ele iria passar essa informação lá para o formulario dessa forma, mas não queremos desse jeito, por isso vamos colocar como "null" */
      password: [null, Validators.required]
    });

     
  this.email = this.addressForm.controls['email']

  }


  getErrorMessagee() {
    if (this.email.hasError('required')) {
      return 'O email é obrigatório'
    } else {
      if (this.email.hasError('email')) {
        return 'Você deve preencher um valor para o email válido!'
      }

      else {
        return '' // Caso não tenha erro, ele vai retornar vazio
      }
    }
  }

   
    
  onSubmit(): void {
    this.user.id = '1'

    // Pegando os dados que meu usuário preencher no campo firstName e atribuindo a variavel do meu objeto user
    if(this.addressForm.controls['firstName'].value)
      this.user.name = this.addressForm.controls['firstName'].value

    if(this.addressForm.controls['email'].value)
      this.user.email = this.addressForm.controls['email'].value

    if(this.addressForm.controls['phone'].value)
      this.user.phone = this.addressForm.controls['phone'].value

    if(this.addressForm.controls['password'].value)
      this.user.password = this.addressForm.controls['password'].value

    alert('Você cadastrou');
    console.log(this.user)

    // gravando no local storage e serializando o objeto
    localStorage.setItem('user', JSON.stringify(this.user))
  }

}
