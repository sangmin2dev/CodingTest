import java.util.*;
import java.io.*;

class Main{

    static int n;
    static long sz;
    static int count = 0;

    public static void sol(){

        int x = n;
        int cnt = 0;
        boolean flag = true;
        while(x!=0){
            if(flag && x%2 == 1) {
                count=cnt;
                flag = false;
            }
            x = x/2;
            cnt++;
        }

        count = cnt-count;
        if(count == 1) {
            count = 0;
            sz = Math.round(Math.pow(2, cnt-1));
        }else{
            sz = Math.round(Math.pow(2, cnt));
        }

    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        sol();
        System.out.print(sz + " " + count);


    }
}