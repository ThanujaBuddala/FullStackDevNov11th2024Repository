package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class Country20DiagonallyMainDemo {
   static FileOutputStream fileOutputStream = null;
   static Workbook workbook = null;
    public static void main(String[] args) {
        try {
            workbook = new XSSFWorkbook();
            writeCountryDiagonally();
            rightToLeftWriteCountryDiagonally();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                workbook.close();
                fileOutputStream.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static void writeCountryDiagonally(){

        Sheet sheet = null;
        Row row = null;
        Cell cell =null;
        try {

            sheet = workbook.createSheet("Sheet1");
            for(int r=0;r<20;r++){
                row = sheet.createRow(r);
                cell = row.createCell(r);
                cell.setCellValue("Country"+(r+1));
            }
            fileOutputStream = new FileOutputStream("D:\\Excel\\Country.xlsx");
            workbook.write(fileOutputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void rightToLeftWriteCountryDiagonally(){

        Sheet sheet = null;
        Row row = null;
        Cell cell =null;
        try {

            sheet = workbook.createSheet("Sheet2");
            for(int r=20-1;r>=0;r--){
                row = sheet.createRow(r);
                cell = row.createCell(20-r);
                cell.setCellValue("Country"+(20-r+1));
            }
            fileOutputStream = new FileOutputStream("D:\\Excel\\Country.xlsx");
            workbook.write(fileOutputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
