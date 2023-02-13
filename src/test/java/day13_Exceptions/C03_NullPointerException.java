package day13_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class C03_NullPointerException {

    /*
    NullPointerException
    Degiskenleri oluşturup instantiate etmediğimizde alırız(new kelimesini kullanmadigimizda)
    Ornegin WebDriver driver; deyip = new ChromeDriver() demezisek null pointer exception aliriz
    Solution:
    Degiskeni instantiate et
    */
    WebDriver driver;
    Faker faker;

    @Test
    public void test() {
        //driver = new ChromeDriver demedigimiz icin
        driver.get("https://www.techproeducation.com"); //(C03_NullPointerException.java:20)Javadan geliyor

    }

    @Test
    public void nulPointerException() {
        //faker= new Faker();
        System.out.println(faker.name().fullName());//java.lang.NullPointerException

    }
}
