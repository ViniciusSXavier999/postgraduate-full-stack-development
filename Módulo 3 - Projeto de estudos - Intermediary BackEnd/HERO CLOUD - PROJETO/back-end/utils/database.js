import {Sequelize } from "sequelize";

// contém informações do banco de dados

const sequelize = new Sequelize("db_herocloud", "root", "soudev", {
  host: "localhost",
  dialect: "mysql",
  port: "3306",
  define: {
    timestamps: false
  }
});

// isso vai fazer com que essa classe seja exposta para aplicação e seja inicializada dentro do index
export default sequelize;
