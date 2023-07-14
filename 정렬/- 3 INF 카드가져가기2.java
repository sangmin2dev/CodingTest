import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Main{

    public static long sol( int[] arr, int k){
        long ans = 0;

        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, Collections.reverseOrder());

        ArrayList<Integer> diff = new ArrayList<>();
        for(int i=0; i<nums.length; i+=2){
            ans += nums[i+1];
            diff.add(nums[i] - nums[i+1]);
        }

        diff.sort(Comparator.reverseOrder());
        for(int i=0;i<k;i++){
            ans+=diff.get(i);
        }


        return ans;
    }

    public static void main(String[] args){

        int[] nums = {7, 8, 5, 12, 3, 1, 3, 1, 1, 12};
        int k = 2;

        System.out.print(sol(nums, k));

    }

}