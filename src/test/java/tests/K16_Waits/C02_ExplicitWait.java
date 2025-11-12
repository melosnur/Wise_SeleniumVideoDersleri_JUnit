package tests.K16_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethod;

import java.time.Duration;

public class C02_ExplicitWait {
    WebDriver driver;

    @Test
    public void implicitlyWaitTesti(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin
        driver.findElement(By.xpath("//*[.='Remove']")).click();

        //3. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));

        Assertions.assertTrue(itsGoneYaziElementi.isDisplayed());

        //4. Add butonuna basin
        driver.findElement(By.xpath("//*[.='Add']")).click();

        //5.It's back mesajinin gorundugunu test edin
        WebElement itsBackElementi = driver.findElement(By.xpath("//*[.=\"It's back!\"]"));
        Assertions.assertTrue(itsBackElementi.isDisplayed());

        ReusableMethod.bekle(2);
        driver.quit();
    }

    @Test
    public void explicitlyWaitTesti(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin
        driver.findElement(By.xpath("//*[.='Remove']")).click();

        //3. "It's gone!" mesajinin goruntulendigini dogrulayin.
        //WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));


                //1.adim wait objesi olustur
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
                //2.ve 3.adim : bekleme yapmadan locate etmek mumkun olmadigindan
                //              bekleme ve locate'i tek adimda yapacagiz
        WebElement itsGoneYaziElementi = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[.=\"It's gone!\"]")));
        Assertions.assertTrue(itsGoneYaziElementi.isDisplayed());

        //4. Add butonuna basin
        driver.findElement(By.xpath("//*[.='Add']")).click();

        //5.It's back mesajinin gorundugunu test edin

        WebElement itsBackYaziElementi = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[.=\"It's back!\"]")));


driver.quit();
    }


}
