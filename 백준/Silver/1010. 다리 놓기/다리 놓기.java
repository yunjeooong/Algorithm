import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            bw.write(getBridge(M, N).toString() + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    // 조합을 계산하는 함수 (BigInteger 사용)
    static BigInteger getBridge(int M, int N) {
        BigInteger result = BigInteger.ONE; // 0과 1 팩토리얼은 1이기 때문에 1부터 시작

        // mCn 계산
        for (int i = 0; i < N; i++) {
            result = result.multiply(BigInteger.valueOf(M - i));
            result = result.divide(BigInteger.valueOf(i + 1));
        }

        return result;
    }
}