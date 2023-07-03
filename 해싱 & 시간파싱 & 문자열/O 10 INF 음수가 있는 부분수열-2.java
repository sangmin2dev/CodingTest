import java.util.HashMap;

class Main{

    public static long sol(long[] nums, long m){
        long ans = 0;

        HashMap<Long, Long> hm = new HashMap<>();

        long sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(sum == m) ans+=1;
            else if(hm.containsKey(sum-m)) ans+=hm.get(sum-m);

            hm.put(sum, hm.getOrDefault(sum, 0l)+1);
        }

        return ans;
    }

    public static void main(String[] args){

        long[] nums = {2, 2, 3, -1, -1, -1, 3, 1, 1};
        long m = 5;

        System.out.print(sol(nums, m));

    }
}