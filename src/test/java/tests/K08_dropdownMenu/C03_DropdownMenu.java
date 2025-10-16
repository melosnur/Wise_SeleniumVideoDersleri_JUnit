package tests.K08_dropdownMenu;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

public class C03_DropdownMenu extends TestBase_Each {

    //1. http://zero.webappsecurity.com/ Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna "username" yazin
    //4. Password kutusuna "password" yazin
    //5. Sign in tusuna basin, back tusuna basarak sayfaya donun
    //6. Online banking menusunden Pay Bills sayfasina gidin
    //7. "Purchase Foreign Currency" tusuna basin
    //8. "Currency" drop down menusunden Eurozone'u secin
    //9. "amount" kutusuna bir sayi girin
    //10. "US Dollars" in secilmedigini test edin
    //11. "Selected currency" butonunu secin
    //12. "Calculate Casts" butonuna basin sonra "purchase" butonuna basin
    //13. "Foreign currency cash was successfully purchased." yazsinin ciktigini kontrol edin.

    @Test
    public void test01(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        //3. Login kutusuna "username" yazin
        WebElement loginKutusu = driver.findElement(By.id("user_login"));
        loginKutusu.sendKeys("username");

        //4. Password kutusuna "password" yazin
        WebElement passwordKutusu = driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");

        //5. Sign in tusuna basin,
        driver.findElement(By.name("submit")).click();
        //back tusuna basarak sayfaya donun
        driver.navigate().back();

        //6. Online banking menusunden
        driver.findElement(By.xpath("//strong[.='Online Banking']")).click();

        // Pay Bills sayfasina gidin
        driver.findElement(By.id("pay_bills_link")).click();


        //7. "Purchase Foreign Currency" tusuna basin

        // driver.findElement(By.xpath("//li[@class='ui-state-default ui-corner-top ui-tabs-selected ui-state-active']//a")).click();

        //8. "Currency" drop down menusunden Eurozone'u secin
        //9. "amount" kutusuna bir sayi girin
        //10. "US Dollars" in secilmedigini test edin
        //11. "Selected currency" butonunu secin
        //12. "Calculate Casts" butonuna basin sonra "purchase" butonuna basin
        //13. "Foreign currency cash was successfully purchased." yazsinin ciktigini kontrol edin.

    }


}
