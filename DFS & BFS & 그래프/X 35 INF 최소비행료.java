import java.util.*;

class Solution {



    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;

        ArrayList<int[]>[] f = new ArrayList[flights.length];
        int[][] check = new int[k+1][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            f[i] = new ArrayList<>();
        }

        for(int[] x : flights){
            f[x[0]].add(new int[]{x[1], x[2]});
            if(x[0] == s){
                q.add(new int[]{x[0], x[1], x[2]});
            }
        }
        for(int i=0; i<k+1; i++){
            for(int j=0; j<n; j++){
                check[i][j]=10001;
            }
        }


        for(int i=0; i<=k; i++){
            int sz = q.size();
            for(int j=0; j<sz; j++){

                int[] tmp = q.poll();

                if(i == 0){
                    check[i][tmp[i]] = tmp[2];
                } else if(check[i][tmp[i]] == 0){
                    check[i][tmp[1]] = check[i-1][tmp[0]]+tmp[2];
                } else{
                    check[i][tmp[1]] = Math.min(check[i][tmp[1]], check[i-1][tmp[0]]+tmp[2]);
                }

                for(int l=0; l<f[tmp[1]].size(); l++){
                    q.add(new int[]{tmp[1], f[tmp[1]].get(l)[0], f[tmp[1]].get(l)[1]});
                }
            }
            if(i>0) check[i][e] = Math.min(check[i][e], check[i-1][e]);
        }

        return check[k][e];
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}