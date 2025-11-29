# Java File & Database Persistence Project

## Project Overview
This project demonstrates how to persist and retrieve data in Java using **two techniques**:  
1. File-based persistence (text files)  
2. Database-backed persistence (PostgreSQL via JDBC)

Users can save and read **Drug** data to/from a text file, and save and read **Patient** data to/from a PostgreSQL database. A simple menu-driven interface is provided for interaction.

---

## Features
- **Entities:**  
  - `Drug` (drugId, drugName, drugCost, dosage)  
  - `Patient` (patientId, patientFirstName, patientLastName, patientDOB)

- **File I/O:**  
  - Save drugs to `drug_data.txt`  
  - Read drugs from file

- **Database I/O (PostgreSQL):**  
  - Insert patients into the `patients` table  
  - Retrieve all patients from the database  

- **Menu Options:**  
  1. Save Drug to File  
  2. Read Drugs From File  
  3. Save Patient to Database  
  4. Read Patients From Database  
  0. Exit

---

## Getting Started

### 1. Database Setup
- Create a PostgreSQL database (e.g., `mydb`)  
- Run the `patient_table.sql` script to create the `patients` table:

```sql
CREATE TABLE patients (
    patientId INT PRIMARY KEY,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    dob VARCHAR(20)
);

### 2. Update PatientDatabaseManager.java With Your Database

private static final String DB_URL = "jdbc:postgresql://localhost:5432/mydb";
private static final String USER = "postgres";
private static final String PASSWORD = "your_password";

### 3. Running the Application

1. Compile and run Application.java.

2. Use the menu to:

- Add drugs to the text file
- Read drugs from the file
- Add patients to the database
- View patients from the database