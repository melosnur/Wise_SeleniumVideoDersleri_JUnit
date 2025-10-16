package tests.K05_Webelements_Locators.D04_xPath_cssLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4- Sayfayi "refresh" yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin "Test Otomasyonu" ifadesi icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)) {
            System.out.println("Title testi PASSED");
        } else System.out.println("Title testi FAILED");

        //6- Furniture Linkine tiklayin

        /*
            Bir HTML element acilan sayfada asagida kaldigi icin
            ilk acilan bolumde gorunmuyorsa
            o webElementi kullanip kullanamayacagimiz
            TAMAMEN sayfayi dizayn edenlerin yazmis olduklari kadar baglidir
            bazi sayfalarda alt tarafta kalan HTML elementler kullanilabilirken
            bazi sayfalarda kullanilamayabilir

            Bizim yapabilecegimiz tek sey
            kullanmayi denemek
            kullanilabiliyorsa sorun yok,
            kullanamiyorsak o zaman sayfayi asagi kaydirmak
         */
        driver.findElement(By.xpath("(//a[text()='Furniture'])[3]")).click();

        //7- price range filtresinde min degeri 40, max degeri 200 yazip filtreleyin
        WebElement minKutusu = driver.findElement(By.cssSelector("input[name='min']"));
        minKutusu.clear();
        minKutusu.sendKeys("40");

        WebElement maxKutusu = driver.findElement(By.cssSelector("input[name='max']"));
        maxKutusu.clear();
        maxKutusu.sendKeys("200");

        //filtrele butonuna basalim
        driver.findElement(By.cssSelector("button[name='button']")).click();

        //8- filtreleme sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.cssSelector("a[class='prod-img']"));
        if (!bulunanUrunElementleriList.isEmpty()) {
            System.out.println("urun filtreleme testi PASSED");
        } else System.out.println("urun filtreleme testi FAILED");

        //10- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
        WebElement urunFiyatElementi = driver.findElement(By.id("priceproduct"));

        System.out.println(urunFiyatElementi.getText());

        String urunFiyatiStr = urunFiyatElementi.getText();

        urunFiyatiStr = urunFiyatiStr.replaceAll("\\D", "");

        Double urunFiyatDbl = Double.parseDouble(urunFiyatiStr) / 100;

        //11-Sayfayi kapatin
        driver.quit();
    }
}
