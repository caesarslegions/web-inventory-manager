# Tabletop Inventory Manager

The Tabletop Inventory Manager is a Java Spring Boot application designed to manage players and their respective items in tabletop role-playing games. The application is built with Java Spring Boot for the backend, React for the frontend, and uses PostgreSQL for the database.

## Description

The application contains two primary entities, `Item` and `PlayerCharacter`, that hold the following properties:

### Item

- **id** (Integer): A unique identifier for the item.
- **name** (String): The name of the item.
- **description** (String): A brief description of the item.
- **effect** (String): The item's effect in the game.
- **value** (Double): The item's value.

### PlayerCharacter

- **id** (Integer): A unique identifier for the character.
- **name** (String): The character's name.
- **class** (String): The class of the character.
- **level** (Integer): The character's level.
- **description** (String): A brief description of the character.

## API Endpoints

### Item Endpoints

- `GET /api/items`: Fetches all items.
- `GET /api/items/{id}`: Fetches a specific item by ID.
- `POST /api/items`: Creates a new item.
- `PUT /api/items/{id}`: Updates a specific item by ID.
- `DELETE /api/items/{id}`: Deletes a specific item by ID.

### PlayerCharacter Endpoints

Assuming similar CRUD operations for `PlayerCharacter` as `Item`, the following endpoints can be inferred:

- `GET /api/playercharacters`: Fetches all characters.
- `GET /api/playercharacters/{id}`: Fetches a specific character by ID.
- `POST /api/playercharacters`: Creates a new character.
- `PUT /api/playercharacters/{id}`: Updates a specific character by ID.
- `DELETE /api/playercharacters/{id}`: Deletes a specific character by ID.

## Usage

Here are examples of how to use the API endpoints:

**Create a new item**

POST request to `/api/items` with a body containing item details:

```json
{
    "itemName": "Magic Wand",
    "itemDescription": "A wand imbued with magical powers.",
    "itemEffect": "Grants the user the ability to cast minor spells.",
    "itemValue": 200.0
}

```

**Create a new character**

POST request to `/api/playercharacters` with a body containing item details:

```json
{
    "playerCharacterName": "Thoric",
    "playerCharacterClass": "Warrior",
    "playerCharacterLevel": 10,
    "playerCharacterDescription": "A seasoned warrior from the North."
}

```
