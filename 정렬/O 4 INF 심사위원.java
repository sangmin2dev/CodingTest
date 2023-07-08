//lt rt 안쓰고 연속구간 통으로 슬라이딩 했어도 ㅇㅇ

import java.util.Arrays;

class Main{

    public static long sol(int[] score, int k){
        long ans = 0l;

        Arrays.sort(score);

        int lt = 0;
        int rt = k-1;
        while(lt<rt){

            if(score[rt] - score[lt] > 10){
                lt++;
            }else if(rt - lt < k-1){
                rt++;
            }else{
                for(int i=lt; i<=rt; i++){
                    ans+=score[i];
                }
                return ans/k;
            }
        }

        return ans;
    }

    public static void main(String[] args){

        int[] score = {88, 99, 91, 89, 90, 72, 75, 94, 95, 100};
        int k=5;

        System.out.print(sol(score, k));

    }
}