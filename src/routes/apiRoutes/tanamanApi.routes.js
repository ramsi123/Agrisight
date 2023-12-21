const express = require("express");
const TanamanControllerApi = require("../../controllers/apiController/tanamanApi.controller");
const router = express.Router();

router.get("/", TanamanControllerApi.getTanaman);
router.get("/:id", TanamanControllerApi.getTanamanById);
router.get("/by-nama/:nama", TanamanControllerApi.getTanamanByNama);

module.exports = router;
