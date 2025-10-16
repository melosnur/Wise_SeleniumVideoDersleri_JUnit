package tests.K06_JUnitFramework.D03_Assertions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_AssertionsClassWork {

    // https://www.bestbuy.com/ Adresine gidin
    // farkli test method'lari olusturarak asagidaki testleri yapin
    // Sayfa URL'nin https://www.bestbuy.com/ 'a esit oldugunu test edin
    // titleTest => Sayfa basliginin "Rest" icermedigini(contains) test edin
    // logoTest => BestBuy logosunun goruntulendigini test edin
    // FrancaisLinkTest => Fransizca Linkin goruntulendigini test edin

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterAll
        public static void teardown() {driver.quit();}

    @Test
            public void urlTest(){
            // Sayfa URL'nin https://www.bestbuy.com/ 'a esit oldugunu test edin
            String expectedUrl = "https://www.bestbuy.com/";
            String actualUrl = driver.getCurrentUrl();

            Assertions.assertEquals(expectedUrl,actualUrl);
        }
        @Test
        public void titleTest(){
            // titleTest => Sayfa basliginin "Rest" icermedigini(contains) test edin
        String unExpectedTitleIcerik = "Reset";
        String actualTitle = driver.getTitle();
            Assertions.assertFalse(actualTitle.contains(unExpectedTitleIcerik));
    }

        @Test
        public void logoTest(){
            // logoTest => BestBuy logosunun goruntulendigini test edin
            WebElement logoElementi = driver.findElement(By.xpath("//div[@lang='en']//img[@alt='Best Buy Logo']"));
            Assertions.assertTrue(logoElementi.isDisplayed());
        }

        @Test
         public void linkTest(){
            // FrancaisLinkTest => Fransizca Linkin goruntulendigini test edin
            WebElement francaisLinkElementi = driver.findElement(By.xpath("//button[normalize-space()='Français']"));
            Assertions.assertTrue(francaisLinkElementi.isDisplayed());
        }
    }


