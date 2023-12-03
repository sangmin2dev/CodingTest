import java.util.*;
import java.io.*;

class Main{

    static int n,m;
    static int[][] map;
    static int row,col,dir;
    static int ans = 0;

    //북서남동
    static int[] dc = {0,-1,0,1};
    static int[] dr = {-1,0,1,0};

    public static boolean canClean(){

        for(int d=0; d<4; d++){
            int nr = row+dr[d];
            int nc = col+dc[d];

            if(map[nr][nc] == 0) return true;
        }
        return false;
    }

    public static void sol(){

        ans+=1;
        map[row][col] = 2;

        while(true){

            if(canClean()){
                for(int d=dir+1; d<dir+5; d++) {
                    int nd = d%4;
                    int nr = row + dr[nd];
                    int nc = col + dc[nd];

                    if (map[nr][nc] == 0) {
                        row = nr;
                        col = nc;
                        dir = nd;
                        ans++;
                        map[nr][nc] = 2;
                        break;
                    }
                }
            }else{
                int back = (dir+2)%4;
                int nr = row+dr[back];
                int nc = col+dc[back];

                if(map[nr][nc] == 1) return;
                else{
                    row = nr;
                    col = nc;
                }
            }


        }


    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        tmp = br.readLine().split(" ");
        row = Integer.parseInt(tmp[0]);
        col = Integer.parseInt(tmp[1]);

        int ndtmp = Integer.parseInt(tmp[2]);
        //북서남동
        dir = (ndtmp == 0) ?  0 :
                (ndtmp == 1) ? 3 :
                        (ndtmp == 2) ? 2 : 1;

        map = new int[n][m];
        for(int i=0; i<n; i++){
            tmp = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        sol();
        System.out.print(ans);

    }
}