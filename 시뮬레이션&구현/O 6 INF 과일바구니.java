
class Main{

    public static int getIdx(int[][] f, int stand){

        int targetIdx = 0;
        for(int j=0; j<3; j++){
            if(f[stand][targetIdx] > f[stand][j]) {
                targetIdx = j;
            }
        }

        return targetIdx;
    }

    public static int sol(int[][] f){
        int ans = 0;
        int[] check = new int[f.length];

        for(int i=0; i<f.length; i++){
            if(check[i] == 1) continue;

            int targetIdx = getIdx(f, i);


            for(int j=i+1; j<f.length; j++){
                if(check[j] == 1) continue;
                int target2Idx=0;
                if(check[j] == 0){
                    target2Idx = getIdx(f, j);
                }


                if(targetIdx!=target2Idx && f[i][target2Idx] > 0 && f[j][targetIdx]>0){
                    if( f[i][target2Idx] - 1  < f[i][targetIdx]+1);
                    else if( f[j][targetIdx] - 1  < f[j][target2Idx]+1);
                    else{
                        ans += f[i][targetIdx]+1;
                        ans += f[j][target2Idx]+1;

                        check[i] = 1;
                        check[j] = 1;
                        break;
                    }

                }
            }
        }

        for(int i=0; i<check.length; i++){
            if(check[i] == 0){
                int target = Integer.MAX_VALUE;
                for(int j=0; j<3; j++){
                    target = Math.min(target, f[i][j]);
                }
                ans += target;
            }
        }


        return ans;
    }


    public static void main(String[] args){


//        int[][] f = {{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}};
//        int[][] f = {{10, 9, 11}, {15, 20, 25}};
//        int[][] f = {{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}};
        int[][] f ={{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}};

        System.out.print(sol(f));




    }
}