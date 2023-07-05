import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node>{

    int diff;
    int p;
    int g;

    public Node(int diff, int p, int g){
        this.diff = diff;
        this.p = p;
        this.g = g;
    }

    @Override
    public int compareTo(Node e){
        if(this.diff == e.diff) return e.g - this.g;
        return e.diff - this.diff;
    }

}

class Main{


    public static int sol(int[] plantTime, int[] growTime){
        int ans = 0;

        ArrayList<Node> node = new ArrayList<>();
        for(int i=0; i<plantTime.length; i++){
            node.add(new Node(growTime[i] - plantTime[i], plantTime[i], growTime[i]));
        }

        Collections.sort(node);

        int pe = 0;
        int ge = 0;
        for(int i=0; i<node.size(); i++){

            pe += node.get(i).p;
            ans = Math.max(pe+node.get(i).g, ans);

        }

        return ans;
    }

    public static void main(String[] args){

        int[] plantTime = {1, 3, 2};
        int[] growTime = {2, 3, 2};

        System.out.print(sol(plantTime, growTime));

    }
}

/*
심는동안 자라야한다

p-g가 큰거 -> 작은거
편차가 같다면? -> g가 큰거

0->1 / 1 -> 3
1->3 / 3->5
3->6 / 6->9

1->4 / 4->7
4->6 / 6->8

 */
