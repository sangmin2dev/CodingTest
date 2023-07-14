// 진료시작시간을 잘못고려한 잘못된 풀이

import java.util.LinkedList;
import java.util.Queue;

class Node{

    int s;
    int e;
    public Node(int s, int e){
        this.s = s;
        this.e = e;
    }

}

class Main{

    public static int sol(int[] laser, String[] enter){
        int ans = 0;
        Queue<Node> q = new LinkedList<>();
        Queue<Node> dq = new LinkedList<>();

        int stand = 0;
        int cnt = 0;
        int h, m, l;
        for(int i=0; i<enter.length; i++){

            String[] tmp = enter[i].split(" ");
            String[] tmp2 = tmp[0].split(":");

            h = Integer.parseInt(tmp2[0]);
            m = Integer.parseInt(tmp2[1]);
            l = laser[Integer.parseInt(tmp[1])];

            q.add(new Node(h*60+m, h*60+m+l));
        }

        while(!q.isEmpty()){
            if(dq.isEmpty()){
                stand = q.poll().e;
            }

            Node now = q.poll();
            dq.add(new Node(now.s, now.e));

            if( now.s < stand) {
                cnt++;
                ans = Math.max(cnt, ans);
            }
            else{
                Node t = dq.poll();
                while(t.s < stand){
                    stand = t.e;
                    cnt--;
                    t = dq.poll();
                }
            }
        }
//        Node now = q.poll();
//        int stand = now.e;
//        while(!q.isEmpty()){
//
//            now = q.peek();
//            if(now.s < stand)
//
//        }



        return ans;
    }


    public static void main(String[] args){

        int[] laser = {30, 20, 25, 15};
        String[] enter = {"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"};

        System.out.print(sol(laser, enter));

    }
}