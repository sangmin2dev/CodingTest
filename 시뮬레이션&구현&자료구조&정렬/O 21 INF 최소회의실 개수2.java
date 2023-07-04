import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class Main{
    public static int sol(int[][] meetings){
        int ans = 0;

        ArrayList<int[]> ms = new ArrayList<>();
        for(int i=0; i<meetings.length; i++){
            ms.add(new int[]{meetings[i][0], 1}); // in
            ms.add(new int[]{meetings[i][1], 0}); // out
        }
        ms.sort((e1, e2) -> {
            if(e1[0] == e2[0]) return e1[1] - e2[1];
            else return e1[0] - e2[0];
        });

        int tmp = 0;
        for(int i=0; i<ms.size(); i++){

            if(ms.get(i)[1] == 1){
                tmp += 1;
            }else{
                tmp -= 1;
            }
            ans = Math.max(tmp,ans);

        }


        return ans;
    }

    public static void main(String[] args) throws IOException {

//        int[][] meetings = {{0, 10}, {12, 25}, {5, 15}, {2, 5}};
//        int[][] meetings = {{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}};
//        int[][] meetings = {{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}};
//        int[][] meetings = {{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] meetings = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.print(sol(meetings));

    }
}


