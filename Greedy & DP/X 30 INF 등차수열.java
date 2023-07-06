import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Node{
    int diff;
    int last;

    public Node(int diff, int last){
        this.diff = diff;
        this.last = last;
    }

}

class Main{

    public static int sol(int n, long[] nums){
        int ans = 0;

        Arrays.sort(nums);

        HashMap<Long, ArrayList<Long>> dp = new HashMap<>();
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                long idx = nums[i] - nums[j];

                ArrayList<Long> x = dp.getOrDefault(idx, new ArrayList<Long>(Arrays.asList(nums[i], 0l)));
                if(x.get(0) != nums[j]){
                    dp.put(idx, new ArrayList<Long>(Arrays.asList(nums[i], 1l)));
                }else{
                    dp.put(idx,new ArrayList<Long>(Arrays.asList(nums[i], x.get(1) + 1l)));
                }
                ans = Math.max(ans, (int)(long)dp.get(idx).get(1));
            }
        }

        return ans+1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] nums = new long[n];
        for(int i=0; i<n; i++){
            nums[i] = Long.parseLong(br.readLine());
        }

        System.out.print(sol(n, nums));
    }
}