package tests.K06_JUnitFramework.D02_Annotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethod;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class C04_BeforeAll_AfterAll {

    // 3 farkli test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Test otomasyonu anasayfaya gidin
    //    Url'in test otomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    static WebDriver driver;

    @BeforeAll // class'in basinda 1 kere calisir
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll // class'in en sonunda 1 kere calisir
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){
        // 1- Test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //    Url'in test otomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url testi PASSED");
        }
        ReusableMethod.bekle(1);

    }

    @Test
    public void test02(){
        // 2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //    ve arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@class='prod-img']"));
        int actualSonucSayisi = bulunanUrunElementleriList.size();

        if (actualSonucSayisi >0){
            System.out.println("phone arama testi PASSED");
        }else System.out.println("phone arama testi FAILED");
        ReusableMethod.bekle(1);
    }

    @Test
    public void test03(){
        // 3- ilk urunu tiklayin
       driver.findElement(By.xpath("//*[@class='prod-img'][1]"))
               .click();
        //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualIsim = ilkUrunIsimElementi.getText().toLowerCase();

        if (actualIsim.contains(expectedIsimIcerik)){
            System.out.println("Urun isim testi PASSED");
        } else System.out.println("Urun isim testi FAILED");
    }
}
