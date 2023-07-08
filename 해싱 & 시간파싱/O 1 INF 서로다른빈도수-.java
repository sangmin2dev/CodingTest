import java.util.*;

class Main{

    public static int sol(String s){

        int ans = 0;

        HashMap<Character, Integer> h = new HashMap<>();

        for(char x : s.toCharArray()){
            h.put(x, h.getOrDefault(x,0)+1);
        }

        ArrayList<Integer> x = new ArrayList<>(h.values());
        x.sort(Comparator.reverseOrder());

        int start = 0;

        while(true){

            boolean flag = true;
            for(int i=0; i<x.size()-1; i++){

                if(x.get(i) == x.get(i+1) && x.get(i) != 0){
                    flag = false;
                    x.set(i+1, x.get(i)-1);
                    ans+=1;
                }
            }

            if(flag) break;
            x.sort(Comparator.reverseOrder());
        }



        return ans;
    }

    public static void main(String[] args){

        String s = "aaabbbcccdddeeeeeff";

        System.out.print(sol(s));

    }
}