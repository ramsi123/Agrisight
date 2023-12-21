const express = require("express");
const TanamanController = require("../controllers/Tanaman.controller");
const router = express.Router();

router.get("/", TanamanController.getTanaman);
router.get("/add", TanamanController.addTanamanPage);
router.post("/", TanamanController.addTanaman);
router.get("/edit/:id", TanamanController.editTanaman);
router.post("/update/:id", TanamanController.updateTanaman);
router.post("/delete/:id", TanamanController.deleteTanaman);

module.exports = router;
