/*
# 해석 : 상근이는 나무 M미터가 필요함. 집 근처 나무 한 줄의 벌목 허가를 받음
        목재 절단기 동작 원리

        땅으로부터의 높이 H를 지정하면 한 줄에 연속해있는 나무를 모두 절단한다.
        높이가 H 보다 큰 나무는 H 윗 부분이 절단나고, 낮은 나무는 오늘도 무사히 살아남을 것.

        Ex1 ) 20 15 10 17 의 나무가 있을 때, H가 15라면 자른뒤 15 15 10 15가 될 것이고. 5와 2인 나무를 들고 집에 간다. 총 7

        최소 총 길이가 M이 되도록 하는 H의 최댓값을 출력하라.

# 입력 :
        Line 1 : 나무의 수 N (1 ≤ N ≤ 1,000,000), 최소길이 M (1 ≤ M ≤ 2,000,000,000)

        Line 2 : N개의 나무 각각의 높이

        나무 높이의 합은 항상 M 이상임으로 나무가 다 작아서 못가져가는 엣지케이스 제외.
        각 나무의 높이 H (0 ≤ H ≤ 1,000,000,000)

# 로직 : 제시된 범위가 굉장히 큰데, 시간제한 1초에 메모리 256메가.
        완전탐색으로는 아인슈타인 할아버지가 와도 못함.
        고로, 이분탐색을 사용한다. (사실 알고리즘 분류 봄)
        일단. 내가 아는 기초적인 이분탐색으로 문제를 한번 풀어보고?
        안되면 아인슈타인선생님 하고 잠깐 접신하는 걸로.

# 이슈 : 코드를 나름 효율적으로 짰다고 생각했는데
        시간초과 발생함. 임시 결과값을 와일안에서 계속 합해서 그런거같음.
        아직은 내가 알아서 개선 가능할듯? 아마도?
 */

import java.io.*;
import java.util.*;

// Silver2_나무자르기_2805
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int minHeight, maxHeight, middleHeight;
    static int result = 0;
    static int[] forest;

    public static void main(String[] x) throws IOException {
        long beforeTime = System.currentTimeMillis();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 어머 이건 사야돼 나무 길이

        forest = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            forest[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, forest[i]);
        }
        minHeight = 0;

        // 기본적인 입력이 끝났고. 이제? 각 H 값을 이용해서 최소 M을 구하는 로직을 짜고? 그거를 이분탐색으로 사용하면 될 것 같음
        // 머릿속에서 그림이 안그려저서 문제 풀이의 로직만 찾아봄
        // 제일 큰 나무 기준으로 반갈죽시키고, 그래서 최소길이보다 넘치면 잠깐 회귀했다가 4분의1로 갈라주고.
        while (minHeight <= maxHeight) {
            middleHeight = (maxHeight + minHeight) / 2;
            long temp = 0; // 결과값 임시 계산

            // 제일 큰 나무 기준 반갈죽시 얘보다 큰 나무가 있따면? 자른값만큼 다른 나무도 잘라줌
            for (int tree : forest) {
                if (tree > middleHeight) {
                    temp += tree - middleHeight;
                    if (temp >= M) break; // 시간아끼려고 넣음
                }
            }

            if (temp >= M) { // 그래서 자른다음에 다 합친 값이 구하고자 하는 값보다 크면? 높이를 올려야 겠지?
                minHeight = middleHeight + 1; // 어디까지? 지금 중간값이 최소값이 되야 함. 그래서 다시 반으로 자른 윗부분에서만 다시 반으로 자르고
                result = middleHeight;
            } else { // 그렇지 않다면? 작다면. 높이를 내리고.
                maxHeight = middleHeight - 1; // 최대값이 중간값이 되어야함.
            }
//            else {
//                result = middleHeight; // 딱 내가 필요한 만큼만 되었다면? 그러면 지금 자른 위치인 middleHeight가 높이의 최댓값이 지ㅣ
//                break;
//            }
        }
        System.out.println(result);
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000;
//        System.out.println("소요시간 : "+secDiffTime+"초");
    }
}
