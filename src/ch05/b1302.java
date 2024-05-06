package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 가장 많이 팔린 책
 * 2. 많이 팔린 책이 여러개 일 경우 사전 순 출력
 */
public class b1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for(int i = 0 ; i< N ; i++){
            arr[i] = br.readLine();
        }

        HashMap<String, Integer> map = new HashMap<>();

//        for (int i = 0; i < N; i++) {
//            String book = br.readLine();
//            map.put(book, map.getOrDefault(book, 0) + 1);
//        }
//
//        int max = Collections.max(map.values());
//
//        List<String> list = new ArrayList<>();
//
//        //alt + enter
//        map.forEach((key, value) -> {
//            if (value == max) {
//                list.add(key);
//            }
//        });
//
//        Collections.sort(list);
//        System.out.print(list.get(0));

        for(int i = 0 ;i < N ; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        int max = 0;
        String str = "";

        for (String s : map.keySet()) {
            if(max < map.get(s)){
                max = map.get(s);
                str = s;
            }
            //max값이 같은 단어들이 여러개 나올 때 추가 조건 넣기
            else if(max == map.get(s) && str.compareTo(s) > 0){
                str = s;
            }
        }

        System.out.println(str);


    }
}
