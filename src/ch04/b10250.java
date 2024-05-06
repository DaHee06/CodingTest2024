package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < M ; i++){

            //for 문 안에 StringTokenizer을 넣어 해당 줄에 대해 새로 생성
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            //나누기 -> 완전히 나눠지는 경우 고려
            int X = 1;
            int Y = 1;
            if(N%H == 0){
                X = (N/H);
                Y = H * 100;
            }else{
                X = (N/H) + 1;
                Y = (N%H) * 100;
            }

            //다른 해설
//            if (N % H == 0) {
//                sb.append((H * 100) + (N / H)).append('\n');
//
//            } else {
//                sb.append(((N % H) * 100) + ((N / H) + 1)).append('\n');
//            }

            int ans = Y + X ;
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
