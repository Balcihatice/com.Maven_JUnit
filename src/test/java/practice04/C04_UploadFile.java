package practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_UploadFile extends TestBase {

    @Test
    public void name() {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        String farkliKisim = System.getProperty("user.home");
        String ortakYol = "/Desktop/Excel.numbers";
        String dosyaYolu = farkliKisim + ortakYol;

        WebElement dosyaSec = driver.findElement(By.xpath("//*[@class='upload_txt']"));
        dosyaSec.sendKeys(dosyaYolu);

        // I accept terms of service bölümünü tikleyin
        // Submit File buttonuna basınız
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='terms']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        waitFor(2);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();
    }
}
