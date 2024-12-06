import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> levels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        int[] tree = new int[(int) Math.pow(2, K) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < tree.length; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        levels = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            levels.add(new ArrayList<>());
        }

        dfs(tree, 0, tree.length - 1, 0);

        for (List<Integer> level : levels) {
            for (int node : level) {
                result.append(node).append(" ");
            }
            result.append("\n");
        }

        System.out.print(result);
    }

    // 중위 순회를 DFS로 구현
    static void dfs(int[] tree, int start, int end, int depth) {
        if (start > end) return;

        int mid = (start + end) / 2;
        levels.get(depth).add(tree[mid]);

        dfs(tree, start, mid - 1, depth + 1); // 왼쪽 서브트리 탐색
        dfs(tree, mid + 1, end, depth + 1);   // 오른쪽 서브트리 탐색
    }
}
