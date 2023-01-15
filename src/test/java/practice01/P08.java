package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P08 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {
        //   https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //   cookies uyarisini kabul ederek kapatin
        //   Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //   Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
        //   Bulunan sonuc sayisini yazdirin
        String[] sonucsayisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        String sonuc = sonucsayisi[1];
        System.out.println("sonuc Sayisi: " + sonuc);
        //   sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        sonuc = sonuc.replaceAll("\\D", "");//tum noklama isaretlerini hiclikle degistir.
        int istenensayi = 10000000;
        Assert.assertTrue(Integer.parseInt(sonuc) > istenensayi);
        //   Sayfayi kapatin
        driver.close();
    }

}
