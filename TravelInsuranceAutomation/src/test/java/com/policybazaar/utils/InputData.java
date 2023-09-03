package com.policybazaar.utils;

import java.util.Map;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// class to get input data
public class InputData {

	public  static XSSFWorkbook inputWorkbook;
	private static XSSFSheet inputSheet;
	private static XSSFCell inputCell;
	private static int totalRows;

	// loads travel insurance data from excel file and puts in map
	public static Map<String, String> getTravelInsuranceData() {

		Map<String, String> travelInsuranceData = new HashMap<>();
		DataFormatter dataFormatter = new DataFormatter();
		String key, value;

		inputSheet = inputWorkbook.getSheet("Travel");
		totalRows = inputSheet.getPhysicalNumberOfRows();

		for (int i = 0; i < totalRows; i++) {

			inputCell = inputSheet.getRow(i).getCell(0);
			key = dataFormatter.formatCellValue(inputCell);
			
			inputCell = inputSheet.getRow(i).getCell(1);
			value = dataFormatter.formatCellValue(inputCell);
		
			travelInsuranceData.put(key, value);
		}
		
		return travelInsuranceData;
	}

	// loads car insurance data from excel file and puts in map
	public static Map<String, String> getCarInsuranceData() {

		Map<String, String> carInsuranceData = new HashMap<>();
		DataFormatter dataFormatter = new DataFormatter();
		String key, value;

		inputSheet = inputWorkbook.getSheet("Car");
		totalRows = inputSheet.getPhysicalNumberOfRows();

		for (int i = 0; i < totalRows; i++) {

			inputCell = inputSheet.getRow(i).getCell(0);
			key = dataFormatter.formatCellValue(inputCell);
			
			inputCell = inputSheet.getRow(i).getCell(1);
			value = dataFormatter.formatCellValue(inputCell);
		
			carInsuranceData.put(key, value);
		}
		
		return carInsuranceData;
	}
}
