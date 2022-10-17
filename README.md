# TrackVG
A repository for TrackVG COE project

## What is it?
An application to track a video game collection. 
You can use it to view, filter and sort your games collection, and track their current status (to play, playing, completed, retired). 
Later, you can add a rating, review and playtime information.

## How does it work?
A user can create and log into an account where they can begin to add games to a collection. 
Username/email address and password are initially required to create a skeleton account.
When adding games, to start with the user can input some basic information such as title, genre and platform. 
Games can be categorised according to their current status in your collection (currently playing, completed etc.). 
Users can add to a wishlist of games that they would like to eventually acquire for their collection. 
A 'stats about your collection' page will display various items such as, number of games owned for each platform, favourite genre, total length of logged playtime, and more.

### MVP
- Create a user account
- Add, remove, update games
- View collection

### Stretch Goals
- Reviews
- Ratings
- Wishlist
- Stats related to your games collection and the information you provide about playing those games.

### Domain Model
``` mermaid
erDiagram
          USER ||--|| GAME : ""
          GAME ||--|| GENRE : ""
          STATUS ||--|| GAME : ""
          PLATFORM ||--|| GAME : ""
          TITLE ||--|| GAME : ""
```

### API Specification
#### GAMES
`GET /games`
Return a list of all games

Response
```json
[
  {
    "id": 1,
    "title": "A Game Title",
    "genre": "RPG",
    "platform": "Xbox One"
  },
  {
    "id": 2,
    "title": "Another Game Title",
    "genre": "Racing",
    "platform": "PS5"
  }
]
```

---

`GET /games/users/{userId}`
Return a list of a user's games

Response
```json
[
  {
    "id": 1,
    "title": "A Game Title",
    "genre": "The Genre",
    "platform": "The Platform",
    "status": "The Status"
  },
  {
    "id": 2,
    "title": "Another Game Title",
    "genre": "The Genre",
    "platform": "The Platform",
    "status": "The Status"
  }
]
```

---

`GET /games/{id}`
Return a game by id

Response
```json
{
  "id": 1,
  "title": "A Game Title",
  "genre": "Racing",
  "platform": "PS4"
}
```

---

`POST /games/users/{userId}`
Create a game

Request
```json
{
  "title": "A New Game",
  "genreId": 1,
  "platformId": 1,
  "statusId": 1
}
```
Response - `201 Created`

---

#### USERS
`GET /users/{id}`
Return a user by id

Response
```json
{
  "id": 1,
  "username": "a_user",
  "enabled": true
}
```

---

`POST /users`
Create a user

Request
```json
{
  "username": "a_user",
  "password": "a_password"
}
```
Response - `201 Created`

---

`PUT /users/{id}`
Update a user by id

Request
```json
{
  "username": "updated_user",
  "password": "updated_password",
  "enabled": true
}
```

---

`DELETE /users/{id}`
Delete a user by id

Response - `204 No Content`

---

### Status
`GET /status`

`POST /status`

`DELETE /status/{statusId}`

### Platforms
`GET /platforms`

`POST /platforms`

`DELETE /platforms/{platformId}`

### Genres
`GET /genres`

`POST /genres`

`DELETE /genres/{genreId}`
