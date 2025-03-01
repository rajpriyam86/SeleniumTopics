package ProjectAutomation2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQuery {

    public static ResultSet fetchRecordByMRN(Connection conn, String tableName, String mrn) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE MRN = '" + mrn.trim() + "'";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public static int getTotalRecords(Connection conn, String tableName) throws SQLException {
        String query = "SELECT COUNT(*) AS total FROM " + tableName;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {
            return rs.getInt("total");
        }
        return 0;
    }
}
