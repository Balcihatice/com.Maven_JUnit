package day14_ScreenShot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ExtentReports extends TestBase {

    // HATIRLAMAMIZ GEREKEN UC CLASS
    public static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @Test
    public void extentReportsTest() {


        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/reports/" + currentTime + "html_report.html";

        //creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

        // creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();
        // *************************************RAPORU CUSTOMIZE EDEBILIRIZ*********************
        extentReports.setSystemInfo("Test Environment", "Regression");
        extentReports.setSystemInfo("Application", "TechPro Education");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Takim", "Eagles");
        extentReports.setSystemInfo("Epic", "Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint Numarasi", "Sprint-145");
        extentReports.setSystemInfo("QA", "Ahmet");

        //*********************************EXTRA RAPOR ISMI VE DOCUMAN ISMI EKLEYEBILIRIZ****
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");

        //********************************RAPOR AYARLARI BITTI****************************

        // Raporu projeme ekliyorum
        extentReports.attachReporter(extentHtmlReporter);

        //Extend Test Objesini olusturduk
        extentTest = extentReports.createTest("Extend Report Test", "Smoke Test Raporu");

        //TUM AYARLAR BITTI. EXTEND TEST OGJESI ILE LOGLAMA(RAPORA YAZDIRMA) ISLEMINI YAPALIM
        extentTest.pass("Kullanici Ana Sayfaya gider");
        driver.get("https://www.techproeducation.com");
        // pass info(bilgilendirme)-->> genelde kullanilir.
        //LMS SAYFASINA GIDELIM
        extentTest.pass("Kullanici LMS sayfasina gider");
        driver.findElement(By.linkText("LMS LOGIN"));

        //TEST BITTI
        extentTest.pass("Test Basariyla Gerceklesti");


        //RAPORU GOSTER.RAPORUN OLUSMASI ICIN BU ADIM ZORUNLUDUR
        extentReports.flush();

    }
}
