# 🍳 Máster Chef Celebrity API

API REST desarrollada por **DOSW Company** para la gestión de recetas del programa **Máster Chef Celebrity**.  
Esta API permite consultar, registrar, actualizar y eliminar recetas creadas por **participantes**, **jueces (chefs)** y **televidentes**, además de filtrar por temporada o por ingredientes específicos.

---

## ⚙️ Instalación y Ejecución Local

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/<tu-usuario>/MasterChefAPI.git
cd MasterChefAPI
```
### 2️⃣ Ejecutar el proyecto

```bash
mvn clean compile
mvn spring-boot:run
```
---
# Enlace de swagger UI 

```bash
https://mastercheft2-a8afeadpdvbxbshj.canadacentral-01.azurewebsites.net/swagger-ui/index.html

```


![Evidencia swagger](/docs/image-1.png)
---
# Evidencia azure


![Evidencia azure](/docs/azure.png)

---

# Ejemplos de request y response por endpoint

## Crear una receta:

Request: 

```bash

    "id": "RE001",
    "title": "Filet Mignon",
    "ingridients": [
        "Beef",
        "Butter",
        "Salt",
        "Pepper"
    ],
    "steps": [
        "Season the meat with salt and pepper.",
        "Heat butter in a pan.",
        "Cook the meat for 3 minutes per side.",
    ],
    "season": 1,
    "authorChef": {
        "id": "CH001",
        "name": "Juan Perez",
        "role": "CONTESTANT"
    }
} 

```


Response: 

```bash
    {
    "id": "RE001",
    "title": "Filet Mignon",
    "ingridients": [
        "400g of beef tenderloin",
        "15g of butter",
        "Salt",
        "Pepper"
    ],
    "steps": [
        "Season the meat with salt and pepper.",
        "Heat butter in a pan.",
        "Cook the meat for 3 minutes per side.",
    ],
    "season": 1,
    "authorChef": {
        "id": "CH001",
        "name": "Juan Perez",
        "role": "CONTESTANT"
    }
    }
```

## Actualizar una receta:

Request:

```bash
    {
  "id": "RE001",
  "title": "Filet Mignon Deluxe",
  "ingridients": [
    "Beef chata",
    "Butter",
    "Salt",
    "Pepper"
  ],
  "steps": [
    "Marinate the meat and put salt, and pepper.",
    "Cook in butter for 400 minutes per side.",
    "Serve with a sauce of your choice."
  ],
  "season": 2,
  "authorChef": {
    "id": "CH001",
    "name": "Juan Perez",
    "role": "CONTESTANT"
  }
}

```


Response:

```bash
        {
  "id": "RE001",
  "title": "Filet Mignon Deluxe",
  "ingridients": [
    "400g of beef chata",
    "20g of butter",
    "Salt",
    "Pepper"
  ],
  "steps": [
    "Marinate the meat and put salt, and pepper.",
    "Cook in butter for 400 minutes per side.",
    "Serve with a sauce of your choice."
  ],
  "season": 2,
  "authorChef": {
    "id": "CH001",
    "name": "Juan Perez",
    "role": "CONTESTANT"
  }
}
```


## Eliminar receta

Request:

```bash
    DELETE /recipes/RE001
```

Response:

```bash
    204 No Content
```

## Obtener todas las recetas

Request:

```bash
    GET /recipes

```


Response:

```bash
    [
  {
    "id": "RE001",
    "title": "Filet Mignon",
    "ingridients": ["Beef", "Butter", "Salt"],
    "steps": ["Season", "Cook", "Serve"],
    "season": 1,
    "authorChef": {
      "id": "CH001",
      "name": "Juan Perez",
      "role": "CONTESTANT"
    }
  }
]
```

## Obtener todas las por id

Request:

```bash
    GET /recipes/RE001

```


Response:

```bash
    [
  {
    "id": "RE001",
    "title": "Filet Mignon",
    "ingridients": ["Beef", "Butter", "Salt"],
    "steps": ["Season", "Cook", "Serve"],
    "season": 1,
    "authorChef": {
      "id": "CH001",
      "name": "Juan Perez",
      "role": "CONTESTANT"
    }
  }
]
```

## Obtener todas las recetas por participante

Request:

```bash
    GET /recipes/contestants

```


Response:

```bash
    [
  {
    "id": "RE001",
    "title": "Filet Mignon",
    "ingridients": ["Beef", "Butter", "Salt"],
    "steps": ["Season", "Cook", "Serve"],
    "season": 1,
    "authorChef": {
      "id": "CH001",
      "name": "Juan Perez",
      "role": "CONTESTANT"
    }
  }
]
```

## Obtener todas las recetas por temporada

Request:

```bash
    GET /recipes/season/1

```


Response:

```bash
    [
  {
    "id": "RE001",
    "title": "Filet Mignon",
    "season": 1,
    }
  }
]
```

## Obtener recetas por ingrediente

Request:

```bash
    GET /recipes/ingridient/Butter

```


Response:

```bash
    [
  {
    "id": "RE001",
    "title": "Filet Mignon",
    "ingridients": ["Beef", "Butter", "Salt"],
    "steps": ["Season", "Cook", "Serve"],
    "authorChef": {
      "id": "CH001",
      "name": "Juan Perez",
      "role": "CONTESTANT"
    }
  }
]

