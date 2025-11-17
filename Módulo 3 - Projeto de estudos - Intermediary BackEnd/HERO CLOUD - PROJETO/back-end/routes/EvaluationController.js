import express from "express";

let router = express.Router();

import evaluationService from "../services/EvaluationService.js"

// MÉTODO DE CREATE

async function addEvaluation(req, res) {
    try {
        const evaluationModel = {
            first_name: req.body.first_name,
            last_name: req.body.last_name,
            email: req.body.email,
            gender: req.body.gender
        }

        const evaluation = await evaluationService.saveEvaluation(evaluationModel)
        return res.status(201).json(evaluation)
    } catch (error) {
        console.error("Erro em addEvaluation:", error)
        return res.status(500).json({ message: "Erro ao salvar usuário", error: error.message })
    }
}

router.post("/addEvaluation", addEvaluation)


// MÉTODO DE GET
async function getAllEvaluations(req, res) {
    try {
        const allEvaluations = await evaluationService.getAllEvaluations()
        return res.status(200).json(allEvaluations)
    } catch (error) {
        console.error("Erro ao buscar usuários:", error)
        return res.status(500).json({ message: "Erro ao buscar usuários" })
    }
}

router.get("/getAllEvaluations", getAllEvaluations)


// BUSCANDO POR ID
async function getEvaluationById(req, res) {
    try {
        const evaluationId = req.params.id
        const evaluation = await evaluationService.getEvaluationById(evaluationId)

        return res.status(200).json(evaluation)
    } catch (error) {
        console.error("Erro ao buscar usuário por ID:", error)
        return res.status(500).json({ message: "Erro ao buscar usuário" })
    }
}

// rota que usa a função
router.get("/evaluation/:id", getEvaluationById)


// MÉTODO DELETE 
async function deleteEvaluationById(req, res) {
    try {
        const evaluationId = req.params.id
        const evaluation = await evaluationService.deleteEvaluationById(evaluationId)
        return res.status(200).json(evaluation)
    } catch (error) {
        console.error("Erro ao deletar usuário:", error)
        return res.status(500).json({ message: "Erro ao deletar usuário" })
    }
}

// rota que usa a função
router.delete("/deleteEvaluation/:id", deleteEvaluationById)


// MÉTODO PARA ATUALIZAR UM USUÁRIO 
async function updateEvaluation(req, res) {
    try {
        const evaluationModel = {
            first_name: req.body.first_name,
            last_name: req.body.last_name,
            email: req.body.email,
            gender: req.body.gender
        }

        const evaluation = await evaluationService.updateEvaluationById(req.params, evaluationModel)
        return res.status(201).json(evaluation)
    } catch (error) {
        console.error("Erro em addEvaluation:", error)
        return res.status(500).json({ message: "Erro ao salvar usuário", error: error.message })
    }
}

router.put("/updateEvaluation/:id", updateEvaluation)

export default router