const { artikelRef } = require("../configs/firebase");

class ArtikelController {
  static getArtikel = async (req, res) => {
    try {
      const snapshot = await artikelRef.get();
      const artikels = [];
      snapshot.forEach((doc) => {
        artikels.push({ id: doc.id, ...doc.data() });
      });
      res.render("./pages/artikel/artikel", { artikels });
    } catch (error) {
      console.log(error);
      res.sendStatus(500);
    }
  };

  static addArtikelPage = (req, res) => {
    res.render("./pages/artikel/addArtikelPage");
  };

  static addArtikel = async (req, res) => {
    try {
      const { judul, deskripsi, tanggal, kategori, gambar } = req.body;
      const newArtikelRef = artikelRef.doc();
      const newArtikel = {
        judul,
        deskripsi,
        tanggal,
        kategori,
        gambar,
        id: newArtikelRef.id,
      };
      await newArtikelRef.set(newArtikel);
      res.redirect("/artikel");
    } catch (error) {
      console.log(error);
      res.sendStatus(500);
    }
  };

  static editArtikel = async (req, res) => {
    try {
      const artikelId = req.params.id;
      const editArtikelRef = artikelRef.doc(artikelId);
      const artikelDoc = await editArtikelRef.get();
      if (!artikelDoc.exists) {
        res.sendStatus(404);
        return;
      }
      const artikelData = artikelDoc.data();
      res.render("./pages/artikel/editArtikelPage", {
        artikel: artikelData,
      });
    } catch (error) {
      console.log(error);
      res.sendStatus(500);
    }
  };

  static updateArtikel = async (req, res) => {
    try {
      const artikelId = req.params.id;
      const updateArtikelRef = artikelRef.doc(artikelId);
      const { judul, deskripsi, tanggal, kategori, gambar } = req.body;
      const updatedArtikel = {
        judul,
        deskripsi,
        tanggal,
        kategori,
        gambar,
      };
      await updateArtikelRef.update(updatedArtikel);
      res.redirect("/artikel");
    } catch (error) {
      console.log(error);
      res.sendStatus(500);
    }
  };

  static deleteArtikel = async (req, res) => {
    try {
      const artikelId = req.params.id;
      const deleteArtikelRef = artikelRef.doc(artikelId);
      await deleteArtikelRef.delete();
      res.redirect("/artikel");
    } catch (error) {
      console.log(error);
      res.sendStatus(500);
    }
  };
}

module.exports = ArtikelController;
