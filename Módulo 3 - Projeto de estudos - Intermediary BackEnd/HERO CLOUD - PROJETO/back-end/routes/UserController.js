import express from "express";
import userService from "../services/UserService.js"
import multer from "multer";
import process from "process";
import { promisify } from "util";





let router = express.Router();

// MÉTODO QUE VAI SALVAR O ARQUIVO
const storage = multer.diskStorage({
    destination: function (req, file, callback) {
        callback(null, './images')
    },
    filename: function (req, file, callback) {
        callback(null, req.body.first_name + "_" + req.body.last_name + "_" + Date.now() + file.originalname)
    }
})

// CAMINHO QUE FAZ O ENVIO DA FOTO PARA ATUALIZAÇÃO
const upload = multer({ storage });
const uploadAsync = promisify(upload.single("file"));



// MÉTODO DE CREATE

async function addUser(req, res) {
    try {

        // Executa upload SEM LAMBDA
        await uploadAsync(req, res);

        if (!req.file) {
            return res.status(400).json({ message: "Nenhum arquivo enviado" });
        }

        const userModel = {
            first_name: req.body.first_name,
            last_name: req.body.last_name,
            email: req.body.email,
            gender: req.body.gender,
            profile_picture: req.file.path
        };

        const user = await userService.saveUser(userModel);

        return res.status(201).json(user);

    } catch (error) {
        console.error("Erro em addUser:", error);
        return res.status(500).json({
            message: "Erro ao salvar usuário",
            error: error.message
        });
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
            gender: req.body.gender,
            profile_picture: req.file?.path

        }

        const user = await userService.updateUserById(req.params.id, userModel)
        return res.status(201).json(user)
    } catch (error) {
        console.error("Erro em addUser:", error)
        return res.status(500).json({ message: "Erro ao salvar usuário", error: error.message })
    }
}

router.put(
    "/updateUser/:id",
    upload.single("profile_picture"),
    updateUser
)



// VAMOS FAZER O GET DA IMAGEM NA TELA 
router.get('/userImage/:id', getUserImage);

async function getUserImage(req, res) {

    try {
        const user = await userService.getUserById(req.params.id);

        // Envia o arquivo da imagem
        const caminhoCompleto = process.cwd() + "\\" + user.profile_picture;
        return res.sendFile(caminhoCompleto);

    } catch (error) {
        console.error("Erro ao buscar imagem do usuário:", error);
        return res.status(500).json({ message: "Erro ao carregar imagem" });
    }
}



export default router
