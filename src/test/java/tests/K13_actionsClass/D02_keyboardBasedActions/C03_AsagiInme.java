package tests.K13_actionsClass.D02_keyboardBasedActions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

import java.security.Key;

public class C03_AsagiInme extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");


        //2- video'yu gorecek kadar asagiya in
        Actions actions = new Actions(driver);
        ReusableMethod.bekle(1);

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //3- videoyu izlemek icin Play tusuna basin

        // videonun bir iframe icinde oldugunu farkettik
        // once iframe'i kaydedip iframe'e gecis yapmamiz gerekir

        WebElement videoIframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(videoIframe);

        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        ReusableMethod.bekle(2);

    }
}
