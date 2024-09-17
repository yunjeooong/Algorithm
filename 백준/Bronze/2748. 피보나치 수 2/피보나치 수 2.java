import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long sol= new Main().solution(n);
        bw.write(String.valueOf(sol));
        bw.flush();
        bw.close();
        br.close();
    }

    long solution(int n){

        long [] dp = new long[n+10];
        dp[1] = 1;
        dp[2] = 1;

        if (n == 1 || n == 2) return 1;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

