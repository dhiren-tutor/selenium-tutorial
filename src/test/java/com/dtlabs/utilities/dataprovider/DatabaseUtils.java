package com.dtlabs.utilities.dataprovider;

import java.sql.*;

public class DatabaseUtils {

    public static Object[][] getDBData(String query) throws SQLException {


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "username", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        rs.last();
        int rowCount = rs.getRow();
        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();
        rs.beforeFirst();

        Object[][] data = new Object[rowCount][colCount];
        int i = 0;
        while (rs.next()) {
            for (int j = 1; j <= colCount; j++) {
                data[i][j - 1] = rs.getObject(j);
            }
            i++;
        }
        conn.close();
        return data;
    }
}
