import express from "express";

let router = express.Router();

import teacherService from "../services/TeacherService.js"

// MÉTODO DE CREATE

async function addTeacher(req, res) {
    try {
        const teacherModel = {
            first_name: req.body.first_name,
            last_name: req.body.last_name,
            email: req.body.email,
            gender: req.body.gender
        }

        const teacher = await teacherService.saveTeacher(teacherModel)
        return res.status(201).json(teacher)
    } catch (error) {
        console.error("Erro em addTeacher:", error)
        return res.status(500).json({ message: "Erro ao salvar usuário", error: error.message })
    }
}

router.post("/addTeacher", addTeacher)


// MÉTODO DE GET
async function getAllTeachers(req, res) {
    try {
        const allTeachers = await teacherService.getAllTeachers()
        return res.status(200).json(allTeachers)
    } catch (error) {
        console.error("Erro ao buscar usuários:", error)
        return res.status(500).json({ message: "Erro ao buscar usuários" })
    }
}

router.get("/getAllTeachers", getAllTeachers)


// BUSCANDO POR ID
async function getTeacherById(req, res) {
    try {
        const teacherId = req.params.id
        const teacher = await teacherService.getTeacherById(teacherId)

        return res.status(200).json(teacher)
    } catch (error) {
        console.error("Erro ao buscar usuário por ID:", error)
        return res.status(500).json({ message: "Erro ao buscar usuário" })
    }
}

// rota que usa a função
router.get("/teacher/:id", getTeacherById)


// MÉTODO DELETE 
async function deleteTeacherById(req, res) {
    try {
        const teacherId = req.params.id
        const teacher = await teacherService.deleteTeacherById(teacherId)
        return res.status(200).json(teacher)
    } catch (error) {
        console.error("Erro ao deletar usuário:", error)
        return res.status(500).json({ message: "Erro ao deletar usuário" })
    }
}

// rota que usa a função
router.delete("/deleteTeacher/:id", deleteTeacherById)


// MÉTODO PARA ATUALIZAR UM USUÁRIO 
async function updateTeacher(req, res) {
    try {
        const teacherModel = {
            first_name: req.body.first_name,
            last_name: req.body.last_name,
            email: req.body.email,
            gender: req.body.gender
        }

        const teacher = await teacherService.updateTeacherById(req.params, teacherModel)
        return res.status(201).json(teacher)
    } catch (error) {
        console.error("Erro em addTeacher:", error)
        return res.status(500).json({ message: "Erro ao salvar usuário", error: error.message })
    }
}

router.put("/updateTeacher/:id", updateTeacher)

export default router