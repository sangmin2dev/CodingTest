import java.util.*;
class Solution {
    public int solution(int[][] board, int[] s, int[] e){
        int answer = Integer.MAX_VALUE;

        int r = board.length;
        int c = board[0].length;

        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};


        PriorityQueue<int[]> q = new PriorityQueue<>((e1, e2) -> {
            return e1[2] - e2[2];
        }); // (r, c, dist, dir)
        q.add(new int[]{s[0], s[1], 0, -1});
        int[][] ch = new int[r][c];
        ch[s[0]][s[1]] = 1;

        while(!q.isEmpty()){

            int sz = q.size();
            for(int i=0; i<sz; i++){

                int[] now = q.poll();
                for(int j=0; j<4; j++){

                    int tr = now[0];
                    int tc = now[1];
                    int dist = now[2];
                    int dir = now[3];

                    int term = 0;
                    if(dir == j) continue;
                    while(true){

                        int nr = tr + dr[j];
                        int nc = tc + dc[j];

                        if(e[0] == nr && e[1] == nc){
                            answer = Math.min(answer, dist+1);
                            break;
                        }

                        if(nr < 0 || nr >= r || nc < 0 || nc >= c){
                            if(term != 0) {
                                q.add(new int[]{tr, tc, dist + term, j});
                            }
                            break;
                        }else if(board[nr][nc] == 1){
                            if(term != 0) {
                                q.add(new int[]{tr, tc, dist + term, j});
                            }
                            break;
                        }else if(ch[nr][nc] == 0){
                            ch[nr][nc] = 1;
                            term+=1;
                            tr = nr;
                            tc = nc;
                        }
                    }
                }
            }
        }

        answer = (answer == Integer.MAX_VALUE) ? -1 : answer;


        return answer;
    }
    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
//        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
//        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
//        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
//        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
