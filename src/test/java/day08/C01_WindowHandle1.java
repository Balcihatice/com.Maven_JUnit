package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

import static java.awt.SystemColor.window;

public class C01_WindowHandle1 extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //   Tests package’inda yeni bir class olusturun: WindowHandle
        //   https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        // ILK SAYFANIN HANDLEINI ALALIM
        String window1Handle = driver.getWindowHandle();


        //   Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String window1Text = driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText();//By.xpath("//h3") de olabilir
        Assert.assertEquals("Opening a new window", window1Text);

        //   Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet", window1Title);

        //   Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();//link oldugu icin linktext kullandik

        //   Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        //Bu noktada iki pencere acti ve 2. ye gecis yapmak istiyoruz
        //BUNUN ICIN : driver.getwindowHandles ile SAYFALARIN ID LERINI ALALIM

        Set<String> allwindowsHandles = driver.getWindowHandles();//window1 ve window2 nin handle`i var
        System.out.println(allwindowsHandles);
        for (String w : allwindowsHandles) {
            //eger listedeki id window1 e esit degilse ,otomatik olarak bir sonrakine esittir
            if (!w.equals(window1Handle)) {
                driver.switchTo().window(w);//Burdaki eachHandle window2 handleina esittir.
                break;
            }
        }
//      BU NOKTADA DRIVER 2.PENCEREDE
        //Acilan pencerenin sayfa basliginin (title) "New Window oldugunu dogrulayin
        Assert.assertEquals("New Window", driver.getTitle());
        //   Sayfadaki textin “New Window” olduğunu doğrulayın.
        String window2Title = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window", window2Title);

        String window2Handle = driver.getWindowHandle();//2.sayfanin id sini verir
//     Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.

        Thread.sleep(3000);
        //1.window`a gecis yapiyorum
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet", driver.getTitle());
        Thread.sleep(3000);
        //2.window`a gecis yapiyorum
        driver.switchTo().window(window2Handle);
        //1.windowa tekrer gecelim
        driver.switchTo().window(window1Handle);
    }

}