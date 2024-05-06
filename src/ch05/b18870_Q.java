package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b18870_Q {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int[] arr2 = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            arr2[i] = num;
        }

        Arrays.sort(arr);

        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N - 1; i++) {
            map.put(arr[i], count); // -10 -9 2 4 4  0 1 2 3
            if (arr[i] != arr[i + 1]) {
                count++;
            }
            System.out.println(arr[i] + ":" + count);
        }

//        for (int i = 0; i < N; i++) {
//            if (!map.containsKey(arr[i])) {
//                map.put(arr[i], count++);
//            }
//        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr2[i])).append(" ");
        }

        System.out.println(sb.toString());

    }
}
