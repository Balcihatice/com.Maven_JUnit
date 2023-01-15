package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Actions02 extends TestBase {
    @Test
    public void test() {


        // Bir Class olusturalim KeyboardActions2
        // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);

        // videoyu izlemek icin Play tusuna basin
        //Play tusunu dogru locate etmemize ragmen videoyu calistirmadi,
        //Bunun uzerine html kodlarini inceleyince Playin aslinda bir iframe icinde oldugunu gorduk
        //Bu durumda once iframei locate etip sonra switchTo ile iframe e gecmelyiz

        //Burda iframe var once iframei locate edelim sonra driviri icine alalim

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        // videoyu izlemek icin Play tusuna basin
        WebElement play = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeYazisi = driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazisi.isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

        driver.switchTo().parentFrame();

        WebElement Powerful = driver.findElement(By.xpath("//span[text()='Powerful, but easy to misuse']"));
        Assert.assertTrue(Powerful.isDisplayed());

    }
}