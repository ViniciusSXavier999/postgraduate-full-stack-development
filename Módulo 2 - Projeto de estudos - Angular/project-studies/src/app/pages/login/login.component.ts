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
  private fb = inject(FormBuilder);
  private autorizacaoService = inject(AutorizacaoService)

  // ao invés de addressForm eu posso colocar o nome que eu quiser
  addressForm = this.fb.group({
    
    email: [null, Validators.compose([
      Validators.required, Validators.minLength(5), Validators.maxLength(50)])
    ],
    password: ['', Validators.required]
  });

  

   
  loginClick() {
    if (this.autorizacaoService.obterLoginStatus()){
      this.autorizacaoService.deslogar()
    } else
      this.autorizacaoService.autorizar();
      }
    
  onSubmit(): void {
    this.loginClick()
    alert('Thanks!');
  }
}
