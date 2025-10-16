package tests.K12_SwitchingWindows.D01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Set;

public class C03_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin "Opening a new window" oldugunu dogrulayin
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));
        String expectedYazi = "Opening a new window";
        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        // Sayfa basliginin(title) "The Internet" oldugunu dogrulayin
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);


        String ilkWindowWHD = driver.getWindowHandle();
        // Click Here butonuna basin
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        // Acilan yeni pencerenin sayfa basliginin (title) "New Window" oldugunu test edin

        /*
            driver.getWindowHandle();
            method'u icerisinde oldugu window'un window handle degerini bize getirir
            ve biz de kaydedebiliriz

            bir window'un whd'ini kaydettikten sonra
            nerede olursak olalim
            driver.swichTo().window(hedefWindowunWHDi); ile bu window'a gecis yapabiliriz

            Kontrolsuz window acildiginda
            driver beklemedigi bir durum oldugundan
            yeni window'a gecemez, eski window'da kalir

            yeni window'a gecemedigimiz icin
            yeni window'un whd'ini de alamayiz

         */
        System.out.println("ilk window whd : " +ilkWindowWHD);
        System.out.println("Click'e bastiktan sonra driver'in oldugu window'un whd : " +driver.getWindowHandle());

        Set<String> acikTumWindowlarinWhdSeti = driver.getWindowHandles();
        System.out.println(acikTumWindowlarinWhdSeti);
        /*

         */

        String ikinciWindowWHD = "";

        for (String eachWhd : acikTumWindowlarinWhdSeti){
            if (eachWhd.equals(ilkWindowWHD)){
                ikinciWindowWHD = eachWhd;
            }
        }

        /*
            ilk window'un whd'ini en basta kaydetmistik
            simdi ikinci window'un whd'ine de sahibiz

            artik switchTo() ile istedigimiz window'a gecis yapabiliriz

         */

        //Acilan yeni pencerenin sayfa basliginin(title) "New Window" oldugunu test edelim
        //yeni window kontrolsuz olarak acildigi icin
        // driver hala eski window'da
        //yeni window ile ilgili islem yapmadan once
        // driver'i yeni window'a gecirmeliyiz

        driver.switchTo().window(ikinciWindowWHD);
        expectedTitle ="New Window";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        //Sayfadaki  textin "New Window" oldugu dogrulayin

         yaziElementi = driver.findElement(By.tagName("h3"));
         expectedYazi = "New Window";
         actualYazi = driver.getTitle();

         Assertions.assertEquals(expectedYazi,actualYazi);

         //bir onceki pencereye geri donun
        driver.switchTo().window(ilkWindowWHD);

        //ve sayfa basliginin "The Internet" oldugunu test edin
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);




    }
}
