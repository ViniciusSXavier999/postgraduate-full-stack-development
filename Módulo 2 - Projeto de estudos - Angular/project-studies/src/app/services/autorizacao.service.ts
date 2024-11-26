import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AutorizacaoService {

  autorizado = false;

  constructor() { }

  // VAI CRIAR UMA FUNÇÃO PARA GRAVAR NO LOCALSTORAGE QUE ELE ESTÁ AUTORIZADO
  autorizar(){
    localStorage.setItem("login", "sim");
  }


  // VAI APAGAR AS INFORMAÇÕES QUE ESTÃO NO LOCALSATORAGE
  deslogar(){
    localStorage.clear();
  }

// ELE VERIFICA SE DENTRO DO LOCALSTORAGE TEM O "sim" passado na função autorizar
  obterLoginStatus = () => !!localStorage.getItem("login");

}
