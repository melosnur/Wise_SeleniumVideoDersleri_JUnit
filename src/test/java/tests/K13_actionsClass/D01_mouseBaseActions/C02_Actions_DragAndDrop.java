package tests.K13_actionsClass.D01_mouseBaseActions;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

public class C02_Actions_DragAndDrop extends TestBase_Each {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        //2- Accept bolumunde "Acceptable" butonuna tutup "Drop Here" kutusunun ustune

        WebElement draggableElementi = driver.findElement(By.id("draggable2"));
        WebElement dropHereKutusuElementi = driver.findElement(By.id("droppable2"));

        Actions actions = new Actions(driver);
        ReusableMethod.bekle(2);
        actions.dragAndDrop(draggableElementi,dropHereKutusuElementi).perform();

        //3- "Drop here" yazisi yerine "Dropped!" oldugunu test edin
        String expectedYazi = "Dropped!";
        String actualYazi = dropHereKutusuElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //4- Sayfayi yenileyin
        driver.navigate().refresh();
        ReusableMethod.bekle(2);

        //5- "Not Acceptable" butonunu tutup "Drop Here" kutusunun ustune birakalim
        WebElement notAcceptableButonu = driver.findElement(By.id("draggable-nonvalid2"));
        dropHereKutusuElementi = driver.findElement(By.id("droppable2"));
        // sayfayi yeniledigimiz icin bunu goremiyor o yuzden bir defa daha locate ettik

        actions.dragAndDrop(notAcceptableButonu,dropHereKutusuElementi).perform();

        //6- "Drop Here" yazisinin degsmedigini test edin
        expectedYazi = "Drop Here";
        actualYazi = dropHereKutusuElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);


    }

}
