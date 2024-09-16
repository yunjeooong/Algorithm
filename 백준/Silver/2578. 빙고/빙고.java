import java.io.*;
import java.util.*;

public class Main {
    int[][] board = new int[5][5];
    boolean[][] checkBoard = new boolean[5][5];
    Map<Integer, int[]> numPositions = new HashMap<>();
    List<Integer> calls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판 입력 
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                numPositions.put(num, new int[]{i, j});
            }
        }

        // 사회자가 부르는 숫자 입력 
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                calls.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(solveBingo());
    }

    int solveBingo() {
        for (int i = 0; i < calls.size(); i++) {
            int num = calls.get(i);
            int[] pos = numPositions.get(num);
            checkBoard[pos[0]][pos[1]] = true;

            if (checkBingo()) {
                return i + 1;
            }
        }
        return 25;
    }

    boolean checkBingo() {
        int bingoCount = 0;

        // 가로, 세로 라인 확인
        for (int i = 0; i < 5; i++) {
            if (checkLine(i, 0, 0, 1)) bingoCount++;
            if (checkLine(0, i, 1, 0)) bingoCount++;
        }

        // 대각선 확인
        if (checkLine(0, 0, 1, 1)) bingoCount++;
        if (checkLine(0, 4, 1, -1)) bingoCount++;

        return bingoCount >= 3;
    }

    boolean checkLine(int startX, int startY, int dx, int dy) {
        for (int i = 0; i < 5; i++) {
            if (!checkBoard[startX + i * dx][startY + i * dy]) {
                return false;
            }
        }
        return true;
    }
}