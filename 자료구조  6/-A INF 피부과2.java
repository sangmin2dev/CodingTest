import java.util.*;
class Solution {
    public int solution(int[] laser, String[] enter){
        int answer = Integer.MIN_VALUE;

        ArrayList<int[]> e = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int n = enter.length;

        for(String x:enter){
            String[] tmp = x.split(" ");
            int start = Integer.parseInt(tmp[0].split(":")[0])*60 + Integer.parseInt(tmp[0].split(":")[1]);
            int duration = laser[Integer.parseInt(tmp[1])];
            e.add(new int[]{start, duration});
        }

        int fin = e.get(0)[0] + e.get(0)[1];
        int idx = 1;
        for(int i=e.get(0)[0]; i<1201; i++){

            if(idx >= n) break;
            if(i == e.get(idx)[0]){
                if(q.isEmpty() && i > fin) fin = i + e.get(idx)[1];
                else q.add(e.get(idx)[1]);
                idx++;
            }
            if(i == fin && !q.isEmpty()){
                fin += q.poll();
            }
            answer = Math.max(answer, q.size());
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}