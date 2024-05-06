package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사탕 게임
 * 1. 입력 값에 대한 이차배열 생성
 * 2. 문자 입력 받아 이차배열 채우기
 * 3. 행 기준으로 열 변경 후 Max 값 찾은 뒤 돌려놓기 , 열에서 가장 큰 출력값
 * 4. 열 기준으로 행 변경 후 Max 값 찾은 뒤 돌려놓기, 행에서 가장 큰 출력값
 * 5. 최대 값 출력
 *
 *
 */
public class b3058_R {
    static char board[][];
    static int N;
    static int Max;

    public static void main(String[] args) throws IOException {
        Max = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine(); //응답값 String만

            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(i);
            }
        }

        //행끼리 변경 - 열 j 가 다름
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) { //마지막 열은 바꾸는 것에 포함되지 않음
                change(i, j, i, j + 1);
                search();
                change(i, j + 1, i, j);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                change(i, j, i + 1, j);
                search();
                change(i + 1, j, i, j);
            }
        }

        System.out.println(Max);


    }

    public static void change(int i1, int j1, int i2, int j2) {
        char temp = board[i1][j1];
        board[i1][j1] = board[i2][j2];
        board[i2][j2] = temp;
    }

    public static void search() {
        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                    Max = Math.max(count, Max);
                } else {
                    count = 1;
                }
            }
        }

        //for문 진행하는 순서 -> 동일한 행에 열 변경, 가로 방향 탐색
//        for(int i = 0; i<N-1 ;i++){
//            int count = 1;
//
//            for(int j = 0; j<N ; j++){
//                if(board[i][j] == board[i+1][j]){
//                    count++;
//                    Max = Math.max(count, Max);
//                } else {
//                    count = 1;
//                }
//            }
//        }

        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    count++;
                    Max = Math.max(count, Max);
                } else {
                    count = 1;
                }
            }
        }
    }
}
