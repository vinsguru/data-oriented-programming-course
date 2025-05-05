package com.vinsguru.sec08.lec03;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = ContactType.EMail.class)
@JsonSubTypes({
        @JsonSubTypes.Type(ContactType.EMail.class),
        @JsonSubTypes.Type(ContactType.Phone.class)
})
public class ContactTypeMixIn {
}
