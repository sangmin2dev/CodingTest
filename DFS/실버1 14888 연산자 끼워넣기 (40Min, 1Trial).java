import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int[] nums;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    public static void dfs(int d, int now, int[] oprt){

        if(d == n){
            if(now > max) max= now;
            if(now < min) min = now;

        }else{
            for(int i=0; i<n-1; i++){

                if(oprt[i] == -1) continue;
                int o = oprt[i];
                int prenow =now;

                if(o==0) now+=nums[d];
                else if(o==1) now-=nums[d];
                else if(o==2) now*=nums[d];
                else if(o==3) now/=nums[d];

                oprt[i] = -1;
                dfs(d+1, now, oprt);
                oprt[i] = o;
                now = prenow;

            }
        }

    }


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        String[] tmp = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(tmp[i]);
        }
        tmp = br.readLine().split(" ");
        int[] oprt = new int[n-1];

        int idx = 0;
        for(int i=0;i<4;i++){
            int eachOprtNum = Integer.parseInt(tmp[i]);
            for(int j=0; j<eachOprtNum; j++){
                oprt[idx] = i;
                idx++;
            }
        }

        dfs(1, nums[0], oprt);

        System.out.print(max + "\n" + min);

    }
}