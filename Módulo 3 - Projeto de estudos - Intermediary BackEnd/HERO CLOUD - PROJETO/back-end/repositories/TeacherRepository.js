import Teacher from "../models/Teacher.js"

// FUNÇÃO QUE SALVA O USUÁRIO
async function saveTeacher(TeacherModel) {
    const save = await Teacher.create(TeacherModel)
    return save
}

// FUNÇÃO QUE BUSCA TODOS USUÁRIOS 
async function getAllTeachers() {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await Teacher.findAll({
        order: [
            ['id', 'ASC']
        ]
    })
}

// FUNÇÃO QUE BUSCA USUÁRIO POR ID
async function getTeacherById(id) {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await Teacher.findByPk(id)
}


// FUNÇÃO QUE DELETA UM USUÁRIO
async function deleteTeacherById(id) {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await Teacher.destroy({ where: { id: id } })
}

// FUNÇÃO QUE ATUALIZA UM USUÁRIO
async function updateTeacherById(id, TeacherModel) {

    try {
        const result = await Teacher.update(TeacherModel, { where: { id: id } })
        if (result[0] === 1) {
            return { message: "Teacher atualizado com sucesso!" }
        } else {
            return { message: "Não consigo encontrar a opção ${id} para atualizar" }
        }
    } catch (error) {
        console.error()
    }
}

// fabrica de funções
const factory = {

    saveTeacher,
    getAllTeachers,
    getTeacherById,
    deleteTeacherById,
    updateTeacherById

}

export default factory;