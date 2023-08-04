package com.irctc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
	public static String inputFile = ReadProperties.getProperties().getProperty("inputFile");

	public static XSSFWorkbook inputWorkBook() {
		
		Properties properties = ReadProperties.getProperties();
		String inputFile = properties.getProperty("inputFile");
		
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(inputFile));
			inputWorkbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputWorkbook; 
	}

	public static String sourceInput() {

		ReadInput.inputSheet = inputWorkbook.getSheet("TrainList");
		ReadInput.totalRows = inputSheet.getPhysicalNumberOfRows();

		for (int i = 0; i < totalRows; i++) {
			cellValue = inputSheet.getRow(i).getCell(0).getStringCellValue();
			if (cellValue.equals("Source")) {
				source = inputSheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		return source;
	}

	public static String destinationInput() {

		try (FileInputStream fileInputStream = new FileInputStream(new File(inputFile))) {
			inputWorkbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ReadInput.inputSheet = inputWorkbook.getSheet("TrainList");
		ReadInput.totalRows = inputSheet.getPhysicalNumberOfRows();

		for (int i = 0; i < totalRows; i++) {
			cellValue = inputSheet.getRow(i).getCell(0).getStringCellValue();
			if (cellValue.equals("Destination")) {
				destination = inputSheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		return destination;
	}

	public static String urlInput() {

		try (FileInputStream fileInputStream = new FileInputStream(new File(inputFile))) {
			inputWorkbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ReadInput.inputSheet = inputWorkbook.getSheet("TrainList");
		ReadInput.totalRows = inputSheet.getPhysicalNumberOfRows();

		for (int i = 0; i < totalRows; i++) {
			cellValue = inputSheet.getRow(i).getCell(0).getStringCellValue();
			if (cellValue.equals("URL")) {
				url = inputSheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		return url;
	}

	public static String siteTitleInput() {

		try (FileInputStream fileInputStream = new FileInputStream(new File(inputFile))) {
			inputWorkbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ReadInput.inputSheet = inputWorkbook.getSheet("TrainList");
		ReadInput.totalRows = inputSheet.getPhysicalNumberOfRows();

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
