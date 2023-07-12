// n, m일때는 length로 하지말고 항상 초기화하고 시작하기. 실수방지
// 방향을 바꾸는 횟수가 제한되어 있지 않기 때문에 차원을 나누지 않아도 괜찮다. 항상 방향바꾼 횟수가 작은것이 옳다
// 항상 방향을 바꾼것이 작은것으로 초기화되기 때문에 최종 ch[n-1][m-1]이 답이다

import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        int n = board.length;
        int m = board[0].length;
        int[][] ch = new int[n][m];

        for(int i=0; i<n; i++){
            Arrays.fill(ch[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((e1, e2) -> {
            return e1[2] - e2[2];
        });
        q.add(new int[]{0,0,0});
        ch[0][0] = 0;

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        while(!q.isEmpty()){

            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];


                if(nr< 0 || nr >= n || nc< 0 || nc >= m) continue;
                else if(board[now[0]][now[1]]-1 == i && ch[nr][nc] > now[2]) {
                    q.add(new int[]{nr, nc, now[2]});
                    ch[nr][nc] = now[2];
                }
                else if(board[now[0]][now[1]]-1 != i && ch[nr][nc] > now[2]+1){
                    q.add(new int[]{nr, nc, now[2]+1});
                    ch[nr][nc] = now[2]+1;
                }
            }
        }
        return ch[n-1][m-1];
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
