package practice03;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P05_Actions extends TestBase {

    @Test
    public void test() {

        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");


        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        Actions actions = new Actions(driver);
        actions.clickAndHold().perform();
        for (int i = 0; i <10 ; i++) {

        }




        //- Son olarak sayfayı temizleyiniz


        //
    }
}
