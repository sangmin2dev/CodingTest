// 시간을 분단위로 볼 수 있기를

import java.util.ArrayList;
import java.util.Collections;

class TimeReport implements Comparable<TimeReport>{
    String n;
    int t;

    public TimeReport(String n, int t){
        this.n = n;
        this.t = t;
    }

    @Override
    public int compareTo(TimeReport n){
        return this.t - n.t;
    }

}

class Main{

    public static ArrayList<String> sol(String[] reports, String times){
        ArrayList<String> ans = new ArrayList<>();

        int starth = Integer.parseInt(times.split(" ")[0].split(":")[0]);
        int startm = Integer.parseInt(times.split(" ")[0].split(":")[1]);
        int endh = Integer.parseInt(times.split(" ")[1].split(":")[0]);
        int endm = Integer.parseInt(times.split(" ")[1].split(":")[1]);

        ArrayList<TimeReport> tr = new ArrayList<>();

        for(String r : reports){
            String n = r.split(" ")[0];
            int h = Integer.parseInt(r.split(" ")[1].split(":")[0]);
            int m = Integer.parseInt(r.split(" ")[1].split(":")[1]);

            tr.add(new TimeReport(n,h*60+m));

        }

        Collections.sort(tr);

        for(TimeReport x: tr){
            if(x.t < starth*60+startm) continue;
            else if(endh*60+endm < x.t) break;
            else {
                ans.add(x.n);
            }

        }

        return ans;
    }


    public static void main(String[] args){


        String[] reports = {"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"};
        String times = "08:33 09:45";

        ArrayList<String> ans = sol(reports, times);
        for(String e:ans){
            System.out.print(e + " ");
        }

    }
}