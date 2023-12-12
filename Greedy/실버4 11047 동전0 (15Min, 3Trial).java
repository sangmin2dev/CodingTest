import java.util.*;
import java.io.*;

class Main{

    static int n;
    static long k;
    static long[] a;

    public static int sol(){
        int ans = 0;

        for(int i=n-1; i>=0; i--){

            if(k==0) break;
            if(k>=a[i]) {
                ans+= k/a[i];
                k = k%a[i];
            }

        }

        return ans;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        k = Long.parseLong(tmp[1]);

        a = new long[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(sol());
    }
}