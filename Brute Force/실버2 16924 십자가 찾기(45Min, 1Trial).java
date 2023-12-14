import java.util.*;
import java.io.*;

class Main{


    static int n,m;
    static int count = 0;
    static int[][] map;
    static int[][] check;
    static ArrayList<int[]> star = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void taov(int r, int c){

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<4; i++){
            q.add(new int[]{r,c,i});
        }

        int sz=0;
        while(true){

            int[][] search = new int[4][2];
            for(int i=0; i<4; i++){
                int[] now = q.poll();
                int nr = now[0] + dir[now[2]][0];
                int nc = now[1] + dir[now[2]][1];

                if(nr<0||nc<0||nr>=n||nc>=m) return;
                if(map[nr][nc] == 0) return;
                search[i] = new int[]{nr, nc};
                q.add(new int[]{nr, nc, i});
            }

            sz++;
            count++;
            sb.append((r+1) + " " + (c+1) + " " + sz + "\n");
            check[r][c] = 0;
            for(int i=0; i<4; i++){
                int nr = search[i][0];
                int nc = search[i][1];
                if(check[nr][nc] == 1) {
                    check[nr][nc] = 0;
                }

            }

        }




    }
    public static void sol(){

        for(int[] s:star){
            taov(s[0], s[1]);
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        map = new int[n][m];
        check = new int[n][m];
        for(int i=0; i<n; i++){
            tmp = br.readLine().split("");
            for(int j=0; j<m; j++){

                if(tmp[j].equals(".")) map[i][j] = 0;
                else{
                    map[i][j] = 1;
                    check[i][j] = 1;
                    star.add(new int[]{i,j});
                }

            }
        }

        sol();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(check[i][j] == 1) {
                    System.out.print(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(count);
        System.out.print(sb.toString());


    }
}