package entities;

public class Patient {
    // Patient properties
    public int patientId;
    public String patientFirstName;
    public String patientLastName;
    public String patientDOB;

    // Constructor
    public Patient(int patientId, String patientFirstName, String patientLastName, String patientDOB) {
        this.patientId = patientId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientDOB = patientDOB;
    };

    // Output
    @Override
    public String toString() {
        return "Patient: " + patientId + ", " + patientFirstName + ", " + patientLastName + ", " + patientDOB;
    };

    public static Patient fromString(String line) {
        String[] parts = line.split(", ");
        
        return new Patient(
            Integer.parseInt(parts[0]),
            parts[1],
            parts[2],
            parts[3]
        );
    };
}