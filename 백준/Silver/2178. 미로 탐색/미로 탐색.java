import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] A;
    static int N,M;
    public static void main(String[] args) throws IOException {
        // dx, dy (상하좌우를 탐색하기 위한 define값 정의 변수)
        // A(데이터 저장 2차원 배열)
        // N(row), M(column)
        // visited(방문 기록 저장 배열)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken(); // ex) 101101101
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && x < N && y >= 0 && y < M) { // 배열을 넘어가면 안되고
                    if (A[x][y] != 0 && !visited[x][y]) { // 0이어서 갈 수 없거나 이미 방문한곳이면 안됨
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // 핵심
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }

}