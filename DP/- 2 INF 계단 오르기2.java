// 그냥 처음부터 점화식대로 하면 규칙에 들어맞을 수 없게끔 점화식 설계
// 설계한 점화식대로만 흘러가는데 오료가 있을 리가 없다고 생각하고 점화식 짜기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static int sol(int n, int[] stairs){

        int[] dp = new int[n+1];
        dp[1] = stairs[1];
        if(n>1) dp[2] = dp[1] + stairs[2];
        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i]);
        }

        return dp[n];
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