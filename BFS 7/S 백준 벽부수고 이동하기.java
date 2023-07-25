// visited 3중배열
// 시작과 도착이 같은 경우

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{

    int r;
    int c;
    int rest;

    public Node(int r, int c, int rest){
        this.r = r;
        this.c = c;
        this.rest = rest;
    }
}

class Main {

    static int[][] board;
    static int[][][] check;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};

    public static int sol(int n, int m){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,1));
        int depth = 1;

        while(!q.isEmpty()){
            int cnt = q.size();

            for(int i=0; i<cnt; i++){
                Node now = q.poll();

                if(now.r == n-1 && now.c == m-1) return depth;

                for(int j=0; j<4; j++){
                    int nr = now.r + dr[j];
                    int nc = now.c + dc[j];

                    if(nr < 0 || nc < 0 || nr >= n || nc >= m);
                    else if(nr == n-1 && nc == m-1) return depth+1;

                    else if(board[nr][nc] == 1){
                        if (now.rest == 1){
                            q.add(new Node(nr,nc,0));
                            check[nr][nc][0]  = 1;
                        }
                    }
                    else{
                        if(now.rest == 0 && check[nr][nc][0] == 0){
                            q.add(new Node(nr,nc, now.rest));
                            check[nr][nc][0]  = 1;
                        }else if(now.rest == 1 && check[nr][nc][1] == 0){
                            q.add(new Node( nr, nc, now.rest));
                            check[nr][nc][1]  = 1;
                        }
                    }
                }
            }
            depth+=1;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        check = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.print(sol(n,m));

    }
}


















