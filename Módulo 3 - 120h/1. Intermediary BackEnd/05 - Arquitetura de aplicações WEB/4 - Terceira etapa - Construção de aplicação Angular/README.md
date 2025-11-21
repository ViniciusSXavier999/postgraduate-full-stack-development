# 4 → TERCEIRA ETAPA: CONSTRUÇÃO DE APLICAÇÃO ANGULAR

🏆 VAMOS PEGAR O HTML DO USER E REPLICAR PARA OS DEMAIS COMPONENTES DA NOSSA APLICAÇÃO 

🏆

### VAMOS REPLICAR ESSAS INFORMAÇÕES PARA OS OUTROS COMPONENTES

```jsx
import { Component } from '@angular/core';

//add esses imports
import { FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FormlyFieldConfig } from '@ngx-formly/core';
import { SharedService } from 'src/app/shared/shared.service';
import { TeacherService } from '../teacher.service';

@Component({
  selector: 'app-teacher-form',
  templateUrl: './teacher-form.component.html',
  styleUrls: ['./teacher-form.component.scss']
})
export class TeacherFormComponent {
  teacher: any = {};
  form = new FormGroup({});
  model: any = {};

  fields: FormlyFieldConfig[] = [
    {
      className: 'd-flex align-content-center justify-content-center',
      fieldGroupClassName: 'row',
      fieldGroup: [
        {
          key: 'name',
          type: 'input',
          props: {
            label: 'Nome',
            placeholder: 'Nome do Professor',
            required: true,
          },
        },
        {
          key: 'course_id',
          type: 'input',
          props: {
            label: 'Id do Curso',
            placeholder: 'Número do curso',
            required: true
          },
        }
      ]
    }
  ];
```

🏆 Daqui pra frente vamos começar a implementar método que geram ação na nossa tela e que geram a integração com o back-end

