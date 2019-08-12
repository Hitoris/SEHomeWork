package com.se.day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.util.Scanner;

import static oracle.net.aso.C00.i;

/**
 * 创建一个"raf.dat"的文件，并在其中写出一个int的最大值，long的最大值，
 * 然后将其分别读取出来并输出
 */
public class Test08 {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("raf.dat","rw");
            raf.writeInt(Integer.MAX_VALUE);
            raf.writeLong(Long.MAX_VALUE);
            raf.seek(0);
            int i = raf.readInt();
            long l = raf.readLong();
            System.out.println(i);
            System.out.println(l);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
