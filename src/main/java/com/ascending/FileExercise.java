package com.ascending;

import java.io.File;

public class FileExercise {
    private static File file = new File("/Users/roma/Downloads/1310.png");

    public static void main(String[] args){
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
    }
}
