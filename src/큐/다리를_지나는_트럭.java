package 큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weight = {7,4,5,6}; //8

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weight = {10}; //101

        System.out.println(solution(bridge_length, weight, truck_weight));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int bridge_weight = 0;
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0 ; i < truck_weights.length ; i++){
            while(true){
                if(que.isEmpty()){
                    que.add(truck_weights[i]);
                    bridge_weight += truck_weights[i];
                    answer++;
                    break;
                }else if(bridge_length == que.size()){
                    bridge_weight -= que.poll();
                }else{
                    if(truck_weights[i] + bridge_weight > weight){
                        que.add(0);
                        answer++;
                    }else{
                        que.add(truck_weights[i]);
                        bridge_weight += truck_weights[i];
                        answer++;
                        break;
                    }
                }
            }
        }
        answer += bridge_length;
            return answer;
    }
}
