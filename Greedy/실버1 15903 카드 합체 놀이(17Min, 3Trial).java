import java.util.*;
import java.io.*;

class Main{
    static int n, m;
    static PriorityQueue<Long> a = new PriorityQueue<>();

    public static long sol(){

        for(int i=0; i<m;i++){
            long x = a.poll();
            long y = a.poll();

            a.add(x+y);
            a.add(x+y);
        }

        long ans = 0;
        while(!a.isEmpty()){
            ans+=a.poll();
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);


        tmp = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            a.add(Long.parseLong(tmp[i]));
        }

        System.out.print(sol());

    }
}