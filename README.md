
# Cloud Computing - AGRISIGHT

![Arsitektur](https://github.com/Aditypraa/Agrisight/assets/95411404/fc49d59c-ad6e-4355-bd18-7c0c930656a8)


## Tech Stack

**Framework:** : Express.Js

**Dependencies** : dotenv, ejs, express, firebase, firebase-admin, nodemon


## Run Locally

Clone the project

```bash
  git clone -b Cloud-Computing https://link-to-project
```

Go to the project directory

```bash
  cd agrisight
```

Install dependencies

```bash
  npm install / npm update
```

Copy .env.development

```bash
  cp .env.development .env
```

Start the server

```bash
  npm run start / npm run start-dev
```


## API Reference

#### Get all Tanaman

```http
  GET /api/tanaman
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### Get Tanaman

```http
  GET /api/tanaman/:id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### Response

- Success Response

  - Status Code: 200 OK
  - Content-Type: application/json

    ``` "success": true,
    "message": "Tanaman ${id} retrieved successfully",
    "data": {
        "tanaman": {
            "id": "id",
            "nama": "nama",
            "nama_latin": "nama latin",
            "deskripsi": "deskripsi",
            "gambar": "gambar"
        }
    }
    ```

- Error Responses

  - Status Code: 404 Not Found

    - Content-Type: application/json

      ```json
      {
        "success": false,
        "message": "Tanaman with ID ds not found",
        
      }
      ```

  - Status Code: 500 Internal Server Error

    - Content-Type: application/json

      ```json
      {
        "message": "Internal Server Error"
      }
      ```

#### Get all Artikel

```http
  GET /api/artikel
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### Get Tanaman

```http
  GET /api/artikel/:id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### Response

- Success Response

  - Status Code: 200 OK
  - Content-Type: application/json

    ``` {
    "success": true,
    "message": "Artikel 2mnscC1liB9Ecv9xqIu8 retrieved successfully",
    "data": {
        "artikel": {
            "id": "id",
            "kategori": "kategori",
            "tanggal": "tanggal",
            "judul": "judul",
            "gambar": "gambar",
            "deskripsi": "deskripsi"
        }
    }
}
    ```

- Error Responses

  - Status Code: 404 Not Found

    - Content-Type: application/json

      ```json
      {
        "success": false,
        "message": "Artikel with ID ds not found",
        
      }
      ```

  - Status Code: 500 Internal Server Error

    - Content-Type: application/json

      ```json
      {
        "message": "Internal Server Error"
      }
      ```


## Authors

- [@aditypraa](https://github.com/Aditypraa)
- [@salmanabilaaa](https://github.com/salmanabilaaa)
