// 2차원 배열 초기화
// for(int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);

// PriorityQueue 사용해 벽허무는 경우의수중 최저만 갱신해서 조사

import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int[][] ch = new int[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                ch[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((e1,e2) -> e1[2] - e2[2]);

        ch[0][0] = 0;
        q.add(new int[]{0,0,0});

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz; i++){
                int[] now = q.poll();

                for(int j=0; j<4; j++){
                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];

                    if(nr<0 || nr>=board.length || nc <0 || nc>=board[0].length) continue;
                    else if(nr == board.length-1 && nc == board[0].length-1){
                        answer = Math.min(answer, now[2]);
                    }
                    else if(board[nr][nc] == 1 && ch[nr][nc] > now[2]+1) {
                        ch[nr][nc] = now[2] + 1;
                        q.add(new int[]{nr, nc, now[2]+1});
                    }
                    else if(board[nr][nc] == 0 && ch[nr][nc] > now[2]) {

                        ch[nr][nc] = now[2];
                        q.add(new int[]{nr, nc, now[2]});
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}