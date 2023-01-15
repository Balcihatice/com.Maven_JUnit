package day04_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WindowHandle {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test() {

        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
        String ilkSaydaHandle = driver.getWindowHandle();

        // 2- nutella icin arama yapın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella", Keys.ENTER);

        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella", Keys.ENTER);
        WebElement ilkUrun = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        ilkUrun.click();

        // 4- yeni tab'da acilan urunun basligini yazdirin
        WebElement urunBasligi = driver.findElement(By.xpath("//*[@id='productTitle']"));
        System.out.println(urunBasligi.getText());

        // 5- ilk sayfaya gecip url'i yazdırın

        driver.switchTo().window(ilkSaydaHandle);
        System.out.println(driver.getCurrentUrl());


    }
}