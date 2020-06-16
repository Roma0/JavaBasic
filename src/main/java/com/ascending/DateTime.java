package com.ascending;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTime {

    public static void main(String[] arg){
        Instant zonedDateTime = ZonedDateTime.now().toInstant();
        System.out.println(zonedDateTime.atOffset(ZoneOffset.UTC));
        System.out.println(zonedDateTime.atZone(ZoneId.of("America/New_York")));
        System.out.println(ZonedDateTime.now());
        System.out.println(ZonedDateTime.now().getZone());
    }

}
