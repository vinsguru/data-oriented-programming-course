package com.vinsguru.sec04.lec03;

public class Demo {

    public static void main(String[] args) {

        // validate everything upfront. no surprises later
        var eMailAddress = new EMailAddress("sam@gmail.com");
        var message = new Message("Hi Sam, How are you?");
        EMailService.send(eMailAddress, message);

    }

}
