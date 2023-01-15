package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P10 {

    /*
- ebay sayfasina gidiniz
- electronics bolumune tiklayiniz
- genisligini 225 ve uzunlugu 225 olan resimlerin hepsine tiklayalaim
- her sayfanin basligini yazdiralim
- sayfayi kapatalim
 */
   static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();//chromun ayarlarini yaptik
        driver = new ChromeDriver(); //driver objesi olusturduk
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        for (int i = 0; i < 24; i++) {
            List<WebElement> fotograflar = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            fotograflar.get(i).click();
            System.out.println("Sayfa basligi : " + driver.getTitle());
            driver.navigate().back();
        }
    }
    @AfterClass
    public void tearDown() {
       driver.close();
    }


}
