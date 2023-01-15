package homework;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Actions01 extends TestBase {

    @Test
    public void test() {

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);

        WebElement kutuFirst = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(kutuFirst).perform();

        //  Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        actions.click(link1).perform();

        //  Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //  Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        waitFor(3);
        //“Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold().perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin


        actions.release().perform();
        waitFor(3);
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClick).perform();


    }


}
