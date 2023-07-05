import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Candie {
    int cal;
    int pri;

    public Candie(int cal, int pri){
        this.cal = cal;
        this.pri = pri;
    }
}

class Main{

    public static long sol(int n, int m, ArrayList<Candie> candies){
        long ans = 0;
        long[] dp = new long[m+1];

//        for(int i=0; i<candies.size(); i++) {
//            Candie c = candies.get(i);
//            for (int j = c.pri; j < m + 1; j++) {
//                dp[j] = Math.max(dp[j], dp[j-c.pri] + c.cal);
//            }
//        }

        candies.sort((e1, e2) -> {
           return (int)(e1.pri - e2.pri);
        });

        for(int i=0; i<candies.size(); i++){
            int x = candies.get(i).cal;
            dp[candies.get(i).pri] = x;
            ans = Math.max(x,ans);
        }

        int now = 0;
        while(now <= m){

            if(dp[now] == 0);
            else{
                for(int i=0; i<candies.size(); i++){
                    long x = dp[now] + candies.get(i).cal;
                    if(now+candies.get(i).pri <= m) {
                        dp[now+candies.get(i).pri] = x;
                        ans = Math.max(x,ans);
                    }
                }
            }
            now+=1;
        }
        return dp[m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = (int)Math.round(Double.parseDouble(st.nextToken()))*100;
        ArrayList<Candie> candies;

        while(n!=0 && m != 0){

            candies = new ArrayList<>();

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int cal = Integer.parseInt(st.nextToken());
                int pri = (int)Math.round(Double.parseDouble(st.nextToken()))*100;

                candies.add(new Candie( cal, pri));
            }
            System.out.println(sol(n,m,candies));

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = (int)Math.round(Double.parseDouble(st.nextToken()))*100;

        }
    }
}