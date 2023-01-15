package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

  /*
     StateElementReferenceException
     StateElementReferenceException = eski kullanılamaz durumda olan, kullanıma artık elverişli olmayan durumlarda alınan hatadır.
     Sayfayı yenilediğimizde,
     sayfada ileri geri gittiğimizde meydana gelen exception'dır.

    Çözüm
       Elemanı tekrar bulmak.

 */

    @Test
    public void stateElementReferenceExceptionTest1() {

        //https://techproeducation.com adrse gidin
        driver.get("https://techproeducation.com");

        //LMS login linkine tikla ve o satfani url nin "lms" icerdigini test et
        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);

        lmsLogin.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));
        waitFor(5);

        //Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar git
        driver.navigate().back();//Tekrar ana sayfaya gel

        waitFor(5);
        lmsLogin.click();//LMS`e git

        /*
        lmsLogin linkini sayfa yenilendikten sonra (back() StaleElementReferenceException aldik
         */
    }

    @Test
    public void stateElementReferenceExceptionTest2() {
        //https://techproeducation.com adrse gidin
        driver.get("https://techproeducation.com");

        //LMS login linkine tikla ve o satfani url nin "lms" icerdigini test et
        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);

        //Sayfayi refresh yap
        driver.navigate().refresh();
        waitFor(5);

        //  SAYFA YENILENMEDEN ONCE BULDUGUM ELEMENTI, SAYFA YENILENDIKDEN SONRA KULLANMAK ISTEDIM
        lmsLogin.click();// org.openqa.selenium.StaleElementReferenceException
        // COZUM ESKI(SLATE ELEMENT) ELEMENTI TEKRAR LOCATE ET
        //  driver.findElement(By.linkText("LMS LOGIN")).click();

    }

}
