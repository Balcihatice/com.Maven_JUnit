package day17_JsExecutors;

import org.junit.Test;
import utilities.TestBase;

public class homework01 extends TestBase {

    @Test
    public void getValueTest() {

        //  2)https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/ ");

        //  3)Tarih kısmındaki Yazili metinleri al ve yazdır

        getValueByJS("hotelDates");

//        NOT: document.querySelector("p").value; -> TAG KULLANILABILIR
//             document.querySelector(".example").value; -> CSS DEGERI KULLANILABILIR
//             document.querySelector("#example").value; -> CSS DEGERI KULLANILABILIR
    }
}
