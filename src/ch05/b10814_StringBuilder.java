package ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10814_StringBuilder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder[] p = new StringBuilder[201];

        for (int i = 0; i < p.length; i++) {
            p[i] = new StringBuilder();
        }

        //p[age]에 저장될 때 같은 나이끼리 저장, 문자는 자연스레 사전순
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            p[age].append(age).append(' ').append(name).append('\n');
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder v : p){
            sb.append(v);
        }

        System.out.println(sb);


    }
}
