import { Component, inject } from '@angular/core';

import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';


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
    ReactiveFormsModule
  ]
})
export class CadastroComponent {
  private fb = inject(FormBuilder);


  addressForm = this.fb.group({
    /* na nossa regra de negócio o nome vai ter no minimo 2 letras e no max 70 letras */
    firstName: [null, Validators.compose([Validators.required, Validators.minLength(2), Validators.maxLength(70)])],
    email: [null, Validators.required],
    phone: [null, Validators.required],
    /* Se passarmos como "free" ele iria passar essa informação lá para o formulario dessa forma, mas não queremos desse jeito, por isso vamos colocar como "null" */
    password: [null, Validators.required]
  });

  
  onSubmit(): void {
    alert('Entrou no onSubmit');
  }
}
