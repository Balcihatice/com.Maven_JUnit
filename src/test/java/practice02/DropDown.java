package practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class DropDown extends TestBase {
    @Test
    public void test() {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Dropdown menuden baby secelim
       WebElement dropdown = driver.findElement(By.xpath("//*[@id'searchDropdownBox']"));
        Select select = new Select(dropdown);
       // dropdown.forEach(t-> System.out.println(t.getText()));
        for (WebElement w: select.getOptions()){
            System.out.println(w.getText());
        }
        //Arama bolumunden milk aratalim
        driver.findElement(By.xpath("//*[@id'searchDropdownBox']")).sendKeys("Baby"
                , Keys.TAB,"Milk",Keys.ENTER);


    }
}