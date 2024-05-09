package 해시;


import java.util.ArrayList;
import java.util.List;

public class 완주하지_못한_선수_Q {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion){
        String answer = "";
        List<String> list = new ArrayList<>();
        for (String s : participant) {
            list.add(s);
        }

        List<String> list2 = new ArrayList<>();
        for (String s : completion) {
            list2.add(s);
        }

        for(int i = 0 ; i< list2.size();i++){
            for(int j = 0 ; j < list.size() ; j++){
                if(list2.get(i).equals(list.get(j))){
                    list.remove(j);
                }
            }
        }

        return list.get(0);
    }
}
