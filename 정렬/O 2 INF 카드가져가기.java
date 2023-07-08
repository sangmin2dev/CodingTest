import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class KR implements Comparable<KR>{
    int round;
    int devi;

    public KR(int round, int devi){
        this.round = round;
        this.devi = devi;
    }

    @Override
    public int compareTo(KR kr){
        return kr.devi - this.devi;
    }

}

class Main{

    public static long sol( Integer[] nums, int k){
        long ans = 0;

        Arrays.sort(nums, Collections.reverseOrder());

        ArrayList<KR> kround = new ArrayList<>();

        for(int i=0; i<nums.length; i+=2){
            kround.add(new KR(i, nums[i] - nums[i+1]));
        }
        Collections.sort(kround);

        ArrayList<Integer> kroundOnly = new ArrayList<>();
        int cnt=0;
        for(int i=0; i<kround.size(); i++){
            kroundOnly.add(kround.get(i).round);
            cnt+=1;
            if(cnt == k) break;
        }

        for(int i=0; i<nums.length; i+=2){
            if(kroundOnly.contains(i)) ans += nums[i];
            else ans+= nums[i+1];
        }
        return ans;
    }

    public static void main(String[] args){

        Integer[] nums = {14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19};
        int k = 3;

        System.out.print(sol(nums, k));

    }

}