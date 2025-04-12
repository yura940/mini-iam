# 🛡️ Mini IAM – Java Identity & Access Simulation

**Simulate a real-world IAM system in Java — like a mini SailPoint**  
Manage users, roles, permissions and simulate provisioning logic from JSON.

---

## 📌 Overview

This project is a lightweight simulation of an **Identity & Access Management (IAM)** platform, inspired by tools like **SailPoint IdentityIQ**.  
It reads users, roles, and applications from `JSON` files and simulates provisioning by logging assigned permissions based on user roles.

---

## 🧰 Tech Stack

- ⚙️ Java 17  
- 📦 Maven  
- 🧩 Jackson (for JSON parsing)  
- 🧪 Ready for JUnit tests (optional)

---

## 🧠 Features

✅ Load users, roles, and applications from JSON  
✅ Assign permissions automatically based on role  
✅ Simulate provisioning logic  
✅ Log all access grants to `provisioning.log`  
✅ Lightweight & terminal-based (no Spring, no database)  

---

## 📁 Project Structure

```
mini-iam/
├── config/
│   ├── users.json              # Input: list of users
│   ├── roles.json              # Input: roles and permissions
│   └── applications.json       # Optional: app/permission registry
├── src/main/java/com/yura/iam/
│   ├── App.java                # Main class
│   ├── model/
│   │   ├── User.java
│   │   ├── Role.java
│   │   └── Application.java
│   └── service/
│       └── ProvisioningService.java
├── provisioning.log            # Output: simulated provisioning results
└── pom.xml
```

---

## 🚀 Getting Started

### 1. Compile the project

```bash
mvn clean package
```

### 2. Run the application

```bash
java -cp target/mini-iam-1.0-SNAPSHOT.jar com.yura.iam.App
```

📂 Output will be saved to `provisioning.log` and printed to the terminal.

---

## 📓 Sample Data

**users.json**
```json
[
  {
    "id": "u001",
    "name": "Jean Dupont",
    "email": "jean@example.com",
    "role": "RH",
    "active": true
  }
]
```

**roles.json**
```json
[
  {
    "name": "RH",
    "permissions": ["HR_APP", "HR_DASHBOARD"]
  }
]
```

**Log output**
```
[2025-04-12T...] Provisioned user Jean Dupont (...) with role RH → Permissions: HR_APP, HR_DASHBOARD
```

---

## 👤 Author

**Yura**  
Security-conscious Java developer focused on IAM, automation and access governance.  
This project was built as a technical showcase for real-world IAM concepts.

---

## 🧠 Next Steps

- [ ] Add JUnit tests for logic validation  
- [ ] Extend with a REST API (Spring Boot)  
- [ ] Add support for de-provisioning, role changes  
- [ ] Export access reviews to PDF/CSV  

---

> 🚀 Use this repo to demonstrate IAM concepts, clean Java architecture, and your readiness for IAM/Java roles!

