import java.util.*;
import java.io.*;

class Node{

    int r;
    int c;

    int pr;
    int pc;
    ArrayList<Integer> e;

    public Node(int r, int c, int pr, int pc, ArrayList<Integer> e){
        this.r = r;
        this.c = c;
        this.pr = pr;
        this.pc= pc;
        this.e = new ArrayList<>();

        for(int ex:e){
            this.e.add(ex);
        }
    }
}

class Main{

    static int n,m;
    static Character[][] map;
//    static int[][] check;
    static Map<Character, int[]> start = new HashMap<>();

    static int[] dc = {1,0,-1,0};
    static int[] dr = {0,1,0,-1};
    static String ans = "No";

    public static void dfs(int r, int c, int pr, int pc, int[][] check){

        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr<0||nc<0||nr>=n||nc>=m) continue;
            else if(nr == pr && nc == pc) continue;
            else if(map[nr][nc] != map[r][c]) continue;
            else if(check[nr][nc] == 1) {
                ans = "Yes";
                return;
            }else{
                check[nr][nc] = 1;
                dfs(nr,nc,r,c,check);
            }

        }
    }

    public static void sol(){

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int[][] check = new int[n][m];
                if(check[i][j] == 1) continue;
                check[i][j] = 1;
                dfs(i,j,-1,-1,check);
                if(ans == "Yes") return ;
            }
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        map = new Character[n][m];
//        check = new int[n][m];
        for(int i=0; i<n; i++){
            String t = br.readLine();
            for(int j=0; j<m; j++){
                Character val = t.charAt(j);
                map[i][j] = val;

            }
        }

        sol();
        System.out.print(ans);


    }
}