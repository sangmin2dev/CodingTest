import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Main{


    public static int sol(int[] arr, int m){
        int ans = 0;

        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]:: new);
        Arrays.sort(nums, Comparator.reverseOrder());
        ArrayList<Integer> saved = new ArrayList<>();

        int lt =0;
        int rt = nums.length-1;
        while(lt<rt){

            if(nums[lt] + nums[rt] > m) {
                saved.add(nums[lt]);
                lt++;
                ans+=1;
            }else{
                saved.add(nums[lt]);
                saved.add(nums[rt]);
                lt++;
                rt--;
                ans+=1;
            }
            if(saved.size() == nums.length){
                return ans;
            }

        }
        return ans;
    }

    public static void main(String[] args){

        int[] nums = {86, 95, 107, 67, 38, 49, 116, 22, 78, 53};
        int m = 150;

        System.out.print(sol(nums, m));

    }
}