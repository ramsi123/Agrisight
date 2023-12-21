const express = require("express");
const ArtikelControllerApi = require("../../controllers/apiController/artikelApi.controller");
const router = express.Router();

router.get("/", ArtikelControllerApi.getArtikel);
router.get("/:id", ArtikelControllerApi.getArtikelById);

module.exports = router;
