package com.vinsguru.sec08.lec01;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);
    private static final ObjectMapper mapper = new ObjectMapper();


    public static void main(String[] args) throws JsonProcessingException {

        var email = """
                { "address":"sam@gmail.com" }
                """;

        var phone = """
                { "countryCode":"+1", "number":"123-456-7890" }
                """;

        log.info("{}", deserialize(email));

        log.info("{}", deserialize(phone));

        log.info("{}", deserialize("{}"));

    }

    private static ContactType deserialize(String json) throws JsonProcessingException {
        return mapper.readValue(json, ContactType.class);
    }

}
