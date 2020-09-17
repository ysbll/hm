package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import java.util.Random;


public class UserDataGenerator {
    private static Faker faker = new Faker();

    public static String emailGenerator(){
        String name = faker.name().firstName();
        name = name + "@gemeil.com.pl";
        return name;
    }

    public static String passwordGenerator(){
        Random random = new Random(1000);
        String password = "Password" + random;
        return password;
    }




}
