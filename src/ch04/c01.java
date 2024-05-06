package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class c01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            String line = scanner.next();
            int answer = 0;

            for (int j = 2; j <= 64; j++) {
                String s = Integer.toString(Integer.parseInt(line), j);
                String r = new StringBuilder(s).reverse().toString();

                if (s.equals(r)) {
                    answer = 1;
                    break;
                }
            }
            System.out.println(answer);
        }
        scanner.close();
    }
}
