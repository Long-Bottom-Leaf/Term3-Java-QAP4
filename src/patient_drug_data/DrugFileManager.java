package patient_drug_data;

import entities.Drug;
import java.io.*;
import java.util.ArrayList;

public class DrugFileManager {
    private static final String FILE_NAME = "drug_data.txt";

    public static void addDrug(Drug drug) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(drug.toString() + System.lineSeparator());
            System.out.println("Drug saved to file!");

        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public static ArrayList<Drug> loadDrugs() {
        ArrayList<Drug> drugList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                drugList.add(Drug.fromString(line));
            }

            System.out.println("Drugs loaded from file!");

        } catch (IOException error) {
            error.printStackTrace();
        }

        return drugList;
    }
}
