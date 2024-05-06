package ch04;

import java.io.*;

public class t01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            answer[i] = findPalindrome(num);
        }

        for (int j = 0 ; j < n; j++) {
            bw.write(String.valueOf(answer[j]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static int findPalindrome(long num) {

        int result = 0;
        for (int b = 2; b <= 64; b++) {
            StringBuffer sb = new StringBuffer();
//            String str = Long.toString(num, b);
            while(num > 0){
                sb.append((char)(num % b));
                num /= b;
            }


            if (isPalindrome(sb.toString())) {
                result = 1;
                break;
            }
        }


        return result;

    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
