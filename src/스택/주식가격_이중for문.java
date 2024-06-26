package 스택;

public class 주식가격_이중for문 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(solution(prices));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++; // 뒤에 있는 값들 보다 작거나 같을 때 인덱스 값 하나씩 추가
                if (prices[i] > prices[j]) { // 크면 다음 인데스 비교
                    break;
                }
            }
        }
        return answer;
    }
}
