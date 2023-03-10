package day17_JsExecutors;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class   C03_JSExecutor_Type extends TestBase {
    //1)typeTest metotu olustur
    // 2)Techpro education ana sayfasina git
    // 3)Arama kutusuna QA yaz
    @Test
    public void name() {
        //1)typeTest metotu olustur
        // 2)Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        waitFor(3);

        // 3)Arama kutusuna QA yaz
        waitFor(3);
        typeWithJS(driver.findElement(By.xpath("//input[@type='search']")), "QA");

    }
}
