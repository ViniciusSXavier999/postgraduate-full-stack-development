import Course from "../models/Course.js"


// FUNÇÃO QUE SALVA O USUÁRIO
async function saveCourse(CourseModel) {
    const save = await Course.create(CourseModel)
    return save
}

// FUNÇÃO QUE BUSCA TODOS USUÁRIOS 
async function getAllCourses() {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await Course.findAll({
        order: [
            ['id', 'ASC']
        ]
    })
}

// FUNÇÃO QUE BUSCA USUÁRIO POR ID
async function getCourseById(id) {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await Course.findByPk(id)
}


// FUNÇÃO QUE DELETA UM USUÁRIO
async function deleteCourseById(id) {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await Course.destroy({ where: { id: id } })
}

// FUNÇÃO QUE ATUALIZA UM USUÁRIO
async function updateCourseById(id, CourseModel) {

    try {
        const result = await Course.update(CourseModel, { where: { id: id } })
        if (result[0] === 1) {
            return { message: "Course atualizado com sucesso!" }
        } else {
            return { message: "Não consigo encontrar a opção ${id} para atualizar" }
        }
    } catch (error) {
        console.error()
    }
}

// fabrica de funções
const factory = {

    saveCourse,
    getAllCourses,
    getCourseById,
    deleteCourseById,
    updateCourseById

}

export default factory;