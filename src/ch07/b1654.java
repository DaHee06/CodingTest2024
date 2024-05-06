package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  랜선의 최소 길이가 1이상이기 때문에 최소값 1
 *  길이 -> long
 */
public class b1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long lo = 1;
        long hi = arr[arr.length - 1];
        long result = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long count = 0;

            for (int i : arr) {
                count += (i / mid);
            }

            if (count < N) hi = mid - 1; //
            else {
                lo = mid + 1;
                result = Math.max(result, mid);
            }
        }

        System.out.println(result);
    }

}
