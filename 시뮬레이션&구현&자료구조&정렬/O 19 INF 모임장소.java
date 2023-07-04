import java.util.ArrayList;

class Main{

    public static int sol(int[][] board){
        int ans=0;

        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 1){
                    r.add(i);
                    c.add(j);
                }
            }
        }

        int rmin = Integer.MAX_VALUE;
        int cmin = Integer.MAX_VALUE;
        for(int i=0; i<board.length; i++){
            int rtmp = 0;
            int ctmp = 0;
            for(int jr=0; jr<r.size(); jr++){
                rtmp += Math.abs(i - r.get(jr));
            }
            rmin = Math.min(rmin, rtmp);


            for(int jc=0; jc<c.size(); jc++){
                ctmp += Math.abs(i - c.get(jc));
            }
            cmin = Math.min(cmin, ctmp);
        }


        return rmin + cmin;
    }


    public static void main(String[] args){

        int[][] board = {{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
//        int[][] board = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}};
//        int[][] board = {{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}};

        System.out.print(sol(board));

    }
}
