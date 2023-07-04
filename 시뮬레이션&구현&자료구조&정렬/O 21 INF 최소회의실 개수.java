import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node>{
    int t;
    int inout; // in: 1

    public Node(int t, int inout){
        this.t = t;
        this.inout = inout;
    }
    @Override
    public int compareTo(Node e){
        if(this.t == e.t) return this.inout - e.inout;
        return this.t - e.t;
    }

}

class Main{
    public static int sol(int[][] meetings){
        int ans = 0;

        ArrayList<Node> ms = new ArrayList<>();
        for(int i=0; i<meetings.length; i++){
            ms.add(new Node(meetings[i][0], 1));
            ms.add(new Node(meetings[i][1], 0));
        }
        Collections.sort(ms);

        int tmp = 0;
        for(int i=0; i<ms.size(); i++){

            if(ms.get(i).inout == 1){
                tmp += 1;
            }else{
                tmp -= 1;
            }
            ans = Math.max(tmp,ans);

        }


        return ans;
    }

    public static void main(String[] args){

//        int[][] meetings = {{0, 10}, {12, 25}, {5, 15}, {2, 5}};
//        int[][] meetings = {{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}};
//        int[][] meetings = {{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}};
        int[][] meetings = {{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}};

        System.out.print(sol(meetings));

    }
}

