# 📚 Hibernate Library Management System (Backend - Java)

A backend-only **Library Management System** built using **Java 17**, **Hibernate ORM**, and **MySQL**, designed to demonstrate enterprise-level backend architecture and layered design using Hibernate features.

> 💡 This project resides in the `New` branch and represents a complete backend system; the `main` branch only contains the README file.

---

## 🚀 Project Overview

This project showcases the use of **Hibernate 5.4.33.Final** for object-relational mapping in Java applications. The system handles operations like user registration, login, book addition, search, deletion, and listing — all executed via backend logic, with dummy front-end simulation via a Java main class.

---

## 🧠 Key Features

- 📥 Register new users / Login for existing users
- ➕ Insert new books into the database
- 🔍 Search books by:
  - Author name
  - Title keywords
  - Publication year
- 📃 View all books in the library
- ❌ Delete books by:
  - Title
  - Author name
  - Year of publication
- 🔐 ISBN encryption using **MD5 hashing**
- 🕵️ Masked password input functionality
- 🧭 Layered architecture: `Entity → Controller → Service → DAO`

---

## 🛠️ Technologies Used

| Technology     | Version          |
|----------------|------------------|
| Java           | 17               |
| Eclipse IDE    | 2023-09+         |
| Hibernate ORM  | 5.4.33.Final     |
| MySQL          | 8.0.33           |
| JDK/JRE        | Java SE 17       |

---

## 📂 Project Structure

```plaintext
LibraryManagement/
│
├── controller/       → Handles user interactions
├── entity/           → Contains POJOs for Book, User, etc.
├── service/          → Contains business logic
├── dao/              → Deals with database operations via Hibernate
├── utils/
│   ├── MD5Encryptor  → Hashes ISBN
│   └── PasswordMask  → Masks password input
└── frontend/
    └── UserFrontend  → Dummy simulation with main method
