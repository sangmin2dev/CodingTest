import java.util.*;
class Solution {
    public int solution(int[][] board){
        int answer = 0;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int[][] ch = new int[7][7];
        int D = 0;

        while(!q.isEmpty()){

            int sz = q.size();
            for(int i=0; i<sz; i++){
                int[] now = q.poll();

                for(int j=0; j<4; j++){
                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];

                    if(nr < 0  || nr >= 7 || nc < 0 || nc >= 7) continue;
                    else if(board[nr][nc] == 1 || ch[nr][nc] == 1) continue;
                    else if(nr == 6 && nc == 6) return D+1;
                    else{
                        ch[nr][nc] = 1;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            D+=1;
        }

        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr= {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));


        int[][] arr2= {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}};
        System.out.println(T.solution(arr2));
    }
}