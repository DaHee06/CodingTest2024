package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max , arr[i]);
        }


        int lo = max ;
        int hi = 10000 * N;

        int result = hi;
        while(lo <= hi){
            int K = (lo + hi)/2; //인출 금액
            int pay = 0 ; //현재 가지고 있는 금액
            int count = 0;

            for(int i = 0; i < N ; i++){
                if(pay < arr[i] ){
                    count++;
                    pay = K;
                }
                pay -= arr[i];
            }
//            for(int i = 0; i < N; i++) {
//                if (pay + arr[i] > K) { // 다음에 사용할 금액을 인출할 금액과 더한 후 K보다 큰지 비교
//                    count++;
//                    pay = arr[i]; // 다음에 사용할 금액을 인출할 금액으로 설정
//                } else {
//                    pay += arr[i]; // 다음에 사용할 금액을 현재까지의 인출 금액에 추가
//                }
//            }

            if(count > M) lo = K + 1;
            else {
                hi = K - 1;
                result = Math.min(result, K);
            }

        }

        System.out.println(result);



    }
}
