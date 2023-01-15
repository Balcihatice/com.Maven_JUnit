package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Actions03 extends TestBase {

    @Test
    public void test01() {

//    Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");

//    Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropBox);
        List<WebElement> dropDown = select.getOptions();
        for (WebElement w : dropDown) {
            System.out.println(w.getText());
        }
//    dropdown menude 40 eleman olduğunu doğrulayın
        int count = dropDown.size();
        Assert.assertEquals(28, count);
    }


    // Test02
    @Test
    public void test02() {

        //    dropdown menuden elektronik bölümü seçin
        driver.get("https://www.amazon.com");
        WebElement dropBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropBox);
        select.selectByVisibleText("Electronics");

        //    arama kutusuna iPhone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("iPhone", Keys.ENTER);
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        //bulunan sonuç sayısını yazdırın



        //    sonuc sayisi bildiren yazinin iphone icerdigini test edin

        //    ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']")).click();

        //    ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String title = driver.getTitle();
        String fiyat = driver.findElement(By.xpath("//*[@class='a-offscreen']")).getText();

    }


    //    Test03
    @Test
    public void test03() {


//    yeni bir sekme açarak amazon anasayfaya gidin
//    dropdown’dan bebek bölümüne secin
//    bebek puset aratıp bulundan sonuç sayısını yazdırın
//    sonuç yazsının puset içerdiğini test edin
//    5-üçüncü ürüne relative locater kullanarak tıklayin
//    6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
//   1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın


    }
}