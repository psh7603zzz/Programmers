import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;
    public static void main(String[] args) throws IOException {
        // 사이클이없다 = 트리 = 이분그래프
        // 갔던 노드를 다시 탐색하려할떄 같은집합이면 이분노드x
        // 모든노드 탐색해야함. DFS 사용
        // DFS에서 갔던노드 체크할떄 갔던노드면 집합을 비교해보도록 짜면될듯
        // 가중치 없는 인접리스트로 구현 ArrayList<Integer>[N]

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaes = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCaes; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A = new ArrayList[V+1]; // 0번인덱스 안쓰려고
            visited = new boolean[V+1];
            check = new int[V+1];
            IsEven = true;
            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<Integer>();
            }
            //엣지 데이터 저장
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                A[start].add(end);
                A[end].add(start);
            }
            // 모든 노드에서 DFS 실행 해야함 ( 그래프 끊어져있을수 있음 )
            for (int i = 1; i <= V; i++) {
                if(IsEven){
                    DFS(i);
                }
                else{
                    break;
                }
            }

            if(IsEven){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static void DFS(int start) {
        visited[start] = true;
        for (int i : A[start]) { // 인접리스트로 받아서 start에서 연결된 모든 노드 탐색
            if(!visited[i]){
                // 바로 직전에 있는 녿와 다른 집합으로 분류해주는 것 필요
                check[i] = (check[start] + 1) % 2;
                DFS(i);
            }
            else if(check[start] == check[i]){
                    IsEven = false;
            }
        }
    }
}