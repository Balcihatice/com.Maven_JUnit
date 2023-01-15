package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementExcepption extends TestBase {

    @Test
    public void test() {
        driver.get("https://techproeducation.com");

        driver.findElement(By.xpath("//*[@type='searchh']"))//org.openqa.selenium.NoSuchElementException:
                .sendKeys("QA"+ Keys.ENTER);

    }
}
