package com.policybazaar.utils;

import java.util.Map;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputData {

	public static XSSFWorkbook inputWorkbook;
	public static XSSFSheet inputSheet;
	public static XSSFRow inputRow;
	public static String cellValue;
	public static int totalRows;

	public static Map<String, String> getTravelInsuranceData() {

		Map<String, String> travelInsuranceData = new HashMap<>();

		inputSheet = inputWorkbook.getSheet("Travel");
		totalRows = inputSheet.getPhysicalNumberOfRows();
		String key, value;

		for (int i = 0; i < totalRows; i++) {

			key = inputSheet.getRow(i).getCell(0).getStringCellValue();
			value = inputSheet.getRow(i).getCell(1).getStringCellValue();

			travelInsuranceData.put(key, value);
			
		}
		return travelInsuranceData;
	}

	public static Map<String, String> getCarInsuranceData() {

		Map<String, String> carInsuranceData = new HashMap<>();

		inputSheet = inputWorkbook.getSheet("Car");
		totalRows = inputSheet.getPhysicalNumberOfRows();
		String key, value;

		for (int i = 0; i < totalRows; i++) {

			key = inputSheet.getRow(i).getCell(0).getStringCellValue();
			value = inputSheet.getRow(i).getCell(1).getStringCellValue();
			
			carInsuranceData.put(key, value);
		}
		return carInsuranceData;
	}
}
