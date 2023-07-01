imimport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Node {

    int r;
    int c;

    public Node(int r, int c){
        this.r = r;
        this.c = c;
    }

}

public class Prob {

//    static int[][] board = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
//            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
//            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
//            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
//            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
//            {0, 1, 0, 1, 0, 0, 0, 0, 0, 0} };

    static int[][] board = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 3} };

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Node h;
    static Node d;

    public static int sol(){
        int ans = 0;

        int hidx = 0;
        int didx = 0;



        for(int i=0; i<10000; i++){
            if(h.r + dr[hidx] < 0 || h.r + dr[hidx] > 9 || h.c + dc[hidx] < 0 || h.c + dc[hidx] > 9){
                hidx = (hidx+1)%4;
            }
            else if(board[h.r + dr[hidx]][h.c + dc[hidx]] == 1){
                hidx = (hidx+1)%4;
            }
            else{
                h.r = h.r + dr[hidx];
                h.c = h.c + dc[hidx];
            }

            if(d.r + dr[didx] < 0 || d.r + dr[didx] > 9 || d.c + dc[didx] < 0 || d.c + dc[didx] > 9){
                didx = (didx+1)%4;
            }
            else if(board[d.r + dr[didx]][d.c + dc[didx]] == 1){
                didx = (didx+1)%4;
            }
            else{
                d.r = d.r + dr[didx];
                d.c = d.c + dc[didx];
            }

            if(h.r == d.r && h.c == d.c) return i+1;

        }


        return ans;
    }

    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        board = new int[10][10];
//
//        for(int i=0; i<10; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j=0; j<10; j++){
//                int x = Integer.parseInt(st.nextToken());
//                board[i][j] = x;
//                if(x == 2) {
//                    h = new Node(i,j);
//                }
//                if(x == 3){
//                    d = new Node(i,j);
//                }
//
//            }
//        }

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(board[i][j] == 2) {
                    h = new Node(i,j);
                }
                if(board[i][j] == 3){
                    d = new Node(i,j);
                }

            }
        }

        System.out.println(sol());

    }

}


    port java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Node {

    int r;
    int c;

    public Node(int r, int c){
        this.r = r;
        this.c = c;
    }

}

public class Prob {

//    static int[][] board = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
//            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
//            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
//            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
//            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
//            {0, 1, 0, 1, 0, 0, 0, 0, 0, 0} };

    static int[][] board = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 3} };

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Node h;
    static Node d;

    public static int sol(){
        int ans = 0;

        int hidx = 0;
        int didx = 0;



        for(int i=0; i<10000; i++){
            if(h.r + dr[hidx] < 0 || h.r + dr[hidx] > 9 || h.c + dc[hidx] < 0 || h.c + dc[hidx] > 9){
                hidx = (hidx+1)%4;
            }
            else if(board[h.r + dr[hidx]][h.c + dc[hidx]] == 1){
                hidx = (hidx+1)%4;
            }
            else{
                h.r = h.r + dr[hidx];
                h.c = h.c + dc[hidx];
            }

            if(d.r + dr[didx] < 0 || d.r + dr[didx] > 9 || d.c + dc[didx] < 0 || d.c + dc[didx] > 9){
                didx = (didx+1)%4;
            }
            else if(board[d.r + dr[didx]][d.c + dc[didx]] == 1){
                didx = (didx+1)%4;
            }
            else{
                d.r = d.r + dr[didx];
                d.c = d.c + dc[didx];
            }

            if(h.r == d.r && h.c == d.c) return i+1;

        }


        return ans;
    }

    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        board = new int[10][10];
//
//        for(int i=0; i<10; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j=0; j<10; j++){
//                int x = Integer.parseInt(st.nextToken());
//                board[i][j] = x;
//                if(x == 2) {
//                    h = new Node(i,j);
//                }
//                if(x == 3){
//                    d = new Node(i,j);
//                }
//
//            }
//        }

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(board[i][j] == 2) {
                    h = new Node(i,j);
                }
                if(board[i][j] == 3){
                    d = new Node(i,j);
                }

            }
        }

        System.out.println(sol());

    }

}


