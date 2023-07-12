// 이중for문 + BFS 가능
// emptySpace 갈수있는 스페이스 줄이기. 반복문을 돌면서 갈수있는 곳 한정짓고, 즉, 반복문을 돌면서 구체화됨
// answer 초기화. 마지막 반복문에서 갈수 있는 곳은 한정되어 있고, 갈수있는 곳중 가장 짧은곳으로 min 초기화


import java.util.*;
class Solution {
    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int n = board.length;

        Queue<int[]> q = new LinkedList<>();
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};


        int[][] ans = new int[n][n];
        int ep = 0; //empty place

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    answer = Integer.MAX_VALUE;
                    q.add(new int[]{i,j});

                    int D = 0;
                    while(!q.isEmpty()){

                        int sz = q.size();
                        D+=1;
                        for(int k=0; k<sz; k++){
                            int[] step = q.poll();

                            for(int l=0; l<4; l++){

                                int nr=  step[0] + dr[l];
                                int nc = step[1] + dc[l];

                                if(nr < 0 || nr >= board.length || nc < 0 || nc >= board.length) continue;
                                else if(board[nr][nc] != ep) continue;

                                ans[nr][nc] += D;
                                board[nr][nc] -= 1;
                                q.add(new int[]{nr, nc});
                                answer = Math.min(answer, ans[nr][nc]);
                            }
                        }
                    }

                    ep -=1;
                }
            }
        }


        answer = (answer>n*n+1) ? -1 : answer;

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}