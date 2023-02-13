package day11_Downloads;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions05 extends TestBase {
    @Test
    public void test() {

//    Google a gidin https://www.google.com
        driver.get("https://www.google.com");

//    ‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        WebElement aramaKutusu = driver.findElement(By.name("q"));
       // aramaKutusu.sendKeys("iPhone X fiyatlari" + Keys.ENTER);


//    cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
//    Ve ENTER tusuna bas

        Actions actions = new Actions(driver);
        actions
                .keyDown(aramaKutusu,Keys.SHIFT)//aramakutusunun ustunde shift tusuna bas
                .sendKeys("iPhone x iyatlari")//shifte basiliyken yazi yaz
                .keyUp(aramaKutusu,Keys.SHIFT)//shif e artik basma
                .sendKeys("  cok pahali  " + Keys.ENTER)//normal halde yaz ve enter tusuna bas
                .build()//birden fazla actions methodu kullanildiginda onceki yapilari guclendir,olustur anlamindadir.
                .perform();
/*
        1- Actions nedir? Actions Class nedir ?
         *Actions selenium dan gelen bir kütüphanedir. Mouse ve Keyboard islemlerini gerçekleştirmek icin
         kullandigimiz hazır bir selenium kutuphanesidir. Ornegin, sag tiklamak(contextClick),
         çift tıklamak(doubleClick), elementin uzerine gitmek(moveToElement) gibi mouse islemlerini
         gerçekleştirebiliriz. Ayni zamanda, shift, control, delete, enter gibi keyboard tuslarinada
         actions yardımıyla basabiliriz. Bu tur islemlerde sendKeys metodu kullaninir.
        2- Ne tur methodlar kullandin?
            Actions metotlari onemlidir. Ve tekrar tekrar kullanmam gerektiğinden, Actions metotlarını
            içeren Reusable metodları oluşturdum. Ve gerektiğinde bu reusable metodları kullanıyorum.
            Ornegin rightClick methodunu bir elemente raga tiklamak icin test classimda vagira bilirim.
        3- Hangi methodlari kullandin ne ne ise yarar?
          Ornegin, sag tiklamak(contextClick), çift tıklamak(doubleClick), elementin uzerine gitmek(moveToElement)
          gibi mouse islemlerini gerçekleştirebiliriz. Ayni zamanda, shift, control, delete, enter gibi
          keyboard tuslarinada actions yardımıyla basabiliriz. Bu tur islemlerde sendKeys metodu kullaninir.

*/
    }
}