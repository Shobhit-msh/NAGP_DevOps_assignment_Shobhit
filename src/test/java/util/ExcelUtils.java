package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	static XSSFWorkbook wb;
	static XSSFSheet sh;

	public ExcelUtils(String sheetname)
	{
		try {
			wb = new XSSFWorkbook(System.getProperty("user.dir")+"/src/test/resources/testdata/TestFile.xlsx");
			sh = wb.getSheet(sheetname);
		} 
		catch (IOException e) {		
			e.printStackTrace();
		}

	}

	public static int getRowCount() {		
		int rowCount=0;
		try {			
			rowCount=sh.getPhysicalNumberOfRows();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		};
		return rowCount;
	}
	
	public static int getColumnCount() {	
		int columnCount=0;
		try {			
			columnCount=sh.getRow(0).getPhysicalNumberOfCells();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		};
		return columnCount;
	}
	
	public static String getCellData(int row, int col) {
		String cellData=null;
		try {
			if(sh.getRow(row).getCell(col).getCellType().toString().equals("STRING"))
			{
				cellData=sh.getRow(row).getCell(col).getStringCellValue();
			}
			else
			{
				cellData=String.valueOf(sh.getRow(row).getCell(col).getNumericCellValue());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		};
		return cellData;
	}

}
