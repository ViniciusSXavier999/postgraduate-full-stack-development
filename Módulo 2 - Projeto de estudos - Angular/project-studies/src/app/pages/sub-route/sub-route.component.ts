import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-sub-route',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './sub-route.component.html',
  styleUrl: './sub-route.component.css'
})
export class SubRouteComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {

  }

  /* O método navigate() do Angular é utilizado para fazer a navegação entre páginas de uma aplicação por meio de código. 
O Angular fornece um esquema de navegação e rotas, que permite que os usuários naveguem entre páginas da aplicação. A navegação pode ser feita:
Por meio de uma ação do usuário, como clicar em um link
Por meio de código, utilizando o método navigate()  */
  goToPage1() {
    this.router.navigate(['page1'], { relativeTo: this.route })
  }

  goToPage2() {
    this.router.navigate(['page2'], { relativeTo: this.route })
  }


}
