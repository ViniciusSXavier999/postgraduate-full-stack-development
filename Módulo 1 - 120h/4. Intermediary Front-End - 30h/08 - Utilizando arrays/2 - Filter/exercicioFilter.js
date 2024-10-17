/* Imagina que você tenha uma lista de eletrodomestico, e trazer somente a categoria eletronico  */

var eletrodomestico = [

    {id: 1, descricao: "TV", categoria: "Eletronico"},
    {id: 2, descricao: "SmartPhone", categoria: "Eletronico"},
    {id: 3, descricao: "Notbook", categoria: "Eletronico"},
    {id: 4, descricao: "Geladeira", categoria: "Eletrodomestico"},

]

var filtroEletronico = eletrodomestico.filter(
    function(valor) {
        return valor.categoria == "Eletronico"
    }
)

console.log(filtroEletronico)