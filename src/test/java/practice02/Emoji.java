package practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Emoji extends TestBase {
    @Test
    public void test() {

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']")); // iframe(1) ilede iframe`e gecebiliriz
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();


        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojiler = driver.findElements(By.xpath("//*[@id='nature']//div/img"));
        emojiler.stream().forEach(w -> w.click());

        // parent iframe e geri donun
        driver.switchTo().defaultContent();//refresh yaparsakta ilk haline doneriz

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        // driver.findElement(By.xpath("//*[@id='text']")).sendKeys("Rose", Keys.TAB,"");
        List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> veriler = new ArrayList<>(Arrays.asList("Rose", "Edward", "selenium", "Java", "git", "hup", "code", "find", "end", "code", "refresh"));
        for (int i = 0; i < list.size(); i++) {
            list.get(i).sendKeys(veriler.get(i));
        }
        //  apply button a basin
        driver.findElement(By.xpath("//*[@class='mdl-button mdl-js-button mdl-button--raised mdl-button--colored']")).click();

    }
}
