// 최소 환승 경로 -> graph


import java.util.*;
class Solution {
    public int solution(int[][] routes, int s, int e){
        int answer = 0;

        HashMap<Integer,HashSet<Integer>> t = new HashMap<>();
        for(int i=0; i<routes.length; i++){
            for(int x : routes[i]){
                t.putIfAbsent(x, new HashSet<Integer>());
                t.get(x).add(i);
            }
        }

        int[] check = new int[routes.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        int L = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; i++){

                int now = q.poll();

                for(int line: t.get(now)){
                    if(check[line] == 1) continue;
                    check[line] = 1;
                    for(int stop:routes[line]){
                        if(stop == e) return L;
                        q.add(stop);
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}