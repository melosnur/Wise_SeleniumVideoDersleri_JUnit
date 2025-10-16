package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebDriverOlusturma_GetveNavigateMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getTitle()); // Test Otomasyonu - Test Otomasyonu
        // sayfanin basligini (Title) getirir

        System.out.println(driver.getCurrentUrl());
        //  https://www.testotomasyonu.com/
        // gidilen sayfadaki actual url'i getirir

        System.out.println(driver.getPageSource());

        System.out.println(driver.getWindowHandle()); // B825E3D6856344A680DFD2954DDF90B9
        System.out.println(driver.getWindowHandles()); // [B825E3D6856344A680DFD2954DDF90B9]

        /*
        WebDriver olusturulan her bir objeye
        benzersiz (unique) bir Windows Handle Degeri atar.

        Bu konu ilerde ayrica anlatilacak

        Eger bir class calistiginda birden fazla windows acilirsa
        herbirinin ayri bir Window Handle Degeri olur

        getWindowHandle() driver'in actigi son window'un handle degerini verir
        getWindowHandles() ise acilan tum window'larin window handle degerlerini
        bir Set olarak verir

        driver'in acilan Window'lar arasinda gecis yapabilmesi icin
        gecegi windod'un window handle degerini bilmesi gerekir

         */




        Thread.sleep(3000); // beklemesi icin yaptigimizi gorelim diye
        // drive.close();

        driver.quit();
    }
}
