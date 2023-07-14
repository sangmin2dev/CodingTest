// 자료형을 적절히 활용하기
//  check
//  relationShip[][]
//  Stack line

// dfs구조
//      반복문
//      더하고, 체킹, DFS, 체킹빼고, 빼주고

import java.util.*;
class Solution {

    static int answer;
    static Stack<Integer> line;
    static int[] check;
    static int[][] relationShip;

    public static void dfs(int n){
        if(n==7){
            answer+=1;
        }else{
            for(int i=1; i<8; i++){
                if(check[i] == 1) continue;
                else if(line.isEmpty()) ;
                else if(relationShip[i][line.peek()] == 1 || relationShip[line.peek()][i] == 1) continue;

                line.add(i);
                check[i] = 1;
                dfs(n+1);
                check[i] = 0;
                line.pop();

            }
        }
    }
    public int solution(int[][] fight){
        answer = 0;

        relationShip = new int[8][8];
        for(int[] x : fight){
            relationShip[x[0]][x[1]] = 1;
            relationShip[x[1]][x[0]] = 1;
        }

        check = new int[8];
        line = new Stack<>();
        dfs(0);

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
