import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ListarComponent } from './pages/listar/listar.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';
import { LoginComponent } from './pages/login/login.component';
import { ManipulandoJsonComponent } from './pages/manipulando-json/manipulando-json.component';
import { SubRouteComponent } from './pages/sub-route/sub-route.component';
import { Page1Component } from './pages/sub-route/page1/page1.component';
import { Page2Component } from './pages/sub-route/page2/page2.component';
import { PrivateComponent } from './pages/private/private.component';
import { AutorizadoGuard } from './guards/autorizado.guard';
import { DetalheComponent } from './pages/detalhe/detalhe.component';


export const routes: Routes = [
    {path:'', redirectTo: '/home', pathMatch: 'full'},
    
    
    {path:'home', component: HomeComponent},

    
    {path:'listar', component: ListarComponent},

    {path: 'cadastroo', component: CadastroComponent},

    {path: 'login', component: LoginComponent},

    // Eu tenho a rota e uma informação que eu quero passar
    {path: 'detalhe/:id', component: DetalheComponent},

    {path: 'json', component: ManipulandoJsonComponent},

    {path: 'subroute', component: SubRouteComponent,

        children: [
            {path: 'page1', component: Page1Component},
             {path: 'page2', component: Page2Component}
        ]
    },

    
    {path: 'private', component: PrivateComponent,
        canActivate: [AutorizadoGuard]
    },
        
];
