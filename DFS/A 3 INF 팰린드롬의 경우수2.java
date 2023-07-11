// 모든 경우의수 조사후 팰린드롬 확인이 아닌!
// 팰린드롬이 만들어지는 로직으로 DFS, 길이가 충족되면(모든 알파벳을 사용하면) 무조건 팰린드롬이 되게
// 팰린드롬이 애초에 될 수 없는 경우는 사전에 컷하는 로직 만들고 들어감

import java.util.*;
class Solution {

    static HashMap<Character, Integer> h;
    static Deque<Character> dq;
    static ArrayList<String> ans;
    static int len;

    public static void dfs(){
        if(dq.size() == len){

            String tmp = "";
            for(char x:dq) tmp+=x;
            ans.add(tmp);

        }else{
            for(Character x:h.keySet()){

                if(h.get(x) == 0) continue;
                dq.addFirst(x);
                dq.addLast(x);
                h.put(x, h.get(x) -2);
                dfs();
                dq.pollFirst();
                dq.pollLast();
                h.put(x, h.get(x)+2);


            }


        }
    }
    public String[] solution(String s){

        h = new HashMap<>();
        dq = new LinkedList<>();
        ans = new ArrayList<>();
        len = s.length();

        for(Character x : s.toCharArray()){
            h.put(x, h.getOrDefault(x, 0) + 1);
        }
        int odd = 0;
        Character mid = '#';
        for(Character x: h.keySet()){
            if(h.get(x) % 2 == 1) {
                odd+=1;
                mid = x;
            }
        }
        if(odd > 1) return new String[]{};

        if(mid != '#') {
            h.put(mid, h.get(mid) -1);
            len -=1;
        }

        dfs();

        String[] answer = new String[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}