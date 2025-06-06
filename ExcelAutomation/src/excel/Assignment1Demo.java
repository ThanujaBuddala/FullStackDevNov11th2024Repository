package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Assignment1Demo
{
    public static void main(String[] args)
    {
        readWritContent();
    }

    private static void readWritContent()
    {
        FileInputStream fin=null;
        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh1=null;
        Sheet sh2=null;
        Row row1=null;
        Row row2=null;
        Cell cell1=null;
        Cell cell2=null;
        try
        {
            fin=new FileInputStream("D:\\Excel\\StateNames.xlsx");
            wb=new XSSFWorkbook(fin);
           sh1= wb.getSheet("Sheet1");
           sh2=wb.getSheet("sheet2");
           if(sh2==null)
           {
               sh2=wb.createSheet("Sheet2");
           }
           int rc=sh1.getPhysicalNumberOfRows();
           for(int r=0;r<rc;r++)
           {
               row1=sh1.getRow(r);
              row2= sh2.getRow(r);
              if(row2==null)
              {
                  row2=sh2.createRow(r);
              }
              //int c=row1.getPhysicalNumberOfCells();
                  cell1=row1.getCell(0);
                  String data=cell1.getStringCellValue();
                  cell2=row2.getCell(9);
                  if(cell2==null)
                  {
                      cell2=row2.createCell(9);
                  }
                  cell2.setCellValue(data);
              }
           fout=new FileOutputStream("D:\\Excel\\StateNames.xlsx");
           wb.write(fout);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                wb.close();
              fin.close();
              fout.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

