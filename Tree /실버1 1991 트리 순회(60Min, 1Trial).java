import java.util.*;
import java.io.*;

class Node{

    Character r;
    Node[] leaf = new Node[2];

    public Node(Character r, Node le0, Node le1){
        this.r = r;
        this.leaf[0] = le0;
        this.leaf[1] = le1;
    }

}

class Main{
    static StringBuilder sb = new StringBuilder();

    static String pre = "";
    static String mid = "";
    static String post = "";
    static int n;
    static Node root;
    static HashMap<String, String[]> hm;

    public static void dfs(int cnt, String root){
        if(cnt == n) {

        }else{

            String left = hm.get(root)[0];
            String right = hm.get(root)[1];

            pre += root;
            if(!left.equals(".")) dfs(cnt+=1, left);
            mid += root;
            if(!right.equals(".")) dfs(cnt+=1, right);
            post += root;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        hm = new HashMap<>();
        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            hm.put(tmp[0], new String[]{tmp[1],tmp[2]});
        }

        dfs(0, "A");
        System.out.println(pre);
        System.out.println(mid);
        System.out.println(post);

    }
}