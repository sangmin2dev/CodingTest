import java.util.*;
import java.io.*;

class Main{

    static int n;
    static long[][] p;

    public static long sol(){

        p[1][1] = p[1][0];

        for(int i=1; i<=n; i++){
            long tmp = p[i][0];
            for(int j=i-1; j>=i/2; j--){

                if(j*2 == i){ //마지막
                    tmp = Math.max(p[j][0]*2,tmp);

                }else{

                    long e1 = p[j][1];
                    long e2 = p[i-j][1];

                    tmp = Math.max(e1+e2, tmp);
                }

            }
            p[i][1] = tmp;
        }


        return p[n][1];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        p = new long[n+1][2];
        String[] tmp = br.readLine().split(" ");
        for(int i=1; i<=n; i++){
            p[i][0] = Integer.parseInt(tmp[i-1]);
        }

        System.out.print(sol());

    }


}