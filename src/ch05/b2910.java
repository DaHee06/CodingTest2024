package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/**
 *  빈도 정렬
 *
 *  1. 숫자를 자주 등장하는 빈도를 센다.
 *  2. 빈도가 같다면 먼저 나온 것을 앞에 출력한다.
 *
 */
public class b2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0 ; i< N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ;i < N ; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        int max = 0 ; // 빈도수, value
        int num = 0 ;
        //빈도가 같다면 먼저 나온 것을 앞에 출력 -> ??
        for (Integer i : map.keySet()) {
            if(max < map.get(i)){
                max = map.get(i);
                num = i;
            }
        }
        //모르겠음


        System.out.println(num);
    }
}
