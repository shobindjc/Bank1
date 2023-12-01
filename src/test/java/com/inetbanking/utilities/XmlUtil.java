package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XmlUtil {
public static FileInputStream fi;
public static XSSFWorkbook workbook;
public static XSSFSheet st;
public static XSSFRow rw;
public static XSSFCell cl;


public static int getRowCount(String filePath, String sheet) throws IOException
{
	fi = new FileInputStream(filePath);
	workbook = new XSSFWorkbook(fi);
	st = workbook.getSheet("Sheet1");
	int rowCount = st.getLastRowNum();
	workbook.close();
	fi.close();
	return rowCount;
}

public static int getColumnCount(String filePath, String sheet) throws IOException
{
	fi = new FileInputStream(filePath);
	workbook = new XSSFWorkbook(fi);
	st = workbook.getSheet("Sheet1");
	rw = st.getRow(0);
	int colCount = rw.getLastCellNum();
	workbook.close();
	fi.close();
	return colCount;
}

public static String getCellData(String filePath, String sheet, int row, int col) throws IOException
{
	fi = new FileInputStream(filePath);
	workbook = new XSSFWorkbook(fi);
	st = workbook.getSheet("Sheet1");
	rw = st.getRow(row);
	cl = rw.getCell(col);
	String clData = cl.toString();
	workbook.close();
	fi.close();
	return clData;
}
}
