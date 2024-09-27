import java.io.*;

public class Main {
    private static final int CARD_COUNT = 5; // 각 사람이 가지는 카드 수
    private static final int CHOOSE_COUNT = 3; // 선택할 카드 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] cards = new int[N][CARD_COUNT];  // N명의 사람들이 가지는 카드 배열

        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < CARD_COUNT; j++) {
                cards[i][j] = Integer.parseInt(input[j]);
            }
        }

       
        int winner = findWinner(N, cards);
        
        
        bw.write(winner + "\n");
        bw.flush();
        bw.close();
    }

    public static int findWinner(int N, int[][] cards) {
        int winner = 0; // 승리자의 번호
        int maxLastDigit = 0; // 최대 일의 자리 값

        // 각 사람의 최댓값 계산
        for (int i = 0; i < N; i++) {
            int maxDigitForPerson = getMaxLastDigit(cards[i]);
            
            // 승리자 갱신 (동점일 경우, 번호가 큰 사람 선택)
            if (maxDigitForPerson >= maxLastDigit) {
                maxLastDigit = maxDigitForPerson;
                winner = i + 1; 
            }
        }
        return winner;
    }

    
    public static int getMaxLastDigit(int[] cardSet) {
        int maxDigit = 0;

        // 세 장의 카드를 고르는 모든 조합을 확인
        for (int i = 0; i < CARD_COUNT - 2; i++) {
            for (int j = i + 1; j < CARD_COUNT - 1; j++) {
                for (int k = j + 1; k < CARD_COUNT; k++) {
                    int sum = cardSet[i] + cardSet[j] + cardSet[k];
                    int lastDigit = sum % 10;
                    maxDigit = Math.max(maxDigit, lastDigit); // 최댓값 갱신
                }
            }
        }
        return maxDigit;
    }
}