package 카카오블라인드;

import java.util.*;

public class 주차_요금_계산 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600}; //기본시간 , 기본요금 , 단위시간, 단위요금
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        //차량 번호 Map에 담는 메소드
        Map<String, ArrayList<String>> map = splitRecords(records);

        HashMap<String, Integer> resultMap = new HashMap<>();

        for (String key : map.keySet()) {
            ArrayList<String> list = map.get(key);

            if(list.size() % 2 != 0){
                list.add("23:59");
            }
            ArrayList<Integer> timeList = new ArrayList<>();
            for (String time : list) {
                int t = convertmin(time); //result에 계산하기
                timeList.add(t);
            }
            int sum = 0;
            for (int i = 1; i < timeList.size(); i += 2) {
                int difference = timeList.get(i) - timeList.get(i - 1);
                sum += difference;
            }

            int fee = caltime(fees, sum);
            resultMap.put(key, fee);

        }
        answer = getSortedValues(resultMap);

        return answer;
    }

    public static Map<String, ArrayList<String>> splitRecords(String[] records) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < records.length; i++) {

            String[] parts = records[i].split(" ");
            String time = parts[0];
            String carNumber = parts[1];

            if (!map.containsKey(carNumber)) {
                map.put(carNumber, new ArrayList<>());
            }
            map.get(carNumber).add(time);
        }
        return map;
    }

    public static int convertmin(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    public static int caltime(int[] fees, int t) { //기본시간 , 기본요금 , 단위시간, 단위요금
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (t <= basicTime) return basicFee;
        else {
            return basicFee + (int) Math.ceil((double) (t - basicTime) / unitTime) * unitFee;
        }

    }

    public static int[] getSortedValues(Map<String, Integer> map) {
        // TreeMap으로 변환하여 키를 오름차순으로 정렬
        Map<String, Integer> sortedMap = new TreeMap<>(map);

        // 정렬된 값들을 배열에 담기
        int[] answer = new int[sortedMap.size()];
        int index = 0;
        for (int value : sortedMap.values()) {
            answer[index++] = value;
        }

        return answer;
    }
}
