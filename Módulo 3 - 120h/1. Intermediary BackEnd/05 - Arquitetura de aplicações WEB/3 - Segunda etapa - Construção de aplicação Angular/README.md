# 3 → SEGUNDA ETAPA: CONSTRUÇÃO DE APLICAÇÃO ANGULAR

💡 BAIXEI O PROJETO COMPLETO


🏆 Vamos revisar sobre os componentes que foi gerado pelo angular e também vamos fazer a adição das rotas nos nossos módulos de cada objeto da aplicação.


---

### MAPEANDO ROTAS

💡 O componente de routing modules do teacher precisa ter o mapeamento do list e do form, o mapeamento do form é o que vai fazer a integração na tela com a entrada de dados.


> A estrutura do front end precisa estar compatível com a integração que a gente está construindo do back-end (a estrutura básica de um crud)
> 

---

### TEACHER ROUTING MODULE

```jsx
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//Add esses imports
import {TeacherFormComponent} from "./teacher-form/teacher-form.component";
import {TeacherListComponent} from "./teacher-list/teacher-list.component";

//Alterar routes para adicionar as rotas /teachers e /addTeacher
const routes: Routes = [
  {
    path: 'teachers',
    component: TeacherListComponent
  },
  {
    path: 'addTeacher',
    component: TeacherFormComponent
  }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TeacherRoutingModule { }
```

### EVALUATION ROUTING MODULE

```jsx
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EvaluationListComponent } from './evaluation-list/evaluation-list.component';
import { EvaluationFormComponent } from './evaluation-form/evaluation-form.component';

const routes: Routes = [

  {
    path: 'evaluations',
    component: EvaluationListComponent
  },
  {
    path: 'addEvaluation',
    component: EvaluationFormComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EvaluationRoutingModule { }

```

### COURSE ROUTING MODULE

```jsx
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//Add esses imports
import {CourseFormComponent} from "./course-form/course-form.component";
import {CourseListComponent} from "./course-list/course-list.component";

//Alterar routes para adicionar as rotas /courses e /addCourse
const routes: Routes = [
  {
    path: 'courses',
    component: CourseListComponent
  },
  {
    path: 'addCourse',
    component: CourseFormComponent
  }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CourseRoutingModule { }
```

---

💡 Toda vez que você precisar fazer uma integração de back-end com front-end, você precisa lembrar que o objeto, rota que você criou no seu back-end ela precisa existir de forma compatível no front-end.


### USER MODULE TS

```jsx
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserRoutingModule} from "./user-routing.module";
import {SharedModule} from "../../shared/shared.module";
import { UserFormComponent } from './user-form/user-form.component';
import { UserListComponent } from './user-list/user-list.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    UserFormComponent,
    UserListComponent,
    //Modulo 7- Adicionar as 2 declarações abaixo
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    SharedModule,
    FormsModule,
  ]
})
export class UserModule { 

}
```

---

💡 Cada componente vai ter suas declarações de módulos especificas.

