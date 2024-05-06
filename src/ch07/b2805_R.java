package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2805_R {
    static int mid;
    static long sum; // long으로 수정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

//        int min = 0;
        int min = arr[0];
        int max = arr[N - 1];

        while (min <= max) {
            sum = 0;

            mid = (min + max) / 2;

            for (int i : arr) {
                if ((i - mid) > 0) {
                    sum += (i - mid);
                }
            }

            if (sum >= M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }

        }
        System.out.println(max);
    }

}