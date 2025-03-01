package ProjectAutomation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

    public static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (FileInputStream fstream = new FileInputStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {

            String strLine;
            while ((strLine = br.readLine()) != null) {
                lines.add(strLine.trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
            lines.add("Error reading file: " + e.getMessage());
        }
        return lines;
    }
}
