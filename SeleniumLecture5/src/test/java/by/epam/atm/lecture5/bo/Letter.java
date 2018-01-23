package by.epam.atm.lecture5.bo;

import by.epam.atm.lecture5.utiles.AddNumberToString;

public class Letter {

    private static final String TO = "mentee2017@mail.ru";
    private static final String SUBJECT = "lecture5 selenium";
    private static final String BODY = "Automation mentoring program";

    public String getRecipient() {
        return TO;
    }

    public String getSubject() {
        return SUBJECT;
    }

    public String getBody() {
        return new AddNumberToString().addRandomNumber(BODY);
    }

}
