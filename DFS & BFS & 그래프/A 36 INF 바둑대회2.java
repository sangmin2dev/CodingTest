import java.util.*;
class Solution {

    static ArrayList<Integer>[] diff;
    static int answer;
    static int[] check;
    static int total;

    public static void dfs(int d, int s){

        if(d == diff.length/2 ){
            int team0 = 0;
            int team1 = 0;
            for(int i=0; i<diff.length; i++){
                if(check[i] == 0){
                    team0+= diff[i].get(0);
                }else{
                    team1+= diff[i].get(1);
                }
            }
            answer = Math.min(answer, Math.abs(team0-team1));
        }else{

            for(int i=s; i<diff.length; i++){

                check[i] = 1;
                dfs(d+1, i+1);
                check[i] = 0;
            }
        }
    }


    public int solution(int[][] cans){
        answer = Integer.MAX_VALUE;

        diff = new ArrayList[cans.length];
        for(int i=0; i<diff.length; i++){
            diff[i] = new ArrayList<>();
            diff[i].add(cans[i][0]);
            diff[i].add(cans[i][1]);
        }

        check = new int[cans.length];

        dfs(0, 0);

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
