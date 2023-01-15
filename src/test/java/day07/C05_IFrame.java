package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void test() {
        // Iframe nedir?
        // https://testcenter.techproeducation.com/index.php?page=iframe
        // Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        // Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        // Son olarak footer daki ‘Powered By’ yazisini varligini test edilip

        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        String anaMetin = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
        //tag[.='metin'] Bana bu tag`li su metni ver
        //tag[text()='metin']
        String expectedText = "black border";
        Assert.assertTrue(anaMetin.contains(expectedText));

        // Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //iframe switch yapmam sart
        driver.switchTo().frame(0);//ilk iframe e switch yapiyoruz

        String icMetin = driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        //  //*[.='Applications lists']-->> * ilede locate edebiliriz  (.= metin alirken demek zorundayiz)
        String expectedMetin = "Applications lists";
        Assert.assertEquals(expectedMetin, icMetin);

        //        Alternatif olarak altdaki secenekler de kullanilabilir
//        Assert.assertTrue(expectedText1.contains(icMetin));
//        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed());

        //   Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
//        Ana sayfadaki Povered By yazinisi test etmek istiyorum Ama driver hala iframein icinde
//        Iframein disina cikmak icin driver.switchTo().defaultContent/parentFrame
        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'])[1]//p")).getText();//footerin altindaki p tagini ver dedik

        Assert.assertTrue(footerText.contains("Power By"));


    }
/* INTERVIEW
 1-Bir sayfadaki toplam iframe sayisini otomasyonla nasil buluruz?
 Iframe ler iframe tagi kullanilarak olusturulur,Bu durumda find element by frame locaterini kullaanarak tum iframeleri bulabilirim
  **driver.findElements(By.tagName("iframe")); (a dersek tum linkleri alir...)
  **driver.findElements(By.xpath("//iframe")); Bunlar bize list dondurur.

 2-Tekrar ana sayfaya nasil donersin?
 2 farkli yol vardir.defaultContent ya da parentFrame methodlarini kullanarak gecis yapabiliriz
 driver.switchTo().defaultContent

 3- DefaultContenet ve parentFrame arasindaki fark nedir?
  Oncelikle her ikiside iframein disina cikartir.Fark defaulContent direk ana sayfaya atlatir
  parentFrame ise bir ust seviyeye atlatir.


 4-Bir test case in fail(kalma) etme sebepleri neler olabilir
   -> Yanlis locator. Cozum elementi tekrar Locator etmek. Degisken element var ise ona gore dinamik bir xpath yazariz
   -> (Wait/syscronization) driver ve web site sekronize olmali, Buna Bekeleme hatalari denir. Cozum:1)implicit wait de yeterli sure oldugundan
   emin olmaliyiz. O sureyi artirabiliriz.30 saniye verilebilir. 2)Explicit wait kullanilabilir.
   -> Iframe. Cozum: switchTo() iframe
   -> Alert. Cozum: switchTo alert yani driveri atlatmak
   -> New window(yeni pencere) : switchTo window ile yeni pencereye girecegiz.

 */
}
