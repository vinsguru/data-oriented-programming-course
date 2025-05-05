package com.vinsguru.sec03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Lec01InstanceOf {

    private static final Logger log = LoggerFactory.getLogger(Lec01InstanceOf.class);

    public static void main(String[] args) {

        log.info("{}", isEmpty(null));
        log.info("{}", isEmpty(""));
        log.info("{}", isEmpty("vinsguru"));
        log.info("{}", isEmpty(List.of()));
        log.info("{}", isEmpty(List.of(1)));

    }

    public static boolean isEmpty(Object obj) {
        log.info("received: {}", obj);
        if (obj == null) {
            return true;
        } else if (obj instanceof String string) {
            return string.isEmpty();
        } else if (obj instanceof Collection<?> collection) {
            return collection.isEmpty();
        } else if (obj instanceof Map<?, ?> map) {
            return map.isEmpty();
        } else if (obj instanceof Object[] array) {
            return array.length == 0;
        }
        return false;
    }

}
