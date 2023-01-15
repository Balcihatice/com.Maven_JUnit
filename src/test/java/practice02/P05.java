package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P05 extends TestBase {

    @Test
    public void test(){
        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");


        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Techproeducation");

        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
        WebElement actualelementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
       Assert.assertTrue(actualelementalSelenium.isDisplayed());

        // Elemental Selenium linkine tıklayın
        actualelementalSelenium.click();

        List<String> windoWHandles = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Acilan pencerelerin handle degerleri : " + windoWHandles);
        driver.switchTo().window(windoWHandles.get(1));


        // Açılan sayfada sayfa başlığını yazdırınız
        String acilanSayfaTitle = driver.getTitle();
        System.out.println("Elemental Selenium başlığı = " + acilanSayfaTitle);;

        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement sourceLab = driver.findElement(By.xpath("//*[text()='Sauce Labs']"));
        Assert.assertTrue(sourceLab.isDisplayed());

        // Source labs linkine tıklayın
        System.out.println("----------------------------");
        sourceLab.click();
        List<String> windoWHandles2 = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("windoWHandles2 = " + windoWHandles2);
        driver.switchTo().window(windoWHandles2.get(2));
/*Bu sekilde 3. sayfanin windowHandle`i ilk liste ekleyebiliriz
windowHandles.add(driver.getWindowHandle());
System.out.println(windowHandles);
 */

        // Açılan sayfada sayfa başlığını yazdırınız
        String acilanSayfa2 = driver.getTitle();
        System.out.println("Source Labs sayfa Basligi = " + acilanSayfa2);


        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(windoWHandles2.get(0));

        // ilk sekmeyi kapatalım
          driver.close();
    }
}
