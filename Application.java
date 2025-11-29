import java.util.Scanner;
import entities.Drug;
import entities.Patient;
import patient_manager.DrugFileManager;
import patient_manager.PatientDatabaseManager;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;

        // Menu loop
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Save Drug to File");
            System.out.println("2. Read Drugs From File");
            System.out.println("3. Save Patient to Database");
            System.out.println("4. Read Patients From Database");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scan.nextInt();
            scan.nextLine();

            // Handle menu choices
            switch (choice) {
                case 1:
                    System.out.print("Drug ID: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Drug Name: ");
                    String name = scan.nextLine();
                    System.out.print("Drug Cost: ");
                    double cost = scan.nextDouble();
                    scan.nextLine();
                    System.out.print("Dosage: ");
                    String dosage = scan.nextLine();

                    DrugFileManager.addDrug(new Drug(id, name, cost, dosage));
                    break;

                case 2:
                    System.out.println("\n--- Drugs From File ---");
                    DrugFileManager.loadDrugs().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Patient ID: ");
                    int patientId = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Patient First Name: ");
                    String patientFirstName = scan.nextLine();
                    System.out.print("Patient Last Name: ");
                    String patientLastName = scan.nextLine();
                    System.out.print("Patient DOB: ");
                    String patientDOB = scan.nextLine();

                    PatientDatabaseManager.addPatient(new Patient(patientId, patientFirstName, patientLastName, patientDOB));
                    break;

                case 4:
                    System.out.println("\n--- Patients From Database ---");
                    PatientDatabaseManager.getAllPatients().forEach(System.out::println);
                    break;
                
                case 0:
                    System.out.println("Exiting...");
                    break;
            };

        } while (choice != 0);

        scan.close();
    };
}
