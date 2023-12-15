import java.util.*;
import java.io.*;

class Main{
    static int n,m,x;
    static ArrayList<int[]>[] graph;
    static Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
    static int[] cng;

    public static int[] sol(int start){

        int[] check = new int[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(check[now[0]] == 1) continue;
            check[now[0]] = 1;

            for(int[] next:graph[now[0]]){
                if(dist[now[0]] + next[1] < dist[next[0]]){
                    dist[next[0]] = dist[now[0]] + next[1];
                    pq.add(new int[]{next[0], dist[now[0]]+next[1]});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        x = Integer.parseInt(tmp[2]);

        cng = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            tmp = br.readLine().split(" ");
            graph[Integer.parseInt(tmp[0])].add(new int[]{Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])});
        }

        for(int i=1; i<=n; i++){ //toX
            int[] toX = sol(i);
            cng[i] = toX[x];
        }

        //XtoN
        int[] Xto = sol(x);
        for(int i=1; i<=n; i++) {
            cng[i] += Xto[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            max = Math.max(max, cng[i]);
        }

        System.out.print(max);

    }
}