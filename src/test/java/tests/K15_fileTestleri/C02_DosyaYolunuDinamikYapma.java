package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){

        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

         String dosyaYoluDownloadsDeneme = "/Users/melahatnurozcan/Downloads/deneme.txt";
        /*
            /Users/ahmetbulutluoz            /Downloads/deneme.txt
            \\Users\\Cansu                   \\Downloads\\deneme.txt
            C:\\Users\\Hamza                 \\Downloads\\deneme.txt

         */

        System.out.println(System.getProperty("user.home")); // /Users/melahatnurozcan

        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        /*
            eger dosya yolunu normal olarak yazarsak
            /Users/melahatnurozcan/Downloads/deneme.txt
            sadece dosya yolunu olusturan kisinin bilgisayarinda calisir
            baska bilgisayarlarda calismaz

            Java artik calisabilmemiz icin
            her kisinin bilgisayarinda farkli olan bastaki kismi
            alabilecegimiz bir kod hazirlamistir

            herkeste farkli olan kisim : //Users/melahatnurozcan
            herkeste ortak olan kisim  : /Downloads/deneme.txt


         */

        String dinamikDownloadsDosyaYoluDeneme = System.getProperty("user.home") +"/Downloads/deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDownloadsDosyaYoluDeneme))); //passed

        // K15 package'i altinda deneme.txt dosyasinin
        // var oldugunu test edin

        String dosyaYoluProjedekiDeneme = "/Users/melahatnurozcan/IdeaProjects/Wise_SeleniumVideoDersleri_JUnit" +
                                            "/src/test/java/tests/K15_fileTestleri/deneme.txt";
                                            // copy path reference-->absolute path

        System.out.println(System.getProperty("user.dir"));
        // /Users/melahatnurozcan/IdeaProjects/Wise_SeleniumVideoDersleri_JUnit

        /*
            Herkeste farkli olan kisim :  /Users/melahatnurozcan/IdeaProjects/Wise_SeleniumVideoDersleri_JUnit
            Herkeste ayni olan kisim   :  /src/test/java/tests/K15_fileTestleri/deneme.txt

         */

        String dinamikDosyaYoluProjedekiDeneme = System.getProperty("user.dir") +
                                                "/src/test/java/tests/K15_fileTestleri/deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYoluProjedekiDeneme)));


    }
}
