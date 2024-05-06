package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class b10814_stream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][2];

        IntStream.range(0, N)
                .forEach(i -> {
                    try {
                        String[] st = br.readLine().split(" ");
                        arr[i][0] = st[0];
                        arr[i][1] = st[1];
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        Arrays.sort(arr, Comparator.comparingInt(o -> Integer.parseInt(o[0])));

        //배열을 스트림으로 변환하기 위한 Arrays의 메서드
        //배열의 요소들을 순차적 스트림으로 변경
        Arrays.stream(arr)
                .forEach(row -> System.out.println(row[0] + " " + row[1]));

//        Arrays.stream(arr)
//                .sorted((o1, o2) -> {
//                    int age1 = Integer.parseInt(o1[0]);
//                    int age2 = Integer.parseInt(o2[0]);
//
//                    if (age1 == age2) {
//                        return o1[1].compareTo(o2[1]);
//                    } else {
//                        return Integer.compare(age1, age2);
//                    }
//                })
//                .forEach(row -> System.out.println(row[0] + " " + row[1]));
    }
}
