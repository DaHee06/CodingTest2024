package 스택;

import java.util.ArrayList;
import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        String s = "[](){}";

        System.out.println(solution(s));
    }

    public static int solution(String s){
        int answer = 0;

        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i< s.length(); i++){
            list.add(s.charAt(i));
        }
        for(int i = 0; i<list.size();i++) {
            if (checkBlank(list)) answer++;
            list.add(list.remove(0));
            //list.add 후 인덱스 변함
//            list.add(list.get(i));
//            list.remove(i);
        }
        return answer;
    }

    public static boolean checkBlank(ArrayList<Character> list){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<list.size();i++){
            char c = list.get(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.size() == 0){
                    return false;
                }char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        if(stack.size() != 0)return false;

        return true;

    }
}
