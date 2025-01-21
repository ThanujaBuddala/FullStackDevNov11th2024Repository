package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class City20Names10thRow
{
    public static void main(String[] args)
    {
        cityWriteContent();
    }

    private static void cityWriteContent()
    {
        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh=null;
        Row row=null;
        Cell cell=null;
        try
        {
            wb = new XSSFWorkbook();
            sh=wb.createSheet("Sheet1");
            row=sh.createRow(9);
            for(int c=0;c<20;c++)
            {
                cell = row.createCell(c);
                cell.setCellValue("CityName" + (c + 1));
            }
             fout=new FileOutputStream("D:Excel\\City.xlsx");
            wb.write(fout);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                wb.close();
                fout.close();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
