import java.util.*;
class Solution {
    public int solution(int s, int e){
        int answer = 0;


        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        int d = 0;
        int ego = 1;
        while(!q.isEmpty()){

            int sz = q.size();
            for(int i=0; i<sz; i++){
                int now = q.poll();
                if(now == e) return d;
                else if(e>200000) return -1;

                int[] dx = {now+1, now-1, now*2};
                for(int j=0; j<3; j++){
                    if(dx[j] <= 200000 && dx[j]>=0){
                        q.add(dx[j]);
                    }
                }


            }
            e+=ego;
            ego++;
            d++;
        }

        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}