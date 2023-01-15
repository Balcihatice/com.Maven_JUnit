package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot1 extends TestBase {
    /*
    Selenium tun ekran goruntusu nasil alinir?
        -tum ekran goruntusu seleniumdan gelen getScreenshotAs metotu ile alinir.
        -getScreenshotAs metotu seleniumdaki TakesScreenshot api indan gelir
     */
    @Test
    public void fullPagScreenShot() throws IOException {

        // Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");

        // 1. Ekran goruntusunu getScreenshotAs metotu ile alip File olarak olusturalim
        File goruntu = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        waitFor(2);
        // 2. Almis oldugum ekran goruntusunu belirledigim bir PATH e kaydet.dir=directory=dpsya

        //Kayit ismini dinamik yapmak icin date objesi kullandim
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//Ekran goruntulerinin saatlerini de ekledik
        String path = System.getProperty("user.dir") + "//test-output/EkranGoruntuleri/" + currentTime + "-image.png";

        File hedef = new File(path);
        waitFor(2);
        // 3. Goruntum ile dosyami birlestirip kaydet
        FileUtils.copyFile(goruntu, new File(path));//copyFile da her iki parametre String olmak zorunda

        /*
       // Bu sekilde tek seferdede yazabiliriz
        FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)//goruntu
                , new File(System.getProperty("user.dir") + "test-output/EkranGoruntuleri/image.png"));//path
        */

        // -“QA” aramasi yap
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA", Keys.ENTER);

        waitFor(3);

        // Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA”
        String expected = "Search Results for: QA";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expected.contains(text));

       // ARA DAN REUSABLE METHOD OLUSTURUP GORUNTUYU ALALIM
        takeScreenShotOfPage(); //Ekran goruntusu alma methodunu cagirdik
    }


}