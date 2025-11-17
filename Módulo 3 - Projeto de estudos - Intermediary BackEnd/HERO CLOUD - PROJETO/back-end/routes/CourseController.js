import express from "express";

let router = express.Router();

import courseService from "../services/CourseService.js"

// MÉTODO DE CREATE

async function addCourse(req, res) {
    try {
        const courseModel = {
            first_name: req.body.first_name,
            last_name: req.body.last_name,
            email: req.body.email,
            gender: req.body.gender
        }

        const course = await courseService.saveCourse(courseModel)
        return res.status(201).json(course)
    } catch (error) {
        console.error("Erro em addCourse:", error)
        return res.status(500).json({ message: "Erro ao salvar usuário", error: error.message })
    }
}

router.post("/addCourse", addCourse)


// MÉTODO DE GET
async function getAllCourses(req, res) {
    try {
        const allCourses = await courseService.getAllCourses()
        return res.status(200).json(allCourses)
    } catch (error) {
        console.error("Erro ao buscar usuários:", error)
        return res.status(500).json({ message: "Erro ao buscar usuários" })
    }
}

router.get("/getAllCourses", getAllCourses)


// BUSCANDO POR ID
async function getCourseById(req, res) {
    try {
        const courseId = req.params.id
        const course = await courseService.getCourseById(courseId)

        return res.status(200).json(course)
    } catch (error) {
        console.error("Erro ao buscar usuário por ID:", error)
        return res.status(500).json({ message: "Erro ao buscar usuário" })
    }
}

// rota que usa a função
router.get("/course/:id", getCourseById)


// MÉTODO DELETE 
async function deleteCourseById(req, res) {
    try {
        const courseId = req.params.id
        const course = await courseService.deleteCourseById(courseId)
        return res.status(200).json(course)
    } catch (error) {
        console.error("Erro ao deletar usuário:", error)
        return res.status(500).json({ message: "Erro ao deletar usuário" })
    }
}

// rota que usa a função
router.delete("/deleteCourse/:id", deleteCourseById)


// MÉTODO PARA ATUALIZAR UM USUÁRIO 
async function updateCourse(req, res) {
    try {
        const courseModel = {
            first_name: req.body.first_name,
            last_name: req.body.last_name,
            email: req.body.email,
            gender: req.body.gender
        }

        const course = await courseService.updateCourseById(req.params, courseModel)
        return res.status(201).json(course)
    } catch (error) {
        console.error("Erro em addCourse:", error)
        return res.status(500).json({ message: "Erro ao salvar usuário", error: error.message })
    }
}

router.put("/updateCourse/:id", updateCourse)

export default router