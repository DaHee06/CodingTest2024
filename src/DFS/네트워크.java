package DFS;

public class 네트워크 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println(solution(n, computers));

    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        for(int i = 0; i<computers.length;i++){
            for(int j = 0; j < computers.length ; j++){
                if(i != j){
                    if(computers[i][j] == 1) answer++;
                }
            }
        }
        return Math.round(answer/2);
    }
}
