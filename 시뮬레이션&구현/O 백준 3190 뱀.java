import java.util.*;
import java.io.*;

class Main{

    static int n;

    public static int sol(int[][] board, ArrayList<int[]> move){

        int[] dc = {1,0,-1,0};
        int[] dr = {0,1,0,-1};
        int nd = 0;
        int t = 0;
        ArrayList<Integer[]> snake = new ArrayList<>();
        snake.add(new Integer[]{0,0}); // 큐를 쓰는게 더 낫다.

        for(int i=0; i<10000; i++){
            t++;

            Integer[] next = {snake.get(0)[0] + dr[nd], snake.get(0)[1]+dc[nd]};

            if(move.size() != 0 && move.get(0)[0] == t){
                if(move.get(0)[1] == 1) nd = (nd + 1)%4;
                else nd = (nd==0) ? 3 : nd-1;
                move.remove(0);
            }

            if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n) return t;
            else if(snake.contains(next) || board[next[0]][next[1]] == 2) return t;
            else if(board[next[0]][next[1]] == 1) {
                board[next[0]][next[1]] = 2;
                snake.add(0,next);
            }
            else if(board[next[0]][next[1]] != 1) {
                board[next[0]][next[1]] = 2;
                snake.add(0,next);

                Integer[] tmp = snake.get(snake.size()-1);
                board[tmp[0]][tmp[1]]= 0;
                snake.remove(snake.size()-1);
            }
        }

        return 10000;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        for(int i=0; i<k; i++){
            String[] tmp = br.readLine().split(" ");
            board[Integer.parseInt(tmp[0])-1][Integer.parseInt(tmp[1])-1] = 1;
        }
        int l = Integer.parseInt(br.readLine());

        ArrayList<int[]> move = new ArrayList<>();
        for(int i=0; i<l; i++) {
            String[] tmp = br.readLine().split(" ");

            int d =  (tmp[1].equals("D")) ? 1 : -1; //D-1 / L--1
            move.add(new int[]{Integer.parseInt(tmp[0]), d}); // 큐를 쓰는게 더 낫다
        }

        System.out.print(sol(board, move));

    }
}