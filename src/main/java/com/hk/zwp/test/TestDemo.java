package com.hk.zwp.test;

import java.io.File;
import java.util.UUID;

public class TestDemo {
    public static void main(String[] args) {
        File file=new File("E:\\file.txt");
        String fileName=file.getName();
        String fileTyle=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        String newFileName = UUID.randomUUID()+fileTyle;
        System.out.println(newFileName);
    }

}
