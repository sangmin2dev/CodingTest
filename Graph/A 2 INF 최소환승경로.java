import java.util.*;
class Solution {
    public int solution(int[][] routes, int s, int e){
        int answer = 0;

        ArrayList<Integer>[] r = new ArrayList[1000001];
        int[] check = new int[1000001];
//        int[][] r = new int[1000001][1000001];

        for(int i=0; i<routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                r[routes[i][j]] = new ArrayList<>();
            }
        }

        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[i].length; j++){
                for(int k=j+1; k<routes[i].length; k++){
                    r[routes[i][j]].add(routes[i][k]);
                    r[routes[i][k]].add(routes[i][j]);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        check[s] = 1;
        while(!q.isEmpty()){

            int sz = q.size();
            for(int i=0; i<sz; i++){
                int now = q.poll();

                if(now == e) return answer-1;
                for(int j=0; j<r[now].size(); j++){
                    if(check[r[now].get(j)] == 0) {
                        q.add(r[now].get(j));
                        check[r[now].get(j)] = 1;
                    }
                }
            }
            answer+=1;
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