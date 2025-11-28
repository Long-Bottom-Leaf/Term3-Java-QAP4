package entities;

public class Patient {
    private int patientId;
    private String patientFirstName;
    private String patientLastName;
    private int patientDOB;

    public Patient(int patientId, String patientFirstName, String patientLastName, int patientDOB) {
        this.patientId = patientId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientDOB = patientDOB;
    };

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
            Integer.parseInt(parts[3])
        );
    }
}