import java.util.*;
import java.io.*;

class Node{

    int n;
    ArrayList<Node> leaf = new ArrayList<>();

    public Node(int n){
        this.n = n;
    }

    public void addLeaf(Node l){
        this.leaf.add(l);
    }

}

class Main{
    static StringBuilder sb = new StringBuilder();
    static int n;

    static ArrayList<Integer>[] ele;
    static int[] parent;

    public static void sol(){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1));
        Arrays.fill(parent,-1);
        parent[1] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();

            for (int e : ele[now.n]) {
                    if(parent[e] != -1) continue;
                    parent[e] = now.n;
                    q.add(new Node(e));
            }
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ele = new ArrayList[n+1];
        parent = new int[n+1];
        for(int i=0; i<n+1; i++){
            ele[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            String[] tmp = br.readLine().split(" ");
            ele[Integer.parseInt(tmp[1])].add(Integer.parseInt(tmp[0]));
            ele[Integer.parseInt(tmp[0])].add(Integer.parseInt(tmp[1]));
        }

        sol();
        for(int i=2; i<n+1; i++){
            sb.append(parent[i] + "\n");
        }
        System.out.print(sb.toString());
    }
}