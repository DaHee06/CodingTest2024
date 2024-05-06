package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr1 = new String[N];
        String[] arr2 = new String[M];

        for(int i = 0 ; i < N ; i++){
            String str1 = br.readLine();
            arr1[i] = str1;
        }
        for(int i = 0 ; i < M ; i++){
            String str2 = br.readLine();
            arr2[i] = str2;
        }

        int count = 0;
        for (String str1 : arr1) {
            for (String str2 : arr2) {
                if(str1.equals(str2)) count++;
            }
        }

        System.out.println(count);
    }
}
