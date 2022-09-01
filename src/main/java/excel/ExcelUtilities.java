package excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtilities {

    public Map<String, String> getRowData(String fileName, String sheetName, int row) throws IOException {

        FileInputStream fis = new FileInputStream("src/test/testData/"+fileName+".xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int lastColumnNum = sheet.getRow(1).getLastCellNum();

        Map<String, String> data = new HashMap<>();

        for (int i = 0; i < lastColumnNum; i++){
            data.put(sheet.getRow(1).getCell(i).getStringCellValue().trim(),sheet.getRow(row+1).getCell(i).getStringCellValue().trim());
        }

        return data;
    }

}
