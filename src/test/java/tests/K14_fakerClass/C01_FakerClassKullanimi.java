package tests.K14_fakerClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C01_FakerClassKullanimi {

    @Test
    public void test01(){

        Faker faker = new Faker();

        System.out.println(faker.lordOfTheRings().character()); // Saruman the White

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().name());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().fullName());
        System.out.println(faker.name().nameWithMiddle());
        System.out.println(faker.name().username());

        System.out.println(".....................");

        System.out.println(faker.address().cityName());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.address().city());
        System.out.println(faker.address().buildingNumber());
        System.out.println(faker.address().country());
        System.out.println(faker.address().countryCode());
        System.out.println(faker.address().state());
        System.out.println(faker.address().streetName());

        System.out.println(".....................");

        System.out.println(faker.internet().password());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().safeEmailAddress());
        System.out.println(faker.internet().userAgentAny());


    }

}
