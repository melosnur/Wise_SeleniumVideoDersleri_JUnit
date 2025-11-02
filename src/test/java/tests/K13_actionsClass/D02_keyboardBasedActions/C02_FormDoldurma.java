package tests.K13_actionsClass.D02_keyboardBasedActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

public class C02_FormDoldurma extends TestBase_Each {

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

        /*
            Formdaki tum kutulari tek tek locate etmek yerine
            firstName kutusuna click yapip, isim gonderelim
            sonraki kutulara gecisi de TAB tusu ile yapabiliriz
         */

        Actions actions = new Actions(driver);
        ReusableMethod.bekle(1);
        WebElement firstNameKutusu = driver.findElement(By.id("firstName"));

        actions.click(firstNameKutusu)
                .sendKeys("Melahatnur")
                .sendKeys(Keys.TAB)
                .sendKeys("Ozcan")
                .sendKeys(Keys.TAB)
                .sendKeys("melahatnurozcan@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        ReusableMethod.bekle(4);

      //   ve Sign Up butonuna basalim
        driver.findElement(By.id("btn-submit-form")).click();

      //5- Kaydin olusturuldugunu test edin
        ReusableMethod.bekle(3);

        /*
            Kayit yapinca bizi otomatik olarak giris sayfasina yonlendiriyor
            kaydin olustugunu test edebilmek icin
            giris yapalim
         */
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        emailKutusu.sendKeys("melahatnurozcan@gmail.com");

        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys("12345");
        driver.findElement(By.id("submitlogin")).click();

        ReusableMethod.bekle(2);
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());


    }

}
