//toCharArray
// FromTO

import java.util.ArrayList;

class Main{

    public static int sol(int[] pad, String password){
        int ans = 0;

        int[] dr = {0,1,1,1,0,-1,-1,-1};
        int[] dc = {1,1,0,-1,-1,-1,0,1};

        int[][] pad2D = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                pad2D[i][j] = pad[3*i+j];
            }
        }

        ArrayList<Integer>[] time = new ArrayList[10];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {

                time[pad2D[i][j]] = new ArrayList<>();

                for(int k=0; k<8; k++) {
                    int nr = i+dr[k];
                    int nc = j+dc[k];
                    if(nr < 0 || nr >= 3 || nc < 0 || nc >=3) continue;
                    else {
                        time[pad2D[i][j]].add(pad2D[nr][nc]);
                    }
                }

            }
        }

        char[] pas = password.toCharArray();
        for(int i=0; i<pas.length-1; i++){
            int now = pas[i] - '0';
            int next = pas[i+1] - '0';

            if(now == next) continue;
            if(time[now].contains(next)) ans+=1;
            else ans+=2;
        }


        return ans;
    }

    public static void main(String[] args){

        int[] pad = {1, 6, 7, 3, 8, 9, 4, 5, 2};
        String password = "3337772122";

        System.out.print(sol(pad, password));


    }
}