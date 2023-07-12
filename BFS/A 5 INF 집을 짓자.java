import java.util.*;
class Solution {
    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        int bnum = 0;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                int x = board[i][j];
                if(x == 1){
                    q.add(new int[]{i,j, bnum});
                    bnum += 1;
                }
            }
        }
        int[][][] ch = new int[board.length][board.length][bnum];

        int D = 0;
        while(!q.isEmpty()){

            int sz = q.size();
            D+=1;
            for(int i=0; i<sz; i++){
                int[] step = q.poll();

                for(int j=0; j<4; j++){

                    int nr=  step[0] + dr[j];
                    int nc = step[1] + dc[j];
                    int bidx = step[2];

                    if(nr < 0 || nr >= board.length || nc < 0 || nc >= board.length) continue;
                    else if(board[nr][nc] > 0 ) continue;
                    else if(ch[nr][nc][bidx] != 0) continue;
                    else{
                        ch[nr][nc][bidx] = D;
                        q.add(new int[]{nr, nc, bidx});

                    }
                }
            }
        }

//        for(int i=0; i<board.length; i++) {
//            System.out.println();
//            for (int j = 0; j < board.length; j++) {
//                System.out.print(ch[i][j][0] + " ");
//            }
//        }
//        System.out.println();
//        for(int i=0; i<board.length; i++) {
//            System.out.println();
//            for (int j = 0; j < board.length; j++) {
//                System.out.print(ch[i][j][1] + " ");
//            }
//        }
//        System.out.println();
//        for(int i=0; i<board.length; i++) {
//            System.out.println();
//            for (int j = 0; j < board.length; j++) {
//                System.out.print(ch[i][j][2] + " ");
//            }
//        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                int tmp = 0;
                int num = 0;
                for(int k=0; k<bnum; k++){
                    if(ch[i][j][k] == 0) break;
                    else {
                        tmp+= ch[i][j][k];
                        num+=1;
                    }
                }
                if(num == bnum){
                    answer = Math.min(tmp, answer);
                }
            }
        }

        answer = (answer>board.length*board.length*bnum) ? -1 : answer;


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