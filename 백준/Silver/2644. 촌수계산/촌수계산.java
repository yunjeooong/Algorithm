import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] relation = new ArrayList[n + 1];
        boolean[] checked = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            relation[i] = new ArrayList<>();
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            relation[p].add(c);
            relation[c].add(p);
        }
        
       
        Solution solution = new Solution();
        int result = solution.calculateKinship(relation, checked, x, y);
        System.out.println(result);
    }
}


class Solution {
    int res = -1;

    public int calculateKinship(List<Integer>[] relation, boolean[] checked, int start, int end) {
        dfs(relation, checked, start, end, 0);
        return res;
    }
    
    // DFS 
    private void dfs(List<Integer>[] relation, boolean[] checked, int current, int target, int count) {
        if (current == target) {
            res = count;
            return;
        }
        
        checked[current] = true;
        for (int next : relation[current]) {
            if (!checked[next]) {
                dfs(relation, checked, next, target, count + 1);
            }
        }
    }
}