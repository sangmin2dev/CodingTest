// n, m일때는 length로 하지말고 항상 초기화하고 시작하기. 실수방지

import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

         int[][][] ch = new int[board.length][board[0].length][2];

         for(int i=0; i<board.length; i++){
             for(int j=0; j<board[0].length; j++){
                 Arrays.fill(ch[i][j], Integer.MAX_VALUE);
             }
         }

         PriorityQueue<int[]> q = new PriorityQueue<>((e1, e2) -> {
             return e1[2] - e2[2];
         });
         q.add(new int[]{0,0,0});
         ch[0][0][0] = 1;

         int[] dr = {0, 0, 1, -1};
         int[] dc = {1, -1, 0, 0};

         while(!q.isEmpty()){

             int[] now = q.poll();

             for(int i=0; i<4; i++){
                 int nr = now[0] + dr[i];
                 int nc = now[1] + dc[i];


                 if(nr< 0 || nr >= board.length || nc< 0 || nc >= board[0].length) continue;
                 else if(board[now[0]][now[1]]-1 == i && ch[nr][nc][0] != 1) {
                     q.add(new int[]{nr, nc, now[2]});
                     ch[nr][nc][0] = 1;

                     if(nr == board.length-1 && nc == board[0].length-1) answer = Math.min(answer, now[2]);
                 }
                 else if(board[now[0]][now[1]]-1 != i && ch[nr][nc][1] >= now[2]+1){
                     q.add(new int[]{nr, nc, now[2]+1});
                     ch[nr][nc][1] = now[2]+1;

                     if(nr == board.length-1 && nc == board[0].length-1) answer = Math.min(answer, now[2]+1);
                 }
             }
         }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
