import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


class Main{

    public static int sol(int n, int[] nums){
        int ans = Integer.MAX_VALUE;

        HashMap<Integer, Integer> dp = new HashMap<>();
        int cnt = 0;
        dp.put(nums[0], 1);
        for(int i=1; i<n; i++){
            dp.put(nums[i], dp.getOrDefault(nums[i], 0)+1);
            if(dp.get(nums[i])%2 == 0){
                cnt -= 1;
            }else{
                cnt += 1;
            }
            ans = Math.min(cnt, ans);
        }


        cnt = cnt < 0 ? 0:cnt;
        return cnt;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        String[] tmp = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(tmp[i]);
        }

        System.out.print(sol(n, nums));
    }
}