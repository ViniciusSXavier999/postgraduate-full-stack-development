import teacherRepository from "../repositories/TeacherRepository.js"

// Função que salva um professor no banco de dados
function saveTeacher(teacherModel) {
    return teacherRepository.saveTeacher(teacherModel);
}

// Buscando professor pelo id
function getTeacherById(id) {
    return teacherRepository.getTeacherById(id);
}

// função que busca todos professores 
function getAllTeachers() {
    return teacherRepository.getAllTeachers();
}

// Método que deleta um professor
function deleteTeacherById(id) {
    return teacherRepository.deleteTeacherById(id);
}

// Método que atualiza um professor
function updateTeacherById(id, teacherModel) {
    return teacherRepository.updateTeacherById(id, teacherModel);
}

const service = {
    saveTeacher,
    getTeacherById,
    getAllTeachers,
    deleteTeacherById,
    updateTeacherById
}

export default service; 