package 해시;

import java.util.HashSet;

public class 평행 {
    public static void main(String[] args) {
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};

        System.out.println(solution(dots));
    }

    public static int solution(int[][] dots) {
        int answer = 0;

        //제시된 배열 수가 적으므로 배열 경우의 수를 직접 작성
        int x1 = dots[0][0];
        int x2 = dots[1][0];
        int x3 = dots[2][0];
        int x4 = dots[3][0];

        int y1 = dots[0][1];
        int y2 = dots[1][1];
        int y3 = dots[2][1];
        int y4 = dots[3][1];

        //CASE 3가지 경우의 수
        double slope1 = (double) (x1-x2) / (y1-y2);
        double slope2 = (double) (x3-x4) / (y3-y4);
        if(slope1 == slope2) return answer = 1;

        slope1 = (double) (x1-x3) / (y1-y3);
        slope2 = (double) (x2-x4) / (y2-y4);
        if(slope1 == slope2) return answer = 1;

        slope1 = (double)(x1-x4) / (y1-y4);
        slope2 = (double)(x2-x3) / (y2-y3);
        if(slope1 == slope2) return answer = 1;

        return answer;


        //for문으로 경우의 수를 만들기
        //slope에 대한 list를 담고 해당 값이 있다면 return = 1; break; -> 1만 나오면 끝남

//        HashSet<Double> set = new HashSet<>();
//
//        for(int i = 0 ; i < dots.length-1;i++){
//            for(int j = i+1 ; j < dots.length;j++){
//                double x = dots[i][0] - dots[j][0];
//                double y = dots[i][1] - dots[j][1];
//
//                double slope = x/y;
//                if(!set.contains(slope)){
//                    set.add(slope);
//                }else{
//                    answer = 1;
//                    break;
//                }
//            }
//            if(answer == 1){
//                break;
//            }
//        }
//
//        return answer;
    }
}
