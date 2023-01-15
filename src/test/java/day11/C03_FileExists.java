package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExists {

    @Test
    public void test() {

        //  Method : isExist
        //   Masa ustunden bir dosyanın varligini test et

        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);

        String userHOME = System.getProperty("user.home");
        System.out.println(userHOME);

        //logo.jpeg indirip kaydedin
        String dosyaYolu = userHOME + "/Desktop/logo.jpeg";
        System.out.println(dosyaYolu);

        boolean isExists = Files.exists(Paths.get(dosyaYolu));//Dosya var ise true ,yoksa false return eder
        Assert.assertTrue(isExists);


    }
}
