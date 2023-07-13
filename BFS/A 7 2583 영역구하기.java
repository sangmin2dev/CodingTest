// 다른사람들은 입력 어떻게 받았나
// board도 입력과 동시에 초기화하면 효율적이다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    static int p = 0;
    static ArrayList<Integer> psize = new ArrayList<>();

    public static void sol(int n, int m, int k, int[][] rec){

        int[][] board = new int[n][m];
        for(int[] r : rec){
            for(int i=r[1]; i<r[3]; i++){
                for(int j=r[0]; j<r[2]; j++){
                    board[i][j] = -1;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(board[i][j] == 0){
                    p += 1;
                    int pstmp = 1;
                    board[i][j] = -1;
                    q.add(new int[]{i,j});

                    while(!q.isEmpty()){

                        int[] now = q.poll();
                        for(int l=0; l<4; l++){
                            int nr = now[0] + dr[l];
                            int nc = now[1] + dc[l];

                            if(nr < 0 || nr >= n || nc < 0 || nc>=m) continue;
                            else if(board[nr][nc] != 0) continue;
                            else {
                                pstmp += 1;
                                board[nr][nc] = -1;
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }
                    psize.add(pstmp);


                }
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);

        int[][] rec = new int[k][4];
        for(int i=0; i<k; i++){
            tmp = br.readLine().split(" ");
            rec[i][0] = Integer.parseInt(tmp[0]);
            rec[i][1] = Integer.parseInt(tmp[1]);
            rec[i][2] = Integer.parseInt(tmp[2]);
            rec[i][3] = Integer.parseInt(tmp[3]);
        }

        sol(n,m,k,rec);

        System.out.println(p);
        Collections.sort(psize);
        for(int x: psize){
            System.out.print(x + " ");
        }


    }
}