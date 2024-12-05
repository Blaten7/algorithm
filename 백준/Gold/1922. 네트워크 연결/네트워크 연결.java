
import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class Main {
    static int[] parent;

    static int find(int i) {
        if (parent[i] == i) {
            return i;
        } else {
            parent[i] = find(parent[i]);
            return parent[i];
        }
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine().trim());
            int M = Integer.parseInt(br.readLine().trim());

            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                edges.add(new Edge(A - 1, B - 1, C));
            }

            Collections.sort(edges);

            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            int mstWeight = 0;
            for (Edge edge : edges) {
                int x = find(edge.src);
                int y = find(edge.dest);

                if (x != y) {
                    union(x, y);
                    mstWeight += edge.weight;
                }
            }

            System.out.print(mstWeight);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.print("Invalid input format.");
        } catch (Exception e) {
            System.err.print("An unexpected error occurred: " + e.getMessage());
        }
    }
}
