package 완전탐색;

import java.util.ArrayList;

public class 수식_최대화 {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";

        solution(expression);
    }

    public static long solution(String expression) {
        long answer = 0;

        String op[][] = {{"+", "-", "*"}, {"+", "*", "-"}, {"-", "+", "*"},
                {"-", "*", "+"}, {"*", "-", "+"}, {"*", "+", "-"}};

        ArrayList<String> list = new ArrayList<String>();

        int start = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                list.add(expression.substring(start, i));
                list.add(expression.charAt(i) + ""); //String으로 변경
                start = i + 1;
            }
        }
        list.add(expression.substring(start));

        for (int i = 0; i < op.length; i++) {
            ArrayList<String> sub_list = new ArrayList<String>(list);
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < sub_list.size(); k++) {
                    if (op[i][j].equals(sub_list.get(k))) {
                        sub_list.set(k - 1, calculate(sub_list.get(k - 1), sub_list.get(k), sub_list.get(k + 1)));
                        sub_list.remove(k);
                        sub_list.remove(k);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(sub_list.get(0))));
        }

        return answer;
    }

    public static String calculate(String num1, String oper, String num2) {
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);

        if (oper.equals("+")) {
            return n1 + n2 + "";
        } else if (oper.equals("-")) {
            return n1 - n2 + "";
        } else {
            return n1 * n2 + "";
        }
    }
}
