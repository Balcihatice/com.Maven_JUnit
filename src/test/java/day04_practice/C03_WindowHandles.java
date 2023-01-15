package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_WindowHandles extends TestBase {

    @Test
    public void test() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String ilkSayfaHandle = driver.getWindowHandle();
        // arama motoruna 'oppo' yazıp aratın
        driver.findElement(By.xpath("//*[@id='searchData']")).sendKeys("oppo", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='lazy cardImage'])[1]")).click();


        // Basligin 'Oppo' icerdigini test edin.
        Set<String> windowHandles = driver.getWindowHandles();
        for (String w : windowHandles) {
            if (!w.equals(ilkSayfaHandle)) {
                driver.switchTo().window(w);
            }
        }
        WebElement baslik = driver.findElement(By.xpath("//h1[@class='proName']"));
        String baslik1 = baslik.getText();
        Assert.assertTrue(baslik1.contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(ilkSayfaHandle);
        System.out.println(driver.getTitle());

    }
}
