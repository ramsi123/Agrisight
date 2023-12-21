const path = require("path");
const express = require("express");
require("dotenv").config();

// DOTENV
const PORT = process.env.PORT;

const app = express();
app.use(express.urlencoded({ extended: true }));

// Router
const indexRouter = require("./routes/Index.routes");
const tanamanRouter = require("./routes/Tanaman.routes");
const artikelRouter = require("./routes/Artikel.routes");

// Router API
const artikelApiRouter = require("./routes/apiRoutes/artikelApi.routes");
const tanamanApiRouter = require("./routes/apiRoutes/tanamanApi.routes");

// Template Engine EJS
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "ejs");

// URL Route
app.use("/index", indexRouter);
app.use("/tanaman", tanamanRouter);
app.use("/artikel", artikelRouter);

// Endpoint API
app.use("/api/artikel", artikelApiRouter);
app.use("/api/tanaman", tanamanApiRouter);
app.use("/api", (req, res) => {
  return res.status(200).json({
    message: "Welcome to Agrisight Rest API",
  });
});

app.listen(PORT, () => {
  console.log(`💡 listening on http://localhost:${PORT}`);
});
