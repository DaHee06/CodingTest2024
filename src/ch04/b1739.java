package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        // 붙여서 써야 바로 입력값 받음

        char[][] board = new char[n][n];

        for(int i =0 ; i< n;i++){
            for(int j=0; j< n ; j++){
                board[i][j] = '.';
            }
        }

        int x = 0;
        int y = 0;

        for(int i = 0 ; i < str.length(); i++){
            char c = str.charAt(i);

            switch (c){
                case 'D' :
                    if(x != n-1){
                        if(board[x][y] == '.'){
                            board[x][y] = '|';
                        }else if(board[x][y] == '-'){
                            board[x][y] = '+';
                        }
                        x++;
                        if(board[x][y] == '.'){
                            board[x][y] = '|';
                        }else if(board[x][y] == '-'){
                            board[x][y] = '+';
                        }
                    }
                    break;
                case 'U' :
                    if(x != 0){
                        if(board[x][y] == '.'){
                            board[x][y] = '|';
                        }else if(board[x][y] == '-'){
                            board[x][y] = '+';
                        }
                        x--;
                        if(board[x][y] == '.'){
                            board[x][y] = '|';
                        }else if(board[x][y] == '-'){
                            board[x][y] = '+';
                        }
                    }
                    break;
                case 'R' :
                    if(y != n-1){
                        if(board[x][y] == '.'){
                            board[x][y] = '-';
                        }else if(board[x][y] == '|'){
                            board[x][y] = '+';
                        }
                        y++;
                        if(board[x][y] == '.'){
                            board[x][y] = '-';
                        }else if(board[x][y] == '|'){
                            board[x][y] = '+';
                        }
                    }
                    break;
                case 'L' :
                    if(y != 0){
                        if(board[x][y] == '.'){
                            board[x][y] = '-';
                        }else if(board[x][y] == '|'){
                            board[x][y] = '+';
                        }
                        y--;
                        if(board[x][y] == '.'){
                            board[x][y] = '-';
                        }else if(board[x][y] == '|'){
                            board[x][y] = '+';
                        }
                    }
                    break;
            }
        }
        for(int i = 0; i < n; i++) {            // 결과물 출력
            for(int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
