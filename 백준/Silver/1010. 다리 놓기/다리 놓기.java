import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 
        StringBuilder sb = new StringBuilder();

       
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]); 
            int M = Integer.parseInt(input[1]); 
            sb.append(combi(M, N)).append('\n'); 
        }

        System.out.println(sb);
    }

    // 조합
    static int combi(int M, int N) {
        if (N == 0 || M == N) {
            return 1; 
        }

        int[][] dp = new int[31][31];

        // 초기화
        for (int i = 0; i <= M; i++) {
            dp[i][0] = 1; // nC0 = 1
            dp[i][i] = 1; // nCn = 1
        }

        // 채우기
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N && j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[M][N];
    }
}