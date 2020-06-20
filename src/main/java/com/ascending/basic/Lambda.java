package com.ascending.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lambda {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //Convert map to 2 Unsorted lists
    private void unsortedMapToList(Map<Integer, String> map){

        System.out.println("Unsorted map:");
        map.entrySet().stream().forEach(System.out::println);

        List<Integer> keysList = new ArrayList<Integer>();
        List<String> valuesList = new ArrayList<String>();
        keysList = map.keySet().stream().collect(Collectors.toList());
        valuesList = map.values().stream().collect(Collectors.toList());

        System.out.println("Unsorted keys list:");
        keysList.forEach(System.out::println);
        System.out.println("Unsorted values list:");
        valuesList.forEach(System.out::println);

    }

    //Convert map to 2 Sorted lists
    private void sortedMapToList(Map<Integer, String> map){

        System.out.println("Sorted map:");
        List<Integer> sortedKeys = new ArrayList<Integer>();
        List<String> sortedValues = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .peek(System.out::println)
                .peek(e -> sortedKeys.add(e.getKey()))
                .map(e -> e.getValue())
                .collect(Collectors.toList());

        System.out.println("Sorted keys list:"
                + sortedKeys.stream()
                .map(e -> e.toString().replaceAll("^", "\n"))
                .collect(Collectors.joining()));

        sortedValues.replaceAll(e -> e.replaceAll("^", "\n"));
        System.out.println("Sorted values list:" + sortedValues.toString()
                .replaceAll("\\[|,|\\]", "")
        );

    }

    public static void main(String[] args){
        Lambda lambda = new Lambda();

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(10, "yd");
        map.put(20, "wx");
        map.put(30, "fx");
        map.put(40, "tf");

        lambda.unsortedMapToList(map);

        lambda.sortedMapToList(map);

    }
}
