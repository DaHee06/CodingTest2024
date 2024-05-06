package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


/**
 *
 * 문제에서 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
 *
 *
 * compare :   양의 정수일 경우만 두 객체의 위치를 바꿔주는 역할
 * 즉, 나이순으로 정렬하면서 이름은 따로 비교를 안한다면 나이순으로 정렬하되,
 * 나이가 같을 경우는 0이 반환되어 자연스레 입력순으로 정렬된다.
 */


public class b10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][2];

        for(int i = 0 ; i < N ; i++){
            String[] st = br.readLine().split(" ");

            arr[i][0] = st[0];
            arr[i][1] = st[1];
        }

//        for(int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            arr[i][0] = st.nextToken();
//            arr[i][1] = st.nextToken();
//        }


        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

//        Arrays.sort(arr, new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                if(o1[0] == o2[0]){
//                    return o1[1].compareTo(o2[1]);
//                }else{
//                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
//                }
//            }
//        });
//
//        Arrays.sort(arr, new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                if(Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])){
//                    return o1[1].compareTo(o2[1]);
//                }else{
//                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
//                }
//            }
//        });


        for(int i = 0; i< N ; i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

    }

}

