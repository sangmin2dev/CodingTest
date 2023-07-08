import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static int sol(int n, int[] v){
        int ans = 0;

        int lt =0;
        int rt =v.length-1;

        int cnt = 1;
        while(lt<=rt){

            if(lt == rt){
                ans+=v[lt]*cnt;
                break;
            }

            if(v[lt] > v[rt]){
                ans += v[rt]*cnt;
                cnt++;
                rt--;
            }else if(v[lt]<v[rt]){
                ans += v[lt]*cnt;
                cnt++;
                lt++;
            }else if(v[lt] == v[rt]){
                if(v[lt+1] > v[rt+1]){
                    ans += v[rt]*cnt;
                    cnt++;
                    rt--;
                }else if(v[lt+1]<v[rt+1]){
                    ans += v[lt]*cnt;
                    cnt++;
                    lt++;
                }
            }
        }


        return ans;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[] v = new int[n];
        for(int i=0; i<n; i++){
            v[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(sol(n, v));
    }
}