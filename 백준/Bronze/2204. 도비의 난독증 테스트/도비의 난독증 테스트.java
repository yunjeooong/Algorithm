import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
       
            int n = Integer.parseInt(br.readLine().trim());
            
           
            if (n == 0) break;

            String result = solution(br, n);
            
         
            sb.append(result).append("\n");
        }

        
        System.out.print(sb);
    }

    public static String solution(BufferedReader br, int n) throws IOException {
        HashMap<String, String> wordMap = new HashMap<>();
        String min = null; // 
        String min_original = null; //제일 사전순 앞에 있는 --> 기존

      
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            String lower_word = word.toLowerCase(); 

            // 처음 단어 또는 현재 단어가 min보다 사전순으로 앞서는 경우
            if (min == null || lower_word.compareToIgnoreCase(min) < 0) {
                min= lower_word; // 최소 단어 갱신
                min_original = word; // 원래 단어 저장
            }

            wordMap.put(lower_word, word);
        }

        return min_original;
    }
}