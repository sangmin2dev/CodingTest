import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class P {

    long in;
    long time;

    public P(long in, long time){
        this.in = in;
        this.time = time;
    }
}

class Main{

    public static ArrayList<String> sol(String[] reports, int time){
        ArrayList<String> ans = new ArrayList<>();

        HashMap<String, P> ps = new HashMap<>();
        for(String r: reports){
            String[] tmp = r.split(" ");

            int h = Integer.parseInt(tmp[1].split(":")[0]);
            int m = Integer.parseInt(tmp[1].split(":")[1]);

            String inout = tmp[2];
            if(inout.equals("in")){
                P p = ps.getOrDefault(tmp[0], new P(0,0));
                p.in = h*60+m;
                ps.put(tmp[0], p);
            }else{
                long duration = ps.get(tmp[0]).time + h*60+m - ps.get(tmp[0]).in;
                ps.put(tmp[0], new P(0, duration));
                if(duration > time) ans.add(tmp[0]);
            }
        }

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args){

        String[] reports = {"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"};
        int time = 60;


        ArrayList<String> ans = sol(reports, time);
        for(String e:ans){
            System.out.print(e + " ");
        }

    }
}