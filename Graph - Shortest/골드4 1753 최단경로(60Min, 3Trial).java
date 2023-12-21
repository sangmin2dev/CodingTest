import java.util.*;
import java.io.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    static int v,e;
    static int s;
    static ArrayList<int[]>[] graph;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
    static int[] check;
    static int[] dist;

    public static void sol(){

        dist = new int[v+1];
        for(int i=1; i<v+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new int[]{s,0});
        dist[s] = 0;

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            if(check[now[0]] == 1) continue;
            check[now[0]] = 1;

            for(int[] next: graph[now[0]]){

                if(now[1] + next[1] < dist[next[0]]) {
                    dist[next[0]] = now[1] + next[1];
                    pq.add(new int[]{next[0], now[1]+next[1]});
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        v = Integer.parseInt(tmp[0]);
        e = Integer.parseInt(tmp[1]);

        s = Integer.parseInt(br.readLine());

        graph = new ArrayList[v+1];
        check = new int[v+1];
        for(int i=1; i<=v; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<e; i++){
            tmp = br.readLine().split(" ");
            graph[Integer.parseInt(tmp[0])].add(new int[]{Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])});
        }



        sol();


        for(int i=1; i<=v; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.print(sb.toString());


    }
}