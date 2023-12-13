import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int[] p;

    public static int sol(){
        int ans = 0;

        Arrays.sort(p);
        for(int i=0; i<n; i++){

            ans += p[i]*(n-i);

        }

        return ans;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        p = new int[n];
        String[] tmp = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            p[i] = Integer.parseInt(tmp[i]);
        }

        System.out.print(sol());


    }
}