import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static int[][] apt = new int[15][15];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        solution();	
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(apt[k][n]).append('\n');
        }
        System.out.println(sb);
    }


    public static void solution () {
       

        for (int i = 0; i < 15; i++) {
            apt[i][1] = 1; // i층 1호
            apt[0][i] = i; // 0층 i호
        }

        for (int i = 1; i < 15; i++) { // 1층~14층
            for (int j = 2; j < 15; j++) {// 2호~14호
                apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
            }
        }
    }

}