import { Component, inject, Injectable } from '@angular/core';
import {
  CanActivateFn,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
  Router,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AutorizacaoService } from '../services/autorizacao.service';


export const AutorizadoGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
):
  | Observable<boolean | UrlTree>
  | Promise<boolean | UrlTree>
  | boolean
  | UrlTree => {

    // INJETANDO O SERVICE
    const autorizadoService = inject(AutorizacaoService);

    // INJETANDO O ROUTER
    const router = inject(Router);

    // COLOCANDO EM UMA VARIAVEL PARA PODER FAZER A VERIFICAÇÃO
    const usuarioEstaLogado = autorizadoService.obterLoginStatus();


    if (usuarioEstaLogado) {
      return true;
    } else {
      router.navigate(["/login"]);  
      return false;
    }
};
















/*

import { Component, inject, Injectable } from '@angular/core';
import {
  CanActivateFn,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
  Router,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AutorizacaoService } from '../services/autorizacao.service';

@Injectable({ providedIn: 'root' })


export const AuthGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
):
  | Observable<boolean | UrlTree>
  | Promise<boolean | UrlTree>
  | boolean
  | UrlTree => {
    const autorizadoService = inject(AutorizacaoService);
    const usuarioEstaLogado = autorizadoService.obterLoginStatus();
    if (usuarioEstaLogado) {
      return true;
    else {
      this.routerService.navigate(["/login"]);  
      return false;
    }
} */