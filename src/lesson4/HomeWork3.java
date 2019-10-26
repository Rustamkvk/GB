package lesson4;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
        try {
            task1();
            task2();
            task3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void task3() throws IOException {
        final int PAGE_SIZE = 1800;
        RandomAccessFile raf = new RandomAccessFile("1.txt", "rw");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter page:");
        int p = sc.nextInt() - 1;
        raf.seek(p * PAGE_SIZE);
        for (int i = 0; i < PAGE_SIZE; i++) {
            System.out.print((char)raf.read());
        }
        raf.close();
    }

    public static void task2() throws IOException {
        ArrayList<InputStream> al = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            al.add(new FileInputStream(i + ".txt"));
        }
        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        int x;
        while((x = in.read()) != -1) {
            System.out.print((char)x);
        }
        in.close();
    }

    public static void task1() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("2.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int x;
        while((x = in.read()) != -1) {
            out.write(x);
        }
        byte[] b = out.toByteArray();
        System.out.println(Arrays.toString(b));
        in.close();
        out.close();
    }
}