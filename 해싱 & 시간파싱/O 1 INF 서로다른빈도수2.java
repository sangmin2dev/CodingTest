import java.util.HashMap;
import java.util.HashSet;

class Main{

    public static Integer sol(String s){

        int ans = 0;

        HashMap<Character, Integer> m = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();

        for(char x:s.toCharArray()){
            m.put(x,m.getOrDefault(x, 0)+1);
        }

        for(char x:m.keySet()){
            if(!hs.contains(m.get(x))){
                hs.add(m.get(x));
            }else{
                while(hs.contains(m.get(x)) && m.get(x) != 0){
                    m.put(x, m.get(x)-1);
                    ans+=1;
                }
                hs.add(m.get(x));
            }
        }
        return ans;
    }

    public static void main(String[] args){

        String s = "aaabbbcccdddeeeeeff";

        System.out.print(sol(s));


    }
}