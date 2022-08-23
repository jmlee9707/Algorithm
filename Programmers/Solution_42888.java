package Programmers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Solution_42888
 */
public class Solution_42888 {

    // 2019 kakao blind
    // 오픈채팅방
    // 닉네임을 변경하는 2가지 방법
    // 1. 채팅방을 나간 후 새로운 닉네임으로 다시 들어오기
    // 2. 채팅방에서 닉네임 변경하기

    // 단 닉네임 변경 시에는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경 됨
    // 중복 닉네임을 허용

    // 채팅방에 들어오고 나가거나 닉네임을 변경한 기록이 담긴 문자열 배열 ->
    // 모든 기록이 처리된 후 최종적으로 방을 개설한 사람이 보게되는 메시지를 문자열 배열 형태로 리턴
    static String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
            "Change uid4567 Ryan" }; // 기록
    static String[][] temp;
    static String[] answer;

    public static void main(String[] args) throws IOException {
        // answer = new String[record.length];
        // 첫단어는 Enter, Leave, Change
        // 각 단어는 공백으로 구분
        // 유저 아이디와 닉네임의 길이는 1이상 10 이하
        int count = 0;
        temp = new String[record.length][3];

        for (int t = 0; t < record.length; t++) {
            String txt = record[t];
            StringTokenizer st = new StringTokenizer(txt, " "); // 공백으로 구분
            String action = st.nextToken(); // 첫 단어
            String userId = st.nextToken(); // 사용자 아이디
            // String nickname = ""; // 닉네임

            if (action.equals("Enter")) {
                // 다시 나갔다 들어온 사람인가 확인
                String nickname = st.nextToken();
                boolean isNew = check(userId, nickname, count);
                if (!isNew) {
                    changeName(userId, nickname, count); // 닉네임변경
                }
                temp[count][0] = nickname;
                temp[count][1] = "님이 들어왔습니다.";
                temp[count][2] = userId;
                count++;

            } else if (action.equals("Leave")) {
                String nickname = findNick(userId, count);
                temp[count][0] = nickname;
                temp[count][1] = "님이 나갔습니다.";
                temp[count][2] = userId;
                count++;
            } else if (action.equals("Change")) {
                // 채팅방에서 이름을 변경하는 경우
                String newName = st.nextToken();
                changeName(userId, newName, count);
            }
        }

        answer = new String[count];

        for (int i = 0; i < count; i++) {
            answer[i] = temp[i][0] + temp[i][1]; // 배열 복사
            System.out.println(answer[i]);
        }

    }

    public static boolean check(String id, String nick, int num) {
        for (int i = 0; i < num; i++) {
            if (temp[i][2].equals(id) && !temp[i][0].equals(nick)) {
                return false;
            }
        }
        return true;
    }

    public static String findNick(String id, int num) {
        // 닉네임 찾기
        String res = "";
        for (int i = 0; i < num; i++) {
            if (temp[i][2].equals(id)) {
                res = temp[i][0];
                break;
            }
        }
        return res;
    }

    public static void changeName(String id, String nick, int num) {
        // 닉네임 변경
        for (int i = 0; i < num; i++) {
            if (temp[i][2].equals(id)) {
                temp[i][0] = nick;
            }
        }
        return;
    }
}