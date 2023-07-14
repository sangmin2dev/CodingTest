import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{

    public static int sol(int n,int m, int[] init, int[][] board){
        int ans = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        if(board[init[0]][init[1]] == 0){
            ans+=1;
            board[init[0]][init[1]] = -1;
        }
        q.add(init);

        int count = 0;
        while(true){

            int[] now = q.poll();

            int nr = now[0] + dr[now[2]];
            int nc = now[1] + dc[now[2]];

            if(count == 4){
                int br = now[0] + dr[(now[2]+2)%4];
                int bc = now[1] + dr[(now[2]+2)%4];

                if(board[br][bc] == 1) break;
                else{
                   q.add(new int[]{br, bc, now[2]});
                   count = 0;
                }
            }else if(board[nr][nc] == 1 || board[nr][nc] == -1) {
                now[2] = (now[2] == 0) ? 3 : now[2] - 1;
                q.add(new int[]{now[0], now[1], now[2]});
                count+=1;
            }else{
                count = 0;
                board[nr][nc] = -1;
                q.add(new int[]{nr, nc, now[2]});
                ans+=1;
            }
        }


        return ans;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] init = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        int[][] board = new int[n][m];
        for(int i=0; i<n; i++){
            st =  new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(sol(n,m,init,board));

    }
}