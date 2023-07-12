import java.util.*;
class Solution {

    static String ips;
    static ArrayList<String> ans;
    static Deque<String> q;
    static int[] ch;
    static String tmp;
    static Integer fidx;
    static Integer eidx;

    public static void dfs(int D){

        if(D == 4){

            String a = "";
            while(!q.isEmpty()){

                a += q.pollFirst();
                a += ".";
            }
            ans.add(a);

        }else{
            for(int i=1; i<ips.length(); i++) {

                if(ch[i] == 1) continue;

                fidx = i;
                if(ips.substring(fidx, eidx).equals("")) ;
                else if(ips.substring(fidx, eidx).length()>2 && ips.substring(fidx,eidx).startsWith("0")) break;
                else if(Integer.parseInt(ips.substring(fidx, eidx)) >255) break;

                ch[i] = 1;
                q.addLast(ips.substring(fidx, eidx));
                dfs(D + 1);
                q.pollLast();
                ch[i] = 0;
            }
        }
    }

    public String[] solution(String s){
        String[] answer;
        ans = new ArrayList<>();
        q = new LinkedList<>();
        ch = new int[s.length()];
        ips = s;
        tmp = "";
        fidx = 0;
        eidx = 0;

        dfs(0);

        answer = new String[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
