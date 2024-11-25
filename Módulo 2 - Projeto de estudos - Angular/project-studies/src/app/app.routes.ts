import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ListarComponent } from './pages/listar/listar.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';
import { LoginComponent } from './pages/login/login.component';
import { ManipulandoJsonComponent } from './pages/manipulando-json/manipulando-json.component';
import { SubRouteComponent } from './pages/sub-route/sub-route.component';


export const routes: Routes = [
    {path:'', redirectTo: '/home', pathMatch: 'full'},
    
    
    {path:'home', component: HomeComponent},

    
    {path:'listar', component: ListarComponent},

    {path: 'cadastroo', component: CadastroComponent},

    {path: 'login', component: LoginComponent},

    {path: 'json', component: ManipulandoJsonComponent},

    {path: 'subroute', component: SubRouteComponent,

        children: [
            {path: 'page1', component: ManipulandoJsonComponent},
             {path: 'page2', component: ManipulandoJsonComponent}
        ]
    },
        
];
