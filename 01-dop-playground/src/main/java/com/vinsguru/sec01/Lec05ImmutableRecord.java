package com.vinsguru.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/*
*  Are records immutable? It depends!
* */
public class Lec05ImmutableRecord {

    private static final Logger log = LoggerFactory.getLogger(Lec05ImmutableRecord.class);

    record Team(String name,
                List<String> members){

        Team{
            members = List.copyOf(members);
        }

    }


    public static void main(String[] args) {

        var members = new ArrayList<String>();
        members.add("sam");
        members.add("mike");

        var team = new Team("dev team", members);

        log.info("{}", team);

        members.add("jake");

        log.info("{}", team);


    }

}
