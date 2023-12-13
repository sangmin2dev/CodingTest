//https://donghyeon.dev/java/2019/06/05/Dangling-meta-character-'+'-near-index-0-%ED%95%B4%EA%B2%B0/
import java.util.*;
import java.io.*;


//가정: 괄호가 여러개임
class Main{


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp  = br.readLine();

        String[] tmp2 = tmp.split("-");

        int[] line = new int[tmp2.length];

        for(int i=0; i<tmp2.length; i++){
            String[] element = tmp2[i].split("\\+");
            for(String e:element){
                line[i] += Integer.parseInt(e);
            }
        }

        int ans = line[0];
        for(int i=1; i<line.length; i++){
            ans-=line[i];
        }

        System.out.print(ans);

    }
}