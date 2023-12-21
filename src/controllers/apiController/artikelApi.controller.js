const { artikelRef } = require("../../configs/firebase");

class ArtikelControllerApi {
  static getArtikel = async (req, res) => {
    try {
      const snapshot = await artikelRef.get();
      const artikels = [];
      snapshot.forEach((doc) => {
        artikels.push({ id: doc.id, ...doc.data() });
      });

      res.json({
        success: true,
        message: "Artikel get all successfully",
        data: { artikels },
      });
    } catch (error) {
      console.log(error);
      res.sendStatus(500);
    }
  };
  static getArtikelById = async (req, res) => {
    try {
      const artikelId = req.params.id; // Assumes ID is in a parameter named "id"

      const docSnapshot = await artikelRef.doc(artikelId).get();

      if (!docSnapshot.exists) {
        res.status(404).json({
          success: false,
          message: `Artikel with ID ${artikelId} not found`,
        });
        return;
      }

      const artikelData = docSnapshot.data();
      const artikel = { id: artikelId, ...artikelData };
      res.json({
        success: true,
        message: `Artikel ${artikelId} retrieved successfully`,
        data: { artikel },
      });
    } catch (error) {
      console.log(error);
      res.sendStatus(500);
    }
  };
}

module.exports = ArtikelControllerApi;
