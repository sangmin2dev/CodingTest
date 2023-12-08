import java.util.*;
import java.io.*;


class Main{

    static int n;
    static long[][] dp;
    static long mod = 1000000000;

    public static long dpSum(int x){

        long sum = 0;
        for(int i=0; i<10; i++){
            sum+=dp[x][i];
        }

        return sum;
    }

    public static long sol(){

        dp[1][0] = 0;
        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }

        if(n == 1){
            dpSum(1);
        }

        for(int i=2; i<=n; i++){

            dp[i][0] = dp[i-1][1]%mod;
            for(int j=1; j<9; j++) {
                dp[i][j] = dp[i - 1][j-1] + dp[i-1][j+1]%mod;
            }
            dp[i][9] = dp[i-1][8]%mod;

        }

        return dpSum(n);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new long[n+1][10];


        System.out.print(sol()%mod);

    }
}