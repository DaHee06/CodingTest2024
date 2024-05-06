package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 삼중 for문 -> 시간 복잡도 O(n^3)
 * <p>
 * 가상의 배열을 만든 후(O(n^2)) 각 합에 대해 배열을 탐색 후 합(O(n^2)) -> 전쳊벅인 시간 복잡도 O(n^2)
 *
 *  숫자가 모두 같아도 된다.
 *
 *  binarySearch(배열, 찾고자 하는 요소) : 정렬되어 있는 배열 한에서 찾고자 하는 요소의 인덱스를 반환
 *
 *  set -> 배열이 아니기 때문에 덧셈, 뺄셈들 활용할 수 있는 것을 계산하자
 */
public class b2295_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];
        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine()); //U에 대한 배열
        }

        Arrays.sort(U);

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                set.add(U[i] + U[j]);
            }
        }

        int max = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                int k = U[i] - U[j];
                if (set.contains(k)) {
                    max = Math.max(U[i], max);
                }
            }
        }

        System.out.println(max);


    }
}
