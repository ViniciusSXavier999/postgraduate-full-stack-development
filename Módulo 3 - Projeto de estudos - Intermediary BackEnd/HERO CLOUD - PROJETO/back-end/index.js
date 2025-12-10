import express from "express";
import router from "./routes/router.js";  // << CORRETO

import sequelize from "./utils/database.js";
import association from "./models/Associations.js";

import cors from "cors";

const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(cors());

(async () => {
    try {
        association.associations();
        await sequelize.sync();

        app.listen(3000, () => {
            console.log("Listening from 3000");
        });

    } catch (error) {
        console.log(error);
    }
})();

app.use("/", router);

