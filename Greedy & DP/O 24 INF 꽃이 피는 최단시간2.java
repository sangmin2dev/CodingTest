import java.util.ArrayList;
import java.util.Collections;

class Main{


    public static int sol(int[] plantTime, int[] growTime){
        int ans = 0;

        ArrayList<int[]> node = new ArrayList<>();
        for(int i=0; i<plantTime.length; i++){
            node.add(new int[]{plantTime[i], growTime[i]});
        }


        Collections.sort(node, (e1, e2) ->{
            return e2[1] - e1[1];
        });

        int pe = 0;
        int ge = 0;
        for(int i=0; i<node.size(); i++){

            pe += node.get(i)[0];
            ans = Math.max(pe+node.get(i)[1], ans);

        }

        return ans;
    }

    public static void main(String[] args){

        int[] plantTime = {1, 2, 3, 4, 5, 6, 7};
        int[] growTime = {7, 5, 4, 3, 2, 1, 6};

        System.out.print(sol(plantTime, growTime));

    }
}

/*
심는동안 자라야한다

p-g가 큰거 -> 작은거
편차가 같다면? -> g가 큰거

0->1 / 1 -> 3
1->3 / 3->5
3->6 / 6->9

1->4 / 4->7
4->6 / 6->8

 */
