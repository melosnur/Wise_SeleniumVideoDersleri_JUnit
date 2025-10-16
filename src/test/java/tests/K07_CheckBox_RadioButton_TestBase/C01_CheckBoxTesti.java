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

public class C01_CheckBoxTesti {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void checkBoxTesti(){
        //  a. Verilen web sayfasina gidin
        //       https://testotomasyonu.com/form

        driver.get("https://testotomasyonu.com/form");

        Actions actions = new Actions(driver); //action objesini olusturmak icin
        //ReusableMethod.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform(); //sayfayi asagiya indirmek icin
        //ReusableMethod.bekle(1);


        //  b. Sirt Agrisi ve Carpinti checkbox'larini secin
        WebElement sirtAgrisiCheckbox = driver.findElement(By.id("gridCheck5"));
        WebElement carpintiCheckbox = driver.findElement(By.id("gridCheck4"));

        ReusableMethod.bekle(3);
        sirtAgrisiCheckbox.click();
        carpintiCheckbox.click();


        //  c. Sirt Agrisi ve Carpinti checkbox'larinin secili oldugunu test edin

        Assertions.assertTrue(sirtAgrisiCheckbox.isSelected());
        Assertions.assertTrue(carpintiCheckbox.isSelected());
        //ReusableMethod.bekle(3);

        //  d. Seker ve Epilepsi checkbox'lariinin secili
        //     olmadigini test edin

        WebElement sekerCheckbox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckbox = driver.findElement(By.id("hastalikCheck7"));


        Assertions.assertFalse(sekerCheckbox.isSelected());
        Assertions.assertFalse(epilepsiCheckbox.isSelected());


    }


}
