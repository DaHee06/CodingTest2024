package 투포인터;

import java.util.HashMap;
import java.util.HashSet;

public class 보석_쇼핑 {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}; // [3,7]
//        String[] gems = {"AA", "AB", "AC", "AA", "AC"}; // [1,3]

        System.out.println(solution(gems));
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }

        HashMap<String, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0 ;
        int diff=Integer.MAX_VALUE;
        int startIndex = 0;
        int endIndex = 0;

        while(true){
            if(set.size() == map.size()){
                map.put(gems[left], map.get(gems[left])-1);

                if(map.get(gems[left]) == 0){
                    map.remove(gems[left]);
                }
                left++;

            }else if(right == gems.length) break;
            else{
                map.put(gems[right], map.getOrDefault(gems[right],0) + 1);
                right++;
            }

            if(set.size() == map.size()){
                if((right - 1) - left < diff){
                    startIndex = left;
                    endIndex = right - 1;
                    diff = (right - 1) - left;
                }
            }
        }

        answer[0]=startIndex+1;
        answer[1]=endIndex+1;

        return answer;
    }

}
