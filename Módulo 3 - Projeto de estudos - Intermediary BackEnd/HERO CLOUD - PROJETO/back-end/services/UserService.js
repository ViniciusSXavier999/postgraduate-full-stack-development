import userRepository from "../repositories/UserRepository.js"

// Função que salva o usuário no banco de dados
function saveUser(userModel) {
    return userRepository.saveUser(userModel);
}

// Buscando usuário pelo id
function getUserById(id) {
    return userRepository.getUserById(id);
}

// função que busca todos usuários 
function getAllUsers() {
    return userRepository.getAllUsers();
}

// Método que deleta um User
function deleteUserById(id) {
    return userRepository.deleteUserById(id);
}

// Método que atualiza um User
function updateUserById(id, userModel) {
    return userRepository.updateUserById(id, userModel);
}


const service = {
    /* Todo método que você fizer no seu service é necessário expor para que ele seja visto por outros pacotes */
    saveUser,
    getUserById,
    getAllUsers,
    deleteUserById,
    updateUserById
}

export default service; 