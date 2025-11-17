import Evaluation from "../models/Evaluation.js"

// FUNÇÃO QUE SALVA O USUÁRIO
async function saveEvaluation(EvaluationModel) {
    const save = await Evaluation.create(EvaluationModel)
    return save
}

// FUNÇÃO QUE BUSCA TODOS USUÁRIOS 
async function getAllEvaluations() {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await Evaluation.findAll({
        order: [
            ['id', 'ASC']
        ]
    })
}

// FUNÇÃO QUE BUSCA USUÁRIO POR ID
async function getEvaluationById(id) {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await Evaluation.findByPk(id)
}


// FUNÇÃO QUE DELETA UM USUÁRIO
async function deleteEvaluationById(id) {

    // aqui ele já retorna direto, anteriormente tinhamos passado o valor da função para uma váriavel.
    return await Evaluation.destroy({ where: { id: id } })
}

// FUNÇÃO QUE ATUALIZA UM USUÁRIO
async function updateEvaluationById(id, EvaluationModel) {

    try {
        const result = await Evaluation.update(EvaluationModel, { where: { id: id } })
        if (result[0] === 1) {
            return { message: "Evaluation atualizado com sucesso!" }
        } else {
            return { message: "Não consigo encontrar a opção ${id} para atualizar" }
        }
    } catch (error) {
        console.error()
    }
}

// fabrica de funções
const factory = {

    saveEvaluation,
    getAllEvaluations,
    getEvaluationById,
    deleteEvaluationById,
    updateEvaluationById

}

export default factory;