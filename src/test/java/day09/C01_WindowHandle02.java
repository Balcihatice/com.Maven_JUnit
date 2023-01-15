package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_WindowHandle02 extends TestBase {

    @Test
    public void test() {
        //        https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualWindow1Text = driver.findElement(By.xpath("//*[.='Opening a new window']")).getText();
        String expectedWindow1Text = "Opening a new window";
        Assert.assertEquals(expectedWindow1Text, actualWindow1Text);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals("The Internet"));


        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        waitFor(3);

        //1.Pencerenin windowHandle`i
        String windowHandle1 = driver.getWindowHandle();

        //2.Pencere acilir
        //2. pencerede islem yapmak istedigimden o pencereye switch yapmaliyiz
        switchToWindow(1);//driver artik 2.window da


        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualWindow2Title = driver.getTitle();
        String expectedWindow2Title = "New Window";
        Assert.assertEquals(expectedWindow2Title, actualWindow2Title);

    }
}
