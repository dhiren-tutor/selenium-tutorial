package com.dtlabs.tests;

import com.dtlabs.utilities.dataprovider.DatabaseUtils;
import com.dtlabs.utilities.dataprovider.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestClass {

    @DataProvider(name = "excelDataProvider")
    public Object[][] excelDataProvider() throws IOException {
        return ExcelUtils.getExcelData("path/to/excel/file.xlsx", "Sheet1");
    }

    @Test(dataProvider = "excelDataProvider")
    public void testMethod1(String param1, String param2) {
        System.out.println("Param1: " + param1 + ", Param2: " + param2);
    }

    @DataProvider(name = "dbDataProvider")
    public Object[][] dbDataProvider() throws SQLException, SQLException {
        return DatabaseUtils.getDBData("SELECT * FROM tablename");
    }

    @Test(dataProvider = "dbDataProvider")
    public void testMethod2(String param1, String param2) {
        System.out.println("Param1: " + param1 + ", Param2: " + param2);
    }
}
