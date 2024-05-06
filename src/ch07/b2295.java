package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class b2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] U = new int[N];
        for(int i = 0; i <N;i++){
            U[i] = Integer.parseInt(br.readLine());
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i : U) {
            for (int i1 : U) {
                set.add(i+i1);
            }
        }

        int max = 0;
        for (int i : U) {
            for (int i1 : U) {
                int k = i1 - i;
                if(set.contains(k)){
                    max = Math.max(i1, max);
                }
            }
        }
        System.out.println(max);
    }
}
