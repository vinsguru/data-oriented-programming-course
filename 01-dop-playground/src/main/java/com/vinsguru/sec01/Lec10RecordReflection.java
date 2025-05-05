package com.vinsguru.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/*
*  Introspect or access record components dynamically.
* */
public class Lec10RecordReflection {

    private static final Logger log = LoggerFactory.getLogger(Lec10RecordReflection.class);

    record Person(String name,
                  int age){
    }

    public static void main(String[] args) {

        accessRecordComponents(String.class);
        accessRecordComponents(Person.class);

        accessFieldValues("sam");
        accessFieldValues(new Person("sam", 10));

    }

    private static <T> void accessRecordComponents(Class<T> type){

        if(!type.isRecord()){
            log.info("{} is not a record", type);
            return;
        }

        Arrays.stream(type.getRecordComponents())
                .forEach(rc -> log.info("{}-{}", rc.getName(), rc.getType()));

    }

    private static void accessFieldValues(Object object){

        if(!object.getClass().isRecord()){
            log.info("{} is not a record", object.getClass());
            return;
        }

        Arrays.stream(object.getClass().getRecordComponents())
              .forEach(rc -> {
                  try {
                      log.info("{}-{}", rc.getName(), rc.getAccessor().invoke(object));
                  } catch (IllegalAccessException | InvocationTargetException e) {
                      throw new RuntimeException(e);
                  }
              });

    }

}
