package by.epam.atm.lecture5.utiles;

import java.util.Random;

public class AddNumberToString {

    public static final int DEFAULT_INT = 1000;

    public String addRandomNumber(String string){
        Integer random = new Random().nextInt(DEFAULT_INT);
        String prefixString = random.toString()+ ": " + string;
        return prefixString;
    }
}
