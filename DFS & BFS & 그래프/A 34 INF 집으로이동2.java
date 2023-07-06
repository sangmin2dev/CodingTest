// 메모리제이션
//  거기서 파생되는 곳이 없어짐을 유의하기 / 이 예제에서 0, 1을 나눈 이유

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] pool, int a, int b, int home){
        int answer = 0;

        ArrayList<Integer> p = new ArrayList<>();
        for(int x : pool){
            p.add(x);
        }

        int[][] check = new int[10001][2];
        for(int e : pool){
            check[e][0] = 1; // 뒤로
            check[e][1] = 1; // 앞으로
        }

        Queue<Integer[]> q = new LinkedList<>(); // 위치, flag
        q.add(new Integer[]{0,0});
        check[0][0] = 1;
        check[0][1] = 1;

        while(!q.isEmpty()){
            int sz = q.size();

            for(int i=0; i<sz; i++) {

                Integer[] now = q.poll();
                if(now[0] == home) return answer;

                if(now[1] != 1){ //연속뒤로점프 아닐시에만
                    if(now[0]-b > 0 && check[now[0] - b][0] == 0 ) {
                        q.add(new Integer[]{now[0]-b, 1});
                        check[now[0] - b][0]=1;
                    }
                }
                if(now[0]+a <= 1000 && check[now[0]+a][1] == 0) {
                    q.add(new Integer[]{now[0] + a, 0});
                    check[now[0] + a][1]=1;
                }
            }
            answer+=1;
        }

        return -1;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}