package com.irctc.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadInput {

	public static XSSFWorkbook inputWorkbook;
	public static XSSFSheet inputSheet;
	public static XSSFRow inputRow;
	public static String cellValue;
	public static int totalRows;

	public static String source;
	public static String destination;
	public static String siteTitle;
	public static String url;

	// gets input keys for 'From'' field
	public static String sourceInput() {

		inputWorkbook = LoadInput.getInputWorkbook();
		inputSheet = inputWorkbook.getSheet("TrainList");
		totalRows = inputSheet.getPhysicalNumberOfRows();

		// checks for Source key in excel file and gets the value
		for (int i = 0; i < totalRows; i++) {
			cellValue = inputSheet.getRow(i).getCell(0).getStringCellValue();
			if (cellValue.equals("Source")) {
				source = inputSheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		return source;
	}

	// gets input keys for 'To'' field
	public static String destinationInput() {

		inputWorkbook = LoadInput.getInputWorkbook();
		inputSheet = inputWorkbook.getSheet("TrainList");
		totalRows = inputSheet.getPhysicalNumberOfRows();

		// checks for Destination key in excel file and gets the value
		for (int i = 0; i < totalRows; i++) {
			cellValue = inputSheet.getRow(i).getCell(0).getStringCellValue();
			if (cellValue.equals("Destination")) {
				destination = inputSheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		return destination;
	}

	// gets the url to navigate
	public static String urlInput() {

		inputWorkbook = LoadInput.getInputWorkbook();
		inputSheet = inputWorkbook.getSheet("TrainList");
		totalRows = inputSheet.getPhysicalNumberOfRows();

		// checks for URL key in excel file and gets the value
		for (int i = 0; i < totalRows; i++) {
			cellValue = inputSheet.getRow(i).getCell(0).getStringCellValue();
			if (cellValue.equals("URL")) {
				url = inputSheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		return url;
	}

	// checks for SiteTitle key in excel file and gets the value
	public static String siteTitleInput() {

		inputWorkbook = LoadInput.getInputWorkbook();
		inputSheet = inputWorkbook.getSheet("TrainList");
		totalRows = inputSheet.getPhysicalNumberOfRows();

		// checks for SiteTitle key in excel file and gets the value
		for (int i = 0; i < totalRows; i++) {
			cellValue = inputSheet.getRow(i).getCell(0).getStringCellValue();
			if (cellValue.equals("SiteTitle")) {
				siteTitle = inputSheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		return siteTitle;
	}
}
