package tests.K14_fakerClass;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

public class C03_FakerVeActionsClassIleFormDoldurma extends TestBase_Each {


    @Test
    public void facebookTesti(){

        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Cookies kabul edelim
        // driver.findElement(By.xpath("(//span[.='Allow all cookies'])[3]")).click();

        //3- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();

        //4- Ad,soyad, mail ve sifre kutularina deger yazalim,
        //   tarih ve cinsiyet secimlerini yapalim ve kaydol tusuna basalim

        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        ReusableMethod.bekle(1);

       WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));

       actions.click(isimKutusu)
               .sendKeys(faker.name().firstName())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.name().lastName())
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys("12")
               .sendKeys(Keys.TAB)
               .sendKeys("Mar")
               .sendKeys(Keys.TAB)
               .sendKeys("1990")
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.ARROW_RIGHT) //erkek secmek icin
               .sendKeys(Keys.TAB)
               .sendKeys(faker.internet().emailAddress())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.internet().password()).perform();


        //5- Kaydol tusuna basalim
        driver.findElement(By.xpath("//*[@name='websubmit']")).click();

        ReusableMethod.bekle(5);







    }




}
