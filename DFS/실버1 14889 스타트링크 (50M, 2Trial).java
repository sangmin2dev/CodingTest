import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int[][] s;

    static int min = Integer.MAX_VALUE;

    public static void dfs(int l, int check, int[] team){


        if(check>=n/2){
            ArrayList<Integer> teamA = new ArrayList<>();
            ArrayList<Integer> teamB = new ArrayList<>();
            for(int i=0; i<n; i++){
                if(team[i] == 1) teamA.add(i);
                else teamB.add(i);
            }

            int sumA =0;
            int sumB =0;

            for(int x:teamA){
                for(int y:teamA){
                    sumA += s[x][y];
                }
            }
            for(int x:teamB){
                for(int y:teamB){
                    sumB += s[x][y];
                }
            }
            int sub = (sumA>sumB) ? sumA-sumB : sumB-sumA;
            min = Math.min(min, sub);

        }else{
            if(l==n) return;
            check++;
            team[l] = 1;
            dfs(l+1, check, team);
            check--;
            team[l] = 0;
            dfs(l+1, check, team);
        }


    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        s = new int[n][n];
        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                s[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int[] team = new int[n];

        dfs(0, 0, team);
        System.out.print(min);

    }
}