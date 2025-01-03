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
import { ListaSimplesComponent } from './pages/lista-simples/lista-simples.component';
import { EditarComponent } from './pages/editar/editar.component';
import { ModalComponent } from './pages/modal/modal.component';
import { UsuarioComponent } from './pages/usuario/usuario.component';


export const routes: Routes = [
    {path:'', redirectTo: '/home', pathMatch: 'full'},
    
    
    {path:'home', component: HomeComponent},

    
    {path:'listar', component: ListarComponent},

    {path:'listar-simples', component: ListaSimplesComponent}, // adicionando a rota da minha lista-simples

    {path: 'cadastroo', component: CadastroComponent},

    {path: 'login', component: LoginComponent},

    {path: 'modal', component: ModalComponent},

    {path: 'editar', component: EditarComponent},

    // Passando mais de duas informações na rota
    {path: 'detalhe/:id/:phone', component: DetalheComponent},

    {path: 'json', component: ManipulandoJsonComponent},

    {path: 'usuario', component: UsuarioComponent},

    {path: 'subroute', component: SubRouteComponent,

        children: [
            {path: 'page1', component: Page1Component},
             {path: 'page2', component: Page2Component}
        ]
    },

    
    {path: 'private', component: PrivateComponent,
        canActivate: [AutorizadoGuard]
    },

    {
        path: 'lazy-component',
        loadComponent: () => import('./pages/lazzy/lazzy.component').then(m => m.LazzyComponent)
      }
        
];
