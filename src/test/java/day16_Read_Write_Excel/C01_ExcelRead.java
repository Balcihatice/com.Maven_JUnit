package day16_Read_Write_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test

    public void readExcelTest() throws Exception {
        //Java dosyasina sag tikla ve ressources adinda bir klasor olustur
        //Excel dosyasini bu klasore at
        //resources dosyasi excel ,word, text... gibi data dostalarinin oldugu klasor klasorun adidir.

        //WORKBOOK > WORKSHEET/SHEET > ROW (SATIR) > CELL(VERI HUCRESI)

        String path = "./src/test/java/resources/Capitals.xlsx";//  <./ > yi biz ekledik,oncekileride aldik

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
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println(cell12);

        //3.satir 1.sutun yazdir ve O verirnin France oldugunu test et
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France", cell31);

        //Exceldeki toplam satir sayisini bul
        int toplamSatirSayisi = sheet1.getLastRowNum() + 1;//son satir numarasi.index sifirdan basliyor,saymasayilari 1 den,o yuzden +1 ekledik
        System.out.println(toplamSatirSayisi);

        //Kullanilan toplam satir sayisi bul(bazi hucreler bos ise)
        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println(kullanilanToplamSatirSayisi);//1 den basliyor

        //COUNTRY, CAPITALS key ve valulari map`e alip print et
        //  {{USA,D,C},{FRANCE,PARIS},...}
        // Variable olusturalim. Bu variable exceldeki countr, capital verilerini tutacak

        Map<String, String> ulkeBaskentleri = new HashMap<>();

        for (int satirSayisi = 1; satirSayisi < kullanilanToplamSatirSayisi; satirSayisi++) {

            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country, capital);

        }
        System.out.println(ulkeBaskentleri);

    }
}