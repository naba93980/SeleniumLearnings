package com.irctc.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

// class to write output in excel file
public class WriteOutput {
	public static XSSFWorkbook outputWorkbook;
	public static XSSFSheet outputSheet;
	public static XSSFRow outputRow;

	public static void output(List<WebElement> trains) {

		Properties properties = ReadProperties.getProperties();
		String outputFile = properties.getProperty("outputFile");

		// creates TrainList sheet in workbook, and a row in sheet
		outputWorkbook = new XSSFWorkbook();
		outputSheet = outputWorkbook.createSheet("TrainList");
		outputRow = outputSheet.createRow(0);
		outputRow.createCell(0).setCellValue("No.");
		outputRow.createCell(1).setCellValue("Train Name");

		// loops over list, creates row for each train, sets value
		for (int i = 1; i <= trains.size(); i++) {
			outputRow = outputSheet.createRow(i);
			outputRow.createCell(0).setCellValue(i);
			outputRow.createCell(1).setCellValue(trains.get(i - 1).getText());
		}

		// workbook is written in the output filestream
		try (FileOutputStream fileOutputStream = new FileOutputStream(
				new File(outputFile))) {
			outputWorkbook.write(fileOutputStream);
			System.out.println("Output saved");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
