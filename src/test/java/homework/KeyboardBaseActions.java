package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeyboardBaseActions extends TestBase {

    @Test
    public void test() {

        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement overMe = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(overMe);
        actions.click(overMe);
        // Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        actions.click(link1);
        waitFor(2);
        // Popup mesajini yazdirin
        String popUp = driver.switchTo().alert().getText();
        System.out.println(popUp);
        waitFor(2);
        // Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // “Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.xpath("//div[@id='click-box']")));

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.switchTo().alert().getText());

        // 8- “Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//div[@id='double-click']")));

    }
}
