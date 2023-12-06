import java.util.*;
import java.io.*;

class Main{

    static ArrayList<Integer>[] t = new ArrayList[4];
    static int k;
    static int[][] move;

    public static void rotateUnit(int tnum, int dir){

        if(dir == 1){ // 시계방향
            int tmp = t[tnum].get(7);
            t[tnum].remove(7);
            t[tnum].add(0, tmp);
        }else{ // 반시계방헝
            int tmp = t[tnum].get(0);
            t[tnum].remove(0);
            t[tnum].add(tmp);
        }
    }


    public static void rotate(int startT, int dirT, ArrayList<Integer> lside, ArrayList<Integer> rside){

        rotateUnit(startT, dirT);

        int rd = (dirT==1)?-1:1;
        int ld = rd;
        for(Integer x:rside){
            rotateUnit(x, rd);
            rd = (rd==1)?-1:1;
        }
        for(Integer x:lside){
            rotateUnit(x, ld);
            ld = (ld==1)?-1:1;
        }

    }


    public static void sol(){

        for(int[] m:move){

            ArrayList<Integer> rside = new ArrayList<>();
            ArrayList<Integer> lside = new ArrayList<>();

            for(int i=m[0]; i>0; i--){//lside
                if(t[i].get(6) != t[i-1].get(2)) lside.add(i-1);
                else break;

            }
            for(int i=m[0]; i<3; i++){ //rside
                if(t[i].get(2) != t[i+1].get(6)) rside.add(i+1);
                else break;
            }

            rotate(m[0], m[1], lside, rside);

        }

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i=0; i<4; i++){
            String[] tmp = br.readLine().split("");

            t[i] = new ArrayList<>();
            for(String e:tmp){
                t[i].add(Integer.parseInt(e));
            }
        }

        k = Integer.parseInt(br.readLine());
        move = new int[k][2];
        for(int i=0; i<k; i++){
            String[] tmp = br.readLine().split(" ");
            move[i][0] = Integer.parseInt(tmp[0])-1;
            move[i][1] = Integer.parseInt(tmp[1]);
        }

        sol();

        int ans =0;
        if(t[0].get(0) == 1) ans+=1;
        if(t[1].get(0) == 1) ans+=2;
        if(t[2].get(0) == 1) ans+=4;
        if(t[3].get(0) == 1) ans+=8;
        System.out.print(ans);
    }
}