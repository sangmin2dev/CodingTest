/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
//        Scanner sc = new Scanner(System.in);
//        int T;
//        T=sc.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */

//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int q = sc.nextInt();
            String[] nmq = br.readLine().split(" ");
            int n = Integer.parseInt(nmq[0]);
            int m = Integer.parseInt(nmq[1]);
            int q = Integer.parseInt(nmq[2]);


            int[] mr = new int[n]; //max per row
            int[] mc = new int[m]; //max per column
            int[][] board = new int[n][m];
            for(int i=0; i<n; i++){
                String[] b = br.readLine().split(" ");
                for(int j=0; j<m; j++){
//                    board[i][j] = sc.nextInt();
                    board[i][j] = Integer.parseInt(b[j]);

                    mr[i] = Math.max(mr[i], board[i][j]);
                    mc[j] = Math.max(mc[j], board[i][j]);
                }
            }

            int round = 0;
            ArrayList<int[]> mpairs = new ArrayList<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(mr[i] == mc[j]) {
                        round+=1;
                        mpairs.add(new int[]{i,j});
                    }
                }
            }


            int answer = 0;

            for(int a=0; a<q; a++){
//                int nr = sc.nextInt()-1;
//                int nc = sc.nextInt()-1;
//                int nx = sc.nextInt();

                String[] qr = br.readLine().split(" ");
                int nr = Integer.parseInt(qr[0]) - 1;
                int nc = Integer.parseInt(qr[1]) - 1;
                int nx = Integer.parseInt(qr[2]);

                board[nr][nc] = nx;

                if(nx < mr[nr] && nx < mc[nc]){
                    answer += round;
                }else if(nx > mr[nr] && nx < mc[nc]) {
//                    for(int[] x: mpairs){
//                        if(x[0] == nr && board[x[0]][x[1]] == mc[x[1]]) {
//                            round-=1;
//                            mpairs.remove(x);
//                            break;
//                        }
//                    }
                    for(int i=0; i<m; i++){
                        if(mr[nr] == mc[i]) {
                            round-=1;
                            break;
                        }
                    }
                    answer += round;
                    mr[nr] = nx;
                }else if(nx < mr[nr] && nx > mc[nc]) {
//                    for(int[] x: mpairs){
//                        if(x[1] == nc && board[x[0]][x[1]] == mr[x[0]]) {
//                            round-=1;
//                            mpairs.remove(x);
//                            break;
//                        }
//                    }
                    for(int i=0; i<n; i++){
                        if(mr[i] == mc[nc]) {
                            round-=1;
                            break;
                        }
                    }
                    answer += round;

                    mc[nc] = nx;
//                } else if(mr[nr] == mc[nc]){
//                    answer += round;
                }else{
                    int eqr=-1;
                    int eqc=-1;
                    for(int i=0; i<n; i++){
                        if(mr[i] == mc[nc]) {
                            round-=1;
                            eqr = i;
                            break;
                        }
                    }
                    for(int i=0; i<m; i++){
                        if(mr[nr] == mc[i]) {
                            round-=1;
                            eqc = i;
                            break;
                        }
                    }
                    if(nr == eqr && nc == eqc) round+=1;

                    mr[nr] = nx;
                    mc[nc] = nx;
                    round+=1;

                    answer+=round;

                }


            }

            System.out.println("#"+ test_case + " " + answer);
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
}


/*
1 4 3
6 5 2

2 2 10
1 3 5
2 3 20

Q1 - 1
1 4 3
6 10 2

Q2 - 2
1 4 5
6 10 2

Q3 - 1
1 4 5
6 10 20


 */