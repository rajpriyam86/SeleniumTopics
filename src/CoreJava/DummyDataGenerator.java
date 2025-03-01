package CoreJava;

import com.github.javafaker.Faker;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DummyDataGenerator {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy"); // Oracle-compatible format for dates
        SimpleDateFormat dateFormatCsv = new SimpleDateFormat("MM/dd/yyyy");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("F:/Automation Project/WinSCP/Legacy_data_2.txt"))) {

            // Step 1: Generate dummy data and write to file
            for (int i = 0; i < 1000; i++) {
                // Generate random values
                String mrn = String.format("%-8s", String.format("%05d", random.nextInt(100000))); // Length: 8
                String firstName = String.format("%-8s", faker.name().firstName()); // Length: 8
                String middleName = String.format("%-3s", faker.lorem().character()); // Length: 3
                String lastName = String.format("%-9s", faker.name().lastName()); // Length: 9
                String dob = String.format("%-9s", dateFormat.format(faker.date().birthday(1, 100))); // Length: 9
                String gender = String.format("%-10s", faker.bool().bool() ? "Male" : "Female"); // Length: 10

                String coverageId = String.format("%-8s", String.format("%05d", random.nextInt(100000))); // Length: 8
                String subscriberMrn = String.format("%-8s", String.format("%06d", random.nextInt(1000000))); // Length: 8

                String effectiveStartDate = String.format("%-10s", dateFormatCsv.format(faker.date().past(365, TimeUnit.DAYS))); // Length: 10
                String effectiveEndDate = String.format("%-10s", dateFormatCsv.format(faker.date().future(365, TimeUnit.DAYS))); // Length: 10

                String space1 = "  "; // Space from position 85-86
                String personCovered = String.format("%-1s", faker.bool().bool() ? "Y" : "N"); // Length: 1
                String space2 = "   "; // Space from position 88-90
                String personRelationToSub = String.format("%-8s", faker.random().nextBoolean() ? "Self" : "Spouse"); // Length: 8

                String coverageStartDate = String.format("%-10s", dateFormatCsv.format(faker.date().past(365, TimeUnit.DAYS))); // Length: 10
                String space3 = "  "; // Space from position 109-110
                String coverageEndDate = String.format("%-10s", dateFormatCsv.format(faker.date().future(365, TimeUnit.DAYS))); // Length: 10

                // Ensure groupId is within the range 1002 to 1008
                int groupIdValue = 1002 + random.nextInt(7); // Generates value between 1002 and 1008
                String groupId = String.format("%-6s", groupIdValue); // Length: 6

                // Add extra spaces or fields to make total length > 128 characters
                String extraField = String.format("%-4s", "EXTR"); // Length: 4 to reach 130 characters

                // Write to file in fixed width format
                String line = mrn + firstName + middleName + lastName + dob + gender + coverageId + subscriberMrn +
                        effectiveStartDate + effectiveEndDate + space1 + personCovered + space2 + personRelationToSub +
                        coverageStartDate + space3 + coverageEndDate + groupId + extraField;

                writer.write(line);
                writer.newLine();
            }

            System.out.println("Data written to file successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
