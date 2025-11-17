import { express } from "express"
import { pkg } from "body-parser"
import { router } from "./routes/router.js"

import sequelize from "./utils/database.js"
import association from "./models/Associations.js"

const app = express()
const { json, urlencoded } = pkg


// vamos mudar a estrutura para ter uma função assíncrona que cria o banco e popula o banco com todas as tabelas vazias



app.use(json());
app.use(urlencoded({ extended: true }))

    (async () => {
        try {
            association.associations();
            await sequelize.sync()
            app.listen(3000, function () {
                console.log("Listening from 3000")
            })
        } catch (error) {
            console.log(error)
        }
    })()


// rotas
app.use("/", router)