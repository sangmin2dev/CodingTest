// P. 문자열 - Character 배열 변환
// P. 문자열에서 dfs 추가 삭제

import java.util.*;
class Solution {

    static int[] ch;
    static int n;
    static ArrayList<String> ans;
    static String str;

    public static void dfs(int D, ArrayList<Character> p){

        if(D == n){
            String tmp = "";
            for(Character x:p){
                tmp += String.valueOf(x);
            }
            if(ans.contains(tmp)){
                return ;
            }

            int lt = 0;
            int rt = n-1;

            while(lt<=rt){
                if(p.get(lt) != p.get(rt)){
                    return ;
                }else{
                    lt++;
                    rt--;
                }
            }

            ans.add(tmp);

        }else{

            for(int i=0; i<n; i++){
                if(ch[i] == 1) continue;
                else{

                    ch[i] = 1;
                    p.add(str.charAt(i));
                    dfs(D+1, p);
                    p.remove(p.size() - 1);
                    ch[i] = 0;

                }
            }
        }

    }

    public String[] solution(String s){
        String[] answer = {};
        ans = new ArrayList<>();

        ArrayList<Character> p = new ArrayList<>();
        ch = new int[s.length()];
        n = s.length();
        str = s;

        dfs(0, p);


        if(ans.size() != 0) {
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + ", ");
            }
        }
        else{
            System.out.print(Arrays.toString(answer));
        }
        System.out.println();

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        Arrays.toString(T.solution("aaaabb"));
        Arrays.toString(T.solution("abbcc"));
        Arrays.toString(T.solution("abbccee"));
        Arrays.toString(T.solution("abbcceee"));
        Arrays.toString(T.solution("ffeffaae"));
    }
}
