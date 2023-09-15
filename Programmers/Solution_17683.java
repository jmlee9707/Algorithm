package Programmers;

import java.util.*;

public class Solution_17683 {
    /*
     * 프로그래머스
     * 2018 kakao blind recruitment
     * [3차] 방금그곡
     */

    static ArrayList<Music> list;

    static class Music implements Comparable<Music> {
        String name;
        int time;
        int n;

        public Music(String name, int time, int n) {
            this.name = name;
            this.time = time;
            this.n = n;
        }

        @Override
        public int compareTo(Music m) {
            if (m.time == this.time) {
                return this.n - m.n;
            } else
                return m.time - this.time;
        }
    }

    public String solution(String m, String[] musicinfos) {

        list = new ArrayList<>();
        m = changeAlpa(m);

        // musicinfo 가공
        for (int i = 0; i < musicinfos.length; i++) {

            String[] info = musicinfos[i].split(",");
            String name = info[2];
            String melody = changeAlpa(info[3]);

            int t = calcTime(info[0], info[1]); // 음악 시작, 끝 시간
            melody = makeMelody(melody, t); // 실제 멜로디

            if (melody.contains(m))
                list.add(new Music(name, t, i));
        }

        Collections.sort(list);

        if (list.size() == 0)
            return "(None)";
        else
            return list.get(0).name;
    }

    public String changeAlpa(String mu) {
        // 음을 바꾸기

        mu = mu.replace("C#", "Z");
        mu = mu.replace("D#", "M");
        mu = mu.replace("F#", "N");
        mu = mu.replace("G#", "X");
        mu = mu.replace("A#", "R");
        return mu;
    }

    public String makeMelody(String melo, int t) {

        // 음악의 재생시간 보다 멜로디가 더 길 때
        if (t < melo.length()) {
            return melo.substring(0, t);
        }

        // 음악 재생시간 = 멜로디
        if (t == melo.length())
            return melo;

        // 음악의 재생시간이 멜로디 보다 길떄
        int rep = t / melo.length();
        String temp = melo;
        for (int i = 2; i <= rep; i++) {
            temp += melo;
        }
        temp += melo.substring(0, t % melo.length());
        return temp;
    }

    public int calcTime(String start, String end) {
        int t = 0;

        String[] temp = end.split(":");
        t = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);

        temp = start.split(":");
        t = t - (Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]));

        return t;
    }
}