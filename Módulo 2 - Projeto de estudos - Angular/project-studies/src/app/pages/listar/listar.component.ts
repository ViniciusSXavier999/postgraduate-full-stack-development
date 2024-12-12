import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatTableModule, MatTable, MatTableDataSource } from '@angular/material/table';
import { MatPaginatorModule, MatPaginator } from '@angular/material/paginator';
import { MatSortModule, MatSort } from '@angular/material/sort';
import { ListarDataSource, ListarItem } from './listar-datasource';
import { User } from '../../models/user';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.css',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, MatSortModule]
})
export class ListarComponent implements AfterViewInit, OnInit {

    
  constructor(private router: Router, public service: UserService) {
  }

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
//  @ViewChild(MatTable) table!: MatTable<ListarItem>;
  @ViewChild(MatTable, {static: false}) table!: MatTable<User>
  dataSource = new MatTableDataSource<User> ([])
  // dataSource = new ListarDataSource();

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns :string[] = ['id', 'firstName', 'email', 'phone', 'cpf'];

  ngOnInit(): void {
      this.buscaUsers()
  }

  buscaUsers(): void {

    this.service.getUsers().subscribe(
      {
        next: (resposta) => {
          this.dataSource = new MatTableDataSource<User> (resposta)
          this.dataSource.sort = this.sort
          this.dataSource.paginator = this.paginator
        },

        // Criação de exceção simples
        error: (erroo: any) => {
          alert('ocorreu algum erro')
          console.log(erroo)
        }
      }
    )
  }

  ngAfterViewInit(): void {
   // this.dataSource.sort = this.sort;
   // this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }
}


