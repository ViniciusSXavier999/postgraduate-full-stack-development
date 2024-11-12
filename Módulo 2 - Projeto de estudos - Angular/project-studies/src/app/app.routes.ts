import { Routes } from '@angular/router';


export const routes: Routes = [
    {path:'', redirectTo: '/home', pathMatch: 'full'},
    
    // Ainda vou criar esse component
    {path:'home', component: HomeComponent},

     // Ainda vou criar esse component
    {path:'cadastro', component: CadastroComponent}
];
