package patient_drug_data;

import entities.Patient;
import java.sql.*;
import java.util.ArrayList;

public class PatientDatabaseManager {
    // database connection parameters
    private static final String DB_URL = "";
    private static final String USER = "";
    private static final String PASSWORD = "";

    public static void addPatient(Patient patient) {
        String insertSQL = "INSERT INTO patients (patientID, patientFirstName, patientLastName, patientDOB) VALUES (?, ?, ?, ?,)";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement prepStmt = connection.prepareStatement(insertSQL))
        {
            prepStmt.setInt(1, patient.patientId);
            prepStmt.setString(2, patient.patientFirstName);
            prepStmt.setString(3, patient.patientLastName);
            prepStmt.setString(4, patient.patientDOB);

            prepStmt.executeUpdate();
            System.out.println("Patient added successfully!");

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public static ArrayList<Patient> getAllPatients() {
        ArrayList<Patient> patients = new ArrayList<>();

        String selectSQL = "SELECT * FROM patients";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery(selectSQL))
        {
            while (results.next()) {
                patients.add(new Patient(
                    results.getInt("patientID"),
                    results.getString("patientFirstName"),
                    results.getString("patientLastName"),
                    results.getString("patientDOB")
                ));
            }

        } catch (SQLException error) {
            error.printStackTrace();
        }

        return patients;
    }

}
