import java.util.*;
import java.io.*;

class Main{

    static Queue<int[]> q = new LinkedList<>();
    static int ucl = -1;
    static int dcl = -1;

    public static int sol(int r, int c, int T, int[][] board){
        int ans = 0;

        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        for(int t=0; t<T; t++){

            int sz = q.size();
            for(int i=0; i<sz; i++){
                int[] x = q.poll();

                int count = 0;
                int val = (int) Math.floor(x[2]/5);
                for(int d=0; d<4; d++) {
                    int nr = x[0] + dr[d];
                    int nc = x[1] + dc[d];

                    if(nr < 0 || nr >= r || nc <0 || nc>=c ) continue;
                    if(board[nr][nc] == -1) continue;
                    board[nr][nc] += val;
                    count++;
                }
                board[x[0]][x[1]] -= val*count;
            }

            for(int i=ucl-1; i>0; i--){
                board[i][0] = board[i-1][0];
                board[i-1][0] = 0;
            }
            for(int i=dcl+1; i<c-2; i++){
                board[i][0] = board[i+1][0];
                board[i+1][0] = 0;
            }
            for(int j=0; j<c-1; j++){
                board[0][j] = board[0][j+1];
                board[0][j+1] = 0;

                board[r-1][j] = board[r-1][j+1];
                board[r-1][j+1] =0;
            }
            for(int j=0; j<ucl; j++){
                board[j][c-1] = board[j+1][c-1];
                board[j+1][c-1] = 0;
            }
            for(int j=r-1; j>dcl; j--){
                board[j][c-1] = board[j-1][c-1];
                board[j-1][c-1] = 0;
            }
            for(int j=c-1; j>1; j--){
                board[ucl][j] = board[ucl][j-1];
                board[ucl][j-1] = 0;

                board[dcl][j] = board[dcl][j-1];
                board[dcl][j-1] =0;
            }

            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    if(board[i][j] != -1 && board[i][j] != 0){
                        q.add(new int[]{i,j, board[i][j]});
                    }
                }
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] != -1 && board[i][j] != 0){
                    ans+=board[i][j];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] board = new int[r][c];
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++){

                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == -1 && ucl == -1) {
                    ucl = i;
                    dcl = i+1;
                }else if(board[i][j] != -1 && board[i][j] != 0){
                    q.add(new int[]{i,j, board[i][j]});
                }
            }
        }

        System.out.print(sol(r,c,t,board));

    }
}