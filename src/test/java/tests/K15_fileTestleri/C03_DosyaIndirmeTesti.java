package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_DosyaIndirmeTesti extends TestBase_Each {

    @Test
    public void test01(){
        //1. https://the-internet.herokuapp.com/download adresine gidelim.
            driver.get("https://the-internet.herokuapp.com/download");

        //2. selenide-intro.txt dosyasini indirelim.
        driver.findElement(By.xpath("//a[text()='selenide-intro.txt']")).click();

        //3. Dosyanin basariyla indirilip indirilmedigini test edelim
        ReusableMethod.bekle(3);

        // Dosya downloads'a inecektir

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/selenide-intro.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


    }

}
