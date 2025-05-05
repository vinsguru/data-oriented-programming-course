package com.vinsguru.sec08.lec02;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        defaultImpl = ContactType.EMail.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ContactType.EMail.class, name = "email"),
        @JsonSubTypes.Type(value = ContactType.Phone.class, name = "phone")
})
public sealed interface ContactType {

    record EMail(String info) implements ContactType {

    }

    record Phone(String info) implements ContactType {

    }

}
