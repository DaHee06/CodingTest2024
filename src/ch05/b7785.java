package ch05;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class b7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> arr = new HashSet<>();

        for(int i = 0 ; i < N ;i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String val = st.nextToken();

            if(val.equals("enter")){
                arr.add(name);
            }else if(val.equals("leave")){
                arr.remove(name);
            }
        }

        br.close();

        ArrayList<String> list = new ArrayList<>(arr);
        Collections.sort(list, Collections.reverseOrder());

        for(var li : list) {
            System.out.print(li + " ");
        }
        bw.flush();
        bw.close();
    }
}
