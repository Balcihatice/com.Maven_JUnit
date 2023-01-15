package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class WındowHandle extends TestBase {

    @Test
    public void test() {
//        Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

//        Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle = driver.getWindowHandle();

//        Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));

//        Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");

//        Sayfa title’nin “TECHPROEDUCATION” icermedigini test edin
        String techProTitle = driver.getTitle();
        Assert.assertFalse(techProTitle.contains("TECHPROEDUCATION"));

//        Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");


//        Sayfa title’nin “Walmart” icerdigini test edin
        String walmartTitle = driver.getTitle();
        Assert.assertTrue(walmartTitle.contains("Walmart"));

//        Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandle);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("https://www.amazon.com"));


    }
}
