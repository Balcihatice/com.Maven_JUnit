package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

/*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
 */
public class P03_Actions extends TestBase {

    @Test
    public void test() {

        // http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");


        // Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        WebElement maviKutu = driver.findElement(By.xpath("//*[@id='div2']"));
        Actions actions = new Actions(driver).moveToElement(maviKutu);
        waitFor(3);
        actions.moveToElement(maviKutu).perform();
        waitFor(3);


        // Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement doubleClick = driver.findElement(By.xpath("//button[@name='dblClick']"));
        actions.doubleClick(doubleClick).perform();

        Assert.assertEquals("Double Clicked !!", driver.switchTo().alert().getText());

        // Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();


        // Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drog = driver.findElement(By.xpath("//*[@id='droppable']"));
        actions.dragAndDrop(drag, drog).perform();


        WebElement dropped = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertEquals("Dropped!", dropped.getText());


    }
}
