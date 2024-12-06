/*
Silver1_완전이진트리_9934

# 해석 : 시간 1초 | 메모리 128MB
        어딘가를 여행하는 중인 상근이
        어딘가의 도로는 깊이가 K인 완전 이진트리 DFS겠죠?
        이 트리는 2^K -1 개의 노드로 구성됨
        각 노드에 번호가 있음.

        중위 순회 방식 사용.

# 입력 :
        Line 1 : 깊이 K (1 ≤ K ≤ 10)

        Line 2 : 탐색한 노드의 번호가 순서대로 입력됨 모든 번호는 중복 X,  [ 1, 2K ] 범위 안에만 존재

# 출력 : K개의 줄에 걸쳐서 최상단 레벨부터, 최하단 레벨까지 각 레벨의 노드 번호를 좌 우 순으로 출력

# 로직 : 
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        int[] tree = new int[(int) Math.pow(2, K) - 1];
        int len = tree.length;
        int parent = len;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        while (parent != 0) {
            int child = (parent - 1) / 2; // 부모가 자식노드 구할 때 왼쪽이 ( 2 * i ) +1 . 이 식의 역순
            
            int gap = (parent - child) * 2; // 상위노드와 하위노드의 차이값에 * 2를 하면 깊이가 동일한 노드간의 차이를 구할 수 있따고 한다
            
            for (int i = child; i < len; i += gap) {
                result.append(tree[i] + " ");
            }
            
            parent = child;
            result.append("\n");
        }
        System.out.print(result);
    }
}