import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


class Room{

    int n;
    int end;
    int num;

    public Room(int n, int end, int num){
        this.n = n;
        this.end = end;
        this.num = num;
    }

}

class Main{


    public static int sol(int n, int[][] meetings){
        int ans = Integer.MAX_VALUE;

        Arrays.sort(meetings, (e1, e2) -> {
            return e1[0] - e2[0];
        });

        PriorityQueue<Room> rooms = new PriorityQueue<>((e1, e2) ->{
            if(e1.end == e2.end) return e1.n - e2.n;
            return e1.end - e2.end;
        });

        for(int[] x : meetings){
            x[1] = x[1]-x[0];
        }

        for(int i=0; i<n; i++){
            rooms.add(new Room(i, 0,0));
        }

        for(int i=0; i<meetings.length; i++){
            Room tmp = rooms.poll();

            int end = (tmp.end < meetings[i][0])? meetings[i][0] : tmp.end;

            rooms.add(new Room(tmp.n, end + meetings[i][1], tmp.num+1));
        }

        PriorityQueue<Room> ansRoom = new PriorityQueue<>((e1, e2) ->{
            if(e1.num == e2.num) return e1.n - e2.n;
            else return e2.num - e1.num;
        });
        while(!rooms.isEmpty()){
            Room r = rooms.poll();
            ansRoom.add(r);
        }


        return ansRoom.poll().n;
    }

    public static void main(String[] args){
        int n = 2;
        int[][] meetings = {{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}};
//        int[][] meetings = {{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}};
//        int[][] meetings = {{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}};
//        int[][] meetings = {{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}};

        System.out.print(sol(n, meetings));


    }
}
