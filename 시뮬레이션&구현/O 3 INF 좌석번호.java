// 체크하고 넘어가? 넘어가고 체크해? 에따라 종료조건


public class Main {


    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] board;
    static int[][] check;
    public static int[] sol(int r, int c, int k){
        int[] ans = {0,0};

        if(k>r*c){
            return ans;
        }

        int cnt = 0;
        if(k >= 1){
            check[0][0] = 1;
            cnt = 1;
        }


        int didx = 0;

        while(cnt<k){
            int nr = ans[0] + dr[didx];
            int nc = ans[1] + dc[didx];

            if(nr < 0 || nr >= r || nc < 0 || nc >= c){
                didx = (didx+1)%4;
            }
            else if(check[nr][nc] == 1){
                didx = (didx+1)%4;
            }else{
                cnt+=1;
                ans[0] = nr;
                ans[1] = nc;
                check[nr][nc] = 1;
            }
        }

        ans[0]+=1;
        ans[1]+=1;
        return ans;
    }

    public static void main(String[] args) {

        int r = 5;
        int c = 6;
        int k = 30;
        board = new int[r][c];
        check = new int[r][c];

        int[] ans = sol(r, c,k);

        System.out.print(ans[1] + ", " + ans[0]);


    }
}