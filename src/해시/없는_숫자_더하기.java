package 해시;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 없는_숫자_더하기 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers){
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        for (int num : numbers) {
            set.add(num);
        }

        for(int i = 0 ; i < 10 ; i++){
            if(!set.contains(i)){
                answer += i;
            }
        }
        return answer;
    }
}
