package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C02_WindowHandle2 extends TestBase {

    //  https://testcenter.techproeducation.com/index.php?page=multiple-windows
    //  Title in ‘Windows’ oldugunu test edin
    //  Click here a tiklayin
    //  Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
    @Test
    public void test() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String window1 = driver.getWindowHandle();

        String title1 = driver.getTitle();
        Assert.assertEquals("Windows", title1);

        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windowHandless = driver.getWindowHandles();
        for (String w : windowHandless) {
            if (!w.equals(window1)) {
                driver.switchTo().window(w);
                break;
            }
        }
        Assert.assertEquals("New Window", driver.getTitle());


    }


}



