package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 11005 - 진법 변환2
 *
 * 아스키 코드 'A'의 경우 65, 'A'의 경우 97
 */
public class b11005 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        //내풀이
//        StringBuilder sb = new StringBuilder();
//
//        while((N%B) < B){
//            if((N%B) >= 10) sb.append((char)(N%B)-10+'A');
//            else sb.append((N%B));
//            N /= B;
//        }
//
//        System.out.println(sb.reverse().toString());


        //List 이용
        ArrayList<Character> list = new ArrayList<>();

        while(N>0){
            if((N%B) >= 10) list.add((char) (N % B - 10 + 'A'));
            else list.add((char) (N % B + '0')); //그냥 숫자출력
            N /= B;
        }

        for (int i = list.size() - 1; i >= 0; i--) { // 맨처음부터 출력해야하므로
            System.out.print(list.get(i));
        }

    }
}
