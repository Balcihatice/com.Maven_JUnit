package day11_Downloads;

import com.github.javafaker.Faker;
import org.junit.Test;


public class C02_JavaFaker {

    Faker faker;

    @Test
    public void javaFakerTest(){
        //1. Faker objesi olustur
        faker = new Faker();
        //2. Faker objesi ile fake data olustur
        String firstName = faker.name().firstName();
        System.out.println(firstName);


        //last name datasi
        String lastName = faker.name().lastName();
        System.out.println(lastName);

        //Kullanici adi
        String username = faker.name().username();
        System.out.println(username);

        //meslek ismi
        System.out.println(faker.name().title());

        //sehir
        System.out.println(faker.address().city());

        //eyalet
        System.out.println(faker.address());

        //full address
        System.out.println(faker.address().fullAddress());

        //ceptelefon no
        System.out.println(faker.phoneNumber().cellPhone());
    
        //email
        System.out.println(faker.internet().emailAddress());

        //rasgele 10 haneli numara
        System.out.println(faker.number().digits(15));

        /*
        TEST DATA : kullanici adi,sifre,tel no,sehir,kredikarti,no....
        Test datalari kimden alinir?
        1- BA-Business anylist -> FRD ve BRD yazar Exceptions criterialari yazar
        2- Test Lead
        3- Manuel Tester
        4- Tech Lead & Team Lead & Dev Lead
        5- Developer
        6- Database
        7- API call lar
        8-Documantasyonlar . Ornegin,API swagger documani.
        9- Java Faker da fake data almak icin kullaniyoruz
        NERDEN GELMEZ? Kullanicidan alinmaz , scrum masterdan alinmaz,
         */


    }
}
