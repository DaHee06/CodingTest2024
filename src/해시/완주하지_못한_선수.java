package 해시;

import java.util.Arrays;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));
    }


    public static String solution(String[] participant, String[] completion){
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        for( i = 0; i< completion.length;i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }

        return participant[i];
    }
}
