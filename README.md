# 🏦 Bank Management System

A console-based **Bank Management System** built in Java, demonstrating core Object-Oriented Programming (OOP) principles including **encapsulation**, **object creation**, and **method invocation**. Users can manage up to 10 bank accounts with full deposit, withdrawal, and transfer functionality.

---

## 📋 Table of Contents

- [Features](#-features)
- [OOP Concepts Used](#-oop-concepts-used)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Run with Shell Script](#run-with-shell-script)
  - [Run Manually](#run-manually)
- [Usage](#-usage)
- [Sample Output](#-sample-output)
- [Limitations](#-limitations)
- [License](#-license)

---

## ✨ Features

- ✅ Create up to **10 bank accounts**
- ✅ **Deposit** money into any account
- ✅ **Withdraw** money with balance validation
- ✅ **Transfer** funds between two accounts
- ✅ **Check balance** and view account details
- ✅ **View all accounts** in a single overview
- ✅ Input validation and descriptive error messages

---

## 🧠 OOP Concepts Used

| Concept | Where Applied |
|---|---|
| **Class & Object** | `BankAccount` class; each account is a separate object |
| **Constructor** | `BankAccount(accNum, name, initialBalance)` initializes each object |
| **Encapsulation** | Fields (`accountNumber`, `ownerName`, `balance`) are `private`; accessed via `public` getters |
| **Methods** | `deposit()`, `withdraw()`, `transfer()`, `displayAccountInfo()` |
| **Object Interaction** | `transfer()` passes one `BankAccount` object into another's method |

---

## 📁 Project Structure

```
BankManagementSystem/
│
├── BankAccount.java      # The BankAccount class (OOP model)
├── Main.java             # Entry point with menu-driven logic
└── run.sh                # Shell script to compile and run
```

---

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK) 8 or higher**
- A terminal / command prompt

Verify your Java installation:

```bash
java -version
javac -version
```

### Run with Shell Script

If you are on **Linux or macOS**, the easiest way is to use the provided shell script:

```bash
chmod +x run.sh
./run.sh
```

### Run Manually

**Step 1 — Compile:**

```bash
javac BankAccount.java Main.java
```

**Step 2 — Run:**

```bash
java Main
```

---

## 🖥️ Usage

Once running, you will see the main menu:

```
========================================
       BANK MANAGEMENT SYSTEM
========================================
  1. Create New Account
  2. Deposit Money
  3. Withdraw Money
  4. Transfer Money
  5. Check Balance
  6. View All Accounts
  7. Exit
```

Enter the number corresponding to your desired action and follow the on-screen prompts.

**Creating an account example:**
```
Enter Account Number (e.g. ACC-001): ACC-001
Enter Account Holder Name          : Tamim Ahmed
Enter Initial Deposit Amount (BDT) : 5000
```

---

## 📸 Sample Output

```
--- Create New Account ---
  Enter Account Number (e.g. ACC-001): ACC-001
  Enter Account Holder Name          : Tamim Ahmed
  Enter Initial Deposit Amount (BDT) : 5000

  [SUCCESS] Account created successfully!
  --------------------------
  Account Number : ACC-001
  Owner Name     : Tamim Ahmed
  Balance        : BDT 5000.0
  --------------------------

--- Deposit Money ---
  Enter Account Number: ACC-001
  Enter amount to deposit (BDT): 2000
  [SUCCESS] Deposited BDT 2000.0
  New Balance: BDT 7000.0
```

---

## ⚠️ Limitations

- Supports a **maximum of 10 accounts** (fixed-size array)
- Data is **not persistent** — all accounts are lost when the program exits
- No **interest calculation** or transaction history
- Single-user, **no authentication** system

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

> Built with ❤️ as a Java OOP practice project.
