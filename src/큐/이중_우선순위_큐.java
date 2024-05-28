package 큐;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중_우선순위_큐 {
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        System.out.println(solution(operations));

    }

    public static int[] solution(String[] operations) {
        int[] answer = {0,0};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String s : operations) {
            String[] temp = s.split(" ");
            String com = temp[0];
            int value = Integer.parseInt(temp[1]);
            switch (com){
                case "I" :
                    minHeap.add(value);
                    maxHeap.add(value);
                    break;
                case "D" :
                    if(minHeap.size() > 0){
                        if(value == 1) {
                            int max = maxHeap.poll();
                            minHeap.remove(max);
                        }else{
                            int min = minHeap.poll();
                            maxHeap.remove(min);
                        }
                    }
                    break;
            }
        }

        if(minHeap.size() > 0){
            answer[0] = maxHeap.peek();
            answer[1] = minHeap.peek();
        }


        return answer;
    }
}
