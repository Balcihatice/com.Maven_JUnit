package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {
    @Test
    public void dissmissAlertTest() throws InterruptedException {

        //  2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
        // ve result mesajının “You clicked: Cancel” oldugunu test edin.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();//cansel tikladik
        Thread.sleep(3000);
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You clicked: Cancel";
        Assert.assertEquals(expectedResult, actualResult);

    }
}
