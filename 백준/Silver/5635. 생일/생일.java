import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String youngest = "", oldest = "";
        int youngestDate = 19900101, oldestDate = 20101231;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int day = Integer.parseInt(input[1]);
            int month = Integer.parseInt(input[2]);
            int year = Integer.parseInt(input[3]);
            
            // 날짜 유효성 검사
            if (year < 1990 || year > 2010 || month < 1 || month > 12 || day < 1 || day > 31) {
                continue; // 유효하지 않은 날짜는 건너뜁니다.
            }
            
            int date = year * 10000 + month * 100 + day;

            if (date > youngestDate) {  // 가장 늦은 생일이 가장 어린 사람
                youngestDate = date;
                youngest = name;
            }
            if (date < oldestDate) {  // 가장 이른 생일이 가장 나이 많은 사람
                oldestDate = date;
                oldest = name;
            }
        }

        System.out.println(youngest);
        System.out.println(oldest);
    }
}