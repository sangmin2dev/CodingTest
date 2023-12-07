import java.util.*;
import java.io.*;

class Pipe{

    int r;
    int c;
    int d; // -1 가로 / 0 대각선 / 1 세로

    public Pipe(int r, int c, int d){
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

class Main{

    static int n;
    static int[][] map;

    public static int sol(){
        int ans = 0;

        Queue<Pipe> pipe = new LinkedList<>();
        pipe.add(new Pipe(0,1, -1));

        if(map[n-1][n-1] == 1) return 0;

        while(!pipe.isEmpty()){

            int sz = pipe.size();
            for(int i=0; i<sz; i++){

                Pipe np = pipe.poll();

                switch(np.d) {

                    case -1:{

                        if(np.c+1 < n){

                            if(np.c+1 == n-1 && np.r == n-1) ans++;
                            else if(map[np.r][np.c+1] == 0){
                                pipe.add(new Pipe(np.r, np.c+1, -1));
                            }

                            if(np.r+1 < n ) {
                                if (map[np.r + 1][np.c + 1] == 1 || map[np.r][np.c + 1] == 1 || map[np.r + 1][np.c] == 1) ;
                                else if (np.c + 1 == n - 1 && np.r + 1 == n - 1) ans++;
                                else if (map[np.r + 1][np.c + 1] == 0 && map[np.r][np.c + 1] == 0 && map[np.r + 1][np.c] == 0) {
                                    pipe.add(new Pipe(np.r + 1, np.c + 1, 0));
                                }
                            }
                        }

                        break;
                    }
                    case 0: {

                        if(np.c+1<n){

                            if(np.c+1 == n-1 && np.r == n-1) ans++;
                            else if(map[np.r][np.c+1] == 0){
                                pipe.add(new Pipe(np.r, np.c+1, -1));
                            }
                        }
                        if(np.r+1 < n) {

                            if (np.c == n - 1 && np.r+1 == n - 1) ans++;
                            else if(map[np.r+1][np.c] == 0){
                                pipe.add(new Pipe(np.r+1, np.c, 1));
                            }
                        }

                        if(np.r+1 < n && np.c+1 <n){
                            if (map[np.r + 1][np.c + 1] == 1 || map[np.r][np.c + 1] == 1 || map[np.r + 1][np.c] == 1) ;
                            else if (np.c+1 == n - 1 && np.r+1 == n - 1) ans++;
                            else{
                                pipe.add(new Pipe(np.r+1, np.c+1, 0));
                            }
                        }


                        break;
                    }
                    case 1: {

                        if(np.r+1 < n){

                            if(np.r+1 == n-1 && np.c == n-1) ans++;
                            else if(map[np.r+1][np.c] == 0){
                                pipe.add(new Pipe(np.r+1, np.c, 1));
                            }

                            if(np.c+1 < n) {
                                if (map[np.r + 1][np.c + 1] == 1 || map[np.r][np.c + 1] == 1 || map[np.r + 1][np.c] == 1) ;
                                else if (np.r + 1 == n - 1 && np.c + 1 == n - 1) ans++;
                                else {
                                    pipe.add(new Pipe(np.r + 1, np.c + 1, 0));
                                }
                            }
                        }

                        break;
                    }

                }

            }
        }


        return ans;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        System.out.print(sol());


    }
}


