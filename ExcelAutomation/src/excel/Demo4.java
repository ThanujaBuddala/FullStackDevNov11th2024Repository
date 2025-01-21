package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class Demo4
{
    public static void main(String[] args)
    {
      writeContent();
    }

    private static void writeContent()
    {
        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh=null;
        Row row=null;
        Cell cell=null;
        try
        {
           wb=new XSSFWorkbook();
           sh=wb.createSheet("Credential");
           for(int r=0;r<20;r++)
           {
               row=sh.createRow(r);
               cell=row.createCell(r);
               cell.setCellValue("Country"+(r+1));
           }
           fout=new FileOutputStream("D:\\Excel\\Cnty.xlsx");
           wb.write(fout);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                fout.close();
                wb.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
