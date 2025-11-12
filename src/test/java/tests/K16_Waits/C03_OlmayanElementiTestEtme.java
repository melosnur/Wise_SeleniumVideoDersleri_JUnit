package tests.K16_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C03_OlmayanElementiTestEtme extends TestBase_Each {

    @Test
    public void test01() {

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin
        driver.findElement(By.xpath("//*[.='Remove']")).click();

        // "It's gone!" gorunceye kadar bekleyin.
        // its gone yazi elementini daha once locate etmedigimiz icin
        // implicitly wait locate edinceye kadar bekler
        // (sonra kapanir bu yuzden olmayan elemnti locate edemeyiz)
        WebElement itsGone = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));

        //3. checkbox'in gorunur olmadigini test edin

        try {
            WebElement checkBox = driver.findElement(By.xpath("//*[@id='checkbox']"));
            // locate edebildiyse, checkbox gorunuyor demektir
            // bu da bizden istenen gorevin failed olmasi anlamina gelir
            Assertions.assertTrue(false,"Checkbox gorunur durumda");

        } catch (NoSuchElementException e) {
            // CheckBox'i locate edemedigi icin NoSuchElemetException olusur
            // bu aslinda bizden istenen gorevin
            // yani checkBox'in gorunemediginin ispatidir
            Assertions.assertTrue(true);
        }

        /*
            checkbox'i daha onceden locate ettigimiz icin
            StaleElementReferenceException verdi,

            eger onceden locate etmemis olsaydik
            bu satirda locate etmeye calissaydik
            implicityWait suresi kadar bekler ve sonra
            NoSuchElementException verirdi.

         */

        //4. Add butonuna basin
        driver.findElement(By.xpath("//*[.='Add']")).click();

        //5.checkbox'in gorunur oldugunu test edin
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='checkbox']"));

        Assertions.assertTrue(checkBox.isDisplayed());
    }
}