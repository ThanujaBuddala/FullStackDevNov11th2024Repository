package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class Color20Names5thColumn
{
    public static void main(String[] args)
    {
        colorWriteContent();
    }

    private static void colorWriteContent()
    {
        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh=null;
        Row row=null;
        Cell cell=null;
        try
        {
            wb=new XSSFWorkbook();
            sh=wb.createSheet("Sheet1");
            for(int r=0;r<20;r++)
            {
                row=sh.createRow(r);
                cell=row.createCell(4);
                cell.setCellValue("Color"+(r+1));
            }
            fout=new FileOutputStream("D:\\Excel\\Color.xlsx");
            wb.write(fout);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                wb.close();
                fout.close();
            } catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }

}
