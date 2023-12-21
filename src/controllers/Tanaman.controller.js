const { tanamanRef } = require("../configs/firebase");

class TanamanController {
  static getTanaman = async (req, res) => {
    try {
      const snapshot = await tanamanRef.get();
      const tanamans = [];
      snapshot.forEach((doc) => {
        tanamans.push({ id: doc.id, ...doc.data() });
      });
      res.render("./pages/tanaman/tanaman", { tanamans });
    } catch (error) {
      console.log(error);
      res.sendStatus(500);
    }
  };
  static addTanamanPage = (req, res) => {
    res.render("./pages/tanaman/addTanamanPage");
  };

  static addTanaman = async (req, res) => {
    try {
      const { nama, nama_latin, gambar, deskripsi } = req.body;
      const newTanamanRef = tanamanRef.doc();
      const newTanaman = {
        nama,
        nama_latin,
        gambar,
        deskripsi,
        id: newTanamanRef.id,
      };
      await newTanamanRef.set(newTanaman);
      res.redirect("/tanaman");
    } catch (error) {
      console.log(error);
      res.sendStatus(500);
    }
  };

  static editTanaman = async (req, res) => {
    try {
      const tanamanId = req.params.id;
      const editTanamanRef = tanamanRef.doc(tanamanId);
      const tanamanDoc = await editTanamanRef.get();
      if (!tanamanDoc.exists) {
        res.sendStatus(404);
        return;
      }
      const tanamanData = tanamanDoc.data();
      res.render("./pages/tanaman/editTanamanPage", {
        tanaman: tanamanData,
      });
    } catch (error) {
      console.log(error);
      res.sendStatus(500);
    }
  };

  static updateTanaman = async (req, res) => {
    try {
      const tanamanId = req.params.id;
      const updateTanamanRef = tanamanRef.doc(tanamanId);
      const { nama, nama_latin, gambar, deskripsi } = req.body;
      const updatedTanaman = {
        nama,
        nama_latin,
        gambar,
        deskripsi,
      };
      await updateTanamanRef.update(updatedTanaman);
      res.redirect("/tanaman");
    } catch (error) {
      console.log(error);
      res.sendStatus(500);
    }
  };

  static deleteTanaman = async (req, res) => {
    try {
      const tanamanId = req.params.id;
      const deleteTanamanRef = tanamanRef.doc(tanamanId);
      await deleteTanamanRef.delete();
      res.redirect("/tanaman");
    } catch (error) {
      console.log(error);
      res.sendStatus(500);
    }
  };
}

module.exports = TanamanController;
