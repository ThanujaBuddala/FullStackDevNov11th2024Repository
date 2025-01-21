package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class FruitNames20FirstRow {
    public static void main(String[] args) {
        writeFruitsInRow();
    }

    private static void writeFruitsInRow(){
        Workbook wb = null;
        Sheet sh = null;
        Row row = null;
        Cell cell = null;
        FileOutputStream fileOutputStream =null;
        try{
            wb = new XSSFWorkbook();
            sh = wb.createSheet("Sheet1");
           row = sh.createRow(0);
           for(int c=0;c<20;c++){
               cell = row.createCell(c);
               cell.setCellValue("Fruit"+(c+1));
           }
           fileOutputStream =new FileOutputStream("D:\\Excel\\Fruits.xlsx");
           wb.write(fileOutputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                wb.close();
                fileOutputStream.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
