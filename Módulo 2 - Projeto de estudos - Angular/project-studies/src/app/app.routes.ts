import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ListarComponent } from './pages/listar/listar.component';


export const routes: Routes = [
    {path:'', redirectTo: '/home', pathMatch: 'full'},
    
    // Ainda vou criar esse component
    {path:'home', component: HomeComponent},

     // Ainda vou criar esse component
    {path:'listar', component: ListarComponent}
];
