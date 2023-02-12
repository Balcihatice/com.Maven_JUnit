package day16_Read_Write_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {

        //WORKSHEET > SHEET > ROW > CELL > YAZDIR ? KAYDET

        //WORKBOOK > WORKSHEET/SHEET > ROW (SATIR) > CELL(VERI HUCRESI)

        String path = "./src/test/java/resources/Capitals.xlsx";//  <./ > yi biz ekledik

        //DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

        //EXCELL DOSYASINI AC/WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //SAYFAYI AC/SHEET1(ASIL EXCEL DOSYASINA GIT)
        //  Sheet sheet1 = workbook.getSheetAt(0);
        Sheet sheet1 = workbook.getSheet("sheet1");//sheet1 isimli sayfayi ac

        //ILK SATIRA GIT / ROW
        Row row1 = sheet1.getRow(0); //row objesi olusturduk icine attik

        //ILK SATIR 3. SUTUNU CREAT ET
        Cell cell3 = row1.createCell(2);//java orayi null gibi dusunmesin diye creat ettik(sadece tikladik)

        //NUFUS YAZ
        cell3.setCellValue("NUFUS");

        //2.Satir 3.Sutuna 45000
        sheet1.getRow(1).createCell(2).setCellValue("45000");

        //3.satir 3. sutuna 35000
        sheet1.getRow(2).createCell(2).setCellValue(35000);

        //KAYDET: KAYIT ISLEMI FILE OUTPUT STREAM ILE YAPILIR.
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

    }
}
