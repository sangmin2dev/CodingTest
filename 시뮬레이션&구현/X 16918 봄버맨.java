import java.util.*;
import java.io.*;

// 0초 초기        1
// 1초 nothing    1
// 2초 안된곳 설치   2
// 3초 3초전 bomb  1X
// 4초 안된곳 설치   1
// 5초 3초전 bomb  2X
// 6초 안된곳 설치   2
// 7초 3초전 bomb  1X
class Main{

    static Character[][][] arr;
    static Character[][] ans;
    static int ch;
    static int unch;


    public static void sol(int r, int c, int n){

        ch = 0;
        unch = 1;

        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};

        for(int t=1; t<=n; t++){

            if(t%2 == 0){
                for(int i=0; i<r; i++){
                    for(int j=0;j<c;j++){
                        if(arr[i][j][ch] == '.') arr[i][j][unch] = '0';
                        else arr[i][j][unch] = '.';
                    }
                }

                int tmp = ch;
                ch = unch;
                unch = tmp;
            }
            else{
                for(int i=0; i<r; i++){
                    for(int j=0; j<c; j++){
                        if(arr[i][j][ch] == '0'){
                            for(int d=0;d<4;d++){

                                int nr = i+dr[d];
                                int nc = j+dc[d];

                                arr[nr][nc][ch] = '.';

                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int r = Integer.parseInt(tmp[0]);
        int c = Integer.parseInt(tmp[1]);
        int n = Integer.parseInt(tmp[2]);

        arr = new Character[r][c][2];
        for(int i=0; i<r; i++){
            String x = br.readLine();
            for(int j=0;j<c; j++){
                arr[i][j][0] = x.charAt(j);
            }
        }

        ans = new Character[r][c];
        if(n%2 == 0) {
            for(int i=0; i<r;i++){
                for(int j=0;j<c;j++){
                    System.out.print('0');
                }
                System.out.println();
            }
        }else {
            sol(r, c, n);

            for(int i=0; i<r; i++){
                for(int j=0;j<c; j++){
                    System.out.print(arr[i][j][ch]);
                }
                System.out.println();
            }

        }

    }
}




