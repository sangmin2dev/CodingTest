// 해쉬맵 어레이리스트

import java.util.*;

class Node{

    String r;
    ArrayList<String> leaf;

    public Node(String r, ArrayList<String> leaf){
        this.r = r;
        this.leaf = new ArrayList<>();
        for(String x : leaf){
            this.leaf.add(x);
        }
    }

}
class Solution {
    public String[] solution(String[] subjects, String[] course){
        String[] answer = {};

        HashMap<String, ArrayList<String>> g = new HashMap<>();

        for(String x : course){
            String[] c = x.split(" ");
            ArrayList<String> tmp = g.getOrDefault(c[0], new ArrayList<>());
            tmp.add(c[1]);
            g.put(c[0], tmp);
        }

        for(String r : g.keySet()){
            for(String r2 : g.keySet()){
                
            }
        }




        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        //System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})[0]);
        //System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}

art - math, music
physical - art, math
english - physical