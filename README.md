# 🚆 Train Ticket Booking API

This is a Spring Boot-based REST API that allows users to purchase a train ticket from **London to France**. The train is divided into **two sections: A and B**, and each user is automatically allocated a seat upon booking. All data is stored in-memory (no database).

---

## 📌 Features

- 🎟️ Purchase a train ticket for $20
- 🧾 Generate and view a receipt containing:
  - From, To, User (First Name, Last Name, Email), Seat, Section, Price
- 📍 Seat auto-allocation between Section A and Section B
- 📜 View receipt by email
- 🔍 View users by section (A or B)
- ❌ Remove a user and their booking
- 🔁 Modify an existing seat (if available)

---

## 🚀 Tech Stack

- Java 17+
- Spring Boot 3.x
- RESTful API
- JUnit 5 + Mockito
- In-memory storage (HashMap)

---

## 📦 API Endpoints

### 🎟️ Purchase Ticket

