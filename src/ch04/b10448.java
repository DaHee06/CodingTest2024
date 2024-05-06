package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 완전 탐색 - 시뮬레이션 10448
 *
 * 1. 자연수 K의  Tn의 합으로 이뤄져야 하기 때문에 Tn의 최대값은 K를 넘어선 안됨
 *    -> 미리 계산하여 배열에서 정리
 * 2. 세 개의 Tn의 for문을 돌려 세개의 합이 될 때만 return 1이 되게 정의 -> 메소드 처리
 */
public class b10448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        int[] arr = new int[45];
        for(int i = 1; i< 45; i++){
            arr[i] = i*(i+1)/2;
        }
        for(int i = 0 ; i< N ; i ++) {
            int result = 0;
            int num = Integer.parseInt(br.readLine());
            result = calulate(num, arr);
            System.out.println(result);
        }
    }

    public static int calulate(int num, int[] arr){
        int sum = 0;
        for(int i = 1; i<arr.length; i++){
            for(int j = 1; j<arr.length; j++){
                for(int k = 1; k<arr.length; k++){
                    sum = arr[i] + arr[j] + arr[k];
                    if(sum == num) return 1;
                }
            }
        }
        return 0;
    }
}
