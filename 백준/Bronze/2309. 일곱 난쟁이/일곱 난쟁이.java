import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 두명을 뽑자 -> sum - 두명의 난쟁이 키의 합 = 100 --> 이 두 난쟁이가 범인
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum = sum + arr[i];
        }

        Arrays.sort(arr);//정렬

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (arr[i] + arr[j]) == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            System.out.println(arr[k]);
                        }
                    }
                    // 정답을 찾으면 반복문 종료
                    return;
                }
            }
        }
    }
}