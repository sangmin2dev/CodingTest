import java.util.ArrayList;
import java.util.Collections;

class TimeReport implements Comparable<TimeReport>{
    String n;
    int h;
    int m;

    public TimeReport(String n, int h, int m){
        this.n = n;
        this.h = h;
        this.m = m;
    }

    @Override
    public int compareTo(TimeReport n){
        if(this.h == n.h && this.m == n.m){
            if(n.n == "s-") return 1;
            else if(n.n == "e-") return -1;
            else return 0;
        }
        else if(this.h == n.h) return this.m - n.m;
        else return this.h - n.h;
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
        tr.add(new TimeReport("s-", starth, startm));
        tr.add(new TimeReport("e-", endh, endm));

        for(String r : reports){
            String n = r.split(" ")[0];
            int h = Integer.parseInt(r.split(" ")[1].split(":")[0]);
            int m = Integer.parseInt(r.split(" ")[1].split(":")[1]);

            tr.add(new TimeReport(n,h,m));

//            if(starth == h && h == endh){
//                if(startm <= m && m <= endm) ans.add(n); // starth == endh
//            }
//            else if(starth == h){
//                if(startm <= m) ans.add(n); // starth == h
//            }
//            else if(endh == h){
//                if(m <= endm) ans.add(n); // endh == h
//            }
//            else{
//                if(starth < h && h < endh) ans.add(n);
//            }
        }


        Collections.sort(tr);

        for(TimeReport x: tr){

            System.out.println(x.n + " " + x.h + " " + x.m);
        }

        for(int i=0; i<tr.size(); i++){
            if(tr.get(i).n != "s-") continue;
            else{
                for(int j=i+1; j<tr.size(); j++)
                    if(tr.get(j).n == "e-") break;
                    else ans.add(tr.get(j).n);
            }
        }

        return ans;
    }


    public static void main(String[] args){


        String[] reports = {"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"};
        String times = "14:20 15:20";

        ArrayList<String> ans = sol(reports, times);
        for(String e:ans){
            System.out.print(e + " ");
        }

    }
}