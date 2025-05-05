package com.vinsguru.sec04.lec02;

public class Demo {


    public static void main(String[] args) {

        // user logs in with valid credentials. as part of MFA, we send some code

        var sam = new User("sam", new ContactType.Phone("+1", "123-456-7890"));
        var mike = new User("mike", new ContactType.EMail("mike@gmail.com"));

        LoginVerificationService.sendVerificationCode(sam);
        LoginVerificationService.sendVerificationCode(mike);


    }


}
