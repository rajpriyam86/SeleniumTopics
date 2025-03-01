package ProjectAutomation2;

import java.util.ArrayList;
import java.util.List;

public class FieldExtractor {

    public static List<String> extractField(List<String> lines, int startPos, int endPos) {
        List<String> fields = new ArrayList<>();
        int startIndex = startPos - 1;
        int endIndex = endPos;

        for (String line : lines) {
            if (line.length() >= endIndex) {
                fields.add(line.substring(startIndex, endIndex).trim());
            } else {
                fields.add("Error: Line is too short. Length: " + line.length());
            }
        }
        return fields;
    }
}
