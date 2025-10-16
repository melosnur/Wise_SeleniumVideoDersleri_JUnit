package tests.K06_JUnitFramework.D03_Assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C02_AssertionsMethodlari {

    int a = 10;
    int b = 20;
    int c = 30;
    String url1 = "https://www.testotomasyonu.com";
    String url2 = "https://www.testotomasyonu.com/";

    @Test
    public void test01(){
        // c'nin a ile b'nin toplamina esit oldugunu test edin

        Assertions.assertEquals(c,a+b);
    }

    @Test
    public void test02(){
        // c'nin a ile b'nin toplamina esit oldugunu test edin

        Assertions.assertTrue(c==a+b);
    }

    @Test
    public void test03(){
        // b'nin a ile c'nin toplamina esit oldugunu test edin

        //equals mumkunse onceligimiz equals() kullanmaktir

         Assertions.assertEquals(b,a+c);
        // Expected :20
        // Actual   :40

        // Assertions.assertTrue(b==a+c);
        // Expected :true
        // Actual   :false
    }

    @Test
    public void test04(){
        // b'nin a ile c'nin toplamina esit olmadigini test edin

        Assertions.assertNotEquals(b,a+c);
    }

    @Test
    public void test05(){
        // url1 ile url2'nin ayni oldugunu test edin

        Assertions.assertEquals(url1,url2);
        // Expected :https://www.testotomasyonu.com
        // Actual   :https://www.testotomasyonu.com/
    }
    @Test
    public void test06(){
        // url1 ile url2'nin ayni oldugunu test edin

        Assertions.assertTrue(url1.equals(url2));
        //Expected :true
        //Actual   :false

    }

    @Test
    public void test07(){
        // url1 ile url2'nin ayni olmadigini test edin

        Assertions.assertNotEquals(url1,url2);
    }

    @Test
    public void test08(){
        // url1'in "test" kelimesini icerdigini test edin

        Assertions.assertTrue(url1.contains("test"));
    }

    @Test
    public void test09(){
        // url1'in "best" kelimesini icermedigini test edin

        Assertions.assertFalse(url1.contains("best"));
    }


}
