import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    public static int[] sol(int[] enter, int[] exit) {
        int[] ans = new int[enter.length + 1];

        Queue<Integer> enterQ = new LinkedList<>();
        Queue<Integer> exitQ = new LinkedList<>();

        for (int i = 0; i < enter.length; i++) {
            enterQ.add(enter[i]);
        }
        for (int i = 0; i < exit.length; i++) {
            exitQ.add(exit[i]);
        }
        ArrayList<Integer> h = new ArrayList<>();

        while (!exitQ.isEmpty()) {

            int s = exitQ.poll();

            if(enterQ.isEmpty()){
                h.remove(Integer.valueOf(s));
                ans[s] += h.size();
                for(int inh: h){
                    ans[inh] += 1;
                }
            }

            while(!enterQ.isEmpty()){
                if(h.contains(s)){
                    h.remove(Integer.valueOf(s));
                    ans[s] += h.size();
                    for(int inh: h){
                        ans[inh] += 1;
                    }
                }else {
                    int x = enterQ.poll();
                    if (x != s) {
                        h.add(x);
                    } else {
                        for (int inh : h) {
                            ans[inh] += 1;
                        }
                        ans[s] += h.size();
                        break;
                    }
                }
            }

        }


        return ans;
    }

    public static void main(String[] args) {

        int[] enter = {1, 3, 2, 4, 5, 7, 6, 8};
        int[] exit = {2, 3, 5, 6, 1, 4, 8, 7};


        int[] x = sol(enter, exit);
        for (int i = 1; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }
}