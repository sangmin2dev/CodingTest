import java.util.*;
import java.io.*;

class Main{

    static int n, m, x, y, k;
    static int[][] board;
    static int[] movelist;

    static int[] dice = new int[6]; //     0 1  2 3 4  5
                                    // 기본 위 동 북 밑 서 남



    public static boolean move(int moving) {
        switch (moving) {
            case 1: { //동
                if(y+1>=m) break;
                y+=1;
                return true;
            }
            case 2: { //동
                if(y-1<0) break;
                y-=1;
                return true;
            }
            case 3: { //동
                if(x-1<0) break;
                x-=1;
                return true;
            }
            case 4: { //동
                if(x+1>=n) break;
                x+=1;
                return true;
            }
        }
        return false;
    }
    public static int[] roll(int moving){ //주사위 굴리기
        int[] newdice = new int[6];


        switch(moving){

            case 1: { //동

                newdice[0] = dice[4];
                newdice[1] = dice[0];
                newdice[2] = dice[2];
                newdice[3] = dice[1];
                newdice[4] = dice[3];
                newdice[5] = dice[5];

                break;


            }
            case 2: {// 서

                newdice[0] = dice[1];
                newdice[1] = dice[3];
                newdice[2] = dice[2];
                newdice[3] = dice[4];
                newdice[4] = dice[0];
                newdice[5] = dice[5];

                break;
            }
            case 3: {// 북

                newdice[0] = dice[5];
                newdice[1] = dice[1];
                newdice[2] = dice[0];
                newdice[3] = dice[2];
                newdice[4] = dice[4];
                newdice[5] = dice[3];
                break;
            }
            case 4: {// 남

                newdice[0] = dice[2];
                newdice[1] = dice[1];
                newdice[2] = dice[3];
                newdice[3] = dice[5];
                newdice[4] = dice[4];
                newdice[5] = dice[0];

                break;

            }
        }

        return newdice;

    }

    public static void sol(){


        for(int moving:movelist){
            if(move(moving)) {
                dice = roll(moving);

                if (board[x][y] == 0) board[x][y] = dice[3];
                else {
                    dice[3] = board[x][y];
                    board[x][y] = 0;
                }
                System.out.println(dice[0]);
            }
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        x = Integer.parseInt(tmp[2]);
        y = Integer.parseInt(tmp[3]);
        k = Integer.parseInt(tmp[4]);

        board = new int[n][m];
        movelist = new int[k];

        for(int i=0;i<n; i++){
            tmp = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        tmp = br.readLine().split(" ");
        for(int i=0; i<k; i++){
            movelist[i] = Integer.parseInt(tmp[i]);
        }
        sol();
    }
}