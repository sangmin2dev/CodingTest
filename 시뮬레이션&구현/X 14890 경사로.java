import java.util.*;
import java.io.*;

class Main{

    public static int sol(int n, int l, int[][] board){

        int ans = 0;

        for(int i=0; i<n; i++){
            int conti = 0;
            int cflag = 0;
            int down = 0;
            int up = 0;
            int nol = 0;
            for(int j=0; j<n-1; j++){

                if(board[i][j] == board[i][j+1]) {
                    if(conti == 0 && cflag == 0) conti = 2;
                    else conti += 1;

                    if(down == 1 && conti >= l) {
                        down = 0;
                        cflag = 1;
                        conti = 0;
                    }
                }else if(board[i][j] - board[i][j+1] == 1){
                    if(down == 1 || up == 1) break;
                    if(l != 1) {
                        down = 1;
                        conti = 0;
                    }
                }else if(board[i][j] - board[i][j+1] == -1) {
                    if(up == 1 || down == 1) break;
                    if (conti < l || l != 1) {
                        up=1;
                        break;
                    }
                    conti = 0;
                }else{
                    nol = 1;
                }

            }
            if(down == 0 && up == 0 && nol == 0) ans += 1;

        }


        for(int j=0; j<n; j++){
            int conti = 0;
            int cflag = 0;
            int down = 0;
            int up = 0;
            int nol = 0;
            for(int i=0; i<n-1; i++){

                if(board[i][j] == board[i+1][j]) {
                    if(conti == 0 && cflag == 0) conti = 2;
                    else conti += 1;

                    if(down == 1 && conti >= l) {
                        down = 0;
                        cflag = 1;
                        conti = 0;
                    }
                }else if(board[i][j] - board[i+1][j] == 1){
                    if(down == 1) break;
                    if(l != 1) {
                        down = 1;
                        conti = 0;
                    }
                }else if(board[i][j] - board[i+1][j] == -1) {
                    if(up == 1) break;
                    if (conti < l) {
                        up=1;
                        break;
                    }
                    conti = 0;
                }else{
                    nol = 1;
                }

            }
            if(down == 0 && up == 0 && nol == 0) ans += 1;

        }

        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(sol(n,l,board));
    }
}