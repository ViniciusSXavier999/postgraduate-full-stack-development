import evaluationRepository from "../repositories/EvaluationRepository.js"


// Função que salva um professor no banco de dados
function saveEvaluation(evaluationModel) {
    return evaluationRepository.saveEvaluation(evaluationModel);
}

// Buscando professor pelo id
function getEvaluationById(id) {
    return evaluationRepository.getEvaluationById(id);
}

// função que busca todos professores 
function getAllEvaluations() {
    return evaluationRepository.getAllEvaluations();
}

// Método que deleta um professor
function deleteEvaluationById(id) {
    return evaluationRepository.deleteEvaluationById(id);
}

// Método que atualiza um professor
function updateEvaluationById(id, evaluationModel) {
    return evaluationRepository.updateEvaluationById(id, evaluationModel);
}

const service = {

    saveEvaluation,
    getEvaluationById,
    getAllEvaluations,
    deleteEvaluationById,
    updateEvaluationById

}

export default service; 