import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static int sol(int n, int[] stairs){
        int ans = 0;

        int[][] dp = new int[n+1][2];
        dp[1][0] = stairs[1];

        for(int i=2; i<stairs.length; i++){

            dp[i][1] = dp[i-1][0] + stairs[i];
            dp[i][0] = Math.max(dp[i-2][1] + stairs[i], dp[i-2][0] + stairs[i]);
        }

        return Math.max(dp[n][0], dp[n][1]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n+1];
        for(int i=1; i<n+1; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(sol(n, stairs));
    }
}

/*
    1 -> 1 -> 2 -> 1 or 2 -> 2
    2 -> 1 ->
 */