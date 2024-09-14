
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int [] arr= new int [5];

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<5;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 버블 정렬
        boolean sorted;
        do {
            sorted = false;
            for (int i = 1; i < 5; i++) {
                if (arr[i - 1] > arr[i]) {
                    int tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                    sorted = true;
                    for (int j = 0; j < 5; j++) sb.append(arr[j]).append(' ');
                    sb.append('\n');
                }
            }
        } while (sorted);
        System.out.print(sb);

    }
    }
