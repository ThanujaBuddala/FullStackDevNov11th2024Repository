package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FlowerAndColourDemo
{
    public static void main(String[] args)
    {
        readWriteContent();
    }

    private static void readWriteContent()
    {
        FileInputStream fin=null;
        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh1=null;
        Sheet sh2=null;
        Row rowsh1=null;
        Row rowsh2=null;
        Cell cellsh1=null;
        Cell cellsh2=null;
        try
        {
            fin=new FileInputStream("D:\\Excel\\FruitAndColorDemo.xlsx");
             wb=new XSSFWorkbook(fin);
            sh1=wb.getSheet("Sheet1");
            sh2=wb.getSheet("Sheet2");
            if(sh2==null)
            {
                sh2=wb.createSheet("Sheet2");
            }
            int rc=sh1.getPhysicalNumberOfRows();
            for(int r=0;r<rc;r++)
            {
                rowsh2=sh1.getRow(r);
                rowsh2=sh2.getRow(3);
                rowsh2=sh2.getRow(4);
                if(rowsh2==null)
                {
                    rowsh2=sh2.createRow(0);
                    rowsh2=sh2.createRow(1);
                }
                cellsh1=rowsh1.getCell(r);
                cellsh1=rowsh1.getCell(r);
                String data=cellsh1.getStringCellValue();
                System.out.printf("%-15s",data);
                System.out.println();
                cellsh2=rowsh2.getCell(3);
                cellsh2=rowsh2.getCell(4);
                if(cellsh2==null)
                {
                    cellsh2=rowsh2.createCell(r);
                    cellsh2=rowsh2.createCell(r);

                }
                cellsh2.setCellValue(data);
            }
            fout=new FileOutputStream("D\\Excel\\FruitAndColorDemo.xlsx");
            wb.write(fout);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                wb.close();
                fout.close();
                fin.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
