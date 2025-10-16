package tests.K06_JUnitFramework.D02_Annotations;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethod;

import java.time.Duration;

public class C02_SetupVeTeardownMethod {

    WebDriver driver; // local variable olmasin her method kullanabilsin diye

public void setup(){
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
}

public void teardown()  {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    driver.quit();}


    @Test
    public void testOtomasyonuTest()  {
        setup();
        // 1.method testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        //          title'in Test Otomasyonu icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle =  driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");
        teardown();
    }

    @Test  //@Disabled gecici sureligine calistirilmasini istemedigimiz method'lar icin kullanilir
    public  void wisequarterTesti(){
    setup();
        // 2.method wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        //          url'nin wisequarter icerdigini test edin

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }
        else System.out.println("Wisequarter testi FAILED");
        teardown();
    }

    @Test
    public  void junitTesti(){
        // 3.method junit.org adresine gidin
        setup();
        driver.get("https://www.junit.org");

        //          url'nin https://junit.org/junit5/" oldugunu test edin

        String expectedUrl = "https://junit.org/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Junit testi PASSED");
        } else System.out.println("Junit testi FAILED");
        teardown();
}
}
