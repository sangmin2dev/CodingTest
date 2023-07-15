// 해쉬맵 정렬
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{

//    public static String sol(int n, int k, String num){
//
//        int[] ch = new int[num.length()];
//        String answer = "";
//        HashMap<Character, Integer> hm = new HashMap<>();
//        for(Character x:num.toCharArray()){
//
//            hm.put(x, hm.getOrDefault(x, 0) +1);
//
//        }
//        List<Character> ks = new ArrayList<>(hm.keySet());
//
//        Collections.sort(ks);
//
//        int count = 0;
//        while(count != k){
//
//            for(Character x: ks) {
//                if(count == k) break;
//                for (int i=0; i<num.length(); i++) {
//                    if(count == k) break;
//                    if(hm.get(x) == 0) break;
//                    if(x == num.charAt(i)){
//                        ch[i] = -1;
//                        hm.put(x, hm.get(x)-1);
//                        count++;
//                    }
//
//                }
//            }
//        }
//
//        for(int i=0; i<ch.length; i++){
//            if(ch[i] == 0) answer+=String.valueOf(num.charAt(i));
//        }
//
//
//        return answer;
//    }

    static int ans;
    static String num;
    static int[] ch;
    static int[] ch2;
    static int n;
    static int k;

    public static void dfs(int n){

        if(n==k){

            String tmp = "";
            for(int i=0; i<ch.length; i++){
                if(ch[i] == 0){
                    tmp+=String.valueOf(num.charAt(i));
                }
            }

            ans = Math.max(ans, Integer.parseInt(tmp));

        }else{

            for(int i=0; i<num.length(); i++){
                if(ch[i]==-1) continue;
                ch[i] = -1;
                dfs(n+1);
                ch[i] = 0;
            }


        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        k = Integer.parseInt(tmp[1]);

        num = br.readLine();
        ch = new int[n];

        dfs(0);
        System.out.print(ans);

    }
}
