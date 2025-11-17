import express from "express";
let router = express.Router();

import userService from "../services/UserService.js"


// MÉTODO DE CREATE

async function addUser(req, res) {
    try {
        const userModel = {
            first_name: req.body.first_name,
            last_name: req.body.last_name,
            email: req.body.email,
            gender: req.body.gender
        }

        const user = await userService.saveUser(userModel)
        return res.status(201).json(user)
    } catch (error) {
        console.error("Erro em addUser:", error)
        return res.status(500).json({ message: "Erro ao salvar usuário", error: error.message })
    }
}

router.post("/addUser", addUser)


// MÉTODO DE GET
async function getAllUsers(req, res) {
    try {
        const allUsers = await userService.getAllUsers()
        return res.status(200).json(allUsers)
    } catch (error) {
        console.error("Erro ao buscar usuários:", error)
        return res.status(500).json({ message: "Erro ao buscar usuários" })
    }
}

router.get("/getAllUsers", getAllUsers)


// BUSCANDO POR ID
async function getUserById(req, res) {
    try {
        const userId = req.params.id
        const user = await userService.getUserById(userId)

        return res.status(200).json(user)
    } catch (error) {
        console.error("Erro ao buscar usuário por ID:", error)
        return res.status(500).json({ message: "Erro ao buscar usuário" })
    }
}

// rota que usa a função
router.get("/user/:id", getUserById)


// MÉTODO DELETE 
async function deleteUserById(req, res) {
    try {
        const userId = req.params.id
        const user = await userService.deleteUserById(userId)
        return res.status(200).json(user)
    } catch (error) {
        console.error("Erro ao deletar usuário:", error)
        return res.status(500).json({ message: "Erro ao deletar usuário" })
    }
}

// rota que usa a função
router.delete("/deleteUser/:id", deleteUserById)


// MÉTODO PARA ATUALIZAR UM USUÁRIO 
async function updateUser(req, res) {
    try {
        const userModel = {
            first_name: req.body.first_name,
            last_name: req.body.last_name,
            email: req.body.email,
            gender: req.body.gender
        }

        const user = await userService.updateUserById(req.params.id, userModel)
        return res.status(201).json(user)
    } catch (error) {
        console.error("Erro em addUser:", error)
        return res.status(500).json({ message: "Erro ao salvar usuário", error: error.message })
    }
}

router.put("/updateUser/:id", updateUser)


export default router
