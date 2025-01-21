package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class writeFlowersExcelFileData
{
    public static void main(String[] args)
    {
        String flowerNames[]={"Rose", "Tulip", "Daisy", "Sunflower", "Lily",
                "Orchid", "Marigold", "Jasmine", "Lotus", "Hibiscus",
                "Daffodil", "Lavender", "Chrysanthemum", "Bluebell", "Carnation",
                "Iris", "Peony", "Poppy", "Zinnia", "Petunia"};
        writeContent(flowerNames);
    }

    private static void writeContent(String [] flowerArray)
    {

        FileOutputStream fout=null;
        Workbook wb=null;
        Sheet sh=null;
        Row row=null;
        Cell cell=null;
        try
        {
            wb=new XSSFWorkbook();
            sh=wb.createSheet("Credentials");
            for(int r=0;r<flowerArray.length;r++){
                row=sh.createRow(r);
                cell = row.createCell(0);
                cell.setCellValue(flowerArray[r]);
               // cell.setCellValue("Flower"+(r+1));

            }

           fout=new FileOutputStream("D:\\Excel\\Flowers.xlsx");
           wb.write(fout);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                fout.close();
                wb.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
