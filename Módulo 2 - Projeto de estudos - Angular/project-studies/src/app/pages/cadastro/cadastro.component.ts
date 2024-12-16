import { Component, inject } from '@angular/core';

import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { User } from '../../models/user';
import { NgxMaskDirective, NgxMaskPipe } from 'ngx-mask';
import { GenericValidator } from '../../rulesCPF&CNPJ/validador';
import { UserService } from '../../services/user.service';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';


@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrl: './cadastro.component.css',
  standalone: true,
  imports: [
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    ReactiveFormsModule,
    NgxMaskDirective,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule

  ]
})
export class CadastroComponent {

  user: User = new User

  // DENTRO DO FORMBUILDER TEMOS OS VALORES DOS DADOS
  private fb = inject(FormBuilder);

  // INJETANDO SERVICE NO MEU COMPONENTE
  private service = inject(UserService)

  addressForm = this.fb.group({
    /* na nossa regra de negócio o nome vai ter no minimo 2 letras e no max 70 letras */
    firstName: [null, Validators.compose([Validators.required, Validators.minLength(2), Validators.maxLength(70)])],

    // APENAS TESTE PARA VER OS TIPOS DE VALIDAÇÕES
    // desc: [null, Validators.compose([Validators.required, Validators.minLength(2), Validators.maxLength(70)])],


    email: [null, Validators.compose([
      Validators.required, Validators.minLength(5), Validators.maxLength(50), Validators.email])
    ],
    phone: [null, Validators.required],

    dataNascimento: [null, Validators.required],

    cpf: [null, Validators.compose([Validators.required, GenericValidator.isValidCpf()])
    ],

    cep: [null, Validators.compose([Validators.required, GenericValidator.isValidCpf()])
    ],

    /* Se passarmos como "free" ele iria passar essa informação lá para o formulario dessa forma, mas não queremos desse jeito, por isso vamos colocar como "null" */
    password: [null, Validators.required]
  });


  email = this.addressForm.controls['email']

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

    //  this.user.id = '1'

    // Pegando os dados que meu usuário preencher no campo firstName e atribuindo a variavel do meu objeto user
    if (this.addressForm.controls['firstName'].value)
      this.user.firstName = this.addressForm.controls['firstName'].value

    if (this.addressForm.controls['email'].value)
      this.user.email = this.addressForm.controls['email'].value

    if (this.addressForm.controls['phone'].value)
      this.user.phone = this.addressForm.controls['phone'].value

    if (this.addressForm.controls['cpf'].value)
      this.user.cpf = this.addressForm.controls['cpf'].value

    if (this.addressForm.controls['password'].value)
      this.user.password = this.addressForm.controls['password'].value

    if (this.addressForm.controls['dataNascimento'].value)
      this.user.dateBirth = this.addressForm.controls['dataNascimento'].value

    // alert('Você cadastrou');
    console.log(this.user)

    // gravando no local storage e serializando o objeto
    // localStorage.setItem('user', JSON.stringify(this.user))

    // ADICIONANDO DADOS NA API DO JSON-SERVER db.json

    this.service.addUser(this.user).subscribe({  // O SUBSCRIBE É OBRIGÁTORIO EM UM OBSERVABLE
      next: (response) => {
        console.log(response)
        alert('Dado registrado com sucesso')
      },
      error: (erro: any) => { // error -> Tratamento de exceção do subscribe
        console.log(erro)
        alert('Ocorreu algum erro')
      }
    })
  }
}
