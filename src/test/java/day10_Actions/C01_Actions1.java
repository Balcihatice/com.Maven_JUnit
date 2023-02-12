package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1 extends TestBase {
  //  ACTIONS CLASS'ı NEDİR? HANGİ METHODLAR İLE  NASIL KULLANILIR?..

//   Actions classını kullanarak klavye ve mouse ile yapabileciğiz tüm işlemleri otomosyonda da  yapmamızı sağlamaktayız..!!
//   Bu classa ait metdodlar kısaca aşağıdaki gibidir....

//       actions.doubleClick () :   WebElement'e çift tıklama yapar
//       actions.clickAndHold () :  Uzerinde click yapili olarak bekler
//       actions .dragAndDrop () :  Bir noktadan diğerine sürükler ve bırakır
//       actions.moveToElement () : Mouse'u istedigimiz WebElement'in uzerinde tutar
//       actions.contextClick ():   Mouse ile istedigimiz WebElement'e sag tiklama yapar.
//       actions.sendKeys() :       Öğeye bir dizi anahtar gönderir
//       actions.keyDown () :       Klavyede tuşa basma işlemi gerçekleştirir
//       actions.keyUp () :         Klavyede tuşu serbest bırakma işlemi gerçekleştirir
//
//
//        !!!!Actions classını kullanmak için üç aşama vardır.

    //     1.Action classından obje üretiriz.
//     (Actions actions= new Actions(driver);)
//     2.actions objesi ile kullanacağımız web elementi locate ederiz...
//     3.istediğimiz methodları action objesi ile kullanırız.
//     actions.doubleClick(element ismi).perform;


    @Test
    public void rightClick(){
//    https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
//        1. ACTIONS OBJESI OLUSTUR
        Actions actions = new Actions(driver);
//       2. ELEMENT I LOCATE EDELIM
        WebElement kutu = driver.findElement(By.id("hot-spot"));
//    Kutuya sag tıklayın
//        TUM ACTIONS LAR actions OBJESIYLE BASLAR permorm() ILE BITER
        actions.contextClick(kutu).perform();
//    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
//        Object olusturmak wait gerekdiren durumlarda makul
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
//    Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
    }
}
