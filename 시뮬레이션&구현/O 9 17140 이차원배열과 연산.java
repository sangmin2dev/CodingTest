// HashMap 정렬가능?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main{

    public static int sol(int r, int c, int k, int[][] arr){
        int ans = -1;

        HashMap<Integer, Integer> hm;
        ArrayList<int[]> a;

        int n = 3;
        int m = 3;

        for(int i=0; i<=100; i++){

            if(i==50 ){
                System.out.print("");
            }
            if(arr[r-1][c-1] == k) return i;

            if(n >= m){ //R
                for(int j=0; j<n; j++){
                    hm = new HashMap<>();
                    for(int l=0; l<100; l++){
                        if(arr[j][l] == 0) continue;
                        hm.put(arr[j][l], hm.getOrDefault(arr[j][l], 0)+1);
                    }

                    a = new ArrayList<>();
                    for(int x:hm.keySet()){
                        a.add(new int[]{x , hm.get(x)});
                    }
                    Collections.sort( a, (e1, e2) -> {
                        if(e1[1] == e2[1]) return e1[0] - e2[0];
                        else return e1[1] - e2[1];
                    });

                    m = Math.max(m, a.size()*2);
                    for(int l=0; l<100; l+=2){
                        if(l < a.size()*2) {
                            int[] x = a.get(l / 2);
                            arr[j][l] = x[0];
                            arr[j][l + 1] = x[1];
                        }else {
                            arr[j][l] = 0;
                            arr[j][l+1] = 0;
                        }
                    }
                }

            }else{ // C
                for(int j=0; j<m; j++){
                    hm = new HashMap<>();
                    for(int l=0; l<100; l++){
                        if(arr[l][j] == 0) continue;
                        hm.put(arr[l][j], hm.getOrDefault(arr[l][j], 0)+1);
                    }

                    a = new ArrayList<>();
                    for(int x:hm.keySet()){
                        a.add(new int[]{x , hm.get(x)});
                    }
                    Collections.sort( a, (e1, e2) -> {
                        if(e1[1] == e2[1]) return e1[0] - e2[0];
                        else return e1[1] - e2[1];
                    });

                    n = Math.max(n, a.size()*2);
                    int sz = Math.min(100, n);
                    for(int l=0; l<sz; l+=2){
                        if(l < a.size()*2) {
                            int[] x = a.get(l / 2);
                            arr[l][j] = x[0];
                            arr[l + 1][j] = x[1];
                        }else {
                            arr[l][j] = 0;
                            arr[l+1][j] = 0;
                        }
                    }

                }
            }

        }

        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k  = Integer.parseInt(st.nextToken());

        int[][] arr = new int[100][100];
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(sol(r,c,k,arr));


    }
}
//2 1 1 2
//1 1 2 1 3 1
//3 3

//1 3 1 1 3 1
//1 1 1 1 1 1
//2 1 2 2
//1 2 1 1
//3
//1

