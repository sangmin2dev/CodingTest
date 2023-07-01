// 조건에 맞는 케이스만 선별해 조사하는 방식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{


    public static int sol(int[] nums){
        int ans = 1;
        int tmp = 1;
        int dir = 1;

        int cnt=1;
//        for(int i=1; i<nums.length; i++){
//            if(nums[i-1] < nums[i]){
//                cnt = i;
//                break;
//            }
//        }

        for(int i=cnt; i<nums.length; i++) {
            if(dir == 1) {
                if (nums[i-1] < nums[i]) {
                    tmp += 1;
                } else if (nums[i-1] == nums[i]){
                    tmp = 1;
                }else{
                    tmp+=1;
                    dir=0;
                }
            }else{
                if (nums[i-1] > nums[i]) {
                    tmp += 1;
                } else if (nums[i] == nums[i-1]){
                    ans = Math.max(ans, tmp);
                    tmp = 1;
                }else{
                    ans = Math.max(ans, tmp);
                    tmp = 2;
                    dir = 1;
                }
            }
        }
        return Math.max(ans, tmp);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }


        System.out.print(sol(nums));

    }
}