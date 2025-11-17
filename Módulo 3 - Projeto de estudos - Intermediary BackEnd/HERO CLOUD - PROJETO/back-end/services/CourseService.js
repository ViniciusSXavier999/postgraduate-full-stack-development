import courseRepository from "../repositories/CourseRepository.js"

// Função que salva um professor no banco de dados
function saveCourse(courseModel) {
    return courseRepository.saveCourse(courseModel);
}

// Buscando professor pelo id
function getCourseById(id) {
    return courseRepository.getCourseById(id);
}

// função que busca todos professores 
function getAllCourse() {
    return courseRepository.getAllCourse();
}

// Método que deleta um professor
function deleteCourseById(id) {
    return courseRepository.deleteCourseById(id);
}

// Método que atualiza um professor
function updateCourseById(id, courseModel) {
    return courseRepository.updateEvaluationById(id, courseModel);
}

const service = {

    saveCourse,
    getCourseById,
    getAllCourse,
    deleteCourseById,
    updateCourseById

}

export default service; 