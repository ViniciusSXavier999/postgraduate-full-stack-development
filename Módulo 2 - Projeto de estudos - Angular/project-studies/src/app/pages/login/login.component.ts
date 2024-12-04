import { Component, inject } from '@angular/core';

import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { AutorizacaoService } from '../../services/autorizacao.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  standalone: true,
  imports: [
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    ReactiveFormsModule,
  ]
})
export class LoginComponent {
  /* O private fb significa que você está criando uma propriedade privada chamada fb (abreviação de FormBuilder), que irá armazenar a instância do FormBuilder injetado */
  private fb = inject(FormBuilder);
  private autorizacaoService = inject(AutorizacaoService)

  // ao invés de addressForm eu posso colocar o nome que eu quiser

  /* addressForm é uma variável que irá armazenar a instância do FormGroup, que é o tipo de estrutura para agrupar controles de formulário em Angular. */
  addressForm = this.fb.group({

    email: [null, Validators.compose([
      Validators.required, Validators.minLength(5), Validators.maxLength(50), Validators.email])
    ],
    password: ['', Validators.required]
  });


  email = this.addressForm.controls['email']

  // Estou verificando para mostrar na tela que o email não é valido
  getErrorMessage() {
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


  loginClick() {
    if (this.autorizacaoService.obterLoginStatus()) {
      this.autorizacaoService.deslogar()
    } else
      this.autorizacaoService.autorizar();
  }

  onSubmit(): void {
    this.loginClick()
    alert('Thanks!');
  }
}
