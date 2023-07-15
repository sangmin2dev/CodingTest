import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main{

    public static int sol(int d, int p, ArrayList<Integer[]> cl){
        int ans = 0;

        int[] dp = new int[d+1];
//        for(int i=0; i<dp.length; i++){
//            dp[i] = Integer.MAX_VALUE;
//        }

        cl.sort((e1,e2)->{
           if(e1[0] == e2[0])  return (int)(e2[1] - e1[1]);
           else return (int)(e1[0] - e2[0]);
        });

        for(int i=0; i<cl.size(); i++){
            Integer[] x = cl.get(i);
            dp[x[0]] = Math.max(x[1], dp[x[0]]);
        }

        for(int i=0; i<cl.size(); i++){
            Integer[] x = cl.get(i);
            for(int j=x[0]; j<d+1; j++) {
                dp[j] = Math.min(dp[j-x[0]], x[1]);
            }
        }

        return dp[d];
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] x = br.readLine().split(" ");
        int d = Integer.parseInt(x[0]);
        int p = Integer.parseInt(x[1]);

        ArrayList<Integer[]> cl = new ArrayList<>();

        for(int i=0; i<p; i++){
            x = br.readLine().split(" ");
            cl.add(new Integer[]{Integer.parseInt(x[0]), Integer.parseInt(x[1])});
        }

        System.out.print(sol(d, p, cl));

    }
}