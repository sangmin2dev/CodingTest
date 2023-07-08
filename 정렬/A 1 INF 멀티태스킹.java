import java.util.Arrays;
import java.util.Collections;

class Main{


    public static int sol(int[] tasks, int k ){
        int ans = -1;

        Integer[] copied = Arrays.stream(tasks).boxed().toArray(Integer[]::new);
        Arrays.sort(copied);

        int last;
        int ncount = tasks.length;
        for(int i=0; i<tasks.length; i++){

            if(copied[i] < (int)Math.ceil((double)k/ncount)){
                int sub = copied[i];
                k -= sub*ncount;
                ncount -=1;
                for(int j=0; j<tasks.length; j++){
                    if(tasks[j] == 0) continue;
                    tasks[j] -= sub;
                    copied[j] -= sub;
                }
            }else if (ncount==0){
                return -1;
            }else{
                for(int j=0; j<tasks.length; j++){
                    if(tasks[j] == 0) continue;
                    else{
                        k-=1;
                        tasks[j] -= 1;
                        if(k==0) {

                            for(int l=0; l<tasks.length; l++) {
                                int idx = (l+j+1)  % tasks.length;

                                if(tasks[idx] == 0) continue;
                                else if (idx >= tasks.length) return 1;
                                else return idx+1;

                            }
                        }
                    }
                }
            }
        }


        return ans;
    }

    public static void main(String[] args){

        int[] tasks = {8, 9, 12, 23, 45, 16, 25, 50};
        int k = 100;


        System.out.print(sol(tasks, k));

    }
}