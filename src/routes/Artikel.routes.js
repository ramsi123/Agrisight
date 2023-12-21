const express = require("express");
const ArtikelController = require("../controllers/Artikel.controller");
const router = express.Router();

router.get("/", ArtikelController.getArtikel);
router.get("/add", ArtikelController.addArtikelPage);
router.post("/", ArtikelController.addArtikel);
router.get("/edit/:id", ArtikelController.editArtikel);
router.post("/update/:id", ArtikelController.updateArtikel);
router.post("/delete/:id", ArtikelController.deleteArtikel);

module.exports = router;
