package 큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(solution(progresses, speeds));


    }
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i< progresses.length;i++){
            if((100 - progresses[i]) % speeds[i] == 0 ){
                que.add((100 - progresses[i]) / speeds[i]);
            }else{
                que.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        int x = que.poll();
        int count = 1;

        while(!que.isEmpty()){
            if(x >= que.peek()){
                count++;
                que.poll();
            }else{
                list.add(count);
                count = 1;
                que.poll();
            }
        }
        list.add(count);

        //코드 int[]가 성능상으로 더 빠르다. return 값을 ArrayList -> int[]로 변경하는 법
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }
}
