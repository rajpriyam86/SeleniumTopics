package ProjectAutomation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    /**
     * Extracts a substring from each line in the specified file for given positions.
     * 
     * @param filePath  The path of the file to read.
     * @param startPos  The starting position (1-based index).
     * @param endPos    The ending position (1-based index, inclusive).
     * @return A list of extracted substrings.
     */
    public static List<String> extractSubstring(String filePath, int startPos, int endPos) {
        List<String> substrings = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            int startIndex = startPos - 1;  // Convert 1-based index to 0-based index
            int endIndex = endPos;  // End index re mains as it is

            while ((strLine = br.readLine()) != null) {
                if (strLine.length() > 100) {
                    if (strLine.length() >= endIndex) {
                        // Trim the substring before adding to the list
                        substrings.add(strLine.substring(startIndex, endIndex).trim());
                    } else {
                        substrings.add("Error: Line is too short for the given positions. Line Length: " + strLine.length());
                    }
                } else {
                    substrings.add("Error: Line is too short. Length: " + strLine.length());
                }
            }

            br.close();
            fstream.close();

        } catch (IOException e) {
            e.printStackTrace();
            substrings.add("Error reading file: " + e.getMessage());
        }

        return substrings;
    }
}
