import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{

    static ArrayList<Integer> ans = new ArrayList<>();
    public static int sol(int n, int m, int[][] arr){
        int answer = -1;

        int[] p = new int[m+1]; // idx: 가격, value: 칼로리

        int pnum = 0;
        for(int i=0; i<n; i++){
            int mazi = m / arr[i][1];
            for(int j=1; j<=mazi; j++){

                for(int k=0; k<m+1; k++){
                    if(p[k] == 0) continue;
                    if(k + j*arr[i][1] > m) continue;
                    pnum+=1;
                    p[k + j*arr[i][1]] = p[k] + j*arr[i][0];
                    answer = Math.max(answer,  p[k]+ j*arr[i][0]);
                }
                pnum+=1;
                p[j*arr[i][1]] = j*arr[i][0];
                answer = Math.max(answer, j*arr[i][0]);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = (int)(Double.parseDouble(st.nextToken()) * 100);

            if(n == 0 && m == 0) break;

            int[][] arr = new int[n][2];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = (int)(Double.parseDouble(st.nextToken()) * 100);
            }
            ans.add(sol(n,m,arr));
        }

        for(int x:ans){
            System.out.println(x);
        }


    }
}