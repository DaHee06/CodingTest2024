package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b10816_Q {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M ; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = arr.length;
        StringBuilder sb = new StringBuilder();
        //인덱스 이상 ~ 초과
        for (int i = 0 ; i < M ; i++){
            left = lower_bound(arr2[i], arr);
            right = upper_bound(arr2[i], arr);
            int sum = right - left;
            sb.append(sum + " ");
        }

        System.out.println(sb.toString());

    }

    public static int lower_bound(int key, int[] arr){
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if (key <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int upper_bound(int key, int[] arr){
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if (key < arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


}
