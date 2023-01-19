package practice06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class C01_DownloadFile extends TestBase {
    @Test
    public void name() {

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browser = driver.findElement(By.xpath("//*[@aria-controls='supported-browsers']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(browser).perform();
        browser.click();
        waitFor(1);
        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();


        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//*[@class='XqQF9c'])[2]")).click();
        waitFor(1);


        //Açılan pencerede chromedriver'i indirelim
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
       driver.findElement(By.xpath("//*[text()='chromedriver_mac64.zip']")).click();
        waitFor(10);

        //Driver'in indiğini doğrulayalım
        String dosyaYolu = "/Users/haticebalci/Downloads/chromedriver_mac64";
        assert Files.exists(Paths.get(dosyaYolu));


    }
}