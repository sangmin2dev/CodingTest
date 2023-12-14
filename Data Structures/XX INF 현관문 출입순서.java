import java.util.*;
class Solution {
    public int[] solution(int[] arrival, int[] state){
        int[] answer = new int[arrival.length];
        ArrayList<Integer> ans = new ArrayList<>();

        int flag = 1;
        // idx, arrival time
        PriorityQueue<int[]> q = new PriorityQueue<>((e1, e2) -> {
            if(e1[1] == e2[1]) return e1[0] - e2[0];
            else return flag*(e1[1] - e2[1]);
        });


        HashMap<Integer, ArrayList<int[]>> hm = new HashMap<>();

        for(int i=0; i<arrival.length; i++){
            ArrayList<int[]> tmp = hm.getOrDefault(arrival[i], new ArrayList<int[]>());
            tmp.add(new int[]{i, state[i]});
        }


        for(int k : hm.keySet()){

            for(int[] x : hm.get(k)){
                q.add(x);
            }

        }



        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}