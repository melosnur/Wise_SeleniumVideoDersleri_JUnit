package tests.K13_actionsClass.D01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

public class C01_Actions_ContextClick extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");
         ReusableMethod.bekle(2);   

        //2- "DGI Drones" uzerinde sag click yapin
        WebElement dgiDronesElementi = driver.findElement(By.id("pic2_thumb"));
        ReusableMethod.bekle(2);

        Actions actions = new Actions(driver);
        actions.contextClick(dgiDronesElementi).perform();

        //3- Alert'te cikan yazinin "Tebrikler!... Sag click yaptiniz." oldugunu test edin
        String expectedYazi = "Tebrikler!... Sağ click yaptınız.";
        String actualYazi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //4- Tamam diyerek alert'i kapatin
        driver.switchTo().alert().accept();
    }




}
