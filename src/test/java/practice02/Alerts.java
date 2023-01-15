package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Alerts extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //    accept Alert(I am an alert box!) and print alert on console
        WebElement alert = driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
        alert.click();
        String alertText = driver.switchTo().alert().getText();//alert uzerindeki yaziyi aldik
        System.out.println("alertText = " + alertText);
        driver.switchTo().alert().accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        //    cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("TechProEducation");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        //    finally print on console this message "Hello TechProEducation How are you today"
        System.out.println(driver.findElement(By.xpath("//*[@id='demo1']")).getText());
        //    aseertion these message
        Assert.assertEquals("Hello TechProEducation How are you today",driver.findElement(By.xpath("//*[@id='demo1']")).getText());
      //isDisplay yapabilirdik

    }
}
