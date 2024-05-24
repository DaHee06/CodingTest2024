package 동적프로그래밍;

public class 정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle){
        int answer = 0;
        int height = triangle.length; //1~5

        int[][] sum = new int[height+1][height+1];
        sum[0][0] = triangle[0][0];

        //모든 왼쪽 배열의 합
        for(int i = 1 ; i < triangle.length ; i++){
            sum[i][0] = sum[i-1][0] + triangle[i][0];
        }

        for(int i = 1;i< triangle.length; i++){
            for(int j = 1; j < triangle[i].length; j++) {
                // 왼쪽 위에서 내려와 더했을 때, 오른쪽 위에서 내려와 더했을 때 중 최대값 저장
                sum[i][j] = Math.max(sum[i-1][j-1] + triangle[i][j], sum[i-1][j] + triangle[i][j]);
            }
        }

        for(int i = 0; i< triangle[height-1].length;i++){
            answer = Math.max(sum[height-1][i], answer);
        }

        return answer;
    }
}
