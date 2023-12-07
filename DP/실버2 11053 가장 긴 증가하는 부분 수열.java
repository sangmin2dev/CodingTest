import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[] nums;
    static int[] dp;

    public static int sol(){

        int ans = 1;

        dp[0] = 1;
        if(n == 1) return 1;

        for(int i=1; i<n; i++){
            dp[i] = 1;
            for(int j=i-1; j>=0; j--){

                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);

            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(tmp[i]);
        }
        dp = new int[n];

        System.out.print(sol());
    }
}