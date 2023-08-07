package com.irctc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//  class to create single instance of input excel file
public class LoadInput {

    private static FileInputStream fileInputStream;
    private static XSSFWorkbook workBook;

    // method to open and return instance of input workbook
    public static XSSFWorkbook getInputWorkbook() throws Exception {

        if (workBook == null) {
            Properties properties = ReadProperties.getProperties();
            String inputFile = properties.getProperty("inputFile");
            try {
                fileInputStream = new FileInputStream(new File(inputFile));
                LoadInput.workBook = new XSSFWorkbook(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
                throw new Exception("Workbook cannot be loaded");
            }
            return workBook;
        } else
            return workBook;
    }

    // method to close instance of input workbook
    public static void closeInputWorkbook() throws Exception {
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Could not close workbook");
        }
    }
}
