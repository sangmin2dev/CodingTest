// 두번 사용 불가

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main{

    public static int sol(int d, int p, ArrayList<int[]> lc){
        int ans = 0;

        int[] dp = new int[d+1];

        int[] ch;
        for(int[] x:lc){
            ch = new int[d+1];
            for(int i=1; i<d+1; i++){
                if(x[0] == i) {
                    if(x[1] > dp[i]) {
                        ch[i] = 1;
                        dp[i] = Math.max(dp[i], x[1]);
                    }
                }
                if(ch[i] == 0 && dp[i] != 0 && i+x[0] <= d) {
                    int tmp = Math.min(dp[i], x[1]);
                    if(tmp > dp[i+x[0]]) {
                        ch[i+x[0]] = 1;
                        dp[i+x[0]] = tmp;
                    }
                }
            }
        }

        return dp[d];
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] x = br.readLine().split(" ");
        int d = Integer.parseInt(x[0]);
        int p = Integer.parseInt(x[1]);

        ArrayList<int[]> lc = new ArrayList<>();

        for(int i=0; i<p; i++){
            x = br.readLine().split(" ");
            lc.add(new int[]{Integer.parseInt(x[0]), Integer.parseInt(x[1])});
        }


        System.out.print(sol(d, p, lc));

    }
}