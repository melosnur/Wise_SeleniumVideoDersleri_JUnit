package tests.K13_actionsClass.D02_keyboardBasedActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

public class C01_KeyboardActions extends TestBase_Each {

    @Test

    public void test01(){

        //1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Arama kutusuna actions method'larini kullanarak "DELL Core I3" yazdirin
        //   ve Enter'a basarak arama yaptirin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        // aramaKutusu.sendKeys("DELL Core I3" + Keys.ENTER);
        // asagidaki ayni ama action ile yapilmis halini gosterdim

        Actions actions = new Actions(driver);
        ReusableMethod.bekle(2);

        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("i")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .sendKeys(Keys.ENTER).perform();


        //3- Bulunan urun isminde "DELL Core I3" bulundugunu test edin

        WebElement isimElementi = driver.findElement(By.xpath("//*[@class='prod-title mb-3 ']"));

        String expectedIsimIcerik = "DELL Core I3";
        String actualIsim = isimElementi.getText();

        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));

        ReusableMethod.bekle(2);
    }






}
