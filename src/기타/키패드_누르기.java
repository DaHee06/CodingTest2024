package 기타;

/**
 * 맨해튼
 */
public class 키패드_누르기 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
//        String answer = "";
        int left = 10;
        int right = 12;

        StringBuilder sb = new StringBuilder();

        for (int number : numbers) {
            if(number == 1 || number == 4 || number == 7){
                sb.append("L");
                left = number;
            }else if(number == 3 || number == 6 || number ==9){
                sb.append("R");
                right = number;
            }else{
                if(number == 0) number = 11; // 좌표방식이기 떄문에 0도 좌표 숫자로 넣어야함

                int leftdiff = Math.abs(number - left) / 3 + Math.abs(number - left) % 3 ;
                int rightdiff = Math.abs(number - right) / 3 + Math.abs(number - right) % 3 ;
                if(leftdiff < rightdiff) {
                    sb.append("L");
                    left = number;
                }
                else if(leftdiff > rightdiff) {
                    sb.append("R");
                    right = number;
                }
                else {
                    if(hand.equals("right")) {
                        sb.append("R");
                        right = number;
                    }
                    else {
                        sb.append("L");
                        left = number;
                    }
                }
            }
        }
        return sb.toString();
    }
}
