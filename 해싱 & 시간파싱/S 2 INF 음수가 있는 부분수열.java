class Main{

    public static long sol(long[] nums, long m){
        long ans = 0;

        for(int i=0; i<nums.length; i++){
            int tmp=0;
            for(int j=i; j<nums.length; j++){

                tmp+=nums[j];
                if(tmp == m) ans+=1;

            }
        }

        return ans;
    }

    public static void main(String[] args){

        long[] nums = {-1, -1, -1, 1};
        long m = 0;

        System.out.print(sol(nums, m));

    }
}