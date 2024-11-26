import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1m² 당 참외 개수 입력
        int K = Integer.parseInt(br.readLine());

        // 변 방향 및 길이 저장
        int[] direction = new int[6];
        int[] length = new int[6];

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            direction[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 긴 가로와 세로 길이 찾기
        int maxWidth = 0, maxHeight = 0;
        int maxWidthIdx = -1, maxHeightIdx = -1;

        for (int i = 0; i < 6; i++) {
            if ((direction[i] == 1 || direction[i] == 2) && length[i] > maxWidth) {
                maxWidth = length[i];
                maxWidthIdx = i;
            }
            if ((direction[i] == 3 || direction[i] == 4) && length[i] > maxHeight) {
                maxHeight = length[i];
                maxHeightIdx = i;
            }
        }

        // 작은 사각형의 가로, 세로 계산
        int smallWidth = Math.abs(length[(maxHeightIdx + 5) % 6] - length[(maxHeightIdx + 1) % 6]);
        int smallHeight = Math.abs(length[(maxWidthIdx + 5) % 6] - length[(maxWidthIdx + 1) % 6]);

        // 면적 계산
        int bigArea = maxWidth * maxHeight;
        int smallArea = smallWidth * smallHeight;
        int area = bigArea - smallArea;

        // 참외 개수 계산
        int result = area * K;

        // 결과 출력
        System.out.println(result);
    }
}
