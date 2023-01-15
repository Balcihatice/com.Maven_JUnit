package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLOutput;

public class C01_ExcelRead {
    @Test

    public void readExcelTest() throws IOException {
        //Java dosyasina sag tikla ve ressources adinda bir klasor olustur
        //Excel dosyasini bu klasore at
        //resources dosyasi excel ,word, text... gibi data dostalarinin oldugu klasor klasorun adidir.

        //WORKBOOK > WORKSHEET/SHEET > ROW (SATIR) > CELL(VERI HUCRESI)

        String path = "./src/test/java/resources/Capitals.xlsx";//  <./ > yi biz ekledik


        //DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);


        //EXCELL DOSYASINI AC/WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);


        //SAYFAYI AC/SHEET1(ASIL EXCEL DOSYASINA GIT)
        //  Sheet sheet1 = workbook.getSheetAt(0);
        Sheet sheet1 = workbook.getSheet("sheet1");//sheet1 isimli sayfayi ac

        //SATIRDAKI ILK VERIYI AL
        Row row1 = sheet1.getRow(0); //row objesi olusturduk icine attik

        //O VERIYI YAZDIR
        Cell cell1 = row1.getCell(0);//ilk huxredeki datayi al.


        //O VERIYI YAZDIR
        System.out.println(cell1);

        //1.SATIR 2. SUTUN
        Cell cell2 = sheet1.getRow(0).getCell(1);
        System.out.println(cell2);
    }
}
