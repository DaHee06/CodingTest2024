package 기타;

import java.util.ArrayList;
import java.util.List;

public class 스킬트리 {
    public static void main(String[] args) {
        String[] skill_trees= {"BACDE", "CBADF", "AECB", "BDA"};
        String skill = "CBD";

        System.out.println(solution(skill, skill_trees));

    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        char[] charArray = skill.toCharArray();

        for (String skillTree : skill_trees) {
            List<Character> list = new ArrayList<>();

            for (char skillChar : skillTree.toCharArray()) {
                for (char c : charArray) {
                    if (skillChar == c) {
                        list.add(skillChar);
                        break;
                    }
                }
            }

            boolean isValid = true;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != charArray[i]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                answer++;
            }
        }


        return answer;
    }
}
