import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] chk; //방문 여부 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        m= Integer.parseInt(br.readLine());

        //인점 리스트
        for (int i = 0; i <= n; i++)
        {
            list.add(new ArrayList<>());
        }
        chk = new boolean[n + 1]; //방문체크 배열
        chk[1] = true;

        StringTokenizer st;
        for (int i = 0; i < m; i++) { // 양방향 인접리스트 구현
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(1, 0);


        int cnt = 0;
        for (int i = 2; i < chk.length; i++) {// i = 1 : 상근이라 카운트X
            if (chk[i]) cnt++;
        }
        System.out.println(cnt);
    }

    private static void dfs(int current, int depth) {
        if (depth == 2) { // 친구의 친구의 친구까지
            return;
        }
        for (int i : list.get(current)) {
            chk[i] = true;
            dfs(i, depth + 1);
        }
    }
}