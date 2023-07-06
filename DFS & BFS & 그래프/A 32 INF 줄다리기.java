import java.util.*;
class Solution {

    static int ans;

    public static boolean isF(int x, int y, ArrayList<Integer>[] f){

        for(int j=0; j<f.length; j++){
            if(f[j].contains(x) && f[j].contains(y)) {
                return true;
            }
        }
        return false;
    }
    public static void dfs(int n, ArrayList<Integer> line, ArrayList<Integer>[] f){
        if(n == 7){
            ans += 1;
        }else{
            for(int i=1; i<8; i++){
                if(line.contains(i)) {
                    continue;
                }
                if(line.size() < 1);
                else if(isF(i, line.get(line.size()-1), f)){
                    continue;
                }

                line.add(i);
                dfs(n+1, line, f);
                line.remove(Integer.valueOf(i));
            }

        }

    }

    public int solution(int[][] fight){
        int answer = 0;

        ans = 0;
        ArrayList<Integer> line = new ArrayList<>();
        ArrayList<Integer>[] f = new ArrayList[fight.length];
        for(int i=0; i<fight.length; i++){
            f[i] = new ArrayList<>();
            for(int j=0; j<2; j++) {
                f[i].add(fight[i][j]);
            }
        }
        dfs(0, line, f);

        return ans;
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
