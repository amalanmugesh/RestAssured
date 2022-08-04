package com.utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
	  
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public Excelutils(String excelfile,String sheetname) throws IOException {
		try {
		 workbook = new XSSFWorkbook(excelfile);
		 sheet = workbook.getSheet(sheetname);
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	
	public static Object getcellvalue(int row,int cell ) throws IOException {
		
	DataFormatter formatter = new DataFormatter();
	Object formatCellValue = formatter.formatCellValue(sheet.getRow(row).getCell(cell));
	return formatCellValue;
	
	

	}

}
