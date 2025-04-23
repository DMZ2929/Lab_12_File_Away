import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int recordCount = 1;
        boolean more = true;

        while (more) {
            System.out.print("First Name: ");
            String first = in.nextLine();

            System.out.print("Last Name: ");
            String last = in.nextLine();

            String id = String.format("%06d", recordCount);  // 000001 format

            System.out.print("Email: ");
            String email = in.nextLine();

            System.out.print("Year of Birth: ");
            String year = in.nextLine();

            String record = String.join(", ", first, last, id, email, year);
            records.add(record);
            recordCount++;

            System.out.print("Add another record? (Y/N): ");
            String response = in.nextLine();
            more = response.equalsIgnoreCase("Y");
        }

        System.out.print("Enter filename to save (add .csv): ");
        String fileName = in.nextLine();

        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String rec : records) {
                writer.write(rec + "\n");
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

