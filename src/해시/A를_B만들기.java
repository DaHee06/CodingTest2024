package 해시;

import java.util.Arrays;

public class A를_B만들기 {
    public static void main(String[] args) {
        System.out.println(solution("olleh","hello"));
    }

    public static int solution(String before, String after){
        char[] arr1 = before.toCharArray();
        char[] arr2 = after.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int answer = Arrays.equals(arr1, arr2) ? 1 : 0;

        return answer;
    }
}
