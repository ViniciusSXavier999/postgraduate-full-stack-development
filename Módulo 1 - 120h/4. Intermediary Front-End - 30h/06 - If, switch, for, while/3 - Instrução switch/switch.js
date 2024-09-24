// var expr = "Banana"

switch (expr = "Manga") {
    case "Laranja":
        console.log("A laranja custa R$0.59 o quilo")
        break

    case "Maçã":
        console.log("A Maçã custa R$0.32 o quilo")
        break

    case "Banana":
        console.log("Banana custa R$0.48 o quilo")
        break

    case "Cereja":
        console.log("Cereja custa R$3.00 o quilo")
        break

    case "Manga":
        console.log("Manga custa R$3.00 o quilo")
        

    case "Mamão":
        console.log("Mamão custa R$2.79 o quilo")
        break

        default:
        console.log("Desculpa, estamos sem nenhuma " + expr + ".")

}

console.log("Tem algo a mais que você gostaria de levar? ")