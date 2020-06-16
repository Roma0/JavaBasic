package com.ascending;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionExercise {
 private    Map<String, String> bAndK = new HashMap<String, String>();

    public static void main(String[] args) {
        Map<String, String> bAndK = new HashMap<String, String>();
        bAndK.put("bucket", "testBucket");
        bAndK.put("key", "ketTest");
        Collection<String> param = new ArrayList<>();
        param.add("bucket");
        param.add("key");

        bAndK.values();
//        param.forEach(e -> System.out.println(e.toString()));

        List list = new ArrayList<>();
        list.add(bAndK.get("bucket"));
        list.add(bAndK.get("key"));
        System.out.println(list);

        list.stream().collect(Collectors.toMap( e -> e, e -> e.toString() ));



//        System.out.println(bAndK.keySet().containsAll(param));
//        System.out.println(bAndK.forEach(<k,v> -> k.toString()));
//        bucketAndKey.keySet().containsAll(param);
    }
}
