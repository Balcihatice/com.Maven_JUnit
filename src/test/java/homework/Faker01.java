package homework;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Faker01 extends TestBase {


    @Test
    public void javaFakerTest() {
        //Faker Kutuphanesi HOMEWORK
        //Faker class'i testlerimizi yaparken ihtiyac duydugumuz isim, soyisim, adres vb bilgiler icin fake
        //degerler uretmemize imkan tanir.
        //Faker degerler uretmek icin Faker class'indan bir obje uretir ve var olan method'lari kullaniriz.
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        Faker faker = new Faker();
        //"create new account"  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();


        //“firstName” giris kutusuna bir isim yazin
        // “surname” giris kutusuna bir soyisim yazin
        // “email” giris kutusuna bir email yazin
        // "email" tekrar girin
        // Bir sifre girin
        String email = faker.internet().emailAddress();
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(), Keys.TAB, email);

        driver.findElement(By.xpath("//*[@name='reg_email_confirmation__']"))
                .sendKeys(faker.internet().emailAddress(), Keys.TAB, faker.internet().password(8, 10));

        //Tarih icin gun secin
        String day = String.valueOf(faker.number().numberBetween(1, 31));
        //Tarih icin ay secin
        Select selectMonth = new Select(driver.findElement(By.name("birthday_month")));
        selectMonth.selectByVisibleText("May");
        //Yil secin
        Select selectYear = new Select(driver.findElement(By.name("birthday_year")));
        selectYear.selectByValue("2000");
        driver.findElement(By.xpath("//*[@name='birthday_day']")).sendKeys(day);
        //Cinsiyeti secin
        WebElement woman = driver.findElement(By.xpath("//input[@value='1']"));
        woman.click();
        WebElement man = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement other = driver.findElement(By.xpath("//input[@value='-1']"));

        // Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(woman.isSelected());
        Assert.assertFalse(man.isSelected());
        Assert.assertFalse(other.isSelected());

    }
}
