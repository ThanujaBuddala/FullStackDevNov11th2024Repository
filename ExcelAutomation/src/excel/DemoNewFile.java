package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DemoNewFile
{
    public static void main(String[] args) {
        studentDetails();
    }

    private static void studentDetails()
    {
        FileInputStream fin=null;
        FileOutputStream fout=null;
        Workbook wb1=null,wb2=null;
        Sheet sh1=null,sh2=null;
        Row row1=null,row2=null;
        Cell cell1=null,cell2=null;
        try
        {
           fin=new FileInputStream("D:\\Excel\\StudentDetails.xlsx");
           wb1=new XSSFWorkbook(fin);
            wb2=new XSSFWorkbook();

           sh1=wb1.getSheet("Sheet1");
           sh2=wb2.getSheet("StudentData");
           if(sh2==null)
           {
               sh2=wb2.createSheet("StudentData");
           }
           int rc=sh1.getPhysicalNumberOfRows();
           for(int r=0;r<rc;r++)
           {
               row1=sh1.getRow(r);
               row2=sh2.getRow(r);
               if(row2==null)
               {
                   row2=sh2.createRow(r);
               }

               int cc=row1.getPhysicalNumberOfCells();
               for(int c=0;c<cc;c++)
               {
                   cell1=row1.getCell(c);
                   cell2=row2.getCell(c);
                   if(cell2==null)
                   {
                       cell2=row2.createCell(c);
                   }
                   String data=cell1.getStringCellValue();
                   cell2.setCellValue(data);
               }
           }
           fout=new FileOutputStream("D:\\Excel\\NewStudentDetails.xlsx");
           wb2.write(fout);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
               fin.close();
              fout.close();
               wb1.close();
               wb2.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
