package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class b1181_stream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i = 0; i < N ; i++){
            String str = br.readLine();
            arr[i] = str;
        }

        String[] sortedString = Arrays.stream(arr)
                .distinct()
                .sorted(Comparator.comparingInt(String::length).thenComparing(String::compareTo))
                .toArray(String[]::new);

        for (int i = 0; i < sortedString.length; i++) {
            System.out.println(sortedString[i]);
        }
    }
}
