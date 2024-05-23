package 그래프;

/**
 * 등록할 수 있는 정보는 다 등록하자.
 * 1. 2차 배열로 승부표 작성
 * 2. A>B이고 B>C라면 A>C이다
 * 이때 졌을 경우도 확인해야함 -> ??추가 확인
 * 3. 총 4개를 알면 나머지 승부결과를 알 수 있다.
 */
public class 순위 {
    public static void main(String[] args) {
        int n = 5;
        int[][] result = {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        };

        System.out.println(solution(n, result));
    }

    static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < results.length; i++) {
            int A = results[i][0];
            int B = results[i][1];

            arr[A][B] = 1;
            arr[B][A] = -1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (arr[i][j] == 1 && arr[j][k] == 1) {
                        arr[i][k] = 1;
                        arr[k][i] = -1;
                    }
                    //왜 진 경우도 고려해야 하는가
                    else if (arr[i][j] == -1 && arr[j][k] == -1) {
                        arr[i][k] = -1;
                        arr[k][i] = 1;
                    }
                }
            }
        }

        //배열 선수의 번호로 확인해야하기 때문에 for문에서 int -> 1부터 시작한다.
        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (arr[i][j] != 0) cnt++;

            }
            if (cnt == n - 1) answer++;
            cnt = 0;
        }


        return answer;
    }
}
