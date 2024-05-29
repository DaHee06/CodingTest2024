package 큐;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {
                {0, 3},
                {1, 9},
                {2, 6}
        };

        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {

        //시작시간
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);

        //작업시간
        PriorityQueue<int[]> tq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int index = 0;
        int total = 0;
        int time = 0;
        int count = 0;

        while(count < jobs.length){
            while(index < jobs.length && jobs[index][0] <= time){
                tq.add(jobs[index++]);
            }

            if(tq.isEmpty()){
                time = jobs[index][0];
            }else{
                int cur[] = tq.poll();
                total += time + cur[1] - cur[0];
                time += cur[1];
                count++;
            }
        }

        return total / jobs.length;
    }
}
