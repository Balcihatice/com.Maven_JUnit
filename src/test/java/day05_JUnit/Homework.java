package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com");
    }

    @After
    public void tearDown() {

        driver.close();
    }


    @Test
    public void test01() {
        //https://www.youtube.com adresine gidin
        //=> Sayfa başlığının “YouTube” oldugunu test edin

        Assert.assertTrue(driver.getTitle().contains("YouTube"));

    }

    @Test
    public void test02() {
        //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]")).isDisplayed());

    }

    @Test
    public void test03() {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());

    }


    @Test
    public void test04() {
        // wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertTrue(driver.getTitle().contains("youtube"));
    }




}
