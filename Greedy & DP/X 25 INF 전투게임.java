// 스트링 숫자 비교시 자릿수가 달라지면 예상과 다른 결과가 나온다

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Node{
    int n;
    String t;
    int o;

    public Node(int n, String t, int o){
        this.n = n;
        this.t = t;
        this.o = o;
    }
}

class Main{

    public static int[] sol(String[] students){
        int[] ans = new int[students.length];

        HashMap<String, Integer> teammate = new HashMap<>();
        HashMap<Integer, Integer> earnby = new HashMap<>();
        ArrayList<Node> arr = new ArrayList<>();

        for(int i=0; i<students.length; i++){
            String[] s = students[i].split(" ");

            arr.add(new Node(i, s[0], Integer.parseInt(s[1])));
            teammate.put(s[0],0);
            earnby.put(Integer.parseInt(s[1]), 0);
        }

        Collections.sort(arr, (e1, e2)->{
            if(e1.o == e2.o) return e1.t.compareTo(e2.t);
            else return e1.o - e2.o;
        });

        for(int i=0; i<arr.size(); i++){
            Node now = arr.get(i);

            ans[now.n] = earnby.get(now.o) - teammate.get(now.t);
            for(int x:earnby.keySet()){
                if(now.o == x) continue;
                else earnby.put(x, earnby.get(x) + now.o);
            }
            teammate.put(now.t, teammate.get(now.t) + now.o);


        }




        return ans;
    }

    public static void main(String[] args){

//        String[] students = {"a 20", "b 12", "a 10", "c 11", "e 12"};
        String[] students = {"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"};
//        String[] students = {"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"};
//        String[] students = {"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"};

        int[] ans = sol(students);

        for(int x:ans){
            System.out.print(x + " ");
        }
    }
}