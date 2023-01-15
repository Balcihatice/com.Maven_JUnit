package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropdownOptions {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();//chromun ayarlarini yaptik
        driver = new ChromeDriver(); //driver objesi olusturduk
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // ...Exercise 2...
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
        // dropdown'dan "Baby" secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        //2-select objesi olusturulmali
        Select select = new Select(ddm);
        //3-opsiyon secilir
        select.selectByVisibleText("Baby");
        // sectiginiz option'i yazdirin
        String sectigimOption = select.getFirstSelectedOption().getText();
        System.out.println("Sectigim opsiyon : " + sectigimOption);
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edelim
         List<WebElement> tumOptionlar = select.getOptions();
         int actualOptionSayisi = tumOptionlar.size();
         int expectedOptionsayisi = 28;
         Assert.assertEquals(expectedOptionsayisi,actualOptionSayisi);

    }
}
