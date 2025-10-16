package tests.K12_SwitchingWindows.D01_KontrolluWindowGecisi_KontrolsuzAcilanWindowlar;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethod;
import utilities.TestBase_Each;

public class C01_AyniWindowdaGezinme extends TestBase_Each {

    @Test
    public void test01(){

        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // windowhandle degerini ve url'i yazdirin
        System.out.println("testotomasyonu url : " + driver.getCurrentUrl());
        System.out.println("testotomasyonu window handle degeri : " + driver.getWindowHandle());

        // Electronics linkini tiklayin
        driver.findElement(By.xpath("(//a[.='Electronics'])[3]")).click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Electronic url : " + driver.getCurrentUrl());
        System.out.println("Electronic window handle degeri : " + driver.getWindowHandle());

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // windowhandle degerini ve url'i yazdirin

        System.out.println(" ilk urun url : " + driver.getCurrentUrl());
        System.out.println(" ilk urun window handle degeri : " + driver.getWindowHandle());

        // account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]")).click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println(" account url : " + driver.getCurrentUrl());
        System.out.println(" account window handle degeri : " + driver.getWindowHandle());



    }





}
