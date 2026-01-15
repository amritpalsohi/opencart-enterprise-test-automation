package com.opencart.Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

public class TestDataUtility {

    public List<String> getTestData(String feature) throws IOException {

        List<String> testData = new ArrayList<String>();

        Properties property = new Properties();
        String propertyFilePath = System.getProperty("user.dir") + "/src/main/java/com/opencart/Resources/GlobalData.properties";
        FileInputStream fis = new FileInputStream(propertyFilePath);
        property.load(fis);

        String environment = property.getProperty("Environment");

        String testDataFilePath = "";

        if(environment.equalsIgnoreCase("QA")) {
            testDataFilePath = System.getProperty("user.dir") + "/src/main/java/com/opencart/Resources/TestData_QA.xlsx";
        }else if(environment.equalsIgnoreCase("PROD")) {
            testDataFilePath = System.getProperty("user.dir") + "/src/main/java/com/opencart/Resources/TestData_PROD.xlsx";
        }
        FileInputStream excelFile = new FileInputStream(testDataFilePath);

        XSSFWorkbook excelSheet = new XSSFWorkbook(excelFile);

        int numberOfSheets = excelSheet.getNumberOfSheets();

        for(int i=0; i<numberOfSheets; i++) {
            if(excelSheet.getSheetName(i).equalsIgnoreCase("Login")) {

                XSSFSheet loginSheet = excelSheet.getSheetAt(i);

                Iterator<Row> rows = loginSheet.iterator();

                while(rows.hasNext()) {
                    Row row = rows.next();

                    Iterator<Cell> cells = row.cellIterator();

                    while(cells.hasNext()) {
                        if(cells.next().getStringCellValue().equalsIgnoreCase(feature)) {
                            testData.add(cells.next().getStringCellValue());
                            testData.add(cells.next().getStringCellValue());
                        }
                    }

                }


            }
        }

        return testData;


    }
}
