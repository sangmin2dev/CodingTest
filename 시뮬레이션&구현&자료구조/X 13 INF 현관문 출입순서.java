import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Node implements Comparable<Node>{

    int n;
    int arrival;
    int state;

    public Node(int n, int arrival, int state){
        this.n = n;
        this.arrival = arrival;
        this.state = state;
    }

    @Override
    public int compareTo(Node e){
        return this.n - e.n;
    }

}

class Main{


    public static int[] sol(int[] arrival, int[] state){
        int[] ans = new int[arrival.length];

        Queue<Node> inq = new LinkedList<>();
        Queue<Node> outq = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
//        PriorityQueue<Node> q = new PriorityQueue<>();

        int stand = arrival[0];
        int unit = 0;
        for(int i=0; i<arrival.length; i++){
            if(state[i] == 0) inq.add(new Node(i, arrival[i], state[i]));
            else outq.add(new Node(i, arrival[i], state[i]));
            q.add(new Node(i, arrival[i], state[i]));
        }

        int cont = 1;
        int cnt = 0;

        int flag = 1;
        Node ind = inq.poll();
        Node outd = outq.poll();
        while(!inq.isEmpty() && !outq.isEmpty()){


            if(inq.isEmpty()){

            }else if(outq.isEmpty()){

            }else{
                if(flag == 1 && outd.arrival <= ind.arrival){
                    ans[outd.n] = cnt;
                    cnt+=1;
                    outd = outq.poll();
                } else if()
                else if(outd.arrival == ind.arrival){
                    ans[outd.n] = cnt;
                    cnt+=1;
                    outd = outq.poll();
                }else{

                }
            }


        }

        return ans;
    }

    public static void main(String[] args){

        int[] arrival = {0, 1, 1, 1, 2, 3, 8, 8};
        int[] state = {1, 0, 0, 1, 0, 0, 1, 0};

        int[] ans = sol(arrival, state);
        for(int e:ans) {
            System.out.print(e + " ");
        }

    }
}