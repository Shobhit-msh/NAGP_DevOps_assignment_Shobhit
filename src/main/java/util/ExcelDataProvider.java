package util;

public class ExcelDataProvider {

	public static Object[][] getData(String sheetname) {
		ExcelUtils excel = new ExcelUtils(sheetname);
		int rowCount= excel.getRowCount();
		int colCount= excel.getColumnCount();
		
		Object data[][]= new Object[rowCount-1][colCount];

		for (int i=1;i<rowCount;i++)
		{
			for (int j=0;j<colCount;j++)
			{
				String cellData=excel.getCellData(i, j);
				data[i-1][j]=cellData;
			}
			System.out.println();
		}
		
		return data;
	}

	public static void main(String a[])
	{
		getData("Invalid_Login");
	}
}
