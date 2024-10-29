class DispositivoEletronico {

    constructor(nome) {
        this.nome = nome
        this.ligado = false;
    }


    ligar()  {
        if(this.ligado){
            console.log("Já está ligado!")
            return
        } 
        this.ligado = true
    }


}

// CLASSE 2
class Smartphone extends DispositivoEletronico{

    constructor(nome, cor, modelo){
        // settando o constructor do DispositivoEletronico -> Atributo nome
        super(nome);
        this.cor = cor
        this.modelo = modelo
        
    }

}

// INSTANCIANDO 

var s1 = new Smartphone("Samsung", "Preto", "S29")
console.log(s1)

// A primeira vez que eu chamar não vai estar ligado
s1.ligar()

// Agora vai ligar oficialmente
s1.ligar()