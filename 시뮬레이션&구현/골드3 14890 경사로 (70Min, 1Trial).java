import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int l;
    static int[][] map;


    public static int checkByDir(int dir){
        int notRoad = 0;


        return notRoad;
    }

    public static int sol(){
        int ans = 0;
        int notRoad = 0;

        for(int d=0; d<2; d++) {
            for (int i = 0; i < n; i++) {
                int count = 1;
                boolean lowerF = false;
                for (int j = 0; j < n; j++) {

                    if (j == n - 1) {
                        if (lowerF) {
                            notRoad++;
                        }
                        break;
                    }


                    int now;
                    int next;
                    if (d == 0) {

                        now = map[i][j];
                        next = map[i][j + 1];
                    } else {

                        now = map[j][i];
                        next = map[j + 1][i];
                    }

                    if (Math.abs(now - next) > 1) { //사다리를 놓을 수 없는 경우
                        notRoad++;
                        break;
                    } else if (now == next) { // 같은경우
                        count++;
                        if (lowerF && count == l) {
                            count = 0;
                            lowerF = false;
                        }
                    } else if (now - next == -1) { //높아진 경우
                        if (count < l) {
                            notRoad++;
                            break;
                        }
                        count = 1;
                    } else if (now - next == 1) {// 낮아진 경우
                        if(lowerF) {
                            notRoad++;
                            break;
                        }

                        if (l != 1) {
                            lowerF = true;
                            count = 1;
                        } else {
                            count = 0;
                        }
                    }

                }
            }
        }


        return 2*n-notRoad;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        l = Integer.parseInt(tmp[1]);

        map = new int[n][n];
        for(int i=0; i<n; i++){
            tmp = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        System.out.print(sol());

    }
}