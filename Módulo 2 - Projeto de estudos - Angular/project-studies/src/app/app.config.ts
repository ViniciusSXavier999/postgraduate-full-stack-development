import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { provideHttpClient } from '@angular/common/http';
import { AutorizacaoService } from './services/autorizacao.service';
import { provideEnvironmentNgxMask } from 'ngx-mask';
import { UserService } from './services/user.service';
import { provideNativeDateAdapter } from '@angular/material/core';



export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes), 
    provideAnimationsAsync(),
    provideHttpClient(),
    provideEnvironmentNgxMask(),
    UserService,
    provideNativeDateAdapter()
  ]
};
