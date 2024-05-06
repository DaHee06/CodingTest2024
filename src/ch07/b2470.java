package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int le = 0;
        int ri = N - 1;
        int min = Integer.MAX_VALUE;

        int answer1 = 0;
        int answer2 = 0;

        while (le < ri) {
            int k = arr[le] + arr[ri];
            if (Math.abs(k) < min) {
                min = Math.abs(k);
                answer1 = arr[le];
                answer2 = arr[ri];
            }
            if (k < 0) le++;
            else ri--;
        }

        System.out.println(answer1 + " " + answer2);
    }
}
