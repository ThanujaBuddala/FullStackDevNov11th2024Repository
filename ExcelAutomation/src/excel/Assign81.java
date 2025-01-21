package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Assign81
{
    public static void main(String[] args) {
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
            fin=new FileInputStream("D:\\Excel\\FruitNum.xlsx");
            wb=new XSSFWorkbook(fin);
            sh1=wb.getSheet("Sheet1");
            sh2=wb.getSheet("Sheet2");
            if(sh2==null)
            {
                sh2=wb.createSheet("Sheet2");
            }
            rowsh2 = sh2.getRow(3);
            if (rowsh2==null)
            {
                rowsh2 = sh2.createRow(3);
            }
            rowsh2 = sh2.getRow(4);
            if (rowsh2==null)
            {
                rowsh2 = sh2.createRow(4);
            }
            int rc = sh1.getPhysicalNumberOfRows();
            int r =3;
            int col4 =0;
            int col5 =0;
            for (int i = 0;i<rc;i++)
            {
                rowsh1 = sh1.getRow(i);
                int cc = rowsh1.getPhysicalNumberOfCells();
                for (int j=0;j<cc;j++)
                {
                    cellsh1 = rowsh1.getCell(j);
                    String data = cellsh1.getStringCellValue();
                    System.out.printf("%-12s",data);
                    if (r==3)
                    {
                        rowsh2 = sh2.getRow(r);
                        cellsh2 =rowsh2.getCell(col4);
                        if (cellsh2==null)
                        {
                            cellsh2 = rowsh2.createCell(col4);
                        }
                        cellsh2.setCellValue(data);
                        col4++;
                    }
                    if (r==4)
                    {
                        rowsh2 = sh2.getRow(r);
                        cellsh2 =rowsh2.getCell(col5);
                        if (cellsh2==null)
                        {
                            cellsh2 = rowsh2.createCell(col5);
                        }
                        cellsh2.setCellValue(data);
                        col5++;
                    }
                    r=4;

                }
                System.out.println();
            }
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                wb.close();
                fin.close();
                fout.close();
            } catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
