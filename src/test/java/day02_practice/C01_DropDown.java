package day02_practice;

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

public class C01_DropDown {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        // driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın

        //Dropdown 3 adimda handle edilir.
        //1.adim
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='dropdown']"));
        //2.Adim select obj olusturun
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        String sectigimOptionIndex = select.getFirstSelectedOption().getText();//sectigim objeyi web element olarak getiriyor.gettxt Stringe donusturuyor
        System.out.println("SECTIGIM OPSION INDEX : " + sectigimOptionIndex);
        Thread.sleep(3000);

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
        String option2 = select.getFirstSelectedOption().getText();
        System.out.println("Option2 = " + option2);
        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");

        String sectigimOptionVisible = select.getFirstSelectedOption().getText();
        System.out.println("sectigimOptionVisible = " + sectigimOptionVisible);

        // Tüm option'ları yazdırın
        List<WebElement> tumOptionlar = select.getOptions();
        //Stringe cevirmeliyiz,foreach kullanalim
        int sayac = 1;
        for (WebElement each : tumOptionlar) {
            System.out.println(sayac + " . OPTION " + each.getText());
            sayac++;
        }


        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int expected = 3;
        int actual = tumOptionlar.size();
        Assert.assertEquals(expected,actual);

    }
}
