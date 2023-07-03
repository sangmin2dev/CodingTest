//삭제보단 자료형에 옮겨담기를

import java.util.*;

class Main{


    public static String sol(String[] votes, long k){
        String ans = "";

        HashMap<String, Integer> candi = new HashMap<>();
        HashMap<String, Integer> voter = new HashMap<>();

        for(String x:votes){
            String c = x.split(" ")[1];

            candi.put(c, candi.getOrDefault(c, 0)+1);
        }

        Set<String> candik = new HashSet<>();
        for(String c:candi.keySet()){
            if(candi.get(c) >= k) {
                candik.add(c);
            }
        }

        for(String x:votes){
            String c = x.split(" ")[1];
            String v = x.split(" ")[0];

            if(candik.contains(c)){
                   voter.put(v, voter.getOrDefault(v,0)+1);
            }
        }

        List<String> ent = new LinkedList<>(voter.keySet());
        ent.sort((e1, e2) -> {
                    if (voter.get(e1) == voter.get(e2)) return e1.compareTo(e2);
                    else return voter.get(e2) - voter.get(e1);
                }
        );



        return ent.get(0);
    }

    public static void main(String[] args){

        String[] votes = {"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"};
        long k = 2;

        System.out.print(sol(votes, k));

    }
}