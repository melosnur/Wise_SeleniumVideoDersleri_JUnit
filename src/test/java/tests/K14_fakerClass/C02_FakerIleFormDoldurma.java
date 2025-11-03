package tests.K14_fakerClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

public class C02_FakerIleFormDoldurma extends TestBase_Each {
    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]")).click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[.=' Sign Up']")).click();

        ReusableMethod.bekle(2);
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim


        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String fakeSifre = faker.internet().password();
        String fakeEmail = faker.internet().emailAddress();

        ReusableMethod.bekle(1);
        WebElement firstNameKutusu = driver.findElement(By.id("firstName"));

        actions.click(firstNameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre).perform();

        ReusableMethod.bekle(4);

        //   ve Sign Up butonuna basalim
        driver.findElement(By.id("btn-submit-form")).click();

        //5- Kaydin olusturuldugunu test edin
        ReusableMethod.bekle(3);

        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        emailKutusu.sendKeys(fakeEmail);

        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys(fakeSifre);

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.id("submitlogin")).click();

        ReusableMethod.bekle(2);
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonu.isEnabled());

        //sistemden cikis yapalim

        logoutButonu.click();


    }

}



