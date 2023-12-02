import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int[][] board;
    static int max = 0;

    public static void sol(){
        int[] sum = new int[n+1];

        for(int now=1; now<=n; now++){
            int next = now + board[now][0] -1;

            if(next > n);
            else if(board[now][1] + max > sum[next]) {
                sum[next] = board[now][1] + max;
            }
            if(sum[now] > max) {
                max = sum[now];
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n+1][2];
        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            board[i+1][0] = Integer.parseInt(tmp[0]);
            board[i+1][1] = Integer.parseInt(tmp[1]);
        }

        sol();
        System.out.print(max);

    }
}