import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Excel {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\shobhitmishra01\\eclipse-workspace\\Selenium_NAGP_Project\\src\\test\\java\\Book1.xlsx";

        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(new File(filePath)))) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet

            for (Row row : sheet) {
                for (Cell cell : row) {
                    String cellValue = cell.getStringCellValue();
                    System.out.print(cell.getCellType() + "1\t");
                    System.out.print(cellValue + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
