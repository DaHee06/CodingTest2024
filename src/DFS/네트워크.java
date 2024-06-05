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

        boolean[] check = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if(!check[i]){
                dfs(computers, i, check);
                answer++;
            }
        }


        return answer;
    }

    public static boolean[] dfs(int[][] computers, int i, boolean[] check) {
        check[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && check[j] == false) {
                check = dfs(computers, j, check);
            }
        }
        return check;
    }
}
