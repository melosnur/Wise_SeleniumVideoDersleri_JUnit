package tests.K15_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExistTesti {

    @Test
    public void test01(){

        // K15 package'i altinda deneme.txt dosyasinin
        // var oldugunu test edin


        String dosyaYoluDeneme = "src/test/java/tests/K15_fileTestleri/deneme.txt";
        // deneme ustune gelip copy path reference kismini scetik oradan da
        // src yazani aldik(content root)

        System.out.println(Files.exists(Paths.get(dosyaYoluDeneme))); //true
        // boyle bir dosya var mi yok mu yazdirir

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYoluDeneme))); //test pass


        // K15 package'i altinda deneme1.txt dosyasinin
        // var olmadigini test edin

        String dosyaYoluDeneme1 = "src/test/java/tests/K15_fileTestleri/deneme1.txt";

        System.out.println(Files.exists(Paths.get(dosyaYoluDeneme1))); // false

        Assertions.assertFalse(Files.exists(Paths.get(dosyaYoluDeneme1))); // test pass


        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        String dosyaYoluDownloadDeneme = "/Users/melahatnurozcan/Downloads/deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYoluDownloadDeneme)));





    }

}
