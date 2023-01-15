package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;


public class P01 extends TestBase {

//    Bir class olusturun: IframeOdev
//    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
//    sayfadaki toplam iframe sayısını bulunuz.
//    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
//    Paragrafdaki yaziyi silelim
//    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
//    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim


    //element.clear();
    //sendkey
    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        int iframesize = iframeList.size();
        System.out.println("Toplam Iframe sayisi: " + iframesize);

        //    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String actualTitle = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(actualTitle.contains("Editor"));

        driver.switchTo().frame(0);
        //    Paragrafdaki yaziyi silelim
        WebElement yazi = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        yazi.clear();

        //    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        yazi.sendKeys("iframin icindeyim");
        driver.switchTo().defaultContent();
        //    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        String alttakiYazi = driver.findElement(By.xpath("//*[.='Elemental Selenium']")).getText();
        Assert.assertTrue(alttakiYazi.contains("Elemental Selenium"));


    }

}
