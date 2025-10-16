package tests.K05_Webelements_Locators.D05_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
            ogrendigimiz 8 locator ile locate edip kullanabildigimiz
            bir WebElement icin RELATIVE LOCATOR kullanmaya GEREK YOKTUR

            EGER olur da webElementin HTML kodlarini gordugunuz halde
            WebElement'i kullanamiyorsaniz
            alternatif olarak RELATIVE LOCATOR'i deneyebilirsiniz
         */

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");

        //2 ) DSLR Camera'yi etrafindaki elementleri kullanarak
        //    3 farkli relative locator ile locate edip tiklayin
        /*
                1- Relative locator'i kullanmak icin oncelikle
                   hedef webelement'e ait bir ozelligi bulmamiz gerekir
                   bunun icin locate edecek gibi webelementi inceleyelim

                    <a id="pictext7" class="overlay active" href="http://testotomasyonu.com/product/32">
                    <img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">
                    <span>DSLR Camera</span></a>
                 */
        /*
            2- hedef webelementin etrafinda kullanabildigimiz bir webelementi
               locate edip kaydedelim
               MotorE13 telefonun dolunda diyelim
             */
        // biz id = pic7_thumb olan diyelim
        WebElement motorTelElementi = driver.findElement(By.id("pic8_thumb"));
        WebElement dslrCamera1 =
                driver.findElement( RelativeLocator.with(By.id("pic7_thumb")).toLeftOf(motorTelElementi));
        dslrCamera1.click();

        //3 ) Acilan urunun DSLR Camera oldugunu test edin

        WebElement dslrCameraIsimElementi = driver.findElement(By.xpath(""));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = dslrCameraIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("DSLR Camera testi PASSED");
        } else System.out.println("DSLR Camera testi FAILED");

        // Ikinci olarak Apple kulakligin saginda diye relative locator kullanalim

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");
        Thread.sleep(1000);

        // hedef elemente ait bir ozellik lazim
        // biz id = pic7_thumb olan diyelim

        // etraftan kullanabilecegimiz bir webElement bulup locate edip kaydetmeliyiz
       WebElement appleKulaklik = driver.findElement(By.id("pic6_thumb"));

       WebElement dslrCamera2 =
               driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toRightOf(appleKulaklik));

       dslrCamera2.click();

       // acilan sayfadaki urunun DSLR Camera oldugunu test edelim
 dslrCameraIsimElementi = driver.findElement(By.xpath("//div[@class='"));

        expectedUrunIsmi = "DSLR Camera";
        actualUrunIsmi = dslrCameraIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("DSLR Camera testi2 PASSED");
        } else System.out.println("DSLR Camera testi2 FAILED");

        /*
         StaleElementReferenceException
         Bir web sayfasindaki elementi locate ettikten sonra
         baska sayfalara gidilip yeniden locate ettigimiz webelementin oldugu sayfaya donersek

         driver daha onceden locate ettigi elementlerin ayni kaldigindan emin olmak ister
         bize NoSuchElementException (elementi bulamadim) deniyor

         onun yerine StaleElementReferenceException (bu webelementi locate etmistik ama ustunden cok zaman gecgi)

         StaleElementReferenceException karsilasinca daha once locate edip kaydettigimiz
         webelement'e yeniden deger atamasi yapmamiz gerekir.

         */

        Thread.sleep(3000);
        driver.quit();
    }
}
