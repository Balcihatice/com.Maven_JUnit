package practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P06_RenkDegistir extends TestBase {


    @Test
    public void test() {

        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        // -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement ikinci = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement ucuncu = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));

        Actions actions = new Actions(driver);
        driver.manage().window().getPosition();


    }
}
