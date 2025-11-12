package tests.K16_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethod;

import java.time.Duration;

public class C01_ExplicitWait  {

    //Iki tane method olusturun : implicitWaitTest, explicitWaitTest
    //Iki method icin de asagidaki adimlari test edin
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin
    //2. Testbox'in etkin olmadigini (enabled) dogrulayin
    //3. Enable butonuna tiklayin ve textbox etkin oluncaya kadar bekleyin
    //4. Textbox'in etkin oldugunu(enabled) dogrulayin
    //5. "It's enabled!" mesajinin goruntulendigini dogrulayin

    WebDriver driver;


    @Test
    public void implicitWaitTesti(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Testbox'in etkin olmadigini (enabled) dogrulayin
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textBox.isEnabled());

        //3. Enable butonuna tiklayin ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        ReusableMethod.bekle(3);

        /*
            testimiz implicityWaitTest oldugu icjn
            implicity wait'in yeterli olup olmadigini kontrol edip
            yeterli olmazsa ekstra bekleme koymak gerekir
         */

        //4. Textbox'in etkin oldugunu(enabled) dogrulayin
        Assertions.assertTrue(textBox.isEnabled());
        /*
            implicityWait() iki durumda bekleme yapar
            1- sayfanin yuklenmesi
            2- bir webelement'in locate edilmesi icin

            gorevin 4.maddesine textbox'in etkin olmasini beklememiz gerekiyor
            ancak bu bekleme implicityWait()'in gorev kapsaminda yok
            bu sebeple implicityWait() ile yaptigimizda
            4.gorev FAILED olacaktir

            Testin passed olmasi icin mutlaka ekstra bekleme gerekir
            4.gorevin gerceklemesi icin Thread.sleep() kullandik
         */

        //5. "It's enabled!" mesajinin goruntulendigini dogrulayin
        WebElement itsEnableYaziElementi = driver.findElement(By.id("message"));

        Assertions.assertTrue(itsEnableYaziElementi.isDisplayed());

        ReusableMethod.bekle(2);
        driver.quit();

    }

    @Test
    public void explicitWaitTesti(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Testbox'in etkin olmadigini (enabled) dogrulayin
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textBox.isEnabled());

        //3. Enable butonuna tiklayin ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        // ve textbox etkin oluncaya kadar bekleyin
        // explicitlyWait ;le bekleyelim

                 // 1.adim bir wait objesi olusturur
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

                // 2.adim MUMKUNSE beklenecek objeyi locate edip bir webelement olarak kaydedin
                //        textbox'i locate edebiliyoruz ve yukarida locate edip kaydettik

        //3.adim wait objesine neyi bekleyecegini soyleyin
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        //4. Texbox'in etkin oldugunu(enabled) dogrulayin
        Assertions.assertTrue(textBox.isEnabled());

        //5. "It's enabled!" mesajinin goruntulendigini dogrulayin
        WebElement itsEnableYaziElementi = driver.findElement(By.id("message"));

        Assertions.assertTrue(itsEnableYaziElementi.isDisplayed());

        driver.quit();
    }


}
