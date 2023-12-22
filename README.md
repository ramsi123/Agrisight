
# Cloud Computing - AGRISIGHT

## Architecture
<p align="center">
<img src="https://i.imgur.com/nMKzVZZ.jpeg" width="70%" alt="Cloud Architecture"/>
</p>

## Team CLOUD COMPUTING
| Member    | Student ID    | Path    | University    |
|------------|------------|------------|------------|
| Aditya Pratama   | C345BSY3341      | Cloud Computing     | Universitas 17 Agustus 1945 Surabaya     |
| Salma Nabila    | C296BSX3580     | Cloud Computing     | Universitas Pembangunan Nasional Veteran Jawa Timur     |


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

#### Get Artikel

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

- [Aditya Pratama](https://github.com/Aditypraa)
- [Salma Nabila](https://github.com/salmanabilaaa)
