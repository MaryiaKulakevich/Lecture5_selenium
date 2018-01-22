package by.epam.atm.lecture5.bo;

public class Letter {

    private static final String TO = "mentee2017@mail.ru";
    private static final String SUBJECT = "lecture5 selenium";
    private static final String BODY = "WebDriver is a remote control interface that enables introspection and control of user agents.";

    public String getRecipient() {
        return TO ;
    }

    public String getSubject() {
        return SUBJECT;
    }

    public String getBody() {
        return BODY;
    }

}
