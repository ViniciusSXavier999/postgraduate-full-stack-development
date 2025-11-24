# 4 → TERCEIRA ETAPA: INTEGRAÇÃO BACK-END E FRONT-END

🏆 Agora vamos olhar para o tratamento dos dados na tela, vamos criar o ts do list dos nossos componentes.

🏆 Agora vamos deixar compatível o tratamento dos dados que vão vir do BackEnd.

🏆 Vamos agora realizar a integração com o back end da nossa list.


---

### CÓDIGO DO TEACHER-LIST.COMPONENT.TS

```jsx
//Add esses imports
import { Component, OnInit } from '@angular/core';
import { faPencil, faTrash } from '@fortawesome/free-solid-svg-icons';
import { SharedService } from 'src/app/shared/shared.service';
import { TeacherService } from '../teacher.service';
@Component({
  selector: 'app-teacher-list',
  templateUrl: './teacher-list.component.html',
  styleUrls: ['./teacher-list.component.scss']
})
export class TeacherListComponent implements OnInit {
  faPencil = faPencil;
  faTrash = faTrash;

  courseLabel: Array<{ value: string, label: string }> = [];
  teachers: any[] = [];

  constructor(private teacherService: TeacherService, private sharedService: SharedService) { }

  async ngOnInit(): Promise<void> {
    await this.listTeachers();
    this.sharedService.getCourses().subscribe(course => this.courseLabel = course);

  }

  async listTeachers(): Promise<void> {
    this.teachers = await this.teacherService.get<any[]>({
      url: "http://localhost:3000/getAllTeachers",
      params: {

      }
    });
  }

  async delete(id: number): Promise<void> {
    if (confirm("Deseja deletar este professor?")) {
      await this.teacherService.delete<any>({
        url: `http://localhost:3000/deleteTeacher/${id}`,
        params: {

        }
      });
      await this.listTeachers();
    }
  }

  onConfirm(value: any) {
    alert("Value:" + value);
  }
}
```

### EXPLICAÇÃO DO CÓDIGO

🏆

# ✅ **TeacherListComponent — Explicação linha por linha**

---

## **📌 IMPORTS**

```tsx
import { Component, OnInit } from '@angular/core';
import { faPencil, faTrash } from '@fortawesome/free-solid-svg-icons';
import { SharedService } from 'src/app/shared/shared.service';
import { TeacherService } from '../teacher.service';

```

### **Explicação**

- `Component` e `OnInit` → vêm do Angular.
    - `Component` marca essa classe como um componente de tela.
    - `OnInit` permite usar o método `ngOnInit()` (executa algo assim que o componente abre).
- `faPencil`, `faTrash` → são ícones do FontAwesome (ícone de lápis e lixo).
- `SharedService` → um service que fornece dados compartilhados, provavelmente lista de cursos.
- `TeacherService` → o service responsável por acessar o backend e buscar professores.

---

## **📌 DECORAÇÃO DO COMPONENTE**

```tsx
@Component({
  selector: 'app-teacher-list',
  templateUrl: './teacher-list.component.html',
  styleUrls: ['./teacher-list.component.scss']
})

```

### **Explicação**

- `selector` → nome da tag HTML usada para mostrar esse componente.
    
    Exemplo: `<app-teacher-list></app-teacher-list>`
    
- `templateUrl` → arquivo HTML dessa tela.
- `styleUrls` → arquivo CSS dessa tela.

---

## **📌 DECLARAÇÃO DA CLASSE**

```tsx
export class TeacherListComponent implements OnInit {

```

### Explicação

- Marca a classe como um **componente Angular**.
- `implements OnInit` → significa que ela possui o método `ngOnInit()`.

---

## **📌 PROPRIEDADES DO COMPONENTE**

```tsx
faPencil = faPencil;
faTrash = faTrash;

```

### Explicação

- Aqui apenas são atribuídos os ícones às variáveis para serem usados no HTML.

---

```tsx
courseLabel: Array<{ value: string, label: string }> = [];

```

### Explicação

- É uma lista de objetos com `{value, label}`.
- Provavelmente usada como **label do curso** (ex: “Curso de Inglês”).

---

```tsx
teachers: any[] = [];

```

### Explicação

- Lista de professores que será carregada do backend.

---

## **📌 CONSTRUTOR**

```tsx
constructor(private teacherService: TeacherService, private sharedService: SharedService) { }

```

### Explicação

- O Angular injeta (entrega automaticamente) dois serviços:
    - `teacherService` → para buscar professores no backend.
    - `sharedService` → provavelmente para buscar a lista de cursos.
- O `private` faz essas variáveis virarem propriedades internas da classe automaticamente.

---

## **📌 ngOnInit() — executa ao abrir a tela**

```tsx
async ngOnInit(): Promise<void> {
  await this.listTeachers();
  this.sharedService.getCourses().subscribe(course => this.courseLabel = course);
}

```

### Explicação

### **1️⃣ `await this.listTeachers()`**

- Chama o método que busca todos os professores no backend.
- Ou seja: *quando a tela abre, ela já traz a lista pronta*.

### **2️⃣ `sharedService.getCourses().subscribe(...)`**

- `getCourses()` retorna um Observable, então é necessário `subscribe()`.
- Cada vez que o service retornar a lista de cursos, a propriedade `courseLabel` é atualizada.

---

## **📌 listTeachers() — busca todos os professores**

```tsx
async listTeachers(): Promise<void> {
  this.teachers = await this.teacherService.get<any[]>({
    url: "http://localhost:3000/getAllTeachers",
    params: {

    }
  });
}

```

### Explicação

- Chama o `TeacherService.get()` passando a URL do backend.
- O resultado vem como lista (`any[]`) e é guardado em `this.teachers`.
- Essa lista depois é usada no HTML para mostrar os professores na tabela.

---

## **📌 delete() — apaga professor**

```tsx
async delete(id: number): Promise<void> {
  if (confirm("Deseja deletar este professor?")) {
    await this.teacherService.delete<any>({
      url: `http://localhost:3000/deleteTeacher/${id}`,
      params: {

      }
    });
    await this.listTeachers();
  }
}

```

### Explicação passo a passo

1. Abre um `confirm()` para o usuário confirmar.
2. Se ele confirmar:
    - chama o serviço `teacherService.delete()`, enviando o ID.
3. Depois recarrega a lista chamando `this.listTeachers()` de novo.

Ou seja:

🔄 **apaga → refaz a consulta → atualiza a tabela.**

---

## **📌 onConfirm() — apenas exibe um alerta**

```tsx
onConfirm(value: any) {
  alert("Value:" + value);
}

```

### Explicação

- Função genérica.
- Apenas mostra um alerta. Não tem ligação direta com CRUD.

---

# 🎯 **QUAL O PAPEL DO `TeacherListComponent` NO SISTEMA?**

Esse componente é responsável por:

### ✔️ Exibir todos os professores cadastrados

(carregados do backend)

### ✔️ Mostrar uma tabela/lista com esses professores

(usando os ícones de editar e excluir)

### ✔️ Permitir deletar professores

(confirmando antes)

### ✔️ Carregar rótulos/nomes de cursos

(usando o SharedService)

### ✔️ Ser a "tela principal" de gerenciamento

É a *página de listagem*, que normalmente acompanha:

- Tela de formulário (teacher-form)
- Tela de visualização (opcional)
- Tela de edição (teacher-form também)

---


---

---

🏆 As conversões de curso: chave e valor vão ser feitas somente nas outras telas, porque as outras telas tem apenas o id de curso, e na tela de curso vamos ter todas as informações relacionadas aos cursos

