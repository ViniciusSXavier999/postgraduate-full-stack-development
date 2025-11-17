import User from "../models/User.js"

// FUNÇÃO QUE SALVA O USUÁRIO
async function saveUser(UserModel) {
    const save = await User.create(UserModel)
    return save
}

// FUNÇÃO QUE BUSCA TODOS USUÁRIOS 
async function getAllUsers() {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await User.findAll({
        order: [
            ['id', 'ASC']
        ]
    }) 
}

// FUNÇÃO QUE BUSCA USUÁRIO POR ID
async function getUserById(id) {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await User.findByPk(id) 
}


// FUNÇÃO QUE DELETA UM USUÁRIO
async function deleteUserById(id) {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await User.destroy({where: {id: id}}) 
}

// FUNÇÃO QUE ATUALIZA UM USUÁRIO
async function updateUserById(id, UserModel) {

    try {
        const result = await User.update(UserModel, {where: {id: id}})
        if (result[0]===1) {
            return {message: "User atualizado com sucesso!"}
        } else {
            return {message: "Não consigo encontrar a opção ${id} para atualizar", statu: 404}
        }
    } catch (error) {
        console.error()
    }
}


// fabrica de funções
const factory = {

    saveUser,
    getAllUsers,
    getUserById,
    deleteUserById,
    updateUserById

}

export default factory;