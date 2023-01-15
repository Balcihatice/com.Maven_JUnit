package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle03 extends TestBase {

    @Test
    public void windowHaandleTest() {

        // 1. TechPro education sayfasinin titleinin "Techpro Education" metnini icerdigini test edin
        driver.get("https://www.techproeducation.com");
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        String techProWindowHandle = driver.getWindowHandle();


        //2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);//1)yeni pencere olusturur,2) oraya gecis yapar
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));


        //3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini icerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));


        //Driver Nerede? 3.Pencerede
        //1. ve 2. sayfalari suanda gormuyor
        //TechPro sayfasina gitmek icin driver.switchTo().window(techProWindowHandle)
        waitFor(3);
        driver.switchTo().window(techProWindowHandle);// Driver 1.Pencereye gecti
        waitFor(3);
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        waitFor(3);
    }
}
