package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  주어진 값들 중에서 0에 가장 가까운 수
 *  오름차순으로 출력
 *  두 개 이상일 경우 그 중 하나만 출력해도 됨
 *
 *  파라메트릭 서치
 *  : 문제의 상황을 만족하는 특정 변수의 최솟값, 최댓값을 구하는 문제)를 결정 문제로 바꾸어 푸는 것
 *
 *  투 포인터
 *  : 리스트에 순차적으로 접근해야 할 때 두 점의 위치를 기록하면서 처리
 *   -> 시간 알고리즘 O(N)
 *
 */
public class b2470_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr= new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 해답을 오름차순으로 답하기 위해

        /**
         * HashMap을 사용하는 경우 키-값의 쌍을 저장하기 때문에 상수 시간에 접근하는 시간 -0> 시간 제한 원인
         */
//        Map<Integer, Integer> ans = new HashMap<Integer, Integer>(2);

        /**
         *  배열의 크기가 최대 100,000이므로 이중 반복문 사용시 최대 10억번 -> 시간 제한
         *  최대 값이 무엇인지 확인하기
         */
//        int min = Integer.MAX_VALUE;
//        for(int i = 0 ; i < N ; i++){
//            for(int j = i + 1 ; j < N ; j++){
//                if(i!=j){
//                    int k = arr[i] + arr[j];
//                    k = Math.abs(k);
//                    min = Math.min(min, k);
//                    if(min == k) {
//                        ans.put(1, arr[i]);
//                        ans.put(2, arr[j]);
//                    }
//                }
//            }
//        }
//
//        System.out.println(ans.get(1)+" "+ans.get(2));


        int left = 0;
        int right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                answer1 = arr[left];
                answer2 = arr[right];
            }
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                break;
            }
        }

        System.out.println(answer1 + " " + answer2);

    }
}
