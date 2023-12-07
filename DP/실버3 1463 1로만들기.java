import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int[] dp;

    public static int sol(){

        if(n == 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 1;

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<=n; i++){

            dp[i] = dp[i-1];
            if(i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2]);
            if(i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3]);
            dp[i]+=1;

        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        System.out.print(sol());
    }
}