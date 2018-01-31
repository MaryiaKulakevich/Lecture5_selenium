package by.epam.atm.lecture8.bo;

import by.epam.atm.patterns.decorator.string_decorator.AddNumberToString;

public class Letter {

    private static final String TO = "mentee2017@mail.ru";
    private static final String SUBJECT = "lecture8 selenium";
    private static final String BODY = "Automation mentoring program";

    public String getRecipient() {
        return TO;
    }

    public String getSubject() {
        return SUBJECT;
    }

    public String getBody() {
        return AddNumberToString.addRandomNumber(BODY);
    }

}
