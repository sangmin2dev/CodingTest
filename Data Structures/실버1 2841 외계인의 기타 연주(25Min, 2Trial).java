import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int f;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        f = Integer.parseInt(tmp[1]);

        Stack<Integer>[] st = new Stack[7];
        for(int i=0; i<7; i++){
            st[i] = new Stack<>();
        }
        int count = 0;

        for(int i=0; i<n; i++){
            tmp = br.readLine().split(" ");
            int line = Integer.parseInt(tmp[0]);
            int fret = Integer.parseInt(tmp[1]);

            if(st[line].isEmpty()){
                st[line].add(fret);
                count++;
            }else if(st[line].peek() > fret){
                while(!st[line].isEmpty()) {
                    if(st[line].peek() > fret) {
                        st[line].pop();
                        count++;
                    }else {
                        break;
                    }
                }
                if(st[line].isEmpty()){
                    st[line].push(fret);
                    count++;
                }else if(st[line].peek() != fret) {
                    st[line].push(fret);
                    count++;
                }
            }else if(st[line].peek() == fret) continue;
            else{
                st[line].push(fret);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count);
        System.out.print(sb.toString());
    }
}