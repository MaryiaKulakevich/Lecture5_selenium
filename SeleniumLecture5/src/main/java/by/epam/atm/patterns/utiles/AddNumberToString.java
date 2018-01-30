package by.epam.atm.patterns.utiles;

import java.util.Random;

public class AddNumberToString {

    public static final int DEFAULT_INT = 1000;

    public static String addRandomNumber(String string){
        Integer random = new Random().nextInt(DEFAULT_INT);
        String prefixString = random.toString()+ ": " + string;
        return prefixString;
    }
}
