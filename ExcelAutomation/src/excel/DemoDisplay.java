package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  DemoDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Alphabet from A to Z or a to z:");
        String itemName = scanner.next();

        String resultString = getItemDescription(itemName);
        System.out.println(resultString);
    }

    private static String getItemDescription(String itemName){
        FileInputStream fileInputStream = null;
        Workbook workbook = null;
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        String finalResult = "";
        try {
            fileInputStream = new FileInputStream("D:\\Excel\\ItemFile.xlsx");
            workbook=new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet("Sheet1");
            String itemDescription = "";
            String itemInCell = "";
            boolean isItemFount = false;
            int rowCount = sheet.getPhysicalNumberOfRows();
            for(int r=0;r<rowCount;r++){
                row = sheet.getRow(r);
                cell = row.getCell(0);
                itemInCell =  cell.getStringCellValue();

                if(isItemFount = itemInCell.compareToIgnoreCase(itemName)==0){
                    cell = row.getCell(1);
                    itemDescription = cell.getStringCellValue();
                    break;
                }
            }
            if(isItemFount) {
                finalResult =  itemInCell + " For " + itemDescription;
            }else {
                finalResult =  "Could not find any match with "+'"'+itemName+'"';
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                workbook.close();
                fileInputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return finalResult;
    }
}


