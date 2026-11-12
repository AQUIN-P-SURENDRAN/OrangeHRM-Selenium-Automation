package com.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {

        String path = "src/test/resources/Testdata/LoginData.xlsx";

        FileInputStream file = new FileInputStream(path);

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheetAt(0);

        DataFormatter formatter = new DataFormatter();

        List<Object[]> loginData = new ArrayList<>();

        // Start from row 1 because row 0 contains headers
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);

            // Ignore completely empty rows
            if (row == null) {
                continue;
            }

            // Read username and password safely
            String username = formatter.formatCellValue(row.getCell(0));
            String password = formatter.formatCellValue(row.getCell(1));

            // Ignore rows where both cells are empty
            if (username.trim().isEmpty() && password.trim().isEmpty()) {
                continue;
            }

            loginData.add(new Object[] { username, password });
        }

        workbook.close();
        file.close();

        // Convert List to Object[][]
        Object[][] data = new Object[loginData.size()][2];

        for (int i = 0; i < loginData.size(); i++) {
            data[i][0] = loginData.get(i)[0];
            data[i][1] = loginData.get(i)[1];
        }

        return data;
    }
}