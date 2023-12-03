import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int[] t;
    static int[] p;

    public static int sol(){
        int[] dp = new int[n+2];

        for(int i=1; i<n+1; i++){

            if(i!=1) dp[i] = Math.max(dp[i], dp[i-1]);
            else dp[i] = 0;

            if(i+t[i] > n+1) ;
            else dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i]+p[i]);
        }

        dp[n+1] = Math.max(dp[n], dp[n+1]);
        return dp[n+1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        t = new int[n+1];
        p = new int[n+1];

        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            t[i+1] = Integer.parseInt(tmp[0]);
            p[i+1] = Integer.parseInt(tmp[1]);
        }

        System.out.print(sol());

    }
}