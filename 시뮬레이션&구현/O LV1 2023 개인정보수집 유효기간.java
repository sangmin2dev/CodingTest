// ArrayList 출력가능? ᄋㅇ

import java.util.*;

class Solution {
    public ArrayList solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> t = new HashMap<>(); //terms
        for(String e:terms){
            String[] tmp = e.split(" ");
            t.put(tmp[0], Integer.parseInt(tmp[1])*28);
        }


        Integer[] p = new Integer[privacies.length];
        int idx = 0;
        for(String e:privacies){
            String[] tmp = e.split(" ");
            String[] tmp2 = tmp[0].split("\\.");


            int x
                    = Integer.parseInt(tmp2[0])*12*28 + Integer.parseInt(tmp2[1])*28 + Integer.parseInt(tmp2[2])
                    + t.get(tmp[1]);
            p[idx] = x;
            idx++;
        }

        String[] tod = today.split("\\.");
        int now
                = Integer.parseInt(tod[0])*12*28 + Integer.parseInt(tod[1])*28 + Integer.parseInt(tod[2]);

        idx = 1;
        for(int e:p){
            if(now >= e){
                answer.add(idx);
            }
            idx++;
        }

        return answer;
    }
}