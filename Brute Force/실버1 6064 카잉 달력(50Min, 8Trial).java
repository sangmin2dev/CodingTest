import java.util.*;
import java.io.*;
//최소공배수

class Main{
    static StringBuilder sb = new StringBuilder();
    static int t;

    public static void sol(int m, int n, int x, int y){

        int mp = m;
        int np = n;
        int maz = Math.min(mp, np);
        int lcm = 1;

        int div = 2;
        while(div <= maz/2){
            if(mp%div == 0 && np%div ==0){
                lcm*=div;
                mp/=div;
                np/=div;
            }
            div++;
        }

        if(mp != 1) lcm*=mp;
        if(np != 1) lcm*=np;


        ArrayList<Integer> xable = new ArrayList<>();
        ArrayList<Integer> yable = new ArrayList<>();

        int nx = x;
        int ny = y;

        while(nx <= lcm && ny <= lcm){
            if(nx < ny) nx+=m;
            else if(nx > ny) ny+=n;
            else if(nx == ny) {
                sb.append(nx + "\n");
                return;
            }
        }

//        while(nx<=lcm){
//            xable.add(nx);
//            nx+=m;
//        }
//        while(ny<=lcm){
//            yable.add(ny);
//            ny+=n;
//        }
//
//        for(Integer ex:xable){
//
//            if(yable.contains(ex)) {
//                sb.append(ex + "\n");
//                return ;
//            }
//        }
        sb.append(-1 + "\n");
        return;

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            String[] tmp = br.readLine().split(" ");
            sol(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]));
        }
        System.out.print(sb.toString());

    }
}