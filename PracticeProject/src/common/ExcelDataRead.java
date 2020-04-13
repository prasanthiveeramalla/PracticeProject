package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataRead {

  public FileInputStream fi;
  public HSSFWorkbook wb;
  public HSSFSheet ws;
  public File f;



  public ExcelDataRead(String excelpath) {
    try {
      f = new File(excelpath);
      fi = new FileInputStream(f);
      wb = new HSSFWorkbook(fi);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Object getdata(HSSFSheet sheet, int row, int col) {
    Object dataObj = null;
    /*int cellType = (sheet.getRow(row).getCell(col) != null) ? sheet.getRow(row).getCell(col).getCellType() : 3;
//    System.out.println("Cell Type:->  " + cellType);
    switch (cellType) {
    case Cell.CELL_TYPE_NUMERIC:
      dataObj = (long) sheet.getRow(row).getCell(col).getNumericCellValue();
      break;
    case Cell.CELL_TYPE_STRING:
      dataObj = sheet.getRow(row).getCell(col).getStringCellValue();
      break;
    case Cell.CELL_TYPE_BLANK:
      dataObj = new Object();
      break;
    default:
      dataObj = new Object();
      break;
    }*/
    
    dataObj =sheet.getRow(row).getCell(col).getStringCellValue();
    return dataObj;
  }

  public int getRowCount(String sheetName) {
    int row = wb.getSheet(sheetName).getLastRowNum();
    return row;
  }

  public int getColCount(String sheetName) {
    int col = wb.getSheet(sheetName).getRow(0).getLastCellNum();
    return col;
  }

  public void updateStatus(String sheetName, int row, String status) throws Exception {
    ws = wb.getSheet(sheetName);
    if (row > 0) {
      ws.getRow(row).createCell(10).setCellValue(status);
      FileOutputStream out = new FileOutputStream(f);
      wb.write(out);
      out.close();
      System.out.println("Excel written successfully..");
    }
  }
  
  
  public static String readExcelSheetData(int r, int c) throws IOException {
	                         //I have placed an excel file 'Test.xlsx' in my D Driver 
	 // FileInputStream fis = new FileInputStream("testdata\\Practice.xlsx");
	  FileInputStream fis = new FileInputStream("D:\\Test.xlsx");
	  
	  XSSFWorkbook workbook1 = new XSSFWorkbook(fis);
	  XSSFSheet sheet = workbook1.getSheetAt(0);
	                         //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
	                         //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
	 // Row row = sheet.getRow(0);
	 // Cell cell = row.getCell(0);
	//XSSFCell a = sheet.getRow(r).getCell(c) ;       
	 System.out.println(sheet.getRow(r).getCell(c).getStringCellValue());
	  //String cellval = cell.getStringCellValue();
	  //System.out.println(cellval);
	  return sheet.getRow(r).getCell(c).getStringCellValue();
	
	 }
  public static Object[][] readExcelData() {
		ExcelDataRead ex = new ExcelDataRead("testdata\\Practice.xlsx");
		String sheetName = "Sheet1";
		HSSFSheet ws = ex.wb.getSheet(sheetName);
		int rows = ex.getRowCount(sheetName);
		int cols = ex.getColCount(sheetName);
		System.out.println("No. of Rows in the Sheet (" + sheetName + "):-> " + rows);
		System.out.println("No. of Columns in the Sheet (" + sheetName + "):-> " + cols);
		Object[][] data = new Object[0][];
		Object[][] temp, temp1;
		for (int i = 0; i < rows; i++) {
			String sheet = ex.getdata(ws, i + 1, 0).toString();
			String flag = ex.getdata(ws, i + 1, 1).toString();
			if ("Y".equals(flag)) {
				temp = getDataFromSheet(ex, sheet);
				int size = temp.length + data.length;
				temp1 = data;
				data = new Object[size][];
				System.arraycopy(temp1, 0, data, 0, temp1.length);
				System.arraycopy(temp, 0, data, temp1.length, temp.length);

			} else {
				System.out.println("Sheet (" + sheet + ") skipped as flag is '" + flag + "'.");
			}
		}
		System.out.println("Data in all sheets:-> " + Arrays.deepToString(data));
		return data;
	}

	public static Object[][] getDataFromSheet(ExcelDataRead xl, String sheetName) {
		Object[][] sheetData = null;
		HSSFSheet ws = xl.wb.getSheet(sheetName);
		int rows = xl.getRowCount(sheetName);
		int cols = xl.getColCount(sheetName);
		System.out.println("Sheet '" + sheetName + "' having (Rows, Cols):-> (" + rows + ", " + cols + ")");
		sheetData = new Object[rows][cols + 2];
		for (int i = 0; i < rows; i++) {
			int j = 0;
			for (; j < cols; j++) {
				sheetData[i][j] = xl.getdata(ws, i + 1, j);
			}
			sheetData[i][j++] = sheetName;
			sheetData[i][j++] = i + 1;
		}
		return sheetData;
	}
	

}