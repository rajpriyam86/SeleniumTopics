package ProjectAutomation2;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ProjectAutomation.FileReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DataValidationTest {

    private Connection conn;

    @BeforeClass
    public void setUp() throws SQLException, ClassNotFoundException {
        DatabaseUtility.connectToDatabase("jdbc:oracle:thin:@localhost:1521:xe", "priyam", "12345");
        conn = DatabaseUtility.getConnection();
    }

    @AfterClass
    public void tearDown() throws SQLException {
        DatabaseUtility.closeConnection();
    }

    @DataProvider(name = "MRNData")
    public Object[][] getData() {
        String filePath = "C:/Users/Dell/Documents/Sample.OUT";
        List<String> lines = FileUtility.readFile(filePath);
        List<String> MRNs = FieldExtractor.extractField(lines, 1, 8);
        List<String> firstNames = FieldExtractor.extractField(lines, 9, 16);
        List<String> middleNames = FileReader.extractSubstring(filePath, 17, 20);
        List<String> lastNames = FileReader.extractSubstring(filePath, 21, 29);
        List<String> dobs = FileReader.extractSubstring(filePath, 30, 38);

        Object[][] data = new Object[MRNs.size()][2];
        for (int i = 0; i < MRNs.size(); i++) {
            data[i][0] = MRNs.get(i);
            data[i][1] = firstNames.get(i);
        }
        return data;
    }

    @Test(dataProvider = "MRNData")
    public void validateFirstName(String mrnFromFile, String expectedFirstName) throws SQLException {
        ResultSet rs = DatabaseQuery.fetchRecordByMRN(conn, "Tap_person", mrnFromFile);

        if (rs.next()) {
            String firstNameFromDB = rs.getString("FIRST_NAME").trim();
            Assert.assertEquals(firstNameFromDB, expectedFirstName, "First Name does not match for MRN: " + mrnFromFile);
        } else {
            Assert.fail("No record found in DB for MRN: " + mrnFromFile);
        }

        rs.close();
    }
}
