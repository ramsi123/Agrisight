const express = require("express");
const IndexController = require("../controllers/Index.controller");

const router = express.Router();

router.get("/", IndexController.getIndexPage);

module.exports = router;
