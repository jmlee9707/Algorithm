package Programmers;

import java.util.*;

public class Solution_92341 {

    // 프로그래머스
    // 주차요금 계산
    // 2022 kakao blind 문제
    public static void main(String[] args) {
        int[] fees = { 120, 0, 60, 591 };
        String[] records = { "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN" };
        Solution1 sol = new Solution1();
        int[] res = sol.solution(fees, records);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}

class Solution1 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        int basicTime = fees[0]; // 기본 시간
        int basicFee = fees[1]; // 기본 요금
        int unitTime = fees[2]; // 단위 시간
        int unitFee = fees[3]; // 단위 요금

        // 시간 저장 -> 시간*60 + 분
        // 출차 기록이 없을 경우 23:59분에 출차 되었다고 간주
        int maxTime = 23 * 60 + 59;

        HashMap<String, Integer> inTime = new HashMap<>();
        HashMap<String, Integer> carFees = new HashMap<>();
        List<String> cars = new ArrayList<>(); // 차들 목록

        for (int i = 0; i < records.length; i++) {
            String str = records[i];

            int time = (Integer.parseInt(str.substring(0, 2))) * 60 + (Integer.parseInt(str.substring(3, 5)));

            String num = str.substring(6, 10);
            Character status = str.charAt(11);

            if (status == 'I') {
                // 처음 들어오는 차일 경우
                if (!carFees.containsKey(num)) {
                    carFees.put(num, 0);
                    inTime.put(num, time);
                    cars.add(num);
                }
                // 이미 들어와있던 차일 경우
                else {
                    inTime.put(num, time);
                }
            }
            // 출차의 경우
            else {
                // 누적 시간 계산
                carFees.put(num, carFees.get(num) + (time - inTime.get(num)));
                System.out.println(carFees.get(num));
                inTime.remove(num); // 주차장에 있는 차 목록에서 제외
            }
        }

        // 요금 계산
        for (int i = 0; i < cars.size(); i++) {
            String carN = cars.get(i);

            // 아직 출차하지 않았을 경우
            if (inTime.containsKey(carN)) {
                carFees.put(carN, (maxTime - inTime.get(carN)) + carFees.get(carN));
            }

            // 요즘 계산하기
            int time = carFees.get(carN);
            if (time > basicTime) {
                int fee = 0;
                if ((time - basicTime) % unitTime != 0) {
                    fee = basicFee + (((time - basicTime) / unitTime) + 1) * unitFee;
                } else
                    fee = basicFee + ((time - basicTime) / unitTime) * unitFee;
                carFees.put(carN, fee); // 요금 계산하여 납부
            } else {
                carFees.put(carN, basicFee); // 기본 요금만 납부
            }
        }

        // key값을 기준으로 정렬
        List<String> keySet = new ArrayList<>(carFees.keySet());
        Collections.sort(keySet);

        int size = keySet.size();
        answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[i] = carFees.get(keySet.get(i));
        }
        return answer;
    }
}