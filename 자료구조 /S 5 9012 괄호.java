import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main{

    public static String[] sol(int n, String[] vps){
        String[] ans = new String[n];

        Stack<Character> st;

        int idx = 0;
        boolean flag = true;
        for(String s:vps){
            flag = true;
            st = new Stack<>();

            for(Character x:s.toCharArray()){
                if(x.equals('(')){
                    st.add('(');
                }else if(x.equals(')')){
                    if(!st.isEmpty()){
                        st.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if(!st.isEmpty()) flag = false;
            if(flag) ans[idx] = "YES";
            else ans[idx] = "NO";
            idx++;
        }

        return ans;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] vps = new String[n];
        for(int i=0; i<n; i++){
            vps[i] = br.readLine();
        }

        String[] ans = sol(n, vps);
        for(String x:ans){
            System.out.println(x);
        }




    }
}