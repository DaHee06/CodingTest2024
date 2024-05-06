package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 정렬 알고리즘 이용
 *  종료  시간 기준으로 저렬
 */
public class b1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        for(int i = 0; i< N ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start_time = Integer.parseInt(st.nextToken());
            int end_time = Integer.parseInt(st.nextToken());

            time[i][0] = start_time;
            time[i][1] = end_time;
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });


        int count = 0;
        int pre_time = 0 ;

        for(int i = 0; i < N ; i++){
           if(pre_time <= time[i][0]){
               pre_time = time[i][1];
               count++;
           }
        }

        System.out.println(count);
    }
}
