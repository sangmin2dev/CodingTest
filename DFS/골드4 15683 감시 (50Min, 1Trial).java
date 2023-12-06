//dfs + bfs

import java.util.*;
import java.io.*;

class Main{

    static int n,m;
    static int[][] map;

    static ArrayList<ArrayList<Integer>> cctv = new ArrayList<>(); //번호, r, c
    static int cctvNum;
    static int[] nd;
    static int min = Integer.MAX_VALUE;
    static int blank = 0;

    static int[] dc = {1,0,-1,0};
    static int[] dr = {0,1,0,-1};
    static ArrayList<ArrayList>[] cctvDir = new ArrayList[5];

    public static void move0(int[][] tmpMap, ArrayList<Integer> c){

        for(int i=c.get(2); i<m; i++){
            if(tmpMap[c.get(1)][i] == 6) break;
            else if(tmpMap[c.get(1)][i] == 0) tmpMap[c.get(1)][i] = -1;
        }

    }
    public static void move1(int[][] tmpMap, ArrayList<Integer> c){

        for(int i=c.get(1); i<n; i++){
            if(tmpMap[i][c.get(2)] == 6) break;
            else if(tmpMap[i][c.get(2)] == 0) tmpMap[i][c.get(2)] = -1;
        }

    }
    public static void move2(int[][] tmpMap, ArrayList<Integer> c){

        for(int i=c.get(2); i>=0; i--){
            if(tmpMap[c.get(1)][i] == 6) break;
            else if(tmpMap[c.get(1)][i] == 0) tmpMap[c.get(1)][i] = -1;
        }

    }
    public static void move3(int[][] tmpMap, ArrayList<Integer> c){

        for(int i=c.get(1); i>=0; i--){
            if(tmpMap[i][c.get(2)] == 6) break;
            else if(tmpMap[i][c.get(2)] == 0) tmpMap[i][c.get(2)] = -1;
        }

    }

    public static int bfs(){

        int[][] tmpMap = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tmpMap[i][j] = map[i][j];
            }
        }

        for(int i=0; i<cctvNum; i++){
            switch (cctv.get(i).get(0)) {

                case 0:{
                    switch (nd[i]){
                        case 0:{
                            move0(tmpMap, cctv.get(i));
                            break;
                        }
                        case 1:{
                            move1(tmpMap, cctv.get(i));
                            break;
                        }
                        case 2:{
                            move2(tmpMap, cctv.get(i));
                            break;
                        }
                        case 3:{
                            move3(tmpMap, cctv.get(i));
                            break;
                        }
                    }
                    break;
                }
                case 1:{
                    switch (nd[i]) {
                        case 0: {
                            move0(tmpMap, cctv.get(i));
                            move2(tmpMap, cctv.get(i));
                            break;
                        }
                        case 1: {
                            move1(tmpMap, cctv.get(i));
                            move3(tmpMap, cctv.get(i));
                            break;
                        }
                    }
                    break;
                }
                case 2:{
                    switch (nd[i]) {
                        case 0: {
                            move0(tmpMap, cctv.get(i));
                            move3(tmpMap, cctv.get(i));
                            break;
                        }
                        case 1: {
                            move0(tmpMap, cctv.get(i));
                            move1(tmpMap, cctv.get(i));
                            break;
                        }
                        case 2: {
                            move1(tmpMap, cctv.get(i));
                            move2(tmpMap, cctv.get(i));
                            break;
                        }
                        case 3: {
                            move2(tmpMap, cctv.get(i));
                            move3(tmpMap, cctv.get(i));
                            break;
                        }
                    }
                    break;
                }
                case 3:{
                    switch (nd[i]) {
                        case 0: {
                            move0(tmpMap, cctv.get(i));
                            move2(tmpMap, cctv.get(i));
                            move3(tmpMap, cctv.get(i));
                            break;
                        }
                        case 1: {
                            move3(tmpMap, cctv.get(i));
                            move0(tmpMap, cctv.get(i));
                            move1(tmpMap, cctv.get(i));
                            break;
                        }
                        case 2: {
                            move0(tmpMap, cctv.get(i));
                            move1(tmpMap, cctv.get(i));
                            move2(tmpMap, cctv.get(i));
                            break;
                        }
                        case 3: {
                            move1(tmpMap, cctv.get(i));
                            move2(tmpMap, cctv.get(i));
                            move3(tmpMap, cctv.get(i));
                            break;
                        }
                    }
                    break;
                }
                case 4:{
                    switch (nd[i]) {
                        case 0: {
                            move0(tmpMap, cctv.get(i));
                            move1(tmpMap, cctv.get(i));
                            move2(tmpMap, cctv.get(i));
                            move3(tmpMap, cctv.get(i));
                            break;
                        }
                    }
                    break;
                }

            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(tmpMap[i][j] == 0) ans++;
            }
        }
        return ans;
    }

    public static void dfs(int depth){

        if(depth == cctvNum){

//            for(int i=0; i<cctvNum; i++) {
//                System.out.print(nd[i]);
//            }
//            System.out.println();

            int now = bfs();
            min = Math.min(min, now);
        }else{

            for(int i=0; i<4; i++){


                if(cctv.get(depth).get(0) == 1 && i >= 2) continue;
                if(cctv.get(depth).get(0) == 4 && i >= 1) continue;
                nd[depth] = i;
                dfs(depth+1);

            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        map = new int[n][m];

        for(int i=0; i<n; i++){
            tmp = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                int e = Integer.parseInt(tmp[j]);
                map[i][j] = e;
                if(e >= 1 && e <= 5) {
                    ArrayList<Integer> c = new ArrayList<>(Arrays.asList(e-1,i,j));
                    cctv.add(c);
                }
                if(e == 0) blank++;
            }
        }
        cctvNum = cctv.size();
        nd = new int[cctvNum];

        dfs(0);
        System.out.print(min);
    }
}