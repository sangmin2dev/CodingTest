import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int[] a;

    public static long sol(){
        long ans = 0;

        Arrays.sort(a);
        for(int i=0; i<n; i++){
            int b = i+1;
            ans+= Math.abs(a[i]-b);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(sol());
    }
}