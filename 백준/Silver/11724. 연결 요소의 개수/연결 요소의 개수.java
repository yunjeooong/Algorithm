import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int connected;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        solution();
        
        bw.write(String.valueOf(connected));
        bw.flush();
        bw.close();
    }

    
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        connected = 0; 
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // 모든 노드를 탐색하며 연결 요소 개수 계산
        for (int i = 1; i <= n; i++) {
            if (dfs(i)) {
                connected++;
            }
        }
    }

    // dfs 
    private static boolean dfs(int node) {
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
        return true;
    }
}