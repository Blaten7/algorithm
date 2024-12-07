import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X, Y;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] i = br.readLine().split(" ");
        X = Integer.parseInt(i[0]);
        Y = Integer.parseInt(i[1]);

        M = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        for (int k = 0; k <= N; k++) {
            graph[k] = new ArrayList<>();
        }
        for (int j = 0; j < M; j++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        visited = new boolean[N + 1];
        
        System.out.print(DFS(X, Y));
    }
    static int DFS(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, 0});
        
        while (!stack.isEmpty()) {
            int[] T = stack.pop();
            int node = T[0];
            int depth= T[1];
            
            if (node == y) return depth;
            
            if (!visited[node]) {
                visited[node] = true;
            }
            List<Integer> l = graph[node];
            
            for (int q = 0; q < l.size(); q++) {
                int t = l.get(q);
                if (!visited[t]) {
                    stack.push(new int[]{t, depth+1});
                }
            }
        }
        return -1;
    }
}
