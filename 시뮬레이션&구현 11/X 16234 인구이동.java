import java.util.*;
import java.io.*;

class Main{

    public static int sol(int n, int l, int r, int[][] board){
        int ans = 0;

        ArrayList<int[]> xy = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        int[][] ch = new int[n][n];
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        int round = 0;
        boolean flag = true;
        while(flag) {
            round++;
            int fcount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if(ch[i][j] == round) continue;

                    int tmp = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                        int near = Math.abs(board[i][j] - board[nr][nc]);
                        if (near >= l && near <= r) {
                            if(ch[i][j] != round){
                                q.add(new int[]{i, j});
                                q2.add(new int[]{i, j});
                                tmp += board[i][j];
                                ch[i][j] = round;
                            }
                            q.add(new int[]{nr, nc});
                            q2.add(new int[]{nr, nc});
                            tmp += board[nr][nc];
                            ch[nr][nc] = round;
                        }
                    }
                    if(q.isEmpty()) fcount++;

                    while (!q.isEmpty()) {
                        int[] x = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = x[0] + dr[d];
                            int nc = x[1] + dc[d];
                            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                            if (ch[nr][nc] == round) continue;

                            int near = Math.abs(board[x[0]][x[1]] - board[nr][nc]);
                            if (near >= l && near <= r) {
                                q.add(new int[]{nr, nc});
                                q2.add(new int[]{nr, nc});
                                tmp += board[nr][nc];
                                ch[nr][nc] = round;
                            }
                        }
                    }

                    if (tmp != 0) {
                        tmp = tmp / q2.size();
                        while (!q2.isEmpty()) {
                            int[] x = q2.poll();
                            board[x[0]][x[1]] = tmp;
                        }
                    }
                }
            }
            if(fcount == n*n) break;
        }

        return round-1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){

                board[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        System.out.print(sol(n,l,r,board));

    }
}