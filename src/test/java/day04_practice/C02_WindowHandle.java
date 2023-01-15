package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {
    @Test
    public void test() {
        // ...Exercise 2...

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaWindowHandle = driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(ilkSayfaWindowHandle);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        String javaIceriyorMu = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(javaIceriyorMu.contains("Java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(ikinciSayfaWindowHandle);

        // 8- logonun gorundugunu test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());
    }
}
