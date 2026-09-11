# Library Management System — Version 1

A simple Java-based Library Management System that demonstrates **Object-Oriented Programming, Maven dependency management, and MongoDB database integration**.

## Version 1 Overview

Version 1 focuses on the foundation of the application and the first database integration milestone.

The current application can:

- Create `Bookobj` objects from user input.
- Store basic book information such as author, genre, publication year, and price.
- Track the number of book objects created during the current program execution.
- Connect the Java application to a local MongoDB server.
- Use MongoDB to store newly created books.
- Separate the Java application logic from the MongoDB repository/database logic.

## Tech Stack

- **Java** — application logic and object-oriented programming
- **Maven** — project and dependency management
- **MongoDB** — database
- **MongoDB Java Driver** — communication between Java and MongoDB
- **MongoDB Compass** — database visualization and management
- **IntelliJ IDEA** — development environment

## Project Structure

```text
Githubproj/
├── src/
│   ├── Libmanage.java
│   ├── Bookobj.java
│   └── BookRepo.java
│
├── pom.xml
├── .gitignore
└── README.md
```

### `Libmanage.java`

Handles the main application flow and user input. It asks the user for book details, creates `Bookobj` instances, and communicates with the repository layer.

### `Bookobj.java`

Represents a book as a Java object. It contains the book fields, constructor, getters, book information display, and a static counter for the number of book objects created during the current run.

### `BookRepo.java`

Handles the MongoDB side of the application. It creates the MongoDB client, selects the database and collection, tests the connection, and currently contains the operation for saving a book document.

### `pom.xml`

Maven configuration file. It defines project information and includes the MongoDB Java Driver dependency required by the application.

## MongoDB Setup

Version 1 uses a **local MongoDB server** running on:

```text
mongodb://127.0.0.1:27017
```

The application uses the following database structure:

```text
MongoDB Server
└── library_db
    └── books
```

### Database

`library_db` is the database used specifically for this Library Management System.

### Collection

`books` is the collection where book documents are stored.

### Document

Each saved book is stored as a MongoDB document. A Version 1 document has the following structure:

```json
{
  "_id": "generated automatically by MongoDB",
  "author": "Robert C. Martin",
  "genre": "Programming",
  "year": 2008,
  "price": 500.0
}
```

MongoDB automatically generates the `_id` field when we insert a document without providing one ourselves. The other fields are created by the Java application when it converts a `Bookobj` into a MongoDB `Document`.

## How the Database Integration Works

The application follows this flow:

```text
User input
    ↓
Libmanage.java
    ↓
Bookobj
    ↓
BookRepo
    ↓
MongoDB Java Driver
    ↓
MongoDB Server
    ↓
library_db → books
```

The repository layer keeps the low-level MongoDB code separate from the main application logic.

## Running the Project

### Requirements

- JDK installed
- IntelliJ IDEA (or another Java IDE)
- Maven
- MongoDB Server running locally
- MongoDB Compass (optional, for viewing the database)

### Steps

1. Start the local MongoDB server.
2. Open the project in IntelliJ IDEA.
3. Allow Maven to download the dependencies from `pom.xml`.
4. Run `Libmanage.java`.
5. Enter the book information when prompted.
6. The application saves the book to `library_db.books`.
7. Open MongoDB Compass and refresh `library_db → books` to view the stored document.

## Current Status — Version 1

### Implemented

- [x] Java `Bookobj` model
- [x] User input for creating books
- [x] Maven project setup
- [x] MongoDB Java Driver integration
- [x] MongoDB connection
- [x] `library_db` database selection
- [x] `books` collection selection
- [x] Create/insert book operation

### Planned for Future Versions

- [ ] Read/fetch all books
- [ ] Search for a book
- [ ] Update book details
- [ ] Delete a book
- [ ] Exception handling and input validation
- [ ] Better command-line menu
- [ ] Improved project structure
- [ ] Web interface using HTML/CSS/JavaScript
- [ ] Future React frontend

## Important Note About MongoDB

The MongoDB database itself is **not stored in this GitHub repository**. GitHub stores the Java source code and Maven configuration. MongoDB runs separately on the developer's machine.

Another developer cloning this repository must have MongoDB running locally (or the project can later be changed to use MongoDB Atlas).

## Authors

Built as a collaborative Java + MongoDB learning project.
