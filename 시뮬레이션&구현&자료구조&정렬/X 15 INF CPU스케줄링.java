import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Node implements Comparable<Node>{

    int n;
    int s;
    int d;

    public Node(int n, int s, int d){
        this.n = n;
        this.s = s;
        this.d = d;
    }

    @Override
    public int compareTo(Node e){
        if(this.d == e.d) return this.n - e.n;
        else return this.d - e.d;
    }
}

class Main{

    public static int[] sol(int[][] tasks){
        int[] ans = new int[tasks.length];

        PriorityQueue<Node> wait = new PriorityQueue<>();
        Queue<int[]> q = new PriorityQueue<>((e1, e2)-> {
            return e1[0] - e2[0];
        });

        for(int i=0; i<tasks.length; i++){
            int[] tmp = {tasks[i][0], tasks[i][1]};
            q.add(tmp);
        }

//        Arrays.sort(tasks, (e1, e2)-> {
//           return e1[0] - e2[0];
//        });



        int end;
        int cnt = 0;
        while(true){

            if(wait.isEmpty()){
                int[] tmp = q.poll();
                cnt +=1;
                end = tmp[0] + tmp[1];
                wait.add(new Node())
            }else{

            }


        }


        return ans;
    }

    public static void main(String[] args){

        int[][] tasks = {{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}};
//        int[][] tasks = {{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}};
//        int[][] tasks = {{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}};
//        int[][] tasks = {{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}};

        int[] ans = sol(tasks);
        for(int e:ans){
            System.out.print(e + " ");
        }
    }
}