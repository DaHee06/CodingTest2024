package 완전탐색;

public class 카펫 {

    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;

        int[] result = solution(brown, yellow);
        System.out.println("Width: " + result[0] + ", Height: " + result[1]);
    }

    public static int[] solution(int brown, int yellow){
        int[] answer = new int[2];

        int carpet = brown + yellow;

        for(int i = 3;i<=carpet;i++){
            int w = i;
            int h = carpet/w;

            if(w >=3 && h>=3) {
                int bow = 2 * (w + h - 2);
                int cen = w * h - bow;

                if (brown == bow && yellow == cen){
                    answer[0] = w;
                    answer[1] = h;
                }
            }
        }

        return answer;
    }
}
