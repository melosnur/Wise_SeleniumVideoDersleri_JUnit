package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

public class C04_FileUploadTesti extends TestBase_Each {

    @Test
    public void test01(){

        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        //Proje altindaki deneme.txt dosyayi secelim

        /*
            ChooseFile butonuna bastigimizda
            bilgisayarimizdaki dosya yapisi cikiyor

            WebDriver ile bilgisayarimizdaki fiziki dosya yapisina
            mudahale edemeyecegimiz icin

            Selenium bize sendKeys(dosyaYolu) yapma firsati verir
         */
        String dinamikDosyaYolu = System.getProperty("user.dir") + "/src/test/java/tests/K15_fileTestleri/deneme.txt";

        chooseFileButonu.sendKeys(dinamikDosyaYolu);
        ReusableMethod.bekle(5);

        //Upload butonuna basalim
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim

        WebElement fileUploadYazıElementı = driver.findElement(By.tagName("h3"));

        String expectedYazi = "File Uploaded!";
        String actualYazi = fileUploadYazıElementı.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);
        ReusableMethod.bekle(2);


    }






}
