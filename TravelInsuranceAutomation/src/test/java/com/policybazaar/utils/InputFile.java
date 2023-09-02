package com.policybazaar.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//  class to create single instance of input excel file
public class InputFile {

//	private static FileInputStream fileInputStream;
	private static XSSFWorkbook workBook;

	// method to open and return instance of input workbook
	public static XSSFWorkbook openInputWorkbook() throws Exception {

		if (workBook == null) {

			Properties properties = ReadProperties.getProperties();
			String inputFile = properties.getProperty("inputFile");

			try {
				workBook = new XSSFWorkbook(new File(inputFile));
			} catch (IOException e) {
				e.printStackTrace();
				throw new Exception("Unable to load workbook");
			}
			return workBook;

		} else
			return workBook;
	}

	// method to close instance of input workbook
	public static void closeInputWorkbook() throws Exception {
		try {
			workBook.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Unable to close workbook");
		}
	}
}
