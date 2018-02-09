package by.epam.atm.lecture10.bo;

import by.epam.atm.patterns.decorator.string_decorator.AddNumberToString;

public class Letter {

    private static final String TO = "mentee2017@mail.ru";
    private static String subject= "lecture10 selenium";
    private static final String BODY = "Automation";

    public String getRecipient() {
        return TO;
    }

    public String getSubject() {return subject;
    }

    /**
     * Setter is added to specify different subjects for Examples of cucumber
     */
    public static void setSubject(String string){
       subject=string;
    }

    public String getBody() {
        return AddNumberToString.addRandomNumber(BODY);
    }

}
