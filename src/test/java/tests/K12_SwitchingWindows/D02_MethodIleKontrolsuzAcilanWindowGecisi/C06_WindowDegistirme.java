package tests.K12_SwitchingWindows.D02_MethodIleKontrolsuzAcilanWindowGecisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

import javax.sound.sampled.AudioPermission;

public class C06_WindowDegistirme extends TestBase_Each {

    @Test
    public void test01(){

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[.='Elemental Selenium']")).click();

        // acilan yeni window'a buyuk basligin "Elemental Selenium" oldugunu test edin
        // once title kullanarak yeni window'a gecelim

        ReusableMethod.titleIleWindowGecisYap(driver, "Home | Elemental");

        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();
        Assertions.assertEquals(expectedYazi,actualYazi);

        // ilk window'a geri donun
        ReusableMethod.UrlIleWindowGecisYap(driver,"https://the-internet.herokuapp.com/windows");

        // "Opening a new window" yazisinin gorunur oldugunu test edin
        WebElement openingWindowElementi = driver.findElement(By.tagName("h3"));
        Assertions.assertTrue(openingWindowElementi.isDisplayed());

        // Click here'a basin
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        // Acilan yeni window'a gecip, oradaki yazinin "New Window" oldugunu test edin

        ReusableMethod.titleIleWindowGecisYap(driver, "New Window");
        // oradaki yazinin "New Window" oldugunu test edin
        expectedYazi = "New Window";
        actualYazi = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        // Elemental selenium'un axik oldugu window'a gecin
        ReusableMethod.UrlIleWindowGecisYap(driver, "https://elementalselenium.com/");

        // Tips linkinin erisilebilir oldugunu test edin
        WebElement tipsElementi = driver.findElement(By.xpath("//*[.='Tips']"));

        Assertions.assertTrue(tipsElementi.isEnabled());

    }


}
