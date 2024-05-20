package 스택;

import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(solution(s));
    }

    public static boolean solution(String s){
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.size() != 0)return false;

        return answer;
    }
}
