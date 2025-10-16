package tests.K07_CheckBox_RadioButton_TestBase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;

import java.time.Duration;

public class C02_RadioButton {

    //  a. Verilen web sayfasina gidin.
    //        https://testotomasyonu.com/form
    //  b. Cinsiyet Radio button elementlerini locate edin
    //  c. Iki farkli test method'u olusturup yazidan veya direk buton'dan size uygun olani secin
    //  d. Sectiginiz radio button'un secili, otekilerin secili olmadigini test edin

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    public void teardown(){
        driver.quit();
    }


    @Test
    public void yazidanSecimTesti(){
        /*
          a. Verilen web sayfasina gidin.
                https://testotomasyonu.com/form
        */
        driver.get("https://testotomasyonu.com/form");
        ReusableMethod.bekle(3);
        Actions actions = new Actions(driver); //action objesini olusturmak icin
        actions.sendKeys(Keys.PAGE_DOWN).perform(); //sayfayi asagiya indirmek icin


        //  b. Cinsiyet Radio button elementlerini locate edin

        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        //  c.  yazidan size uygun olani secin
        //      erkek seciyorum
        driver.findElement(By.xpath("//*[@for='inlineRadio2']")).click();

        //  d. Sectiginiz radio button'un secili, otekilerin secili olmadigini test edin
        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());
    }

    @Test
    public void butondanSecimTesti(){
        // a.Verilen web sayfasina gidin
        //      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        ReusableMethod.bekle(3);
        Actions actions = new Actions(driver); //action objesini olusturmak icin
        actions.sendKeys(Keys.PAGE_DOWN).perform(); //sayfayi asagiya indirmek icin


        // b.Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // c.direk buton'dan size uygun olanini secin
        //   erkek butonu seciyorum

        ReusableMethod.bekle(2);
        erkekRadioButton.click();

        // d.Sectiginiz radio button'un secili, otekilerin secili olmadigini test edin
        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());

    }

}
