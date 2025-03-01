package ProjectAutomation;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DataValidationTest {

    private Connection conn;

    @BeforeClass
    public void setUp() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priyam", "12345");
    }

    @AfterClass
    public void tearDown() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    @DataProvider(name = "MRNData")
    public Object[][] getData() {
        String filePath = "C:/Users/Dell/Documents/Sample.OUT";
        List<String> MRNs = FileReader.extractSubstring(filePath, 1, 8);
        List<String> firstNames = FileReader.extractSubstring(filePath, 9, 16);
        List<String> MiddleNames = FileReader.extractSubstring(filePath, 17, 20);
        
        Object[][] data = new Object[MRNs.size()][3];
        for (int i = 0; i < MRNs.size(); i++) {
            data[i][0] = MRNs.get(i);
            data[i][1] = firstNames.get(i);
            data[i][2] = MiddleNames.get(i);
        }
        return data;
    }

    @Test(dataProvider = "MRNData")
    public void validateFirstName(String mrnFromFile, String expectedMiddleName) throws SQLException {
    	System.out.println(expectedMiddleName);
    	
    }
/*        String query = "select * from Tap_person where MRN = '" + mrnFromFile.trim() + "'";
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(query);

        if (rs.next()) {
            String firstNameFromDB = rs.getString("FIRST_NAME").trim();  // Trim the database value as well
            String middleNameFromDB = rs.getString("MIDDLE_NAME");
            Assert.assertEquals(firstNameFromDB, expectedFirstName, "First Name does not match for MRN: " + mrnFromFile);
            Assert.assertEquals(middleNameFromDB, expectedMiddleName, "M Name does not match for MRN: " + mrnFromFile);

        } else {
            Assert.fail("No record found in DB for MRN: " + mrnFromFile);
        }

        rs.close();
        s.close();
    }*/
}
