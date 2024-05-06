package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Arrays.fill() : 배열의 모든 요소를 지정된 값으로 채우는데 사용
 * StringTokenizer의 nextToken()의 메서드 반환 String
 * Charater.toString : char로 반환
 * char 배열 선언시 모든 요소는 0으로 초기화
 *
 */
public class b2840 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] wheel = new char[N];
        int cur = 0; //현재 화살표가 가르키는 번호

        for(int i = 0; i < K ; i++){ //K번째 반복
           st = new StringTokenizer(br.readLine());
           int S = Integer.parseInt(st.nextToken());
           char ch = st.nextToken().charAt(0);

           cur = (cur + S) >= N ? (cur + S)%N : N ;
           //지정된 배열의 값에 다른 값이 들어있지 않고 ch이 아닐 때 --> 행운의 바퀴가 아니고 정해준 ch이 아닐 때
           if(wheel[cur] != 0 && wheel[cur] != ch){
               System.out.println("!");
               return;
           }
           wheel[cur] = ch;

        }

        String ans = "";
        for(int i = cur ; i>=0; i--){
            if(wheel[i] == 0){
                ans+=("?");
            }else if(ans.contains(Character.toString(wheel[i]))){
                System.out.println("!");
                return;
            }else{
                ans+=wheel[i];
            }
        }
        for(int i = N-1 ; i>cur; i--){
            if(wheel[i] == 0){
                ans+=("?");
            }else if(ans.contains(Character.toString(wheel[i]))){
                System.out.println("!");
                return;
            }else{
                ans+=wheel[i];
            }
        }
        System.out.println(ans);

    }
}
