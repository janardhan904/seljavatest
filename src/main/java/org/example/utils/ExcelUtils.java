package org.example.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    public static FileInputStream fileInputStream;
    public static FileOutputStream fileOutputStream;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static int getRowCount(String xlfile, String xlsheet) throws IOException {
        fileInputStream = new FileInputStream(xlfile);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(xlsheet);
        int rowcount = sheet.getLastRowNum();
        workbook.close();
        fileInputStream.close();
        return rowcount;
    }

    public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
        fileInputStream = new FileInputStream((xlfile));
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(xlsheet);
        row = sheet.getRow(rownum);
        int cellcount = row.getLastCellNum();
        workbook.close();
        fileInputStream.close();
        return cellcount;

    }

    public static String getCellData(String xlfile, String xlsheet, int rownum, int column) throws IOException {
        fileInputStream = new FileInputStream((xlfile));
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(xlsheet);
        row = sheet.getRow(rownum);
        cell = row.getCell(column);
        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        } catch (Exception e) {
            data = "";
        }
        workbook.close();
        fileInputStream.close();
        return data;

    }

    public static void setCellData(String xlfile, String xlsheet, int rownum, int column, String data) throws IOException {
        fileInputStream = new FileInputStream((xlfile));
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(xlsheet);
        row = sheet.getRow(rownum);
        cell = row.getCell(column);
        cell.setCellValue(data);
        fileOutputStream = new FileOutputStream(xlfile);
        workbook.write(fileOutputStream);
        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
