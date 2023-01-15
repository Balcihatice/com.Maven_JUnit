package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        // 3. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick ='jsPrompt()']")).click();
        // uyarıdaki metin kutusuna isminizi yazin,
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Rose");
        // OK butonuna tıklayın
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        // ve result mesajında isminizin görüntülendiğini doğrulayın.
        Thread.sleep(3000);
        String actualResult = driver.findElement(By.id("result")).getText();
        Thread.sleep(3000);
        String expectedResult = "Rose";
        Thread.sleep(3000);
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
