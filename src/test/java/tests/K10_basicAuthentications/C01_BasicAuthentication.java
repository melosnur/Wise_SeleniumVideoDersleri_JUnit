package tests.K10_basicAuthentications;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

public class C01_BasicAuthentication extends TestBase_Each {

    @Test
    public void test01() {
        //1- Bir class olusturun: BasicAuthentication
        //2- https://testotomasyonu.com/basicauth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication'i yapin
        //
        //Html komutu : https://username:password@URL (bunu sirket kendi veriyor)
        //  Username  : membername
        //  password  : sunflower


        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");
        //https://username:password@URL

        //4- Basarili sekilde sayfaya girildigini dogrulayin

        String expectedYazi = "Basic Auth";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi, actualYazi);
    }
}
