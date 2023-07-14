// LIS 알고리식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{


    static int[][] check;
    public static int sol(int[] nums){
        int ans = -1;
        int tmp = 0;

        check[0][0] = 1;
        check[nums.length-1][1] = 1;

        for(int i=1; i<nums.length; i++){

            check[i][0] = 1;
            for(int j=i-1; j>=0; j--){
                if(nums[j] < nums[i]) {
                    check[i][0] = Math.max(check[j][0]+1, check[i][0]);
                }
            }
        }

        for(int i=nums.length-2; i>=0; i--){
            check[i][1] = 1;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] < nums[i]){
                    check[i][1] = Math.max(check[j][1]+1, check[i][1]);
                }
            }
        }

        for(int i=0; i<nums.length; i++){
            ans = Math.max(check[i][0] + check[i][1], ans);
        }

        return ans-1;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        check = new int[n][2];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }


        System.out.print(sol(nums));

    }
}