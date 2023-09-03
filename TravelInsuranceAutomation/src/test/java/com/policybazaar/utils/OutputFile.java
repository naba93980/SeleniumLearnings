package com.policybazaar.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

// class to create and write output data
public class OutputFile {

	public static XSSFWorkbook outputWorkbook;
	public static XSSFRow outputRow;
	public static String outputFile;

	public static void createOutputFile() {

		Properties properties = ReadProperties.getProperties();
		outputFile = properties.getProperty("outputFile");
		outputWorkbook = new XSSFWorkbook();
	}

	public static class TravelInsurance {

		public static void output(List<WebElement> insuranceName, List<WebElement> insurancePrice,
				List<WebElement> insuranceCompany) {

			// creates Travel sheet in workbook, and a row in sheet
			XSSFSheet outputSheet = outputWorkbook.createSheet("Travel");
			outputRow = outputSheet.createRow(0);
			outputRow.createCell(0).setCellValue("Insurance name");
			outputRow.createCell(1).setCellValue("Insurance price");
			outputRow.createCell(2).setCellValue("Insurance company");

			// loops over list, creates row for each insurance plan, sets value
			for (int i = 1; i <= insuranceName.size(); i++) {
				outputRow = outputSheet.createRow(i);
				outputRow.createCell(0).setCellValue(insuranceName.get(i - 1).getText());
				outputRow.createCell(1).setCellValue(insurancePrice.get(i - 1).getText());
				outputRow.createCell(2).setCellValue(insuranceCompany.get(i - 1).getText());
			}
		}
	}

	public static class CarInsurance {

		public static void output(List<WebElement> invalidData) {

			// creates Car sheet in workbook
			XSSFSheet outputSheet = outputWorkbook.createSheet("Car");
			outputRow = outputSheet.createRow(0);
			outputRow.createCell(0).setCellValue("Invalid details");

			// loops over list, creates row for each invalid data, sets value
			for (int i = 1; i <= invalidData.size(); i++) {
				outputRow = outputSheet.createRow(i);
				outputRow.createCell(0).setCellValue(invalidData.get(i - 1).getText());
			}
		}
	}
	
	public static class InsuranceProducts {
		
		public static void output(List<WebElement> products) {
			
			// creates Health sheet in workbook
			XSSFSheet outputSheet = outputWorkbook.createSheet("Health");
			outputRow = outputSheet.createRow(0);
			outputRow.createCell(0).setCellValue("Health Products");
			
			// loops over list, creates row for each product, sets value
			for (int i = 1; i <= products.size(); i++) {
				outputRow = outputSheet.createRow(i);
				outputRow.createCell(0).setCellValue(products.get(i - 1).getText());
			}
		}
	}

	public static void flush() throws Exception {

		// workbook is written in the output file stream
		try (FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFile))) {
			outputWorkbook.write(fileOutputStream);
			System.out.println("Output file saved");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Could not save output");
		}
	}
}
