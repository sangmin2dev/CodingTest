// 기사랑 영희로만 루프 도는게 더 효율적임

import java.util.*;
class Solution {
    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;

        int r = board.length;
        int c = board[0].length;

        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};


        Queue<int[]> q = new LinkedList<>(); // 큐 (r, c, w)
        HashMap<Integer, int[]> w = new HashMap<>(); // 각 산딸기당 w
        int[][] ch;

        int widx = -1;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){

                if(board[i][j] == 4) {
                    widx+=1;
                    w.put(widx, new int[]{0,0});
                    q.add(new int[]{i,j,0});

                    int D = 0;
                    ch = new int[r][c];
                    while(!q.isEmpty()){

                        D+=1;
                        int sz = q.size();
                        for(int k=0; k<sz; k++){

                            int[] now = q.poll();
                            for(int l=0; l<4; l++){
                                int nr = now[0] + dr[l];
                                int nc = now[1] + dc[l];

                                if(w.getOrDefault(widx, new int[]{0,0})[0] != 0 && w.getOrDefault(widx, new int[]{0,0})[1] != 0) break;

                                if(nr<0 || nr>=r || nc<0 || nc >=c) continue;
                                else if(board[nr][nc] == 1) continue;
                                else if(board[nr][nc] == 2 && ch[nr][nc] == 0){
                                    int[] tmp = w.getOrDefault(widx, new int[]{0,0});
                                    tmp[0] += D;
                                    w.put(widx, tmp);
                                    ch[nr][nc] = 1;
                                    q.add(new int[]{nr, nc, D});
                                }else if(board[nr][nc] == 3 && ch[nr][nc] == 0){
                                    int[] tmp = w.getOrDefault(widx, new int[]{0,0});
                                    tmp[1] += D;
                                    w.put(widx, tmp);
                                    ch[nr][nc] = 1;
                                    q.add(new int[]{nr, nc, D});
                                }else if(ch[nr][nc] == 0){
                                    ch[nr][nc] = 1;
                                    q.add(new int[]{nr, nc, D});
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int x: w.keySet()){
            int tmp = w.get(x)[0] + w.get(x)[1];
            answer = Math.min(tmp, answer);
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}